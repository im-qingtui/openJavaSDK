package com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import java.util.List;

/**
 * 键值对消息参数实体类
 *
 * @author shizhen
 */
public class KeyValueMsg implements Message {

    private String title;//标题
    private ColorText sub_title;//开头语
    private String url;//点击后跳转的url
    private List<KeyValueMsgContent> content;//内容
    private ColorText footer;//末尾语
    private String button_text;//按钮文本

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

    public List<KeyValueMsgContent> getContent() {
        return content;
    }

    public void setContent(List<KeyValueMsgContent> content) {
        this.content = content;
    }

    public ColorText getFooter() {
        return footer;
    }

    public void setFooter(ColorText footer) {
        this.footer = footer;
    }

    public ColorText getSub_title() {
        return sub_title;
    }

    public void setSub_title(ColorText sub_title) {
        this.sub_title = sub_title;
    }

    public String getButton_text() {
        return button_text;
    }

    public void setButton_text(String button_text) {
        this.button_text = button_text;
    }
}