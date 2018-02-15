package com.example.dingdong.db.model;

import java.io.Serializable;

/**
 * Created by CCX on 2018/2/15.
 */
public class MessageModel implements Serializable{
    private NewsUserModel newsUserModel;//资讯发布者模型
    private String summarize;//概述
    private   int lastDate;//最后聊时间

    public NewsUserModel getNewsUserModel() {
        return newsUserModel;
    }

    public void setNewsUserModel(NewsUserModel newsUserModel) {
        this.newsUserModel = newsUserModel;
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
    }

    public int getLastDate() {
        return lastDate;
    }

    public void setLastDate(int lastDate) {
        this.lastDate = lastDate;
    }
}
