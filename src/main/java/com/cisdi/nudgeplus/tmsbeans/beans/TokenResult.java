package com.cisdi.nudgeplus.tmsbeans.beans;

public class TokenResult extends BaseResult {

    private static final long serialVersionUID = 1L;

    private String access_token;

    private String refresh_token;

    private long expires_in;

    public String getAccessToken(){
        return access_token;
    }
    @Deprecated
    public String getAccess_token() {
        return access_token;
    }

    public void setAccessToken(String accessToken){
        this.access_token = accessToken;
    }
    @Deprecated
    public void setAccess_token(String accessToken) {
        this.access_token = accessToken;
    }

    public long gertExporesIn(){
        return expires_in;
    }

    @Deprecated
    public long getExpires_in() {
        return expires_in;
    }

    public void setExpiresIn(long expiresIn){
        this.expires_in = expiresIn;
    }

    @Deprecated
    public void setExpires_in(long expiresIn) {
        this.expires_in = expiresIn;
    }

    public String getRefreshToken(){
        return refresh_token;
    }
    @Deprecated
    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefreshToken(String refreshToken){
        this.refresh_token = refreshToken;
    }
    @Deprecated
    public void setRefresh_token(String refreshToken) {
        this.refresh_token = refreshToken;
    }

}
