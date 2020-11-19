package im.qingtui.open.callback.event.event;

import lombok.Data;

/**
 * message event
 *
 * @author hanxin
 */
@Data
public class MessageEvent implements Event {

    /**
     * event type
     */
    public static final String TYPE = "message";

    private String type = TYPE;

    private String channelId;

    private String accountId;

    private String openId;

    private String chatType;

    private String text;

}