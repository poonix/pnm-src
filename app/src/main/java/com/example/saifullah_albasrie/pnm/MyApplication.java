package com.example.saifullah_albasrie.pnm;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.crashlytics.android.Crashlytics;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import io.fabric.sdk.android.Fabric;

/**
 * Created by saifullahalbasrie on 3/26/17.
 */

public class MyApplication extends Application {

    private static Context context;
    private static Bus eventBus;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        context = this;
        eventBus = new Bus(ThreadEnforcer.ANY);
        //https://stackoverflow.com/questions/38200282/android-os-fileuriexposedexception-file-storage-emulated-0-test-txt-exposed
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    public static Context getContext() {
        return context;
    }

    public static Bus getEventBus() {
        return eventBus;
    }
}
