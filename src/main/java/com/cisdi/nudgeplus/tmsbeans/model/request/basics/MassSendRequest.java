package com.cisdi.nudgeplus.tmsbeans.model.request.basics;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 指定用户群发消息请求体
 *
 * @author yiya
 */
@Data
public class MassSendRequest<T extends Message> implements Serializable {

    private List<String> toUsers;

    private T message;

}
