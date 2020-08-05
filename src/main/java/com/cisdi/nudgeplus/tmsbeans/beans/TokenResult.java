package com.cisdi.nudgeplus.tmsbeans.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TokenResult extends BaseResult {

    private String accessToken;

    private String refreshToken;

    private long expiresIn;

}
