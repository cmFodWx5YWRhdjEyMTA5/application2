package com.example.dingdong.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by CCX on 2017/6/19.
 */
public class MyService extends Service {
private MyBind myBind=new MyBind();
    @Override
    public void onCreate() {
        super.onCreate();
//        Log.d("onCreate","onCreate");
//        Notification notification=new Notification();
//        Intent notificationIntent = new Intent(this, WelcomeActivity.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
//                notificationIntent, 0);
//        notification.t(this, "这是通知的标题", "这是通知的内容",
//                pendingIntent);
//        startForeground(1,notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("onStartCommand","onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    private void detailMessage(){

    }

    @Override
    public void onDestroy() {
        Log.d("onDestroy","onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBind;
    }

    public class MyBind extends Binder{

    }
}
