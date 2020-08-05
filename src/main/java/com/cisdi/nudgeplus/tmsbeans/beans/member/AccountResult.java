package com.cisdi.nudgeplus.tmsbeans.beans.member;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 账号结果实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AccountResult extends BaseResult {

    private String accountId;

}
