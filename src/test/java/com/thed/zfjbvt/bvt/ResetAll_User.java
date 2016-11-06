package com.thed.zfjbvt.bvt;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class ResetAll_User extends BaseTest {
		
	public ResetAll_User() {
		logger = Logger.getLogger(this.getClass());
	}
	
	@Test(enabled = testEnabled, priority=1)
	public void resetFilters() {
		altID=1;
		CommonUtil.alertMsg("Reset Filters...");
		logger.info("Reset Filters started...");
			
		isSuccess=zfjNavigator.resetFilters();
		Assert.assertTrue(isSuccess,"Reseting Filters not successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("Filters are Reseted successfully.");	
	}
	
	

	@BeforeClass
	public void beforeClass() throws Throwable{
		logger.info("beforeClass invoked");
		Assert.assertTrue(jiraNavigator.doLogin(JIRA_USER_USERNAME, JIRA_USER_PASSWORD), "Login to jira is not successfully...");
		jiraNavigator.checkAndCloseNewFeatureDialog();
		logger.info("Logged Into Jira Successfully...");
		Assert.assertTrue(jiraNavigator.selectProject(Config.getValue("JIRA_PROJECT")), " Project is not selected successfully.");
		logger.info("Project is selected successfully.");
		
	}
	
	@AfterClass
	public void afterClass(){
		logger.info("afterClass invoked");
		logger.info("logout from Jira successfully.");
		Assert.assertTrue(jiraNavigator.doLogout(),"Logout from jira is not successfully.");
		
	}

	@BeforeMethod
	public void beforeMethod(){
		logger.info("beforeMethod invoked");
		if(Driver.driver == null){
			Driver.driver=Driver.browserFactory();
		}
		if(Driver.driver.getTitle().contains("Log in")){
			Assert.assertTrue(jiraNavigator.doLogin(JIRA_USER_USERNAME, JIRA_USER_PASSWORD), "Login to jira is not successfully.");
			logger.info("logged in to Jira as user successfully.");
		}
		isSuccess = false;
		
	}
	
	@AfterMethod
	public void afterMethod() throws Exception{
		logger.info("afterMethod invoked");
		if(isSuccess == false){
			captureScreenshotInLog();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).build().perform();
			Assert.assertTrue(jiraNavigator.doLogout(),"Logout from jira is not successfully.");
			logger.info("logged out from Jira successfully...");
			
		}
		updateStatusInExcel();
		logger.info("Excel sheet is updated successfully.");
	}

}