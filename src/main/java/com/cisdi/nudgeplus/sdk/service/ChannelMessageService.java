package com.cisdi.nudgeplus.sdk.service;

import static com.cisdi.nudgeplus.sdk.service.TokenService.getToken;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.sdk.utils.TransformUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MessageResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.model.CardMessage;
import com.cisdi.nudgeplus.tmsbeans.model.ImageMsg;
import com.cisdi.nudgeplus.tmsbeans.model.NewsMsg;
import com.cisdi.nudgeplus.tmsbeans.model.RichMsg;
import com.cisdi.nudgeplus.tmsbeans.model.TempCardChannelMessage;
import com.cisdi.nudgeplus.tmsbeans.model.TempCardSingleMessage;
import com.cisdi.nudgeplus.tmsbeans.model.TextMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.ChannelSendRequest;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.SingleSendRequest;
import com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue.KeyValueMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.media.MediaMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgArticle;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgParam;
import com.cisdi.nudgeplus.tmsbeans.model.request.textcard.TextCardMsg;
import im.qingtui.cross.card_message.Card;
import im.qingtui.cross.card_message.CardExtensionKt;
import java.util.List;

/**
 * 发送群消息接口
 */
public final class ChannelMessageService {

    /**
     * 根据群id发送文本消息
     *
     * @param channelId 群id
     * @param textMsg   文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(String channelId, TextMsg textMsg) {
        return sendTextMsg(channelId, textMsg, getToken());
    }

    /**
     * 根据群id发送文本消息
     *
     * @param channelId   群id
     * @param textMsg     文本消息
     * @param accessToken 应用凭证
     * @return 返回消息id
     */
    public static String sendTextMsg(String channelId, TextMsg textMsg, String accessToken) {
        if (textMsg == null) {
            throw new IllegalMessageException();
        }

        ChannelSendRequest<TextMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(textMsg);

        String path = PathConstants.CHANNEL_TEXT_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken, JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return (String) resultWrapper.getResult().getData();
    }

    /**
     * 根据群id发送图片消息
     *
     * @param channelId 群id
     * @param imageMsg  图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(String channelId, ImageMsg imageMsg) {
        return sendImageMsg(channelId, imageMsg, getToken());
    }

    /**
     * 根据群id发送图片消息
     *
     * @param channelId   群id
     * @param imageMsg    图片消息
     * @param accessToken 应用凭证
     * @return 返回消息id
     */
    public static String sendImageMsg(String channelId, ImageMsg imageMsg, String accessToken) {
        if (imageMsg == null) {
            throw new IllegalMessageException();
        }

        ChannelSendRequest<ImageMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(imageMsg);

        String path = PathConstants.CHANNEL_IMAGE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken, JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return (String) resultWrapper.getResult().getData();
    }

    /**
     * 根据群id发送富文本消息
     *
     * @param channelId 群id
     * @param richMsg   富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(String channelId, RichMsg richMsg) {
        return sendRichMsg(channelId, richMsg, getToken());
    }

    /**
     * 根据群id发送富文本消息
     *
     * @param channelId   群id
     * @param richMsg     富文本消息
     * @param accessToken 应用凭证
     * @return 返回消息id
     */
    public static String sendRichMsg(String channelId, RichMsg richMsg, String accessToken) {
        if (richMsg == null) {
            throw new IllegalMessageException();
        }

        ChannelSendRequest<RichMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(richMsg);

        String path = PathConstants.CHANNEL_RICH_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken, JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return (String) resultWrapper.getResult().getData();
    }

