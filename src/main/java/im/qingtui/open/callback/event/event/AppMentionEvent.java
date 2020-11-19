package im.qingtui.open.callback.event.event;

import lombok.Data;

/**
 * app mention event
 *
 * @author hanxin
 */
@Data
public class AppMentionEvent implements Event {

    /**
     * event type
     */
    public static final String TYPE = "app_mention";

    private String type = TYPE;

    private String channelId;

    private String accountId;

    private String openId;

    private String chatType;

    private String text;

}