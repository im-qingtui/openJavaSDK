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


    private List<String> accountIdList;

    private String domainId;

    public List<String> getAccountIdList() {
        return accountIdList;
    }

    public void setAccountIdList(List<String> accountIdList) {
        this.accountIdList = accountIdList;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }
}
