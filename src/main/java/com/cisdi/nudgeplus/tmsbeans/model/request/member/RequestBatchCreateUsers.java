package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import java.util.List;

/**
 * 批量创建用户请求参数实体类
 *
 * @author shizhen
 */
public class RequestBatchCreateUsers implements Serializable {

    private String domainId;//团队id
    private List<RequestCreateUser> users;//用户list

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public List<RequestCreateUser> getUsers() {
        return users;
    }

    public void setUsers(List<RequestCreateUser> users) {
        this.users = users;
    }
}