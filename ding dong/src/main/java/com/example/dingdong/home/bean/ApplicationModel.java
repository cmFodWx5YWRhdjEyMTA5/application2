package com.example.dingdong.home.bean;

import java.io.Serializable;

/**
 *  应用中心模型
 * Created by CCX on 2017/8/21.
 */
public class ApplicationModel implements Serializable {
    private long id;
    private String logo_url;
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
