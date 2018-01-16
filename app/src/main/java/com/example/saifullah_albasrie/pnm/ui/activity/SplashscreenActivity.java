package com.example.saifullah_albasrie.pnm.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.example.saifullah_albasrie.pnm.R;
import com.example.saifullah_albasrie.pnm.utils.CommonUtil;
import com.example.saifullah_albasrie.pnm.utils.PermissionUtil;

import java.util.HashMap;
import java.util.Map;

public class SplashscreenActivity extends AppCompatActivity {

    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 1500);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (PermissionUtil.checkGPSPermission(SplashscreenActivity.this)) {
                openMainActivity();
            }
        }
    };

    private void openMainActivity(){
        Intent intent = new Intent(SplashscreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
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
                    openMainActivity();
                } else {
                    //PermissionUtil.checkGPSPermission(this);
                    finish();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }
}
