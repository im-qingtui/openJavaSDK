package com.cisdi.nudgeplus.tmsbeans.model.request.member;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户请求参数实体类
 *
 * @author shizhen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    private String accountId;

}