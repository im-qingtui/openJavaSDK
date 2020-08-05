package com.cisdi.nudgeplus.tmsbeans.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Msg extends MsgModel {

    private String toUser;

}
