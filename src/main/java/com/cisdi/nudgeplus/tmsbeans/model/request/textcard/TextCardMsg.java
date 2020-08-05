package com.cisdi.nudgeplus.tmsbeans.model.request.textcard;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import java.util.List;
import lombok.Data;

/**
 * 文本卡片消息请求实体
 *
 * @author shizhen
 */
@Data
public class TextCardMsg implements Message {

    private String title;

    private String url;

    private String buttonText;

    private List<TextCardContent> contentList;

}