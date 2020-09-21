package com.cisdi.nudgeplus.sdk.service;

import static com.cisdi.nudgeplus.sdk.service.TokenService.getToken;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.beans.channel.ChannelMemberResult;
import com.cisdi.nudgeplus.tmsbeans.beans.channel.ChannelResult;
import java.util.HashMap;
import java.util.Map;

/**
 * 群相关接口 Date:2020/7/29
 *
 * @author GuanZhong
 */
public final class ChannelService {

    /**
     * 通过appid查询机器人所在群
     */
    public static ChannelResult getChannelList() {
        return getChannelList(getToken());
    }

    /**
     * 通过appid查询机器人所在群
     *
     * @param accessToken 应用凭证
     */
    public static ChannelResult getChannelList(String accessToken) {
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("appId", NudgePlusConfig.getAppId());

        String path = PathConstants.GET_CHANNEL_LIST_PATH;

        ResultWrapper<ChannelResult> resultWrapper = ClientUtils.get(path, map, ChannelResult.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据群id查询群成员
     */
    public static ChannelMemberResult getChannelMemberList(String channelId) {
        return getChannelMemberList(channelId, getToken());
    }

    /**
     * 根据群id查询群成员
     *
     * @param accessToken 应用凭证
     */
    public static ChannelMemberResult getChannelMemberList(String channelId, String accessToken) {
        if (channelId == null) {
            throw new IllegalRequestException();
        }

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("channelId", channelId);

        String path = PathConstants.GET_CHANNEL_MEMBER_LIST_PATH;

        ResultWrapper<ChannelMemberResult> resultWrapper = ClientUtils.get(path, map, ChannelMemberResult.class);

        return resultWrapper.getResult();
    }

    private ChannelService() {
    }

}
