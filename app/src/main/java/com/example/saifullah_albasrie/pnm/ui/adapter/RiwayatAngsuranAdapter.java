package com.example.saifullah_albasrie.pnm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.model.RiwayatAngsuran;
import com.example.saifullah_albasrie.pnm.ui.listener.OnItemClickListener;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RiwayatAngsuranAdapter extends RecyclerView.Adapter<RiwayatAngsuranAdapter.ItemViewHolder> {

    private Context mContext;
    private OnItemClickListener onItemClickListener;

    private List<RiwayatAngsuran> list;

    public RiwayatAngsuranAdapter(List<RiwayatAngsuran> item) {
        this.list = item;
    }

    public RiwayatAngsuran getSelectedItem(int position) {
        return list.get(position);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_riwayat_angsuran, parent, false);
        ItemViewHolder viewHolder = new ItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        RiwayatAngsuran model = list.get(position);
        if (model != null) {
            /*
            String sTglJT = "";
            if (model.getTglJatuhTempo() != null && !TextUtils.isEmpty(model.getTglJatuhTempo().getDate())) {
                sTglJT = DateUtil.convertDateToNormal(model.getTglJatuhTempo().getDate());
            }
            String sTglTrans = "";
            if (model.getTglRealisasi() != null && !TextUtils.isEmpty(model.getTglRealisasi().getDate())) {
                sTglTrans = DateUtil.convertDateToNormal(model.getTglRealisasi().getDate());
            }

            holder.tvNoAngsuran.setText("Angsuran Ke " + String.valueOf(model.getPosisiCicilanKe()));
            holder.tvTglJatuhTempo.setText(sTglJT);
            holder.tvTglTransaksi.setText(sTglTrans);

            double d1 = WidgetUtil.getNumberValueFromModel(model.getPokokSaldoAkhir());
            double d2 = WidgetUtil.getNumberValueFromModel(model.getBungaSaldoAkhir());
            holder.tvTotalDibayar.setText(WidgetUtil.convertToLocalCurrency(d1 + d2));
            holder.tvPokokDibayar.setText(WidgetUtil.convertToLocalCurrency(model.getPokokSaldoAkhir()));
            holder.tvBungaDibayar.setText(WidgetUtil.convertToLocalCurrency(model.getBungaSaldoAkhir()));
            //holder.tvDendaDibayar.setText(WidgetUtil.convertToLocalCurrency(model.getDendaDibayar()));

            holder.tvTotalAngsuran.setText(WidgetUtil.convertToLocalCurrency(model.getAngsuranTotal()));
            //holder.tvAngsuranPokok.setText(WidgetUtil.convertToLocalCurrency(model.getAngsuranPokok()));
            //holder.tvAngsuranBunga.setText(WidgetUtil.convertToLocalCurrency(model.getAngsuranBunga()));
            //holder.tvDendaAngsuran.setText(WidgetUtil.convertToLocalCurrency(model.getAngsuranBunga()));
            */

            String sTglJT = "";
            if (model.getTglJatuhTempo() != null && !TextUtils.isEmpty(model.getTglJatuhTempo().getDate())) {
                sTglJT = DateUtil.convertDateToNormal(model.getTglJatuhTempo().getDate());
            }

            holder.tvNoRekening.setText(model.getNoRekening());
            holder.tvOutstanding.setText(WidgetUtil.convertToLocalCurrency(model.getOutstanding()));
            holder.tvJmlPinjaman.setText(WidgetUtil.convertToLocalCurrency(model.getJmlPinjaman()));
            holder.tvJmlAngsuran.setText(String.valueOf(model.getJmlAngsuran()));
            holder.tvPosisiCicilan.setText(String.valueOf(model.getPosisiCicilanKe()));
            holder.tvTglJatuhTempo.setText(sTglJT);
            holder.tvKolektibilitas.setText(model.getKolektibilitas());

        }

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private OnItemClickListener mlistener;

        /*@BindView(R.id.tv_no_angsuran)
        TextView tvNoAngsuran;
        @BindView(R.id.tv_tgl_jatuhtempo_bulanan)
        TextView tvTglJatuhTempo;
        @BindView(R.id.tv_tgl_transaksi)
        TextView tvTglTransaksi;
        @BindView(R.id.tv_total_dibayar)
        TextView tvTotalDibayar;
        @BindView(R.id.tv_pokok_dibayar)
        TextView tvPokokDibayar;
        @BindView(R.id.tv_bunga_dibayar)
        TextView tvBungaDibayar;
        @BindView(R.id.tv_denda_dibayar)
        TextView tvDendaDibayar;

        @BindView(R.id.tv_total_angsuran)
        TextView tvTotalAngsuran;
        @BindView(R.id.tv_angsuran_pokok)
        TextView tvAngsuranPokok;
        @BindView(R.id.tv_angsuran_bunga)
        TextView tvAngsuranBunga;
        @BindView(R.id.tv_denda_angsuran)
        TextView tvDendaAngsuran;*/

        @BindView(R.id.tv_no_rekening)
        TextView tvNoRekening;
        @BindView(R.id.tv_outstanding)
        TextView tvOutstanding;
        @BindView(R.id.tv_jml_pinjaman)
        TextView tvJmlPinjaman;
        @BindView(R.id.tv_jml_angsuran)
        TextView tvJmlAngsuran;
        @BindView(R.id.tv_posisi_cicilan)
        TextView tvPosisiCicilan;
        @BindView(R.id.tv_tgl_jatuh_tempo)
        TextView tvTglJatuhTempo;
        @BindView(R.id.tv_kolektibilitas)
        TextView tvKolektibilitas;


        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
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
}
