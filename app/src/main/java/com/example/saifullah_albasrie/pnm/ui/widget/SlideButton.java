package com.example.saifullah_albasrie.pnm.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.SeekBar;

import com.example.saifullah_albasrie.pnm.R;

/**
 * Created by saifullahalbasrie on 4/9/17.
 */

public class SlideButton extends AppCompatSeekBar implements SeekBar.OnSeekBarChangeListener{

    public static final int SLIDE_NORMAL = 0;
    public static final int SLIDE_LEFT = -1;
    public static final int SLIDE_RIGHT = 1;

    private SlideButtonListener listener;

    private int leftColor = Color.parseColor("#EE1221"); //RED
    private int rightColor = Color.parseColor("#12AC02"); //GREEN

    public SlideButton(Context context) {
        super(context);
        init();
    }

    public SlideButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SlideButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initThumb();
        setSecondaryProgress(getMax());
        setOnSeekBarChangeListener(this);
        setCenterPosition();
    }

    private void initThumb() {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics());
        setThumbOffset((int)px);
        setPadding(10,0,10,0);
    }

    public void setLeftColor(int leftColor) {
        this.leftColor = leftColor;
    }

    public void setRightColor(int rightColor) {
        this.rightColor = rightColor;
    }

    @Override
    public void setThumb(Drawable thumb) {
        super.setThumb(thumb);
        initThumb();
    }

    private void handleSlide(int slideType) {
        if(listener != null) {
            listener.handleSlide(slideType);
        }
    }

    public void setCenterPosition() {
        //center position
        setProgress(getMax()/2);
        getProgressDrawable().clearColorFilter();
        clearThumbColorFilter();
    }

    private void setThumbColorFilter(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            //getThumb().setColorFilter(color, PorterDuff.Mode.DARKEN);
            //getThumb().setColorFilter(color, PorterDuff.Mode.OVERLAY);
        }
    }

    private void clearThumbColorFilter() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            //getThumb().clearColorFilter();
        }
    }

    public void setSlideButtonListener(SlideButtonListener listener) {
        this.listener = listener;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //Log.d("SlideButton","onProgressChanged : " + progress);
        int centerValue = getMax() / 2;
        int percentage = 100 * Math.abs(progress - centerValue) / centerValue;
        int alpha = (255 * percentage) / 100;
        //Log.d("", "onProgressChanged--> " + alpha);
        if (progress > centerValue) {
            int color = Color.argb(alpha, Color.red(rightColor), Color.green(rightColor), Color.blue(rightColor));
            setThumbColorFilter(color);
            getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        } else if (progress < centerValue) {
            int color = Color.argb(alpha, Color.red(leftColor), Color.green(leftColor), Color.blue(leftColor));
            setThumbColorFilter(color);
            getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        } else {
            clearThumbColorFilter();
            getProgressDrawable().clearColorFilter();
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //Log.d("SlideButton","onStartTrackingTouch : " + seekBar.getProgress());
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (getProgress() >= (getMax() * 0.75)) {
            setProgress(getMax());
            handleSlide(SLIDE_RIGHT);
        } else if (getProgress() <= (getMax() * 0.25)) {
            setProgress(0);
            handleSlide(SLIDE_LEFT);
        } else {
            setCenterPosition();
            handleSlide(SLIDE_NORMAL);
        }
    }

    public interface SlideButtonListener {
        void handleSlide(int slideType);
    }
}

