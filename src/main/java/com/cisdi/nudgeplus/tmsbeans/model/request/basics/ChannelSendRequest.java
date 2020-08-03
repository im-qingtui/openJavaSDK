package com.cisdi.nudgeplus.tmsbeans.model.request.basics;

import java.io.Serializable;

/**
 * 群消息发送请求体
 *
 * @author yiya
 */
public class ChannelSendRequest<T extends Message> implements Serializable {

    private String channelId;

    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
