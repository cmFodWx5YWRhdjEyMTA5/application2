package com.example.dingdong.db.model;

import java.io.Serializable;

/**
 * 群组对象
 * Created by CCX on 2018/2/15.
 */
public class MessageModel implements Serializable{
    private NewsUserModel newsUserModel;//资讯发布者模型
    private String groupName;//群聊名称
    private String summarize;//概述
    private   int lastDate;//最后聊时间
    private String linkKey;//群组link key
    private boolean isMultiPrv;//是否是群聊

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

    public String getLinkKey() {
        return linkKey;
    }

    public void setLinkKey(String linkKey) {
        this.linkKey = linkKey;
    }

    public boolean isMultiPrv() {
        return isMultiPrv;
    }

    public void setMultiPrv(boolean multiPrv) {
        isMultiPrv = multiPrv;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
