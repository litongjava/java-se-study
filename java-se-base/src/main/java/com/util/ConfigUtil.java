package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author litong
 * @date 2018年6月5日_下午2:07:49 
 * @version 1.0 
 */
public class ConfigUtil {
	private static Properties prop = null;
	// ============== properties statrt=====================================
	private static String configFile = "config.properties";
	// ==============properties end=========================================

	static {
		InputStream ins = ConfigUtil.class.getClassLoader().getResourceAsStream(configFile);
		InputStreamReader insReader = new InputStreamReader(ins);
		prop = new Properties();
		try {
			prop.load(insReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		return prop.getProperty(key);
	}

}
