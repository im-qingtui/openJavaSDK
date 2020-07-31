package service;

import com.cisdi.nudgeplus.sdk.service.ChannelService;
import com.cisdi.nudgeplus.tmsbeans.beans.channel.ChannelMemberResult;
import com.cisdi.nudgeplus.tmsbeans.beans.channel.ChannelResult;
import org.junit.Test;

/**
 * 群相关接口测试
 * Date:2020/7/29
 *
 * @author GuanZhong
 */
public class ChannelServiceTest {

    @Test
    public void testGetChannelList() {
        ChannelResult channelResult = ChannelService.getChannelList("4856684061");
        System.out.println(channelResult);
    }

    @Test
    public void testGetChannelMemberList() {
        ChannelMemberResult channelMemberList = ChannelService.getChannelMemberList("1ee883f9263f47b284d61754e2fdb6b5");
        System.out.println(channelMemberList);
    }

}
