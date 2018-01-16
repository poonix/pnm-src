package com.example.saifullah_albasrie.pnm.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.AlamatCallback;
import com.example.saifullah_albasrie.pnm.callback.SurveyDetailCallback;
import com.example.saifullah_albasrie.pnm.controller.AlamatController;
import com.example.saifullah_albasrie.pnm.controller.SurveyDetailController;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.ExumModel;
import com.example.saifullah_albasrie.pnm.model.ProspekAlamatModel;
import com.example.saifullah_albasrie.pnm.model.ProspekJadwalModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyDataPembiayaanModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.model.master.KabupatenModel;
import com.example.saifullah_albasrie.pnm.model.master.KecamatanModel;
import com.example.saifullah_albasrie.pnm.model.master.KelurahanModel;
import com.example.saifullah_albasrie.pnm.model.master.ProdukModel;
import com.example.saifullah_albasrie.pnm.model.master.ProvinsiModel;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.rest.request.SurveyDetailRequest;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDetailResponse;
import com.example.saifullah_albasrie.pnm.ui.customview.WorkaroundMapFragment;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.ui.fragment.MainFragment;
import com.example.saifullah_albasrie.pnm.ui.widget.MapViewFragment;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.DateUtil;
import com.example.saifullah_albasrie.pnm.utils.PermissionUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by aldhiramdan on 3/21/17.
 */

public class FormSurveyActivity extends BaseFormActivity implements SurveyDetailCallback {

    private ProspekListItemModel mDataModel;
    private List<SurveyDataPembiayaanModel> dataPembiayaanModels;
    private List<ProspekJadwalModel> jadwalModels;
    private List<ProspekAlamatModel> alamatModels;
    private List<ExumModel> exumModels;

    private List<MapViewFragment> listMapFragment = new ArrayList<>();

    private SurveyDetailController controller;

    @BindView(R.id.sv_form_survey)
    ScrollView scrollView;

    @BindView(R.id.spinner_rencana_produk)
    Spinner spRencanaProduk;
    @BindView(R.id.tv_rencana_plafond)
    EditText tvRencanaPlafond;
    @BindView(R.id.tv_jangka_waktu)
    EditText tvJangkaWaktu;
    @BindView(R.id.tv_kemampuan_angsuran)
    EditText tvKemampuanAngsuran;
    @BindView(R.id.spinner_tujuan_pembiayaan)
    Spinner spTujuanPembiayaan;

    @BindView(R.id.ll_container_alamat)
    LinearLayout alamatView;

    @BindView(R.id.ll_btn_tambah)
    View vButtonTambah;

    @BindView(R.id.tv_executive_summary)
    EditText tvExum;

    @BindView(R.id.tv_pilih_tanggal)
    TextView tvDate;
    @BindView(R.id.picker_date)
    View ivPickerDate;

    @OnClick(R.id.picker_date)
    void onCLick(View v) {
        switch (v.getId()) {
            case R.id.picker_date:
                WidgetUtil.showDatePicker(this, tvDate);
                break;
        }
    }

    @BindViews({
            R.id.tv_hint_tanggal_survey,
            R.id.tv_hint_rencana_plafon,
            R.id.tv_hint_jangka_waktu,
            R.id.tv_hint_kemampuan_angsuran,
            R.id.tv_hint_tujuan_pembiayaan,
            R.id.tv_hint_executive_summary
    })
    List<TextView> mandatoryHintViews;

    public static void navigate(Activity activity, int formMode, ProspekListItemModel mDataModel) {
        Intent intent = new Intent(activity, FormSurveyActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        activity.startActivity(intent);
    }

    /*
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        loadData();
    }
    */

    @Override
    protected int getLayoutId() {
        return R.layout.layout_form_survey;
    }

    public void initData() {
        controller = new SurveyDetailController(this);
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }

        WidgetUtil.setDataMasterAdapter(spRencanaProduk, DataManager.getInstance().getProdukModelList());
        WidgetUtil.setTextWatcherCurrency(tvRencanaPlafond);
        WidgetUtil.setTextWatcherCurrency(tvKemampuanAngsuran);

        WidgetUtil.setTextWatcherCurrency(tvRencanaPlafond, Constant.MAX_PLAFOND_VALUE);
        WidgetUtil.setTextWatcherCurrency(tvKemampuanAngsuran, Constant.MAX_PLAFOND_VALUE);
        WidgetUtil.setTextWatcherCurrency(tvJangkaWaktu, 9999L);

        if (alamatView.getChildCount() == 0) {
            addAlamatItem(null);
        }

        if (!PermissionUtil.isPermissionGpsGranted(this)) {
            PermissionUtil.checkGPSPermission(this);
            return;
        }
    }

