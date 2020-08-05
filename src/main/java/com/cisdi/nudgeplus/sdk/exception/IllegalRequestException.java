package com.cisdi.nudgeplus.sdk.exception;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;

public class IllegalRequestException extends RuntimeException {

    private BaseResult error;

    public IllegalRequestException() {
        super("请求路径或参数错误");
    }

    public IllegalRequestException(String msg) {
        super(msg);
    }

    public IllegalRequestException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public IllegalRequestException(BaseResult error) {
        super(error.toString());
        this.error = error;
    }

    public IllegalRequestException(BaseResult error, Throwable cause) {
        super(error.toString());
        this.error = error;
    }

    public BaseResult getError() {
        return this.error;
    }

}
