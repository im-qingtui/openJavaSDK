package im.qingtui.open.callback.event;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import im.qingtui.open.callback.event.payload.AppMentionPayload;
import im.qingtui.open.callback.event.payload.BotAddedPayload;
import im.qingtui.open.callback.event.payload.BotRemovedPayload;
import im.qingtui.open.callback.event.payload.EventPayload;
import im.qingtui.open.callback.event.payload.MemberJoinedChannelPayload;
import im.qingtui.open.callback.event.payload.MemberLeftChannelPayload;
import im.qingtui.open.callback.event.payload.MessagePayload;
import im.qingtui.open.callback.utils.GsonFactory;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public final class EventManager {

    private static Map<String, EventPayload> map;

    static {
        init();
    }

    public static String toJson(EventPayload payload) {
        return GsonFactory.snakeCase().toJson(payload);
    }

    public static EventPayload fromJson(String json) {
        String key = extractEventTypeKey(json);

        if (null != map.get(key)) {
            return GsonFactory.snakeCase().fromJson(json, map.get(key).getClass());
        } else {
            return null;
        }
    }


    private static void init() {
        map = new HashMap<>();

        register(new AppMentionPayload());
        register(new MemberJoinedChannelPayload());
        register(new MemberLeftChannelPayload());
        register(new BotAddedPayload());
        register(new BotRemovedPayload());
        register(new MessagePayload());
    }

    public static void register(EventPayload eventPayload) {
        String key = buildKey(eventPayload.getEvent().getType(), eventPayload.getEvent().getSubType());
        map.put(key, eventPayload);
    }

    public static void deregister(EventPayload eventPayload) {
        String key = buildKey(eventPayload.getEvent().getType(), eventPayload.getEvent().getSubType());
        map.remove(key);
    }

    private static String extractEventTypeKey(String json) {
        String type = "";
        String subType = "";

        try {
            JsonElement root = JsonParser.parseString(json);

            if (root != null && root.isJsonObject() && root.getAsJsonObject().has("event")) {
                JsonElement event = root.getAsJsonObject().get("event");

                if (event.isJsonObject()) {
                    if (event.getAsJsonObject().has("type")) {
                        JsonElement element = event.getAsJsonObject().get("type");
                        if (element.isJsonPrimitive()) {
                            type = element.getAsString();
                        }
                    }

                    if (event.getAsJsonObject().has("subType")) {
                        JsonElement element = event.getAsJsonObject().get("subType");
                        if (element.isJsonPrimitive()) {
                            subType = element.getAsString();
                        }
                    }
                }
            }
        } catch (JsonSyntaxException e) {
            log.error("Parse json failed, content={}", json, e);
        }

        return buildKey(type, subType);
    }

    private static String buildKey(String type, String subType) {
        return type + ":" + subType;
    }

    private EventManager() {
    }

}
