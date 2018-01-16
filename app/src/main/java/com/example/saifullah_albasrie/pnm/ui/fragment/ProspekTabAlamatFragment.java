package com.example.saifullah_albasrie.pnm.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.AlamatCallback;
import com.example.saifullah_albasrie.pnm.controller.AlamatController;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.ProspekAlamatModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.KabupatenModel;
import com.example.saifullah_albasrie.pnm.model.master.KecamatanModel;
import com.example.saifullah_albasrie.pnm.model.master.KelurahanModel;
import com.example.saifullah_albasrie.pnm.model.master.ProvinsiModel;
import com.example.saifullah_albasrie.pnm.model.state.FormModeStateChanged;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class ProspekTabAlamatFragment extends BaseFragment {

    private int formMode;
    private List<ProspekAlamatModel> mAlamatModel;

    @BindView(R.id.tv_hint_alamat_prioritas)
    TextView tvHintAlamatPrioritas;
    @BindView(R.id.sp_alamat_prioritas)
    Spinner spAlamatPrioritas;
    @BindView(R.id.ll_btn_tambah)
    View layoutBtnTambahAlamat;

//    @BindView(R.id.btnTambahAlamat)
//    Button btnTambahAlamat;

    @BindView(R.id.view_alamat)
    LinearLayout alamatView;

    @Override
    public int getFragmentView() {
        return R.layout.fragment_prospek_alamat;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            formMode = getArguments().getInt(Constant.BUNDLE_FORM_MODE);
            ProspekListItemModel prospekItemModel = getArguments().getParcelable(Constant.BUNDLE_DATA);
            if (prospekItemModel != null) {
                mAlamatModel = prospekItemModel.getAlamatModel();
            }
        }
        setupView();
    }

    @Optional
    @OnClick(R.id.ll_btn_tambah)
    public void onClickAddAlamat() {
        int count = alamatView.getChildCount();
        if (count < Constant.MAX_ALAMAT) {
            addAlamatItem(null);
        }
    }

    private void addAlamatItem(final ProspekAlamatModel model) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_alamat, null);
        final Spinner spJenisAlamat = ButterKnife.findById(view, R.id.sp_jenis_alamat);
        final EditText tvAlamat = ButterKnife.findById(view, R.id.tv_alamat);
        final EditText tvRT = ButterKnife.findById(view, R.id.tv_rt);
        final EditText tvRW = ButterKnife.findById(view, R.id.tv_rw);
        final EditText tvKodepos = ButterKnife.findById(view, R.id.tv_kodepos);
        final EditText tvTahun = ButterKnife.findById(view, R.id.tv_tahun);
        final EditText tvBulan = ButterKnife.findById(view, R.id.tv_bulan);
        final Spinner spProvinsi = ButterKnife.findById(view, R.id.spinner_province);
        final Spinner spKota = ButterKnife.findById(view, R.id.spinner_city);
        final Spinner spKecamatan = ButterKnife.findById(view, R.id.spinner_district);
        final Spinner spKelurahan = ButterKnife.findById(view, R.id.spinner_subDistrict);
        final View ivDelete = ButterKnife.findById(view, R.id.delete_alamat);
        if (formMode == FormMode.VIEW || alamatView.getChildCount() == 0) {
            ivDelete.setVisibility(View.GONE);
        } else {
            ivDelete.setVisibility(View.VISIBLE);
        }
        ivDelete.setTag(view);
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (alamatView.getChildCount() > 1) {
                    DialogFactory.showConfirmation(getContext(), "", "Hapus Alamat?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            View container = (View) v.getTag();
                            alamatView.removeView(container);
                        }
                    });
                } else {
                    DialogFactory.showAlert(getContext(), "Alamat tidak bisa di hapus, minimal harus ada satu alamat");
                }

            }
        });

        WidgetUtil.setInputRange(tvBulan, 0, 12);

        final AlamatController alamatController = new AlamatController();

        /*List<ProvinsiModel> arrProvinsi = DataManager.getInstance().getProvinsiModelList();
        if (arrProvinsi != null && arrProvinsi.size() > 0) {
            ArrayAdapter<ProvinsiModel> adapterProvinsi = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrProvinsi);
            adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spProvinsi.setAdapter(adapterProvinsi);
        }*/
        WidgetUtil.setDataMasterAdapter(spProvinsi, DataManager.getInstance().getProvinsiModelList());

        spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spProvinsi.getSelectedItem() != null && spProvinsi.getSelectedItem() instanceof ProvinsiModel) {
                    ProvinsiModel provinsiModel = (ProvinsiModel) spProvinsi.getSelectedItem();
                    if (provinsiModel != null && provinsiModel.getId() > 0) {
                        WidgetUtil.setDefaultEmptyAdapter(spKota);
                        WidgetUtil.setDefaultEmptyAdapter(spKecamatan);
                        WidgetUtil.setDefaultEmptyAdapter(spKelurahan);
                        alamatController.getKabupaten(provinsiModel.getId());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spKota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spProvinsi.getSelectedItem() instanceof  ProvinsiModel
                        && spKota.getSelectedItem() instanceof KabupatenModel) {
                    ProvinsiModel provinsiModel = (ProvinsiModel) spProvinsi.getSelectedItem();
                    KabupatenModel kabupatenModel = (KabupatenModel) spKota.getSelectedItem();
                    if (provinsiModel != null && provinsiModel.getId() > 0
                            && kabupatenModel != null && kabupatenModel.getId() > 0) {

                        WidgetUtil.setDefaultEmptyAdapter(spKecamatan);
                        WidgetUtil.setDefaultEmptyAdapter(spKelurahan);
                        alamatController.getKecamatan(provinsiModel.getId(), kabupatenModel.getId());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spKecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spProvinsi.getSelectedItem() instanceof  ProvinsiModel
                        && spKota.getSelectedItem() instanceof KabupatenModel
                        && spKecamatan.getSelectedItem() instanceof KecamatanModel) {
                    ProvinsiModel provinsiModel = (ProvinsiModel) spProvinsi.getSelectedItem();
                    KabupatenModel kabupatenModel = (KabupatenModel) spKota.getSelectedItem();
                    KecamatanModel kecamatanModel = (KecamatanModel) spKecamatan.getSelectedItem();
                    if (provinsiModel != null && provinsiModel.getId() > 0
                            && kabupatenModel != null && kabupatenModel.getId() > 0
                            && kecamatanModel != null && kecamatanModel.getId() > 0
                            ) {
                        alamatController.getKelurahan(provinsiModel.getId(), kabupatenModel.getId(), kecamatanModel.getId());
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AlamatCallback alamatCallback = new AlamatCallback() {
            @Override
            public void onGetKabupatenSuccess(List<KabupatenModel> list) {
                if (!isVisible()) {
                    return;
                }

                if (list == null) {
                    list = new ArrayList<>();
                }
                KabupatenModel modelFirst = new KabupatenModel();
                modelFirst.setNamaKabupaten("Pilih");
                if(!list.contains(modelFirst)) {
                    list.add(0, modelFirst);
                }

                ArrayAdapter<KabupatenModel> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spKota.setAdapter(adapter);

                if (model != null) {
                    if (model.getIdKabupatenKota() > 0 && !TextUtils.isEmpty(model.getNamaKabupatenKota())) {
                        int posKota = WidgetUtil.getSpinnerIndexByLabel(spKota, model.getNamaKabupatenKota());
                        spKota.setSelection(posKota);
                    }
                }
            }

            @Override
            public void onGetKabupatenFailed(Throwable t) {

            }

            @Override
            public void onGetKecamatanSuccess(List<KecamatanModel> list) {
                if (!isVisible()) {
                    return;
                }

                if (list == null) {
                    list = new ArrayList<>();
                }
                KecamatanModel modelFirst = new KecamatanModel();
                modelFirst.setNamaKecamatan("Pilih");
                if(!list.contains(modelFirst)) {
                    list.add(0, modelFirst);
                }

                ArrayAdapter<KecamatanModel> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spKecamatan.setAdapter(adapter);

                if(model != null) {
                    if (model.getIdKecamatan() > 0 && !TextUtils.isEmpty(model.getNamaKecamatan())) {
                        int posKecamatan = WidgetUtil.getSpinnerIndexByLabel(spKecamatan, model.getNamaKecamatan());
                        spKecamatan.setSelection(posKecamatan);
                    }
                }
            }

            @Override
            public void onGetKecamatanFailed(Throwable t) {

            }

            @Override
            public void onGetKelurahanSuccess(List<KelurahanModel> list) {
                if (!isVisible()) {
                    return;
                }

                if (list == null) {
                    list = new ArrayList<>();
                }
                KelurahanModel modelFirst = new KelurahanModel();
                modelFirst.setNamaKelurahan("Pilih");
                if(!list.contains(modelFirst)) {
                    list.add(0, modelFirst);
                }

                ArrayAdapter<KelurahanModel> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spKelurahan.setAdapter(adapter);

                if(model != null) {
                    if (model.getIdKelurahan() > 0 && !TextUtils.isEmpty(model.getNamaKelurahan())) {
                        int posKelurahan = WidgetUtil.getSpinnerIndexByLabel(spKelurahan, model.getNamaKelurahan());
                        spKelurahan.setSelection(posKelurahan);
                    }
                }
            }

            @Override
            public void onGetKelurahanFailed(Throwable t) {

            }
        };
        alamatController.setCallback(alamatCallback);

        if (model != null) {
            if (model.getPrioritas() == 1) {
                int posAlamatPrioritas = model.getJenisAlamat();
                spAlamatPrioritas.setSelection(posAlamatPrioritas);
            }

            spJenisAlamat.setSelection(model.getJenisAlamat());
            tvAlamat.setText(model.getAlamat());
            tvRT.setText(model.getRt());
            tvRW.setText(model.getRw());
            tvKodepos.setText(model.getKodepos());
            if (model.getLamaMenempatiTahun() > 0) {
                tvTahun.setText(String.valueOf(model.getLamaMenempatiTahun()));
            }
            if (model.getLamaMenempatiBulan() > 0) {
                tvBulan.setText(String.valueOf(model.getLamaMenempatiBulan()));
            }

            int posProvinsi = WidgetUtil.getSpinnerIndexByLabel(spProvinsi, model.getNamaProvinsi());
            spProvinsi.setSelection(posProvinsi);
            int posKota = WidgetUtil.getSpinnerIndexByLabel(spKota, model.getNamaKabupatenKota());
            spKota.setSelection(posKota);
            int posKecamatan = WidgetUtil.getSpinnerIndexByLabel(spKecamatan, model.getNamaKecamatan());
            spKecamatan.setSelection(posKecamatan);
            int posKelurahan = WidgetUtil.getSpinnerIndexByLabel(spKota, model.getNamaKelurahan());
            spKelurahan.setSelection(posKelurahan);
        }


        setupHintView(view);

        if (alamatView.getChildCount() < Constant.MAX_ALAMAT) {
            alamatView.addView(view);
        }
    }

    private void setupView() {
        spAlamatPrioritas.setSelection(0);
        alamatView.removeAllViews();
        if (mAlamatModel != null) {
            for (ProspekAlamatModel item : mAlamatModel) {
                addAlamatItem(item);
            }
        }

        if (alamatView.getChildCount() == 0) {
            addAlamatItem(null);
        }

        spAlamatPrioritas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                changeAlamatDefault(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        setupMode();
    }

    private void changeAlamatDefault(int position) {
        for (int i = 0; i < alamatView.getChildCount() && i < 1; i++) {
            View view = alamatView.getChildAt(i);
            Spinner spJenisAlamat = ButterKnife.findById(view, R.id.sp_jenis_alamat);
            spJenisAlamat.setSelection(position);
        }
    }

    private void setupHintMode(){
        for (int i = 0; i < alamatView.getChildCount(); i++) {
            View view = alamatView.getChildAt(i);
            setupHintView(view);
        }
    }

    private void setupHintView(View view){
        TextView hintJenisAlamat = ButterKnife.findById(view, R.id.tv_hint_jenis_alamat);
        TextView hintAlamat = ButterKnife.findById(view, R.id.tv_hint_alamat);
        TextView hintRT = ButterKnife.findById(view, R.id.tv_hint_rt);
        TextView hintRW = ButterKnife.findById(view, R.id.tv_hint_rw);
        TextView hintProvinsi = ButterKnife.findById(view, R.id.tv_hint_provinsi);
        TextView hintKota = ButterKnife.findById(view, R.id.tv_hint_kota);
        TextView hintKecamatan = ButterKnife.findById(view, R.id.tv_hint_kecamatan);
        TextView hintKelurahan = ButterKnife.findById(view, R.id.tv_hint_kelurahan);
        TextView hintKodepos = ButterKnife.findById(view, R.id.tv_hint_kode_pos);
        TextView hintTahun = ButterKnife.findById(view, R.id.tv_hint_tahun);
        TextView hintBulan = ButterKnife.findById(view, R.id.tv_hint_bulan);


        if (formMode == FormMode.VIEW) {
            tvHintAlamatPrioritas.setTextColor(getResources().getColor(R.color.grey_text));
            hintJenisAlamat.setTextColor(getResources().getColor(R.color.grey_text));
            hintAlamat.setTextColor(getResources().getColor(R.color.grey_text));
            hintRT.setTextColor(getResources().getColor(R.color.grey_text));
            hintRW.setTextColor(getResources().getColor(R.color.grey_text));
            hintProvinsi.setTextColor(getResources().getColor(R.color.grey_text));
            hintKota.setTextColor(getResources().getColor(R.color.grey_text));
            hintKecamatan.setTextColor(getResources().getColor(R.color.grey_text));
            hintKelurahan.setTextColor(getResources().getColor(R.color.grey_text));
            hintKodepos.setTextColor(getResources().getColor(R.color.grey_text));
            hintTahun.setTextColor(getResources().getColor(R.color.grey_text));
            hintBulan.setTextColor(getResources().getColor(R.color.grey_text));
        } else {
            tvHintAlamatPrioritas.setTextColor(getResources().getColor(R.color.red_text));
            hintJenisAlamat.setTextColor(getResources().getColor(R.color.red_text));
            hintAlamat.setTextColor(getResources().getColor(R.color.red_text));
            hintRT.setTextColor(getResources().getColor(R.color.red_text));
            hintRW.setTextColor(getResources().getColor(R.color.red_text));
            hintProvinsi.setTextColor(getResources().getColor(R.color.red_text));
            hintKota.setTextColor(getResources().getColor(R.color.red_text));
            hintKecamatan.setTextColor(getResources().getColor(R.color.red_text));
            hintKelurahan.setTextColor(getResources().getColor(R.color.red_text));
            hintKodepos.setTextColor(getResources().getColor(R.color.red_text));
            hintTahun.setTextColor(getResources().getColor(R.color.red_text));
            hintBulan.setTextColor(getResources().getColor(R.color.red_text));
        }
    }

    private void setupMode() {
        switch (formMode) {
            case FormMode.VIEW:
                setEnableItems(false);
                layoutBtnTambahAlamat.setEnabled(false);
                layoutBtnTambahAlamat.setVisibility(View.GONE);
                break;
            default:
                setEnableItems(true);
                layoutBtnTambahAlamat.setEnabled(true);
                layoutBtnTambahAlamat.setVisibility(View.VISIBLE);
                break;
        }
        setupHintMode();

    }

    private void setEnableItems(boolean enable) {
        spAlamatPrioritas.setEnabled(enable);

        for (int i = 0; i < alamatView.getChildCount(); i++) {
            View view = alamatView.getChildAt(i);

            ImageView ivDelete = ButterKnife.findById(view, R.id.delete_alamat);
            if (enable && i > 0) {
                ivDelete.setVisibility(View.VISIBLE);
            } else {
                ivDelete.setVisibility(View.GONE);
            }
            Spinner spJenisAlamat = ButterKnife.findById(view, R.id.sp_jenis_alamat);
            spJenisAlamat.setEnabled(enable);
            final EditText tvAlamat = ButterKnife.findById(view, R.id.tv_alamat);
            tvAlamat.setEnabled(enable);
            final EditText tvRT = ButterKnife.findById(view, R.id.tv_rt);
            tvRT.setEnabled(enable);
            final EditText tvRW = ButterKnife.findById(view, R.id.tv_rw);
            tvRW.setEnabled(enable);
            final EditText tvKodepos = ButterKnife.findById(view, R.id.tv_kodepos);
            tvKodepos.setEnabled(enable);
            final EditText tvTahun = ButterKnife.findById(view, R.id.tv_tahun);
            tvTahun.setEnabled(enable);
            final EditText tvBulan = ButterKnife.findById(view, R.id.tv_bulan);
            tvBulan.setEnabled(enable);
            Spinner spProvinsi = ButterKnife.findById(view, R.id.spinner_province);
            spProvinsi.setEnabled(enable);
            Spinner spKota = ButterKnife.findById(view, R.id.spinner_city);
            spKota.setEnabled(enable);
            Spinner spKecamatan = ButterKnife.findById(view, R.id.spinner_district);
            spKecamatan.setEnabled(enable);
            Spinner spKelurahan = ButterKnife.findById(view, R.id.spinner_subDistrict);
            spKelurahan.setEnabled(enable);
        }
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

    public List<ProspekAlamatModel> saveData() {
        if (!WidgetUtil.validateField(spAlamatPrioritas, getString(R.string.field_err_msg, "Alamat prioritas"))) {
            return null;
        }
        int posAlamatPrioritas = spAlamatPrioritas.getSelectedItemPosition();

        if (mAlamatModel != null) {
            mAlamatModel.clear();
        } else {
            mAlamatModel = new ArrayList<>();
        }
        int count = alamatView.getChildCount();
        ArrayList arrJenisAlamat = new ArrayList();
        for (int i=0; i< count; i++) {
            View view = alamatView.getChildAt(i);

            Spinner spJenisAlamat = ButterKnife.findById(view, R.id.sp_jenis_alamat);
            int idJenisAlamat = spJenisAlamat.getSelectedItemPosition();
            if(idJenisAlamat <= 0 && !WidgetUtil.validateField(spJenisAlamat, getString(R.string.field_err_msg, "Jenis Alamat"))) {
                return null;
            }

            if(arrJenisAlamat.contains(idJenisAlamat)) {
                WidgetUtil.showToast(getContext(), "Pilihan Jenis Alamat tidak boleh sama");
                return null;
            }
            arrJenisAlamat.add(idJenisAlamat);

            final EditText tvAlamat = ButterKnife.findById(view, R.id.tv_alamat);
            if (!WidgetUtil.validateField(tvAlamat, getString(R.string.field_err_msg, "Alamat"))) {
                return null;
            }
            final EditText tvRT = ButterKnife.findById(view, R.id.tv_rt);
            if (!WidgetUtil.validateField(tvRT, getString(R.string.field_err_msg, "RT"))) {
                return null;
            }

            final EditText tvRW = ButterKnife.findById(view, R.id.tv_rw);
            if (!WidgetUtil.validateField(tvRT, getString(R.string.field_err_msg, "RW"))) {
                return null;
            }
            final EditText tvKodepos = ButterKnife.findById(view, R.id.tv_kodepos);
            if (!WidgetUtil.validateField(tvKodepos, getString(R.string.field_err_msg, "Kodepos"))) {
                return null;
            }

            final EditText tvTahun = ButterKnife.findById(view, R.id.tv_tahun);
            final EditText tvBulan = ButterKnife.findById(view, R.id.tv_bulan);

            Spinner spProvinsi = ButterKnife.findById(view, R.id.spinner_province);
            if(!WidgetUtil.validateField(spProvinsi, getString(R.string.field_err_msg, "Provinsi"))) {
                return null;
            }

            Spinner spKota = ButterKnife.findById(view, R.id.spinner_city);
            if(!WidgetUtil.validateField(spKota, getString(R.string.field_err_msg, "Kota/Kabupaten"))) {
                return null;
            }
            Spinner spKecamatan = ButterKnife.findById(view, R.id.spinner_district);
            if(!WidgetUtil.validateField(spKecamatan, getString(R.string.field_err_msg, "Kecamatan"))) {
                return null;
            }
            Spinner spKelurahan = ButterKnife.findById(view, R.id.spinner_subDistrict);
            if(!WidgetUtil.validateField(spKelurahan, getString(R.string.field_err_msg, "Kelurahan"))) {
                return null;
            }

            ProvinsiModel provinsiModel = (ProvinsiModel) spProvinsi.getSelectedItem();
            KabupatenModel kabupatenModel = (KabupatenModel) spKota.getSelectedItem();
            KecamatanModel kecamatanModel = (KecamatanModel) spKecamatan.getSelectedItem();
            KelurahanModel kelurahanModel = (KelurahanModel) spKelurahan.getSelectedItem();

            ProspekAlamatModel model = new ProspekAlamatModel();
            if (idJenisAlamat == posAlamatPrioritas) {
                model.setPrioritas(1);
            }
            model.setJenisAlamat(idJenisAlamat);
            model.setAlamat(tvAlamat.getText().toString());
            model.setRt(tvRT.getText().toString());
            model.setRw(tvRW.getText().toString());
            model.setKodepos(tvKodepos.getText().toString());
            int lamaBulan = 0;
            try {
                lamaBulan = Integer.parseInt(tvBulan.getText().toString());
            }catch (Exception e) {}
            int lamaTahun = 0;
            try {
                lamaTahun = Integer.parseInt(tvTahun.getText().toString());
            }catch (Exception e) {}

            model.setLamaMenempatiBulan(lamaBulan);
            model.setLamaMenempatiTahun(lamaTahun);

            if (provinsiModel != null && provinsiModel.getId() != 0) {
                model.setIdProvinsi(provinsiModel.getId());
                model.setNamaProvinsi(provinsiModel.getNamaProvinsi());
            } else {
                WidgetUtil.showToast(getContext(), getString(R.string.field_err_msg, "Provinsi"));
            }

            if (kabupatenModel != null && kabupatenModel.getId() != 0) {
                model.setIdKabupatenKota(kabupatenModel.getId());
                model.setNamaKabupatenKota(kabupatenModel.getNamaKabupaten());
            } else {
                WidgetUtil.showToast(getContext(), getString(R.string.field_err_msg, "Kabupaten/Kota"));
            }

            if (kecamatanModel != null && kecamatanModel.getId() != 0) {
                model.setIdKecamatan(kecamatanModel.getId());
                model.setNamaKecamatan(kecamatanModel.getNamaKecamatan());
            } else {
                WidgetUtil.showToast(getContext(), getString(R.string.field_err_msg, "Kecamatan"));
            }

            if (kelurahanModel != null && kelurahanModel.getId() != 0) {
                model.setIdKelurahan(kelurahanModel.getId());
                model.setNamaKelurahan(kelurahanModel.getNamaKelurahan());
            } else {
                WidgetUtil.showToast(getContext(), getString(R.string.field_err_msg, "Kelurahan"));
            }

            mAlamatModel.add(model);

        }

        if(!arrJenisAlamat.contains(posAlamatPrioritas)) {
            WidgetUtil.showToast(getContext(), "Alamat prioritas yang anda pilih tidak ada");
            spAlamatPrioritas.setFocusable(true);
            spAlamatPrioritas.setFocusableInTouchMode(true);
            spAlamatPrioritas.requestFocus();
            return null;
        }


        return mAlamatModel;
    }

}
