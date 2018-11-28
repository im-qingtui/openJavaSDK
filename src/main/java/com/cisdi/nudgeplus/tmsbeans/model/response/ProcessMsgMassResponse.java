package com.cisdi.nudgeplus.tmsbeans.model.response;

/**
 * 待办消息群发响应
 *
 * @author yiya
 */
public class ProcessMsgMassResponse {

    private String openId;
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
