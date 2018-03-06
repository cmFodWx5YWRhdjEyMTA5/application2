package com.example.dingdong.animator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;

/**
 * 旋转动画
 * @auther CCX
 * @date 2018/3/2
 */

public class RotateAnimator  {
    private ObjectAnimator objectAnimator;
    private View view;
    private float  radian;
    public RotateAnimator(View view,float radian){
        this.view=view;
        this.radian=radian;
    }

    public void startAnimator(){
        objectAnimator=ObjectAnimator.ofFloat(view,"rotation",0,radian);
        objectAnimator.setDuration(300);//播放时间间隔
        objectAnimator.setRepeatCount(0);//播放次数
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);//正序播放
        objectAnimator.start();
        // 启动动画
    }

    public void recoverAnimator(){
        objectAnimator=ObjectAnimator.ofFloat(view,"rotation",radian,0);
        objectAnimator.setDuration(300);//播放时间间隔
        objectAnimator.setRepeatCount(0);//播放次数
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);//正序播放
        objectAnimator.start();
        // 启动动画
    }
}
