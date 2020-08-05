package com.cisdi.nudgeplus.tmsbeans.beans.org;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 组织机构树结果实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class OrgTreeResultResult extends OrgBaseResult {

    private List<OrgTreeResultResult> children;

}