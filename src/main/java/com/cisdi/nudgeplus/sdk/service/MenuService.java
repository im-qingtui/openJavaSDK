package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MenuResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import com.cisdi.nudgeplus.tmsbeans.model.Menu;

/**
 * 创建自定义菜单
 */
public class MenuService {

    /**
     * 使用缓存的ACCESS_TOKEN创建自定义菜单
     *
     * @param menu 自定义菜单消息体
     * @return 返回菜单id
     */
    public static String createMenu(Menu menu) {
        return createMenu(menu, TokenService.ACCESS_TOKEN);
    }

    /**
     * 使用指定的ACCESS_TOKEN创建自定义菜单
     *
     * @param menu 自定义菜单消息体
     * @return 返回菜单id
     */
    public static String createMenu(Menu menu, String token) {
        if (menu == null) {
            throw new IllegalMessageException();
        }
        String path = PathConstants.BASE_URL + PathConstants.CREATE_MENU_PATH;
        ResultWapper<MenuResult> resultWapper = ClientUtils.post(
            path, token,
            JsonUtils.beanToJson(menu), MenuResult.class);
        if (resultWapper.isError()) {
            throw new IllegalRequestException(resultWapper.getErrorResult());
        }
        return resultWapper.getResult().getMenuId();
    }

}
