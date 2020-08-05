package com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.MsgColor;
import java.io.Serializable;
import lombok.Data;

/**
 * 带颜色的文本实体类
 *
 * @author shizhen
 */
@Data
public class ColorText implements Serializable {

    private String text;

    private MsgColor msgColor;

    private String color;

    public void setMsgColor(MsgColor msgColor) {
        this.msgColor = msgColor;
        this.color = msgColor.getValue();
    }
}