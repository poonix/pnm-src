package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.master.ReputasiPemohonModel;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReputasiPemohonAdapter extends RecyclerView.Adapter<ReputasiPemohonAdapter.ReputasiPemohonVIewHolder> {

    private List<ReputasiPemohonModel> list;
    private boolean isEnable;

    public ReputasiPemohonAdapter(List<ReputasiPemohonModel> list) {
        this.list = list;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
        notifyDataSetChanged();
    }

    public ReputasiPemohonModel getSelectedItem(int position) {
        return list.get(position);
    }

    public List getCheckedItemsId() {
        List checkedList = new ArrayList<>();
        for (ReputasiPemohonModel model : list) {
            if (model.getChecked()) {
                checkedList.add(model.getText());
            }
        }

        return checkedList;
    }

    public void setCheckedItems(String[] checkedItems) {
        for (int i = 0; i < list.size(); i++) {
            boolean isChecked = false;
            for (String id : checkedItems) {
                if (String.valueOf(list.get(i).getText()).equals(id)) {
                    isChecked = true;
                    break;
                }
            }

            list.get(i).setChecked(isChecked);
        }
        notifyDataSetChanged();
    }

    @Override
    public ReputasiPemohonVIewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_reputasi_pemohon, parent, false);
        ReputasiPemohonVIewHolder vIewHolder = new ReputasiPemohonVIewHolder(v);
        vIewHolder.cbReputasi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int pos = (int) buttonView.getTag();
                list.get(pos).setChecked(isChecked);
            }
        });

        return vIewHolder;
    }

    @Override
    public void onBindViewHolder(ReputasiPemohonVIewHolder holder, int position) {
        ReputasiPemohonModel model = list.get(position);
        holder.cbReputasi.setText(model.getText());
        holder.cbReputasi.setTag(position);
        holder.cbReputasi.setEnabled(isEnable);
        holder.cbReputasi.setChecked(model.getChecked());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public class ReputasiPemohonVIewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnItemClickListener mListener;

        @BindView(R.id.ll_content)
        public RelativeLayout rlContent;
        @BindView(R.id.cb_reputasi)
        public CheckBox cbReputasi;

        public ReputasiPemohonVIewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(itemView, v, getAdapterPosition(), getItemId());
            }
        }

        public void setOnCLickListener(OnItemClickListener listener) {
            this.mListener = listener;
        }
    }

}
