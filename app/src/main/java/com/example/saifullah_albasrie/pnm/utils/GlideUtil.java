package com.example.saifullah_albasrie.pnm.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.saifullah_albasrie.pnm.R;

import java.io.File;

/**
 * Created by saifullahalbasrie on 4/23/17.
 */

public class GlideUtil {

    public static void loadImage(Context context, ImageView imageView, String url) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                .crossFade()
                .error(R.drawable.no_image_available)
                .into(imageView);
    }

    public static void loadImage(Context context, ImageView imageView, File file) {
        Glide.with(context)
                .load(Uri.fromFile(file))
                .centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                .crossFade()
                .error(R.drawable.no_image_available)
                .into(imageView);
    }
}
