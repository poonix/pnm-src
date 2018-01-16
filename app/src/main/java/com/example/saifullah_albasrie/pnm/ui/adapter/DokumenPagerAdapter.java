package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.SurveyDokumenModel;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.GlideUtil;

import java.io.File;
import java.util.List;

/**
 * Created by saifullahalbasrie on 4/21/17.
 */

public class DokumenPagerAdapter extends PagerAdapter {

    private OnDocumentEventListener onEventListener;
    private List<SurveyDokumenModel> list;

    private LayoutInflater inflater;
    private Context context;

    private boolean isEditMode = true;

    public DokumenPagerAdapter(Context context, List<SurveyDokumenModel> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list != null? list.size() : 0;
    }

    @Override
    public Object instantiateItem(ViewGroup view, final int position) {
        SurveyDokumenModel model = list.get(position);
        final View viewHolder = inflater.inflate(R.layout.item_gallery, view, false);

        final ImageView ivImage = (ImageView) viewHolder.findViewById(R.id.iv_image);
        final EditText tvKeterangan = (EditText) viewHolder.findViewById(R.id.tv_title);
        final ImageView ivEdit = (ImageView) viewHolder.findViewById(R.id.iv_edit);
        final ImageView ivDelete = (ImageView) viewHolder.findViewById(R.id.iv_delete);

        if (isEditMode) {
            ivEdit.setVisibility(View.VISIBLE);
            ivDelete.setVisibility(View.VISIBLE);
        } else {
            ivEdit.setVisibility(View.INVISIBLE);
            ivDelete.setVisibility(View.INVISIBLE);
        }
        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKeterangan.setEnabled(false);
                if (onEventListener != null) {
                    onEventListener.onItemClick(viewHolder, position, list.get(position));
                }
            }
        });


        if (!TextUtils.isEmpty(model.getKeterangan())) {
            tvKeterangan.setText(model.getKeterangan());
        }

        if (model.getBitmap() != null) {
            ivImage.setImageBitmap(model.getBitmap());
        } else {
            File fileImage = new File(CommonUtil.getOrCreateFotoFolder(), model.getNamaFile());
            if (fileImage.exists()) {
                GlideUtil.loadImage(context, ivImage, fileImage);
            } else {
                GlideUtil.loadImage(context, ivImage, model.getUrlFile());
            }
        }

        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKeterangan.setEnabled(false);
                tvKeterangan.setFocusableInTouchMode(false);
            }
        });

        ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKeterangan.setEnabled(true);
                tvKeterangan.setFocusableInTouchMode(true);
                tvKeterangan.requestFocus();
                tvKeterangan.setSelection(tvKeterangan.getText().length());
                CommonUtil.showKeyboard(tvKeterangan);
                if (onEventListener != null) {
                    onEventListener.onEditClick(viewHolder, position, list.get(position));
                }
            }
        });

        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvKeterangan.setEnabled(false);
                tvKeterangan.setFocusableInTouchMode(false);
                if (onEventListener != null) {
                    onEventListener.onDeleteClick(viewHolder, position, list.get(position));
                }

            }
        });

        tvKeterangan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                list.get(position).setKeterangan(s.toString());
            }
        });

        view.addView(viewHolder);

        return viewHolder;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public int getItemPosition(Object object){
        return PagerAdapter.POSITION_NONE;
    }

    public boolean isEditMode() {
        return isEditMode;
    }

    public void setEditMode(boolean editMode) {
        isEditMode = editMode;
    }

    public void setOnEventClickListener(OnDocumentEventListener listener) {
        this.onEventListener = listener;
    }

    public interface OnDocumentEventListener {
        void onItemClick(View v, int position, SurveyDokumenModel model);
        void onDeleteClick(View v, int position, SurveyDokumenModel model);
        void onEditClick(View v, int position, SurveyDokumenModel model);
    }
}
