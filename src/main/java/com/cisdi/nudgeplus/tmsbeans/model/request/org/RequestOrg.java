package com.cisdi.nudgeplus.tmsbeans.model.request.org;

import java.io.Serializable;

/**
 * 组织机构请求参数实体类
 *
 * @author shizhen
 */
public class RequestOrg implements Serializable {

    private String orgId;//组织机构id
    private String domainId;//团队id

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }
}