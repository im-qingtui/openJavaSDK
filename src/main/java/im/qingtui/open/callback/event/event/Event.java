package im.qingtui.open.callback.event.event;

import java.io.Serializable;

/**
 * event
 *
 * @author hanxin
 */
public interface Event extends Serializable {

    String getType();

    default String getSubType() {
        return "";
    }

}