package com.cisdi.nudgeplus.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;

/**
 * jsapi工具类
 *
 * @author shizhen
 */
public class JsapiUtils {

    /**
     * 获取jsapi加密签名
     */
    public static String getJsapiSignature(String jsapiTicket, String nonceStr, String timeStamp, String url) {
        String newUrl;
        try {
            newUrl = URLDecoder.decode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("url decode fail");
        }
        if (newUrl.contains("#")) {
            newUrl = newUrl.substring(0, newUrl.indexOf("#"));
        }
        String mosaicString = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timeStamp + "&url=" + newUrl;
        return getSha1(mosaicString);
    }

    /**
     * sha1加密算法
     */
    public static String getSha1(String str) {
        if (null == str || 0 == str.length()) {
            return null;
        }
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));

            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] buf = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            throw new RuntimeException("sha1 fail");
        }
    }
}