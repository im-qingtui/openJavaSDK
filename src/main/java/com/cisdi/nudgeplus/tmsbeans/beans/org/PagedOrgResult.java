package com.cisdi.nudgeplus.tmsbeans.beans.org;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 分页请求组织机构结果的实体类参数
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PagedOrgResult extends BaseResult {

    private int totalCount;

    private boolean hasMore;

    private List<OrgBaseResult> resultList;

}
