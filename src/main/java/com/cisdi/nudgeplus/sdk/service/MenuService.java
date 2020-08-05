package com.cisdi.nudgeplus.sdk.service;

import com.cisdi.nudgeplus.sdk.constants.PathConstants;
import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalMessageException;
import com.cisdi.nudgeplus.sdk.utils.JsonUtils;
import com.cisdi.nudgeplus.tmsbeans.beans.MenuResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWrapper;
import com.cisdi.nudgeplus.tmsbeans.model.Menu;

/**
 * 创建自定义菜单
 */
public final class MenuService {

    /**
     * 创建自定义菜单
     *
     * @param menu 自定义菜单消息体
     * @return 返回菜单id
     */
    public static String createMenu(Menu menu) {
        if (menu == null) {
            throw new IllegalMessageException();
        }

        String path = PathConstants.CREATE_MENU_PATH;

        ResultWrapper<MenuResult> resultWrapper = ClientUtils.post(
            path, TokenService.getToken(),
            JsonUtils.beanToJson(menu), MenuResult.class);

        return resultWrapper.getResult().getMenuId();
    }

    private MenuService() {
    }

}
