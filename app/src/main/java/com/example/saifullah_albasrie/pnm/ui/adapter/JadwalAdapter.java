package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aldhiramdan on 3/21/17.
 */

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ItemViewHolder> {

    private Context mContext;
    private OnItemClickListener onClickListener;

    private List<ProspekJadwalModel> list;

    public JadwalAdapter(List<ProspekJadwalModel> item) {
        this.list = item;
    }

    public ProspekJadwalModel getSelectedItem(int position) {
        return list.get(position);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jadwal, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        ProspekJadwalModel model = list.get(position);

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ll_content)
        View mContainer;
        @BindView(R.id.btnSubmit)
        TextView tvSubItemSurvey;
        @BindView(R.id.iv_statusSurvey)
        ImageView ivStatusSurvey;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
