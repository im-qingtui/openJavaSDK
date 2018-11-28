package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import java.io.Serializable;
import java.util.List;

public class RichMsg extends BaseBean implements Serializable {

    private String title;

    private long xtime;

    private String body;

    private List<RichMedia> imgList;

    private List<RichUrl> urlList;

    private RichMedia attachment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<RichMedia> getImgList() {
        return imgList;
    }

    public void setImgList(List<RichMedia> imgList) {
        this.imgList = imgList;
    }

    public List<RichUrl> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<RichUrl> urlList) {
        this.urlList = urlList;
    }

    public RichMedia getAttachment() {
        return attachment;
    }

    public void setAttachment(RichMedia attachment) {
        this.attachment = attachment;
    }

    public long getXtime() {
        return xtime;
    }

    public void setXtime(long xtime) {
        this.xtime = xtime;
    }

}
