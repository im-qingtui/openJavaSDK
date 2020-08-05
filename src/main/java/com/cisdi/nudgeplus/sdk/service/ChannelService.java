package com.cisdi.nudgeplus.sdk.service;

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
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", TokenService.getToken());
        map.put("appId", NudgePlusConfig.getAppId());

        String path = PathConstants.GET_CHANNEL_LIST_PATH;

        ResultWrapper<ChannelResult> resultWrapper = ClientUtils.get(path, map, ChannelResult.class);

        return resultWrapper.getResult();
    }

    /**
     * 根据群id查询群成员
     */
    public static ChannelMemberResult getChannelMemberList(String channelId) {
        if (channelId == null) {
            throw new IllegalRequestException();
        }

        Map<String, String> map = new HashMap<>();
        map.put("accessToken", TokenService.getToken());
        map.put("channelId", channelId);

        String path = PathConstants.GET_CHANNEL_MEMBER_LIST_PATH;

        ResultWrapper<ChannelMemberResult> resultWrapper = ClientUtils.get(path, map, ChannelMemberResult.class);

        return resultWrapper.getResult();
    }

    private ChannelService() {
    }

}
