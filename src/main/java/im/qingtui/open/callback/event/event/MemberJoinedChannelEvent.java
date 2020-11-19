package im.qingtui.open.callback.event.event;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * member joined event
 *
 * @author hanxin
 */
@Data
public class MemberJoinedChannelEvent implements Event {

    /**
     * event type
     */
    public static final String TYPE = "member_joined_channel";

    private String type = TYPE;

    private String channelId;

    private String channelType;

    private String operator;

    private List<String> accounts = new ArrayList<>();

}