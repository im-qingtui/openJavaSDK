package com.cisdi.nudgeplus.sdk.service;

import static com.cisdi.nudgeplus.sdk.service.TokenService.getToken;

import com.cisdi.nudgeplus.sdk.constants.ErrorConstants;
import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.beans.member.AccountResult;
import com.cisdi.nudgeplus.tmsbeans.beans.member.OpenIdResult;
import com.cisdi.nudgeplus.tmsbeans.beans.member.PagedSyncUserDetailResult;
import com.cisdi.nudgeplus.tmsbeans.beans.member.PagedUserInfoResult;
import com.cisdi.nudgeplus.tmsbeans.beans.member.UserDetail;
import com.cisdi.nudgeplus.tmsbeans.beans.member.UserDetailList;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestBatchCreateUsers;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestCreateUser;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestDeleteUsers;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestPagedOrgUserInfo;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestPagedSyncMember;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestPagedUserInfo;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestUpdateUser;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestUser;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestUserBatch;
import java.util.HashMap;
import java.util.Map;

/**
 * 成员业务接口
 *
 * @author shizhen
 */
public final class MemberService {

    /**
     * 根据orgId和domainId分页查找用户信息
     *
     * @param request 分页请求
     * @return 返回分页请求下的用户信息
     */
    public static PagedUserInfoResult pageOrgUserInfo(RequestPagedOrgUserInfo request) {
        return pageOrgUserInfo(request, getToken());
    }

