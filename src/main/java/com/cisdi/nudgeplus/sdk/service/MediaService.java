package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.tmsbeans.beans.MediaResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import java.io.File;

public class MediaService {

    /**
     * 使用缓存的ACCESS_TOKEN上传多媒体文件
     *
     * @param media 多媒体文件File对象
     * @param type MsgType中的文件类型
     * @return 返回消息id
     */
    public static String upload(File media, String type) {
        return upload(media, type, TokenService.ACCESS_TOKEN);
    }

    /**
     * 使用指定的ACCESS_TOKEN上传多媒体文件
     *
     * @param media 多媒体文件File对象
     * @param type MsgType中的文件类型
     * @return 返回消息id
     */
    public static String upload(File media, String type, String token) {
        String path = PathConstants.BASE_URL + PathConstants.UPLOAD_MEDIA_PATH;
        ResultWapper<MediaResult> resultWapper = ClientUtils.uploadMedia(
            path, token, type, media,
            MediaResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMediaId();
    }

}
