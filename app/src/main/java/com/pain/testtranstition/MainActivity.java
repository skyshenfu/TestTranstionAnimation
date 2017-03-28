package com.pain.testtranstition;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    //用来控制下面三个颜色的方块进行场景切换的按钮
    Button button;
    //用来控制下面三个颜色的方块进行场景切换的一个变量
    boolean a;
    Button scaleAndPushButton;
    Button fadeButton;
    //场景的根视图
    FrameLayout frameLayout;
    //享元模式的ImageView
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        fadeButton= (Button) findViewById(R.id.button_fade);
        scaleAndPushButton= (Button) findViewById(R.id.button_scaleandpush);
        imageView= (ImageView) findViewById(R.id.image_view);
        frameLayout= (FrameLayout) findViewById(R.id.root_alyout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initChange();
            }
        });
        scaleAndPushButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initScaleAndPush();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTransShare();
            }
        });
        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTrans();
            }
        });

    }

    /**
     * 只是个开启逻辑有区别，和享元模式一样，不建议用作大多数情况，因为只支持api21+
     * 另外具体动画逻辑实在目标Activity中实现的
     */
    @TargetApi(21)
    private void initTrans() {
        Intent intent=new Intent(this,TransActivity.class);

        if(Build.VERSION.SDK_INT >= 21){
            startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }else {
            startActivity(intent);
        }
    }

    /**
     * 享元模式要求如下：calling和called都有一个transName的属性，名字要相同，传入参数第二个为在calling里面有transName的View第三个为transName具体字段
     * 注意，此模式要求API21要进行下版本判断
     */
    @TargetApi(21)
    private void initTransShare() {
        Intent intent=new Intent(this,ShareActivity.class);
        if(Build.VERSION.SDK_INT >= 21){
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,imageView,"share").toBundle());
        }else {
            startActivity(intent);
        }

    }
    /**
     * 此种办法切换场景Activity要求没有使用startActivity（intent，bundle）的那个方法否则效果会被覆盖掉
     */
    private void initScaleAndPush() {
        Intent intent = new Intent(this, PushAndScaleActivity.class);
        startActivity(intent);
    }


    /**
     * 切换场景的具体逻辑
     */
        private void initChange() {
        int id;
        if (!a){
            id=R.layout.scence2;
        }else {
            id=R.layout.scence1;
        }
        Scene scence2=Scene.getSceneForLayout(frameLayout, id, this);
        ChangeBounds changeBounds = new ChangeBounds();
        TransitionManager.go(scence2,changeBounds);
        a=!a;
    }
}
