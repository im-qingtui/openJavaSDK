package com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.MsgColor;
import java.io.Serializable;
import lombok.Data;

/**
 * 键值对消息内容实体类
 *
 * @author shizhen
 */
@Data
public class KeyValueMsgContent implements Serializable {

    private String key;

    private String value;

    private MsgColor msgValueColor;

    private String valueColor;

}