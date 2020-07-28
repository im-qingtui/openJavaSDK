package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import java.io.Serializable;

public class ImageMsg extends BaseBean implements Serializable, Message {

    private String media_id;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

}
