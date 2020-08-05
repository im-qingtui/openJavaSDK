package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MsgModel extends BaseBean implements Serializable {

    private String msgtype;

    private TextMsg text;

    private ImageMsg image;

    private RichMsg richMsg;

    private NewsMsg newsMsg;

}
