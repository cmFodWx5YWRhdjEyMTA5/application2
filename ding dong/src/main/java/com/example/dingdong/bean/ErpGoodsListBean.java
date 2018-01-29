package com.example.dingdong.bean;

import java.io.Serializable;

/**
 * 商品列表模型
 * Created by CCX on 2017/7/11.
 */
public class ErpGoodsListBean implements Serializable{
    private long id;
    private String goodsName;

    public ErpGoodsListBean(long id,String goodsName){
        this.id=id;
        this.goodsName=goodsName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
