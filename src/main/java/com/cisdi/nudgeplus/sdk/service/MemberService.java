package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.ErrorConstants;
import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.cisdi.nudgeplus.tmsbeans.beans.member.*;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 成员业务接口
 *
 * @author shizhen
 */
public class MemberService {

    /**
     * 根据orgId和domainId使用缓存的ACCESS_TOKEN分页查找用户信息
     *
     * @param request 分页请求
     * @return 返回分页请求下的用户信息
     */
    public static PagedUserInfoResult pageOrgUserInfo(RequestPagedOrgUserInfo request) {
        return pageOrgUserInfo(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据orgId和domainId使用指定的ACCESS_TOKEN分页查找用户信息
     *
     * @param request 分页请求
     * @return 返回分页请求下的用户信息
     */
    public static PagedUserInfoResult pageOrgUserInfo(RequestPagedOrgUserInfo request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        map.put("orgId", request.getOrgId());
        map.put("pageSize", String.valueOf(request.getPageSize()));
        map.put("requestPage", String.valueOf(request.getRequestPage()));
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        String path = PathConstants.TEAM_URL + PathConstants.PAGE_ORG_USER_INFO_PATH;
        ResultWapper<PagedUserInfoResult> resultWapper = ClientUtils.get(path, map, PagedUserInfoResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }

        return resultWapper.getResult();
    }

    /**
     * 根据domainId使用缓存的ACCESS_TOKEN分页查找用户信息
     *
     * @param request 分页请求
     * @return 返回分页请求下的用户信息
     */
    public static PagedUserInfoResult pageAllUserInfo(RequestPagedUserInfo request) {
        return pageAllUserInfo(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId使用指定的ACCESS_TOKEN分页查找用户信息
     *
     * @param request 分页请求
     * @return 返回分页请求下的用户信息
     */
    public static PagedUserInfoResult pageAllUserInfo(RequestPagedUserInfo request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("pageSize", String.valueOf(request.getPageSize()));
        map.put("requestPage", String.valueOf(request.getRequestPage()));
        map.put("accessToken", token);
        String path = PathConstants.TEAM_URL + PathConstants.PAGE_ALL_USER_INFO_PATH;
        ResultWapper<PagedUserInfoResult> resultWapper = ClientUtils.get(path, map, PagedUserInfoResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }

    /**
     * 根据domainId和accountId使用缓存的ACCESS_TOKEN分页查找用户信息
     *
     * @param request 用户详情请求
     * @return 返回请求下的用户信息
     */
    public static UserDetail getUserDetailInfo(RequestUser request) {
        return getUserDetailInfo(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId和accountId使用指定的ACCESS_TOKEN分页查找用户信息
     *
     * @param request 用户详情请求
     * @return 返回请求下的用户信息
     */
    public static UserDetail getUserDetailInfo(RequestUser request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("accountId", request.getAccountId());
        String path = PathConstants.TEAM_URL + PathConstants.GET_USER_DETAIL_INFO_PATH;
        ResultWapper<UserDetail> resultWapper = ClientUtils.get(path, map, UserDetail.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }

    /**
     * 根据domainId和accountIdList使用缓存的ACCESS_TOKEN批量查找用户信息
     *
     * @param request
     * @return
     */
    public static UserDetailList batchGetUserDetailInfo(RequestUserBatch request) {
        return batchGetUserDetailInfo(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId和accountId使用指定的ACCESS_TOKEN批量查找用户信息
     *
     * @param request 用户详情请求
     * @return 返回请求下的用户信息
     */
    public static UserDetailList batchGetUserDetailInfo(RequestUserBatch request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        String path = PathConstants.TEAM_URL + PathConstants.GET_USER_DETAIL_INFO_PATH;
        ResultWapper<UserDetailList> resultWapper = ClientUtils.post(path, token, JsonUtils.beanToJson(request), UserDetailList.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }

    /**
     * 根据dopenId使用缓存的ACCESS_TOKEN分页查找用户信息
     *
     * @param openId 用户openId
     * @return 返回请求下的用户信息
     */
    public static UserDetail getUserDetailInfo(String openId) {
        return getUserDetailInfo(openId, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据dopenId使用指定的ACCESS_TOKEN分页查找用户信息
     *
     * @param openId 用户openId
     * @return 返回请求下的用户信息
     */
    public static UserDetail getUserDetailInfo(String openId, String token) {
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        map.put("openId", openId);
        String path = PathConstants.TEAM_URL + PathConstants.GET_USER_DETAIL_INFO_OPENID_PATH;
        ResultWapper<UserDetail> resultWapper = ClientUtils.get(path, map, UserDetail.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }

    /**
     * 根据domainId和accountId使用缓存的ACCESS_TOKEN删除用户信息
     *
     * @param request 删除用户的请求
     */
    public static void deleteUser(RequestUser request) {
        deleteUser(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId和accountId使用指定的ACCESS_TOKEN删除用户信息
     *
     * @param request 删除用户的请求
     */
    public static void deleteUser(RequestUser request, String token) {
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

        String path = PathConstants.TEAM_URL + PathConstants.DELETE_SINGLE_MEMBER_PATH;
        ResultWapper<BaseResult> resultWapper = ClientUtils
                .post(path, token, JsonUtils.beanToJson(request), BaseResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
    }

    /**
     * 根据domainId和accountId使用缓存的ACCESS_TOKEN批量删除用户信息
     *
     * @param request 删除用户的请求
     */
    public static void batchDeleteUsers(RequestDeleteUsers request) {
        batchDeleteUsers(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId和accountId使用指定的ACCESS_TOKEN批量删除用户信息
     *
     * @param request 删除用户的请求
     */
    public static void batchDeleteUsers(RequestDeleteUsers request, String token) {
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
        String path = PathConstants.TEAM_URL + PathConstants.DELETE_BATCH_MEMBER_PATH;
        ResultWapper<BaseResult> resultWapper = ClientUtils
                .post(path, token, JsonUtils.beanToJson(request), BaseResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
    }

    /**
     * 根据domainId和accountId使用缓存的ACCESS_TOKEN单个更新用户信息
     *
     * @param request 更新用户的请求
     */
    public static void updateUserInfo(RequestUpdateUser request) {
        updateUserInfo(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId和accountId使用指定的ACCESS_TOKEN单个更新用户信息
     *
     * @param request 更新用户的请求
     */
    public static void updateUserInfo(RequestUpdateUser request, String token) {
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
        String path = PathConstants.TEAM_URL + PathConstants.UPDATE_USER_SINGLE_PATH;
        ResultWapper<BaseResult> resultWapper = ClientUtils
                .post(path, token, JsonUtils.beanToJson(request), BaseResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
    }

    /**
     * 根据domainId使用缓存的ACCESS_TOKEN同步用户信息
     *
     * @param request 分页同步用户的请求
     * @return 返回分页请求下的用户详细信息
     */
    public static PagedSyncUserDetailResult syncUsers(RequestPagedSyncMember request) {
        return syncUsers(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据domainId使用指定的ACCESS_TOKEN同步用户信息
     *
     * @param request 分页同步用户的请求
     * @return 返回分页请求下的用户详细信息
     */
    public static PagedSyncUserDetailResult syncUsers(RequestPagedSyncMember request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        map.put("syncTime", String.valueOf(request.getSyncTime()));
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("pageSize", String.valueOf(request.getPageSize()));
        map.put("requestPage", String.valueOf(request.getRequestPage()));
        String path = PathConstants.TEAM_URL + PathConstants.SYNC_MEMBER_PATH;
        ResultWapper<PagedSyncUserDetailResult> resultWapper = ClientUtils.get(path, map, PagedSyncUserDetailResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }

    /**
     * 根据openId使用缓存的ACCESS_TOKEN获取用户accountId
     *
     * @param openId 用户的openId
     * @return 返回用户的accountId
     */
    public static String getAccountId(String openId) {
        return getAccountId(openId, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据openId使用指定的ACCESS_TOKEN获取用户accountId
     *
     * @param openId 用户的openId
     * @return 返回用户的accountId
     */
    public static String getAccountId(String openId, String token) {
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        map.put("openId", openId);
        String path = PathConstants.TEAM_URL + PathConstants.GET_MEMBER_ACCOUNT_PATH;
        ResultWapper<AccountResult> resultWapper = ClientUtils.get(path, map, AccountResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getAccountId();
    }

    /**
     * 根据accountId和domainId使用缓存的ACCESS_TOKEN获取用户openId
     *
     * @param request 获取用户openId的请求参数
     * @return 返回用户的openId
     */
    public static String getOpenId(RequestUser request) {
        return getOpenId(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据accountId和domainId使用指定的ACCESS_TOKEN获取用户openId
     *
     * @param request 获取用户openId的请求参数
     * @return 返回用户的openId
     */
    public static String getOpenId(RequestUser request, String token) {
        if (request == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        map.put("accountId", request.getAccountId());
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        String path = PathConstants.TEAM_URL + PathConstants.GET_MEMBER_OPEN_ID_PATH;
        ResultWapper<OpenIdResult> resultWapper = ClientUtils.get(path, map, OpenIdResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getOpenId();
    }

    /**
     * 根据新用户信息使用缓存的ACCESS_TOKEN批量创建新用户
     *
     * @param request 需要批量创建的新用户信息
     */
    public static void batchCreateNewUsers(RequestBatchCreateUsers request) {
        batchCreateNewUsers(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据新用户信息使用指定的ACCESS_TOKEN批量创建新用户
     *
     * @param request 需要批量创建的新用户信息
     */
    public static void batchCreateNewUsers(RequestBatchCreateUsers request, String token) {
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
        String path = PathConstants.TEAM_URL + PathConstants.BATCH_CREATE_USERS_PATH;
        ResultWapper<BaseResult> resultWapper = ClientUtils
                .post(path, token, JsonUtils.beanToJson(request), BaseResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
    }

    /**
     * 根据新用户信息使用缓存的ACCESS_TOKEN单个创建新用户
     *
     * @param request 需要创建的新用户信息
     */
    public static void createNewUser(RequestCreateUser request) {
        createNewUser(request, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据新用户信息使用指定的ACCESS_TOKEN单个创建新用户
     *
     * @param request 需要创建的新用户信息
     */
    public static void createNewUser(RequestCreateUser request, String token) {
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
        String path = PathConstants.TEAM_URL + PathConstants.CREATE_USER_PATH;
        ResultWapper<BaseResult> resultWapper = ClientUtils
                .post(path, token, JsonUtils.beanToJson(request), BaseResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
    }
}