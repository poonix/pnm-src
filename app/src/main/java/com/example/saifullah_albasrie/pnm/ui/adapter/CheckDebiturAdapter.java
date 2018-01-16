package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.CheckDebiturModel;
import com.example.saifullah_albasrie.pnm.model.FeedbackItemModel;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by saifullah_albasrie on 4/18/17.
 */

public class CheckDebiturAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private OnItemClickListener onItemClickListener;

    private List<CheckDebiturModel> modelList;
    private int selectedPosition = -1;

    public CheckDebiturAdapter(List<CheckDebiturModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return getItemView(inflater, parent);
    }

    private RecyclerView.ViewHolder getItemView(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_check_debitur, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        holder.setOnClickListener(onItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            CheckDebiturModel model = modelList.get(position);
            viewHolder.tvNama.setText(model.getNamaNasabah() != null ? model.getNamaNasabah().trim() : "");
            viewHolder.tvID.setText("ID : " + (model.getNoId() != null ? model.getNoId().trim() : ""));
            viewHolder.tvTanggalLahir.setText(model.getTanggalLahir() != null ? model.getTanggalLahir().trim() : "");
            viewHolder.tvIbuKandung.setText(model.getNamaIbuKandung() != null ? model.getNamaIbuKandung().trim() : "");
            viewHolder.tvTelp.setText(model.getTelpon() != null ? model.getTelpon().trim() : "");
            viewHolder.tvUnit.setText(model.getNamaUnit() != null ? model.getNamaUnit().trim() : "");
            viewHolder.tvCabang.setText("Cabang " + (model.getNamaCabang() != null ? model.getNamaCabang().trim() : ""));
        }

        if (position == selectedPosition) {
            holder.itemView.setSelected(true);
        } else {
            holder.itemView.setSelected(false);
        }
    }

    @Override
    public int getItemCount() {
        return modelList != null ? modelList.size() : 0;
    }

    public int getSelectedIndex() {
        return selectedPosition;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_nama)
        public TextView tvNama;
        @BindView(R.id.tv_id)
        public TextView tvID;
        @BindView(R.id.tv_tanggal_lahir)
        public TextView tvTanggalLahir;
        @BindView(R.id.tv_ibu_kandung)
        public TextView tvIbuKandung;
        @BindView(R.id.tv_telp)
        public TextView tvTelp;
        @BindView(R.id.tv_unit)
        public TextView tvUnit;
        @BindView(R.id.tv_cabang)
        public TextView tvCabang;

        private OnItemClickListener listener;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        public void setOnClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            if (selectedPosition >= 0 && selectedPosition < getItemCount()) {
                notifyItemChanged(selectedPosition);
            }

            selectedPosition = getAdapterPosition();
            if (listener != null) {
                listener.onItemClick(itemView, v, selectedPosition, getItemId());

            }

            notifyItemChanged(selectedPosition);
        }

    }
}
