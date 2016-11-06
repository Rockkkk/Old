package com.thed.zfjbvt.zfj;


import com.thed.zfjbvt.zfj.impl.ZfjNavigator173Impl;
import com.thed.zfjbvt.zfj.impl.ZfjNavigator21Impl;
import com.thed.zfjbvt.zfj.impl.ZfjNavigator22Impl;
import com.thed.zfjbvt.zfj.impl.ZfjNavigator25Impl;

public class ZfjNavigatorFactory {

	private static String SUPPORTED_VERSIONS = "1.7.3,2.1,2.2, 2.5";
	
	public static ZfjNavigator getInstance() {
		return instance ;
	}
	private static ZfjNavigator instance ;
	
	public static void init(String version) {
		if (version.equalsIgnoreCase("1.7.3")) {
			instance = new ZfjNavigator173Impl();
		}
		else if(version.equalsIgnoreCase("2.1")){
			instance = new ZfjNavigator21Impl();
		}
		else if(version.equalsIgnoreCase("2.2")){
			instance = new ZfjNavigator22Impl();
		}
		else if(version.equalsIgnoreCase("2.5")){
			instance = new ZfjNavigator25Impl();
		}
		else{
			throw new RuntimeException("Zephyr For JIRA versions " + SUPPORTED_VERSIONS + " are supported. "
					+ "Version " + version + " is not supported");
		}
	}
	
	
}
