package service;

import com.cisdi.nudgeplus.sdk.service.ProcessService;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import com.cisdi.nudgeplus.tmsbeans.model.request.process.CompleteProcess;
import org.junit.Test;

/**
 * 待办消息接口测试类
 *
 * @author shizhen
 */
public class ProcessServiceTest {

    private String openid = NudgePlusConfig.getProperty("openid");

    @Test
    public void testProcessComplete() {
        CompleteProcess completeProcess = new CompleteProcess();
        completeProcess.setMsgId("c574c438d0a240899fbf09d6b96a7246");
        completeProcess.setOpenId("872507a4038a49109ce99402d20f94c4");
        ProcessService.processComplete(completeProcess);
    }
}