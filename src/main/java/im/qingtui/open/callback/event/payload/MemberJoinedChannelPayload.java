package im.qingtui.open.callback.event.payload;

import im.qingtui.open.callback.event.event.MemberJoinedChannelEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * member joined channel payload
 *
 * @author hanxin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberJoinedChannelPayload extends EventPayload<MemberJoinedChannelEvent> {

    private MemberJoinedChannelEvent event;

    public MemberJoinedChannelPayload() {
        event = new MemberJoinedChannelEvent();
    }
}