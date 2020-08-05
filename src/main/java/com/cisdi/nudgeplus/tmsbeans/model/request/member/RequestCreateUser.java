package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建用户请求参数实体类
 *
 * @author shizhen
 */
@Data
@NoArgsConstructor
public class RequestCreateUser implements Serializable {

    private String mobile;

    private String name;

    private String mail;

    private String orgId;

    private List<String> orgList;

    private String comment;

    private String domainId;

    private String password;

    private String employeeId;

}
