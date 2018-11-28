package com.cisdi.nudgeplus.tmsbeans.beans;

import com.google.gson.annotations.SerializedName;

/**
 * ticket返回结果实体类
 *
 * @author shizhen
 */
public class TicktetResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    private String ticket;
    @SerializedName("expires_in")
    private Integer expiresIn;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}