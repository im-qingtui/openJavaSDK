package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import com.cisdi.nudgeplus.tmsbeans.beans.channel.ChannelMemberResult;
import com.cisdi.nudgeplus.tmsbeans.beans.channel.ChannelResult;
import com.cisdi.nudgeplus.tmsbeans.beans.member.PagedUserInfoResult;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestPagedOrgUserInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 群相关接口
 * Date:2020/7/29
 *
 * @author GuanZhong
 */
public class ChannelService {

    public static ChannelResult getChannelList(String appId) {
        return getChannelList(appId, TokenService.ACCESS_TOKEN);
    }

    /**
     * 通过appid查询机器人所在群 指定ACCESS_TOKEN
     *
     * @param appId
     * @param token
     * @return
     */
    public static ChannelResult getChannelList(String appId, String token) {
        if (appId == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        map.put("appId", appId);
        String path = PathConstants.TEAM_URL + PathConstants.GET_CHANNEL_LIST_PATH;
        ResultWapper<ChannelResult> resultWapper = ClientUtils.get(path, map, ChannelResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }


    /**
     * 根据群id查询群成员 使用缓存的ACCESS_TOKEN
     *
     * @param channelId
     * @return
     */
    public static ChannelMemberResult getChannelMemberList(String channelId) {
        return getChannelMemberList(channelId, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据群id查询群成员 指定ACCESS_TOKEN
     *
     * @param channelId
     * @param token
     * @return
     */
    public static ChannelMemberResult getChannelMemberList(String channelId, String token) {
        if (channelId == null) {
            throw new IllegalRequestException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        map.put("channelId", channelId);
        String path = PathConstants.TEAM_URL + PathConstants.GET_CHANNEL_MEMBER_LIST_PATH;
        ResultWapper<ChannelMemberResult> resultWapper = ClientUtils.get(path, map, ChannelMemberResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }


}
