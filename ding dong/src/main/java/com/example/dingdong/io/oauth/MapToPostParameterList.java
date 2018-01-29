package com.example.dingdong.io.oauth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * @author Peibin
 * @describe
 * @since 2016/1/13
 */
public class MapToPostParameterList {

    public static List<PostParameter> transformMapToList(Map<String,Object> stringObjectMap){
        List<PostParameter> parameters = new ArrayList<>();
        Iterator<Map.Entry<String ,Object>> iterator = stringObjectMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Object> entry = iterator.next();
            Object value = entry.getValue();
            parameters.add(new PostParameter(entry.getKey(), value==null?"":String.valueOf(value)));
        }
        return parameters;
    }
}
