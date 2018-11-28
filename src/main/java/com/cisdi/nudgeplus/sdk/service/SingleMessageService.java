package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.ClassUtils;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MessageResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import com.cisdi.nudgeplus.tmsbeans.constants.MsgType;
import com.cisdi.nudgeplus.tmsbeans.model.ImageMsg;
import com.cisdi.nudgeplus.tmsbeans.model.Msg;
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
public class SingleMessageService {

    /**
     * 根据用户openid使用缓存的ACCESS_TOKEN发送文本消息
     *
     * @param toUser 用户openid
     * @param textMsg 文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(String toUser, TextMsg textMsg) {
        return sendTextMsg(toUser, textMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送文本消息
     *
     * @param toUser 用户openid
     * @param textMsg 文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(String toUser, TextMsg textMsg, String token) {
        if (textMsg == null) {
            throw new IllegalMessageException();
        }
        Msg msg = new Msg();
        msg.setTouser(toUser);
        msg.setMsgtype(MsgType.TEXT);
        msg.setText(textMsg);
        String path = PathConstants.BASE_URL + PathConstants.SINGLE_MESSAGE_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMsgId();
    }

    /**
     * 根据用户openid使用缓存的ACCESS_TOKEN发送图片消息
     *
     * @param toUser 用户openid
     * @param imageMsg 图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(String toUser, ImageMsg imageMsg) {
        return sendImageMsg(toUser, imageMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送图片消息
     *
     * @param toUser 用户openid
     * @param imageMsg 图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(String toUser, ImageMsg imageMsg, String token) {
        if (imageMsg == null) {
            throw new IllegalMessageException();
        }
        Msg msg = new Msg();
        msg.setTouser(toUser);
        msg.setMsgtype(MsgType.IMAGE);
        msg.setImage(imageMsg);
        String path = PathConstants.BASE_URL + PathConstants.SINGLE_MESSAGE_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMsgId();
    }

    /**
     * 根据用户openid使用缓存的ACCESS_TOKEN发送富文本消息
     *
     * @param toUser 用户openid
     * @param richMsg 富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(String toUser, RichMsg richMsg) {
        return sendRichMsg(toUser, richMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送富文本消息
     *
     * @param toUser 用户openid
     * @param richMsg 富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(String toUser, RichMsg richMsg, String token) {
        if (richMsg == null) {
            throw new IllegalMessageException();
        }
        Msg msg = new Msg();
        msg.setTouser(toUser);
        msg.setMsgtype(MsgType.RICHMSG);
        msg.setRichMsg(richMsg);
        String path = PathConstants.BASE_URL + PathConstants.SINGLE_MESSAGE_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMsgId();
    }

    /**
     * 根据用户openid使用缓存的ACCESS_TOKEN发送多图文消息
     *
     * @param toUser 用户openid
     * @param newsMsg 多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(String toUser, NewsMsg newsMsg) {
        return sendNewsMsg(toUser, newsMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送多图文消息
     *
     * @param toUser 用户openid
     * @param newsMsg 多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(String toUser, NewsMsg newsMsg, String token) {
        if (newsMsg == null) {
            throw new IllegalMessageException();
        }
        SingleSendRequest<NewsMsgParam> msg = new SingleSendRequest<>();
        List<NewsMsgArticle> newsMsgArticleList = ClassUtils.convertNewsMsg(newsMsg.getArticles());
        NewsMsgParam newsMsgParam = new NewsMsgParam();
        newsMsgParam.setArticle_list(newsMsgArticleList);
        msg.setMessage(newsMsgParam);
        msg.setTo_user(toUser);
        String path = PathConstants.BASE_URL + PathConstants.SINGLE_NEWS_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid使用缓存的ACCESS_TOKEN发送文件频消息
     *
     * @param toUser 用户openid
     * @param mediaMsg 发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(String toUser, MediaMsg mediaMsg) {
        return sendFileMsg(toUser, mediaMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送文件消息
     *
     * @param toUser 用户openid
     * @param mediaMsg 发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(String toUser, MediaMsg mediaMsg, String token) {
        if (mediaMsg == null) {
            throw new IllegalMessageException();
        }
        SingleSendRequest<MediaMsg> msg = new SingleSendRequest<>();
        msg.setTo_user(toUser);
        msg.setMessage(mediaMsg);
        String path = PathConstants.BASE_URL + PathConstants.SINGLE_FILE_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送文本卡片消息
     *
     * @param toUser 用户openid
     * @param textCardMsg 发送的文本卡片消息实体
     * @return 消息id
     */
    public static String sendTextCardMsg(String toUser, TextCardMsg textCardMsg) {
        return sendTextCardMsg(toUser, textCardMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送文本卡片消息
     *
     * @param toUser 用户openid
     * @param textCardMsg 发送的文本卡片消息实体
     * @return 消息id
     */
    public static String sendTextCardMsg(String toUser, TextCardMsg textCardMsg, String token) {
        if (textCardMsg == null) {
            throw new IllegalMessageException();
        }
        SingleSendRequest<TextCardMsg> msg = new SingleSendRequest<>();
        msg.setTo_user(toUser);
        msg.setMessage(textCardMsg);
        String path = PathConstants.BASE_URL + PathConstants.SINGLE_TEXT_CARD_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送键值对消息
     *
     * @param toUser 用户openid
     * @param keyValueMsg 发送的键值对消息实体
     * @return 消息id
     */
    public static String sendKeyValueMsg(String toUser, KeyValueMsg keyValueMsg) {
        return sendKeyValueMsg(toUser, keyValueMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送键值对消息
     *
     * @param toUser 用户openid
     * @param keyValueMsg 发送的键值对消息实体
     * @return 消息id
     */
    public static String sendKeyValueMsg(String toUser, KeyValueMsg keyValueMsg, String token) {
        if (keyValueMsg == null) {
            throw new IllegalMessageException();
        }
        SingleSendRequest<KeyValueMsg> msg = new SingleSendRequest<>();
        msg.setTo_user(toUser);
        msg.setMessage(keyValueMsg);
        String path = PathConstants.BASE_URL + PathConstants.SINGLE_KEY_VALUE_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送待办消息
     *
     * @param toUser 用户openid
     * @param processMsg 发送的待办消息实体
     * @return 消息id
     */
    public static String sendProcessMsg(String toUser, ProcessMsg processMsg) {
        return sendProcessMsg(toUser, processMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送待办消息
     *
     * @param toUser 用户openid
     * @param processMsg 发送的待办消息实体
     * @return 消息id
     */
    public static String sendProcessMsg(String toUser, ProcessMsg processMsg, String token) {
        if (processMsg == null) {
            throw new IllegalMessageException();
        }
        SingleSendRequest<ProcessMsg> msg = new SingleSendRequest<>();
        msg.setTo_user(toUser);
        msg.setMessage(processMsg);
        String path = PathConstants.BASE_URL + PathConstants.SINGLE_PROCESS_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return (String) ((LinkedTreeMap) resultWapper.getResult().getData()).get("msg_id");
    }
}
