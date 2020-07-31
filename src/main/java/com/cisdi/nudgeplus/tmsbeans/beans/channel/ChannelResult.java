package com.cisdi.nudgeplus.tmsbeans.beans.channel;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Description
 * Date:2020/7/29
 *
 * @author GuanZhong
 */
public class ChannelResult extends BaseResult {

    @SerializedName("result_list")
    private List<ChannelBaseInfo> resultList;

    public List<ChannelBaseInfo> getResultList() {
        return resultList;
    }

    public void setResultList(List<ChannelBaseInfo> resultList) {
        this.resultList = resultList;
    }
}