package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MediaResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import java.io.File;

public final class MediaService {

    /**
     * 上传多媒体文件
     *
     * @param media 多媒体文件File对象
     * @param type MsgType中的文件类型
     * @return 返回消息id
     */
    public static String upload(File media, String type) {
        String path = PathConstants.UPLOAD_MEDIA_PATH;

        ResultWrapper<MediaResult> resultWrapper = ClientUtils.uploadMedia(
            path, TokenService.getToken(), type, media,
            MediaResult.class);

        return resultWrapper.getResult().getMediaId();
    }

    private MediaService() {
    }

}
