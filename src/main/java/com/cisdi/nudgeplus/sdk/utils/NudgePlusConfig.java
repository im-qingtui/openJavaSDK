package com.cisdi.nudgeplus.sdk.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class NudgePlusConfig {
	public NudgePlusConfig() {}

	private static Properties props = new Properties();
	static {
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("qingtui.properties"));
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		//兼容老版本单词拼写错误
		if("APP_SERCRET".equals(key))
			key = "APP_SECRET";
		return props.getProperty(key);
	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}
}
