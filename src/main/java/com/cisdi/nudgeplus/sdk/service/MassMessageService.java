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
import com.cisdi.nudgeplus.tmsbeans.model.MassMsg;
import com.cisdi.nudgeplus.tmsbeans.model.NewsMsg;
import com.cisdi.nudgeplus.tmsbeans.model.RichMsg;
import com.cisdi.nudgeplus.tmsbeans.model.TextMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.MassSendRequest;
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
public class MassMessageService {

    /**
     * 根据用户openid列表使用缓存的ACCESS_TOKEN进行文本消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param textMsg 文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(List<String> userList, TextMsg textMsg) {
        return sendTextMsg(userList, textMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid列表使用指定的ACCESS_TOKEN进行文本消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param textMsg 文本消息
     * @return 返回消息id
     */
    public static String sendTextMsg(List<String> userList, TextMsg textMsg, String token) {
        if (textMsg == null) {
            throw new IllegalMessageException();
        }
        MassMsg msg = new MassMsg();
        msg.setTouser(userList);
        msg.setMsgtype(MsgType.TEXT);
        msg.setText(textMsg);
        String path = PathConstants.BASE_URL + PathConstants.MASS_MESSAGE_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMsgId();
    }

    /**
     * 根据用户openid列表使用缓存的ACCESS_TOKEN进行图片消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param imageMsg 图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(List<String> userList, ImageMsg imageMsg) {
        return sendImageMsg(userList, imageMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid列表使用指定的ACCESS_TOKEN进行图片消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param imageMsg 图片消息
     * @return 返回消息id
     */
    public static String sendImageMsg(List<String> userList, ImageMsg imageMsg, String token) {
        if (imageMsg == null) {
            throw new IllegalMessageException();
        }
        MassMsg msg = new MassMsg();
        msg.setTouser(userList);
        msg.setMsgtype(MsgType.IMAGE);
        msg.setImage(imageMsg);
        String path = PathConstants.BASE_URL + PathConstants.MASS_MESSAGE_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMsgId();
    }

    /**
     * 根据用户openid列表使用缓存的ACCESS_TOKEN进行富文本消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param richMsg 富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(List<String> userList, RichMsg richMsg) {
        return sendRichMsg(userList, richMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid列表使用指定的ACCESS_TOKEN进行富文本消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param richMsg 富文本消息
     * @return 返回消息id
     */
    public static String sendRichMsg(List<String> userList, RichMsg richMsg, String token) {
        if (richMsg == null) {
            throw new IllegalMessageException();
        }
        MassMsg msg = new MassMsg();
        msg.setTouser(userList);
        msg.setMsgtype(MsgType.RICHMSG);
        msg.setRichMsg(richMsg);
        String path = PathConstants.BASE_URL + PathConstants.MASS_MESSAGE_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMsgId();
    }

