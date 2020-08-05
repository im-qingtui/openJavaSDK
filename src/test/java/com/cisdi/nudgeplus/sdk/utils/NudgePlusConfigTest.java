package com.cisdi.nudgeplus.sdk.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author zk
 */
public class NudgePlusConfigTest {

    @Test
    public void getAppId() {
        String value = "4856684061";
        Assert.assertEquals(value, NudgePlusConfig.getAppId());
    }

    @Test
    public void getAppSecret() {
        String value = "ef7b418836774939949ad6cd03b456ec";
        Assert.assertEquals(value, NudgePlusConfig.getAppSecret());
    }

    @Test
    public void getEndpoint() {
        String value = "https://devqtopen.qingtui.com";
        Assert.assertEquals(value, NudgePlusConfig.getEndpoint());
    }

    @Test
    public void setAppId() {
        String value = "4856684061";
        Assert.assertEquals(value, NudgePlusConfig.getAppId());

        value = "new_app_Id";

        NudgePlusConfig.setAppId(value);
        Assert.assertEquals(value, NudgePlusConfig.getAppId());
    }

    @Test
    public void setAppSecret() {
        String value = "https://devqtopen.qingtui.com";
        Assert.assertEquals(value, NudgePlusConfig.getAppSecret());

        value = "new_app_secret";

        NudgePlusConfig.setAppSecret(value);
        Assert.assertEquals(value, NudgePlusConfig.getAppSecret());
    }

    @Test
    public void setEndpoint() {
        String value = "https://devqtopen.qingtui.com";
        Assert.assertEquals(value, NudgePlusConfig.getEndpoint());

        value = "new_endpoint";

        NudgePlusConfig.setEndpoint(value);
        Assert.assertEquals(value, NudgePlusConfig.getEndpoint());
    }

    @Test
    public void getProperty() {
        String value = "4856684061";
        Assert.assertEquals(value, NudgePlusConfig.getProperty("APP_ID"));
    }

    @Test
    public void setProperty() {
        String value = "4856684061";
        NudgePlusConfig.setProperty("CUSTOM_PROPERTY", value);
        Assert.assertEquals(value, NudgePlusConfig.getProperty("CUSTOM_PROPERTY"));
    }
}