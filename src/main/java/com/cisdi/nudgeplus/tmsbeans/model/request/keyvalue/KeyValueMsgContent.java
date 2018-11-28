package com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.MsgColor;
import java.io.Serializable;

/**
 * 键值对消息内容实体类
 *
 * @author shizhen
 */
public class KeyValueMsgContent implements Serializable {

    private String key;//key文本
    private String value;//value文本
    private MsgColor msgValueColor;//消息value文本颜色
    private String valueColor;//value文本颜色

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public MsgColor getMsgValueColor() {
        return msgValueColor;
    }

    public void setMsgValueColor(MsgColor msgValueColor) {
        this.msgValueColor = msgValueColor;
        this.valueColor = msgValueColor.getValue();
    }
}