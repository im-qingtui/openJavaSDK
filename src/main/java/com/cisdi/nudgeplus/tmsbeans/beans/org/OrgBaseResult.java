package com.cisdi.nudgeplus.tmsbeans.beans.org;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 组织机构基础信息实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class OrgBaseResult extends BaseResult {

    private String id;

    private String name;

    private String parentId;

    private Integer sequence;

    private Integer grade;

}