    @Override
    public void loadData() {
        if (mDataModel != null) {
            DialogFactory.showProgress(this);
            controller.getSurveyDetail(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }
    }


    @Override
    public void changeToViewMode() {
        super.changeToViewMode();
        ButterKnife.apply(mandatoryHintViews, WidgetUtil.SET_COLOR, getResources().getColor(R.color.grey_text));

    }

    @Override
    public void changeToEditMode() {
        super.changeToEditMode();
        ButterKnife.apply(mandatoryHintViews, WidgetUtil.SET_COLOR, getResources().getColor(R.color.red_text));
    }

    @Override
    public void setEnableItems(boolean enable) {
        tvDate.setEnabled(enable);
        ivPickerDate.setEnabled(enable);
        spRencanaProduk.setEnabled(enable);
        tvRencanaPlafond.setEnabled(enable);
        tvJangkaWaktu.setEnabled(enable);
        tvKemampuanAngsuran.setEnabled(enable);
        spTujuanPembiayaan.setEnabled(enable);
        tvExum.setEnabled(enable);
        vButtonTambah.setVisibility(enable ? View.VISIBLE : View.GONE);

        for (int i = 0; i < alamatView.getChildCount(); i++) {
            View view = alamatView.getChildAt(i);

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

            if (i < listMapFragment.size()) {
                MapViewFragment fragment = listMapFragment.get(i);
                fragment.setEnableMap(enable);
            }
        }
    }


    @Override
    public void setupView() {
        if (jadwalModels != null && jadwalModels.size() > 0) {
            tvDate.setText(DateUtil.convertDateToNormal(jadwalModels.get(0).getRealisasiPertemuan()));
        }
        if (dataPembiayaanModels != null && dataPembiayaanModels.size() > 0) {
            SurveyDataPembiayaanModel model = dataPembiayaanModels.get(0);
            int posProduk = WidgetUtil.getSpinnerIndexByLabel(spRencanaProduk, model.getNamaProduk());
            spRencanaProduk.setSelection(posProduk);
            tvRencanaPlafond.setText(WidgetUtil.convertToLocalCurrency(model.getRencanaPlafond()));
            tvJangkaWaktu.setText(String.valueOf(model.getJangkaWaktu()));
            tvKemampuanAngsuran.setText(WidgetUtil.convertToLocalCurrency(model.getAngsuranPerbulan()));
            spTujuanPembiayaan.setSelection(WidgetUtil.getSpinnerIndexByLabel(spTujuanPembiayaan, model.getTujuanPembiayaan()));
        }

        if (alamatModels != null) {
            clearAlamat();
            for (ProspekAlamatModel alamatModel : alamatModels) {
                addAlamatItem(alamatModel);
            }
        }

        if (exumModels != null && exumModels.size() > 0) {
            tvExum.setText(exumModels.get(0).getExum());
        }
        setupMode();
    }

    private void clearAlamat() {
        if (alamatView != null) {
            alamatView.removeAllViews();
        }
        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        for (Fragment fragment : listMapFragment) {
            ft.remove(fragment);
        }
        ft.commit();
        listMapFragment.clear();
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
        final Context context = this;
        View view = LayoutInflater.from(this).inflate(R.layout.item_alamat_map, null);
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
                    DialogFactory.showConfirmation(context, "", "Hapus Alamat?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            View container = (View) v.getTag();
                            int idx = alamatView.indexOfChild(container);
                            alamatView.removeView(container);
                            //Remove MapViewFragment
                            if (idx >=0 && idx < listMapFragment.size()) {
                                Fragment fragment = listMapFragment.get(idx);
                                if (fragment != null) {
                                    FragmentManager fragmentManager = getSupportFragmentManager();
                                    FragmentTransaction ft = fragmentManager.beginTransaction();
                                    ft.remove(fragment);
                                    ft.commit();
                                }
                                listMapFragment.remove(idx);
                            }
                        }
                    });
                } else {
                    DialogFactory.showAlert(context, "Alamat tidak bisa dihapus, minimal harus ada satu alamat");
                }
            }
        });

        /*FrameLayout frameLayout = ButterKnife.findById(view, R.id.frame_map);
        if (frameLayout!=null) {
            MapViewFragment mapViewFragment = (MapViewFragment) getSupportFragmentManager().findFragmentById(R.id.frame_map);
            if (mapViewFragment!=null) {
                Log.d("MapViewFragment", "MapViewFragment -> " + mapViewFragment.toString());
            }
        }*/

        final FrameLayout vLayoutMap = ButterKnife.findById(view, R.id.layout_map);
        if (vLayoutMap != null) {
            /*int count = alamatView.getChildCount();
            int containerId = 1000000 + count;
            switch (count) {
                case 0:
                    containerId = R.id.layoutMap0;
                    break;
                case 1:
                    containerId = R.id.layoutMap1;
                    break;
                case 2:
                    containerId = R.id.layoutMap2;
                    break;
                case 3:
                    containerId = R.id.layoutMap3;
                    break;
            }*/

            int containerId = 100000 + CommonUtil.generateViewId();
            FrameLayout viewMap = new FrameLayout(this);
            viewMap.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));
            viewMap.setId(containerId);

            String tag = "fragment_map_" + containerId;
            FragmentManager fragmentManager  = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            try {
                MapViewFragment fragment = new MapViewFragment();
                ft.replace(containerId, fragment, tag);
                //ft.add(containerId, fragment, tag);
                ft.commit();
                ft.addToBackStack(tag);
                vLayoutMap.addView(viewMap);
                if (model != null && model.getLokasiLatitude() != 0 && model.getLokasiLongitude() != 0) {
                    fragment.setMarkerLatlng(new LatLng(model.getLokasiLatitude(), model.getLokasiLongitude()));
                }
                listMapFragment.add(fragment);

                fragment.setListener(new MapViewFragment.OnTouchListener() {
                    @Override
                    public void onTouch() {
                        scrollView.requestDisallowInterceptTouchEvent(true);
                    }
                });
            }catch (Exception e){
                Log.e("ERRROR", e.getMessage());
            }
        }

        final AlamatController alamatController = new AlamatController();

        WidgetUtil.setDataMasterAdapter(spProvinsi,  DataManager.getInstance().getProvinsiModelList());

        spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spProvinsi.getSelectedItem() != null && spProvinsi.getSelectedItem() instanceof ProvinsiModel) {
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
                if (spProvinsi.getSelectedItem() instanceof ProvinsiModel
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
                if (spProvinsi.getSelectedItem() instanceof ProvinsiModel
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
                //if (!isDestroyed()) {
                //    return;
                //}

                if (list == null) {
                    list = new ArrayList<>();
                }
                KabupatenModel modelFirst = new KabupatenModel();
                modelFirst.setNamaKabupaten("Pilih");
                if (!list.contains(modelFirst)) {
                    list.add(0, modelFirst);
                }

                ArrayAdapter<KabupatenModel> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, list);
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
                //if (!isVisible()) {
                //    return;
                //}

                if (list == null) {
                    list = new ArrayList<>();
                }
                KecamatanModel modelFirst = new KecamatanModel();
                modelFirst.setNamaKecamatan("Pilih");
                if (!list.contains(modelFirst)) {
                    list.add(0, modelFirst);
                }

                ArrayAdapter<KecamatanModel> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spKecamatan.setAdapter(adapter);

                if (model != null) {
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
                //if (!isVisible()) {
                //    return;
                //}

                if (list == null) {
                    list = new ArrayList<>();
                }
                KelurahanModel modelFirst = new KelurahanModel();
                modelFirst.setNamaKelurahan("Pilih");
                if (!list.contains(modelFirst)) {
                    list.add(0, modelFirst);
                }

                ArrayAdapter<KelurahanModel> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spKelurahan.setAdapter(adapter);

                if (model != null) {
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
            //if (model.getPrioritas() == 1) {
            //   int posAlamatPrioritas = model.getJenisAlamat();
            //   spAlamatPrioritas.setSelection(posAlamatPrioritas);
            //}

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


        //setupHintView(view);

        if (alamatView.getChildCount() < Constant.MAX_ALAMAT) {
            alamatView.addView(view);
        }
    }

    public void saveData() {
        if (!WidgetUtil.validateField(tvDate, getString(R.string.field_err_msg, "Tanggal Survey"))) {
            return;
        }

        if (!WidgetUtil.validateField(spRencanaProduk, getString(R.string.field_err_msg, "Rencana Produk"))) {
            return;
        }

        if (!WidgetUtil.validateField(tvRencanaPlafond, getString(R.string.field_err_msg, "Rencana Plafond"))) {
            return;
        }

        if (!WidgetUtil.validateField(tvJangkaWaktu, getString(R.string.field_err_msg, "Jangka waktu"))) {
            return;
        }


        //validate jadwal
        String tglSurvey = DateUtil.convertDateToDB(tvDate.getText().toString());
        ProspekJadwalModel jadwalModel = new ProspekJadwalModel();
        jadwalModel.setRealisasiPertemuan(tglSurvey);

        //validate pembiayaan
        SurveyDataPembiayaanModel surveyDataPembiayaanModel = new SurveyDataPembiayaanModel();
        ProdukModel produkModel = null;
        if (spRencanaProduk.getSelectedItem() != null && spRencanaProduk.getSelectedItem() instanceof ProdukModel) {
            produkModel = (ProdukModel) spRencanaProduk.getSelectedItem();
            surveyDataPembiayaanModel.setRencanaProduk(produkModel.getId());
            surveyDataPembiayaanModel.setNamaProduk(produkModel.getNamaProduk());
        }

        if (produkModel == null) {
            WidgetUtil.showToast(this, getString(R.string.field_err_msg, "Rencana Produk"));
            return;
        }

        int rencanaPlafond = 0;
        String sRencanaPlafond = WidgetUtil.getNumberFromField(tvRencanaPlafond);
        try {
            rencanaPlafond = Integer.parseInt(sRencanaPlafond);
        } catch (Exception e) {
        }
        if (rencanaPlafond < produkModel.getPlafondMinimal() || rencanaPlafond > produkModel.getPlafondMaksimal()) {
            WidgetUtil.showToast(this, "Pilih plafond antara " +
                    WidgetUtil.convertToLocalCurrency(produkModel.getPlafondMinimal()) + " sampai "
                    + WidgetUtil.convertToLocalCurrency(produkModel.getPlafondMaksimal()));
            tvRencanaPlafond.requestFocus();
            return;
        }

        int jangkaWaktu = 0;
        try {
            jangkaWaktu = Integer.parseInt(tvJangkaWaktu.getText().toString());
        } catch (Exception e) {
        }

        if (jangkaWaktu < produkModel.getTenorMin() || jangkaWaktu > produkModel.getTenorMax()) {
            WidgetUtil.showToast(this, "Pilih jangka waktu antara" + produkModel.getTenorMin() + " sampai " + produkModel.getTenorMax());
            tvJangkaWaktu.requestFocus();
            return;
        }

        surveyDataPembiayaanModel.setRencanaPlafond(sRencanaPlafond);
        surveyDataPembiayaanModel.setJangkaWaktu(jangkaWaktu);
        surveyDataPembiayaanModel.setAngsuranPerbulan(WidgetUtil.getNumberFromField(tvKemampuanAngsuran));
        surveyDataPembiayaanModel.setTujuanPembiayaan(spTujuanPembiayaan.getSelectedItem().toString());

        //validate alamat
        List<ProspekAlamatModel> alamats = validateAlamat();
        if (alamats == null || alamats.size() == 0) {
            return;
        }

        //validate exum
        ExumModel exumModel = new ExumModel();
        exumModel.setExum(tvExum.getText().toString());


        jadwalModels = new ArrayList<>();
        jadwalModels.add(jadwalModel);

        dataPembiayaanModels = new ArrayList<>();
        dataPembiayaanModels.add(surveyDataPembiayaanModel);

        alamatModels = new ArrayList<>();
        alamatModels.addAll(alamats);

        exumModels = new ArrayList<>();
        exumModels.add(exumModel);

        BiodataModel biodataModel = new BiodataModel();
        biodataModel.setIdSdm(AppPreference.getInstance().getUserLoggedIn().getIdsdm());
        biodataModel.setIdDebitur(mDataModel.getIdDebitur());
        biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
        SurveyDetailRequest request = new SurveyDetailRequest(biodataModel);
        request.setJadwalModels(jadwalModels);
        request.setDataPembiayaanModels(dataPembiayaanModels);
        request.setAlamatModels(alamatModels);
        request.setExumModel(exumModels);

        DialogFactory.showProgress(this);
        controller.saveSurveyDetail(request);

    }

    private List<ProspekAlamatModel> validateAlamat() {
        List<ProspekAlamatModel> mAlamatModel = new ArrayList<>();
        int count = alamatView.getChildCount();
        ArrayList arrJenisAlamat = new ArrayList();
        for (int i = 0; i < count; i++) {
            View view = alamatView.getChildAt(i);

            Spinner spJenisAlamat = ButterKnife.findById(view, R.id.sp_jenis_alamat);
            int idJenisAlamat = spJenisAlamat.getSelectedItemPosition();
            if (idJenisAlamat <= 0 && !WidgetUtil.validateField(spJenisAlamat, getString(R.string.field_err_msg, "Jenis Alamat"))) {
                return null;
            }

            if (arrJenisAlamat.contains(idJenisAlamat)) {
                WidgetUtil.showToast(this, "Pilihan Jenis Alamat tidak boleh sama");
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
            if (!WidgetUtil.validateField(spProvinsi, getString(R.string.field_err_msg, "Provinsi"))) {
                return null;
            }

            Spinner spKota = ButterKnife.findById(view, R.id.spinner_city);
            if (!WidgetUtil.validateField(spKota, getString(R.string.field_err_msg, "Kota/Kabupaten"))) {
                return null;
            }
            Spinner spKecamatan = ButterKnife.findById(view, R.id.spinner_district);
            if (!WidgetUtil.validateField(spKecamatan, getString(R.string.field_err_msg, "Kecamatan"))) {
                return null;
            }
            Spinner spKelurahan = ButterKnife.findById(view, R.id.spinner_subDistrict);
            if (!WidgetUtil.validateField(spKelurahan, getString(R.string.field_err_msg, "Kelurahan"))) {
                return null;
            }

            ProvinsiModel provinsiModel = (ProvinsiModel) spProvinsi.getSelectedItem();
            KabupatenModel kabupatenModel = (KabupatenModel) spKota.getSelectedItem();
            KecamatanModel kecamatanModel = (KecamatanModel) spKecamatan.getSelectedItem();
            KelurahanModel kelurahanModel = (KelurahanModel) spKelurahan.getSelectedItem();

            ProspekAlamatModel model = new ProspekAlamatModel();
            /*if (idJenisAlamat == posAlamatPrioritas) {
                model.setPrioritas(1);
            }*/
            model.setJenisAlamat(idJenisAlamat);
            model.setAlamat(tvAlamat.getText().toString());
            model.setRt(tvRT.getText().toString());
            model.setRw(tvRW.getText().toString());
            model.setKodepos(tvKodepos.getText().toString());
            int lamaBulan = 0;
            try {
                lamaBulan = Integer.parseInt(tvBulan.getText().toString());
            } catch (Exception e) {
            }
            int lamaTahun = 0;
            try {
                lamaTahun = Integer.parseInt(tvTahun.getText().toString());
            } catch (Exception e) {
            }

            model.setLamaMenempatiBulan(lamaBulan);
            model.setLamaMenempatiTahun(lamaTahun);

            if (provinsiModel != null && provinsiModel.getId() != 0) {
                model.setIdProvinsi(provinsiModel.getId());
                model.setNamaProvinsi(provinsiModel.getNamaProvinsi());
            } else {
                WidgetUtil.showToast(this, getString(R.string.field_err_msg, "Provinsi"));
            }

            if (kabupatenModel != null && kabupatenModel.getId() != 0) {
                model.setIdKabupatenKota(kabupatenModel.getId());
                model.setNamaKabupatenKota(kabupatenModel.getNamaKabupaten());
            } else {
                WidgetUtil.showToast(this, getString(R.string.field_err_msg, "Kabupaten/Kota"));
            }

            if (kecamatanModel != null && kecamatanModel.getId() != 0) {
                model.setIdKecamatan(kecamatanModel.getId());
                model.setNamaKecamatan(kecamatanModel.getNamaKecamatan());
            } else {
                WidgetUtil.showToast(this, getString(R.string.field_err_msg, "Kecamatan"));
            }

            if (kelurahanModel != null && kelurahanModel.getId() != 0) {
                model.setIdKelurahan(kelurahanModel.getId());
                model.setNamaKelurahan(kelurahanModel.getNamaKelurahan());
            } else {
                WidgetUtil.showToast(this, getString(R.string.field_err_msg, "Kelurahan"));
            }

            LatLng markerLatlng = null;
            LatLng gpsLatLng = null;
            if (i < listMapFragment.size()) {
                MapViewFragment fragment = listMapFragment.get(i);
                if (fragment != null) {
                    markerLatlng = fragment.getMarkerLatlng();
                    gpsLatLng = fragment.getGpsLatLng();
                }
            }
            if (markerLatlng != null) {
                model.setLokasiLatitude(markerLatlng.latitude);
                model.setLokasiLongitude(markerLatlng.longitude);
            }
            if (gpsLatLng != null) {
                model.setLokasiRealLatitude(markerLatlng.latitude);
                model.setLokasiRealLongitude(markerLatlng.longitude);
            }

            mAlamatModel.add(model);

        }

        /*if(!arrJenisAlamat.contains(posAlamatPrioritas)) {
            WidgetUtil.showToast(getContext(), "Alamat prioritas yang anda pilih tidak ada");
            spAlamatPrioritas.setFocusable(true);
            spAlamatPrioritas.setFocusableInTouchMode(true);
            spAlamatPrioritas.requestFocus();
            return null;
        }*/


        return mAlamatModel;
    }

    @Override
    public void onGetSurveyDetailSuccess(SurveyDetailResponse response) {
        if (response != null) {
            dataPembiayaanModels = response.getDataPembiayaanModels();
            jadwalModels = response.getJadwalModels();
            alamatModels = response.getAlamatModels();
            exumModels = response.getExumModel();
        }
        setupView();
        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetSurveyDetailFailed(Throwable t) {
        DialogFactory.dismissProgress();
        if (!isFinishing()) {
            DialogFactory.showAlert(this, t.getMessage());
        }
    }

    @Override
    public void onSaveSurveyDetailSuccess(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                //changeToViewMode();
                //setResult(RESULT_OK);
                MyApplication.getEventBus().post(new DataStateChanged(true));
                finish();
            }
        });
    }

    @Override
    public void onSaveSurveyDetailFailed(Throwable t) {
        DialogFactory.dismissProgress();
        if (!isFinishing()) {
            DialogFactory.showAlert(this, t.getMessage());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PermissionUtil.REQUEST_PERMISSION_GPS:
                Map<String, Integer> perms = new HashMap<>();
                perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
                perms.put(Manifest.permission.ACCESS_COARSE_LOCATION, PackageManager.PERMISSION_GRANTED);
                for (int i = 0; i < permissions.length; i++) {
                    perms.put(permissions[i], grantResults[i]);
                }

                if ( perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                        && perms.get(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //initMap();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    /*
    private LocationManager locationManager;
    private LatLng markerLatlng;
    private LatLng gpsLatLng;

    private void initGps() {
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        *//*if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            CommonUtil.checkGPSPermission(this);
            return;
        }*//*
        if (!PermissionUtil.isPermissionGpsGranted(this)) {
            PermissionUtil.checkGPSPermission(this);
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 3, gpsListener);

    }

    private LocationListener gpsListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            gpsLatLng = new LatLng(location.getLatitude(), location.getLongitude());
            if (markerLatlng == null) {
                setMarkerPosition(gpsLatLng);
            }

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };*/
}
