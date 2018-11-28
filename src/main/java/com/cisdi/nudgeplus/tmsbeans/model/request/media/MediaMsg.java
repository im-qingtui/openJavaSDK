package com.cisdi.nudgeplus.tmsbeans.model.request.media;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import com.google.gson.annotations.SerializedName;

/**
 * 媒体消息请求实体
 *
 * @author shizhen
 */
public class MediaMsg implements Message {

    @SerializedName("media_id")
    private String mediaId;//媒体id

    @SerializedName("getMedia_id")
    public String getMediaId() {
        return mediaId;
    }

    @Deprecated
    public void setMedia_id(String mediaId) {
        this.mediaId = mediaId;
    }
    public void setMediaId(String mediaId){
        this.mediaId = mediaId;
    }
}