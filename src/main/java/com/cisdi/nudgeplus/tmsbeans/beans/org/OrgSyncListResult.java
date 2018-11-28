package com.cisdi.nudgeplus.tmsbeans.beans.org;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import java.util.List;

/**
 * 组织机构同步结果实体类
 *
 * @author shizhen
 */
public class OrgSyncListResult extends BaseResult {

    private static final long serialVersionUID = 1L;
    private List<OrgSync> list;

    public List<OrgSync> getList() {
        return list;
    }

    public void setList(List<OrgSync> list) {
        this.list = list;
    }
}