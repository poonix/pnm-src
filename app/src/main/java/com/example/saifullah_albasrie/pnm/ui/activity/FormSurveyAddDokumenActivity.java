package com.example.saifullah_albasrie.pnm.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyDokumenCallback;
import com.example.saifullah_albasrie.pnm.controller.SurveyDokumenController;
import com.example.saifullah_albasrie.pnm.model.ProspekListItemModel;
import com.example.saifullah_albasrie.pnm.model.SurveyDokumenModel;
import com.example.saifullah_albasrie.pnm.model.annotation.DocumentType;
import com.example.saifullah_albasrie.pnm.model.annotation.FormMode;
import com.example.saifullah_albasrie.pnm.model.annotation.UserType;
import com.example.saifullah_albasrie.pnm.model.state.DataStateChanged;
import com.example.saifullah_albasrie.pnm.ui.adapter.DokumenPagerAdapter;
import com.example.saifullah_albasrie.pnm.ui.factory.DialogFactory;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.Constant;
import com.example.saifullah_albasrie.pnm.utils.ImageUtil;
import com.example.saifullah_albasrie.pnm.utils.PermissionUtil;
import com.example.saifullah_albasrie.pnm.utils.WidgetUtil;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by saifullahalbasrie on 4/21/17.
 */

public class FormSurveyAddDokumenActivity extends BaseFormActivity implements SurveyDokumenCallback{

    protected static final int CAMERA_REQUEST = 11;
    protected static final int GALLERY_REQUEST = 12;
    private final String tempFile = "_temp001.jpg";
    private String fileName;

    private ProspekListItemModel mDataModel;
    private @DocumentType String documentType;

    private SurveyDokumenController controller;
    private List<SurveyDokumenModel> dokumenModelList;
    private List<SurveyDokumenModel> dokumenModelListTemp;
    private DokumenPagerAdapter dokumenPagerAdapter;

    //private Bitmap bitmap;
    //private String selectedImagePath;

