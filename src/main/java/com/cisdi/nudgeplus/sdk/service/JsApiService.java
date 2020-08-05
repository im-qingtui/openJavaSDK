package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.tmsbeans.beans.MediaResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.beans.TicketResult;
import java.util.HashMap;
import java.util.Map;

/**
 * jsapi接口
 *
 * @author shizhen
 */
public final class JsApiService {

    /**
     * 下载jsapi上传的文件
     *
     * @param mediaId 文件id
     * @return 文件下载地址
     */
    public static String download(String mediaId) {
        if (mediaId == null) {
            throw new IllegalMessageException();
        }

        Map<String, String> map = new HashMap<>();
        map.put("access_token", TokenService.getToken());
        map.put("media_id", mediaId);

        String path = PathConstants.MEDIA_DOWNLOAD_PATH;

        ResultWrapper<MediaResult> resultWrapper = ClientUtils.get(path, map, MediaResult.class);

        return resultWrapper.getResult().getMediaId();
    }

    /**
     * 获取ticket
     *
     * @return ticket
     */
    public static TicketResult getTicket() {
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", TokenService.getToken());

        String path = PathConstants.GET_TICKTET_PATH;

        ResultWrapper<TicketResult> resultWrapper = ClientUtils.get(path, map, TicketResult.class);

        return resultWrapper.getResult();
    }

    private JsApiService() {
    }
}