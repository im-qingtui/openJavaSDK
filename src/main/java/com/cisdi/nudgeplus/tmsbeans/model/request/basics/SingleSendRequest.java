package com.cisdi.nudgeplus.tmsbeans.model.request.basics;

import java.io.Serializable;
import lombok.Data;

/**
 * 单发消息请求体
 *
 * @author yiya
 */
@Data
public class SingleSendRequest<T extends Message> implements Serializable {

    private String toUser;

    private T message;

}
