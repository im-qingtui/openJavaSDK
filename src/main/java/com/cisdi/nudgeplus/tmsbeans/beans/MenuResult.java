package com.cisdi.nudgeplus.tmsbeans.beans;

public class MenuResult extends BaseResult {
    private static final long serialVersionUID = 1L;

    private String menu_id;

    public String getMenuId(){
        return menu_id;
    }
    @Deprecated
    public String getMenu_id() {
        return menu_id;
    }

    public void setMenuId(String menuId){
        this.menu_id = menuId;
    }
    @Deprecated
    public void setMenu_id(String menuId) {
        this.menu_id = menuId;
    }
}
