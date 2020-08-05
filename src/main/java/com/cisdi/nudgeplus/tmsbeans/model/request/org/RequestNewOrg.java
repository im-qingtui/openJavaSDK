package com.cisdi.nudgeplus.tmsbeans.model.request.org;

import java.io.Serializable;
import lombok.Data;

/**
 * 创建新的组织机构请求参数实体类
 *
 * @author shizhen
 */
@Data
public class RequestNewOrg implements Serializable {

    private String name;

    private String parentId;

    private String domainId;

    private Integer sequence;

    private Boolean autoSequence;

}
