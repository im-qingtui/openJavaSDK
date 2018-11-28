package service;

import com.cisdi.nudgeplus.sdk.service.OrgService;
import com.cisdi.nudgeplus.tmsbeans.model.request.org.RequestNewOrg;
import com.cisdi.nudgeplus.tmsbeans.model.request.org.RequestOrg;
import com.cisdi.nudgeplus.tmsbeans.model.request.org.RequestOrgName;
import com.cisdi.nudgeplus.tmsbeans.model.request.org.RequestOrgSycInfo;
import com.cisdi.nudgeplus.tmsbeans.model.request.org.RequestPagedOrg;
import org.junit.Test;

/**
 * 组织机构接口测试
 *
 * @author shizhen
 */
public class OrgServiceTest extends BaseTest {

    @Test
    public void testGetOrganizationList() {
        RequestOrg request = new RequestOrg();
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setOrgId("279e479cc6dd480aa71f552745662784");
        System.out.println(OrgService.getOrganizationList(request));
    }

    @Test
    public void testPagedOrganizationList() {
        RequestPagedOrg request = new RequestPagedOrg();
        request.setPageSize(10);
        request.setRequestPage(1);
        System.out.println(OrgService.pagedOrganizationList(request));
    }

    @Test
    public void testGetOrganizationDetail() {
        RequestOrg request = new RequestOrg();
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setOrgId("617497eab11e4572914627254105e434");
        System.out.println(OrgService.getOrganizationDetail(request));
    }

    @Test
    public void testSumUserOfOrganization() {
        RequestOrg request = new RequestOrg();
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setOrgId("617497eab11e4572914627254105e434");
        System.out.println(OrgService.sumUserOfOrganization(request));
    }

    @Test
    public void testDeleteTheUnderlyingOrg() {
        RequestOrg request = new RequestOrg();
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setOrgId("529126368b834bbfb2763150e4447407");
        OrgService.deleteTheUnderlyingOrg(request);
    }

    @Test
    public void testCreateNewOrg() {
        RequestNewOrg request = new RequestNewOrg();
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setName("我们是共产主义的接班人111");
        request.setParentId("279e479cc6dd480aa71f552745662784");
        System.out.println(OrgService.createNewOrg(request));
    }

    @Test
    public void testUpdateOrg() {
        RequestOrgName request = new RequestOrgName();
        request.setName("少先队员");
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setOrgId("279e479cc6dd480aa71f552745662784");
        OrgService.updateOrg(request);
    }

    @Test
    public void testSynOrgInfo() {
        RequestOrgSycInfo request = new RequestOrgSycInfo();
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setSyncTime(0L);
        System.out.println(OrgService.synOrgInfo(request));
    }
}