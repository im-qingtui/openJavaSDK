package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import com.cisdi.nudgeplus.tmsbeans.beans.TokenResult;
import java.util.HashMap;
import java.util.Map;

public class TokenService {

    /**
     * 缓存的ACCESS_TOKEN
     */
    public static String ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJkb21haW5faWQiOiJmOTRlMGNiZDQ5YTc0YjNmYjFjNzY5M2E5MjM4M2JlOSIsImRpc3BhdGNoIjoxNTk2MDg5MTQxNjc0LCJhcHBpZCI6IjQ4NTY2ODQwNjEiLCJleHBpcmVzX2luIjoxNTk2MDk2MzQxNjc0fQ.a6cu0M04YKP2-rJ_zSEP7ccrU05Q3RXUYNr2CgIy2Qc";

    /**
     * 根据appid和secret刷新缓存的ACCESS_TOKEN,当调用不提供ACCESS_TOKEN的方法时默认使用此方法刷新的ACCESS_TOKEN. 开发者可以定时(2小时以内的周期)调用此方法,以确保ACCESS_TOKEN的长期有效
     *
     * @param appid 平台发放的appid
     * @param secret 平台发放的secret
     */
    public static synchronized void refreshToken(final String appid, final String secret) {
        TokenResult token = null;
        try {
            token = getToken(appid, secret);
        } catch (IllegalRequestException e) {
            e.printStackTrace();
        }
        if (token != null) {
            ACCESS_TOKEN = token.getAccessToken();
        }
    }

    /**
     * 使用appid和secret获取ACCESS_TOKEN,新的ACCESS_TOKEN不会覆盖老的ACCESS_TOKEN,每个ACCESS_TOKEN可以使用2小时
     *
     * @param appid 平台发放的appid
     * @param secret 平台发放的secret
     * @return TokenResult ACCESS_TOKEN的包装类
     */
    public static TokenResult getToken(String appid, String secret) {
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("grant_type", "client_credential");
        queryParams.put("appid", appid);
        queryParams.put("secret", secret);
        ResultWapper<TokenResult> resultWapper;
        TokenResult token;
        String path = PathConstants.BASE_URL + PathConstants.TOKEN;
        resultWapper = ClientUtils.get(path, queryParams, TokenResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        token = resultWapper.getResult();
        return token;
    }

    /**
     * 使用配置文件的appid和secret获取ACCESS_TOKEN,新的ACCESS_TOKEN不会覆盖老的ACCESS_TOKEN,每个ACCESS_TOKEN可以使用2小时
     *
     * @return TokenResult ACCESS_TOKEN的包装类
     */
    public static TokenResult getToken() {
        return getToken(NudgePlusConfig.getValue("APP_ID"), NudgePlusConfig.getValue("APP_SECRET"));
    }
}
