package com.example.dingdong.io;

import com.alibaba.fastjson.JSONObject;

/**
 * 网络回到接口
 * Created by CCX on 2017/7/6.
 */
public class NetResponseBack {

    public interface StringJsonListener{
        void  onResponse(String jsonObjectStr);
    }

    public interface JsonListener{
       void  onResponse(JSONObject jsonObject);
    }

    public interface ErrorListener{
        void onErrorResponse(String errorResponse);
    }
}
