package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.StatusType;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by saifullah_albasrie on 3/2/17.
 */

public class ProspekItemAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private OnItemClickListener onItemClickListener;

    private List<ProspekListItemModel> listProspek;
    private int selectedPosition = -1;
    private boolean showProgress = true;

    public ProspekItemAdapter(List<ProspekListItemModel> listProspek) {
        this.listProspek = listProspek;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return getItemView(inflater, parent);
    }

    private RecyclerView.ViewHolder getItemView(LayoutInflater inflater, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_prospek, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        holder.setOnClickListener(onItemClickListener);
        return holder;
    }

    public void setShowProgress(boolean showProgress) {
        this.showProgress = showProgress;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;

            ProspekListItemModel model = listProspek.get(position);
            //ProspekBiodataModel biodataModel = model.getBiodataModel();
            //viewHolder.tvName.setText(biodataModel != null ? biodataModel.getFullName() : "");
            //viewHolder.tvIdentity.setText(biodataModel != null ? biodataModel.getIdentityNumber() : "");
            viewHolder.tvName.setText(model.getNamaPanggilan());
            viewHolder.tvIdentity.setText(model.getJenisIdentitas() + ": " + model.getNoIdentitas());
            viewHolder.tvVisit.setText("Visit : " + model.getVisit());
            viewHolder.tvStatus.setText(model.getStatusName());
            viewHolder.tvIdDebitur.setText(model.getIdDebitur());

            if(AppPreference.getInstance().getUserType() == UserType.MANAGER_UNIT) {
                viewHolder.ivIcon.setVisibility(View.GONE);
            } else {
                if(showProgress) {
                    viewHolder.ivIcon.setVisibility(View.VISIBLE);
                } else {
                    viewHolder.ivIcon.setVisibility(View.GONE);
                }
            }

            switch (model.getProgress()) {
                case 5:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_5);
                    break;
                case 10:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_10);
                    break;
                case 15:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_15);
                    break;
                case 20:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_20);
                    break;
                case 25:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_25);
                    break;
                case 30:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_30);
                    break;
                case 35:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_35);
                    break;
                case 40:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_40);
                    break;
                case 45:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_45);
                    break;
                case 50:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_50);
                    break;
                case 55:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_55);
                    break;
                case 60:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_60);
                    break;
                case 65:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_65);
                    break;
                case 70:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_70);
                    break;
                case 75:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_75);
                    break;
                case 80:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_80);
                    break;
                case 85:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_85);
                    break;
                case 90:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_90);
                    break;
                case 95:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_95);
                    break;
                case 100:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_100);
                    break;
                default:
                    viewHolder.ivIcon.setBackgroundResource(R.drawable.ic_progress_5);
                    break;
            }

            //@see StatusType
            switch (model.getStatusDebitur()) {
                case StatusType.BARU:
                    viewHolder.tvStatus.setText("");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.black_text));
                    break;
               case StatusType.PROSPEK_MENUNGGU:
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.yellow_text));
                    break;
                case StatusType.PROSPEK_DITOLAK:
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.red_text));
                    break;
                case StatusType.SURVEY:
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.green_text));
                    break;
                case StatusType.SURVEY_MENUNGGU:
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.yellow_text));
                    break;
                case StatusType.SURVEY_DITOLAK:
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.red_text));
                    break;
                case StatusType.SURVEY_DITERIMA:
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.green_text));
                    break;
                default:
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.black_text));
                    break;

            }
            /*
            switch (model.getStatusDebitur()) {
                case StatusType.BARU:
                    viewHolder.tvStatus.setText("");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.black_text));
                    break;
                case StatusType.PROSPEK:
                    //viewHolder.tvStatus.setText("Menunggu Persetujuan");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.black_text));
                    break;
                case StatusType.PROSPEK_MENUNGGU:
                    //viewHolder.tvStatus.setText("Telah Disetujui");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.green_text));
                    break;
                case StatusType.PROSPEK_REVISI:
                    //viewHolder.tvStatus.setText("Tidak Disetujui");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.red_text));
                    break;
                case StatusType.PROSPEK_DITOLAK:
                    //viewHolder.tvStatus.setText("Sudah dilengkapi");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.green_text));
                    break;
                case StatusType.SURVEY:
                    //viewHolder.tvStatus.setText("Belum dilengkapi");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.red_text));
                    break;
                case StatusType.SURVEY_MENUNGGU:
                    //viewHolder.tvStatus.setText("Direkomendasikan");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.green_text));
                    break;
                case StatusType.SURVEY_REVISI:
                    viewHolder.tvStatus.setText("Belum direkomendasi");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.red_text));
                    break;
                case StatusType.SURVEY_DITOLAK:
                    viewHolder.tvStatus.setText("Menunggu pengajuan");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.yellow_text));
                    break;
                default:
                    viewHolder.tvStatus.setText("");
                    viewHolder.tvStatus.setTextColor(mContext.getResources().getColor(R.color.black_text));
                    break;

            }*/
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

        @BindView(R.id.iv_icon)
        public ImageView ivIcon;

        @BindView(R.id.tv_name)
        public TextView tvName;
        @BindView(R.id.tv_identity_number)
        public TextView tvIdentity;
        @BindView(R.id.tv_visit)
        public TextView tvVisit;
        @BindView(R.id.tv_status)
        public TextView tvStatus;
        @BindView(R.id.tv_id_debitur)
        public TextView tvIdDebitur;

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
