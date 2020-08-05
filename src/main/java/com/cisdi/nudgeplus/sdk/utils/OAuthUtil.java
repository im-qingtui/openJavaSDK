package com.cisdi.nudgeplus.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public final class OAuthUtil {

    public static String getOauthPath(String path) throws UnsupportedEncodingException {
        String encodedPath = URLEncoder.encode(path, StandardCharsets.UTF_8.name());

        return NudgePlusConfig.getEndpoint()
            + "/v1/oauth2/authorize?appid=" + NudgePlusConfig.getAppId()
            + "&redirect_uri=" + encodedPath;
    }

    private OAuthUtil() {
    }
}
