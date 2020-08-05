package com.cisdi.nudgeplus.tmsbeans.beans.member;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户分页信息
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PagedUserInfoResult extends BaseResult {

    private Integer totalCount;

    private Boolean hasMore;

    private List<UserDetail> resultList;

}