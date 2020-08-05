package com.cisdi.nudgeplus.tmsbeans.model.request.org;

import java.io.Serializable;
import lombok.Data;

/**
 * 组织机构请求参数实体类
 *
 * @author shizhen
 */
@Data
public class RequestOrg implements Serializable {

    private String orgId;

    private String domainId;

}