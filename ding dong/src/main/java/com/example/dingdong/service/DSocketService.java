package com.example.dingdong.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.dingdong.socket.DSocket;
import com.example.dingdong.socket.DSocketMessageBack;
import org.greenrobot.eventbus.EventBus;
import java.net.URISyntaxException;
/**
 * Created by hasee on 2017/6/3.
 */
public class DSocketService extends Service {
    private DSocket dSocket;

    @Override
    public void onCreate() {
        super.onCreate();
        initDSocket();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void initDSocket(){
        if(dSocket!=null){
            try {
                dSocket=DSocket.getIntense();
                openSocketCommunication();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
    }

    private void openSocketCommunication(){
        dSocket.open(new DSocketMessageBack() {
            @Override
            public void detailResultChatMessage(Object[] obj) {
                if(obj!=null){
//                    ChatMessageModel chatMessageModel=new ChatMessageModel();
//                    EventBus.getDefault().post(chatMessageModel);//socket 收到消息后广播消息
                }
            }
        });
    }

}
