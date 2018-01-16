package com.example.saifullah_albasrie.pnm.ui.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.ProspekAplikasiModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.JenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.ProdukModel;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProspekTabAplikasiFragment extends BaseFragment {

    private int formMode;
    private List<ProspekAplikasiModel> mAplikasiModel;

    @BindView(R.id.tv_rencana_plafond)
    EditText tvRencanaPlafond;
    @BindView(R.id.tv_jangka_waktu)
    EditText tvJangkaWaktu;
    @BindView(R.id.tv_kemampuan)
    EditText tvKemampuan;
    @BindView(R.id.spinner_tujuan_pembiayaan)
    Spinner spTujuanPembiayaan;
    @BindView(R.id.spinner_rencana_produk)
    Spinner spRencanaProduk;

    @BindView(R.id.ll_btn_tambah)
    View layoutBtnTambahUsaha;

    @BindView(R.id.view_aplikasi)
    LinearLayout aplikasiView;

    @BindViews({
            R.id.tv_hint_rencana_plafond,
            R.id.tv_hint_rencana_produk,
            //R.id.tv_hint_jangka_waktu,
            R.id.tv_hint_kemampuan_ansuran,
            R.id.tv_hint_tujuan_pembiayaan
    })
    List<TextView> mandatoryHintMaster;


    @Optional
    @OnClick(R.id.ll_btn_tambah)
    public void onClickAddAplikasi() {
        addAplikasiItem(null);
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_aplikasi;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            ProspekListItemModel prospekItemModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            if (prospekItemModel != null && prospekItemModel.getAplikasiModel() != null && prospekItemModel.getAplikasiModel().size() > 0) {
                mAplikasiModel = prospekItemModel.getAplikasiModel();
            }
        }
        setupView();
    }

    private void initView() {
        /*List<ProdukModel> arrProduk = DataManager.getInstance().getProdukModelList();
        if (arrProduk != null && arrProduk.size() > 0) {
            ArrayAdapter<ProdukModel> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrProduk);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spRencanaProduk.setAdapter(adapter);
        }*/
        WidgetUtil.setDataMasterAdapter(spRencanaProduk, DataManager.getInstance().getProdukModelList());
        WidgetUtil.setTextWatcherCurrency(tvRencanaPlafond, Constant.MAX_PLAFOND_VALUE);
        WidgetUtil.setTextWatcherCurrency(tvKemampuan, Constant.MAX_PLAFOND_VALUE);
        WidgetUtil.setTextWatcherCurrency(tvJangkaWaktu, 9999L);
    }

    private void setupView() {
        aplikasiView.removeAllViews();
        if (mAplikasiModel != null && mAplikasiModel.size() > 0) {
            ProspekAplikasiModel model = mAplikasiModel.get(0);
            tvRencanaPlafond.setText(model.getRencanaPlafond());
            tvJangkaWaktu.setText(String.valueOf(model.getJangkaWaktu()));
            tvKemampuan.setText(model.getAngsuranPerbulan());
            int posTujuan = WidgetUtil.getSpinnerIndexByLabel(spTujuanPembiayaan, model.getTujuanPembiayaan());
            spTujuanPembiayaan.setSelection(posTujuan);
            int posProduk = WidgetUtil.getSpinnerIndexByLabel(spRencanaProduk, model.getNamaProduk());
            spRencanaProduk.setSelection(posProduk);

            for (ProspekAplikasiModel item : mAplikasiModel) {
                addAplikasiItem(item);
            }
        }

        if (aplikasiView.getChildCount() == 0) {
            addAplikasiItem(null);
        }
        setupMode();
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                ButterKnife.apply(mandatoryHintMaster,WidgetUtil.SET_COLOR,getResources().getColor(R.color.grey_text));
                setEnableItems(false);
                layoutBtnTambahUsaha.setEnabled(false);
                layoutBtnTambahUsaha.setVisibility(View.GONE);
                break;
            default:
                ButterKnife.apply(mandatoryHintMaster,WidgetUtil.SET_COLOR,getResources().getColor(R.color.red_text));
                setEnableItems(true);
                layoutBtnTambahUsaha.setEnabled(true);
                layoutBtnTambahUsaha.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void setEnableItems(boolean enable) {
        tvRencanaPlafond.setEnabled(enable);
        tvJangkaWaktu.setEnabled(enable);
        tvKemampuan.setEnabled(enable);
        spTujuanPembiayaan.setEnabled(enable);
        spRencanaProduk.setEnabled(enable);

        for (int i = 0; i < aplikasiView.getChildCount(); i++) {
            View view = aplikasiView.getChildAt(i);

            /*
            EditText tvRencanaPlafond = ButterKnife.findById(view, R.id.tv_rencana_plafond);
            tvRencanaPlafond.setEnabled(enable);
            EditText tvJangkaWaktu = ButterKnife.findById(view, R.id.tv_jangka_waktu);
            tvJangkaWaktu.setEnabled(enable);

            EditText tvKemampuan = ButterKnife.findById(view, R.id.tv_kemampuan);
            tvKemampuan.setEnabled(enable);

            Spinner spTujuanPembiayaan = ButterKnife.findById(view, R.id.spinner_tujuan_pembiayaan);
            spTujuanPembiayaan.setEnabled(enable);
            */
            ImageView ivDelete = ButterKnife.findById(view, R.id.delete_usaha);
            if (enable && i > 0) {
                ivDelete.setVisibility(View.VISIBLE);
            } else {
                ivDelete.setVisibility(View.GONE);
            }

            Spinner spJenisUsaha = ButterKnife.findById(view, R.id.spinner_jenis_usaha);
            spJenisUsaha.setEnabled(enable);

            Spinner spLamaTahun = ButterKnife.findById(view, R.id.spinner_lama_tahun);
            spLamaTahun.setEnabled(enable);

            Spinner spLamaBulan = ButterKnife.findById(view, R.id.spinner_lama_bulan);
            spLamaBulan.setEnabled(enable);

            EditText tvAlamatUsaha = ButterKnife.findById(view, R.id.tv_alamat_usaha);
            tvAlamatUsaha.setEnabled(enable);

            EditText tvNamaUsaha = ButterKnife.findById(view, R.id.tv_nama_usaha);
            tvNamaUsaha.setEnabled(enable);

            EditText tvOmsetPerhari = ButterKnife.findById(view, R.id.tv_omset_perhari);
            tvOmsetPerhari.setEnabled(enable);

            EditText tvJumlahKaryawan = ButterKnife.findById(view, R.id.tv_jumlah_karyawan);
            tvJumlahKaryawan.setEnabled(enable);

            EditText tvNoTelp = ButterKnife.findById(view, R.id.tv_no_telp);
            tvNoTelp.setEnabled(enable);

            TextView hintJenisUsaha = ButterKnife.findById(view,R.id.tv_hint_jenis_usaha);
            TextView hintNamaUsaha = ButterKnife.findById(view,R.id.tv_hint_nama_usaha);
            if(formMode == FormMode.VIEW){
                hintJenisUsaha.setTextColor(getResources().getColor(R.color.grey_text));
                hintNamaUsaha.setTextColor(getResources().getColor(R.color.grey_text));
            }else{
                hintJenisUsaha.setTextColor(getResources().getColor(R.color.red_text));
                hintNamaUsaha.setTextColor(getResources().getColor(R.color.red_text));
            }

        }
    }


    private void addAplikasiItem(ProspekAplikasiModel model) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_aplikasi, null);
        /*
        EditText tvRencanaPlafond = ButterKnife.findById(view, R.id.tv_rencana_plafond);
        EditText tvJangkaWaktu = ButterKnife.findById(view, R.id.tv_jangka_waktu);
        EditText tvKemampuan = ButterKnife.findById(view, R.id.tv_kemampuan);
        Spinner spTujuanPembiayaan = ButterKnife.findById(view, R.id.spinner_tujuan_pembiayaan);
        */
        Spinner spJenisUsaha = ButterKnife.findById(view, R.id.spinner_jenis_usaha);
        Spinner spLamaTahun = ButterKnife.findById(view, R.id.spinner_lama_tahun);
        Spinner spLamaBulan = ButterKnife.findById(view, R.id.spinner_lama_bulan);

        /*List<JenisUsahaModel> arrJenisUsaha = DataManager.getInstance().getJenisUsahaModelList();
        if (arrJenisUsaha != null && arrJenisUsaha.size() > 0) {
            ArrayAdapter<JenisUsahaModel> adapterJenisUsaha = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrJenisUsaha);
            adapterJenisUsaha.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spJenisUsaha.setAdapter(adapterJenisUsaha);
        }*/
        WidgetUtil.setDataMasterAdapter(spJenisUsaha, DataManager.getInstance().getJenisUsahaModelList());

        EditText tvAlamatUsaha = ButterKnife.findById(view, R.id.tv_alamat_usaha);
        EditText tvNamaUsaha = ButterKnife.findById(view, R.id.tv_nama_usaha);
        EditText tvOmsetPerhari = ButterKnife.findById(view, R.id.tv_omset_perhari);
        EditText tvJumlahKaryawan = ButterKnife.findById(view, R.id.tv_jumlah_karyawan);
        EditText tvNoTelp = ButterKnife.findById(view, R.id.tv_no_telp);

        WidgetUtil.setTextWatcherCurrency(tvOmsetPerhari);

        ImageView ivDelete = ButterKnife.findById(view, R.id.delete_usaha);
        if (aplikasiView.getChildCount() > 0 && formMode != FormMode.VIEW) {
            ivDelete.setVisibility(View.VISIBLE);
        } else {
            ivDelete.setVisibility(View.GONE);
        }

        ivDelete.setTag(view);
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (aplikasiView.getChildCount() > 1) {
                    DialogFactory.showConfirmation(getContext(), "", "Hapus Data Usaha?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            View container = (View) v.getTag();
                            aplikasiView.removeView(container);
                        }
                    });
                }

            }
        });

        if (model != null) {
            int posJenisUsaha = WidgetUtil.getSpinnerIndexByLabel(spJenisUsaha, model.getNamaJenisUsaha());
            spJenisUsaha.setSelection(posJenisUsaha);
            int posLamaTahun = WidgetUtil.getSpinnerIndexByLabel(spLamaTahun, String.valueOf(model.getLamaUsahaTahun()));
            spLamaTahun.setSelection(posLamaTahun);
            int posLamaBulan = WidgetUtil.getSpinnerIndexByLabel(spLamaBulan, String.valueOf(model.getLamaUsahaBulan()));
            spLamaBulan.setSelection(posLamaBulan);

            tvAlamatUsaha.setText(model.getAlamatUsaha());
            tvNamaUsaha.setText(model.getNamaUsaha());
            tvOmsetPerhari.setText(model.getOmsetPerHari());
            tvJumlahKaryawan.setText(model.getJumlahKaryawan());
            tvNoTelp.setText(model.getNomorTelp());
        }

        TextView hintJenisUsaha = ButterKnife.findById(view,R.id.tv_hint_jenis_usaha);
        TextView hintNamaUsaha = ButterKnife.findById(view,R.id.tv_hint_nama_usaha);
        if(formMode == FormMode.VIEW){
            hintJenisUsaha.setTextColor(getResources().getColor(R.color.grey_text));
            hintNamaUsaha.setTextColor(getResources().getColor(R.color.grey_text));
        }else{
            hintJenisUsaha.setTextColor(getResources().getColor(R.color.red_text));
            hintNamaUsaha.setTextColor(getResources().getColor(R.color.red_text));
        }

        aplikasiView.addView(view);
    }

    /**
     * Auto bind with event bus using subscribe annotation
     *
     * @param stateChanged
     */
    @Subscribe
    public void onFormModeChanged(FormModeStateChanged stateChanged) {
        if (stateChanged != null) {
            formMode = stateChanged.getFormMode();
            if (stateChanged.isResetView()) {
                setupView();
            } else {
                setupMode();
            }
        }
    }

    public List<ProspekAplikasiModel> saveData() {
        if (!WidgetUtil.validateField(spRencanaProduk, getString(R.string.field_err_msg, "Rencana Produk"))) {
            return null;
        }

        if (!WidgetUtil.validateField(tvRencanaPlafond, getString(R.string.field_err_msg, "Rencana Plafond"))) {
            return null;
        }

        if (!WidgetUtil.validateField(tvJangkaWaktu, getString(R.string.field_err_msg, "Jangka waktu"))) {
            return null;
        }

        ProspekAplikasiModel model = new ProspekAplikasiModel();

        ProdukModel produkModel = null;
        if ( spRencanaProduk.getSelectedItem() != null && spRencanaProduk.getSelectedItem() instanceof ProdukModel) {
            produkModel = (ProdukModel) spRencanaProduk.getSelectedItem();
            model.setIdProduk(produkModel.getId());
            model.setNamaProduk(produkModel.getNamaProduk());
        }

        if (produkModel == null) {
            WidgetUtil.showToast(getContext(), getString(R.string.field_err_msg, "Rencana Produk"));
            return null;
        }

        int rencanaPlafond = 0;
        String sRencanaPlafond = WidgetUtil.getNumberFromField(tvRencanaPlafond);
        model.setRencanaPlafond(sRencanaPlafond);
        try {
            rencanaPlafond = Integer.parseInt(sRencanaPlafond);
        }catch (Exception e) {}
        if (rencanaPlafond < produkModel.getPlafondMinimal() || rencanaPlafond > produkModel.getPlafondMaksimal()) {
            WidgetUtil.showToast(getContext(), "Pilih plafond antara " +
                    WidgetUtil.convertToLocalCurrency(produkModel.getPlafondMinimal()) + " sampai "
                    + WidgetUtil.convertToLocalCurrency(produkModel.getPlafondMaksimal()));
            tvRencanaPlafond.requestFocus();
            return null;
        }

        int jangkaWaktu = 0;
        try {
            jangkaWaktu = Integer.parseInt(tvJangkaWaktu.getText().toString());
        }catch (Exception e) {}

        if (jangkaWaktu < produkModel.getTenorMin() || jangkaWaktu > produkModel.getTenorMax()) {
            WidgetUtil.showToast(getContext(), "Pilih jangka waktu antara" + produkModel.getTenorMin() + " sampai " + produkModel.getTenorMax());
            tvJangkaWaktu.requestFocus();
            return null;
        }

        if (!WidgetUtil.validateField(tvKemampuan, getString(R.string.field_err_msg, "Kemampuan perbulan"))) {
            return null;
        }

        if (!WidgetUtil.validateField(spTujuanPembiayaan, getString(R.string.field_err_msg, "Tujuan pembiayaan"))) {
            return null;
        }

        model.setJangkaWaktu(jangkaWaktu);
        model.setAngsuranPerbulan(WidgetUtil.getNumberFromField(tvKemampuan));
        model.setTujuanPembiayaan(spTujuanPembiayaan.getSelectedItem().toString());


        for (int i = 0; i < aplikasiView.getChildCount(); i++) {
            View view = aplikasiView.getChildAt(i);
            Spinner spJenisUsaha = ButterKnife.findById(view, R.id.spinner_jenis_usaha);
            Spinner spLamaUsahaTahun = ButterKnife.findById(view, R.id.spinner_lama_tahun);
            Spinner spLamaUsahaBulan = ButterKnife.findById(view, R.id.spinner_lama_bulan);
            EditText tvAlamatUsaha = ButterKnife.findById(view, R.id.tv_alamat_usaha);
            EditText tvNamaUsaha = ButterKnife.findById(view, R.id.tv_nama_usaha);
            EditText tvOmsetPerhari = ButterKnife.findById(view, R.id.tv_omset_perhari);
            EditText tvJumlahKaryawan = ButterKnife.findById(view, R.id.tv_jumlah_karyawan);
            EditText tvNoTelp = ButterKnife.findById(view, R.id.tv_no_telp);

            if (!WidgetUtil.validateField(spJenisUsaha, getString(R.string.field_err_msg, "Jenis Usaha"))) {
                return null;
            }

            if ( spJenisUsaha.getSelectedItem() != null && spJenisUsaha.getSelectedItem() instanceof JenisUsahaModel) {
                JenisUsahaModel jenisUsahaModel = (JenisUsahaModel) spJenisUsaha.getSelectedItem();
                model.setIdJenisUsaha(jenisUsahaModel.getId());
                model.setNamaJenisUsaha(jenisUsahaModel.getNamaJenisUsaha());
            } else {
                return null;
            }

            if (!WidgetUtil.validateField(tvNamaUsaha, getString(R.string.field_err_msg, "Nama Usaha"))) {
                return null;
            }

            model.setAlamatUsaha(tvAlamatUsaha.getText().toString());
            model.setNamaUsaha(tvNamaUsaha.getText().toString());
            if (!TextUtils.isEmpty(tvOmsetPerhari.getText().toString())) {
                model.setOmsetPerHari(WidgetUtil.getNumberFromField(tvOmsetPerhari));
            }
            model.setJumlahKaryawan(tvJumlahKaryawan.getText().toString());
            model.setNomorTelp(tvNoTelp.getText().toString());
            model.setLamaUsahaTahun(spLamaUsahaTahun.getSelectedItem() != null ? spLamaUsahaTahun.getSelectedItem().toString(): "");
            model.setLamaUsahaBulan(spLamaUsahaBulan.getSelectedItem() != null? spLamaUsahaBulan.getSelectedItem().toString() : "");
            //model.setLamaUsahaTahun(WidgetUtil.getNumberFromField(spLamaUsahaTahun));
            //model.setLamaUsahaBulan(WidgetUtil.getNumberFromField(spLamaUsahaBulan));

        }

        if (mAplikasiModel == null) {
            mAplikasiModel = new ArrayList<>();
        } else {
            mAplikasiModel.clear();
        }

        mAplikasiModel.add(model);

        return mAplikasiModel;
    }
}
