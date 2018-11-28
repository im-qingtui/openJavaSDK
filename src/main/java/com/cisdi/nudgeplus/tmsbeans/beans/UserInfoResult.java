package com.cisdi.nudgeplus.tmsbeans.beans;

import com.google.gson.annotations.SerializedName;

public class UserInfoResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    private String openid;

    private String username;

    private String uid;

    private String avatar;

    private String unionid;

    private String domainid;

    private String userid;

    private int role;

    @SerializedName("domain_manager")
    private boolean domainManager;

    @SerializedName("app_manager")
    private boolean appManager;

    private String workId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getDomainid() {
        return domainid;
    }

    public void setDomainid(String domainid) {
        this.domainid = domainid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isDomainManager() {
        return domainManager;
    }

    public void setDomainManager(boolean domainManager) {
        this.domainManager = domainManager;
    }

    public boolean isAppManager() {
        return appManager;
    }

    public void setAppManager(boolean appManager) {
        this.appManager = appManager;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    @Deprecated
    public boolean getDomain_manager() {
        return domainManager;
    }

    @Deprecated
    public void setDomain_manager(boolean isDomainManager) {
        this.domainManager = isDomainManager;
    }

    @Deprecated
    public boolean getApp_manager() {
        return appManager;
    }

    @Deprecated
    public void setApp_manager(boolean isAppManager) {
        this.appManager = isAppManager;
    }
}
