package im.qingtui.open.callback.event.payload;

import im.qingtui.open.callback.event.event.AppMentionEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * app mention payload
 *
 * @author hanxin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AppMentionPayload extends EventPayload<AppMentionEvent> {

    private AppMentionEvent event;

    public AppMentionPayload() {
        event = new AppMentionEvent();
    }
}