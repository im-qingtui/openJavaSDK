package im.qingtui.open.callback.event.payload;

import im.qingtui.open.callback.event.event.MessageEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * message payload
 *
 * @author hanxin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessagePayload extends EventPayload<MessageEvent> {

    private MessageEvent event;

    public MessagePayload() {
        event = new MessageEvent();
    }
}