package com.cisdi.nudgeplus.tmsbeans.model.request.basics;

import java.io.Serializable;
import lombok.Data;

/**
 * 群消息发送请求体
 *
 * @author yiya
 */
@Data
public class ChannelSendRequest<T extends Message> implements Serializable {

    private String channelId;

    private T message;

}
