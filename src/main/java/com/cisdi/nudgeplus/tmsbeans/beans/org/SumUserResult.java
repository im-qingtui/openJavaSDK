package com.cisdi.nudgeplus.tmsbeans.beans.org;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;

/**
 * 用户人数结果实体类
 *
 * @author shizhen
 */
public class SumUserResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    private int memberCount;//人总数

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }
}