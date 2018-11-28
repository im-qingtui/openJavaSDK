package com.cisdi.nudgeplus.tmsbeans.model.request.process;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.RequestParamEntity;
import com.google.gson.annotations.SerializedName;

/**
 * 待办消息已处理请求实体
 *
 * @author yiya
 */

public class CompleteProcess implements RequestParamEntity {

    @SerializedName("open_id")
    private String openId;
    @SerializedName("msg_id")
    private String msgId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
