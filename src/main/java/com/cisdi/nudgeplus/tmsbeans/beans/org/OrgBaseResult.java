package com.cisdi.nudgeplus.tmsbeans.beans.org;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.google.gson.annotations.SerializedName;

/**
 * 组织机构基础信息实体类
 *
 * @author shizhen
 */
public class OrgBaseResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    private String id;//组织机构id
    private String name;//组织机构名称
    @SerializedName("parent_id")
    private String parentId;//父极id
    private Integer sequence;//组织机构顺序
    private Integer grade;//组织机构等级

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}