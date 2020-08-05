package com.cisdi.nudgeplus.tmsbeans.beans.channel;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseResult;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Description Date:2020/7/29
 *
 * @author GuanZhong
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ChannelResult extends BaseResult {

    private List<ChannelBaseInfo> resultList;

}