    @BindView(R.id.layout_Gallery)
    View layoutGallery;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.button_add_foto)
    View btnAddPhoto;

    @OnClick({R.id.button_add_foto, R.id.iv_left, R.id.iv_right})
    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button_add_foto:
                if (dokumenModelList.size() < Constant.MAX_FOTO) {
                    showCamera();
                } else {
                    WidgetUtil.showToast(this, "Sudah melebihi maksimal foto yang bisa dikirim");
                }
                break;
            case R.id.iv_left:
                goLeft();
                break;
            case R.id.iv_right:
                goRight();
                break;

        }
    }

    public static void navigate(Activity activity, @FormMode int formMode, ProspekListItemModel mDataModel, @DocumentType String documentType) {
        Intent intent = new Intent(activity, FormSurveyAddDokumenActivity.class);
        intent.putExtra(Constant.BUNDLE_FORM_MODE, formMode);
        intent.putExtra(Constant.BUNDLE_DATA, mDataModel);
        intent.putExtra(Constant.BUNDLE_DOCUMENT_TYPE, documentType);
        activity.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_document;
    }


    @Override
    @SuppressWarnings("ResourceType")
    protected void initData() {
        controller = new SurveyDokumenController(this);
        if (getIntent() != null) {
            formMode = getIntent().getIntExtra(Constant.BUNDLE_FORM_MODE, FormMode.NEW);
            mDataModel = getIntent().getParcelableExtra(Constant.BUNDLE_DATA);
            documentType = getIntent().getStringExtra(Constant.BUNDLE_DOCUMENT_TYPE);
        }

        switch (documentType) {
            case DocumentType.PRIBADI:
                setTitle(getString(R.string.dokumen_pribadi));
                break;
            case DocumentType.KELUARGA:
                setTitle(getString(R.string.dokumen_keluarga));
                break;
            case DocumentType.PEMBIAYAAN:
                setTitle(getString(R.string.dokumen_pembiayaan));
                break;
            case DocumentType.PINJAMAN:
                setTitle(getString(R.string.dokumen_pinjaman));
                break;
            case DocumentType.AGUNAN:
                setTitle(getString(R.string.dokumen_agunan));
                break;
        }

        dokumenModelList = new ArrayList<>();
        dokumenModelListTemp = new ArrayList<>();
        dokumenPagerAdapter = new DokumenPagerAdapter(this, dokumenModelList);
        viewPager.setAdapter(dokumenPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        dokumenPagerAdapter.setOnEventClickListener(new DokumenPagerAdapter.OnDocumentEventListener() {
            @Override
            public void onItemClick(View v, int position, SurveyDokumenModel model) {

            }

            @Override
            public void onDeleteClick(View v, int position, SurveyDokumenModel model) {
                onDeleteDokumen(v, position, model);
            }

            @Override
            public void onEditClick(View v, int position, SurveyDokumenModel model) {

            }
        });
    }

    private void onDeleteDokumen(final View view, final int position, final SurveyDokumenModel model) {
        DialogFactory.showConfirmation(this, "", "Hapus Photo ?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (model.isHasUploaded()) {
                    DialogFactory.showProgress(FormSurveyAddDokumenActivity.this);
                    controller.deleteDokumen(position, model);
                } else {
                    dokumenModelList.remove(model);
                    dokumenModelListTemp.remove(model);
                    dokumenPagerAdapter.notifyDataSetChanged();
                    //viewPager.removeView(view);
                    //delete file
                    CommonUtil.deleteFoto(model.getLocalFile());
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (controller != null) {
            controller.setCallback(null);
            controller.cancel();
        }
        super.onDestroy();
    }

    @Override
    protected void loadData() {
        if (mDataModel != null) {
            DialogFactory.showProgress(this);
            controller.getSurveyDokumen(mDataModel.getIdDebitur(), mDataModel.getIdTransaksiDebitur(), documentType);
        }
    }

    @Override
    protected void setEnableItems(boolean enable) {
        btnAddPhoto.setEnabled(enable);
        if (AppPreference.getInstance().getUserType() == UserType.ANALIS) {
            if (enable) {
                btnAddPhoto.setVisibility(View.VISIBLE);
            } else {
                btnAddPhoto.setVisibility(View.GONE);
            }
        } else {
            btnAddPhoto.setVisibility(View.GONE);
        }

        dokumenPagerAdapter.setEditMode(enable);
        dokumenPagerAdapter.notifyDataSetChanged();
    }

    @Override
    protected void setupView() {
        dokumenModelList.clear();
        //dokumenModelList.addAll(dokumenModelListTemp);
        //cloning data and do not referencing the object or list
        for (SurveyDokumenModel model : dokumenModelListTemp) {
            dokumenModelList.add(new SurveyDokumenModel(model));
        }

        if (dokumenModelList.size() > 0) {
            layoutGallery.setVisibility(View.VISIBLE);
        } else {
            layoutGallery.setVisibility(View.GONE);
        }
        dokumenPagerAdapter.notifyDataSetChanged();
    }

    private void showCamera() {
        if (PermissionUtil.isPermissionStorageGranted(this)) {
            DialogFactory.showTakePictureDialog(this, new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        showCameraIntent();
                    } else {
                        showGalleryIntent();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } else {
            PermissionUtil.checkPermissionStorage(this);
        }
    }


    private void showCameraIntent() {
        if (PermissionUtil.isPermissionStorageGranted(this)) {
            fileName = CommonUtil.createFotoFileName(mDataModel.getIdDebitur());
            File file = new File(Environment.getExternalStorageDirectory(), tempFile);
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
            //startActivityForResult(intent, CAMERA_REQUEST);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Context context = MyApplication.getContext();
                Uri uri = FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            } else {
                Uri uri = Uri.fromFile(file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            }
            startActivityForResult(intent, CAMERA_REQUEST);
        }
    }

    private void showGalleryIntent() {
        if (PermissionUtil.isPermissionStorageGranted(this)) {
            fileName = CommonUtil.createFotoFileName(mDataModel.getIdDebitur());
            Intent pictureActionIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pictureActionIntent, GALLERY_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap;
        String selectedImagePath;

        if (resultCode == RESULT_OK && requestCode == CAMERA_REQUEST) {
            File f = new File(Environment.getExternalStorageDirectory().toString());
            for (File temp : f.listFiles()) {
                if (temp.getName().equals(tempFile)) {
                    f = temp;
                    break;
                }
            }

            if (!f.exists()) {
                WidgetUtil.showToast(this, "Error capture photo");
                return;
            }

            try {

                selectedImagePath = f.getAbsolutePath();
                bitmap = BitmapFactory.decodeFile(selectedImagePath);
                bitmap = ImageUtil.getResizedBitmap(bitmap, Constant.MAX_FOTO_SIZE);

                selectedImagePath = CommonUtil.getOrCreateFotoFolder() + File.separator + fileName;
                CommonUtil.saveFotoToDisk(bitmap, selectedImagePath);

                addPhotoModel(bitmap, selectedImagePath);

            } catch (Exception e) {
                e.printStackTrace();
                WidgetUtil.showToast(this, "Terjadi kesalahan, foto tidak berhasil");
            }

        } else if (resultCode == RESULT_OK && requestCode == GALLERY_REQUEST) {
            if (data != null) {

                Uri selectedImage = data.getData();
                String[] filePath = { MediaStore.Images.Media.DATA };
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                selectedImagePath = c.getString(columnIndex);
                c.close();

                bitmap = BitmapFactory.decodeFile(selectedImagePath);
                bitmap = ImageUtil.getResizedBitmap(bitmap, Constant.MAX_FOTO_SIZE);

                selectedImagePath = CommonUtil.getOrCreateFotoFolder() + File.separator + fileName;
                CommonUtil.saveFotoToDisk(bitmap, selectedImagePath);

                addPhotoModel(bitmap, selectedImagePath);

            }
        }

    }

    private void goLeft() {
        int pos = viewPager.getCurrentItem();
        if (pos > 0) {
            pos--;
        }
        viewPager.setCurrentItem(pos);
    }

    private void goRight() {
        int pos = viewPager.getCurrentItem();
        if (pos < dokumenModelList.size() -1) {
            pos++;
        }
        viewPager.setCurrentItem(pos);
    }

    private void addPhotoModel(Bitmap bitmap, String path) {
        SurveyDokumenModel model = new SurveyDokumenModel();
        model.setIdDebitur(mDataModel.getIdDebitur());
        model.setIdTransaksiDebitur(mDataModel.getIdTransaksiDebitur());
        model.setJenisDokumen(documentType);
        model.setBitmap(bitmap);
        String filename = path.substring(path.lastIndexOf(File.separator)+1);
        model.setNamaFile(filename);
        model.setLocalFile(path);
        model.setKeterangan("Keterangan");
        model.setHasUploaded(false);
        dokumenModelList.add(model);
        dokumenPagerAdapter.notifyDataSetChanged();
        viewPager.setCurrentItem(dokumenModelList.size()-1);
        layoutGallery.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case PermissionUtil.REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showCamera();
                } else {
                    finish();
                }
                break;
        }
    }

    @Override
    protected void saveData() {
        if (dokumenModelList.size() > 0) {
            DialogFactory.showProgress(this);
            controller.uploadSurveyDokumen(dokumenModelList);
        } else {
            WidgetUtil.showToast(this, "Dokumen tidak ada");
        }
    }


    @Override
    public void onGetSurveyDokumenSuccess(List<SurveyDokumenModel> dokumenModels) {
        /*dokumenModelList.clear();
        if (dokumenModels != null && dokumenModels.size() > 0) {
            dokumenModelList.addAll(dokumenModels);
            layoutGallery.setVisibility(View.VISIBLE);
            changeToViewMode();
        } else {
            layoutGallery.setVisibility(View.GONE);
            changeToNewMode();
        }
        dokumenPagerAdapter.notifyDataSetChanged();
        */

        dokumenModelListTemp.clear();
        if (dokumenModels != null && dokumenModels.size() > 0) {
            dokumenModelListTemp.addAll(dokumenModels);
            if (formMode != FormMode.READ_ONLY) {
                changeToViewMode();
            }
        } else {
            if (formMode != FormMode.READ_ONLY) {
                changeToNewMode();
            }
        }
        setupView();
        DialogFactory.dismissProgress();
    }

    @Override
    public void onGetSurveyDokumenFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onUploadSurveyDokumenSuccess(SurveyDokumenModel model) {
        if (model != null && !TextUtils.isEmpty(model.getNamaFile())) {
            for (int i = 0; i < dokumenModelList.size(); i++) {
                if (dokumenModelList.get(i).getNamaFile().equals(model.getNamaFile())) {
                    model.setBitmap(dokumenModelList.get(i).getBitmap());
                    dokumenModelList.set(i, model);
                    break;
                }
            }
            //dokumenPagerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onUploadSurveyDokumenFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onUploadSurveyDokumenCompleted(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                MyApplication.getEventBus().post(new DataStateChanged(true));
                finish();
            }
        });

    }

    @Override
    public void onDeleteSurveyDokumenSuccess(int position, SurveyDokumenModel model) {
        DialogFactory.dismissProgress();
        //DialogFactory.showAlert(this, "Dokumen berhasil dihapus");
        dokumenModelList.remove(model);
        dokumenModelListTemp.remove(model);
        dokumenPagerAdapter.notifyDataSetChanged();

        if(dokumenModelList.size() == 0) {
            layoutGallery.setVisibility(View.GONE);
            changeToNewMode();
        }
        MyApplication.getEventBus().post(new DataStateChanged(true));
    }

    @Override
    public void onDeleteSurveyDokumenFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }
}
