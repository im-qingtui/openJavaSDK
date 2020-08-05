package com.cisdi.nudgeplus.tmsbeans.beans.org;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 组织机构同步结果实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class OrgSyncListResult extends BaseResult {

    private List<OrgSync> list;

}