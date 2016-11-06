package com.thed.zfjbvt;

import java.io.File;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;

import com.thed.zfjbvt.util.CommonUtil;

public class Config {
	//String path;

	private static boolean isInit = false ;
	private static String path = null ;
	private static Properties prop = null ;
	private static String logPath = null ;
	
	public Config() {
		if (isInit) {
			return ;
		}
		init();
	}
	
	private void init() {
		Config.path = "/config.properties" ;
		prop = CommonUtil.loadProperties(Config.path);
		if (prop == null) {
			throw new RuntimeException("Unable to load properties file: " + Config.path);
		}
		initLog4j();
		logPath = "logs" + File.separator;
		
		isInit = true ;
	}
	
	/* Log4j appender is located at a different dir, so using programmatically initialization */
	private static void initLog4j() {
		try {
			Properties properties = new Properties();
			File file = CommonUtil.getPropertyFilePath("/log4j.xml");
			DOMConfigurator.configure(file.getAbsolutePath());
		} catch (Exception e) {
			RuntimeException fe = new RuntimeException("Couldn't initialize log4j.", e);
			throw fe ;
		}		
	}
	
	public static String getValue(String key) {
		return prop.getProperty(key);
	}
	
	public static String getScreenPath() {
		return logPath + "screenshot" + File.separator + System.currentTimeMillis() + ".png";
	}
	
	
	public static String getFilePath(String module, String filePath) {
		return prop.get(Constants.CONFIG_PATH) + File.separator + module + File.separator + filePath;
	}
	
}
