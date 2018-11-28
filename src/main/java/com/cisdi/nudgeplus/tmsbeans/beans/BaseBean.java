package com.cisdi.nudgeplus.tmsbeans.beans;

import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import java.io.Serializable;

public class BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return JsonUtils.beanToJson(this);
    }

}
