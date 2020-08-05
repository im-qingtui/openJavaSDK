package service;

import com.cisdi.nudgeplus.sdk.service.TokenService;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import org.junit.Test;

public class TokenServiceTest {

    private static volatile int a = 0;

    @Test
    public void getToken() {
        NudgePlusConfig.setAppId("6661152724");
        NudgePlusConfig.setAppSecret("e8db6d8c1c0247648e118e81192edaac");
        String accessToken = TokenService.getToken();

        System.out.println(accessToken);
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
                            String accessToken = TokenService.getToken();
                            System.out.println("[a]" + ++a + " [1] " + x + ": " + accessToken);
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

}
