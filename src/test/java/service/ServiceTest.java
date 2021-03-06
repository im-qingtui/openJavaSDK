package service;

import com.cisdi.nudgeplus.tmsbeans.model.Article;
import com.cisdi.nudgeplus.tmsbeans.model.NewsMsg;
import com.cisdi.nudgeplus.tmsbeans.model.request.media.MediaMsg;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.cisdi.nudgeplus.sdk.service.MediaService;
import com.cisdi.nudgeplus.sdk.service.ServiceMessageService;
import com.cisdi.nudgeplus.tmsbeans.constants.MsgType;
import com.cisdi.nudgeplus.tmsbeans.model.ImageMsg;
import com.cisdi.nudgeplus.tmsbeans.model.RichMedia;
import com.cisdi.nudgeplus.tmsbeans.model.RichMsg;
import com.cisdi.nudgeplus.tmsbeans.model.RichUrl;
import com.cisdi.nudgeplus.tmsbeans.model.TextMsg;

public class ServiceTest extends BaseTest {

    @Test
    public void sendTextMsg() {
        TextMsg tm = new TextMsg();
        tm.setContent("大家好！");
        String str = ServiceMessageService.sendTextMsg(tm);
        System.out.println(str);
    }

    @Test
    public void sendServiceImgMsg() {
        File file = new File(this.getClass().getClassLoader().getResource("test1.jpeg").getFile());
        String id = MediaService.upload(file, MsgType.IMAGE);
        ImageMsg img = new ImageMsg();
        // TODO 上传图片,发送图片URL
        if (id != null) {
            img.setMedia_id(id);
            String msg_id = ServiceMessageService.sendImageMsg(img);
            System.out.println(msg_id);
        }
    }

    @Test
    public void sendServiceRichMsg() {
        File file = new File("/Users/sunny/Desktop/123.png");
        String attach_id = MediaService.upload(file, MsgType.RICHMSG);
        System.out.println(attach_id);
        File file1 = new File("/Users/sunny/Desktop/124.png");
        String pic_id = MediaService.upload(file1, MsgType.IMAGE);
        System.out.println(pic_id);
        RichMsg richMsg = new RichMsg();
        richMsg.setTitle("这是一个测试title");
        richMsg.setBody("这是测试的消息体");
        List<RichUrl> urlList = new ArrayList<RichUrl>();
        RichUrl richUrl = new RichUrl();
        richUrl.setName("这是一个链接");
        richUrl.setUrl("http://jfoieoajoifea222");
        urlList.add(richUrl);
        urlList.add(richUrl);
        richMsg.setUrlList(urlList);

        List<RichMedia> mediaList = new ArrayList<RichMedia>();
        RichMedia richMedia = new RichMedia();
        richMedia.setName("这是图片");
        richMedia.setMedia_id(pic_id);
        mediaList.add(richMedia);
        mediaList.add(richMedia);
        mediaList.add(richMedia);
        richMsg.setImgList(mediaList);
        RichMedia attachment = new RichMedia();
        attachment.setName("啦啦啦啦德玛西亚");
        attachment.setMedia_id(attach_id);
        richMsg.setAttachment(attachment);
        String msg_id = ServiceMessageService.sendRichMsg(richMsg);
        System.out.println("msgId1:" + msg_id);
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
                            sendServiceRichMsg();
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
    public void testSendSFileMsg() {
        MediaMsg mediaMsg = new MediaMsg();
        mediaMsg.setMedia_id("01111eb3600b4274a8ac28209961f08e");
        System.out.println(ServiceMessageService.sendFileMsg(mediaMsg));
    }

    @Test
    public void testSendNewsMsg() {
        NewsMsg newsMsg = new NewsMsg();
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setContent("内容1");
        File file = new File(this.getClass().getClassLoader().getResource("test1.jpeg").getFile());
        String id = MediaService.upload(file, MsgType.IMAGE);
        article.setThumb_media_id("123");
        article.setTitle("标题1");
        article.setUrl("www.baidu.comm");
        article.setXtime(System.currentTimeMillis());
        articles.add(article);
        newsMsg.setArticles(articles);
        System.out.println(ServiceMessageService.sendNewsMsg(newsMsg));
    }
}
