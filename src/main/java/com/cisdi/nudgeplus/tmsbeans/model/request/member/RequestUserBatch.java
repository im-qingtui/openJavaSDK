package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import java.util.List;

/**
 * 批量请求用户参数实体类
 * Date:2020/7/29
 *
 * @author GuanZhong
 */
public class RequestUserBatch implements Serializable {

    private List<String> accountIds;

    private String domainId;

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }
}
