package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.PnmDebiturModel;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class CollectionItemAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private OnItemClickListener onItemClickListener;

    private List<PnmDebiturModel> listProspek;
    private int selectedPosition = -1;

    public CollectionItemAdapter(List<PnmDebiturModel> listProspek) {
        this.listProspek = listProspek;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return getItemView(inflater, parent);
    }

    private RecyclerView.ViewHolder getItemView(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_collection, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        holder.setOnClickListener(onItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            PnmDebiturModel model = listProspek.get(position);
            viewHolder.tvName.setText((model.getNamaDebitur() != null ? model.getNamaDebitur().trim() : ""));
            viewHolder.tvTglJatuhTempo.setText("JT : " + (model.getTglJatuhTempo() != null ? model.getTglJatuhTempo().trim() : ""));
            viewHolder.tvIdentity.setText("OS : Rp. " + WidgetUtil.convertToLocalCurrency(model.getSaldoNominatif()));
            viewHolder.tvAging.setText("Aging : " + (model.getJmlTunggakanHari() != null ? model.getJmlTunggakanHari().trim() : "") + " hari");
        }

        /*if (position == selectedPosition) {
            holder.itemView.setSelected(true);
        } else {
            holder.itemView.setSelected(false);
        }*/
    }

    @Override
    public int getItemCount() {
        return listProspek != null ? listProspek.size() : 0;
    }

    public int getSelectedIndex() {
        return selectedPosition;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tv_name)
        public TextView tvName;
        @BindView(R.id.tv_identity_number)
        public TextView tvIdentity;
        @BindView(R.id.tv_tanggal_jatuh_tempo)
        public TextView tvTglJatuhTempo;
        @BindView(R.id.tv_status)
        public TextView tvAging;

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
            selectedPosition = getAdapterPosition();
            if (listener != null) {
                listener.onItemClick(itemView, v, selectedPosition, getItemId());
            }
        }

    }
}
