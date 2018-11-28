package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;

/**
 * 用户请求参数实体类
 *
 * @author shizhen
 */
public class Account implements Serializable {

    private String accountId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Account(String accountId){
        this.accountId = accountId;
    }
}