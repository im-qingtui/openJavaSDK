package service;

import com.cisdi.nudgeplus.sdk.service.JsApiService;
import org.junit.Test;

/**
 * jsapi接口测试类
 *
 * @author shizhen
 */
public class JsapiServiceTest {

    @Test
    public void testGetTicket() {
        System.out.println(JsApiService.getTicket());
    }
}