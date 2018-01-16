package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.master.JenisHartaModel;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by saifullahalbasrie on 4/21/17.
 */

public class HartaAdapter extends RecyclerView.Adapter<HartaAdapter.HartaViewHolder> {

    private List<JenisHartaModel> list;
    //private OnItemClickListener onClickListener;
    private boolean isEnable;
    //private boolean [] checkedItems;

    public HartaAdapter(List<JenisHartaModel> list) {
        this.list = list;
        /*if (list != null) {
            checkedItems = new boolean[list.size()];
        }*/
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
        notifyDataSetChanged();
    }

    public JenisHartaModel getSelectedItem(int position) {
        return list.get(position);
    }

    public List<JenisHartaModel> getCheckedItems() {
        List<JenisHartaModel> checkedList = new ArrayList<>();
        for (JenisHartaModel model : list) {
            if (model.isChecked()) {
                checkedList.add(model);
            }
        }
        return checkedList;
    }

    public List getCheckedItemsId() {
        List checkedList = new ArrayList<>();
        for (JenisHartaModel model : list) {
            if (model.isChecked()) {
                checkedList.add(model.getId());
            }
        }

        return checkedList;
    }

    public void setCheckedItems(String[] checkedItems) {
        for (int i = 0; i < list.size(); i++) {
            boolean isChecked = false;
            for (String id : checkedItems) {
                if (String.valueOf(list.get(i).getId()).equals(id)) {
                    isChecked = true;
                    break;
                }
            }

            list.get(i).setChecked(isChecked);
        }
        notifyDataSetChanged();
    }

    @Override
    public HartaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_harta, parent, false);
        HartaViewHolder viewHolder = new HartaViewHolder(v);
        //viewHolder.setOnClickListener(onItemClickListener());
        viewHolder.cbHarta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //list.get(position).setChecked(isChecked);//bug recycle position
                int pos = (int) buttonView.getTag();
                list.get(pos).setChecked(isChecked);
                //checkedItems[pos] = isChecked;

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HartaViewHolder holder, int position) {
        JenisHartaModel model = list.get(position);
        holder.cbHarta.setText(model.getNamaHartaBenda());
        holder.cbHarta.setTag(position);
        holder.cbHarta.setEnabled(isEnable);
        holder.cbHarta.setChecked(model.isChecked());
        //holder.cbHarta.setChecked(checkedItems[position]);

        /*holder.cbHarta.setOnCheckedChangeListener(null);
        holder.cbHarta.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //list.get(position).setChecked(isChecked);//bug recycle position
                int pos = (int) buttonView.getTag();
                //list.get(pos).setChecked(isChecked);
                checkedItems[pos] = isChecked;

            }
        });*/
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    /*
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onClickListener = listener;
    }

    public OnItemClickListener onItemClickListener() {
        return new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, View view, int position, long id) {
                if (onClickListener != null) {
                    onClickListener.onItemClick(itemView, view, position, id);
                }
            }

        };
    }*/

    public class HartaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnItemClickListener mListener;

        @BindView(R.id.ll_content)
        public View mContainer;
        @BindView(R.id.cb_harta)
        CheckBox cbHarta;


        public HartaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
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
}
