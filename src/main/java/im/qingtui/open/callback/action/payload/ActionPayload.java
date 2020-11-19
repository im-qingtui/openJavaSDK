package im.qingtui.open.callback.action.payload;

import im.qingtui.open.callback.action.Action;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * action payload
 *
 * @author hanxin
 */
@Data
@NoArgsConstructor
public class ActionPayload {

    private long actionTime;

    private String actionId;

    private String appId;

    private String domainId;

    private String accountId;

    private String channelId;

    private String openId;

    private long msgId;

    private List<Action> action;

}