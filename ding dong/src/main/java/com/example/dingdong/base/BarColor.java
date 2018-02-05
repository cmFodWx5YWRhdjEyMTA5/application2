package com.example.dingdong.base;

import android.app.Activity;
import android.os.Build;
import android.view.ViewGroup;
import android.view.Window;

/**
 * @auther CCX
 * @date 2018/2/5
 */

public class BarColor {
    public static void setStatusBarColor(Activity activity, int statusColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            EyesLollipop.setStatusBarColor(activity, statusColor);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            EyesKitKat.setStatusBarColor(activity, statusColor);
        }
    }
    static void setContentTopPadding(Activity activity, int padding) {
        ViewGroup mContentView = (ViewGroup) activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
        mContentView.setPadding(0, padding, 0, 0);
    }

}
