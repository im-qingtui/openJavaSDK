package com.cisdi.nudgeplus.tmsbeans.beans.org;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * 分页请求组织机构结果的实体类参数
 *
 * @author shizhen
 */
public class PagedOrgResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    @SerializedName("total_count")
    private int totalCount;//总数
    @SerializedName("has_more")
    private boolean hasMore;//没有更多的数据,false没有更多数据，true还有更多数据
    @SerializedName("result_list")
    private List<OrgBaseResult> resultList;//得到请求的数据

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

    public List<OrgBaseResult> getResultList() {
        return resultList;
    }

    public void setResultList(List<OrgBaseResult> resultList) {
        this.resultList = resultList;
    }
}