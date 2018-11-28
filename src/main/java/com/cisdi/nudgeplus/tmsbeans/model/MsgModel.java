package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import com.cisdi.nudgeplus.tmsbeans.constants.MsgType;
import java.io.Serializable;

public class MsgModel extends BaseBean implements Serializable {

    private String msgtype;

    private TextMsg text;

    private ImageMsg image;

    private RichMsg richMsg;

    private NewsMsg newsMsg;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public TextMsg getText() {
        if (!MsgType.TEXT.equals(this.msgtype)) {
            return null;
        }
        return text;
    }

    public void setText(TextMsg text) {
        this.text = text;
    }

    public ImageMsg getImage() {
        if (!MsgType.IMAGE.equals(this.msgtype)) {
            return null;
        }
        return image;
    }

    public void setImage(ImageMsg image) {
        this.image = image;
    }

    public RichMsg getRichMsg() {
        if (!MsgType.RICHMSG.equals(this.msgtype)) {
            return null;
        }
        return richMsg;
    }

    public void setRichMsg(RichMsg richMsg) {
        this.richMsg = richMsg;
    }

    public NewsMsg getNewsMsg() {
        return newsMsg;
    }

    public void setNewsMsg(NewsMsg newsMsg) {
        this.newsMsg = newsMsg;
    }

}
