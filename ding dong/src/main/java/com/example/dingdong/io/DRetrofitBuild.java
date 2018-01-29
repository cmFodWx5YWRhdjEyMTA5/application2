package com.example.dingdong.io;

import com.alibaba.fastjson.JSONObject;
import com.example.dingdong.common.URLConstants;
import com.example.dingdong.io.bean.NetResultBean;
import com.example.dingdong.unit.StringUtils;

import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

/**
 * Created by CCX on 2017/7/2.
 */
public class DRetrofitBuild {
    private static DRetrofitBuild dRetrofitBuild;
    private static Retrofit retrofit;
    public static DService dService;

    private DRetrofitBuild() {
        initRetrofit();

    }
    /**
     * 获取DRetrofitBuild 实例
     *
     * @return
     */
    public static DRetrofitBuild getInstance() {
        if (dRetrofitBuild == null) {
            dRetrofitBuild = new DRetrofitBuild();
        }
        return dRetrofitBuild;
    }

    /**
     * 获取 Retrofit 实例
     */
    private void initRetrofit() {
        synchronized (DRetrofitBuild.class) {
            if (retrofit == null) {
                OkHttpClient.Builder okHttpClientBuilder= new OkHttpClient().newBuilder();
                okHttpClientBuilder.addInterceptor(new CommonParamsInterceptor());
                retrofit = new Retrofit.Builder().baseUrl(
                        URLConstants.CONNECTION_ADDRESS_API)
                        .client(okHttpClientBuilder.build())
                        .addConverterFactory(FastJsonConverterFactory.create()).build();
            }
            dService = retrofit.create(DService.class);
        }
    }

    private void getResultForNet(String url, Map<String, Object> param){
        dService.getBeanResultForNet(url,param).enqueue(new Callback<NetResultBean>() {
            @Override
            public void onResponse(Call<NetResultBean> call, Response<NetResultBean> response) {
                if(response!=null){
                    NetResultBean netResultBean=response.body();
                }
            }

            @Override
            public void onFailure(Call<NetResultBean> call, Throwable t) {

            }
        });
    }

    private void postResultForNet(String url, Map<String, Object> param, final NetResponseBack.StringJsonListener StringList, NetResponseBack.ErrorListener errorListener) {
        dService.postBeanResultForNet(url, param).enqueue(new Callback<NetResultBean>() {
            @Override
            public void onResponse(Call<NetResultBean> call, Response<NetResultBean> response) {
                if (response != null) {
                     NetResultBean netResultBean=response.body();
                    if(netResultBean!=null){
                        StringList.equals(netResultBean.getData());
                    }
                }
            }

            @Override
            public void onFailure(Call<NetResultBean> call, Throwable t) {
                if(t!=null){

                }
            }
        });
    }

    public void  postJsonResultForNet(String url, Map<String, Object> param,final NetResponseBack.JsonListener jsonListener, NetResponseBack.ErrorListener errorListener){
        postResultForNet(url,param,new NetResponseBack.StringJsonListener(){
            @Override
            public void onResponse(String jsonObjectStr) {
                if(StringUtils.isBlank(jsonObjectStr)){
                    jsonListener.onResponse(JSONObject.parseObject(jsonObjectStr));
                }
            }
        },errorListener);
    }
}






