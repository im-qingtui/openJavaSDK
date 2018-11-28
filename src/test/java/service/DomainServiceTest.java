package service;

import com.cisdi.nudgeplus.sdk.service.DomainService;
import org.junit.Test;

/**
 * 团队接口测试
 *
 * @author shizhen
 */
public class DomainServiceTest extends BaseTest {

    @Test
    public void testGetDomainId() {
        System.out.print(DomainService.getDomainId("90995"));
    }
}