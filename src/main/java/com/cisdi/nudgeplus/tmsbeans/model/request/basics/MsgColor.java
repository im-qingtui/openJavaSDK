package com.cisdi.nudgeplus.tmsbeans.model.request.basics;

import java.io.Serializable;

/**
 * 消息颜色
 *
 * @author shizhen
 */
public enum MsgColor implements Serializable {

    /**
     * 黑色
     */
    BLACK("black"),
    /**
     * 高亮
     */
    HIGHLIGHT("highlight"),
    /**
     * 灰色
     */
    GRAY("gray");

    private String value;

    MsgColor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}