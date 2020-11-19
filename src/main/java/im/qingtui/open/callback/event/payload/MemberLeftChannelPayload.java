package im.qingtui.open.callback.event.payload;

import im.qingtui.open.callback.event.event.MemberLeftChannelEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * member left channel payload
 *
 * @author hanxin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MemberLeftChannelPayload extends EventPayload<MemberLeftChannelEvent> {

    private MemberLeftChannelEvent event;

    public MemberLeftChannelPayload() {
        event = new MemberLeftChannelEvent();
    }

}