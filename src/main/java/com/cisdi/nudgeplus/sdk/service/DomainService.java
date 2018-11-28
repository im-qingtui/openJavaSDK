package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.tmsbeans.beans.domain.DomainResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import java.util.HashMap;
import java.util.Map;

/**
 * 团队接口
 *
 * @author shizhen
 */
public class DomainService {


    /**
     * 根据domainNumber使用缓存的ACCESS_TOKEN查找domainId
     *
     * @param domainNumber 团队号
     * @return 返回团队id
     */
    public static String getDomainId(String domainNumber) {
        return getDomainId(domainNumber, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainNumber使用指定的ACCESS_TOKEN查找domainId
     *
     * @param domainNumber 团队号
     * @return 返回团队id
     */
    public static String getDomainId(String domainNumber, String token) {
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        map.put("number", domainNumber);
        String path = PathConstants.TEAM_URL + PathConstants.GET_DOMAIN_ID_PATH;
        ResultWapper<DomainResult> resultWapper = ClientUtils.get(path, map, DomainResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getDomainId();
    }
}