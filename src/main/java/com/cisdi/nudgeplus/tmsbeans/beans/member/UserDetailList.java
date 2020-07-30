package com.cisdi.nudgeplus.tmsbeans.beans.member;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 用户详情实体
 * Date:2020/7/29
 *
 * @author GuanZhong
 */
public class UserDetailList extends BaseResult {

    @SerializedName("result_list")
    private List<UserDetail> resultList;

    public List<UserDetail> getResultList() {
        return resultList;
    }

    public void setResultList(List<UserDetail> resultList) {
        this.resultList = resultList;
    }
}
