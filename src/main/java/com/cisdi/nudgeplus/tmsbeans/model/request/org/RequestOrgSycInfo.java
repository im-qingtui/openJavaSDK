package com.cisdi.nudgeplus.tmsbeans.model.request.org;

import java.io.Serializable;

/**
 * 同步组织机构请求参数实体类
 *
 * @author shizhen
 */
public class RequestOrgSycInfo implements Serializable {

    private Long syncTime;
    private String domainId;

    public Long getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Long syncTime) {
        this.syncTime = syncTime;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }
}