package com.cisdi.nudgeplus.tmsbeans.beans.org;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.google.gson.annotations.SerializedName;

/**
 * 新建组织机构返回结果实体类
 *
 * @author shizhen
 */
public class NewOrgResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    @SerializedName("org_id")
    private String orgId;//组织机构id

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}