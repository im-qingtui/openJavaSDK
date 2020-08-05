package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 分页获取组织机构下用户信息请求参数实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class RequestPagedOrgUserInfo extends RequestPagedUserInfo {

    private String orgId;

}