package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import com.cisdi.nudgeplus.tmsbeans.beans.UserInfoResult;
import java.util.HashMap;
import java.util.Map;

/**
 * OAuth接口类
 */
public class OAuthService {

    /**
     * 根据qt_code验证用户的合法性,并返回用户信息
     *
     * @param appid 平台发放的appid
     * @param secret 平台发放的secret
     * @param qtCode 用户点击授权链接后发放的qt_code,5分钟有效,只能使用1次
     * @return 返回用户基本信息
     */
    public static UserInfoResult getUserInfo(String appid, String secret, String qtCode) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("grant_type", "client_credential");
        queryParams.put("appid", appid);
        queryParams.put("secret", secret);
        queryParams.put("qt_code", qtCode);
        ResultWapper<UserInfoResult> resultWapper;
        UserInfoResult userInfo = null;
        try {
            String path = PathConstants.BASE_URL + PathConstants.OAUTH_USERINFO_PATH;
            resultWapper = ClientUtils.get(path, queryParams, UserInfoResult.class);
            if (resultWapper.isError()) {
                throw new IllegalRequestException(resultWapper.getErrorResult());
            }
            userInfo = resultWapper.getResult();
        } catch (IllegalRequestException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    /**
     * 根据qt_code验证用户的合法性,并返回用户信息(使用配置文件中的参数)
     *
     * @param qtCode 用户点击授权链接后发放的qt_code,5分钟有效,只能使用1次
     * @return 返回用户基本信息
     */
    public static UserInfoResult getUserInfo(String qtCode) {
        return getUserInfo(NudgePlusConfig.getValue("APP_ID"), NudgePlusConfig.getValue("APP_SECRET"), qtCode);
    }
}
