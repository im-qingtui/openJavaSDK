package com.cisdi.nudgeplus.tmsbeans.beans.member;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户详情实体 Date:2020/7/29
 *
 * @author GuanZhong
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class UserDetailList extends BaseResult {

    private List<UserDetail> resultList;

}
