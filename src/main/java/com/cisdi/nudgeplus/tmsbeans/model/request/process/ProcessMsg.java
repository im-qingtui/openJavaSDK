package com.cisdi.nudgeplus.tmsbeans.model.request.process;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;

/**
 * 待办消息实体
 *
 * @author shizhen
 */
public class ProcessMsg implements Message {

    private String title;
    private String body;
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}