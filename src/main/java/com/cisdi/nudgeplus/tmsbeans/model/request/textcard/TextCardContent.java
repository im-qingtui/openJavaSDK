package com.cisdi.nudgeplus.tmsbeans.model.request.textcard;

import java.io.Serializable;
import lombok.Data;

/**
 * 文本卡片消息内容实体类
 *
 * @author shizhen
 */
@Data
public class TextCardContent implements Serializable {

    private String text;

    private ContentAttr attr;

}