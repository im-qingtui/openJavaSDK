package com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.MsgColor;
import java.io.Serializable;

/**
 * 带颜色的文本实体类
 *
 * @author shizhen
 */

public class ColorText implements Serializable {

    private String text;//文本内容
    private MsgColor msgColor;//消息颜色
    private String color;//颜色

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MsgColor getMsgColor() {
        return msgColor;
    }

    public void setMsgColor(MsgColor msgColor) {
        this.msgColor = msgColor;
        this.color = msgColor.getValue();
    }
}