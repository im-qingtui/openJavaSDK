package im.qingtui.open.callback.event.event;

import lombok.Data;

/**
 * bot added event
 *
 * @author hanxin
 */
@Data
public class BotAddedEvent implements Event {

    /**
     * event type
     */
    public static final String TYPE = "bot_added";

    private String type = TYPE;

    private String channelId;

    private String channelType;

    private String operator;

    private String appId;

}