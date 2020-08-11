package service;

import com.cisdi.nudgeplus.sdk.service.MassMessageService;
import com.cisdi.nudgeplus.sdk.service.MediaService;
import com.cisdi.nudgeplus.sdk.service.SingleMessageService;
import com.cisdi.nudgeplus.sdk.utils.NudgePlusConfig;
import com.cisdi.nudgeplus.tmsbeans.constants.MsgType;
import com.cisdi.nudgeplus.tmsbeans.model.Article;
import com.cisdi.nudgeplus.tmsbeans.model.CardMessage;
import com.cisdi.nudgeplus.tmsbeans.model.ImageMsg;
import com.cisdi.nudgeplus.tmsbeans.model.NewsMsg;
import com.cisdi.nudgeplus.tmsbeans.model.RichMedia;
import com.cisdi.nudgeplus.tmsbeans.model.RichMsg;
import com.cisdi.nudgeplus.tmsbeans.model.RichUrl;
import com.cisdi.nudgeplus.tmsbeans.model.TextMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.basics.MsgColor;
import com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue.ColorText;
import com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue.KeyValueMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.keyvalue.KeyValueMsgContent;
import com.cisdi.nudgeplus.tmsbeans.model.request.media.MediaMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.process.ProcessMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.textcard.ContentAttr;
import com.cisdi.nudgeplus.tmsbeans.model.request.textcard.TextCardContent;
import com.cisdi.nudgeplus.tmsbeans.model.request.textcard.TextCardMsg;
import com.cisdi.nudgeplus.tmsbeans.model.response.ProcessMsgMassResponse;
import im.qingtui.cross.card_message.Card;
import im.qingtui.cross.card_message.TestKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class MassTest {

    @Test
    public void sendTextMsg() {
        TextMsg tm = new TextMsg();
        tm.setContent(
            "哈哈哈哈哈哈哈，这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试这是群发消息测试");
        List<String> userList = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            userList.add(NudgePlusConfig.getProperty("openid"));
        }
        String msg_id = MassMessageService.sendTextMsg(userList, tm);
        System.out.println(msg_id);
    }


    @Test
    public void sendMassImgMsg() {
        File file = new File(this.getClass().getClassLoader().getResource("test1.jpeg").getFile());
        String id = MediaService.upload(file, MsgType.IMAGE);
        ImageMsg img = new ImageMsg();
        // TODO 上传图片,发送图片URL
        if (id != null) {
            img.setMediaId(id);
            List<String> userList = new ArrayList<String>();
            userList.add("89be684aeae64b87b5ef865d4a56ded6");
            userList.add("83137222dd3c40d8b814a3babab1d648");
            String msg_id = MassMessageService.sendImageMsg(userList, img);
            System.out.println(msg_id);
        }
    }

    @Test
    public void sendRichMsg() {
        File file = new File(this.getClass().getClassLoader().getResource("test2.png").getFile());
        String attach_id = MediaService.upload(file, MsgType.IMAGE);
        System.out.println(attach_id);
        File file1 = new File(this.getClass().getClassLoader().getResource("test3.png").getFile());
        String pic_id = MediaService.upload(file1, MsgType.IMAGE);
        RichMsg richMsg = new RichMsg();
        richMsg.setTitle("这是一个测试title");
        richMsg.setBody("这是测试的消息体123456");
        List<RichUrl> urlList = new ArrayList<RichUrl>();
        RichUrl richUrl = new RichUrl();
        richUrl.setName("这是一个链接");
        richUrl.setUrl("http://jfoieoajoifea");
        urlList.add(richUrl);
        urlList.add(richUrl);
        richMsg.setUrlList(urlList);

        List<RichMedia> mediaList = new ArrayList<RichMedia>();
        RichMedia richMedia1 = new RichMedia();
        RichMedia richMedia2 = new RichMedia();
        richMedia1.setName("这是图片1");
        richMedia1.setMediaId(pic_id);
        richMedia2.setName("这是图片2");
        richMedia2.setMediaId(attach_id);
        mediaList.add(richMedia1);
        mediaList.add(richMedia2);
        richMsg.setImgList(mediaList);
        RichMedia attachment = new RichMedia();
        attachment.setName("demacia");
        attachment.setMediaId(attach_id);
        richMsg.setAttachment(attachment);
        List<String> userList = new ArrayList<String>();
        userList.add("89be684aeae64b87b5ef865d4a56ded6");
        userList.add("83137222dd3c40d8b814a3babab1d648");
        String msg_id = MassMessageService.sendRichMsg(userList, richMsg);
        System.out.println(msg_id);
    }

    @Test
    public void testSendFileMsg() {
        MediaMsg mediaMsg = new MediaMsg();
        mediaMsg.setMediaId("01111eb3600b4274a8ac28209961f08e");
        List<String> userList = new ArrayList<>();
        userList.add("f54e2a94ad724576825e7f0c886c81d2");
        userList.add("89a056757600493ab2d8f6dff671e9d9");
        userList.add("30ce27e162cd495e9341879a55cbc7d8");
        userList.add("08bbb9292856442990dc6372e1125d89");
        userList.add("22760ffee14f4f50b643dde6625bb8f4");
        userList.add("b8d92ccf91f04c4fb9f51771857e584b");
        System.out.println(MassMessageService.sendFileMsg(userList, mediaMsg));
    }

    @Test
    public void testSendTextCardMsg() {
        TextCardMsg textCardMsg = new TextCardMsg();
        textCardMsg.setUrl("https://www.baidu.com");
        textCardMsg.setButtonText("详情");
        textCardMsg.setTitle("长标题123456789012345678901234567890123456789012");
        List<TextCardContent> contentList = new ArrayList<>();
        TextCardContent content = new TextCardContent();
        content.setText("内容1232332/r/n");
        ContentAttr contentAttr = new ContentAttr();
        contentAttr.setColor(MsgColor.HIGHLIGHT);
        content.setAttr(contentAttr);
        contentList.add(content);

        TextCardContent content2 = new TextCardContent();
        content2.setText("内容");
        ContentAttr contentAttr2 = new ContentAttr();
        contentAttr2.setColor(MsgColor.BLACK);
        content2.setAttr(contentAttr2);
        contentList.add(content2);

        TextCardContent content3 = new TextCardContent();
        content3.setText("内容3");
        ContentAttr contentAttr3 = new ContentAttr();
        contentAttr3.setColor(MsgColor.HIGHLIGHT);
        content3.setAttr(contentAttr3);
        contentList.add(content3);

        textCardMsg.setContentList(contentList);
        List<String> userList = new ArrayList<>();
        userList.add("f54e2a94ad724576825e7f0c886c81d2");
        userList.add("89a056757600493ab2d8f6dff671e9d9");
        userList.add("30ce27e162cd495e9341879a55cbc7d8");
        userList.add("08bbb9292856442990dc6372e1125d89");
        userList.add("22760ffee14f4f50b643dde6625bb8f4");
        userList.add("b8d92ccf91f04c4fb9f51771857e584b");
        System.out.println(MassMessageService.sendTextCardMsg(userList, textCardMsg));
    }

    @Test
    public void testSendKeyValueMsg() {
        KeyValueMsg keyValueMsg = new KeyValueMsg();
        keyValueMsg.setTitle("长标题123456789012345678901234567890123456789012");
        keyValueMsg.setUrl("https://www.baidu.com");
        keyValueMsg.setButtonText("详情");
        ColorText subTitle = new ColorText();
        subTitle.setText("开头语");
        subTitle.setMsgColor(MsgColor.BLACK);
        keyValueMsg.setSubTitle(subTitle);
        ColorText footer = new ColorText();
        footer.setText("末尾语");
        footer.setMsgColor(MsgColor.HIGHLIGHT);
        keyValueMsg.setFooter(footer);
        List<KeyValueMsgContent> contentList = new ArrayList<>();
        KeyValueMsgContent content = new KeyValueMsgContent();
        content.setKey("键11");
        content.setValue("值11111111111111111111");
        content.setMsgValueColor(MsgColor.BLACK);
        contentList.add(content);
        KeyValueMsgContent content2 = new KeyValueMsgContent();
        content2.setKey("键212");
        content2.setValue("值222222222222222222");
        content2.setMsgValueColor(MsgColor.HIGHLIGHT);
        contentList.add(content2);
        KeyValueMsgContent content3 = new KeyValueMsgContent();
        content3.setKey("键333");
        content3.setValue("值334444444/r/n23132131");
        content3.setMsgValueColor(MsgColor.GRAY);
        contentList.add(content3);
        keyValueMsg.setContent(contentList);
        List<String> userList = new ArrayList<>();
        userList.add("60ccc83e99c64e87b5d1813b061ffea9 ");
        System.out.println(MassMessageService.sendKeyValueMsg(userList, keyValueMsg));
    }

    @Test
    public void testSendProcessMsg() {
        ProcessMsg processMsg = new ProcessMsg();
        processMsg.setTitle("标题");
        processMsg.setBody("内容");
        processMsg.setUrl("https://www.baidu.com");
        List<String> userList = new ArrayList<>();
        userList.add(NudgePlusConfig.getProperty("openid"));
        userList.add("b8d92ccf91f04c4fb9f51771857e584b");
        List<ProcessMsgMassResponse> responsesList = MassMessageService.sendProcessMsg(userList, processMsg);
        for (ProcessMsgMassResponse responses : responsesList) {
            System.out.println("msgId=" + responses.getMsgId() + ",openId=" + responses.getOpenId());
        }
    }

    @Test
    public void testSendNewsMsg() {
        NewsMsg newsMsg = new NewsMsg();
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setAuthor("b8d92ccf91f04c4fb9f51771857e584b");
        article.setContent("内容1");
        File file = new File(this.getClass().getClassLoader().getResource("test1.jpeg").getFile());
        String id = MediaService.upload(file, MsgType.RICH_MSG);
        article.setThumbMediaId("123");
        article.setTitle("标题1");
        article.setUrl("www.baidu.comm");
        article.setXtime(System.currentTimeMillis());
        articles.add(article);

//        Article article2 = new Article();
//        article2.setAuthor("b8d92ccf91f04c4fb9f51771857e584b");
//        article2.setContent("内容2");
//        File file2 = new File(this.getClass().getClassLoader().getResource("test2.png").getFile());
//        String id2 = MediaService.upload(file2, MsgType.RICH_MSG);
//        article2.setThumb_media_id(id2);
//        article2.setTitle("标题2");
//        article2.setUrl("www.baidu.comm");
//        article2.setXtime(System.currentTimeMillis());
//        articles.add(article2);
        newsMsg.setArticles(articles);
        List<String> userList = new ArrayList<>();
        userList.add("60ccc83e99c64e87b5d1813b061ffea9");
        System.out.println(MassMessageService.sendNewsMsg(userList, newsMsg));
    }

    @Test
    public void testCardMsg() {
        CardMessage cardMessage = new CardMessage();
        Card card = TestKt.getTestCard();
        cardMessage.setCard(card);
        cardMessage.setContent(cardMessage.getContent());
        List<String> userList = new ArrayList<String>();
        userList.add("89be684aeae64b87b5ef865d4a56ded6");
        userList.add("83137222dd3c40d8b814a3babab1d648");
        String id = MassMessageService.sendCardMsg(userList, cardMessage);
        System.out.println(id);
    }
}
