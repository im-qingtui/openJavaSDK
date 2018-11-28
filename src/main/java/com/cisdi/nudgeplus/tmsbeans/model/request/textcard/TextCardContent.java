package com.cisdi.nudgeplus.tmsbeans.model.request.textcard;

import java.io.Serializable;

/**
 * 文本卡片消息内容实体类
 *
 * @author shizhen
 */
public class TextCardContent implements Serializable {

    private String text;//标题
    private ContentAttr attr;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ContentAttr getAttr() {
        return attr;
    }

    public void setAttr(ContentAttr attr) {
        this.attr = attr;
    }
}