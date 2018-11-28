package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.OptionResult;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息状态查询接口
 */
public class MessageStatusService {

    /**
     * 使用缓存的ACCESS_TOKEN根据消息id查询消息发送状态
     *
     * @param MsgId 消息id
     */
    public static void sendGetStatus(String MsgId) {
        sendGetStatus(MsgId, TokenService.ACCESS_TOKEN);
    }

    /**
     * 使用指定的ACCESS_TOKEN根据消息id查询消息发送状态
     *
     * @param MsgId 消息id
     */
    public static void sendGetStatus(String MsgId, String token) {
        if (MsgId == null) {
            throw new IllegalMessageException();
        }
        Map<String, String> requestMap = new HashMap<String, String>();
        requestMap.put("msg_id", MsgId);
        String path = PathConstants.BASE_URL + PathConstants.SEND_MESSAGE_PATH;
        ClientUtils.post(path, token, JsonUtils.beanToJson(requestMap), OptionResult.class);
    }

}
