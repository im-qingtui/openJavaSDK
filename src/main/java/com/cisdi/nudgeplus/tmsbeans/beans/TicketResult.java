package com.cisdi.nudgeplus.tmsbeans.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ticket返回结果实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TicketResult extends BaseResult {

    private String ticket;

    private Integer expiresIn;

}