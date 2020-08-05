package com.cisdi.nudgeplus.tmsbeans.beans;

import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import java.io.Serializable;

public class BaseBean implements Serializable {

    @Override
    public String toString() {
        return JsonUtils.beanToSnakeJson(this);
    }

}
