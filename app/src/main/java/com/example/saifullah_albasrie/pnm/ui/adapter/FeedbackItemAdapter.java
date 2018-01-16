package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.FeedbackItemModel;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class FeedbackItemAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private OnItemClickListener onItemClickListener;

    private List<FeedbackItemModel> modelList;
    private int selectedPosition = -1;

    public FeedbackItemAdapter(List<FeedbackItemModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return getItemView(inflater, parent);
    }

    private RecyclerView.ViewHolder getItemView(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_feedback, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        holder.setOnClickListener(onItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            FeedbackItemModel model = modelList.get(position);
            viewHolder.tvTitle.setText(model.getNamaPanggilan());
            //viewHolder.tvName.setText(model.getNamaPanggilan());
            viewHolder.tvDate.setText("" + DateUtil.convertDateToNormal(model.getModifiedDate()));
            if (model.isRead()) {
                viewHolder.ivIcon.setVisibility(View.GONE);
            } else {
                viewHolder.ivIcon.setVisibility(View.VISIBLE);
            }

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

        @BindView(R.id.iv_icon)
        public ImageView ivIcon;

        @BindView(R.id.tv_title)
        public TextView tvTitle;
        //@BindView(R.id.tv_name)
        //public TextView tvName;
        @BindView(R.id.tv_date)
        public TextView tvDate;


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
