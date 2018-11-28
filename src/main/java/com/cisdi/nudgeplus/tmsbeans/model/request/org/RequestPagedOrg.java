package com.cisdi.nudgeplus.tmsbeans.model.request.org;

import java.io.Serializable;

/**
 * 分页获取组织机构请求参数实体类
 *
 * @author shizhen
 */
public class RequestPagedOrg extends RequestOrg {

    private int pageSize;//每页大小
    private int requestPage;//请求页数

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
}