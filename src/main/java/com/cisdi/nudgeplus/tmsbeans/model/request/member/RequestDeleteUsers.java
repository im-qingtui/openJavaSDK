package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量删除成员的请求参数实体类
 *
 * @author shizhen
 */
@Data
@NoArgsConstructor
public class RequestDeleteUsers implements Serializable {

    private String domainId;

    private List<Account> users;

}
