package service;

import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.sdk.service.TokenService;
import com.cisdi.nudgeplus.tmsbeans.beans.TokenResult;
import org.junit.Test;

public class TokenServiceTest extends BaseTest {

    volatile int a = 0;

    @Test
    public void getToken() {
        try {
            TokenResult token = TokenService.getToken(APPID, SECRET);
            System.out.println(token.getAccess_token());
        } catch (IllegalRequestException e) {
            System.out.println(e.getError());
        }
    }

    //启动m个线程,每个线程获取n次
    @Test
    public void getTokenBatch() throws InterruptedException {

        for (int i = 0; i < 1; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int x = 0; x < 10; x++) {
                        try {
                            Thread.sleep(1000);
                            TokenService.refreshToken(APPID, SECRET);
                            System.out.println("[a]" + ++a + " [1] " + x + ": " + TokenService.ACCESS_TOKEN);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }) {
            }.start();
        }
        Thread.sleep(60000);
    }

    @Test
    public void testGetToken(){
        System.out.println(TokenService.getToken());
    }
}
