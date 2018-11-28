package com.cisdi.nudgeplus.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class OAuthUtil {

	public static String getOauthPath(String appid, String path) throws UnsupportedEncodingException {
		String encodePath = URLEncoder.encode(path, "UTF-8");
		return NudgePlusConfig.getValue("baseURL") + "/oauth2/authorize?appid=" + appid + "&redirect_uri=" + encodePath;
	}
}
