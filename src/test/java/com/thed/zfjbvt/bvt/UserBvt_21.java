package com.thed.zfjbvt.bvt;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.jira.impl.jira52.JiraLandingPage;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class UserBvt_21 extends BaseTest  {
	//private String JIRA_USER_USERNAME, JIRA_USER_PASSWORD;
	
	public UserBvt_21() {
		logger = Logger.getLogger(this.getClass());	
	}

	@Test(enabled = false , priority=1)
	public void selectProject(){
		altID=1;
		Assert.assertTrue(JiraLandingPage.getInstance().selectProject("ZFJ"), " Project is not selected successfully.");
		logger.info(" Project is selected successfully.");
		isSuccess=true;
	}
@Test(enabled=testEnabled, priority=58)
public void testBvt58() {
		altID=58;
		logger.info("executing bvt58...");
		isSuccess=zfjNavigator.verifyZfjTestMenus();
		Assert.assertTrue(isSuccess, "ZFJ test menus validation failed");
		logger.info("Bvt58 executed successfully...");
		
	}
@Test(enabled=testEnabled, priority=59)
public void testBvt59(){
		altID=59;
		logger.info("executing bvt59...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("PRIORITY", "Major"); // priority of new Test.
		values.put("COMPONENT", "Component1"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 2.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 1.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "label1"); //label of new Test.
		
		isSuccess=zfjNavigator.createTest(values);
		Assert.assertTrue(isSuccess, "New Test Creation Failed...");
		logger.info("Bvt59 executed successfully...");
		
	}


@Test(enabled=testEnabled, priority=60)
public void testBvt60(){
	altID=60;
	logger.info("executing bvt60");
	isSuccess=zfjNavigator.searchTestByKeyword();
	Assert.assertTrue(isSuccess,"Search for Test Failed... ");
	logger.info("Bvt60 executed successfully...");
	
}

@Test(enabled=testEnabled, priority=61)
public void testBvt61(){
	altID=61;
	logger.info("executing bvt61...");
	Map<String, String> values = new HashMap<String, String>();
	values.put("SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
	values.put("PRIORITY", "Major"); // priority of new Test.
	values.put("COMPONENT", "Component1"); // component of new Test.
	values.put("AFFECTED_VERSION", "Version 1.0"); // affected version of new Test.
	values.put("FIX_VERSION", "Version 1.0"); // fix version of new Test.
	values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
	values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
	values.put("LABEL", "wifi"); //label of new Test.
	
	//edit the test details to.
	values.put("CHANGE_SUMMARY_TO","Drag and drop an icon from menu to main screen verify wether that icon is displayed properly");
	values.put("CHANGE_PRIORITY_TO", "Blocker");
	values.put("CHANGE_COMPONENT_TO", "Component2"); // component of new Test.
	values.put("CHANGE_AFFECTED_VERSION_TO", "Version 2.0"); // affected version of new Test.
	values.put("CHANGE_FIX_VERSION_TO", "Version 2.0"); // fix version of new Test.
	values.put("CHANGE_ENVIRONMENT_TO", "kitkat"); //environment of new Test.
	values.put("CHANGE_DESCRIPTION_TO", "check the icon moved"); //description of new Test.
	values.put("CHANGE_LABEL_TO", "display"); //label of new Test.
	
	isSuccess=zfjNavigator.editTestDetails(values);
	Assert.assertTrue(isSuccess, "Editing Test Failed...");
	logger.info("Bvt61 executed successfully...");
	
	
}

@Test(enabled=testEnabled, priority=62)
public void testBvt62() {
		altID=62;
		logger.info("executing bvt62...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Unscheduled");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Ad hoc");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", testKeySet.get("Sixth test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "BLOCKED");	// Test status which is used to set the status while executing a test.
		
		isSuccess=zfjNavigator.executeTestInAdhoc(values);
		Assert.assertTrue(isSuccess, "Executing Test in Adhoc is not executed successfully.");
		logger.info("Bvt62 is executed successfully.");
		
	}
@Test(enabled=testEnabled, priority=63)
public void testBvt63() {
		altID=63;
		logger.info("executing bvt63...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", testKeySet.get("Seventh test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "FAIL");	// Test status which is used to set the status while executing a test.
		values.put("ISSUE_SUMMARY", "This is a issue.");	// This is the issue summary which is used for creating an issue.
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestWithDefectAndAttachment(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt63 is executed successfully.");
		
	}
@Test(enabled=testEnabled, priority=64)
public void testBvt64() {
		altID=64;
		logger.info("executing bvt64...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", testStepKeySet.get("Fifth Test with Test step"));	// Here Test is used to add and execute in the cycle.
		values.put("STEP_EXEC_STATUS", "FAIL");	// Step status for execution which is used to set the status while executing a test.
		values.put("TEST_STEP_NUM", "5"); // Test step to execute.
		values.put("ISSUE_SUMMARY", "This is a issue.");	// This is the issue summary which is used for creating an issue.
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeStepWithDefect(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt64 is executed successfully.");
		
	}
	

@Test(enabled=testEnabled, priority=65)
public void testBvt65() {
		altID=65;
		logger.info("executing bvt65...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle Five");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		
		values.put("TEST_ONE", testKeySet.get("First test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_TWO", testKeySet.get("Second test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_THREE", testKeySet.get("Third test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_FOUR", testKeySet.get("Fourth test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_FIVE", testKeySet.get("Fifth test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_ONE_EXEC_STATUS", "PASSED");	// Test status which is used to set the status while executing a test.
		values.put("TEST_TWO_EXEC_STATUS", "FAIL");	// Test status which is used to set the status while executing a test.
		values.put("TEST_THREE_EXEC_STATUS", "WIP");	// Test status which is used to set the status while executing a test.
		values.put("TEST_FOUR_EXEC_STATUS", "BLOCKED");	// Test status which is used to set the status while executing a test.
		
		//isSuccess=zfjNavigator.createTestCycle(values);
		//Assert.assertTrue(isSuccess,"Creating cycle is not successfully.");
		isSuccess=zfjNavigator.addTestsMultipleAndExecute(values);
		Assert.assertTrue(isSuccess,"Adding tests multiple into cycle is not executed successfully.");
		
		logger.info("Bvt65 is executed successfully.");
		
	}
	
@Test(enabled=testEnabled, priority=66)
public void testBvt66() {
		altID=66;
		logger.info("executing bvt66...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", testKeySet.get("Eighth test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "BLOCKED");	// Test status which is used to set the status while executing a test.
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestDirectlyInViewIssue(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt66 is executed successfully.");
		
	}

@Test(enabled=testEnabled, priority=67)
public void testBvt67() {
		altID=67;
		logger.info("executing bvt50...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", testKeySet.get("Nineth test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "WIP");	// Test status which is used to set the status while executing a test.
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestDirectlyInPlanTest(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt67 is executed successfully.");
		
	}

@Test(enabled=testEnabled, priority=68)
public void testBvt68(){
	altID=68;
	logger.info("executing bvt68...");
	Map<String, String> values= new HashMap<String, String>();
	values.put("PREDEFINED_FILTER_NAME_ONE", "My Executed Tests");	// Name of the predefined filter one
	values.put("PREDEFINED_FILTER_NAME_TWO", "My Failed Executions");	// Name of the predefined filter two
	values.put("PREDEFINED_FILTER_NAME_THREE", "All Unexecuted Tests");	// Name of the predefined filter three
	values.put("PREDEFINED_FILTER_NAME_FOUR", "All Executed Tests");	// Name of the predefined filter four
	values.put("PREDEFINED_FILTER_NAME_FIVE", "All Failed Executions");	// Name of the predefined filter five
	
	isSuccess=zfjNavigator.executePredefinedFilters(values);
	Assert.assertTrue(isSuccess, "Execution of predefined filters failed.");
	logger.info("Bvt 68 executed successfully...");
}
@Test(enabled=testEnabled, priority=69)
public void testBvt69(){
	altID=69;
	logger.info("executing bvt69...");
	Map<String, String> values= new HashMap<String, String>();
	values.put("COMPONENT_NAME", "Component2");
	values.put("ZQLQUERY", "executionStatus != \"UNEXECUTED\" AND component=\"Component2\"");	// ZQL Query for component
	
	isSuccess=zfjNavigator.executeZQLQueryForComponent(values);
	Assert.assertTrue(isSuccess, "Execution of zql query for Component failed.");
	logger.info("Bvt 69 executed successfully...");
}
@Test(enabled=testEnabled, priority=70)
public void testBvt70(){
	altID=70;
	logger.info("executing bvt70...");
	isSuccess=zfjNavigator.changeBulkTestsStatusWithTeststeps("wip", "fail", 2);
	logger.info("Bvt70 executed successfully...");
}

@Test(enabled=testEnabled, priority=71)
public void testBvt71(){
	altID=71;
	logger.info("executing bvt71...");
	isSuccess=zfjNavigator.bulkMoveTestsToCycle("Version 2.0", "testcycle",2);
	logger.info("Bvt71 executed successfully...");
}

@Test(enabled=testEnabled, priority=72)
public void testBvt72(){
	altID=72;
	logger.info("executing bvt72...");
	String bugId = jiraNavigator.createIssue("Defect to Associate in Bulk copy with defect not carried", "Bug");
	isSuccess=zfjNavigator.bulkCopyTestToCycleWithDefectsAndStatusNotCarried("Version 2.0","cycle" ,bugId, 3);
	logger.info("Bvt71 executed successfully...");
}
@Test(enabled=testEnabled, priority=73)
public void testBvt73(){
	altID=73;
	logger.info("executing bvt73...");
	String bugId = jiraNavigator.createIssue("Defect to Associate in Bulk ", "Bug");
	isSuccess=zfjNavigator.bulkAssociateDefect(bugId,2);
	logger.info("Bvt73 executed successfully...");
}


@Test(enabled=testEnabled, priority=74)
public void testBvt74(){
	altID=74;
	logger.info("executing bvt 74...");
	Map<String, String> values= new HashMap<String, String>();
	values.put("ZQLQUERY", "fixVersion = \"Version 1.0\"");	// ZQL Query for execution.
	values.put("EXECUTION_FILTER_NAME", "ExecFilter4");	// Name of the filter.
	
	isSuccess=zfjNavigator.searchExecFilterInManageExecFilter(values);
	Assert.assertTrue(isSuccess, "Search execution filter is not searched successfully in search execution filter page.");
	logger.info("Bvt 74 executed successfully...");
}



@Test(enabled=testEnabled, priority=75)
public void testBvt75(){
		altID=75;
		logger.info("executing bvt75...");
		isSuccess=zfjNavigator.viewAndDrillDownTestSummary();	
		Assert.assertTrue(isSuccess, "Test Summary validation Failed...");
		logger.info("Bvt 75 executed successfully...");
		
	}
@Test(enabled=testEnabled, priority=76)
public void testBvt76(){
		altID=76;
		logger.info("executing bvt76...");
		isSuccess=zfjNavigator.viewTestSummaryCharts();	
		Assert.assertTrue(isSuccess,"Test Summary Charts validation Failed...");
		logger.info("Bvt 76 executed successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=77)
	public void testBvt77(){
		altID=77;
		logger.info("executing bvt77...");
		isSuccess=zfjNavigator.launchTestMatricsAndDispalysCreationAndExecutionGadgets();	
		Assert.assertTrue(isSuccess,"Test Creation And Execution Validation Failed");
		logger.info("Bvt 77 executed successfully...");
		
	}
	
@Test(enabled=testEnabled, priority=78)
public void testBvt78(){
		altID=78;
		logger.info("executing bvt78...");
		isSuccess=zfjNavigator.viewTestDistributonGadget();
		Assert.assertTrue(isSuccess,"Validating Test Distribution Gadget Failed...");
		isSuccess=zfjNavigator.viewTestExecutionGadget();
		Assert.assertTrue(isSuccess,"Validating Test Execution Gadget Failed...");
		logger.info("Bvt 78 executed successfully...");
			
		
}
	

	@Test(enabled=testEnabled, priority=79)

	public void testBvt79(){
		altID=79;
		logger.info("executing bvt79...");
		isSuccess=zfjNavigator.viewTopDefectGadget();	
		Assert.assertTrue(isSuccess,"Validating Top Defects Gadget Failed...");
		logger.info("Bvt 79 executed successfully...");
		
	}
	

	@Test(enabled=testEnabled, priority=80)
	public void testBvt80(){
		altID=80;
		logger.info("executing bvt80...");
		isSuccess=zfjNavigator.viewExecutionBurndownGadget();	
		Assert.assertTrue(isSuccess,"Validating Test Execution Burndown Failed...");
		logger.info("Bvt 80 executed successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=81)
	public void testBvt81(){
		altID=81;
		logger.info("executing bvt81...");
		isSuccess=zfjNavigator.viewTestExecutionDetailsGadget();
		Assert.assertTrue(isSuccess,"Validating Test Execution Details Failed...");
		logger.info("Bvt 81 execution successfully...");
	}
		
	
	@BeforeClass
	public void beforeClass() throws Throwable{
		logger.info("beforeClass invoked");
		JIRA_USER_USERNAME=Config.getValue("JIRA_USER_USERNAME");
		JIRA_USER_PASSWORD=Config.getValue("JIRA_USER_PASSWORD");
		Assert.assertTrue(jiraNavigator.doLogin(JIRA_USER_USERNAME, JIRA_USER_PASSWORD), "Login to jira is not successfully.");
		logger.info("logged in to Jira successfully.");
		Assert.assertTrue(JiraLandingPage.getInstance().selectProject(Config.getValue("JIRA_PROJECT")), " Project is not selected successfully.");
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
			logger.info("logged in to Jira successfully.");
		}
		isSuccess = false;
		
	}
	
	@AfterMethod
	public void afterMethod() throws Exception{
		logger.info("afterMethod invoked");
		if(isSuccess==false){
			captureScreenshotInLog();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(jiraNavigator.doLogout(),"Logout from jira is not successfully.");
			logger.info("logged out from Jira successfully...");
			
		}
		updateStatusInExcel();
		logger.info("Excel sheet is updated successfully.");
	}


}

