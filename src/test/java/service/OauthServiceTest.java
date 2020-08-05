package service;

import com.cisdi.nudgeplus.sdk.service.OAuthService;
import com.cisdi.nudgeplus.tmsbeans.beans.UserInfoResult;
import org.junit.Test;

/**
 * @author yiya
 */
public class OauthServiceTest {

    @Test
    public void testUserInfo() {
        UserInfoResult userInfoResult = OAuthService.getUserInfo("A7657C7857D2423E87C126A94CF2C9F3");
        System.out.println(userInfoResult);
    }

}
