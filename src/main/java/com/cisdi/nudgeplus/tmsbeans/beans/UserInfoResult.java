package com.cisdi.nudgeplus.tmsbeans.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoResult extends BaseResult {

    private String openid;

    private String username;

    private String uid;

    private String avatar;

    private String unionId;

    private String domainId;

    private String userId;

    private int role;

    private boolean domainManager;

    private boolean appManager;

    private String workId;

}
