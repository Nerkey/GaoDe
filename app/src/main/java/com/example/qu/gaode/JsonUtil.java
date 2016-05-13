package com.example.qu.gaode;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonUtil {

    /**
     * 解析Json Object通用类
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        T t = JSON.parseObject(jsonString, clazz);
        return t;
    }

    /**
     * 解析Json List通用类
     *
     * @param jsonString
     * @param clazz
     * @param <T>
     * @returnP
     */
    public static <T> List<T> parseArray(String jsonString, Class<T> clazz) {
        List<T> list = JSON.parseArray(jsonString, clazz);
        return list;
    }

    /**
     * 解析Map
     *
     * @param jsonString
     * @return
     */
    public static JSONObject parseObject(String jsonString) {
        JSONObject jsonObject = JSON.parseObject(jsonString);
        return jsonObject;
    }


}
