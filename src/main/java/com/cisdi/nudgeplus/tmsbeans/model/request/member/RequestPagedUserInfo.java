package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;

/**
 * 分页获取用户信息请求参数实体
 *
 * @author shizhen
 */
public class RequestPagedUserInfo implements Serializable {

    private int pageSize;//每页大小
    private int requestPage;//请求页数
    private String domainId;//团队id

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRequestPage() {
        return requestPage;
    }

    public void setRequestPage(int requestPage) {
        this.requestPage = requestPage;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }
}