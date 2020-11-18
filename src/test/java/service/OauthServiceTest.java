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
        UserInfoResult userInfoResult = OAuthService.getUserInfo("D00941ECE7DD405BA4367ACF9404BF5F");
        System.out.println(userInfoResult);
    }

}
