package com.cisdi.nudgeplus.tmsbeans.beans;

public class MediaResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    private String type;
    private String media_id;
    private long created_at;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return media_id;
    }

    @Deprecated
    public String getMedia_id() {
        return media_id;
    }

    public void setMediaId(String mediaId) {
        this.media_id = mediaId;
    }

    @Deprecated
    public void setMedia_id(String mediaId) {
        this.media_id = mediaId;
    }

    public long getCreateAt() {
        return created_at;
    }

    @Deprecated
    public long getCreated_at() {
        return created_at;
    }

    public void setCreateAt(long createdAt) {
        this.created_at = createdAt;
    }

    @Deprecated
    public void setCreated_at(long createdAt) {
        this.created_at = createdAt;
    }

}
