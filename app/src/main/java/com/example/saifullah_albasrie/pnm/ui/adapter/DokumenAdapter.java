package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.SurveyDokumenModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by saifullahalbasrie on 4/21/17.
 */

public class DokumenAdapter extends RecyclerView.Adapter<DokumenAdapter.DokumenViewHolder> {

    private List<SurveyDokumenModel> list;
    private OnDokumenListener onClickListener;

    public DokumenAdapter(List<SurveyDokumenModel> list) {
        this.list = list;
    }

    public SurveyDokumenModel getSelectedItem(int position) {
        return list.get(position);
    }

    @Override
    public DokumenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_gallery, parent, false);
        DokumenViewHolder viewHolder = new DokumenViewHolder(v);
        viewHolder.setOnClickListener(onItemClickListener());
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DokumenViewHolder holder, int position) {
        SurveyDokumenModel model = list.get(position);
        holder.tvKeterangan.setText(model.getKeterangan());
        holder.ivImage.setImageBitmap(model.getBitmap());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public void setOnItemClickListener(OnDokumenListener listener) {
        this.onClickListener = listener;
    }

    public OnDokumenListener onItemClickListener() {
        return new OnDokumenListener() {
            @Override
            public void onItemClick(View itemView, View view, int position, long id) {
                if (onClickListener != null) {
                    onClickListener.onItemClick(itemView, view, position, id);
                }
            }

            @Override
            public void onDeleteClick(int position) {
                if (onClickListener != null) {
                    onClickListener.onDeleteClick(position);
                }
            }

            @Override
            public void onEditClick(int position) {
                if (onClickListener != null) {
                    onClickListener.onEditClick(position);
                }
            }

        };
    }

    public interface OnDokumenListener {
        void onItemClick(View itemView, View view, int position, long id);
        void onDeleteClick(int position);
        void onEditClick(int position);
    }

    public class DokumenViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private DokumenAdapter.OnDokumenListener mListener;

        @BindView(R.id.ll_content)
        public View mContainer;
        @BindView(R.id.iv_image)
        public ImageView ivImage;
        @BindView(R.id.tv_keterangan)
        public TextView tvKeterangan;
        @BindView(R.id.iv_delete)
        public ImageView ivDelete;
        @BindView(R.id.iv_edit)
        public ImageView ivEdit;


        public DokumenViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            ivEdit.setOnClickListener(this);
        }

        public void setOnClickListener(DokumenAdapter.OnDokumenListener listener) {
            this.mListener = listener;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.iv_edit) {
                tvKeterangan.setEnabled(true);
                tvKeterangan.requestFocus();
                if (mListener != null) {
                    mListener.onEditClick(getAdapterPosition());
                }
            } else if (v.getId() == R.id.iv_delete) {
                tvKeterangan.setEnabled(false);
                if (mListener != null) {
                    mListener.onDeleteClick(getAdapterPosition());
                }
            } else {
                tvKeterangan.setEnabled(false);
                if (mListener != null) {
                    mListener.onItemClick(itemView, v, getAdapterPosition(), getItemId());
                }
            }
        }
    }
}
