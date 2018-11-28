package com.cisdi.nudgeplus.tmsbeans.beans;

public class MessageResult<DATA> extends BaseResult {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private String msg_id;
    private DATA data;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public DATA getData() {
        return data;
    }

    public void setData(DATA data) {
        this.data = data;
    }

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
    public void setMsg_id(String msgId) {
        this.msg_id = msgId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
