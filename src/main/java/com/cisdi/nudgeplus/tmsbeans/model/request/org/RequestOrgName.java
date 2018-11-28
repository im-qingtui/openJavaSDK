package com.cisdi.nudgeplus.tmsbeans.model.request.org;

import java.io.Serializable;

/**
 * 组织机构修改名称请求参数实体类
 *
 * @author shizhen
 */
public class RequestOrgName implements Serializable {

    private String orgId;//组织机构id
    private String name;//组织机构名称
    private String domainId;//团队id
    private Integer sequence;//组织机构顺序
    private Boolean autoSequence;//自动排序

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Boolean getAutoSequence() {
        return autoSequence;
    }

    public void setAutoSequence(Boolean autoSequence) {
        this.autoSequence = autoSequence;
    }
}