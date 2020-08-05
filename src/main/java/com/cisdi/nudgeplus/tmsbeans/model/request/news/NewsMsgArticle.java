package com.cisdi.nudgeplus.tmsbeans.model.request.news;

import java.io.Serializable;
import lombok.Data;

/**
 * 多图文消息文章实体类
 *
 * @author shizhen
 */
@Data
public class NewsMsgArticle implements Serializable {

    private String title;

    private long time;

    private String author;

    private String url;

    private String content;

    private String thumbMediaId;

    private int showCoverPic;

}