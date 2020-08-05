package com.cisdi.nudgeplus.tmsbeans.model.request.media;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import lombok.Data;

/**
 * 媒体消息请求实体
 *
 * @author shizhen
 */
@Data
public class MediaMsg implements Message {

    private String mediaId;

}