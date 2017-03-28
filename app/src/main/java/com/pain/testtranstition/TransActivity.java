package com.pain.testtranstition;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/3/27
 * 版本：1.0.0
 * 描述：
 */

public class TransActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        setContentView(R.layout.activity_share);
        initAnimation();

    }
    @TargetApi(21)
    private void initAnimation() {
        if (Build.VERSION.SDK_INT>=21){
            Fade fade = new Fade();
            Slide slide=new Slide(Gravity.LEFT);
            getWindow().setEnterTransition(fade);
            getWindow().setAllowEnterTransitionOverlap(false);
            getWindow().setExitTransition(fade);
        }
    }

}
