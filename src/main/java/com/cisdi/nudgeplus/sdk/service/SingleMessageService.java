package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import com.cisdi.nudgeplus.sdk.utils.TransformUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MessageResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.model.CardMessage;
import com.cisdi.nudgeplus.tmsbeans.model.ImageMsg;
import com.cisdi.nudgeplus.tmsbeans.model.NewsMsg;
import com.cisdi.nudgeplus.tmsbeans.model.RichMsg;
import com.cisdi.nudgeplus.tmsbeans.model.TextMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.SingleSendRequest;
import com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue.KeyValueMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.media.MediaMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgArticle;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgParam;
import com.cisdi.nudgeplus.tmsbeans.model.request.process.ProcessMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.textcard.TextCardMsg;
import com.google.gson.internal.LinkedTreeMap;
import java.util.List;

/**
 * 单发消息接口
 */
public final class SingleMessageService {

    /**
     * 根据用户openid发送文本消息
     *
     * @param toUser 用户openid
     * @param textMsg 文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(String toUser, TextMsg textMsg) {
        if (textMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<TextMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(textMsg);

        String path = PathConstants.SINGLE_TEXT_MSG_PATH;
        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        if (resultWrapper.isError()) {
            throw new IllegalRequestException(resultWrapper.getErrorResult());
        }

        return (String) resultWrapper.getResult().getData();
    }

    /**
     * 根据用户openid发送图片消息
     *
     * @param toUser 用户openid
     * @param imageMsg 图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(String toUser, ImageMsg imageMsg) {
        if (imageMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<ImageMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(imageMsg);

        String path = PathConstants.SINGLE_IMAGE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        if (resultWrapper.isError()) {
            throw new IllegalRequestException(resultWrapper.getErrorResult());
        }

        return (String) resultWrapper.getResult().getData();
    }


    /**
     * 根据用户openid发送富文本消息
     *
     * @param toUser 用户openid
     * @param richMsg 富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(String toUser, RichMsg richMsg) {
        if (richMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<RichMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(richMsg);

        String path = PathConstants.SINGLE_RICH_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        if (resultWrapper.isError()) {
            throw new IllegalRequestException(resultWrapper.getErrorResult());
        }

        return (String) resultWrapper.getResult().getData();
    }

    /**
     * 根据用户openid发送多图文消息
     *
     * @param toUser 用户openid
     * @param newsMsg 多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(String toUser, NewsMsg newsMsg) {
        if (newsMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<NewsMsgParam> msg = new SingleSendRequest<>();
        List<NewsMsgArticle> newsMsgArticleList = TransformUtils.convertNewsMsg(newsMsg.getArticles());
        NewsMsgParam newsMsgParam = new NewsMsgParam();
        newsMsgParam.setArticleList(newsMsgArticleList);
        msg.setMessage(newsMsgParam);
        msg.setToUser(toUser);

        String path = PathConstants.SINGLE_NEWS_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        if (resultWrapper.isError()) {
            throw new IllegalRequestException(resultWrapper.getErrorResult());
        }

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送文件消息
     *
     * @param toUser 用户openid
     * @param mediaMsg 发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(String toUser, MediaMsg mediaMsg) {
        if (mediaMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<MediaMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(mediaMsg);

        String path = PathConstants.SINGLE_FILE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        if (resultWrapper.isError()) {
            throw new IllegalRequestException(resultWrapper.getErrorResult());
        }

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送文本卡片消息
     *
     * @param toUser 用户openid
     * @param textCardMsg 发送的文本卡片消息实体
     * @return 消息id
     */
    public static String sendTextCardMsg(String toUser, TextCardMsg textCardMsg) {
        if (textCardMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<TextCardMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(textCardMsg);

        String path = PathConstants.SINGLE_TEXT_CARD_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送键值对消息
     *
     * @param toUser 用户openid
     * @param keyValueMsg 发送的键值对消息实体
     * @return 消息id
     */
    public static String sendKeyValueMsg(String toUser, KeyValueMsg keyValueMsg) {
        if (keyValueMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<KeyValueMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(keyValueMsg);

        String path = PathConstants.SINGLE_KEY_VALUE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送待办消息
     *
     * @param toUser 用户openid
     * @param processMsg 发送的待办消息实体
     * @return 消息id
     */
    public static String sendProcessMsg(String toUser, ProcessMsg processMsg) {
        if (processMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<ProcessMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(processMsg);

        String path = PathConstants.SINGLE_PROCESS_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return (String) ((LinkedTreeMap) resultWrapper.getResult().getData()).get("msg_id");
    }

    /**
     * 发布自定义卡片消息
     *
     * @param toUser 用户openid
     * @param cardMessage 卡片消息
     * @return 消息id
     */
    public static String sendCardMsg(String toUser, CardMessage cardMessage) {
        if (cardMessage == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<CardMessage> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(cardMessage);

        String path = PathConstants.SINGLE_CARD_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    private SingleMessageService() {
    }
}
