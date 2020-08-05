package com.cisdi.nudgeplus.sdk.exception;

public class IllegalMessageException extends RuntimeException {

    public IllegalMessageException() {
        super("非法的消息体");
    }

    public IllegalMessageException(String msg) {
        super(msg);
    }

    public IllegalMessageException(String msg, Throwable e) {
        super(msg, e);
    }

}
