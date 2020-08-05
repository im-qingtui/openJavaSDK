package com.cisdi.nudgeplus.tmsbeans.model.request.basics;

import java.io.Serializable;
import lombok.Data;

/**
 * 服务号群发请求
 *
 * @author shizhen
 */
@Data
public class ServiceSendRequest<T extends Message> implements Serializable {

    private T message;

}