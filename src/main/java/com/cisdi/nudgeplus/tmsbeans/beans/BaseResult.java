package com.cisdi.nudgeplus.tmsbeans.beans;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BaseResult extends BaseBean implements Serializable {

    private int errcode;

    private String errmsg;

}
