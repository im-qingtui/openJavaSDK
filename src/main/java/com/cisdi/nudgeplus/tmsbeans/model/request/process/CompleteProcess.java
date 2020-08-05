package com.cisdi.nudgeplus.tmsbeans.model.request.process;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.RequestParamEntity;
import lombok.Data;

/**
 * 待办消息已处理请求实体
 *
 * @author yiya
 */
@Data
public class CompleteProcess implements RequestParamEntity {

    private String openId;

    private String msgId;

}
