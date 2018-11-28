package com.cisdi.nudgeplus.tmsbeans.beans.domain;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;

/**
 * 团队结果
 *
 * @author shizhen
 */
public class DomainResult extends BaseResult {

    private static final long serialVersionUID = 1L;
    private String domainId;//团队id

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }


}