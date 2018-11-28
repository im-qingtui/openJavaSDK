package com.cisdi.nudgeplus.tmsbeans.model.request.textcard;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.MsgColor;
import java.io.Serializable;

/**
 * 内容元素实体类
 *
 * @author shizhen
 */
public class ContentAttr implements Serializable {

    private MsgColor msgColor;//颜色
    private String color;

    public MsgColor getColor() {
        return msgColor;
    }

    public void setColor(MsgColor msgColor) {
        this.msgColor = msgColor;
        this.color = msgColor.getValue();
    }
}