package service;

import com.cisdi.nudgeplus.sdk.service.MemberService;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.Account;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestBatchCreateUsers;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestCreateUser;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestDeleteUsers;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestPagedOrgUserInfo;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestPagedSyncMember;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestPagedUserInfo;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestUpdateUser;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestUser;
import com.cisdi.nudgeplus.tmsbeans.model.request.member.RequestUserBatch;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * 成员业务接口测试
 *
 * @author shizhen
 */
public class MemberServiceTest {

    @Test
    public void testGetUserInformation() {
        RequestPagedOrgUserInfo request = new RequestPagedOrgUserInfo();
        request.setOrgId("b1f60acc9baf41f1b4b616612c03337d");
        request.setPageSize(10);
        request.setRequestPage(1);
        System.out.println(MemberService.pageOrgUserInfo(request));
    }

    @Test
    public void testPageAllUserInformation() {
        RequestPagedUserInfo request = new RequestPagedUserInfo();
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setRequestPage(1);
        request.setPageSize(100);
        System.out.println(MemberService.pageAllUserInfo(request));
    }

    @Test
    public void testGetUserDetailInfo() {
        RequestUser request = new RequestUser();
        request.setAccountId("530c72f1f6384b91a8c0c5a362c1b73d");
        request.setDomainId("f94e0cbd49a74b3fb1c7693a92383be9");
        System.out.println(MemberService.getUserDetailInfo(request));
    }

    @Test
    public void testBatchGetUserDetailInfo() {
        RequestUserBatch request = new RequestUserBatch();
        List<String> accountIds = new ArrayList<>();
        accountIds.add("530c72f1f6384b91a8c0c5a362c1b73d");
        accountIds.add("38dab1546a08496f90631a522302a505");
        request.setAccountIds(accountIds);
        request.setDomainId("f94e0cbd49a74b3fb1c7693a92383be9");
        System.out.println(MemberService.batchGetUserDetailInfo(request));
    }

    @Test
    public void testGetUserDetailInfoByOpenId() {
        System.out.println(MemberService.getUserDetailInfo("60ccc83e99c64e87b5d1813b061ffea9"));
    }

    @Test
    public void testDeleteUser() {
        RequestUser request = new RequestUser();
        request.setDomainId("1fdb126cc85a4f4b83fde8bc961dc763");
        request.setAccountId("9b3c13f67f874b578bc430dfee13b17b");
        MemberService.deleteUser(request);
    }

    @Test
    public void testBatchDeleteUsers() {
        RequestDeleteUsers request = new RequestDeleteUsers();
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        List<Account> accountList = new ArrayList<>();
        Account account = new Account("7dd8f144a0505b86c1934be1101b2e21");
        accountList.add(account);
        request.setUsers(accountList);
        MemberService.batchDeleteUsers(request);
    }


    @Test
    public void testUpdateUserInfo() {
        RequestUpdateUser request = new RequestUpdateUser();
        request.setAccountId("e7e1eafd8be34b0cb7acfd8b077ad30e");
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setName("ekixx");
        request.setComment("这是个大帅哥");
        request.setEmployeeId("222222");
        MemberService.updateUserInfo(request);
    }

    @Test
    public void testSyncUsers() {
        RequestPagedSyncMember request = new RequestPagedSyncMember();
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setSyncTime(0L);
        request.setPageSize(10);
        request.setRequestPage(1);
        System.out.println(MemberService.syncUsers(request));
    }

    @Test
    public void testGetAccountId() {
        System.out.println(MemberService.getAccountId("60ccc83e99c64e87b5d1813b061ffea9"));
    }

    @Test
    public void testGetOpenId() {
        RequestUser request = new RequestUser();
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setAccountId("2344e421a4c8465e9d197b32232bc995");
        System.out.println(MemberService.getOpenId(request));
    }

    @Test
    public void testBatchCreateNewUsers() {
        RequestBatchCreateUsers request = new RequestBatchCreateUsers();
        RequestCreateUser createUser1 = new RequestCreateUser();
        createUser1.setMobile("13340217234");
        createUser1.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        createUser1.setName("喷红龙");
        createUser1.setPassword("abc123");
        createUser1.setOrgId("1738618810684c1d86b159f7d1d3e885");
        createUser1.setEmployeeId("23222233");
        List<RequestCreateUser> createUsers = new ArrayList<>();
        createUsers.add(createUser1);
        request.setUsers(createUsers);
        MemberService.batchCreateNewUsers(request);
    }

    @Test
    public void testCreateNewUsers() {
        RequestCreateUser request = new RequestCreateUser();
        request.setName("皮丘");
        request.setMobile("13340217039");
        request.setPassword("abc123");
        request.setDomainId("b9b3539c60064d5b9c6e39ac985d4369");
        request.setEmployeeId("122n2");
        List<String> orgIdList = new ArrayList<>();
        orgIdList.add("1738618810684c1d86b159f7d1d3e885");
        orgIdList.add("617497eab11e4572914627254105e434");
        request.setOrgList(orgIdList);
        MemberService.createNewUser(request);
    }

    @Test
    public void testCreateNewGuest() {
        RequestCreateUser request = new RequestCreateUser();
        request.setName("皮丘111");
        request.setMobile("13340217039");
        request.setPassword("abc123");
        request.setDomainId("e872447f44864ce4b7ccf93ca8a91b6f");
        request.setEmployeeId("122n2");
//        List<String> orgIdList = new ArrayList<>();
//        orgIdList.add("1738618810684c1d86b159f7d1d3e885");
//        orgIdList.add("617497eab11e4572914627254105e434");
//        request.setOrgList(orgIdList);
        MemberService.createNewGuest(request);
    }
}