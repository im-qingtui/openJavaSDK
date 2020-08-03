package com.cisdi.nudgeplus.sdk.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import sun.misc.BASE64Decoder;


public class JsonUtils {

    private static Gson gson = new Gson();
    private static Gson underLineCaseGson;
    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        underLineCaseGson = gsonBuilder.create();
    }

    public static String beanToJson(Object obj) {
        return gson.toJson(obj);
    }

    public static String beanToUnderLineJson(Object object){
        return underLineCaseGson.toJson(object);
    }

    public static <T> T jsonToBean(String json, Class<T> cls) {
        return gson.fromJson(json, cls);
    }

    public static String getDomainIdByToken(String token) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] tokenByte = decoder.decodeBuffer(token.split("\\.")[1]);
        System.out.println(token.split("\\.")[1]);
        String tokenJson = new String(tokenByte, "UTF-8");
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(tokenJson.substring(0, tokenJson.indexOf("}") + 1));
        return jsonObject.get("domain_id").getAsString();
    }

}
