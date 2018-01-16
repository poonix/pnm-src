package com.example.saifullah_albasrie.pnm.controller;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;

import com.example.saifullah_albasrie.pnm.MyApplication;
import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.callback.SurveyDokumenCallback;
import com.example.saifullah_albasrie.pnm.model.SurveyDokumenModel;
import com.example.saifullah_albasrie.pnm.rest.RestHelper;
import com.example.saifullah_albasrie.pnm.rest.RestService;
import com.example.saifullah_albasrie.pnm.rest.response.BaseResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDokumenResponse;
import com.example.saifullah_albasrie.pnm.rest.response.SurveyDokumenUploadResponse;
import com.example.saifullah_albasrie.pnm.utils.preference.AppPreference;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saifullahalbasrie on 3/29/17.
 */

public class SurveyDokumenController {

    private final String LOG_TAG = SurveyDokumenController.class.getSimpleName();

    private SurveyDokumenCallback callback;

    private RestService service = RestHelper.getInstance().getRestService();

    private Call<SurveyDokumenResponse> call;
    private Call<BaseResponse> callSubmit;

    public SurveyDokumenController(SurveyDokumenCallback callback) {
        this.callback = callback;
    }

    public void setCallback(SurveyDokumenCallback callback) {
        this.callback = callback;
    }

    public void getSurveyDokumen(String idDebitur, String idTransaksi, String jenisDokumen) {
        call = service.getSurveyDokumen(idDebitur, idTransaksi, jenisDokumen);
        call.enqueue(new Callback<SurveyDokumenResponse>() {
            @Override
            public void onResponse(Call<SurveyDokumenResponse> call, Response<SurveyDokumenResponse> response) {
                Log.d(LOG_TAG, "getSurveyDokumen.onResponse " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onGetSurveyDokumenSuccess(response.body().getDokumenModelList());
                        } else {
                            callback.onGetSurveyDokumenFailed(new Throwable(errMsg));
                        }
                    } else {
                        if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                            callback.onGetSurveyDokumenSuccess(null);
                        } else {
                            callback.onGetSurveyDokumenFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed)));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SurveyDokumenResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getSurveyDokumen.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetSurveyDokumenFailed(new Throwable(MyApplication.getContext().getString(R.string.data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    private static final Object LOCK = new Object();
    private List<Call> queue = new ArrayList<>();

    public void uploadSurveyDokumen(List<SurveyDokumenModel> models) {
        synchronized (LOCK) {
            queue.clear();
        }

        for (SurveyDokumenModel model : models) {
            uploadSurveyDokumen(model);
        }
    }

    private void uploadSurveyDokumen(SurveyDokumenModel model) {
        try {
            RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), "");
            MultipartBody.Part body = MultipartBody.Part.createFormData("uploaded_file", "", requestFile);
            if (!model.isHasUploaded() && !TextUtils.isEmpty(model.getLocalFile())) {
                //Using direct file
                //File file = new File(model.getLocalFile());
                //requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
                //Using bitmap and convert to byte array
                try {
                    Bitmap bmp = model.getBitmap();
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    requestFile = RequestBody.create(MediaType.parse("image/jpg"), byteArray);
                } catch (Exception e) {
                    File file = new File(model.getLocalFile());
                    requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
                }
                body = MultipartBody.Part.createFormData("uploaded_file", model.getNamaFile(), requestFile);
            }

            // add another field
            RequestBody idSdm = RequestBody.create(MediaType.parse("text/plain"), AppPreference.getInstance().getUserLoggedIn().getIdsdm());
            RequestBody idDebitur = RequestBody.create(MediaType.parse("text/plain"), model.getIdDebitur());
            RequestBody idTransaksi = RequestBody.create(MediaType.parse("text/plain"), model.getIdTransaksiDebitur());
            RequestBody idDokumen = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(model.getId()));
            RequestBody jenisDokumen = RequestBody.create(MediaType.parse("text/plain"), model.getJenisDokumen());
            //RequestBody namaFile = RequestBody.create(MediaType.parse("text/plain"), model.getNamaFile());
            RequestBody keterangan = RequestBody.create(MediaType.parse("text/plain"), model.getKeterangan());

            Call call = service.uploadDokumen(body, idSdm, idDebitur, idTransaksi, idDokumen, jenisDokumen, keterangan);
            synchronized (LOCK) {
                queue.add(call);
            }

            call.enqueue(new Callback<SurveyDokumenUploadResponse>() {
                @Override
                public void onResponse(Call<SurveyDokumenUploadResponse> call, Response<SurveyDokumenUploadResponse> response) {
                    Log.d(LOG_TAG, "uploadSurveyDokumen.onResponse " + (response != null ? response.body() : ""));
                    if (callback != null) {
                        if (response != null && response.body() != null) {
                            String statusMsg = response.body().getStatus();
                            if (response.body().isSuccessResponse()) {
                                callback.onUploadSurveyDokumenSuccess(response.body().getDokumenModel());
                                onUploadResponse(call, true, statusMsg);
                            } else {
                                //callback.onUploadSurveyDokumenFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + statusMsg));
                                onUploadResponse(call, false, MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + statusMsg);
                            }
                        } else {
                            //callback.onUploadSurveyDokumenFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                            onUploadResponse(call, false, MyApplication.getContext().getString(R.string.save_data_failed));
                        }
                    }
                }

                @Override
                public void onFailure(Call<SurveyDokumenUploadResponse> call, Throwable t) {
                    Log.d(LOG_TAG, "uploadSurveyDokumen.onFailure " + (t != null ? t.getMessage() : ""));
                    /*if (callback != null) {
                        callback.onUploadSurveyDokumenFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                    }*/

                    onUploadResponse(call, false, MyApplication.getContext().getString(R.string.save_data_failed) + "\n" + (t != null ? t.getMessage() : ""));
                }
            });
        }catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
            /*if (callback != null) {
                callback.onUploadSurveyDokumenFailed(new Throwable(MyApplication.getContext().getString(R.string.upload_failed)));
            }*/

            onUploadResponse(call, false, MyApplication.getContext().getString(R.string.upload_failed) + "\n" + e.getMessage());
        }
    }

    private void onUploadResponse(Call call, boolean success, String message) {
        if (success) {
            synchronized (LOCK) {
                queue.remove(call);
                if (queue.size() == 0 && callback != null) {
                    callback.onUploadSurveyDokumenCompleted(message);
                }
            }
        } else {
            synchronized (LOCK) {
                queue.remove(call);
                if (call.isCanceled()) {
                    return;
                }

                for (Call item : queue) {
                    item.cancel();
                }

                if (callback != null) {
                    callback.onUploadSurveyDokumenFailed(new Throwable(message));
                }
            }
        }
    }

    public void deleteDokumen(final int posIndex, final SurveyDokumenModel model) {
        callSubmit = service.deleteSurveyDokumen(model.getId(), model.getNamaFile());
        callSubmit.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                Log.d(LOG_TAG, "deleteDokumen.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onDeleteSurveyDokumenSuccess(posIndex, model);
                        } else {
                            callback.onDeleteSurveyDokumenFailed(new Throwable(MyApplication.getContext().getString(R.string.delete_data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onDeleteSurveyDokumenFailed(new Throwable(MyApplication.getContext().getString(R.string.delete_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.d(LOG_TAG, "deleteDokumen.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onDeleteSurveyDokumenFailed(new Throwable(MyApplication.getContext().getString(R.string.delete_data_failed) + "\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
        if (callSubmit != null)
            callSubmit.cancel();
    }
}
