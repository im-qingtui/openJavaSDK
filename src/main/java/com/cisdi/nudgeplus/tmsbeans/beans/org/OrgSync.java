package com.cisdi.nudgeplus.tmsbeans.beans.org;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 组织机构同步信息实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class OrgSync extends OrgBaseResult {

    private String updateTime;

    private Integer status;

}