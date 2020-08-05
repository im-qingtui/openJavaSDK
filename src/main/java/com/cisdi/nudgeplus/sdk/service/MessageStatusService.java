package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.OptionResult;
import java.util.HashMap;
import java.util.Map;

/**
 * 消息状态查询接口
 */
public final class MessageStatusService {

    /**
     * 根据消息id查询消息发送状态
     *
     * @param msgId 消息id
     */
    public static void sendGetStatus(String msgId) {
        if (msgId == null) {
            throw new IllegalMessageException();
        }

        Map<String, String> requestMap = new HashMap<String, String>();
        requestMap.put("msg_id", msgId);

        String path = PathConstants.SEND_MESSAGE_PATH;

        ClientUtils.post(path, TokenService.getToken(), JsonUtils.beanToJson(requestMap), OptionResult.class);
    }

    private MessageStatusService() {
    }

}
