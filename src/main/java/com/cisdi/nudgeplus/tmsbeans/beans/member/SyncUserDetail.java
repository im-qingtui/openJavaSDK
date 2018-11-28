package com.cisdi.nudgeplus.tmsbeans.beans.member;


import com.google.gson.annotations.SerializedName;

/**
 * 同步用户详情实体类
 *
 * @author shizhen
 */
public class SyncUserDetail extends UserDetail {

    private static final long serialVersionUID = 1L;

    private String status;//状态
    @SerializedName("update_time")
    private String updateTime;//更新时间

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}