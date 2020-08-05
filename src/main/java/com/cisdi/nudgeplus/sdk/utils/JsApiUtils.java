package com.cisdi.nudgeplus.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * jsapi工具类
 *
 * @author shizhen
 */
public final class JsApiUtils {

    /**
     * 获取js api加密签名
     */
    public static String getJsApiSignature(String jsApiTicket, String nonceStr, String timestamp, String url) {
        String decodedUrl;

        try {
            decodedUrl = URLDecoder.decode(url, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("url decode fail");
        }

        if (decodedUrl.contains("#")) {
            decodedUrl = decodedUrl.substring(0, decodedUrl.indexOf("#"));
        }

        String mosaicString = "jsapi_ticket=" + jsApiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + decodedUrl;

        return DigestUtils.sha1Hex(mosaicString);

    }

    private JsApiUtils() {
    }
}