package com.cisdi.nudgeplus.tmsbeans.model.request.basics;

import java.io.Serializable;

/**
 * 服务号群发请求
 *
 * @author shizhen
 */
public class ServiceSendRequest<T extends Message> implements Serializable {

    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}