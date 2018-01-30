package com.example.dingdong.db.model;

import java.io.Serializable;

/**
 * @auther CCX
 * @date 2018/1/30
 * 资讯发布者信息
 */

public class NewsUserModel implements Serializable{
    private long userId;//发布者id
    private String userName;//发布者名称
    private boolean isVip;//是否是vip
    private String headPortrait;//头像

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}
