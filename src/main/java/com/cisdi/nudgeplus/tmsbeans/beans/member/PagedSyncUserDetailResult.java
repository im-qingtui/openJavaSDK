package com.cisdi.nudgeplus.tmsbeans.beans.member;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 分页同步用户详细信息实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PagedSyncUserDetailResult extends BaseResult {

    private int totalCount;

    private boolean hasMore;

    private List<SyncUserDetail> resultList;

}
