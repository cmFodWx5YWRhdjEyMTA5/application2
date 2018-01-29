package com.example.dingdong.io.bean;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * 网络结果bean
 * Created by CCX on 2017/7/3.
 */
public class NetResultBean implements Serializable{

    private int ret;
    private String time;
    private String data;
    private String msg;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
