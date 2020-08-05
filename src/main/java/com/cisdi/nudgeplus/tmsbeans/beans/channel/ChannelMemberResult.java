package com.cisdi.nudgeplus.tmsbeans.beans.channel;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 群成员Id Date:2020/7/31
 *
 * @author GuanZhong
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ChannelMemberResult extends BaseResult {

    private List<String> resultList;

}
