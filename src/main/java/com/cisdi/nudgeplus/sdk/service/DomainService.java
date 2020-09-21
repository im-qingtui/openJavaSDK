package com.cisdi.nudgeplus.sdk.service;

import static com.cisdi.nudgeplus.sdk.service.TokenService.getToken;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.beans.domain.DomainResult;
import java.util.HashMap;
import java.util.Map;

/**
 * 团队接口
 *
 * @author shizhen
 */
public final class DomainService {

    /**
     * 根据domainNumber查找domainId
     *
     * @param domainNumber 团队号
     * @return 返回团队id
     */
    public static String getDomainId(String domainNumber) {
        return getDomainId(domainNumber, getToken());
    }

    /**
     * 根据domainNumber查找domainId
     *
     * @param domainNumber 团队号
     * @param accessToken  应用凭证
     * @return 返回团队id
     */
    public static String getDomainId(String domainNumber, String accessToken) {
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("number", domainNumber);

        String path = PathConstants.GET_DOMAIN_ID_PATH;

        ResultWrapper<DomainResult> resultWrapper = ClientUtils.get(path, map, DomainResult.class);

        return resultWrapper.getResult().getDomainId();
    }

    private DomainService() {
    }
}