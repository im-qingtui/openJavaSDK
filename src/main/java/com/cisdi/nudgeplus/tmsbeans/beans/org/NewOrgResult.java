package com.cisdi.nudgeplus.tmsbeans.beans.org;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 新建组织机构返回结果实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class NewOrgResult extends BaseResult {

    private String orgId;

}