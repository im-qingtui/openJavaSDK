package com.cisdi.nudgeplus.tmsbeans.beans.org;


import com.google.gson.annotations.SerializedName;

/**
 * 组织机构同步信息实体类
 *
 * @author shizhen
 */
public class OrgSync extends OrgBaseResult {

    private static final long serialVersionUID = 1L;

    @SerializedName("update_time")
    private String updateTime;//更新时间
    private Integer status;//状态，1为删除，0为未删除

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}