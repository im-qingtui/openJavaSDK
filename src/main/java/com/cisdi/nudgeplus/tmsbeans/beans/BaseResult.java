package com.cisdi.nudgeplus.tmsbeans.beans;

import java.io.Serializable;

public class BaseResult extends BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int errcode;

    private String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

}
