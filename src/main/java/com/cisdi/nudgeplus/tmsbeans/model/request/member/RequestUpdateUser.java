package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.util.List;

/**
 * 更新用户请求参数实体
 *
 * @author shizhen
 */
public class RequestUpdateUser extends RequestUser {

    private String name;//姓名
    private String orgId;//组织机构id
    private List<String> orgList;//组织机构list
    private String comment;//详情
    private String employeeId;//工号

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public List<String> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<String> orgList) {
        this.orgList = orgList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}