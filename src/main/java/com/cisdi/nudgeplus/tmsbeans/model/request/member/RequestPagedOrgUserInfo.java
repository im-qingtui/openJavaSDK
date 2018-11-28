package com.cisdi.nudgeplus.tmsbeans.model.request.member;

/**
 * 分页获取组织机构下用户信息请求参数实体类
 *
 * @author shizhen
 */
public class RequestPagedOrgUserInfo extends RequestPagedUserInfo {

    private String orgId;//组织机构id

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

}