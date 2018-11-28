package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import java.util.List;

/**
 * 批量删除成员的请求参数实体类
 *
 * @author shizhen
 */
public class RequestDeleteUsers implements Serializable {

    private String domainId;//团队id
    private List<Account> users;//用户list

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public List<Account> getUsers() {
        return users;
    }

    public void setUsers(List<Account> users) {
        this.users = users;
    }
}