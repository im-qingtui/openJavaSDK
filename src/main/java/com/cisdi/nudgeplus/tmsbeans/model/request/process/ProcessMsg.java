package com.cisdi.nudgeplus.tmsbeans.model.request.process;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import lombok.Data;

/**
 * 待办消息实体
 *
 * @author shizhen
 */
@Data
public class ProcessMsg implements Message {

    private String title;

    private String body;

    private String url;

}