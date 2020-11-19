package im.qingtui.open.callback.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * app utils class
 *
 * @author hanxin
 */
public final class GsonFactory {

    private static Gson snakeCaseGson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();

    private static Gson camelCaseGson = new GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        .create();

    public static Gson snakeCase() {
        return snakeCaseGson;
    }

    public static Gson camelCase() {
        return camelCaseGson;
    }

    private GsonFactory() {
    }

}