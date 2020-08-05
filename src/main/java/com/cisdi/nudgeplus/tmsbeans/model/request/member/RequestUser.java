package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求用户参数实体类
 *
 * @author shizhen
 */
@Data
@NoArgsConstructor
public class RequestUser implements Serializable {

    private String domainId;

    private String accountId;

}
