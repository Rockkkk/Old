package com.thed.zfjbvt.bvt;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class UserBvt_173 extends BaseTest  {
	
	
	public UserBvt_173() {
		logger = Logger.getLogger(this.getClass());	
	}


	@Test(enabled=testEnabled, priority=41)
	public void testBvt41() {
		altID=41;
		logger.info("executing bvt41...");
		isSuccess=zfjNavigator.verifyZfjTestMenus();
		Assert.assertTrue(isSuccess, "ZFJ test menus validation failed");
		logger.info("Bvt41 executed successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=42)
	public void testBvt42(){
		altID=42;
		logger.info("executing bvt42...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("PRIORITY", "Critical"); // priority of new Test.
		values.put("COMPONENT", "Component1"); // component of new Test.
		values.put("AFFECTEDVERSION", "Version 2.0"); // affected version of new Test.
		values.put("FIXVERSION", "Version 1.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "label1"); //label of new Test.
		
		isSuccess=zfjNavigator.createTest(values);
		Assert.assertTrue(isSuccess, "New Test Creation Failed...");
		logger.info("Bvt42 executed successfully...");
		
	}


@Test(enabled=testEnabled, priority=43)
public void testBvt43(){
	altID=43;
	logger.info("executing bvt43");
	isSuccess=zfjNavigator.searchTestByKeyword();
	Assert.assertTrue(isSuccess,"Search for Test Failed... ");
	logger.info("Bvt43 executed successfully...");
	
}
@Test(enabled=testEnabled, priority=44)
public void testBvt44(){
	altID=44;
	logger.info("executing bvt13...");
	Map<String, String> values = new HashMap<String, String>();
	values.put("SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
	values.put("PRIORITY", "Critical"); // priority of new Test.
	values.put("COMPONENT", "Component1"); // component of new Test.
	values.put("AFFECTED_VERSION", "Version 1.0"); // affected version of new Test.
	values.put("FIX_VERSION", "Version 1.0"); // fix version of new Test.
	values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
	values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
	values.put("LABEL", "Label2"); //label of new Test.
	
	//edit the test details to.
	values.put("CHANGE_SUMMARY_TO","Drag and drop an icon from menu to main screen verify wether that icon is displayed properly");
	values.put("CHANGE_PRIORITY_TO", "Blocker");
	values.put("CHANGE_COMPONENT_TO", "Component2"); // component of new Test.
	values.put("CHANGE_AFFECTED_VERSION_TO", "Version 2.0"); // affected version of new Test.
	values.put("CHANGE_FIX_VERSION_TO", "Version 2.0"); // fix version of new Test.
	values.put("CHANGE_ENVIRONMENT_TO", "kitkat"); //environment of new Test.
	values.put("CHANGE_DESCRIPTION_TO", "check the icon moved"); //description of new Test.
	values.put("CHANGE_LABEL_TO", "Label3"); //label of new Test.
	
	isSuccess=zfjNavigator.editTestDetails(values);
	Assert.assertTrue(isSuccess, "Editing Test Failed...");
	logger.info("Bvt44 executed successfully...");
	
	
}

	@Test(enabled=testEnabled, priority=45)
	public void testBvt45() {
		altID=45;
		logger.info("executing bvt45...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Unscheduled");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Ad hoc");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZAPI-5");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "WIP");	// Test status which is used to set the status while executing a test.
		
		isSuccess=zfjNavigator.executeTestInAdhoc(values);
		Assert.assertTrue(isSuccess, "Executing Test in Adhoc is not executed successfully.");
		logger.info("Bvt45 is executed successfully.");
		
	}

	@Test(enabled=testEnabled, priority=46)
	public void testBvt46() {
		altID=46;
		logger.info("executing bvt46...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZAPI-7");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "FAIL");	// Test status which is used to set the status while executing a test.
		values.put("ISSUE_SUMMARY", "This is a issue.");	// This is the issue summary which is used for creating an issue.
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestWithDefectAndAttachment(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt46 is executed successfully.");
		
	}
	@Test(enabled=testEnabled, priority=47)
	public void testBvt47() {
		altID=47;
		logger.info("executing bvt47...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZAPI-13");	// Here Test is used to add and execute in the cycle.
		values.put("STEP_EXEC_STATUS", "FAIL");	// Step status for execution which is used to set the status while executing a test.
		values.put("TEST_STEP_NUM", "3"); // Test step to execute.
		values.put("ISSUE_SUMMARY", "This is a issue.");	// This is the issue summary which is used for creating an issue.
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeStepWithDefect(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt47 is executed successfully.");
		
	}
	
	@Test(enabled=testEnabled, priority=48)
	public void testBvt48() {
		altID=48;
		logger.info("executing bvt48...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle Five");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		
		values.put("TEST_ONE", "ZAPI-1");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_TWO", "ZAPI-2");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_THREE", "ZAPI-3");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_FOUR", "ZAPI-4");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_FIVE", "ZAPI-5");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_ONE_EXEC_STATUS", "PASSED");	// Test status which is used to set the status while executing a test.
		values.put("TEST_TWO_EXEC_STATUS", "FAIL");	// Test status which is used to set the status while executing a test.
		values.put("TEST_THREE_EXEC_STATUS", "WIP");	// Test status which is used to set the status while executing a test.
		values.put("TEST_FOUR_EXEC_STATUS", "BLOCKER");	// Test status which is used to set the status while executing a test.
		
		isSuccess=zfjNavigator.createTestCycle(values);
		Assert.assertTrue(isSuccess,"Creating cycle is not successfully.");
		isSuccess=zfjNavigator.addTestsMultipleAndExecute(values);
		Assert.assertTrue(isSuccess,"Adding tests multiple into cycle is not executed successfully.");
		
		logger.info("Bvt26 is executed successfully.");
		
	}
	
	@Test(enabled=testEnabled, priority=49)
	public void testBvt49() {
		altID=49;
		logger.info("executing bvt49...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZAPI-8");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "BLOCKER");	// Test status which is used to set the status while executing a test.
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestDirectlyInViewIssue(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt49 is executed successfully.");
		
	}

	@Test(enabled=true, priority=50)
	public void testBvt50() {
		altID=50;
		logger.info("executing bvt50...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZAPI-9");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "WIP");	// Test status which is used to set the status while executing a test.
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestDirectlyInPlanTest(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt50 is executed successfully.");
		
	}
		
	
	@Test(enabled=testEnabled, priority=51)
	public void testBvt51(){
		altID=51;
		logger.info("executing bvt51...");
		isSuccess=zfjNavigator.viewAndDrillDownTestSummary();	
		Assert.assertTrue(isSuccess, "Test Summary validation Failed...");
		logger.info("Bvt 51 executed successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=52)
	public void testBvt52(){
		altID=52;
		logger.info("executing bvt52...");
		isSuccess=zfjNavigator.viewTestSummaryCharts();	
		Assert.assertTrue(isSuccess,"Test Summary Charts validation Failed...");
		logger.info("Bvt 52 executed successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=53)
	public void testBvt53(){
		altID=53;
		logger.info("executing bvt53...");
		isSuccess=zfjNavigator.launchTestMatricsAndDispalysCreationAndExecutionGadgets();	
		Assert.assertTrue(isSuccess,"Test Creation And Execution Validation Failed");
		logger.info("Bvt 53 executed successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=54)
	public void testBvt54(){
		altID=54;
		logger.info("executing bvt54...");
		isSuccess=zfjNavigator.viewTestDistributonGadget();
		Assert.assertTrue(isSuccess,"Validating Test Distribution Gadget Failed...");
		isSuccess=zfjNavigator.viewTestExecutionGadget();
		Assert.assertTrue(isSuccess,"Validating Test Execution Gadget Failed...");
		logger.info("Bvt 54 executed successfully...");
			
		
	}
	

	@Test(enabled=testEnabled, priority=55)

	public void testBvt55(){
		altID=55;
		logger.info("executing bvt55...");
		isSuccess=zfjNavigator.viewTopDefectGadget();	
		Assert.assertTrue(isSuccess,"Validating Top Defects Gadget Failed...");
		logger.info("Bvt 55 executed successfully...");
		
	}
	

	@Test(enabled=testEnabled, priority=56)
	public void testBvt56(){
		altID=56;
		logger.info("executing bvt56...");
		isSuccess=zfjNavigator.viewExecutionBurndownGadget();	
		Assert.assertTrue(isSuccess,"Validating Test Execution Burndown Failed...");
		logger.info("Bvt 56 executed successfully...");
		
	}
	@BeforeClass
	public void beforeClass() throws Throwable{
		logger.info("beforeClass invoked");
		//JIRA_ADMIN_USERNAME=Config.getValue("JIRA_ADMIN_USERNAME");
		//JIRA_ADMIN_PASSWORD=Config.getValue("JIRA_ADMIN_PASSWORD");
		Assert.assertTrue(jiraNavigator.doLogin(JIRA_USER_USERNAME, JIRA_USER_PASSWORD), "Login to jira is not successfully...");
		logger.info("Logged Into Jira Successfully...");
		
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
			Assert.assertTrue(jiraNavigator.doLogout(),"Logout from jira is not successfully.");
			logger.info("logged out from Jira successfully...");
			
		}
		updateStatusInExcel();
		logger.info("Excel sheet is updated successfully.");
	}	
	

}

