package com.cisdi.nudgeplus.tmsbeans.model.request.news;

import com.cisdi.nudgeplus.tmsbeans.model.request.basics.Message;
import java.util.List;
import lombok.Data;

/**
 * 多图文消息实体类
 *
 * @author shizhen
 */
@Data
public class NewsMsgParam implements Message {

    List<NewsMsgArticle> articleList;

}