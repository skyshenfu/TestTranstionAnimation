package com.pain.testtranstition;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by zty
 * 个人github地址：http://www.github.com/skyshenfu
 * 日期：2017/3/27
 * 版本：1.0.0
 * 描述：
 */

public class PushAndScaleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        overridePendingTransition(R.anim.nb_slide_in_from_bottom,R.anim.nb_old_activity_scale_in_to_center);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

    }
}