    /**
     * 根据群id发送多图文消息
     *
     * @param channelId 群id
     * @param newsMsg   多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(String channelId, NewsMsg newsMsg) {
        return sendNewsMsg(channelId, newsMsg, getToken());
    }

    /**
     * 根据群id发送多图文消息
     *
     * @param channelId   群id
     * @param newsMsg     多图文消息
     * @param accessToken 应用凭证
     * @return 返回消息id
     */
    public static String sendNewsMsg(String channelId, NewsMsg newsMsg, String accessToken) {
        if (newsMsg == null) {
            throw new IllegalMessageException();
        }

        ChannelSendRequest<NewsMsgParam> msg = new ChannelSendRequest<>();
        List<NewsMsgArticle> newsMsgArticleList = TransformUtils.convertNewsMsg(newsMsg.getArticles());
        NewsMsgParam newsMsgParam = new NewsMsgParam();
        newsMsgParam.setArticleList(newsMsgArticleList);
        msg.setMessage(newsMsgParam);
        msg.setChannelId(channelId);

        String path = PathConstants.CHANNEL_NEWS_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken, JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据群id发送文件消息
     *
     * @param channelId 群id
     * @param mediaMsg  发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(String channelId, MediaMsg mediaMsg) {
        return sendFileMsg(channelId, mediaMsg, getToken());
    }

    /**
     * 根据群id发送文件消息
     *
     * @param channelId   群id
     * @param mediaMsg    发送的文件消息实体
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendFileMsg(String channelId, MediaMsg mediaMsg, String accessToken) {
        if (mediaMsg == null) {
            throw new IllegalMessageException();
        }

        ChannelSendRequest<MediaMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(mediaMsg);

        String path = PathConstants.CHANNEL_FILE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken, JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据群id发送文本卡片消息
     *
     * @param channelId   群id
     * @param textCardMsg 发送的文本卡片消息实体
     * @return 消息id
     */
    public static String sendTextCardMsg(String channelId, TextCardMsg textCardMsg) {
        return sendTextCardMsg(channelId, textCardMsg, getToken());
    }

    /**
     * 根据群id发送文本卡片消息
     *
     * @param channelId   群id
     * @param textCardMsg 发送的文本卡片消息实体
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendTextCardMsg(String channelId, TextCardMsg textCardMsg, String accessToken) {
        if (textCardMsg == null) {
            throw new IllegalMessageException();
        }

        ChannelSendRequest<TextCardMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(textCardMsg);

        String path = PathConstants.CHANNEL_TEXT_CARD_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken, JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据群id发送键值对消息
     *
     * @param channelId   群id
     * @param keyValueMsg 发送的键值对消息实体
     * @return 消息id
     */
    public static String sendKeyValueMsg(String channelId, KeyValueMsg keyValueMsg) {
        return sendKeyValueMsg(channelId, keyValueMsg, getToken());
    }

    /**
     * 根据群id发送键值对消息
     *
     * @param channelId   群id
     * @param keyValueMsg 发送的键值对消息实体
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendKeyValueMsg(String channelId, KeyValueMsg keyValueMsg, String accessToken) {
        if (keyValueMsg == null) {
            throw new IllegalMessageException();
        }

        ChannelSendRequest<KeyValueMsg> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        msg.setMessage(keyValueMsg);

        String path = PathConstants.CHANNEL_KEY_VALUE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken, JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }


    /**
     * 发布自定义卡片消息
     *
     * @param channelId   群id
     * @param card 卡片消息
     * @return 消息id
     */
    public static String sendCardMsg(String channelId, Card card) {
        return sendCardMsg(channelId, card, getToken());
    }

    /**
     * 发布自定义卡片消息
     *
     * @param channelId   群id
     * @param card 卡片消息
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendCardMsg(String channelId, Card card, String accessToken) {
        if (card == null) {
            throw new IllegalMessageException();
        }

        ChannelSendRequest<CardMessage> msg = new ChannelSendRequest<>();
        msg.setChannelId(channelId);
        CardMessage cardMessage = new CardMessage();
        cardMessage.setCard(card);
        cardMessage.setContent(cardMessage.getContent());
        msg.setMessage(cardMessage);
        String path = PathConstants.CHANNEL_CARD_MSG_PATH;
        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);
        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 发送自定义卡片临时消息
     *
     * @param toUser      用户openid
     * @param channelId 显示消息所在群
     * @param card 卡片消息
     * @return 消息id
     */
    public static String sendTempCardMsg(String toUser, String channelId,Card card){
        return sendTempCardMsg(toUser, channelId, card,getToken());
    }

    /**
     * 发送自定义卡片临时消息
     *
     * @param toUser      用户openid
     * @param channelId 显示消息所在群
     * @param card 卡片消息
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendTempCardMsg(String toUser, String channelId,Card card, String accessToken) {
        if (card == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<TempCardChannelMessage> msg = new SingleSendRequest<>();
        TempCardChannelMessage tempCardChannelMessage = new TempCardChannelMessage();
        tempCardChannelMessage.setCard(card);
        tempCardChannelMessage.setChannelId(channelId);
        tempCardChannelMessage.setContent(CardExtensionKt.getSerializer().toSerialized(card));
        msg.setMessage(tempCardChannelMessage);
        msg.setToUser(toUser);
        String path = PathConstants.CHANNEL_TEMP_CARD_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 发送自定义卡片临时消息
     *
     * @param toAccount      用户accountId
     * @param channelId 显示消息所在群
     * @param card 卡片消息
     * @return 消息id
     */
    public static String sendTempCardMsgByAccountId(String toAccount, String channelId,Card card){
        return sendTempCardMsgByAccountId(toAccount, channelId, card,getToken());
    }

    /**
     * 发送自定义卡片临时消息
     *
     * @param toAccount      用户accountId
     * @param channelId 显示消息所在群
     * @param card 卡片消息
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendTempCardMsgByAccountId(String toAccount, String channelId, Card card, String accessToken) {
        if (card == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<TempCardChannelMessage> msg = new SingleSendRequest<>();
        TempCardChannelMessage tempCardChannelMessage = new TempCardChannelMessage();
        tempCardChannelMessage.setCard(card);
        tempCardChannelMessage.setChannelId(channelId);
        tempCardChannelMessage.setContent(CardExtensionKt.getSerializer().toSerialized(card));
        msg.setMessage(tempCardChannelMessage);
        msg.setToUser(toAccount);
        String path = PathConstants.CHANNEL_TEMP_CARD_ACCOUNT_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    private ChannelMessageService() {
    }
}
