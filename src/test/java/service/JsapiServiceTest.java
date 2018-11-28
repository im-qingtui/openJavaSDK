package service;

import com.cisdi.nudgeplus.sdk.service.JsapiService;
import org.junit.Test;

/**
 * jsapi接口测试类
 *
 * @author shizhen
 */
public class JsapiServiceTest extends BaseTest {

    @Test
    public void testGetTicket(){
        System.out.println(JsapiService.getTicket());
    }
}