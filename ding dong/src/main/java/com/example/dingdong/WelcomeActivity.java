package com.example.dingdong;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.alibaba.fastjson.JSONObject;
import com.example.dingdong.base.BaseActivity;
import com.example.dingdong.common.URLConstants;
import com.example.dingdong.home.HomePageActivity;
import com.example.dingdong.io.NetResponseBack;
import com.example.dingdong.service.MyService;

import java.util.HashMap;
import java.util.Map;
public class WelcomeActivity extends BaseActivity {
    @Override
    public int initLayout() {
        return R.layout.dd_welcome_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

        Intent intent=new Intent();
        intent.setClass(this, HomePageActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void initEvent() {

    }


    private void getUserToken(){
        Map<String,Object> params=new HashMap<>();
        params.put("x_auth_username","18018789281");
        params.put("x_auth_password","123456");
        params.put("x_auth_mode","client_auth");
        dRetrofitBuild.postJsonResultForNet( URLConstants.ACCESS_TOKEN_URL, params, new NetResponseBack.JsonListener() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                if(jsonObject!=null){

                }

            }
        }, new NetResponseBack.ErrorListener() {
            @Override
            public void onErrorResponse(String errorResponse) {

            }
        });
    }
}