    /**
     * 根据orgId和domainId分页查找用户信息
     *
     * @param request     分页请求
     * @param accessToken 应用凭证
     * @return 返回分页请求下的用户信息
     */
    public static PagedUserInfoResult pageOrgUserInfo(RequestPagedOrgUserInfo request, String accessToken) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("orgId", request.getOrgId());
        map.put("pageSize", String.valueOf(request.getPageSize()));
        map.put("requestPage", String.valueOf(request.getRequestPage()));

        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }

        String path = PathConstants.PAGE_ORG_USER_INFO_PATH;

        ResultWrapper<PagedUserInfoResult> resultWrapper = ClientUtils.get(path, map, PagedUserInfoResult.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据domainId分页查找用户信息
     *
     * @param request 分页请求
     * @return 返回分页请求下的用户信息
     */
    public static PagedUserInfoResult pageAllUserInfo(RequestPagedUserInfo request) {
        return pageAllUserInfo(request, getToken());
    }

    /**
     * 根据domainId分页查找用户信息
     *
     * @param request     分页请求
     * @param accessToken 应用凭证
     * @return 返回分页请求下的用户信息
     */
    public static PagedUserInfoResult pageAllUserInfo(RequestPagedUserInfo request, String accessToken) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        Map<String, String> map = new HashMap<>();
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("pageSize", String.valueOf(request.getPageSize()));
        map.put("requestPage", String.valueOf(request.getRequestPage()));
        map.put("accessToken", accessToken);

        String path = PathConstants.PAGE_ALL_USER_INFO_PATH;

        ResultWrapper<PagedUserInfoResult> resultWrapper = ClientUtils.get(path, map, PagedUserInfoResult.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据domainId和accountId分页查找用户信息
     *
     * @param request 用户详情请求
     * @return 返回请求下的用户信息
     */
    public static UserDetail getUserDetailInfo(RequestUser request) {
        return getUserDetailInfo(request, getToken());
    }

    /**
     * 根据domainId和accountId分页查找用户信息
     *
     * @param request     用户详情请求
     * @param accessToken 应用凭证
     * @return 返回请求下的用户信息
     */
    public static UserDetail getUserDetailInfo(RequestUser request, String accessToken) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("accountId", request.getAccountId());

        String path = PathConstants.GET_USER_DETAIL_INFO_PATH;

        ResultWrapper<UserDetail> resultWrapper = ClientUtils.get(path, map, UserDetail.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据domainId和accountId批量查找用户信息
     *
     * @param request 用户详情请求
     * @return 返回请求下的用户信息
     */
    public static UserDetailList batchGetUserDetailInfo(RequestUserBatch request) {
        return batchGetUserDetailInfo(request, getToken());
    }

    /**
     * 根据domainId和accountId批量查找用户信息
     *
     * @param request     用户详情请求
     * @param accessToken 应用凭证
     * @return 返回请求下的用户信息
     */
    public static UserDetailList batchGetUserDetailInfo(RequestUserBatch request, String accessToken) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        String path = PathConstants.BATCH_GET_USER_DETAIL_INFO_PATH;

        ResultWrapper<UserDetailList> resultWrapper = ClientUtils
            .post(path, accessToken, JsonUtils.beanToSnakeJson(request), UserDetailList.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据dopenId分页查找用户信息
     *
     * @param openId 用户openId
     * @return 返回请求下的用户信息
     */
    public static UserDetail getUserDetailInfo(String openId) {
        return getUserDetailInfo(openId, getToken());
    }

    /**
     * 根据dopenId分页查找用户信息
     *
     * @param openId      用户openId
     * @param accessToken 应用凭证
     * @return 返回请求下的用户信息
     */
    public static UserDetail getUserDetailInfo(String openId, String accessToken) {
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("openId", openId);

        String path = PathConstants.GET_USER_DETAIL_INFO_OPENID_PATH;

        ResultWrapper<UserDetail> resultWrapper = ClientUtils.get(path, map, UserDetail.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据domainId和accountId删除用户信息
     *
     * @param request 删除用户的请求
     */
    public static void deleteUser(RequestUser request) {
        deleteUser(request, getToken());
    }

    /**
     * 根据domainId和accountId删除用户信息
     *
     * @param request     删除用户的请求
     * @param accessToken 应用凭证
     */
    public static void deleteUser(RequestUser request, String accessToken) {
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

        String path = PathConstants.DELETE_SINGLE_MEMBER_PATH;

        ClientUtils.post(path, accessToken, JsonUtils.beanToSnakeJson(request), BaseResult.class);
    }

    /**
     * 根据domainId和accountId批量删除用户信息
     *
     * @param request 删除用户的请求
     */
    public static void batchDeleteUsers(RequestDeleteUsers request) {
        batchDeleteUsers(request, getToken());
    }

    /**
     * 根据domainId和accountId批量删除用户信息
     *
     * @param request     删除用户的请求
     * @param accessToken 应用凭证
     */
    public static void batchDeleteUsers(RequestDeleteUsers request, String accessToken) {
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

        String path = PathConstants.DELETE_BATCH_MEMBER_PATH;

        ClientUtils.post(path, accessToken, JsonUtils.beanToSnakeJson(request), BaseResult.class);
    }

    /**
     * 根据domainId和accountId单个更新用户信息
     *
     * @param request 更新用户的请求
     */
    public static void updateUserInfo(RequestUpdateUser request) {
        updateUserInfo(request, getToken());
    }

    /**
     * 根据domainId和accountId单个更新用户信息
     *
     * @param request     更新用户的请求
     * @param accessToken 应用凭证
     */
    public static void updateUserInfo(RequestUpdateUser request, String accessToken) {
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
        String path = PathConstants.UPDATE_USER_SINGLE_PATH;

        ClientUtils.post(path, accessToken, JsonUtils.beanToSnakeJson(request), BaseResult.class);
    }

    /**
     * 根据domainId同步用户信息
     *
     * @param request 分页同步用户的请求
     * @return 返回分页请求下的用户详细信息
     */
    public static PagedSyncUserDetailResult syncUsers(RequestPagedSyncMember request) {
        return syncUsers(request, getToken());
    }

    /**
     * 根据domainId同步用户信息
     *
     * @param request     分页同步用户的请求
     * @param accessToken 应用凭证
     * @return 返回分页请求下的用户详细信息
     */
    public static PagedSyncUserDetailResult syncUsers(RequestPagedSyncMember request, String accessToken) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("syncTime", String.valueOf(request.getSyncTime()));
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }
        map.put("pageSize", String.valueOf(request.getPageSize()));
        map.put("requestPage", String.valueOf(request.getRequestPage()));

        String path = PathConstants.SYNC_MEMBER_PATH;

        ResultWrapper<PagedSyncUserDetailResult> resultWrapper = ClientUtils.get(path, map, PagedSyncUserDetailResult.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据openId获取用户accountId
     *
     * @param openId 用户的openId
     * @return 返回用户的accountId
     */
    public static String getAccountId(String openId) {
        return getAccountId(openId, getToken());
    }

    /**
     * 根据openId获取用户accountId
     *
     * @param openId      用户的openId
     * @param accessToken 应用凭证
     * @return 返回用户的accountId
     */
    public static String getAccountId(String openId, String accessToken) {
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("openId", openId);

        String path = PathConstants.GET_MEMBER_ACCOUNT_PATH;

        ResultWrapper<AccountResult> resultWrapper = ClientUtils.get(path, map, AccountResult.class);

        return resultWrapper.getResult().getAccountId();
    }

    /**
     * 根据accountId和domainId获取用户openId
     *
     * @param request 获取用户openId的请求参数
     * @return 返回用户的openId
     */
    public static String getOpenId(RequestUser request) {
        return getOpenId(request, getToken());
    }

    /**
     * 根据accountId和domainId获取用户openId
     *
     * @param request     获取用户openId的请求参数
     * @param accessToken 应用凭证
     * @return 返回用户的openId
     */
    public static String getOpenId(RequestUser request, String accessToken) {
        if (request == null) {
            throw new IllegalRequestException();
        }

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("accountId", request.getAccountId());
        if (request.getDomainId() != null) {
            map.put("domainId", request.getDomainId());
        }

        String path = PathConstants.GET_MEMBER_OPEN_ID_PATH;
        ResultWrapper<OpenIdResult> resultWrapper = ClientUtils.get(path, map, OpenIdResult.class);

        return resultWrapper.getResult().getOpenId();
    }

    /**
     * 根据新用户信息批量创建新用户
     *
     * @param request 需要批量创建的新用户信息
     */
    public static void batchCreateNewUsers(RequestBatchCreateUsers request) {
        batchCreateNewUsers(request, getToken());
    }

    /**
     * 根据新用户信息批量创建新用户
     *
     * @param request     需要批量创建的新用户信息
     * @param accessToken 应用凭证
     */
    public static void batchCreateNewUsers(RequestBatchCreateUsers request, String accessToken) {
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

        String path = PathConstants.BATCH_CREATE_USERS_PATH;

        ClientUtils.post(path, accessToken, JsonUtils.beanToSnakeJson(request), BaseResult.class);
    }

    /**
     * 根据新用户信息单个创建新用户
     *
     * @param request 需要创建的新用户信息
     */
    public static void createNewUser(RequestCreateUser request) {
        createNewUser(request, getToken());
    }

    /**
     * 根据新用户信息单个创建新用户
     *
     * @param request 需要创建的新用户信息
     */
    public static void createNewUser(RequestCreateUser request, String accessToken) {
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

        String path = PathConstants.CREATE_USER_PATH;

        ClientUtils.post(path, accessToken, JsonUtils.beanToSnakeJson(request), BaseResult.class);
    }

    private MemberService() {
    }
}