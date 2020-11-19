package im.qingtui.open.callback.event.event;

import lombok.Data;

/**
 * bot removed event
 *
 * @author hanxin
 */
@Data
public class BotRemovedEvent implements Event {

    /**
     * event type
     */
    public static final String TYPE = "bot_removed";

    private String type = TYPE;

    private String channelId;

    private String channelType;

    private String operator;

    private String appId;

}