package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.ErrorConstants;
import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
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
public class OrgService {


    /**
     * 根据domainId和orgId使用缓存的ACCESS_TOKEN查找组织机构信息
     *
     * @param request 组织机构信息请求
     * @return 返回请求下的组织机构信息
     */
    public static OrgTreeResultResult getOrganizationList(RequestOrg request) {
        return getOrganizationList(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId和orgId使用指定的ACCESS_TOKEN查找组织机构信息
     *
     * @param request 组织机构信息请求
     * @return 返回请求下的组织机构信息
     */
    public static OrgTreeResultResult getOrganizationList(RequestOrg request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        map.put("orgId", request.getOrgId());
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        String path = PathConstants.TEAM_URL + PathConstants.GET_ORG_LIST_PATH;
        ResultWapper<OrgTreeResultResult> resultWapper = ClientUtils.get(path, map, OrgTreeResultResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }

    /**
     * 根据domainId和orgId使用缓存的ACCESS_TOKEN分页查找组织机构信息
     *
     * @param request 组织机构信息分页请求
     * @return 返回请求下的分页组织机构信息
     */
    public static PagedOrgResult pagedOrganizationList(RequestPagedOrg request) {
        return pagedOrganizationList(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId和orgId使用指定的ACCESS_TOKEN分页查找组织机构信息
     *
     * @param request 组织机构信息分页请求
     * @return 返回请求下的分页组织机构信息
     */
    public static PagedOrgResult pagedOrganizationList(RequestPagedOrg request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        if(request.getOrgId() != null){
            map.put("orgId", request.getOrgId());
        }
        map.put("pageSize", String.valueOf(request.getPageSize()));
        map.put("requestPage", String.valueOf(request.getRequestPage()));
        String path = PathConstants.TEAM_URL + PathConstants.PAGE_ORG_LIST_PATH;
        ResultWapper<PagedOrgResult> resultWapper = ClientUtils.get(path, map, PagedOrgResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }

    /**
     * 根据domainId和orgId使用指定的ACCESS_TOKEN查找组织机构行详细信息
     *
     * @param request 组织机构信息请求
     * @return 返回请求下的组织机构详细信息
     */
    public static OrgBaseResult getOrganizationDetail(RequestOrg request) {
        return getOrganizationDetail(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId和orgId使用指定的ACCESS_TOKEN查找组织机构行详细信息
     *
     * @param request 组织机构信息请求
     * @return 返回请求下的组织机构详细信息
     */
    public static OrgBaseResult getOrganizationDetail(RequestOrg request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("orgId", request.getOrgId());
        String path = PathConstants.TEAM_URL + PathConstants.GET_ORG_DETAIL_PATH;
        ResultWapper<OrgBaseResult> resultWapper = ClientUtils.get(path, map, OrgBaseResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }

    /**
     * 根据domainId和orgId使用指定的ACCESS_TOKEN查找组织机构下的总人数
     *
     * @param request 组织机构下的总人数请求
     * @return 返回请求下的组织机构下的总人数
     */
    public static int sumUserOfOrganization(RequestOrg request) {
        return sumUserOfOrganization(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId和orgId使用指定的ACCESS_TOKEN查找组织机构下的总人数
     *
     * @param request 组织机构下的总人数请求
     * @return 返回请求下的组织机构下的总人数
     */
    public static int sumUserOfOrganization(RequestOrg request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("orgId", request.getOrgId());
        String path = PathConstants.TEAM_URL + PathConstants.SUM_USER_OF_ORG_PATH;
        ResultWapper<SumUserResult> resultWapper = ClientUtils.get(path, map, SumUserResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMemberCount();
    }

    /**
     * 根据domainId和orgId使用缓存的ACCESS_TOKEN删除组织机构 只能删除底层的组织机构
     *
     * @param request 删除组织机构的请求
     */
    public static void deleteTheUnderlyingOrg(RequestOrg request) {
        deleteTheUnderlyingOrg(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId和orgId使用指定的ACCESS_TOKEN删除组织机构 只能删除底层的组织机构
     *
     * @param request 删除组织机构的请求
     */
    public static void deleteTheUnderlyingOrg(RequestOrg request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        if (request.getDomainId() == null) {
            try {
                request.setDomainId(JsonUtils.getDomainIdByToken(token));
            } catch (Exception e) {
                throw new IllegalRequestException(ErrorConstants.TOKEN_ERRPO);
            }
        }
        String path = PathConstants.TEAM_URL + PathConstants.ORG_DELETE_PATH;
        ResultWapper<BaseResult> resultWapper = ClientUtils
            .post(path, token, JsonUtils.beanToJson(request), BaseResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
    }

    /**
     * 根据新建的组织机构信息使用缓存的ACCESS_TOKEN新建组织机构
     *
     * @param request 新建组织机构的请求
     * @return 返回新建的组织机构id
     */
    public static String createNewOrg(RequestNewOrg request) {
        return createNewOrg(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据新建的组织机构信息使用指定的ACCESS_TOKEN新建组织机构
     *
     * @param request 新建组织机构的请求
     * @return 返回新建的组织机构id
     */
    public static String createNewOrg(RequestNewOrg request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        if (request.getDomainId() == null) {
            try {
                request.setDomainId(JsonUtils.getDomainIdByToken(token));
            } catch (Exception e) {
                throw new IllegalRequestException(ErrorConstants.TOKEN_ERRPO);
            }
        }
        String path = PathConstants.TEAM_URL + PathConstants.ORG_CREATE_PATH;
        ResultWapper<NewOrgResult> resultWapper = ClientUtils
            .post(path, token, JsonUtils.beanToJson(request), NewOrgResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getOrgId();
    }

    /**
     * 根据更新的组织机构信息使用缓存的ACCESS_TOKEN修改组织机构
     *
     * @param request 修改组织机构的请求
     */
    public static void updateOrg(RequestOrgName request) {
        updateOrg(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据更新的组织机构信息使用指定的ACCESS_TOKEN修改组织机构
     *
     * @param request 修改组织机构的请求
     */
    public static void updateOrg(RequestOrgName request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        if (request.getDomainId() == null) {
            try {
                request.setDomainId(JsonUtils.getDomainIdByToken(token));
            } catch (Exception e) {
                throw new IllegalRequestException(ErrorConstants.TOKEN_ERRPO);
            }
        }
        String path = PathConstants.TEAM_URL + PathConstants.ORG_UOPDATE_PATH;
        ResultWapper<BaseResult> resultWapper = ClientUtils
            .post(path, token, JsonUtils.beanToJson(request), BaseResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
    }

    /**
     * 根据同步时间和domainid使用缓存的ACCESS_TOKEN查看同步组织机构信息
     *
     * @param request 同步织机构的请求
     * @return 返回同步请求下的组织机构id
     */
    public static OrgSyncListResult synOrgInfo(RequestOrgSycInfo request) {
        return synOrgInfo(request, TokenService.ACCESS_TOKEN);
    }


    /**
     * 根据同步时间和domainid使用指定的ACCESS_TOKEN查看同步组织机构信息
     *
     * @param request 同步织机构的请求
     * @return 返回同步请求下的组织机构id
     */
    public static OrgSyncListResult synOrgInfo(RequestOrgSycInfo request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("syncTime", String.valueOf(request.getSyncTime()));
        String path = PathConstants.TEAM_URL + PathConstants.ORG_SYNC_PATH;
        ResultWapper<OrgSyncListResult> resultWapper = ClientUtils.get(path, map, OrgSyncListResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }
}