package com.example.dingdong.io;

import com.alibaba.fastjson.JSON;
import com.example.dingdong.io.oauth.MapToPostParameterList;
import com.example.dingdong.io.oauth.OAuth;
import com.example.dingdong.io.oauth.OAuthToken;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 *   重写拦截器
 *   添加oAuth
 * Created by CCX on 2017/7/5.
 */
public class CommonParamsInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取到request
        Request request=chain.request();
        //获取到方法
        String method=request.method();
        HashMap<String, Object> rootMap = new HashMap<>();
        //获取到请求地址api
        HttpUrl httpUrlurl = request.url();
        if(method.equals("GET")){
            //通过请求地址(最初始的请求地址)获取到参数列表
            Set<String> parameterNames = httpUrlurl.queryParameterNames();
            for (String key : parameterNames) {  //循环参数列表
                    String oldParamsJson = httpUrlurl.queryParameter(key);
                    if (oldParamsJson != null) {  //因为有的是没有这个p={"page"：0}  而是直接/xxx/index的
//                        HashMap<String, Object> p = JSON.parseObject(oldParamsJson, HashMap.class);  //原始参数
//                        if (p != null) {
//                        for (Map.Entry<String, Object> entry : p.entrySet()) {
                                rootMap.put(key,oldParamsJson);
                        }
            }
        }else if(method.equals("POST")){
            RequestBody requestBody = request.body();
            if (requestBody instanceof FormBody) {
                for (int i = 0; i < ((FormBody) requestBody).size(); i++) {
                    rootMap.put(((FormBody) requestBody).encodedName(i), ((FormBody) requestBody).encodedValue(i));
                }
            } else {
                //buffer流
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);
                String oldParamsJson = buffer.readUtf8();
                rootMap =  JSON.parseObject(oldParamsJson, HashMap.class);  //原始参数
            }

        }
        String url = httpUrlurl.toString();
        int index = url.indexOf("?");
        if (index > 0) {
            url = url.substring(0, index);
        }
        Request newRequest=  request.newBuilder().addHeader("Authorization", getHeaders(method,url,rootMap,null)).build();
        return chain.proceed(newRequest);
    }

    private String getHeaders(String method,String url,Map<String,Object> mParamMap,OAuthToken oauthToken){
        String authorization;
        OAuth oauth=new OAuth("dT0xJmFwcF9pZD03MjY5MzQ4JmFjY2Vzcz1ydw==","6f4e885d30bc03333c89f8ccc1b4e5d2");
        authorization = oauth.generateAuthorizationHeader(method, url, MapToPostParameterList.transformMapToList(mParamMap), oauthToken);
        return authorization;
    }
}
