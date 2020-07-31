package com.cisdi.nudgeplus.tmsbeans.beans.channel;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 群成员Id
 * Date:2020/7/31
 *
 * @author GuanZhong
 */

public class ChannelMemberResult extends BaseResult {
    @SerializedName("result_list")
    private List<String> resultList;

    public List<String> getResultList() {
        return resultList;
    }

    public void setResultList(List<String> resultList) {
        this.resultList = resultList;
    }
}
