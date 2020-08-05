package com.cisdi.nudgeplus.sdk.utils;

import java.io.IOException;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class NudgePlusConfig {

    private static final String APP_ID = "APP_ID";

    private static final String APP_SECRET = "APP_SECRET";

    private static final String ENDPOINT = "ENDPOINT";

    private static Properties props = new Properties();

    static {
        init();
    }

    public static String getAppId() {
        return props.getProperty(APP_ID);
    }

    public static String getAppSecret() {
        return props.getProperty(APP_SECRET);
    }

    public static String getEndpoint() {
        return props.getProperty(ENDPOINT);
    }

    public static void setAppId(String appId) {
        setProperty(APP_ID, appId);
    }

    public static void setAppSecret(String appSecret) {
        setProperty(APP_SECRET, appSecret);
    }

    public static void setEndpoint(String endpoint) {
        setProperty(ENDPOINT, endpoint);
    }

    public static String getProperty(String key) {
        return props.getProperty(key, "");
    }

    public static void setProperty(String key, String value) {
        props.setProperty(key, value);
    }

    private static synchronized void init() {
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("qingtui.properties"));
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        }
    }

    private NudgePlusConfig() {
    }
}
