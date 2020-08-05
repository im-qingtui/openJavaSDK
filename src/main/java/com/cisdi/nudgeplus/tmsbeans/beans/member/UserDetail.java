package com.cisdi.nudgeplus.tmsbeans.beans.member;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户详情实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserDetail extends BaseResult {

    private String userId;

    private String name;

    private String mobile;

    private String mail;

    private String avatar;

    private String comment;

    private String accountId;

    private List<String> orgList;

    private String orgId;

    private String guest;

    private String employeeId;

}
