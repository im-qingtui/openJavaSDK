package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MessageResult;
import com.cisdi.nudgeplus.tmsbeans.model.request.process.CompleteProcess;

/**
 * 待办消息接口
 *
 * @author shizhen
 */
public final class ProcessService {

    /**
     * 根据用户openid完成待办消息
     *
     * @param completeProcess 完成待办消息实体
     */
    public static void processComplete(CompleteProcess completeProcess) {
        if (completeProcess == null) {
            throw new IllegalMessageException();
        }

        String path = PathConstants.COMPLETE_PROCESS_MSG_PATH;

        ClientUtils.post(path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(completeProcess), MessageResult.class);
    }

    private ProcessService() {
    }
}