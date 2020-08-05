package datamng;

import com.cisdi.nudgeplus.sdk.datamng.ClientUtils;
import com.cisdi.nudgeplus.sdk.exception.IllegalRequestException;
import com.cisdi.nudgeplus.tmsbeans.beans.MessageResult;
import com.cisdi.nudgeplus.tmsbeans.beans.TokenResult;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class ClientUtilsTest {

    @Test(expected = IllegalRequestException.class)
    public void post() throws IllegalRequestException {
        ClientUtils.post("/v1/message/single/send",
            "2d2d2594346556d3e35bed9e3eac6448",
            "{\"touser\": \"5723775\", \"msgtype\": \"text\", \"text\": {\"content\": \"Hello World\"}}",
            MessageResult.class);
    }

    @Test(expected = IllegalRequestException.class)
    public void get() throws IllegalRequestException {
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("grant_type", "123");
        queryParams.put("appid", "1");
        queryParams.put("secret", "test");
        ClientUtils.get("/v1/token", queryParams, TokenResult.class);
    }

}
