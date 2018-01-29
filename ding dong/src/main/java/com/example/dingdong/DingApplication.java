package com.example.dingdong;

import android.app.Application;
import android.content.Context;

/**
 * Created by CCX on 2017/7/5.
 */
public class DingApplication extends Application {
    private static DingApplication dingApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        dingApplication=this;
    }

    public static Context getContext(){
       return  dingApplication.getApplicationContext();
    }
}
