package com.cisdi.nudgeplus.sdk.utils;

import com.cisdi.nudgeplus.tmsbeans.model.Article;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgArticle;
import java.util.ArrayList;
import java.util.List;

/**
 * 常用类的工具类
 *
 * @author shizhen
 */
public final class TransformUtils {

    public static List<NewsMsgArticle> convertNewsMsg(List<Article> articleList) {
        List<NewsMsgArticle> newsMsgArticleList = new ArrayList<>();
        if (articleList != null && articleList.size() != 0) {
            for (Article article : articleList) {
                NewsMsgArticle newsMsgArticle = new NewsMsgArticle();
                newsMsgArticle.setAuthor(article.getAuthor());
                newsMsgArticle.setContent(article.getContent());
                newsMsgArticle.setShowCoverPic(article.getShowCoverPic());
                newsMsgArticle.setTime(article.getXtime());
                newsMsgArticle.setTitle(article.getTitle());
                newsMsgArticle.setUrl(article.getUrl());
                newsMsgArticle.setThumbMediaId(article.getThumbMediaId());
                newsMsgArticleList.add(newsMsgArticle);
            }
        }
        return newsMsgArticleList;
    }

    private TransformUtils() {
    }
}