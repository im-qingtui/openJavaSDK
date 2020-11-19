package im.qingtui.open.callback.event.payload;

import im.qingtui.open.callback.event.event.BotAddedEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * bot added payload
 *
 * @author hanxin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BotAddedPayload extends EventPayload<BotAddedEvent> {

    private BotAddedEvent event;

    public BotAddedPayload() {
        event = new BotAddedEvent();
    }
}