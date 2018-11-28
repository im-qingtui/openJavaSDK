package com.cisdi.nudgeplus.tmsbeans.beans;

public class MessageSendStatus extends BaseResult {

    public static final String SEND_SUCCESS = "SEND_SUCCESS";
    public static final String SEND_FAILD = "SEND_FAILD";
    public static final String SENDING = "SENDING";

    private static final long serialVersionUID = 1L;

    private String msg_id;
    private String msg_status;
    private double rate;

    public String getMsgId() {
        return msg_id;
    }

    @Deprecated
    public String getMsg_id() {
        return msg_id;
    }

    public void setMsgId(String msgId) {
        this.msg_id = msgId;
    }

    @Deprecated
    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsgStatus() {
        return msg_status;
    }

    @Deprecated
    public String getMsg_status() {
        return msg_status;
    }

    public void setMsgStatus(String msgStatus) {
        this.msg_status = msgStatus;
    }

    @Deprecated
    public void setMsg_status(String msgStatus) {
        this.msg_status = msgStatus;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
