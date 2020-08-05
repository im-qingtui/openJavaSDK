package com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import java.util.List;
import lombok.Data;

/**
 * 键值对消息参数实体类
 *
 * @author shizhen
 */
@Data
public class KeyValueMsg implements Message {

    private String title;

    private ColorText subTitle;

    private String url;

    private List<KeyValueMsgContent> content;

    private ColorText footer;

    private String buttonText;

}