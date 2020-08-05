package com.cisdi.nudgeplus.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public final class OAuthUtil {

    public static String getOauthPath(String appId, String path) throws UnsupportedEncodingException {
        String encodedPath = URLEncoder.encode(path, StandardCharsets.UTF_8.name());
        return NudgePlusConfig.getProperty("baseURL")
            + "/oauth2/authorize?appid=" + appId
            + "&redirect_uri=" + encodedPath;
    }

    private OAuthUtil() {
    }
}
