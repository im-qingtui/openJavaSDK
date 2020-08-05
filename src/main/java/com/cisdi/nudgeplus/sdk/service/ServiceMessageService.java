package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.sdk.utils.TransformUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MessageResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.constants.MsgType;
import com.cisdi.nudgeplus.tmsbeans.model.ImageMsg;
import com.cisdi.nudgeplus.tmsbeans.model.NewsMsg;
import com.cisdi.nudgeplus.tmsbeans.model.RichMsg;
import com.cisdi.nudgeplus.tmsbeans.model.ServiceMsg;
import com.cisdi.nudgeplus.tmsbeans.model.TextMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.ServiceSendRequest;
import com.cisdi.nudgeplus.tmsbeans.model.request.media.MediaMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgArticle;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgParam;
import java.util.List;

/**
 * 服务号消息接口
 */
public class ServiceMessageService {

    /**
     * 向所有关注者发送文本消息
     *
     * @param textMsg 文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(TextMsg textMsg) {
        if (textMsg == null) {
            throw new IllegalMessageException();
        }

        ServiceMsg msg = new ServiceMsg();
        msg.setMsgtype(MsgType.TEXT);
        msg.setText(textMsg);

        String path = PathConstants.SERVICE_MESSAGE_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getMsgId();
    }

    /**
     * 向所有关注者发送图片消息
     *
     * @param imageMsg 图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(ImageMsg imageMsg) {
        if (imageMsg == null) {
            throw new IllegalMessageException();
        }

        ServiceMsg msg = new ServiceMsg();
        msg.setMsgtype(MsgType.IMAGE);
        msg.setImage(imageMsg);

        String path = PathConstants.SERVICE_MESSAGE_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getMsgId();
    }

    /**
     * 向所有关注者发送富文本消息
     *
     * @param richMsg 富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(RichMsg richMsg) {
        if (richMsg == null) {
            throw new IllegalMessageException();
        }

        ServiceMsg msg = new ServiceMsg();
        msg.setMsgtype(MsgType.RICH_MSG);
        msg.setRichMsg(richMsg);

        String path = PathConstants.SERVICE_MESSAGE_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getMsgId();
    }

    /**
     * 向所有关注者发送多图文消息
     *
     * @param newsMsg 多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(NewsMsg newsMsg) {
        if (newsMsg == null) {
            throw new IllegalMessageException();
        }

        ServiceSendRequest<NewsMsgParam> msg = new ServiceSendRequest<>();
        List<NewsMsgArticle> newsMsgArticleList = TransformUtils.convertNewsMsg(newsMsg.getArticles());
        NewsMsgParam newsMsgParam = new NewsMsgParam();
        newsMsgParam.setArticleList(newsMsgArticleList);
        msg.setMessage(newsMsgParam);

        String path = PathConstants.SERVICE_NEWS_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送文件消息
     *
     * @param mediaMsg 发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(MediaMsg mediaMsg) {
        if (mediaMsg == null) {
            throw new IllegalMessageException();
        }

        ServiceSendRequest<MediaMsg> msg = new ServiceSendRequest<>();
        msg.setMessage(mediaMsg);

        String path = PathConstants.SERVICE_FILE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }
}
