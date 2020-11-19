package im.qingtui.open.callback.action;

import im.qingtui.open.callback.action.payload.ActionPayload;
import im.qingtui.open.callback.utils.GsonFactory;

/**
 * action manager
 *
 * @author hanxin
 */
public final class ActionManager {

    public static String toJson(ActionPayload payload) {
        return GsonFactory.snakeCase().toJson(payload);
    }

    public static ActionPayload fromJson(String json) {
        return GsonFactory.snakeCase().fromJson(json, ActionPayload.class);
    }

    private ActionManager() {
    }

}