package datamng;

import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.tmsbeans.beans.MessageResult;
import com.cisdi.nudgeplus.tmsbeans.beans.ResultWapper;
import com.cisdi.nudgeplus.tmsbeans.beans.TokenResult;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ClientUtilsTest {

    @Test
    public void post() throws IllegalRequestException {
        ResultWapper<MessageResult> resultWapper = ClientUtils.post("/message/single/send",
            "2d2d2594346556d3e35bed9e3eac6448",
            "{\"touser\": \"5723775\", \"msgtype\": \"text\", \"text\": {\"content\": \"Hello World\"}}",
            MessageResult.class);
    }

    @Test
    public void get() throws IllegalRequestException {
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("grant_type", "123");
        queryParams.put("appid", "1");
        queryParams.put("secret", "test");
        ResultWapper<TokenResult> resultWapper = ClientUtils.get("/token", queryParams, TokenResult.class);
        System.out.println(resultWapper.getResult().getAccess_token());
    }

}
