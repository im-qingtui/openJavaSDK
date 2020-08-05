package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量创建用户请求参数实体类
 *
 * @author shizhen
 */
@Data
@NoArgsConstructor
public class RequestBatchCreateUsers implements Serializable {

    private String domainId;

    private List<RequestCreateUser> users;

}
