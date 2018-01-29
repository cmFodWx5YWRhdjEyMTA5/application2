package com.example.dingdong.chat;

import android.os.Bundle;

import com.example.dingdong.chat.model.ChatMessageModel;
import com.example.dingdong.base.BaseActivity;
import com.example.dingdong.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by hasee on 2017/4/23.
 */
public class ChatDetailActivity extends BaseActivity {
    @Override
    public int initLayout() {
        return R.layout.dd_chat_detail_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ChatMessageModel chatMessageModel){
            if(chatMessageModel!=null){

            }
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
