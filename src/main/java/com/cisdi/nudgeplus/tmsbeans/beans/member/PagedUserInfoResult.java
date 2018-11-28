package com.cisdi.nudgeplus.tmsbeans.beans.member;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * 用户分页信息
 *
 * @author shizhen
 */
public class PagedUserInfoResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    @SerializedName("total_count")
    private Integer totalCount;//总数
    @SerializedName("has_more")
    private Boolean hasMore;//是否还有数据，false没有，true还有
    @SerializedName("result_list")
    private List<UserDetail> resultList;//得到请求的数据

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<UserDetail> getResultList() {
        return resultList;
    }

    public void setResultList(List<UserDetail> resultList) {
        this.resultList = resultList;
    }
}