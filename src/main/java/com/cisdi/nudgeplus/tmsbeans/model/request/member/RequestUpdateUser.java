package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 更新用户请求参数实体
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class RequestUpdateUser extends RequestUser {

    private String name;

    private String orgId;

    private List<String> orgList;

    private String comment;

    private String employeeId;

}
