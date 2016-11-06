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

public class ResetAll_Admin extends BaseTest {
		
	public ResetAll_Admin() {
		logger = Logger.getLogger(this.getClass());
	}
	
	@Test(enabled = testEnabled, priority=2)
	public void resetFilters() {
		altID=2;
		CommonUtil.alertMsg("Reseting Filters...");
		logger.info("Reseting Filters started...");
		
		isSuccess=zfjNavigator.resetFilters();
		Assert.assertTrue(isSuccess,"Reseting Filters not successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("Filters are Reseted successfully.");	
	}
	
	@Test(enabled = testEnabled, priority=3)
	public void resetTestStatus() {
		altID=3;
		CommonUtil.alertMsg("Reseting test status...");
		logger.info("Reseting test status started...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("TEST_EXEC_STATUS", "PASSED"); // Main test execution status which is used to finding the status.
		values.put("NEW_TEST_EXEC_STATUS", "PASS"); // used for updating the test status.
		values.put("NEW_TEST_EXEC_STATUS_DESC", "Test was executed and passed successfully."); // Used for updating test status description.
		
		
		isSuccess = jiraNavigator.navigateToAdminCustomizeTestStatusPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD );
		Assert.assertTrue(isSuccess,"Not Navigated Successfully to Customize Test Status page.");
		
		isSuccess=zfjNavigator.updateTestExecutionStatus(values);
		Assert.assertTrue(isSuccess,"Test status is not updated successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("Test status is now reset.");
		
		
	}
	
	@Test(enabled = testEnabled, priority=4)
	public void deleteTestStatus() {
		altID=4;
		CommonUtil.alertMsg("Deleting test status...");
		logger.info("Deleting test status started...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("TEST_EXEC_STATUS", "CANCEL"); // New test status for adding into step status.
		values.put("NEW_TEST_EXEC_STATUS_DESC", "It will cancel the test."); // New test status description for adding into the step status.
		values.put("NEW_TEST_EXEC_STATUS_COLORCODE", "#ff33ff"); // New color code for adding into the test status.
		
		isSuccess = jiraNavigator.navigateToAdminCustomizeTestStatusPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD );
		Assert.assertTrue(isSuccess,"Not Navigated Successfully to Customize Test Status page.");
		
		isSuccess=zfjNavigator.deleteTestExecutionStatus("CANCEL");
		Assert.assertTrue(isSuccess,"Test status is not deleted successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("New Test status is deleted successfully.");
		
	}
	@Test(enabled = testEnabled, priority=5)
	public void resetStepStatus() {
		altID=5;
		CommonUtil.alertMsg("Reseting step status...");
		logger.info("Reseting step status started...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("STEP_EXEC_STATUS", "PASSED"); // Old Step status for editing and updating.
		values.put("NEW_STEP_EXEC_STATUS", "PASS"); // New step status used for updating into old status.
		values.put("NEW_STEP_EXEC_STATUS_DESC", "Test step was executed and passed successfully."); // New step status description for adding into the new step status.
		
		isSuccess = jiraNavigator.navigateToAdminCustomizeStepStatusPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD );
		Assert.assertTrue(isSuccess,"Not Navigated Successfully to Customize Step Status page.");
		
		isSuccess=zfjNavigator.updateStepExecutionStatus(values);
		Assert.assertTrue(isSuccess,"Step status is not updated successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("Step status is now reset.");
		
	}
	@Test(enabled = testEnabled, priority=6)
	public void deleteStepStatus() {
		altID=6;
		CommonUtil.alertMsg("Deleting Step status...");
		logger.info("Deleting Step status started...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("NEW_STEP_EXEC_STATUS", "CANCEL"); // New step status for adding into the step statuses.
		values.put("NEW_STEP_EXEC_STATUS_DESC", "This is cancelled status."); // New Step description for adding into the step status.
		values.put("NEW_STEP_EXEC_STATUS_COLORCODE", "#ff33ff"); // New step status color code for adding into the step status.
		
		isSuccess = jiraNavigator.navigateToAdminCustomizeStepStatusPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD );
		Assert.assertTrue(isSuccess,"Not Navigated Successfully to Customize Step Status page.");
		
		isSuccess=zfjNavigator.deleteStepExecutionStatus("CANCEL");
		Assert.assertTrue(isSuccess,"New Step status is not added successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("Step Status is Deleted successfully.");
		
	}
	
	@Test(enabled = testEnabled, priority=7)
	public void deleteProject() {
		altID=7;
		CommonUtil.alertMsg("Deleting Project...");
		logger.info("Delete Project execution started...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("JIRA_PROJECT", Config.getValue("JIRA_PROJECT"));
		values.put("ADMIN_AUTHENTICATE_USERNAME", JIRA_ADMIN_USERNAME);	// Used for authenticate administration username.
		values.put("ADMIN_AUTHENTICATE_PASSWORD", JIRA_ADMIN_PASSWORD);	//Used for authenticate Administrative password.
				
		isSuccess = jiraNavigator.deleteProject(values);
		Assert.assertTrue(isSuccess,"zfj plugin is not deleted successfully.");
		
		logger.info("Project is not Deleted Successfully.");
		
	}
	@Test(enabled = true, priority=8)
	public void createProject() {
		altID=8;
		CommonUtil.alertMsg("Creating Project...");
		logger.info("Creating Project execution started...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("JIRA_PROJECT", Config.getValue("JIRA_PROJECT"));
		values.put("ADMIN_AUTHENTICATE_USERNAME", JIRA_ADMIN_USERNAME);	// Used for authenticate administration username.
		values.put("ADMIN_AUTHENTICATE_PASSWORD", JIRA_ADMIN_PASSWORD);	//Used for authenticate Administrative password.
				
		isSuccess = jiraNavigator.runJellyScript(values);
		Assert.assertTrue(isSuccess,"Jelly Script is not executed successfully.");
		
		logger.info("Project is created successfully using Jelly Script.");
		
	}
	@Test(enabled = true, priority=9)
	public void resetGadget() {
		altID=9;
		CommonUtil.alertMsg("Reseting Gadgets...");
		logger.info("Reseting Gadgets execution started...");
		
		isSuccess = zfjNavigator.resetGadget();
		Assert.assertTrue(isSuccess,"zfj gadgets are not reset.");
		
		logger.info("ZFJ gadgets are reseted successfully.");
	}
	@Test(enabled = true, priority=10)
	public void unInstallPlugin() {
		altID=10;
		CommonUtil.alertMsg("Uninstalling Plug-in...");
		logger.info("Uninstalling Plug-in started...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("JIRA_PROJECT", Config.getValue("JIRA_PROJECT"));
		values.put("ADMIN_AUTHENTICATE_USERNAME", JIRA_ADMIN_USERNAME);	// Used for authenticate administration username.
		values.put("ADMIN_AUTHENTICATE_PASSWORD", JIRA_ADMIN_PASSWORD);	//Used for authenticate Administrative password.
				
		isSuccess=jiraNavigator.uninstallPlugin(values);
		Assert.assertTrue(isSuccess,"zfj plugin is not installed successfully.");
		
		logger.info("ZFJ Plug-in is uninstalled successfully.");
	}
	
	

	@BeforeClass
	public void beforeClass() throws Throwable{
		logger.info("beforeClass invoked");
		Assert.assertTrue(jiraNavigator.doLogin(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD), "Login to jira is not successfully...");
		jiraNavigator.checkAndCloseNewFeatureDialog();
		logger.info("Logged Into Jira Successfully...");
		//Assert.assertTrue(jiraNavigator.selectProject(Config.getValue("JIRA_PROJECT")), " Project is not selected successfully.");
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
			Assert.assertTrue(jiraNavigator.doLogin(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD), "Login to jira is not successfully.");
			logger.info("logged in to Jira successfully.");
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