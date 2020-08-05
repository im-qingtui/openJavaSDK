package com.cisdi.nudgeplus.tmsbeans.beans;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AppMenuInfo extends BaseResult {

    private String appId;

    private String content;

    private int isDelete;

    private String id;

    private Date createTime;

}
