package com.cisdi.nudgeplus.tmsbeans.model.request.org;

import java.io.Serializable;
import lombok.Data;

/**
 * 组织机构修改名称请求参数实体类
 *
 * @author shizhen
 */
@Data
public class RequestOrgName implements Serializable {

    private String orgId;

    private String name;

    private String domainId;

    private Integer sequence;

    private Boolean autoSequence;

}