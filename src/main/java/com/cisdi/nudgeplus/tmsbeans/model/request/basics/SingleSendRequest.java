package com.cisdi.nudgeplus.tmsbeans.model.request.basics;

import java.io.Serializable;

/**
 * 单发消息请求体
 *
 * @author yiya
 */
public class SingleSendRequest<T extends Message> implements Serializable {

    private String to_user;

    private T message;

    public String getTo_user() {
        return to_user;
    }

    public void setTo_user(String to_user) {
        this.to_user = to_user;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
