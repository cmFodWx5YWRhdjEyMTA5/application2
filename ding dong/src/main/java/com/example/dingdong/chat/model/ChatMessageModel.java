
package com.example.dingdong.chat.model;

/**
 * 聊天信息模型
 * Created by hasee on 2017/6/3.
 */
public class ChatMessageModel{
    private long id;

    private long userId;//信息发起人

    private long chatGroupId;//属于那个聊天组

    private String message;//信息

    private double chatDate;//信息发起时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getChatGroupId() {
        return chatGroupId;
    }

    public void setChatGroupId(long chatGroupId) {
        this.chatGroupId = chatGroupId;
    }

    public double getChatDate() {
        return chatDate;
    }

    public void setChatDate(double chatDate) {
        this.chatDate = chatDate;
    }



}
