package com.example.dingdong.unit;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.dingdong.DingApplication;

/**
 * Created by CCX on 2017/7/5.
 */
public class PreferencesUtils {
    private static final String PREFERENCE_NAME_PRIVATE = "dingD_private";//偏好缓存文件名（私有）
    private static final String PREFERENCE_NAME_PUBLIC = "dingD__public";//偏好缓存文件名（提供外部访问）

    public interface SharePreferenceKeyParams {
        /**
         * token 标志
         */
        String DINGD_TOKEN = "dingD_token";

        /**
         * tokensecret 标志
         */
        String DINGD_TOKEN_SECRET = "dingD_tokensecret";
    }

    public static Object getPreferencesValue(String key, Object defaultObject){
        SharedPreferences  sharedPreferences=   getSharedPreferences();
        if (defaultObject instanceof String) {
            return sharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defaultObject);
        }else {
            return StringUtils.EMPTY;
        }
    }

    public static void putPreferencesValue(String key, Object  object){
        SharedPreferences sp = getSharedPreferences();
        SharedPreferences.Editor editor=  sp.edit();
        if(object instanceof String ){
            editor.putString(key,(String)object);
        }else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            if (object != null)
                editor.putString(key, object.toString());
        }
        editor.apply();
    }

    private static SharedPreferences getSharedPreferences(){
        SharedPreferences sharedPreferences= DingApplication.getContext().getSharedPreferences(PREFERENCE_NAME_PRIVATE, Context.MODE_PRIVATE);
        return sharedPreferences;

    }
}