    /**
     * 根据用户openid列表使用缓存的ACCESS_TOKEN进行图文消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param newsMsg 多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(List<String> userList, NewsMsg newsMsg) {
        return sendNewsMsg(userList, newsMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid列表使用指定的ACCESS_TOKEN进行多图文消息群发,openid可重复(会发多次),最多50个
     *
     * @param userList 用户openid列表
     * @param newsMsg 多图文消息
     * @return 返回消息id
     */
    public static String sendNewsMsg(List<String> userList, NewsMsg newsMsg, String token) {
        if (newsMsg == null) {
            throw new IllegalMessageException();
        }
        MassSendRequest<NewsMsgParam> msg = new MassSendRequest<>();
        List<NewsMsgArticle> newsMsgArticleList = ClassUtils.convertNewsMsg(newsMsg.getArticles());
        NewsMsgParam newsMsgParam = new NewsMsgParam();
        newsMsgParam.setArticle_list(newsMsgArticleList);
        msg.setMessage(newsMsgParam);
        msg.setTo_users(userList);
        String path = PathConstants.BASE_URL + PathConstants.MASS_NEWS_MSG_PATH;
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
     * @param userList 用户openid列表
     * @param mediaMsg 发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(List<String> userList, MediaMsg mediaMsg) {
        return sendFileMsg(userList, mediaMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送文件消息
     *
     * @param userList 用户openid列表
     * @param mediaMsg 发送的文件消息实体
     * @return 消息id
     */
    public static String sendFileMsg(List<String> userList, MediaMsg mediaMsg, String token) {
        if (mediaMsg == null) {
            throw new IllegalMessageException();
        }
        MassSendRequest<MediaMsg> msg = new MassSendRequest<>();
        msg.setTo_users(userList);
        msg.setMessage(mediaMsg);
        String path = PathConstants.BASE_URL + PathConstants.MASS_FILE_MSG_PATH;
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
     * @param userList 用户openid列表
     * @param textCardMsg 发送的文本卡片消息实体
     * @return 消息id
     */
    public static String sendTextCardMsg(List<String> userList, TextCardMsg textCardMsg) {
        return sendTextCardMsg(userList, textCardMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送文本卡片消息
     *
     * @param userList 用户openid列表
     * @param textCardMsg 发送的文本卡片消息实体
     * @return 消息id
     */
    public static String sendTextCardMsg(List<String> userList, TextCardMsg textCardMsg, String token) {
        if (textCardMsg == null) {
            throw new IllegalMessageException();
        }
        MassSendRequest<TextCardMsg> msg = new MassSendRequest<>();
        msg.setTo_users(userList);
        msg.setMessage(textCardMsg);
        String path = PathConstants.BASE_URL + PathConstants.MASS_TEXT_CARD_MSG_PATH;
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
     * @param userList 用户openid列表
     * @param keyValueMsg 发送的键值对消息实体
     * @return 消息id
     */
    public static String sendKeyValueMsg(List<String> userList, KeyValueMsg keyValueMsg) {
        return sendKeyValueMsg(userList, keyValueMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送键值对消息
     *
     * @param userList 用户openid列表
     * @param keyValueMsg 发送的键值对消息实体
     * @return 消息id
     */
    public static String sendKeyValueMsg(List<String> userList, KeyValueMsg keyValueMsg, String token) {
        if (keyValueMsg == null) {
            throw new IllegalMessageException();
        }
        MassSendRequest<KeyValueMsg> msg = new MassSendRequest<>();
        msg.setTo_users(userList);
        msg.setMessage(keyValueMsg);
        String path = PathConstants.BASE_URL + PathConstants.MASS_KEY_VALUE_MSG_PATH;
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
     * @param userList 用户openid列表
     * @param processMsg 发送的待办消息实体
     * @return 消息id
     */
    public static List<ProcessMsgMassResponse> sendProcessMsg(List<String> userList, ProcessMsg processMsg) {
        return sendProcessMsg(userList, processMsg, TokenService.ACCESS_TOKEN);
    }

    /**
     * 根据用户openid使用指定的ACCESS_TOKEN发送待办消息
     *
     * @param userList 用户openid列表
     * @param processMsg 发送的待办消息实体
     * @return 消息id
     */
    public static List<ProcessMsgMassResponse> sendProcessMsg(List<String> userList, ProcessMsg processMsg, String token) {
        if (processMsg == null) {
            throw new IllegalMessageException();
        }
        MassSendRequest<ProcessMsg> msg = new MassSendRequest<>();
        msg.setTo_users(userList);
        msg.setMessage(processMsg);
        String path = PathConstants.BASE_URL + PathConstants.MASS_PROCESS_MSG_PATH;
        ResultWapper<MessageResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(msg), MessageResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        List<ProcessMsgMassResponse> response = new ArrayList<>();
        for (int i = 0; i < ((ArrayList) resultWapper.getResult().getData()).size(); i++) {
            ProcessMsgMassResponse processMsgMassResponse = new ProcessMsgMassResponse();
            processMsgMassResponse.setMsgId((String) ((LinkedTreeMap) ((ArrayList) resultWapper.getResult().getData()).get(i)).get("msg_id"));
            processMsgMassResponse.setOpenId((String) ((LinkedTreeMap) ((ArrayList) resultWapper.getResult().getData()).get(i)).get("open_id"));
            response.add(processMsgMassResponse);
        }
        return response;
    }
}
