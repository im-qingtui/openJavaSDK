package com.cisdi.nudgeplus.sdk.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import sun.misc.BASE64Decoder;


public class JsonUtils {

    private static Gson gson = new Gson();

    public static String beanToJson(Object obj) {
        return gson.toJson(obj);
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
