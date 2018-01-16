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

public class ButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnItemClickListener mListener;

    @BindView(R.id.ll_content)
    public View mContainer;
    @BindView(R.id.btn_menu)
    public TextView btnMenu;

    public ButtonViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setClickable(true);
        itemView.setOnClickListener(this);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonViewHolder.this.onClick(v);
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
