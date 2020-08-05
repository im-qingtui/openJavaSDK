package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页获取用户信息请求参数实体
 *
 * @author shizhen
 */
@Data
@NoArgsConstructor
public class RequestPagedUserInfo implements Serializable {

    private int pageSize;

    private int requestPage;

    private String domainId;

}
