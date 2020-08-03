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
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.ChannelSendRequest;
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
 * 发送群消息接口
 */
public class ChannelMessageService {

    /**
     * 根据群id使用缓存的ACCESS_TOKEN发送文本消息
     *
     * @param channelId 群id
     * @param textMsg 文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(String channelId, TextMsg textMsg) {
        return sendTextMsg(channelId, textMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据群id使用指定的ACCESS_TOKEN发送文本消息
     *
     * @param channelId 群id
     * @param textMsg 文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(String channelId, TextMsg textMsg, String token) {
        if (textMsg == null) {
            throw new IllegalMessageException();
        }
        ChannelSendRequest<TextMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(textMsg);
        String path = PathConstants.BASE_URL + PathConstants.CHANNEL_TEXT_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToUnderLineJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return (String) resultWapper.getResult().getData();
    }

    /**
     * 根据群id使用缓存的ACCESS_TOKEN发送图片消息
     *
     * @param toUser 用户openid
     * @param imageMsg 图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(String toUser, ImageMsg imageMsg) {
        return sendImageMsg(toUser, imageMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据群id使用指定的ACCESS_TOKEN发送图片消息
     *
     * @param channelId 群id
     * @param imageMsg 图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(String channelId, ImageMsg imageMsg, String token) {
        if (imageMsg == null) {
            throw new IllegalMessageException();
        }
        ChannelSendRequest<ImageMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(imageMsg);
        String path = PathConstants.BASE_URL + PathConstants.CHANNEL_IMAGE_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToUnderLineJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMsgId();
    }

    /**
     * 根据群id使用缓存的ACCESS_TOKEN发送富文本消息
     *
     * @param channelId 群id
     * @param richMsg 富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(String channelId, RichMsg richMsg) {
        return sendRichMsg(channelId, richMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据群id使用指定的ACCESS_TOKEN发送富文本消息
     *
     * @param channelId 群id
     * @param richMsg 富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(String channelId, RichMsg richMsg, String token) {
        if (richMsg == null) {
            throw new IllegalMessageException();
        }
        ChannelSendRequest<RichMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(richMsg);
        String path = PathConstants.BASE_URL + PathConstants.CHANNEL_RICH_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToUnderLineJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return (String) resultWapper.getResult().getData();
    }

    /**
     * 根据群id使用缓存的ACCESS_TOKEN发送多图文消息
     *
     * @param toUser 用户openid
     * @param newsMsg 多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(String toUser, NewsMsg newsMsg) {
        return sendNewsMsg(toUser, newsMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据群id使用指定的ACCESS_TOKEN发送多图文消息
     *
     * @param channelId 群id
     * @param newsMsg 多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(String channelId, NewsMsg newsMsg, String token) {
        if (newsMsg == null) {
            throw new IllegalMessageException();
        }
        ChannelSendRequest<NewsMsgParam> msg = new ChannelSendRequest<>();
        List<NewsMsgArticle> newsMsgArticleList = ClassUtils.convertNewsMsg(newsMsg.getArticles());
        NewsMsgParam newsMsgParam = new NewsMsgParam();
        newsMsgParam.setArticle_list(newsMsgArticleList);
        msg.setMessage(newsMsgParam);
        msg.setChannelId(channelId);
        String path = PathConstants.BASE_URL + PathConstants.CHANNEL_NEWS_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToUnderLineJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getData().toString();
    }

    /**
     * 根据群id使用缓存的ACCESS_TOKEN发送文件频消息
     *
     * @param toUser 用户openid
     * @param mediaMsg 发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(String toUser, MediaMsg mediaMsg) {
        return sendFileMsg(toUser, mediaMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据群id使用指定的ACCESS_TOKEN发送文件消息
     *
     * @param channelId 群id
     * @param mediaMsg 发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(String channelId, MediaMsg mediaMsg, String token) {
        if (mediaMsg == null) {
            throw new IllegalMessageException();
        }
        ChannelSendRequest<MediaMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(mediaMsg);
        String path = PathConstants.BASE_URL + PathConstants.CHANNEL_FILE_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToUnderLineJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getData().toString();
    }

    /**
     * 根据群id使用指定的ACCESS_TOKEN发送文本卡片消息
     *
     * @param toUser 用户openid
     * @param textCardMsg 发送的文本卡片消息实体
     * @return 消息id
     */
    public static String sendTextCardMsg(String toUser, TextCardMsg textCardMsg) {
        return sendTextCardMsg(toUser, textCardMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据群id使用指定的ACCESS_TOKEN发送文本卡片消息
     *
     * @param channelId 群id
     * @param textCardMsg 发送的文本卡片消息实体
     * @return 消息id
     */
    public static String sendTextCardMsg(String channelId, TextCardMsg textCardMsg, String token) {
        if (textCardMsg == null) {
            throw new IllegalMessageException();
        }
        ChannelSendRequest<TextCardMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(textCardMsg);
        String path = PathConstants.BASE_URL + PathConstants.CHANNEL_TEXT_CARD_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToUnderLineJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getData().toString();
    }

    /**
     * 根据群id使用指定的ACCESS_TOKEN发送键值对消息
     *
     * @param toUser 用户openid
     * @param keyValueMsg 发送的键值对消息实体
     * @return 消息id
     */
    public static String sendKeyValueMsg(String toUser, KeyValueMsg keyValueMsg) {
        return sendKeyValueMsg(toUser, keyValueMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据群id使用指定的ACCESS_TOKEN发送键值对消息
     *
     * @param channelId 群id
     * @param keyValueMsg 发送的键值对消息实体
     * @return 消息id
     */
    public static String sendKeyValueMsg(String channelId, KeyValueMsg keyValueMsg, String token) {
        if (keyValueMsg == null) {
            throw new IllegalMessageException();
        }
        ChannelSendRequest<KeyValueMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(keyValueMsg);
        String path = PathConstants.BASE_URL + PathConstants.CHANNEL_KEY_VALUE_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToUnderLineJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getData().toString();
    }
}
