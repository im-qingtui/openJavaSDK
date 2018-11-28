package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MessageResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import com.cisdi.nudgeplus.tmsbeans.model.request.process.CompleteProcess;

/**
 * 待办消息接口
 *
 * @author shizhen
 */
public class ProcessService {


    /**
     * 根据用户openid使用指定的ACCESS_TOKEN完成待办消息
     *
     * @param completeProcess 完成待办消息实体
     * @return 消息id
     */
    public static void processComplete(CompleteProcess completeProcess) {
        processComplete(completeProcess, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN完成待办消息
     *
     * @param completeProcess 完成待办消息实体
     * @return 消息id
     */
    public static void processComplete(CompleteProcess completeProcess, String token) {
        if (completeProcess == null) {
            throw new IllegalMessageException();
        }
        String path = PathConstants.BASE_URL + PathConstants.COMPLETE_PROCESS_MSG_PATG;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(path, token,
            JsonUtils.beanToJson(completeProcess), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
    }
}