package com.cisdi.nudgeplus.tmsbeans.beans.member;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 同步用户详情实体类
 *
 * @author shizhen
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SyncUserDetail extends UserDetail {

    private String status;

    private String updateTime;

}
