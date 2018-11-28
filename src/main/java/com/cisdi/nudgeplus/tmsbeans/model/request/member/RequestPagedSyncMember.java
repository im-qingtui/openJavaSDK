package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;

/**
 * 同步成员请求参数实体类
 *
 * @author shizhen
 */
public class RequestPagedSyncMember implements Serializable {

    private Long syncTime;//同步时间
    private String domainId;//团队id
    private Integer pageSize;//分页大小
    private Integer requestPage;//请求页数

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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRequestPage() {
        return requestPage;
    }

    public void setRequestPage(Integer requestPage) {
        this.requestPage = requestPage;
    }
}