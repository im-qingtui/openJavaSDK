package com.cisdi.nudgeplus.tmsbeans.model.request.org;

import java.io.Serializable;
import lombok.Data;

/**
 * 同步组织机构请求参数实体类
 *
 * @author shizhen
 */
@Data
public class RequestOrgSycInfo implements Serializable {

    private Long syncTime;

    private String domainId;

}