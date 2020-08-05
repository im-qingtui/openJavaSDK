package com.cisdi.nudgeplus.tmsbeans.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageResult<DATA> extends BaseResult {

    private int code;

    private String msg;

    private String msgId;

    private DATA data;

}
