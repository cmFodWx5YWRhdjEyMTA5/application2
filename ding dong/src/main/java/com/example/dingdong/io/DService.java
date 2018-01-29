package com.example.dingdong.io;

import com.alibaba.fastjson.JSON;
import com.example.dingdong.common.URLConstants;
import com.example.dingdong.io.bean.NetResultBean;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * 请求地址
 * Created by CCX on 2017/7/2.
 */
public interface DService{
    @GET(URLConstants.GET_API_URL)
    Call<JSON> getDDURL();//获取网络请求数据

    @GET
    Call<NetResultBean> getBeanResultForNet(@Url  String requestUrl, @QueryMap Map<String,Object> param);

    @POST
    Call<NetResultBean> postBeanResultForNet(@Url  String requestUrl, @Body Map<String,Object> param);
}
