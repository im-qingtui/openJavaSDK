package com.cisdi.nudgeplus.tmsbeans.beans;

public class ErrorResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    public ErrorResult(int errcode, String errmsg) {
        this.setErrcode(errcode);
        this.setErrmsg(errmsg);
    }

}
