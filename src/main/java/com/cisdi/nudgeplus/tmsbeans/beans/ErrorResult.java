package com.cisdi.nudgeplus.tmsbeans.beans;

public class ErrorResult extends BaseResult {

    public ErrorResult(int errcode, String errmsg) {
        this.setErrcode(errcode);
        this.setErrmsg(errmsg);
    }

}
