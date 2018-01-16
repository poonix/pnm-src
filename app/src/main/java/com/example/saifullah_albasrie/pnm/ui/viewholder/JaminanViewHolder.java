package com.example.saifullah_albasrie.pnm.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aldhiramdan on 4/24/17.
 */

public class JaminanViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnItemClickListener mlistener;

    @BindView(R.id.ll_content)
    public View mContainer;
    @BindView(R.id.btnSubmit)
    public TextView tvSubJaminan;

    public JaminanViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setClickable(true);
        itemView.setOnClickListener(this);
    }

    public void setOnClickListener(OnItemClickListener clickListener) {
        this.mlistener = clickListener;
    }

    @Override
    public void onClick(View v) {
        if (mlistener != null) {
            mlistener.onItemClick(itemView, v, getAdapterPosition(), getItemId());
        }
    }
}
