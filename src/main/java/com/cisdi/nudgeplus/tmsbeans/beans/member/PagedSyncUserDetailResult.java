package com.cisdi.nudgeplus.tmsbeans.beans.member;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * 分页同步用户详细信息实体类
 *
 * @author shizhen
 */
public class PagedSyncUserDetailResult extends BaseResult {

    private static final long serialVersionUID = 1L;
    @SerializedName("total_count")
    private int totalCount;//总数
    @SerializedName("has_more")
    private boolean hasMore;//是否还有更多数据，false没有更多数据，true还有更多数据
    @SerializedName("result_list")
    private List<SyncUserDetail> resultList;//得到的请求的数据

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<SyncUserDetail> getResultList() {
        return resultList;
    }

    public void setResultList(List<SyncUserDetail> resultList) {
        this.resultList = resultList;
    }
}