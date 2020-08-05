package com.cisdi.nudgeplus.sdk.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public final class JsonUtils {

    private static Gson gson = new Gson();
    private static Gson snakeGson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        snakeGson = gsonBuilder.create();
    }

    public static String beanToJson(Object obj) {
        return gson.toJson(obj);
    }

    public static String beanToSnakeJson(Object object) {
        return snakeGson.toJson(object);
    }

    public static <T> T jsonToBean(String json, Class<T> cls) {
        return gson.fromJson(json, cls);
    }

    public static <T> T snakeJsonToBean(String json, Class<T> cls) {
        return snakeGson.fromJson(json, cls);
    }

    private JsonUtils() {
    }

}
