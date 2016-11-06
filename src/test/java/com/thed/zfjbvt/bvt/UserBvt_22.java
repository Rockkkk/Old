package com.thed.zfjbvt.bvt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class UserBvt_22 extends BaseTest  {
	//private String JIRA_USER_USERNAME, JIRA_USER_PASSWORD;
	
	public UserBvt_22() {
		logger = Logger.getLogger(this.getClass());	
	}
	
	@Test(enabled = testEnabled, priority=69)
	public void testBvt69() {
		altID=69;
		CommonUtil.alertMsg("executing bvt69...");
		logger.info("executing bvt69...");
		isSuccess=zfjNavigator.verifyZfjTestMenus();
		Assert.assertTrue(isSuccess, "ZFJ test menus validation failed");
		logger.info("Bvt69 executed successfully...");
		
	}
	@Test(enabled = testEnabled, priority=70)
	public void testBvt70(){
		altID=70;
		CommonUtil.alertMsg("executing bvt70...");
		logger.info("executing bvt70...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("SUMMARY", "First Test By User"); // summary of the new Test.
		values.put("PRIORITY", "Major"); // priority of new Test.
		values.put("COMPONENT", "Component3"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 3.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 1.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "label1"); //label of new Test.
		
		isSuccess=zfjNavigator.createTest(values);
		Assert.assertTrue(isSuccess, "New Test Creation Failed...");
		logger.info("Bvt70 executed successfully...");
		
	}

	@Test(enabled = testEnabled, priority=71)
	public void testBvt71(){
		altID=71;
		CommonUtil.alertMsg("executing bvt71...");
		logger.info("executing bvt71");
		isSuccess=zfjNavigator.searchTestById();
		Assert.assertTrue(isSuccess,"Search for Test Failed... ");
		logger.info("Bvt71 executed successfully...");
	
	}

	@Test(enabled = testEnabled, priority=72)
	public void testBvt72(){
		altID=72;
		CommonUtil.alertMsg("executing bvt72...");
		logger.info("executing bvt72...");
		Map<String, String> values = new HashMap<String, String>();
		
		//edit the test details to.
		values.put("CHANGE_SUMMARY_TO","Test by admin(Edited)");
		values.put("CHANGE_PRIORITY_TO", "Major");
		values.put("CHANGE_COMPONENT_TO", "Component3"); // component of new Test.
		values.put("CHANGE_AFFECTED_VERSION_TO", "Version 1.0"); // affected version of new Test.
		values.put("CHANGE_FIX_VERSION_TO", "Version 1.0"); // fix version of new Test.
		values.put("CHANGE_ENVIRONMENT_TO", "kitkat"); //environment of new Test.
		values.put("CHANGE_DESCRIPTION_TO", "check the icon moved"); //description of new Test.
		values.put("CHANGE_LABEL_TO", "Label3"); //label of new Test.
		
		isSuccess=zfjNavigator.editTestDetails(values);
		Assert.assertTrue(isSuccess, "Editing Test Failed...");
	
		logger.info("Bvt72 executed successfully...");
	}

	@Test(enabled = testEnabled, priority=73)
	public void testBvt73() {
		altID=73;
		CommonUtil.alertMsg("executing bvt73...");
		logger.info("executing bvt73...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Unscheduled");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Ad hoc");	//	Here cycle is used for selecting a cycle in zfj.
		//values.put("TEST_NAME",  testKeySet.get("Sixth test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "BLOCKED");	// Test status which is used to set the status while executing a test.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.executeTestInAdhoc(values);
		Assert.assertTrue(isSuccess, "Executing Test in Adhoc is not executed successfully.");
		logger.info("Bvt73 is executed successfully.");
		
	}

	@Test(enabled = testEnabled, priority=74)
	public void testBvt74() {
		altID=74;
		CommonUtil.alertMsg("executing bvt74...");
		logger.info("executing bvt74...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "User Cycle");	//	Here cycle is used for selecting a cycle in zfj.
		//values.put("TEST_NAME", testStepKeySet.get("Fifth Test with Test step"));
		values.put("STEP_EXEC_STATUS", "FAIL");	// Step status for execution which is used to set the status while executing a test.
		values.put("TEST_STEP_NUM", "1"); // Test step to execute.
		values.put("ISSUE_SUMMARY", "This is a issue.");	// This is the issue summary which is used for creating an issue.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test step");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeStepWithDefect(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt74 is executed successfully.");
		
	}
	
	@Test(enabled = testEnabled, priority=75)
	public void testBvt75() {
		altID=75;
		CommonUtil.alertMsg("executing bvt75...");
		logger.info("executing bvt75...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "User Cycle");	//	Here cycle is used for selecting a cycle in zfj.
		//values.put("TEST_NAME", testKeySet.get("Seventh test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "FAIL");	// Test status which is used to set the status while executing a test.
		values.put("ISSUE_SUMMARY", "This is a issue.");	// This is the issue summary which is used for creating an issue.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestWithDefectAndAttachment(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt75 is executed successfully.");
		
	}
	@Test(enabled = testEnabled, priority=76)
	public void testBvt76() {
		altID=76;
		CommonUtil.alertMsg("executing bvt76...");
		logger.info("executing bvt76...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle Five");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		
		List<String> tests = zfjNavigator.getTests(5);
		values.put("TEST_ONE", tests.get(0));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_TWO", tests.get(1));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_THREE", tests.get(2));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_FOUR", tests.get(3));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_FIVE", tests.get(4));	// Here Test is used to add and execute in the cycle.
		
		values.put("TEST_ONE_EXEC_STATUS", "PASSED");	// Test status which is used to set the status while executing a test.
		values.put("TEST_TWO_EXEC_STATUS", "FAIL");	// Test status which is used to set the status while executing a test.
		values.put("TEST_THREE_EXEC_STATUS", "WIP");	// Test status which is used to set the status while executing a test.
		values.put("TEST_FOUR_EXEC_STATUS", "BLOCKED");
		values.put("TEST_FIVE_EXEC_STATUS", "CANCEL");	// Test status which is used to set the status while executing a test.
		
		/*isSuccess=zfjNavigator.createTestCycle(values);
		Assert.assertTrue(isSuccess,"Creating cycle is not successfully.");*/
		//isSuccess=zfjNavigator.addTestsMultipleAndExecute(values);
		isSuccess=zfjNavigator.executeMultipleTests(values);
		Assert.assertTrue(isSuccess,"Adding tests multiple into cycle is not executed successfully.");
		
		logger.info("Bvt76 is executed successfully.");
		
	}
	
	@Test(enabled = testEnabled, priority=77)
	public void testBvt77() {
		altID=77;
		CommonUtil.alertMsg("executing bvt77...");
		logger.info("executing bvt77...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "User Cycle");	//	Here cycle is used for selecting a cycle in zfj.
		//values.put("TEST_NAME", testKeySet.get("Eighth test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "BLOCKED");	// Test status which is used to set the status while executing a test.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestDirectlyInViewIssue(values);
		Assert.assertTrue(isSuccess, "Executing test directly is not executed successfully.");
		logger.info("Bvt77 is executed successfully.");
		
	}

	@Test(enabled = testEnabled, priority=78)
	public void testBvt78() {
		altID=78;
		CommonUtil.alertMsg("executing bvt78...");
		logger.info("executing bvt78...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "User Cycle");	//	Here cycle is used for selecting a cycle in zfj.
		//values.put("TEST_NAME", testKeySet.get("Nineth test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "WIP");	// Test status which is used to set the status while executing a test.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestDirectlyInPlanTest(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt78 is executed successfully.");
		
	}

	@Test(enabled = testEnabled, priority=79)
	public void testBvt79(){
		altID=79;
		CommonUtil.alertMsg("executing bvt79...");
		logger.info("executing bvt79...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("PREDEFINED_FILTER_NAME_ONE", "My Executed Tests");	// Name of the predefined filter one
		values.put("PREDEFINED_FILTER_NAME_TWO", "My Failed Executions");	// Name of the predefined filter two
		values.put("PREDEFINED_FILTER_NAME_THREE", "All Unexecuted Tests");	// Name of the predefined filter three
		values.put("PREDEFINED_FILTER_NAME_FOUR", "All Executed Tests");	// Name of the predefined filter four
		values.put("PREDEFINED_FILTER_NAME_FIVE", "All Failed Executions");	// Name of the predefined filter five
		
		isSuccess=zfjNavigator.executePredefinedFilters(values);
		Assert.assertTrue(isSuccess, "Execution of predefined filters failed.");
		logger.info("Bvt79 executed successfully...");
	}
	@Test(enabled = testEnabled, priority=80)
	public void testBvt80(){
		altID=80;
		CommonUtil.alertMsg("executing bvt80...");
		logger.info("executing bvt80...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("COMPONENT_NAME", "Component2");
		values.put("ZQLQUERY", "executionStatus != \"UNEXECUTED\" AND component=\"Component2\"");	// ZQL Query for component
		
		isSuccess=zfjNavigator.executeZQLQueryForComponent(values);
		Assert.assertTrue(isSuccess, "Execution of zql query for Component failed.");
		logger.info("Bvt80 executed successfully...");
	}
	@Test(enabled=testEnabled, priority=81)
	public void testBvt81(){
		altID=81;
		CommonUtil.alertMsg("executing bvt81...");
		logger.info("executing bvt81...");
		isSuccess=zfjNavigator.changeBulkTestsStatusWithTeststeps("wip", "fail", 2);
		logger.info("Bvt81 executed successfully...");
	}

	@Test(enabled=testEnabled, priority=82)
	public void testBvt82(){
		altID=82;
		CommonUtil.alertMsg("executing bvt82...");
		logger.info("executing bvt82...");
		isSuccess=zfjNavigator.bulkMoveTestsToCycle("Version 2.0", "testcycle",2);
		logger.info("Bvt82 executed successfully...");
	}

	@Test(enabled=testEnabled, priority=83)
	public void testBvt83(){
		altID=83;
		CommonUtil.alertMsg("executing bvt83...");
		logger.info("executing bvt83...");
		String bugId = jiraNavigator.createIssue("Defect to Associate in Bulk copy with defect not carried", "Bug");
		isSuccess=zfjNavigator.bulkCopyTestToCycleWithDefectsAndStatusNotCarried("Version 2.0","cycle" ,bugId, 3);
		logger.info("Bvt83 executed successfully...");
	}
	@Test(enabled=testEnabled, priority=84)
	public void testBvt84(){
		altID=84;
		CommonUtil.alertMsg("executing bvt84...");
		logger.info("executing bvt84...");
		String bugId = jiraNavigator.createIssue("Defect to Associate in Bulk ", "Bug");
		isSuccess=zfjNavigator.bulkAssociateDefect(bugId,2);
		logger.info("Bvt84 executed successfully...");
	}


	@Test(enabled = testEnabled, priority=85)
	public void testBvt85(){
		altID=85;
		CommonUtil.alertMsg("executing bvt85...");
		logger.info("executing bvt85...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("ZQLQUERY", "fixVersion = \"Version 1.0\"");	// ZQL Query for execution.
		values.put("EXECUTION_FILTER_NAME", "ExecFilter4");	// Name of the filter.
		
		isSuccess=zfjNavigator.searchExecFilterInManageExecFilter(values);
		Assert.assertTrue(isSuccess, "Search execution filter is not searched successfully in search execution filter page.");
		logger.info("Bvt85 executed successfully...");
	}



	@Test(enabled = testEnabled, priority=86)
	public void testBvt86(){
		altID=86;
		CommonUtil.alertMsg("executing bvt86...");
		logger.info("executing bvt86...");
		isSuccess=zfjNavigator.viewAndDrillDownTestSummary();	
		Assert.assertTrue(isSuccess, "Test Summary validation Failed...");
		logger.info("Bvt86 executed successfully...");
		
	}
	@Test(enabled = testEnabled, priority=87)
	public void testBvt87(){
		altID=87;
		CommonUtil.alertMsg("executing bvt87...");
		logger.info("executing bvt87...");
		isSuccess=zfjNavigator.viewTestSummaryCharts();	
		Assert.assertTrue(isSuccess,"Test Summary Charts validation Failed...");
		logger.info("Bvt87 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=88)
	public void testBvt88(){
		altID=88;
		CommonUtil.alertMsg("executing bvt88...");
		logger.info("executing bvt88...");
		isSuccess=zfjNavigator.launchTestMatricsAndDispalysCreationAndExecutionGadgets();	
		Assert.assertTrue(isSuccess,"Test Creation And Execution Validation Failed");
		logger.info("Bvt88 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=89)
	public void testBvt89(){
		altID=89;
		CommonUtil.alertMsg("executing bvt89...");
		logger.info("executing bvt89...");
		isSuccess=zfjNavigator.viewTestDistributonGadget();
		Assert.assertTrue(isSuccess,"Validating Test Distribution Gadget Failed...");
		isSuccess=zfjNavigator.viewTestExecutionGadget();
		Assert.assertTrue(isSuccess,"Validating Test Execution Gadget Failed...");
		logger.info("Bvt89	 executed successfully...");
			
	}

	@Test(enabled = testEnabled, priority=90)
	public void testBvt90(){
		altID=90;
		CommonUtil.alertMsg("executing bvt90...");
		logger.info("executing bvt90...");
		isSuccess=zfjNavigator.viewTopDefectGadget();	
		Assert.assertTrue(isSuccess,"Validating Top Defects Gadget Failed...");
		logger.info("Bvt90 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=91)
	public void testBvt91(){
		altID=91;
		CommonUtil.alertMsg("executing bvt91...");
		logger.info("executing bvt91...");
		isSuccess=zfjNavigator.viewExecutionBurndownGadget();	
		Assert.assertTrue(isSuccess,"Validating Test Execution Burndown Failed...");
		logger.info("Bvt 91 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=92)
	public void testBvt92(){
		altID=92;
		CommonUtil.alertMsg("executing bvt92...");
		logger.info("executing bvt92...");
		isSuccess=zfjNavigator.viewTestExecutionDetailsGadget();
		Assert.assertTrue(isSuccess,"Validating Test Execution Details Failed...");
		logger.info("Bvt92 execution successfully...");
	}

	@BeforeClass
	public void beforeClass() throws Throwable{
		logger.info("beforeClass invoked");
		Assert.assertTrue(jiraNavigator.doLogin(JIRA_USER_USERNAME, JIRA_USER_PASSWORD), "Login to jira is not successfully.");
		jiraNavigator.checkAndCloseNewFeatureDialog();
		logger.info("logged in to Jira successfully.");
		Assert.assertTrue(jiraNavigator.selectProject(Config.getValue("JIRA_PROJECT")), " Project is not selected successfully.");
		logger.info("Project is selected successfully.");
		
	}
	
	@AfterClass
	public void afterClass(){
		logger.info("afterClass invoked");
		CommonUtil.closeTheDriver();
		logger.info("Driver is closed successfully.");
	}
	
	
	
	@BeforeMethod
	public void beforeMethod(){
		logger.info("beforeMethod invoked");
		if(Driver.driver.getTitle().contains("Log in")){
			Assert.assertTrue(jiraNavigator.doLogin(JIRA_USER_USERNAME, JIRA_USER_PASSWORD), "Login to jira is not successfully.");
			logger.info("logged in to Jira as user successfully.");
		}
		isSuccess = false;
		
	}
	
	@AfterMethod
	public void afterMethod() throws Exception{
		logger.info("afterMethod invoked");
		if(isSuccess==false){
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

