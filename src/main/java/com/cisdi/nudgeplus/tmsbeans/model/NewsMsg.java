package com.cisdi.nudgeplus.tmsbeans.model;

import com.cisdi.nudgeplus.tmsbeans.beans.BaseBean;
import java.io.Serializable;
import java.util.List;

public class NewsMsg extends BaseBean implements Serializable {

    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Article getFace() {
        if (articles == null || articles.size() == 0) {
            return null;
        }
        for (Article art : articles) {
            if (art.getShow_cover_pic() == 1) {
                return art;
            }
        }
        return articles.get(0);
    }

    public void setFace(Article face) {
    }

}
