package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.tmsbeans.beans.MediaResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import com.cisdi.nudgeplus.tmsbeans.beans.TicktetResult;
import java.util.HashMap;
import java.util.Map;

/**
 * jsapi接口
 *
 * @author shizhen
 */
public class JsapiService {

    /**
     * 使用缓存下载jsapi上传的文件
     *
     * @param mediaId 文件id
     * @return 文件下载地址
     */
    public static String download(String mediaId) {
        return download(mediaId, TokenService.ACCESS_TOKEN);
    }

    /**
     * 使用指定的ACCESS_TOKEN下载jsapi上传的文件
     *
     * @param mediaId 文件id
     * @return 文件下载地址
     */
    public static String download(String mediaId, String token) {
        if (mediaId == null) {
            throw new IllegalMessageException();
        }
        Map<String, String> map = new HashMap<>();
        map.put("access_token", token);
        map.put("media_id", mediaId);
        String path = PathConstants.BASE_URL + PathConstants.MEDIA_DOWNLOAD_PATH;
        ResultWapper<MediaResult> resultWapper = ClientUtils.get(path, map, MediaResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMediaId();
    }

    /**
     * 使用缓存获取ticket
     *
     * @return ticket
     */
    public static TicktetResult getTicket() {
        return getTicket(TokenService.ACCESS_TOKEN);
    }

    /**
     * 使用指定的ACCESS_TOKEN获取ticket
     *
     * @return ticket
     */
    public static TicktetResult getTicket(String token) {
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", token);
        String path = PathConstants.JSAPI_URL + PathConstants.GET_TICKTET_PATH;
        ResultWapper<TicktetResult> resultWapper = ClientUtils.get(path, map, TicktetResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult();
    }
}