package com.cisdi.nudgeplus.sdk.constants;

import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;

public final class PathConstants {

    public static final String TOKEN = "/v1/token";

    public static final String SINGLE_MESSAGE_PATH = "/v1/message/single/send";
    public static final String MASS_MESSAGE_PATH = "/v1/message/mass/send";
    public static final String SERVICE_MESSAGE_PATH = "/v1/message/service/send";
    public static final String SEND_MESSAGE_PATH = "/v1/message/status/get";

    public static final String SINGLE_TEXT_MSG_PATH = "/v1/message/text/send/single";
    public static final String MASS_TEXT_MSG_PATH = "/v1/message/text/send/mass";
    public static final String SERVICE_TEXT_MSG_PATH = "/v1/message/text/send/service";
    public static final String CHANNEL_TEXT_MSG_PATH = "/v1/message/text/send/channel";

    public static final String SINGLE_IMAGE_MSG_PATH = "/v1/message/image/send/single";
    public static final String MASS_IMAGE_MSG_PATH = "/v1/message/image/send/mass";
    public static final String SERVICE_IMAGE_MSG_PATH = "/v1/message/image/send/service";
    public static final String CHANNEL_IMAGE_MSG_PATH = "/v1/message/image/send/channel";

    public static final String SINGLE_RICH_MSG_PATH = "/v1/message/rich/send/single";
    public static final String MASS_RICH_MSG_PATH = "/v1/message/rich/send/mass";
    public static final String SERVICE_RICH_MSG_PATH = "/v1/message/rich/send/service";
    public static final String CHANNEL_RICH_MSG_PATH = "/v1/message/rich/send/channel";

    public static final String CREATE_MENU_PATH = "/v1/menu/create";

    public static final String UPLOAD_MEDIA_PATH = "/v1/media/upload";

    public static final String OAUTH_USERINFO_PATH = "/v1/oauth2/userinfo";

    public static final String SINGLE_FILE_MSG_PATH = "/v1/message/file/send/single";
    public static final String MASS_FILE_MSG_PATH = "/v1/message/file/send/mass";
    public static final String SERVICE_FILE_MSG_PATH = "/v1/message/file/send/service";
    public static final String CHANNEL_FILE_MSG_PATH = "/v1/message/file/send/channel";

    public static final String SINGLE_TEXT_CARD_MSG_PATH = "/v1/message/textCard/send/single";
    public static final String MASS_TEXT_CARD_MSG_PATH = "/v1/message/textCard/send/mass";
    public static final String CHANNEL_TEXT_CARD_MSG_PATH = "/v1/message/textCard/send/channel";

    public static final String SINGLE_KEY_VALUE_MSG_PATH = "/v1/message/keyValue/send/single";
    public static final String MASS_KEY_VALUE_MSG_PATH = "/v1/message/keyValue/send/mass";
    public static final String CHANNEL_KEY_VALUE_MSG_PATH = "/v1/message/keyValue/send/channel";

    public static final String SINGLE_CARD_MSG_PATH = "/v1/message/card/send/single";
    public static final String MASS_CARD_MSG_PATH = "/v1/message/card/send/mass";
    public static final String SERVICE_CARD_MSG_PATH = "/v1/message/card/send/service";
    public static final String CHANNEL_CARD_MSG_PATH = "/v1/message/card/send/channel";

    public static final String SINGLE_PROCESS_MSG_PATH = "/v1/message/process/send/single";
    public static final String MASS_PROCESS_MSG_PATH = "/v1/message/process/send/mass";
    public static final String COMPLETE_PROCESS_MSG_PATH = "/v1/message/process/complete";

    public static final String SINGLE_NEWS_MSG_PATH = "/v1/message/news/send/single";
    public static final String MASS_NEWS_MSG_PATH = "/v1/message/news/send/mass";
    public static final String SERVICE_NEWS_MSG_PATH = "/v1/message/news/send/service";
    public static final String CHANNEL_NEWS_MSG_PATH = "/v1/message/news/send/channel";

    public static final String GET_DOMAIN_ID_PATH = "/team/domain/id/get";

    public static final String PAGE_ORG_USER_INFO_PATH = "/team/member/org/paged";
    public static final String PAGE_ALL_USER_INFO_PATH = "/team/member/all/paged";
    public static final String GET_USER_DETAIL_INFO_PATH = "/team/member/detail";
    public static final String BATCH_GET_USER_DETAIL_INFO_PATH = "/team/member/detail/batch/json";
    public static final String GET_USER_DETAIL_INFO_OPENID_PATH = "/team/member/openid/detail";
    public static final String DELETE_SINGLE_MEMBER_PATH = "/team/member/delete/single/json";
    public static final String DELETE_BATCH_MEMBER_PATH = "/team/member/delete/batch/json";
    public static final String UPDATE_USER_SINGLE_PATH = "/team/member/update/single/json";
    public static final String SYNC_MEMBER_PATH = "/team/member/sync";
    public static final String GET_MEMBER_ACCOUNT_PATH = "/team/member/account/get";
    public static final String GET_MEMBER_OPEN_ID_PATH = "/team/member/openid/get";
    public static final String BATCH_CREATE_USERS_PATH = "/team/member/create/batch/json";
    public static final String CREATE_USER_PATH = "/team/member/create/single/json";


    public static final String GET_ORG_LIST_PATH = "/team/org/list";
    public static final String PAGE_ORG_LIST_PATH = "/team/org/paged";
    public static final String GET_ORG_DETAIL_PATH = "/team/org/detail";
    public static final String SUM_USER_OF_ORG_PATH = "/team/org/member/count";
    public static final String ORG_DELETE_PATH = "/team/org/delete/json";
    public static final String ORG_CREATE_PATH = "/team/org/create/json";
    public static final String ORG_UPDATE_PATH = "/team/org/update/json";
    public static final String ORG_SYNC_PATH = "/team/org/sync";

    public static final String MEDIA_DOWNLOAD_PATH = "/team/media/download/path";

    public static final String GET_CHANNEL_LIST_PATH = "/team/channel/list";
    public static final String GET_CHANNEL_MEMBER_LIST_PATH = "/team/channel/member/list";

    public static final String GET_TICKET_PATH = "/js/ticket/get";

    private PathConstants() {
    }
}
