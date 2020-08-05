package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 同步成员请求参数实体类
 *
 * @author shizhen
 */
@Data
@NoArgsConstructor
public class RequestPagedSyncMember implements Serializable {

    private Long syncTime;

    private String domainId;

    private Integer pageSize;

    private Integer requestPage;

}
