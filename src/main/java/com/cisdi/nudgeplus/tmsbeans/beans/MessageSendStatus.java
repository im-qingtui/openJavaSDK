package com.cisdi.nudgeplus.tmsbeans.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageSendStatus extends BaseResult {

    //TODO handle public property

    public static final String SEND_SUCCESS = "SEND_SUCCESS";

    public static final String SEND_FAILD = "SEND_FAILD";

    public static final String SENDING = "SENDING";

    private String msgId;

    private String msgStatus;

    private double rate;

}
