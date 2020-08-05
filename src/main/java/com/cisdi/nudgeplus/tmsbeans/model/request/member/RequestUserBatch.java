package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 批量请求用户参数实体类
 * Date:2020/7/29
 *
 * @author GuanZhong
 */
@Data
@NoArgsConstructor
public class RequestUserBatch implements Serializable {

    private List<String> accountIds;

    private String domainId;

}

