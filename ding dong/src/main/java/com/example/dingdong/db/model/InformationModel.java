package com.example.dingdong.db.model;

import java.io.Serializable;

/**
 * @auther CCX
 * @date 2018/1/26
 * 资讯bean 对象
 */

public class InformationModel implements Serializable{
    private long id;//资讯id
    private String message;//资讯信息
    private String[] imageUrls;//展示图片
    private NewsUserModel newsUserModel;//资讯发布者模型
    private long createDate;//创建时间
    private String address;//创建地址
    private String classify;//分类
    private String specificGoods;//具体物品
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

    public NewsUserModel getNewsUserModel() {
        return newsUserModel;
    }

    public void setNewsUserModel(NewsUserModel newsUserModel) {
        this.newsUserModel = newsUserModel;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getSpecificGoods() {
        return specificGoods;
    }

    public void setSpecificGoods(String specificGoods) {
        this.specificGoods = specificGoods;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }
}
