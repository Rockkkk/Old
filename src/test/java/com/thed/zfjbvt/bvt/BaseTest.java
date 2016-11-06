package com.thed.zfjbvt.bvt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.jira.JiraNavigator;
import com.thed.zfjbvt.jira.JiraNavigatorFactory;
import com.thed.zfjbvt.util.BVTUtil;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.CustomHTMLLayout;
import com.thed.zfjbvt.zfj.ZfjNavigator;
import com.thed.zfjbvt.zfj.ZfjNavigatorFactory;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.util.HSSFColor.TEAL;

public class BaseTest {

	/*=========================================================
	 * ATTRIBUTES
	 *=======================================================*/
	
	//====================== STATIC ===========================
	protected static boolean isInit = false ;
	protected static JiraNavigator jiraNavigator = null ;
	protected static ZfjNavigator zfjNavigator = null ;
	protected static String jiraVersion = null ;
	protected static String zfjVersion = null ;
	
	protected int altID;
	protected boolean isSuccess = false ;
	
	protected Logger logger = null ;
	protected static final boolean testEnabled=false;
	protected static String JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD, JIRA_USER_USERNAME, JIRA_USER_PASSWORD, JIRA_URL;
	protected static Map<String, String> testStepKeySet;
	protected static Map<String, String> testKeySet;
	
	protected static Map<String, List<String>> testStepKey;
	protected static Map<String, List<String>> testKey;
	protected static List<String> listOfExecTest = new ArrayList<String>();
	/*=========================================================
	 * CONSTRUCTOR AND INIT
	 *=======================================================*/
	
	public BaseTest() {
		init();
		
	}

	public static void init() {
		if (isInit) {
			return ;
		}
		Config config = new Config();	// initialization
		jiraVersion = Config.getValue("JIRA_VERSION");
		zfjVersion = Config.getValue("ZFJ_VERSION");
		
		JiraNavigatorFactory.init(jiraVersion);
		jiraNavigator = JiraNavigatorFactory.getInstance();
		ZfjNavigatorFactory.init(zfjVersion);
		zfjNavigator = ZfjNavigatorFactory.getInstance();
		isInit = true ;
	}
	
	/*=========================================================
	 * TEST LIFECYCLE METHODS
	 *=======================================================*/
	
	/*=========================================================
	 * COMMON METHODS
	 *=======================================================*/
	
	public  void captureScreenshotInLog() {
		CommonUtil.captureScreenshot(Config.getScreenPath());
		String imgPath = CommonUtil.captureScreenshot(Config.getScreenPath());
		logger.info(CustomHTMLLayout.IMAGE_PREFIX + "src=\"../" + imgPath + "\"/>");
	}
	
	protected void updateStatusInExcel(){
		String status = "f";
		if(isSuccess){
			status="p";
		}
		BVTUtil.writeStatus(Config.getFilePath("","BVT_ZFJ.xls"), altID, status);
	}
	@BeforeSuite
	public void beforeSuite(){
		
		BVTUtil.setBuildNumber(Config.getFilePath("","BVT_ZFJ.xls"), Config.getValue("BUILD_NO"));
		testKeySet=new HashMap<String, String>();
		testStepKeySet=new HashMap<String, String>();
		JIRA_ADMIN_USERNAME=Config.getValue("JIRA_ADMIN_USERNAME");
		JIRA_ADMIN_PASSWORD=Config.getValue("JIRA_ADMIN_PASSWORD");
		JIRA_USER_USERNAME=Config.getValue("JIRA_USER_USERNAME");
		JIRA_USER_PASSWORD=Config.getValue("JIRA_USER_PASSWORD");
		//System.out.println(JIRA_ADMIN_USERNAME +" : "+JIRA_ADMIN_PASSWORD);
		JIRA_URL=Config.getValue("JIRA_URL");
		CommonUtil.launchBrowser(JIRA_URL);
		logger.info("Initialization of all data Successfully.");
		logger.info("Browser Launched Successfully...");
	}
	@AfterSuite
	public void afterSuite(){
		logger.info("After suite is running.");
		CommonUtil.closeTheDriver();
		logger.info("Driver is closed.");
	}
	
}
