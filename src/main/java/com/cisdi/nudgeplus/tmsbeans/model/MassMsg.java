package com.cisdi.nudgeplus.tmsbeans.model;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class MassMsg extends MsgModel {

    private List<String> toUsers;

}
