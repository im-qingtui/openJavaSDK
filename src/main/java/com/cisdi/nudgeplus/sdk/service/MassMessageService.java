package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.sdk.utils.TransformUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MessageResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.constants.MsgType;
import com.cisdi.nudgeplus.tmsbeans.model.CardMessage;
import com.cisdi.nudgeplus.tmsbeans.model.ImageMsg;
import com.cisdi.nudgeplus.tmsbeans.model.MassMsg;
import com.cisdi.nudgeplus.tmsbeans.model.NewsMsg;
import com.cisdi.nudgeplus.tmsbeans.model.RichMsg;
import com.cisdi.nudgeplus.tmsbeans.model.TextMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.MassSendRequest;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.SingleSendRequest;
import com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue.KeyValueMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.media.MediaMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgArticle;
import com.cisdi.nudgeplus.tmsbeans.model.request.news.NewsMsgParam;
import com.cisdi.nudgeplus.tmsbeans.model.request.process.ProcessMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.textcard.TextCardMsg;
import com.cisdi.nudgeplus.tmsbeans.model.response.ProcessMsgMassResponse;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.List;

/**
 * 群发消息接口
 */
public final class MassMessageService {

    /**
     * 根据用户openid列表进行文本消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param textMsg 文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(List<String> userList, TextMsg textMsg) {
        if (textMsg == null) {
            throw new IllegalMessageException();
        }
        MassSendRequest<TextMsg> msg = new MassSendRequest<>();
        msg.setMessage(textMsg);
        msg.setToUsers(userList);

        String path = PathConstants.MASS_TEXT_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(), JsonUtils.beanToJson(msg), MessageResult.class);

        return resultWrapper.getResult().getMsgId();
    }

    /**
     * 根据用户openid列表进行图片消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param imageMsg 图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(List<String> userList, ImageMsg imageMsg) {
        if (imageMsg == null) {
            throw new IllegalMessageException();
        }
        MassSendRequest<ImageMsg> msg = new MassSendRequest<>();
        msg.setMessage(imageMsg);
        msg.setToUsers(userList);

        String path = PathConstants.MASS_IMAGE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(), JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return (String) resultWrapper.getResult().getData();
    }

    /**
     * 根据用户openid列表进行富文本消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param richMsg 富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(List<String> userList, RichMsg richMsg) {
        if (richMsg == null) {
            throw new IllegalMessageException();
        }
        MassSendRequest<RichMsg> msg = new MassSendRequest<>();
        msg.setMessage(richMsg);
        msg.setToUsers(userList);

        String path = PathConstants.MASS_RICH_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(), JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return (String) resultWrapper.getResult().getData();
    }

    /**
     * 根据用户openid列表进行多图文消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param newsMsg 多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(List<String> userList, NewsMsg newsMsg) {
        if (newsMsg == null) {
            throw new IllegalMessageException();
        }

        MassSendRequest<NewsMsgParam> msg = new MassSendRequest<>();
        List<NewsMsgArticle> newsMsgArticleList = TransformUtils.convertNewsMsg(newsMsg.getArticles());
        NewsMsgParam newsMsgParam = new NewsMsgParam();
        newsMsgParam.setArticleList(newsMsgArticleList);
        msg.setMessage(newsMsgParam);
        msg.setToUsers(userList);

        String path = PathConstants.MASS_NEWS_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(), JsonUtils.beanToJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送文件消息
     *
     * @param userList 用户openid列表
     * @param mediaMsg 发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(List<String> userList, MediaMsg mediaMsg) {
        if (mediaMsg == null) {
            throw new IllegalMessageException();
        }
        MassSendRequest<MediaMsg> msg = new MassSendRequest<>();
        msg.setToUsers(userList);
        msg.setMessage(mediaMsg);
        String path = PathConstants.MASS_FILE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(), JsonUtils.beanToJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送文本卡片消息
     *
     * @param userList 用户openid列表
     * @param textCardMsg 发送的文本卡片消息实体
     * @return 消息id
     */
    public static String sendTextCardMsg(List<String> userList, TextCardMsg textCardMsg) {
        if (textCardMsg == null) {
            throw new IllegalMessageException();
        }
        MassSendRequest<TextCardMsg> msg = new MassSendRequest<>();
        msg.setToUsers(userList);
        msg.setMessage(textCardMsg);

        String path = PathConstants.MASS_TEXT_CARD_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(), JsonUtils.beanToJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送键值对消息
     *
     * @param userList 用户openid列表
     * @param keyValueMsg 发送的键值对消息实体
     * @return 消息id
     */
    public static String sendKeyValueMsg(List<String> userList, KeyValueMsg keyValueMsg) {
        if (keyValueMsg == null) {
            throw new IllegalMessageException();
        }

        MassSendRequest<KeyValueMsg> msg = new MassSendRequest<>();
        msg.setToUsers(userList);
        msg.setMessage(keyValueMsg);

        String path = PathConstants.MASS_KEY_VALUE_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(), JsonUtils.beanToJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    /**
     * 根据用户openid发送待办消息
     *
     * @param userList 用户openid列表
     * @param processMsg 发送的待办消息实体
     * @return 消息id
     */
    public static List<ProcessMsgMassResponse> sendProcessMsg(List<String> userList, ProcessMsg processMsg) {
        if (processMsg == null) {
            throw new IllegalMessageException();
        }

        MassSendRequest<ProcessMsg> msg = new MassSendRequest<>();
        msg.setToUsers(userList);
        msg.setMessage(processMsg);

        String path = PathConstants.MASS_PROCESS_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(), JsonUtils.beanToJson(msg), MessageResult.class);

        List<ProcessMsgMassResponse> response = new ArrayList<>();

        for (int i = 0; i < ((ArrayList) resultWrapper.getResult().getData()).size(); i++) {
            ProcessMsgMassResponse processMsgMassResponse = new ProcessMsgMassResponse();
            processMsgMassResponse.setMsgId((String) ((LinkedTreeMap) ((ArrayList) resultWrapper.getResult().getData()).get(i)).get("msg_id"));
            processMsgMassResponse.setOpenId((String) ((LinkedTreeMap) ((ArrayList) resultWrapper.getResult().getData()).get(i)).get("open_id"));
            response.add(processMsgMassResponse);
        }

        return response;
    }

    /**
     * 发布自定义卡片消息
     *
     * @param userList 用户openid列表
     * @param cardMessage 卡片消息
     * @return 消息id
     */
    public static String sendCardMsg(List<String> userList, CardMessage cardMessage) {
        if (cardMessage == null) {
            throw new IllegalMessageException();
        }

        MassSendRequest<CardMessage> msg = new MassSendRequest<>();
        msg.setToUsers(userList);
        msg.setMessage(cardMessage);

        String path = PathConstants.MASS_CARD_MSG_PATH;

        ResultWrapper<MessageResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToSnakeJson(msg), MessageResult.class);

        return resultWrapper.getResult().getData().toString();
    }

    private MassMessageService() {
    }
}
