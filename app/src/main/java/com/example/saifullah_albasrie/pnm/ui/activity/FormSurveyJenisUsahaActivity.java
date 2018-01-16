package com.example.saifullah_albasrie.pnm.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyJenisUsahaCallback;
import com.example.saifullah_albasrie.pnm.controller.SurveyJenisUsahaController;
import com.example.saifullah_albasrie.pnm.data.DataManager;
import com.example.saifullah_albasrie.pnm.model.BiodataModel;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyJenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.master.JenisProdukUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.JenisUsahaModel;
import com.example.saifullah_albasrie.pnm.model.master.PengelolaanKeuanganModel;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.ui.customview.WorkaroundMapFragment;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.PermissionUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;

/**
 * Created by aldhiramdan on 4/2/17.
 */

public class FormSurveyJenisUsahaActivity extends BaseFormActivity implements OnMapReadyCallback, SurveyJenisUsahaCallback {

    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;

    private final String LOG_TAG = FormSurveyJenisUsahaActivity.class.getSimpleName();

    private ProspekListItemModel mDataModel;
    private SurveyJenisUsahaController controller;
    private SurveyJenisUsahaModel surveyJenisUsahaModel;

    private GoogleMap googleMap;

    private LocationManager locationManager;
    private LatLng markerLatlng;
    private LatLng gpsLatLng;

    @BindView(R.id.sv_form_jenis_usaha)
    ScrollView scrollViewMain;

    @BindView(R.id.spinner_bidang_usaha_debitur)
    Spinner spBidangUsahaDebitur;
    @BindView(R.id.spinner_jenis_produk)
    Spinner spJenisProduk;
    @BindView(R.id.spinner_kegiatan_tempat_usaha)
    Spinner spKegiatanTempatUsaha;
    @BindView(R.id.tv_jumlah_tenaga_kerja)
    EditText tvJumlahTenagaKerja;
    //@BindView(R.id.tv_jarak_lokasi_usaha)
    //EditText tvJarakLokasiUsaha;
    @BindView(R.id.spinner_surat_keterangan_usaha)
    Spinner spSuratKetUsaha;
    @BindView(R.id.spinner_bahan_baku)
    Spinner spBahanBaku;
    @BindView(R.id.spinner_jumlah_pemasok)
    Spinner spJumlahPemasok;
    @BindView(R.id.spinner_persaingan_usaha)
    Spinner spPersainganUsaha;
    @BindView(R.id.spinner_kondisi_usaha)
    Spinner spKondisiUsaha;
    @BindView(R.id.spinner_pengelolaan_keuangan)
    Spinner spPengelolaanKeuangan;

    @BindView(R.id.tv_lokasi_usaha)
    EditText tvLokasiUsaha;
    //@BindView(R.id.tv_pengelolaan_usaha)
    //EditText tvPengelolaanUsaha;
    @BindView(R.id.spinner_pengelolaan_usaha)
    Spinner spPengelolaanUsaha;
    @BindView(R.id.tv_aspek_pemasaran)
    EditText tvAspekPemasaran;

    @BindView(R.id.tv_exum)
    EditText tvExum;

    @BindView(R.id.ll_btn_search)
    LinearLayout ll_btn_search;

