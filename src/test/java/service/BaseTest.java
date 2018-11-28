package service;

import com.cisdi.nudgeplus.sdk.service.TokenService;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import org.junit.Before;

public class BaseTest {

    protected static final String APPID = NudgePlusConfig.getValue("APP_ID");
    protected static final String SECRET = NudgePlusConfig.getValue("APP_SECRET");

    @Before
    public void refreshToken() {
        TokenService.refreshToken(APPID, SECRET);
        System.out.println(TokenService.ACCESS_TOKEN);
    }
}
