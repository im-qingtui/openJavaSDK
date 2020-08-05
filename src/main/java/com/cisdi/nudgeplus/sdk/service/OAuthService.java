package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.beans.UserInfoResult;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * OAuth接口类
 */
@Slf4j
public final class OAuthService {

    /**
     * 根据qt_code验证用户的合法性,并返回用户信息
     *
     * @param qtCode 用户点击授权链接后发放的qt_code,5分钟有效,只能使用1次
     * @return 返回用户基本信息
     */
    public static UserInfoResult getUserInfo(String qtCode) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("grant_type", "client_credential");
        queryParams.put("appid", NudgePlusConfig.getAppId());
        queryParams.put("secret", NudgePlusConfig.getAppSecret());
        queryParams.put("qt_code", qtCode);
        ResultWrapper<UserInfoResult> resultWrapper;
        UserInfoResult userInfo = null;

        try {
            String path = PathConstants.OAUTH_USERINFO_PATH;
            resultWrapper = ClientUtils.get(path, queryParams, UserInfoResult.class);
            userInfo = resultWrapper.getResult();
        } catch (IllegalRequestException e) {
            log.error(e.getMessage(), e);
        }
        return userInfo;
    }

    private OAuthService() {
    }

}