    public static void navigate(Activity activity, int formMode, ProspekListItemModel mDataModel) {
        Intent intent = new Intent(activity, FormSurveyJenisUsahaActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMap();
        ll_btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAutocompleteActivity();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        CommonUtil.checkGPSEnable(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_form_jenis_usaha;
    }

    private void initMap() {

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        /*if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            CommonUtil.checkGPSPermission(this);
            return;
        }*/
        if (!PermissionUtil.isPermissionGpsGranted(this)) {
            PermissionUtil.checkGPSPermission(this);
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 3, gpsListener);

        WorkaroundMapFragment mapFragment = (WorkaroundMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fm_map);
        mapFragment.getMapAsync(this);
        mapFragment.setListener(new WorkaroundMapFragment.OnTouchListener() {
            @Override
            public void onTouch() {
                scrollViewMain.requestDisallowInterceptTouchEvent(true);
            }
        });
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
                    initMap();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }

    @Override
    public void initData() {
        controller = new SurveyJenisUsahaController(this);
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
        }

        WidgetUtil.setDataMasterAdapter(spBidangUsahaDebitur, DataManager.getInstance().getJenisUsahaModelList());
        WidgetUtil.setDataMasterAdapter(spJenisProduk, DataManager.getInstance().getJenisProdukUsahaModelList());
        WidgetUtil.setDataMasterAdapter(spPengelolaanKeuangan, DataManager.getInstance().getPengelolaanKeuanganModelList());
        WidgetUtil.setDataMasterAdapter(spPengelolaanUsaha, DataManager.getInstance().getPengelolaanUsahaModelList());

    }



    @Override
    public void loadData() {
        if (mDataModel != null) {
            DialogFactory.showProgress(this);
            controller.getSurveyJenisUsaha(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur());
        }
    }

    @Override
    public void setEnableItems(boolean enable) {
        spBidangUsahaDebitur.setEnabled(enable);
        spJenisProduk.setEnabled(enable);
        spKegiatanTempatUsaha.setEnabled(enable);
        tvJumlahTenagaKerja.setEnabled(enable);
        //tvJarakLokasiUsaha.setEnabled(enable);
        spSuratKetUsaha.setEnabled(enable);
        spBahanBaku.setEnabled(enable);
        spJumlahPemasok.setEnabled(enable);
        spPersainganUsaha.setEnabled(enable);
        spKondisiUsaha.setEnabled(enable);
        spPengelolaanKeuangan.setEnabled(enable);
        tvLokasiUsaha.setEnabled(enable);
        //tvPengelolaanUsaha.setEnabled(enable);
        spPengelolaanUsaha.setEnabled(enable);
        tvAspekPemasaran.setEnabled(enable);
        tvExum.setEnabled(enable);

        setEnableMap(enable);
    }

    private void setEnableMap(boolean enable) {
        if (formMode == FormMode.EDIT || formMode == FormMode.NEW) {
            ll_btn_search.setVisibility(View.VISIBLE);
        } else {
            ll_btn_search.setVisibility(View.GONE);
        }
        if (googleMap != null) {
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            googleMap.getUiSettings().setZoomGesturesEnabled(true);
            googleMap.getUiSettings().setRotateGesturesEnabled(enable);
            googleMap.getUiSettings().setMyLocationButtonEnabled(enable);
        }
    }

    @Override
    public void setupView() {
        if(surveyJenisUsahaModel != null) {
            WidgetUtil.setSpinnerSelectionById(spBidangUsahaDebitur, surveyJenisUsahaModel.getIdJenisUsaha());
            WidgetUtil.setSpinnerSelectionById(spJenisProduk, surveyJenisUsahaModel.getIdJenisProdukUsaha());
            WidgetUtil.setSpinnerSelectionById(spKegiatanTempatUsaha, surveyJenisUsahaModel.getKegiatanTempat());
            tvJumlahTenagaKerja.setText(String.valueOf(surveyJenisUsahaModel.getJumlahTenagaKerja()));
            //tvJarakLokasiUsaha.setText(String.valueOf(surveyJenisUsahaModel.getJarakUsahaUlamm()));
            spSuratKetUsaha.setSelection(surveyJenisUsahaModel.getIsMilikiSku());
            WidgetUtil.setSpinnerSelectionById(spBahanBaku, surveyJenisUsahaModel.getKetersediaanBahanBaku());
            WidgetUtil.setSpinnerSelectionById(spJumlahPemasok, surveyJenisUsahaModel.getJumlahPemasok());
            WidgetUtil.setSpinnerSelectionById(spPersainganUsaha, surveyJenisUsahaModel.getPersainganUsaha());
            WidgetUtil.setSpinnerSelectionById(spKondisiUsaha, surveyJenisUsahaModel.getGambaranKondisi());
            WidgetUtil.setSpinnerSelectionById(spPengelolaanKeuangan, surveyJenisUsahaModel.getIdPengelolaanKeuangan());
            //tvLokasiUsaha.setText(String.valueOf(surveyJenisUsahaModel.getLokasiUsahaLatitude()) + ", " + String.valueOf(surveyJenisUsahaModel.getLokasiUsahaLongitude()));
            tvLokasiUsaha.setText(surveyJenisUsahaModel.getAlamatLokasi());
            //tvPengelolaanUsaha.setText(surveyJenisUsahaModel.getPengelolaanUsaha());
            spPengelolaanUsaha.setSelection(WidgetUtil.getSpinnerIndexByLabel(spPengelolaanUsaha, surveyJenisUsahaModel.getPengelolaanUsaha()));
            tvAspekPemasaran.setText(surveyJenisUsahaModel.getAspekPemasaran());
            tvExum.setText(surveyJenisUsahaModel.getExum());

            if (surveyJenisUsahaModel.getLokasiUsahaLatitude() != 0 && surveyJenisUsahaModel.getLokasiUsahaLongitude() != 0) {
                markerLatlng = new LatLng(surveyJenisUsahaModel.getLokasiUsahaLatitude(), surveyJenisUsahaModel.getLokasiUsahaLongitude());
                setMarkerPosition(markerLatlng);
            }

            if (surveyJenisUsahaModel.getLokasiUsahaRealLatitude() != 0 && surveyJenisUsahaModel.getLokasiUsahaRealLongitude() != 0) {
                gpsLatLng = new LatLng(surveyJenisUsahaModel.getLokasiUsahaRealLatitude(), surveyJenisUsahaModel.getLokasiUsahaRealLongitude());
            }

        }
    }

    @Override
    public void saveData() {
        SurveyJenisUsahaModel newModel = new SurveyJenisUsahaModel();
        JenisUsahaModel jenisUsahaModel = (JenisUsahaModel)spBidangUsahaDebitur.getSelectedItem();
        if(jenisUsahaModel != null) {
            newModel.setIdJenisUsaha(jenisUsahaModel.getId());
            newModel.setNamaJenisUsaha(jenisUsahaModel.getNamaJenisUsaha());
        }
        JenisProdukUsahaModel produkUsahaModel = (JenisProdukUsahaModel) spJenisProduk.getSelectedItem();
        if(produkUsahaModel != null) {
            newModel.setIdJenisProdukUsaha(produkUsahaModel.getId());
            newModel.setNamaJenisProdukUsaha(produkUsahaModel.getNamaProdukUsaha());
        }
        newModel.setKegiatanTempat(spKegiatanTempatUsaha.getSelectedItem().toString());
        int jmlTenaga = 0;
        try{
            jmlTenaga = Integer.parseInt(tvJumlahTenagaKerja.getText().toString());
        }catch (Exception e) {}
        newModel.setJumlahTenagaKerja(jmlTenaga);
        /*float jarak = 0;
        try {
            jarak = Float.parseFloat(tvJarakLokasiUsaha.getText().toString());
        }catch (Exception e) {}
        newModel.setJarakUsahaUlamm(jarak);*/
        newModel.setIsMilikiSku(spSuratKetUsaha.getSelectedItemPosition());
        newModel.setKetersediaanBahanBaku(spBahanBaku.getSelectedItem().toString());
        newModel.setJumlahPemasok(spJumlahPemasok.getSelectedItem().toString());
        newModel.setPersainganUsaha(spPersainganUsaha.getSelectedItem().toString());
        newModel.setGambaranKondisi(spKondisiUsaha.getSelectedItem().toString());
        PengelolaanKeuanganModel pengelolaanKeuanganModel = (PengelolaanKeuanganModel) spPengelolaanKeuangan.getSelectedItem();
        if(pengelolaanKeuanganModel != null) {
            newModel.setIdPengelolaanKeuangan(pengelolaanKeuanganModel.getId());
            //model.setNamaPengelolaanKeuangan(pengelolaanKeuanganModel.getDetail());
        }
        //tvLokasiUsaha.setText(String.valueOf(surveyJenisUsahaModel.getLokasiUsahaLatitude()) + ", " + String.valueOf(surveyJenisUsahaModel.getLokasiUsahaLongitude()));
        newModel.setAlamatLokasi(tvLokasiUsaha.getText().toString());
        if (markerLatlng != null) {
            newModel.setLokasiUsahaLatitude(markerLatlng.latitude);
            newModel.setLokasiUsahaLongitude(markerLatlng.longitude);
        }
        if (gpsLatLng != null) {
            newModel.setLokasiUsahaRealLatitude(gpsLatLng.latitude);
            newModel.setLokasiUsahaRealLongitude(gpsLatLng.longitude);
        } else {
            //WidgetUtil.showToast(this, "Lokasi belum berhasil ditemukan");
            //return;
        }
        //newModel.setPengelolaanUsaha(tvPengelolaanUsaha.getText().toString());
        newModel.setPengelolaanUsaha(spPengelolaanUsaha.getSelectedItem().toString());
        newModel.setAspekPemasaran(tvAspekPemasaran.getText().toString());
        newModel.setExum(tvExum.getText().toString());

        surveyJenisUsahaModel = newModel;

        DialogFactory.showProgress(this);
        BiodataModel biodataModel = new BiodataModel();
        biodataModel.setIdSdm(AppPreference.getInstance().getUserLoggedIn().getIdsdm());
        biodataModel.setIdDebitur(mDataModel.getIdDebitur());
        biodataModel.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
        controller.saveSurveyJenisUsaha(biodataModel, surveyJenisUsahaModel);
    }

    @Override
    public void onMapReady(GoogleMap googlemap) {
        this.googleMap = googlemap;
        LatLng markerPosition = new LatLng(-6.1875635, 106.8206277); //Jakarta
        if (markerLatlng != null) {
            markerPosition = markerLatlng;
        }
        setMarkerPosition(markerPosition);

        if (formMode == FormMode.VIEW)
            setEnableMap(false);
        else
            setEnableMap(true);

        /*
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        */
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //googleMap.clear();
                //googleMap.addMarker(new MarkerOptions().position(latLng));
                if (formMode != FormMode.VIEW) {
                    markerLatlng = latLng;
                    setMarkerPosition(latLng);
                }

            }
        });

    }

    private void setMarkerPosition(LatLng markerPosition) {
        if (googleMap != null) {
            googleMap.clear();
            googleMap.addMarker(new MarkerOptions()
                    .position(markerPosition)
                    .title("Tempat Usaha"));

            CameraPosition cameraPosition = CameraPosition.builder()
                    .target(markerPosition)
                    .zoom(16)
                    .bearing(0)
                    .tilt(45)
                    .build();
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1000, null);
            fetchAddress(markerPosition);

        }

    }

    private void fetchAddress(final LatLng mLatLng){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Geocoder gcd = new Geocoder(FormSurveyJenisUsahaActivity.this, Locale.getDefault());
                List<Address> addresses = null;
                try {
                    addresses = gcd.getFromLocation(mLatLng.latitude, mLatLng.longitude, 1);
                    if(tvLokasiUsaha!=null) {
                        if (addresses != null && addresses.size() > 0) {
                            String alamat = addresses.get(0).getAddressLine(0);

                            tvLokasiUsaha.setText(alamat);
                        } else {
                            tvLokasiUsaha.setText("");
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }

    @Override
    public void onGetSurveyJenisUsahaSuccess(SurveyJenisUsahaModel surveyJenisUsahaModel) {
        this.surveyJenisUsahaModel = surveyJenisUsahaModel;
        setupView();
        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetSurveyJenisUsahaFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSaveSurveyJenisUsahaSuccess(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                //setResult(RESULT_OK);
                MyApplication.getEventBus().post(new DataStateChanged(true));
                finish();
            }
        });
    }

    @Override
    public void onSaveSurveyJenisUsahaFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());

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
    };


    private void openAutocompleteActivity() {
        try {
            // The autocomplete activity requires Google Play Services to be available. The intent
            // builder checks this and throws an exception if it is not the case.
            Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                    .build(this);
            startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);
        } catch (GooglePlayServicesRepairableException e) {
            // Indicates that Google Play Services is either not installed or not up to date. Prompt
            // the user to correct the issue.
            GoogleApiAvailability.getInstance().getErrorDialog(this, e.getConnectionStatusCode(),
                    0 /* requestCode */).show();
        } catch (GooglePlayServicesNotAvailableException e) {
            // Indicates that Google Play Services is not available and the problem is not easily
            // resolvable.
            String message = "Google Play Services is not available: " +
                    GoogleApiAvailability.getInstance().getErrorString(e.errorCode);
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Called after the autocomplete activity has finished to return its result.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that the result was from the autocomplete widget.
        if (requestCode == REQUEST_CODE_AUTOCOMPLETE) {
            if (resultCode == RESULT_OK) {
                // Get the user's selected place from the Intent.
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i(LOG_TAG, "Place Selected: " + place.getName());

                if(place!=null) {
                    setMarkerPosition(place.getLatLng());
                    if (tvLokasiUsaha != null) {
                        tvLokasiUsaha.setText(place.getAddress());
                    } else {
                        tvLokasiUsaha.setText("");
                    }
                }

            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                Log.e(LOG_TAG, "Error: Status = " + status.toString());
            } else if (resultCode == RESULT_CANCELED) {
                // Indicates that the activity closed before a selection was made. For example if
                // the user pressed the back button.
            }
        }
    }
}
