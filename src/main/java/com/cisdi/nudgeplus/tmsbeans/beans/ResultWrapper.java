package com.cisdi.nudgeplus.tmsbeans.beans;


import lombok.Data;

@Data
public class ResultWrapper<T extends BaseResult> {

    private boolean isError = false;

    private T result;

    private ErrorResult errorResult;

}
