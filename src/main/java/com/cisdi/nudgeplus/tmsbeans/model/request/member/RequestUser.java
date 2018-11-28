package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;

/**
 * 请求用户参数实体类
 *
 * @author shizhen
 */
public class RequestUser implements Serializable {

    private String domainId;//团队id
    private String accountId;//用户aid

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}