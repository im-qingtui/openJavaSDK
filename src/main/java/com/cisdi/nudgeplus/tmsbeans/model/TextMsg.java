package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import java.io.Serializable;

public class TextMsg extends BaseBean implements Serializable, Message {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
