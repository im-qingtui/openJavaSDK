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

    private String unionid;

    private String domainid;

    private String userid;

    private int role;

    private boolean isDomainManager;

    private boolean isAppManager;

    private String workId;

}
