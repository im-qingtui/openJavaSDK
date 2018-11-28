package com.cisdi.nudgeplus.tmsbeans.model.request.basics;

import java.io.Serializable;
import java.util.List;

/**
 * 指定用户群发消息请求体
 *
 * @author yiya
 */
public class MassSendRequest<T extends Message> implements Serializable {

    private List<String> to_users;
    private T message;

    public List<String> getTo_users() {
        return to_users;
    }

    public void setTo_users(List<String> to_users) {
        this.to_users = to_users;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
