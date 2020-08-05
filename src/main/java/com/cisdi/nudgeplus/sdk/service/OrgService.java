package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.ErrorConstants;
import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.beans.org.NewOrgResult;
import com.cisdi.nudgeplus.tmsbeans.beans.org.OrgBaseResult;
import com.cisdi.nudgeplus.tmsbeans.beans.org.OrgSyncListResult;
import com.cisdi.nudgeplus.tmsbeans.beans.org.OrgTreeResultResult;
import com.cisdi.nudgeplus.tmsbeans.beans.org.PagedOrgResult;
import com.cisdi.nudgeplus.tmsbeans.beans.org.SumUserResult;
import com.cisdi.nudgeplus.tmsbeans.model.request.org.RequestNewOrg;
import com.cisdi.nudgeplus.tmsbeans.model.request.org.RequestOrg;
import com.cisdi.nudgeplus.tmsbeans.model.request.org.RequestOrgName;
import com.cisdi.nudgeplus.tmsbeans.model.request.org.RequestOrgSycInfo;
import com.cisdi.nudgeplus.tmsbeans.model.request.org.RequestPagedOrg;
import java.util.HashMap;
import java.util.Map;

/**
 * 组织机构业务接口
 *
 * @author shizhen
 */
public final class OrgService {

    /**
     * 根据domainId和orgId查找组织机构信息
     *
     * @param request 组织机构信息请求
     * @return 返回请求下的组织机构信息
     */
    public static OrgTreeResultResult getOrganizationList(RequestOrg request) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", TokenService.getToken());
        map.put("orgId", request.getOrgId());

        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }

        String path = PathConstants.GET_ORG_LIST_PATH;
        ResultWrapper<OrgTreeResultResult> resultWrapper = ClientUtils.get(path, map, OrgTreeResultResult.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据domainId和orgId分页查找组织机构信息
     *
     * @param request 组织机构信息分页请求
     * @return 返回请求下的分页组织机构信息
     */
    public static PagedOrgResult pagedOrganizationList(RequestPagedOrg request) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", TokenService.getToken());
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        if (request.getOrgId() != null) {
            map.put("orgId", request.getOrgId());
        }
        map.put("pageSize", String.valueOf(request.getPageSize()));
        map.put("requestPage", String.valueOf(request.getRequestPage()));
        String path = PathConstants.PAGE_ORG_LIST_PATH;
        ResultWrapper<PagedOrgResult> resultWrapper = ClientUtils.get(path, map, PagedOrgResult.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据domainId和orgId查找组织机构行详细信息
     *
     * @param request 组织机构信息请求
     * @return 返回请求下的组织机构详细信息
     */
    public static OrgBaseResult getOrganizationDetail(RequestOrg request) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", TokenService.getToken());
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("orgId", request.getOrgId());

        String path = PathConstants.GET_ORG_DETAIL_PATH;

        ResultWrapper<OrgBaseResult> resultWrapper = ClientUtils.get(path, map, OrgBaseResult.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据domainId和orgId查找组织机构下的总人数
     *
     * @param request 组织机构下的总人数请求
     * @return 返回请求下的组织机构下的总人数
     */
    public static int sumUserOfOrganization(RequestOrg request) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", TokenService.getToken());
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("orgId", request.getOrgId());

        String path = PathConstants.SUM_USER_OF_ORG_PATH;

        ResultWrapper<SumUserResult> resultWrapper = ClientUtils.get(path, map, SumUserResult.class);

        return resultWrapper.getResult().getMemberCount();
    }

    /**
     * 根据domainId和orgId删除组织机构 只能删除底层的组织机构
     *
     * @param request 删除组织机构的请求
     */
    public static void deleteTheUnderlyingOrg(RequestOrg request) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        if (request.getDomainId() == null) {
            try {
                request.setDomainId(TokenService.getDomainIdByToken());
            } catch (Exception e) {
                throw new IllegalRequestException(ErrorConstants.TOKEN_ERROR);
            }
        }

        String path = PathConstants.ORG_DELETE_PATH;

        ClientUtils.post(path, TokenService.getToken(), JsonUtils.beanToJson(request), BaseResult.class);
    }

    /**
     * 根据新建的组织机构信息新建组织机构
     *
     * @param request 新建组织机构的请求
     * @return 返回新建的组织机构id
     */
    public static String createNewOrg(RequestNewOrg request) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        if (request.getDomainId() == null) {
            try {
                request.setDomainId(TokenService.getDomainIdByToken());
            } catch (Exception e) {
                throw new IllegalRequestException(ErrorConstants.TOKEN_ERROR);
            }
        }

        String path = PathConstants.ORG_CREATE_PATH;

        ResultWrapper<NewOrgResult> resultWrapper = ClientUtils
            .post(path, TokenService.getToken(), JsonUtils.beanToJson(request), NewOrgResult.class);

        return resultWrapper.getResult().getOrgId();
    }

    /**
     * 根据更新的组织机构信息修改组织机构
     *
     * @param request 修改组织机构的请求
     */
    public static void updateOrg(RequestOrgName request) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        if (request.getDomainId() == null) {
            try {
                request.setDomainId(TokenService.getDomainIdByToken());
            } catch (Exception e) {
                throw new IllegalRequestException(ErrorConstants.TOKEN_ERROR);
            }
        }

        String path = PathConstants.ORG_UOPDATE_PATH;

        ClientUtils.post(path, TokenService.getToken(), JsonUtils.beanToJson(request), BaseResult.class);
    }

    /**
     * 根据同步时间和domainid查看同步组织机构信息
     *
     * @param request 同步织机构的请求
     * @return 返回同步请求下的组织机构id
     */
    public static OrgSyncListResult synOrgInfo(RequestOrgSycInfo request) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", TokenService.getToken());
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("syncTime", String.valueOf(request.getSyncTime()));

        String path = PathConstants.ORG_SYNC_PATH;

        ResultWrapper<OrgSyncListResult> resultWrapper = ClientUtils.get(path, map, OrgSyncListResult.class);

        return resultWrapper.getResult();
    }

    private OrgService() {
    }
}