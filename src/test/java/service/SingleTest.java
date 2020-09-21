package service;

import com.cisdi.nudgeplus.sdk.service.ChannelMessageService;
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
import im.qingtui.cross.card_message.Card;
import im.qingtui.cross.card_message.TestKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SingleTest {

    private String openid = NudgePlusConfig.getProperty("openid");

    @Test
    public void sendSingleTextMsg() {
        TextMsg tm = new TextMsg();
        tm.setContent("哈哈，测试一下a");
        //String temp = SingleMessageService.sendTextMsg("6cfd6c5f2c0511e6946b6c92bf21d955", tm);
        String temp = SingleMessageService.sendTextMsg(openid, tm);
        System.out.println(temp);
    }

    @Test
    public void testCardMsg() {
        Card card = TestKt.getTestCard();
        String id = SingleMessageService.sendCardMsg(openid, card);
        System.out.println(id);
    }

    @Test
    public void sendSingleImgMsg() {
        File file = new File(this.getClass().getClassLoader().getResource("test2.png").getFile());
        String id = MediaService.upload(file, MsgType.IMAGE);
        ImageMsg img = new ImageMsg();
        // TODO 上传图片,发送图片URL
        if (id != null) {
            img.setMediaId(id);
            String str = SingleMessageService.sendImageMsg(openid, img);
            System.out.println(str);
        }
    }

    @Test
    public void sendSingleRichMsg() {

        File file = new File(this.getClass().getClassLoader().getResource("test2.png").getFile());
//        String attach_id = MediaService.upload(file, MsgType.RICH_MSG);
//        System.out.println(attach_id);
        File file1 = new File(this.getClass().getClassLoader().getResource("test2.png").getFile());
        File file2 = new File(this.getClass().getClassLoader().getResource("test2.png").getFile());
        String pic_id1 = MediaService.upload(file1, MsgType.IMAGE);
//        String pic_id2 = MediaService.upload(file2, MsgType.IMAGE);
//        System.out.println(pic_id1);
//        System.out.println(pic_id2);
        RichMsg richMsg = new RichMsg();
        richMsg.setTitle("这是一个测试title");
        richMsg.setBody("这是测试的消息体");
        List<RichUrl> urlList = new ArrayList<RichUrl>();
        RichUrl richUrl = new RichUrl();
        richUrl.setName("这是一个链接");
        richUrl.setUrl("http://jfoieoajoifea");
        urlList.add(richUrl);
        urlList.add(richUrl);
        richMsg.setUrlList(urlList);

        List<RichMedia> mediaList = new ArrayList<RichMedia>();
        RichMedia richMedia1 = new RichMedia();
//        RichMedia richMedia2 = new RichMedia();
        richMedia1.setName("这是图片1");
        richMedia1.setMediaId(pic_id1);
//        richMedia2.setName("这是图片2");
//        richMedia2.setMediaId(pic_id1);
        mediaList.add(richMedia1);
//        mediaList.add(richMedia2);
        richMsg.setImgList(mediaList);
//        RichMedia attachment = new RichMedia();
//        attachment.setName("附件attachment");
//        attachment.setMediaId(attach_id);
//        richMsg.setAttachment(attachment);
        String str = SingleMessageService.sendRichMsg(openid, richMsg);
        System.out.println(str);
    }


    @Test
    public void sendBatch() throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int x = 0; x < 10; x++) {
                        try {
                            Thread.sleep(100);
                            sendSingleImgMsg();
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
    public void testSendFileMsg() {
        MediaMsg mediaMsg = new MediaMsg();
        File file = new File(this.getClass().getClassLoader().getResource("test1.jpeg").getFile());
        String mediaId = MediaService.upload(file, MsgType.FILE);
        mediaMsg.setMediaId(mediaId);
        System.out.println(SingleMessageService.sendFileMsg(openid, mediaMsg));
    }

    @Test
    public void testSendTextCardMsg() {
        TextCardMsg textCardMsg = new TextCardMsg();
        textCardMsg.setUrl("https://www.baidu.com");
        textCardMsg.setButtonText("详情");
        textCardMsg.setTitle("标题");
        List<TextCardContent> contentList = new ArrayList<>();
        TextCardContent content = new TextCardContent();
        content.setText("内容");
        ContentAttr contentAttr = new ContentAttr();
        contentAttr.setColor(MsgColor.BLACK);
        content.setAttr(contentAttr);
        contentList.add(content);
        textCardMsg.setContentList(contentList);
        System.out.println(SingleMessageService.sendTextCardMsg(openid, textCardMsg));
    }

    @Test
    public void testSendKeyValueMsg() {
        KeyValueMsg keyValueMsg = new KeyValueMsg();
        keyValueMsg.setTitle("标题");
        keyValueMsg.setUrl("https://www.baidu.com");
        keyValueMsg.setButtonText("详情");
        ColorText subTitle = new ColorText();
        subTitle.setText("开头语");
        subTitle.setMsgColor(MsgColor.BLACK);
        keyValueMsg.setSubTitle(subTitle);
        ColorText footer = new ColorText();
        footer.setText("末尾语");
        footer.setMsgColor(MsgColor.BLACK);
        keyValueMsg.setFooter(footer);
        List<KeyValueMsgContent> contentList = new ArrayList<>();
        KeyValueMsgContent content = new KeyValueMsgContent();
        content.setKey("键1");
        content.setValue("值1");
        content.setMsgValueColor(MsgColor.BLACK);
        contentList.add(content);
        KeyValueMsgContent content2 = new KeyValueMsgContent();
        content2.setKey("键2");
        content2.setValue("值2");
        content2.setMsgValueColor(MsgColor.HIGHLIGHT);
        contentList.add(content2);
        KeyValueMsgContent content3 = new KeyValueMsgContent();
        content3.setKey("键3");
        content3.setValue("值3");
        content3.setMsgValueColor(MsgColor.GRAY);
        contentList.add(content3);
        keyValueMsg.setContent(contentList);
        System.out.println(SingleMessageService.sendKeyValueMsg(openid, keyValueMsg));
    }

    @Test
    public void testSendProcessMsg() {
        ProcessMsg processMsg = new ProcessMsg();
        processMsg.setTitle("标题");
        processMsg.setBody("内容");
        processMsg.setUrl("https://www.baidu.com");
        System.out.println(SingleMessageService.sendProcessMsg(openid, processMsg));
    }

    @Test
    public void testSendNewsMsg() {
        NewsMsg newsMsg = new NewsMsg();
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        File file = new File(this.getClass().getClassLoader().getResource("test1.jpeg").getFile());
        String id = MediaService.upload(file, MsgType.RICH_MSG);
        article.setThumbMediaId(id);
        article.setContent("11111");
        article.setTitle("1");
        article.setUrl("www.baidu.comm");
        article.setXtime(System.currentTimeMillis());
        articles.add(article);

//        Article article2 = new Article();
//        File file2 = new File(this.getClass().getClassLoader().getResource("test2.png").getFile());
//        String id2 = MediaService.upload(file2, MsgType.RICH_MSG);
//        article2.setThumb_media_id(id2);
//        article2.setTitle("2");
//        article2.setUrl("www.baidu.comm");
//        article2.setContent("2222");
//        article2.setXtime(System.currentTimeMillis());
//        articles.add(article2);
//
//        Article article3 = new Article();
//        File file3 = new File(this.getClass().getClassLoader().getResource("test3.png").getFile());
//        String id3 = MediaService.upload(file3, MsgType.RICH_MSG);
//        article3.setThumb_media_id(id3);
//        article3.setTitle("3");
//        article3.setUrl("www.baidu.comm");
//        article3.setContent("33333");
//        article3.setXtime(System.currentTimeMillis());
//        articles.add(article3);
        newsMsg.setArticles(articles);

        System.out.println(SingleMessageService.sendNewsMsg(openid, newsMsg));
    }

    @Test
    public void re() {
        TextCardMsg textCardMsg = new TextCardMsg();
        textCardMsg.setUrl(
            "https://open.qingtui.cn/v1/oauth2/authorize?appid=3659509525&redirect_uri=http%3a%2f%2f172.20.10.2:8081/#/mainPage?openId=779c3b94551841ec951cbf474d84e79f");
        textCardMsg.setButtonText("围观详情");
        textCardMsg.setTitle("你分享的新资讯有100000人偷偷喜欢");

        List<TextCardContent> contentList = new ArrayList<TextCardContent>();
        TextCardContent content = new TextCardContent();
        content.setText("这次分享真是太精彩了！");
        ContentAttr contentAttr = new ContentAttr();
        contentAttr.setColor(MsgColor.BLACK);
        content.setAttr(contentAttr);
        contentList.add(content);
        textCardMsg.setContentList(contentList);
        SingleMessageService.sendTextCardMsg(openid, textCardMsg);

    }

    @Test
    public void testTempCardMsg() {
        Card card = TestKt.getTestCard();
        String id = SingleMessageService.sendTempCardMsg(openid, card);
        System.out.println(id);
    }
}
