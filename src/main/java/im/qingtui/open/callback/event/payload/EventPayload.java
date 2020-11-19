package im.qingtui.open.callback.event.payload;


import im.qingtui.open.callback.event.event.Event;
import lombok.Data;

/**
 * event payload
 *
 * @author hanxin
 */
@Data
public abstract class EventPayload<E extends Event> {

    /**
     * event callback type
     */
    public static final String TYPE = "event_callback";

    private String type = TYPE;

    private String eventId;

    private long eventTime;

    private String domainId;

    private String appId;

    public abstract E getEvent();

    public abstract void setEvent(E event);

}