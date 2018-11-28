package com.cisdi.nudgeplus.tmsbeans.model.request.news;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import java.util.List;

/**
 * 多图文消息实体类
 *
 * @author shizhen
 */
public class NewsMsgParam implements Message {

    List<NewsMsgArticle> article_list;

    public List<NewsMsgArticle> getArticle_list() {
        return article_list;
    }

    public void setArticle_list(List<NewsMsgArticle> article_list) {
        this.article_list = article_list;
    }
}