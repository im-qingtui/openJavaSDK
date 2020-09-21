package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.beans.TokenResult;
import com.google.gson.annotations.SerializedName;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

@Slf4j
public final class TokenService {

    private static volatile String accessToken;

    private static volatile long accessTokenExpiration = 0L;

    private static volatile TokenPayload payload;

    private static final long TOKEN_REFRESH_LIMIT = 300000L;

    /**
     * 根据 NudgePlusConfig 中保存的 appId 和 secret 获取 5分钟内可用的 accessToken
     *
     * @return token
     */
    public static String getToken() {
        return getToken(NudgePlusConfig.getAppId(), NudgePlusConfig.getAppSecret());
    }

    /**
     * 根据 appId 和 secret 获取 5分钟内可用的 accessToken
     *
     * @return token
     */
    public static String getToken(String appId, String appSecret) {
        if (System.currentTimeMillis() > accessTokenExpiration || StringUtils.isEmpty(accessToken)) {
            refreshToken(appId, appSecret);
        }
        return accessToken;
    }

    /**
     * 从accessToken中获取domainId
     *
     * @return domainId
     */
    public static String getDomainIdByToken() {
        if (System.currentTimeMillis() > accessTokenExpiration || null == payload) {
            refreshToken();
        }

        return payload.getDomainId();
    }

    @Data
    @NoArgsConstructor
    private static class TokenPayload {

        private String domainId;
        @SerializedName("appid")
        private String appId;
        private long dispatch;
        private long expiresIn;
    }

    /**
     * 根据 NudgePlusConfig 中保存的 appId 和 secret 刷新token
     */
    private static void refreshToken() {
        refreshToken(NudgePlusConfig.getAppId(), NudgePlusConfig.getAppSecret());
    }

    /**
     * 根据appId 和 secret 刷新token
     */
    private static synchronized void refreshToken(String appId, String appSecret) {
        Map<String, String> queryParams = new HashMap<>();

        queryParams.put("grant_type", "client_credential");
        queryParams.put("appid", appId);
        queryParams.put("secret", appSecret);

        String path = PathConstants.TOKEN;

        ResultWrapper<TokenResult> res = ClientUtils.get(path, queryParams, TokenResult.class);

        if (res.isError()) {
            log.info("获取token失败, res={}", res.getErrorResult());
        }

        TokenResult token = res.getResult();

        accessToken = token.getAccessToken();
        payload = parseTokenPayload();
        accessTokenExpiration = payload.getExpiresIn() - TOKEN_REFRESH_LIMIT;
        log.info("token refreshed, payload={}", payload);
    }

    private static TokenPayload parseTokenPayload() {
        Base64 base64 = new Base64();
        String json = new String(base64.decode(accessToken.split("\\.")[1]), StandardCharsets.UTF_8);

        return JsonUtils.snakeJsonToBean(json, TokenPayload.class);
    }


    private TokenService() {
    }
}
