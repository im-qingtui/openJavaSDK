package com.cisdi.nudgeplus.tmsbeans.model.request.textcard;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.MsgColor;
import java.io.Serializable;
import lombok.Data;

/**
 * 内容元素实体类
 *
 * @author shizhen
 */
@Data
public class ContentAttr implements Serializable {

    private MsgColor msgColor;

    private String color;

    public void setColor(MsgColor msgColor) {
        this.msgColor = msgColor;
        this.color = msgColor.getValue();
    }
}