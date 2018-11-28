package service;

import java.io.File;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import org.junit.Test;
import com.cisdi.nudgeplus.sdk.service.MediaService;
import com.cisdi.nudgeplus.tmsbeans.constants.MsgType;

public class MediaServiceTest extends BaseTest {

    @Test
    public void upload() {
        File file = new File("/Users/cisdi/Downloads/拆墙复盘.txt");
        String id = MediaService.upload(file, MsgType.FILE);
        System.out.println(id);
    }

    @Test
    public void uploadFile() {
        // 中文文件名称会有问题？
        File file = new File(this.getClass().getClassLoader().getResource("123.png").getFile());
        String id = MediaService.upload(file, MsgType.IMAGE);
        System.out.println(id+","+UUID.randomUUID().toString().toLowerCase().replaceAll("-",""));

    }

    @Test
    public void test() throws UnsupportedEncodingException {
        String fileName = "拆墙复盘.txt";
        System.out.println(URLEncoder.encode(fileName, "utf8"));
    }
}
