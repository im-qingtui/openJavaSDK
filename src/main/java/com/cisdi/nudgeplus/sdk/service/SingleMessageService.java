package com.cisdi.nudgeplus.sdk.service;

import static com.cisdi.nudgeplus.sdk.service.TokenService.getToken;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.sdk.utils.TransformUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MessageResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.model.CardMessage;
import com.cisdi.nudgeplus.tmsbeans.model.ImageMsg;
import com.cisdi.nudgeplus.tmsbeans.model.NewsMsg;
import com.cisdi.nudgeplus.tmsbeans.model.RichMsg;
import com.cisdi.nudgeplus.tmsbeans.model.TempCardSingleMessage;
import com.cisdi.nudgeplus.tmsbeans.model.TextMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.SingleSendRequest;
import com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue.KeyValueMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.media.MediaMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgArticle;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgParam;
import com.cisdi.nudgeplus.tmsbeans.model.request.process.ProcessMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.textcard.TextCardMsg;
import com.google.gson.internal.LinkedTreeMap;
import im.qingtui.cross.card_message.Card;
import java.util.List;

/**
 * 单发消息接口
 */
public final class SingleMessageService {

    /**
     * 根据用户openid发送文本消息
     *
     * @param toUser  用户openid
     * @param textMsg 文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(String toUser, TextMsg textMsg) {
        return sendTextMsg(toUser, textMsg, getToken());
    }

    /**
     * 根据用户openid发送文本消息
     *
     * @param toUser      用户openid
     * @param textMsg     文本消息
     * @param accessToken 应用凭证
     * @return 返回消息id
     */
    public static String sendTextMsg(String toUser, TextMsg textMsg, String accessToken) {
        if (textMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<TextMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(textMsg);

        String path = PathConstants.SINGLE_TEXT_MSG_PATH;
        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        if (resultWrapper.isError()) {
            throw new IllegalRequestException(resultWrapper.getErrorResult());
        }

        return (String) resultWrapper.getResult().getData();
    }

    /**
     * 根据用户openid发送图片消息
     *
     * @param toUser   用户openid
     * @param imageMsg 图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(String toUser, ImageMsg imageMsg) {
        return sendImageMsg(toUser, imageMsg, getToken());
    }

    /**
     * 根据用户openid发送图片消息
     *
     * @param toUser      用户openid
     * @param imageMsg    图片消息
     * @param accessToken 应用凭证
     * @return 返回消息id
     */
    public static String sendImageMsg(String toUser, ImageMsg imageMsg, String accessToken) {
        if (imageMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<ImageMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(imageMsg);

        String path = PathConstants.SINGLE_IMAGE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        if (resultWrapper.isError()) {
            throw new IllegalRequestException(resultWrapper.getErrorResult());
        }

        return (String) resultWrapper.getResult().getData();
    }


    /**
     * 根据用户openid发送富文本消息
     *
     * @param toUser  用户openid
     * @param richMsg 富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(String toUser, RichMsg richMsg) {
        return sendRichMsg(toUser, richMsg, getToken());
    }

    /**
     * 根据用户openid发送富文本消息
     *
     * @param toUser      用户openid
     * @param richMsg     富文本消息
     * @param accessToken 应用凭证
     * @return 返回消息id
     */
    public static String sendRichMsg(String toUser, RichMsg richMsg, String accessToken) {
        if (richMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<RichMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(richMsg);

        String path = PathConstants.SINGLE_RICH_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        if (resultWrapper.isError()) {
            throw new IllegalRequestException(resultWrapper.getErrorResult());
        }

        return (String) resultWrapper.getResult().getData();
    }

    /**
     * 根据用户openid发送多图文消息
     *
     * @param toUser  用户openid
     * @param newsMsg 多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(String toUser, NewsMsg newsMsg) {
        return sendNewsMsg(toUser, newsMsg, getToken());
    }

    /**
     * 根据用户openid发送多图文消息
     *
     * @param toUser      用户openid
     * @param newsMsg     多图文消息
     * @param accessToken 应用凭证
     * @return 返回消息id
     */
    public static String sendNewsMsg(String toUser, NewsMsg newsMsg, String accessToken) {
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
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        if (resultWrapper.isError()) {
            throw new IllegalRequestException(resultWrapper.getErrorResult());
        }

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送文件消息
     *
     * @param toUser   用户openid
     * @param mediaMsg 发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(String toUser, MediaMsg mediaMsg) {
        return sendFileMsg(toUser, mediaMsg, getToken());
    }

    /**
     * 根据用户openid发送文件消息
     *
     * @param toUser      用户openid
     * @param mediaMsg    发送的文件消息实体
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendFileMsg(String toUser, MediaMsg mediaMsg, String accessToken) {
        if (mediaMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<MediaMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(mediaMsg);

        String path = PathConstants.SINGLE_FILE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        if (resultWrapper.isError()) {
            throw new IllegalRequestException(resultWrapper.getErrorResult());
        }

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送文本卡片消息
     *
     * @param toUser      用户openid
     * @param textCardMsg 发送的文本卡片消息实体
     * @return 消息id
     */
    public static String sendTextCardMsg(String toUser, TextCardMsg textCardMsg) {
        return sendTextCardMsg(toUser, textCardMsg, getToken());
    }

    /**
     * 根据用户openid发送文本卡片消息
     *
     * @param toUser      用户openid
     * @param textCardMsg 发送的文本卡片消息实体
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendTextCardMsg(String toUser, TextCardMsg textCardMsg, String accessToken) {
        if (textCardMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<TextCardMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(textCardMsg);

        String path = PathConstants.SINGLE_TEXT_CARD_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送键值对消息
     *
     * @param toUser      用户openid
     * @param keyValueMsg 发送的键值对消息实体
     * @return 消息id
     */
    public static String sendKeyValueMsg(String toUser, KeyValueMsg keyValueMsg) {
        return sendKeyValueMsg(toUser, keyValueMsg, getToken());
    }

    /**
     * 根据用户openid发送键值对消息
     *
     * @param toUser      用户openid
     * @param keyValueMsg 发送的键值对消息实体
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendKeyValueMsg(String toUser, KeyValueMsg keyValueMsg, String accessToken) {
        if (keyValueMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<KeyValueMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(keyValueMsg);

        String path = PathConstants.SINGLE_KEY_VALUE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送待办消息
     *
     * @param toUser     用户openid
     * @param processMsg 发送的待办消息实体
     * @return 消息id
     */
    public static String sendProcessMsg(String toUser, ProcessMsg processMsg) {
        return sendProcessMsg(toUser, processMsg, getToken());
    }

    /**
     * 根据用户openid发送待办消息
     *
     * @param toUser      用户openid
     * @param processMsg  发送的待办消息实体
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendProcessMsg(String toUser, ProcessMsg processMsg, String accessToken) {
        if (processMsg == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<ProcessMsg> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        msg.setMessage(processMsg);

        String path = PathConstants.SINGLE_PROCESS_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return (String) ((LinkedTreeMap) resultWrapper.getResult().getData()).get("msg_id");
    }

    /**
     * 发布自定义卡片消息
     *
     * @param toUser      用户openid
     * @param card 卡片消息
     * @return 消息id
     */
    public static String sendCardMsg(String toUser, Card card) {
        return sendCardMsg(toUser, card, getToken());
    }

    /**
     * 发布自定义卡片消息
     *
     * @param toUser      用户openid
     * @param card 卡片消息
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendCardMsg(String toUser, Card card, String accessToken) {
        if (card == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<CardMessage> msg = new SingleSendRequest<>();
        msg.setToUser(toUser);
        CardMessage cardMessage = new CardMessage();
        cardMessage.setCard(card);
        cardMessage.setContent(cardMessage.getContent());
        msg.setMessage(cardMessage);

        String path = PathConstants.SINGLE_CARD_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 发送自定义卡片临时消息
     *
     * @param toUser      用户openid
     * @param card 卡片消息
     * @return 消息id
     */
    public static String sendTempCardMsg(String toUser, Card card){
        return sendTempCardMsg(toUser,card,getToken());
    }

    /**
     * 发送自定义卡片临时消息
     *
     * @param toUser      用户openid
     * @param card 卡片消息
     * @param accessToken 应用凭证
     * @return 消息id
     */
    public static String sendTempCardMsg(String toUser, Card card, String accessToken) {
        if (card == null) {
            throw new IllegalMessageException();
        }

        SingleSendRequest<TempCardSingleMessage> msg = new SingleSendRequest<>();
        TempCardSingleMessage tempCardSingleMessage = new TempCardSingleMessage();
        tempCardSingleMessage.setCard(card);
        tempCardSingleMessage.setOpenId(toUser);
        tempCardSingleMessage.setContent(tempCardSingleMessage.getContent());
        msg.setMessage(tempCardSingleMessage);
        msg.setToUser(toUser);
        String path = PathConstants.SINGLE_TEMP_CARD_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, accessToken,
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    private SingleMessageService() {
    }
}
