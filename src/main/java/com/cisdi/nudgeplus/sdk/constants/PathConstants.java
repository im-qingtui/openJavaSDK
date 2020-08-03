package com.cisdi.nudgeplus.sdk.constants;

import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;

public class PathConstants {

    public static final String BASE_URL = NudgePlusConfig.getValue("baseURL");
    public static final String TEAM_URL = NudgePlusConfig.getValue("teamURL");
    public static final String JSAPI_URL = NudgePlusConfig.getValue("jsapiURL");

    public final static String TOKEN = "/token";

    public final static String SINGLE_MESSAGE_PATH = "/message/single/send";
    public final static String MASS_MESSAGE_PATH = "/message/mass/send";
    public final static String SERVICE_MESSAGE_PATH = "/message/service/send";
    public final static String SEND_MESSAGE_PATH = "/message/status/get";

    public final static String SINGLE_TEXT_MSG_PATH = "/message/text/send/single";
    public final static String MASS_TEXT_MSG_PATH = "/message/text/send/mass";
    public final static String SERVICE_TEXT_MSG_PATH = "/message/text/send/service";
    public final static String CHANNEL_TEXT_MSG_PATH = "/message/text/send/channel";

    public final static String SINGLE_IMAGE_MSG_PATH = "/message/image/send/single";
    public final static String MASS_IMAGE_MSG_PATH = "/message/image/send/mass";
    public final static String SERVICE_IMAGE_MSG_PATH = "/message/image/send/service";
    public final static String CHANNEL_IMAGE_MSG_PATH = "/message/image/send/channel";

    public final static String SINGLE_RICH_MSG_PATH = "/message/rich/send/single";
    public final static String MASS_RICH_MSG_PATH = "/message/rich/send/mass";
    public final static String SERVICE_RICH_MSG_PATH = "/message/rich/send/service";
    public final static String CHANNEL_RICH_MSG_PATH = "/message/rich/send/channel";

    public final static String CREATE_MENU_PATH = "/menu/create";

    public final static String UPLOAD_MEDIA_PATH = "/media/upload";

    public final static String OAUTH_USERINFO_PATH = "/oauth2/userinfo";

    public final static String SINGLE_FILE_MSG_PATH = "/message/file/send/single";
    public final static String MASS_FILE_MSG_PATH = "/message/file/send/mass";
    public final static String SERVICE_FILE_MSG_PATH = "/message/file/send/service";
    public final static String CHANNEL_FILE_MSG_PATH = "/message/file/send/channel";

    public final static String SINGLE_TEXT_CARD_MSG_PATH = "/message/textCard/send/single";
    public final static String MASS_TEXT_CARD_MSG_PATH = "/message/textCard/send/mass";
    public final static String CHANNEL_TEXT_CARD_MSG_PATH = "/message/textCard/send/channel";

    public final static String SINGLE_KEY_VALUE_MSG_PATH = "/message/keyValue/send/single";
    public final static String MASS_KEY_VALUE_MSG_PATH = "/message/keyValue/send/mass";
    public final static String CHANNEL_KEY_VALUE_MSG_PATH = "/message/keyValue/send/channel";

    public final static String SINGLE_CARD_MSG_PATH = "/message/card/send/single";
    public final static String MASS_CARD_MSG_PATH = "/message/card/send/mass";
    public final static String SERVICE_CARD_MSG_PATH = "/message/card/send/service";
    public final static String CHANNEL_CARD_MSG_PATH = "/message/card/send/channel";

    public final static String SINGLE_PROCESS_MSG_PATH = "/message/process/send/single";
    public final static String MASS_PROCESS_MSG_PATH = "/message/process/send/mass";
    public final static String COMPLETE_PROCESS_MSG_PATG = "/message/process/complete";

    public final static String SINGLE_NEWS_MSG_PATH = "/message/news/send/single";
    public final static String MASS_NEWS_MSG_PATH = "/message/news/send/mass";
    public final static String SERVICE_NEWS_MSG_PATH = "/message/news/send/service";
    public final static String CHANNEL_NEWS_MSG_PATH = "/message/news/send/channel";

    public final static String GET_DOMAIN_ID_PATH = "/domain/id/get";

    public final static String PAGE_ORG_USER_INFO_PATH = "/member/org/paged";
    public final static String PAGE_ALL_USER_INFO_PATH = "/member/all/paged";
    public final static String GET_USER_DETAIL_INFO_PATH = "/member/detail";
    public final static String BATCH_GET_USER_DETAIL_INFO_PATH = "/member/detail/batch/json";
    public final static String GET_USER_DETAIL_INFO_OPENID_PATH = "/member/openid/detail";
    public final static String DELETE_SINGLE_MEMBER_PATH = "/member/delete/single/json";
    public final static String DELETE_BATCH_MEMBER_PATH = "/member/delete/batch/json";
    public final static String UPDATE_USER_SINGLE_PATH = "/member/update/single/json";
    public final static String SYNC_MEMBER_PATH = "/member/sync";
    public final static String GET_MEMBER_ACCOUNT_PATH = "/member/account/get";
    public final static String GET_MEMBER_OPEN_ID_PATH = "/member/openid/get";
    public final static String BATCH_CREATE_USERS_PATH = "/member/create/batch/json";
    public final static String CREATE_USER_PATH = "/member/create/single/json";


    public final static String GET_ORG_LIST_PATH = "/org/list";
    public final static String PAGE_ORG_LIST_PATH = "/org/paged";
    public final static String GET_ORG_DETAIL_PATH = "/org/detail";
    public final static String SUM_USER_OF_ORG_PATH = "/org/member/count";
    public final static String ORG_DELETE_PATH = "/org/delete/json";
    public final static String ORG_CREATE_PATH = "/org/create/json";
    public final static String ORG_UOPDATE_PATH = "/org/update/json";
    public final static String ORG_SYNC_PATH = "/org/sync";

    public final static String MEDIA_DOWNLOAD_PATH = "/media/download/path";

    public final static String GET_TICKTET_PATH = "/js/ticket/get";

    public final static String GET_CHANNEL_LIST_PATH = "/channel/list";
    public final static String GET_CHANNEL_MEMBER_LIST_PATH = "/channel/member/list";
}
