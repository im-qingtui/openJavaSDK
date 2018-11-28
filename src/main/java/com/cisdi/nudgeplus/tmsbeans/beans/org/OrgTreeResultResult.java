package com.cisdi.nudgeplus.tmsbeans.beans.org;

import java.util.List;

/**
 * 组织机构树结果实体类
 *
 * @author shizhen
 */
public class OrgTreeResultResult extends OrgBaseResult {

    private static final long serialVersionUID = 1L;
    private List<OrgTreeResultResult> children;

    public List<OrgTreeResultResult> getChildren() {
        return children;
    }

    public void setChildren(List<OrgTreeResultResult> children) {
        this.children = children;
    }
}