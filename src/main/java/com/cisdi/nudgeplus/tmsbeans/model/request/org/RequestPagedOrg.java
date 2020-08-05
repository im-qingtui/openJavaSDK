package com.cisdi.nudgeplus.tmsbeans.model.request.org;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分页获取组织机构请求参数实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RequestPagedOrg extends RequestOrg {

    private int pageSize;

    private int requestPage;

}