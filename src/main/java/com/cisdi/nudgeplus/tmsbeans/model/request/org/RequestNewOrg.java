package com.cisdi.nudgeplus.tmsbeans.model.request.org;

import java.io.Serializable;

/**
 * 创建新的组织机构请求参数实体类
 *
 * @author shizhen
 */
public class RequestNewOrg implements Serializable {

    private String name;//组织机构名
    private String parentId;//组织机构父节点
    private String domainId;//团队id
    private Integer sequence;//顺序
    private Boolean autoSequence;//自动排序

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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