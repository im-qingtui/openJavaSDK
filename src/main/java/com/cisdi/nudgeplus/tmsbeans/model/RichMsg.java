package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import java.io.Serializable;
import java.util.List;

public class RichMsg extends BaseBean implements Serializable, Message {

    private String title;

    private long xtime;

    private String body;

    private List<RichMedia> img_list;

    private List<RichUrl> url_list;

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

    public List<RichMedia> getImg_list() {
        return img_list;
    }

    public void setImg_list(List<RichMedia> img_list) {
        this.img_list = img_list;
    }

    public List<RichUrl> getUrl_list() {
        return url_list;
    }

    public void setUrl_list(List<RichUrl> url_list) {
        this.url_list = url_list;
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
