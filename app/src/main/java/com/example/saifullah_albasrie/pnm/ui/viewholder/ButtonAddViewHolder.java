package com.example.saifullah_albasrie.pnm.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by saifullahalbasrie on 4/5/17.
 */

public class ButtonAddViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnItemClickListener mListener;

    @BindView(R.id.ll_btn_tambah)
    public View mContainer;
    @BindView(R.id.tv_label)
    public TextView btnLabel;

    public ButtonAddViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setClickable(true);
        itemView.setOnClickListener(this);
        btnLabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonAddViewHolder.this.onClick(v);
            }
        });
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            mListener.onItemClick(itemView, v, getAdapterPosition(), getItemId());
        }
    }
}
