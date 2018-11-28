package com.cisdi.nudgeplus.tmsbeans.model.request.textcard;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import java.util.List;

/**
 * 文本卡片消息请求实体
 *
 * @author shizhen
 */
public class TextCardMsg implements Message {

    private String title;//标题
    private String url;//点击后跳转的url
    private String button_text;//按钮文字
    private List<TextCardContent> content_list;//内容

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getButton_text() {
        return button_text;
    }

    public List<TextCardContent> getContent_list() {
        return content_list;
    }

    public void setContent_list(List<TextCardContent> content_list) {
        this.content_list = content_list;
    }

    public void setButton_text(String button_text) {
        this.button_text = button_text;
    }
}