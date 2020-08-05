package com.cisdi.nudgeplus.tmsbeans.beans.domain;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 团队结果
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class DomainResult extends BaseResult {

    private String domainId;

}