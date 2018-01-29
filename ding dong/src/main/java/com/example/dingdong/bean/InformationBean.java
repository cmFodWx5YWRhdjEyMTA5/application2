package com.example.dingdong.bean;

import java.io.Serializable;

/**
 * @auther CCX
 * @date 2018/1/26
 */

public class InformationBean implements Serializable{
    private long id;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
