package im.qingtui.open.callback.event.payload;

import im.qingtui.open.callback.event.event.BotRemovedEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * bot removed payload
 *
 * @author hanxin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BotRemovedPayload extends EventPayload<BotRemovedEvent> {

    private BotRemovedEvent event;

    public BotRemovedPayload() {
        event = new BotRemovedEvent();
    }
}