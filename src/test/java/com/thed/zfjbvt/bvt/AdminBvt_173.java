package com.thed.zfjbvt.bvt;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.zfj.impl.ZfjNavigator173Impl;
import com.thed.zfjbvt.zfj.impl.zfj173.TestMetricsPage;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.CustomHTMLLayout;
import com.thed.zfjbvt.util.Driver;

public class AdminBvt_173 extends BaseTest {
	
	//private JiraNavigator jiraNavigator = new JiraNavigator52Impl() ;
	//private ZfjNavigator zfjNavigator = new ZfjNavigator173Impl();
	//private CommonUtil commonUtil=new CommonUtil();
	private String JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD;
		
	public AdminBvt_173() {
		logger = Logger.getLogger(this.getClass());
	}

	@Test(enabled=testEnabled, priority=1)
	public void testBvt1() {
		altID=1;
		logger.info("Executing bvt1...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("ADMIN_AUTHENTICATE_USERNAME", "admin");	// Used for authenticate administration username.
		values.put("ADMIN_AUTHENTICATE_PASSWORD", "admin");	// Used for authenticate Administrative password.
		values.put("FIND_NEW_PLUGIN_NAME", "zephyr");	// Used for Find new plugin 
		
		isSuccess=jiraNavigator.searchForNewPlugIn(values);
		Assert.assertTrue(isSuccess,"New plugin is not found successfully.");
		logger.info("bvt1 is executed successfully.");
		
		
	}
	@Test(enabled=testEnabled, priority=2)
	public void testBvt2() {
		altID=2;
		logger.info("Executing bvt2...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("ADMIN_AUTHENTICATE_USERNAME", "admin");	// Used for authenticate administration username.
		values.put("ADMIN_AUTHENTICATE_PASSWORD", "admin");	//Used for authenticate Administrative password.
		
		isSuccess=jiraNavigator.installZFJPlugIn(values);
		Assert.assertTrue(isSuccess,"zfj plugin is not installed successfully.");
		logger.info("bvt2 is executed successfully.");
		
		
	}
	
	@Test(enabled=testEnabled, priority=3)
	public void testBvt3() {
		altID=3;
		logger.info("executing bvt3...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("TEST_EXEC_STATUS", "PASS"); // Main test execution status which is used to finding the status.
		values.put("NEW_TEST_EXEC_STATUS", "PASSED"); // used for updating the test status.
		values.put("NEW_TEST_EXEC_STATUS_DESC", "Test was executed and passed successfully.(edited)"); // Used for updating test status description.
		
		isSuccess=zfjNavigator.updateTestExecutionStatus(values);
		Assert.assertTrue(isSuccess,"Test status is not updated successfully.");
		logger.info("bvt3 is executed successfully.");
		
		
	}
	
	@Test(enabled=testEnabled, priority=4)
	public void testBvt4() {
		altID=4;
		logger.info("executing bvt4...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("NEW_TEST_EXEC_STATUS", "CANCEL"); // New test status for adding into step status.
		values.put("NEW_TEST_EXEC_STATUS_DESC", "It will cancel the test."); // New test status description for adding into the step status.
		values.put("NEW_TEST_EXEC_STATUS_COLORCODE", "#ff33ff"); // New color code for adding into the test status.
		
		isSuccess=zfjNavigator.addTestExecutionStatus(values);
		Assert.assertTrue(isSuccess, "New Test status is not added successfully.");
		logger.info("bvt4 is executed successfully.");
		
	}
	@Test(enabled=testEnabled, priority=5)
	public void testBvt5() {
		altID=5;
		logger.info("executing bvt5...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("STEP_EXEC_STATUS", "PASS"); // Old Step status for editing and updating.
		values.put("NEW_STEP_EXEC_STATUS", "PASSED"); // New step status used for updating into old status.
		values.put("NEW_STEP_EXEC_STATUS_DESC", "Test step was executed and passed successfully.(edited)"); // New step status description for adding into the new step status.
		
		isSuccess=zfjNavigator.updateStepExecutionStatus(values);
		Assert.assertTrue(isSuccess,"Step status is not updated successfully.");
		logger.info("Bvt5 is executed successfully.");
		
	}
	@Test(enabled=testEnabled, priority=6)
	public void testBvt6() {
		altID=6;
		logger.info("executing bvt6...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("NEW_STEP_EXEC_STATUS", "CANCEL"); // New step status for adding into the step statuses.
		values.put("NEW_STEP_EXEC_STATUS_DESC", "This is cancelled status."); // New Step description for adding into the step status.
		values.put("NEW_STEP_EXEC_STATUS_COLORCODE", "#ff33ff"); // New step status color code for adding into the step status.
		
		isSuccess=zfjNavigator.addStepExecutionStatus(values);
		Assert.assertTrue(isSuccess,"New Step status is not added successfully.");
		logger.info("Bvt6 is executed successfully.");
		
	}
	
	@Test(enabled=testEnabled, priority=7)
	public void testBvt7() {
		altID=7;
		logger.info("executing bvt7...");
		isSuccess=zfjNavigator.verifyZfjTestMenus();
		Assert.assertTrue(isSuccess, "ZFJ test menus validation failed");
		logger.info("Bvt7 executed successfully...");
		
	}
	@Test(enabled=testEnabled, priority=8)
	public void testBvt8(){
		altID=8;
		logger.info("executing bvt8...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("PRIORITY", "Critical"); // priority of new Test.
		values.put("COMPONENT", "Component1"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 1.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 2.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "Label1"); //label of new Test.
		
		isSuccess=zfjNavigator.createTest(values);
		Assert.assertTrue(isSuccess, "New Test Creation Failed...");
		logger.info("Bvt8 executed successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=9)
	public void testBvt9(){
		altID=9;
		logger.info("executing bvt9...");
		isSuccess=jiraNavigator.setFieldVisibilityInCreateIssueDialog("Environment", "Fix Version/s");
		Assert.assertTrue(isSuccess,"Setting Fields Visibility Failed...");
		logger.info("Bvt9 executed successfully...");
	}
	
	@Test(enabled=testEnabled, priority=10)
	public void testBvt10(){
		altID=10;
		logger.info("executing bvt10..");
		
		Map<String, String> values= new HashMap<String, String>();
		values.put("SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("PRIORITY", "Major"); // priority of new Test.
		values.put("COMPONENT", "Component1"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 1.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 1.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "Label2"); //label of new Test.
		values.put("COMPONENT", "Component1"); // component of new Test.
		values.put("AFFECTEDVERSION", "Version 1.0"); // affected version of new Test.
		values.put("FIXVERSION", "Version 1.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "wifi"); //label of new Test.
		//first step.
		values.put("FIRST_STEP", "Open browser");
		values.put("FIRST_DATA", "Default browser");
		values.put("FIRST_EXPECTED_RESULT", "Default browser must launched");
		//second step.
		values.put("SECOND_STEP", "Enter url");
		values.put("SECOND_DATA", "www.gmail.com");
		values.put("SECOND_EXPECTED_RESULT", "should open the gmail page");
		//third step.
		values.put("THIRD_STEP", "Enter valid username and pwd");
		values.put("THIRD_DATA", "username:abcd pwd:1234");
		values.put("THIRD_EXPECTED_RESULT", "should open the home page of the user");
		//fourth step.
		values.put("FOURTH_STEP", "Compose a mail");
		values.put("FOURTH_DATA", "To:xyz@gmail.com");
		values.put("FOURTH_EXPECTED_RESULT", "Mail must be created");
		//fifth step.
		values.put("FIFTH_STEP", "Send a mail");
		values.put("FIFTH_DATA", "click on send button");
		values.put("FIFTH_EXPECTED_RESULT", "Confirmation msg must be displayed");
		values.put("TOTAL_STEPS","5");
		
		isSuccess=zfjNavigator.addStepsToTest(values);
		Assert.assertTrue(isSuccess,"Teststeps additin Failed...");
		logger.info("Teststeps added Successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=11)
	public void testBvt11(){
		altID=11;
		logger.info("executing bvt11...");
		//isSuccess=zfjNavigator.reArrangeTeststeps();
		Assert.assertTrue(isSuccess,"Re-Arranging of teststep failed...");
		logger.info("Bvt11 executed successfully...");
		
	}
	@Test(enabled=testEnabled, priority=12)
	public void testBvt12(){
		altID=12;
		logger.info("executing bvt12...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("SUMMARY", "Open default Browser and login to Gmail"); // summary of the new Test.
		values.put("PRIORITY", "Blocker"); // priority of new Test.
		//first step.
		values.put("FIRST_STEP", "Open browser");
		values.put("FIRST_DATA", "Default browser");
		values.put("FIRST_EXPECTED_RESULT", "Default browser must launched");
		//second step.
		values.put("SECOND_STEP", "Enter url");
		values.put("SECOND_DATA", "www.gmail.com");
		values.put("SECOND_EXPECTED_RESULT", "should open the gmail page");
		values.put("TOTAL_STEPS","2");
		values.put("TEST_STEP_TO_EDIT","1");
		values.put("CHANGE_STEP_TO","Check the network");
		values.put("CHANGE_DATA_TO","4g");
		values.put("CHANGE_EXPECTED_RESULT_TO","shud show the 4g-network");
		
		isSuccess=zfjNavigator.editTeststeps(values);
		Assert.assertTrue(isSuccess, "Editing Test Step Failed");
		logger.info("Bvt12 executed successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=13)
	public void testBvt13(){
		altID=13;
		logger.info("executing bvt13...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("PRIORITY", "Critical"); // priority of new Test.
		values.put("COMPONENT", "Component2"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 3.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 3.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "Label2"); //label of new Test.
		
		//edit the test details to.
		values.put("CHANGE_SUMMARY_TO","Drag and drop an icon from menu to main screen verify wether that icon is displayed properly");
		values.put("CHANGE_PRIORITY_TO", "Blocker");
		values.put("CHANGE_COMPONENT_TO", "Component3"); // component of new Test.
		values.put("CHANGE_AFFECTED_VERSION_TO", "Version 2.0"); // affected version of new Test.
		values.put("CHANGE_FIX_VERSION_TO", "Version 2.0"); // fix version of new Test.
		values.put("CHANGE_ENVIRONMENT_TO", "kitkat"); //environment of new Test.
		values.put("CHANGE_DESCRIPTION_TO", "check the icon moved"); //description of new Test.
		values.put("CHANGE_LABEL_TO", "Label3"); //label of new Test.
		
		isSuccess=zfjNavigator.editTestDetails(values);
		Assert.assertTrue(isSuccess, "Editing Test Failed...");
		logger.info("Bvt13 executed successfully...");		
	}
	
	@Test(enabled=testEnabled, priority=14)
	public void testBvt14(){
		altID=14;
		logger.info("executing bvt14...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("PRIORITY", "Major"); // priority of new Test.
		values.put("COMPONENT", "Component1"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 1.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 2.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "Label1"); //label of new Test.
		//first step.
		values.put("FIRST_STEP", "Open browser");
		values.put("FIRST_DATA", "Default browser");
		values.put("FIRST_EXPECTED_RESULT", "Default browser must launched");
		//second step.
		values.put("SECOND_STEP", "Enter url");
		values.put("SECOND_DATA", "www.gmail.com");
		values.put("SECOND_EXPECTED_RESULT", "should open the gmail page");
		values.put("TOTAL_STEPS","2");
		values.put("CHANGE_SUMMARY_TO", "Enable the bluetooth and verify the data transfer at min rate");
		isSuccess=zfjNavigator.cloneTest(values);
		Assert.assertTrue(isSuccess,"Test cloning Failed...");
		logger.info("Bvt14 executed successfully...");
	}
	
	@Test(enabled=testEnabled, priority=15)
	public void testBvt15(){
		altID=15;
		logger.info("executing bvt15...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("PRIORITY", "Major"); // priority of new Test.
		values.put("COMPONENT", "Component1"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 1.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 1.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "Label2"); //label of new Test.
		
		//edit the test details to.
		values.put("SECOND_SUMMARY","Drag and drop an icon from menu to main screen verify wether that icon is displayed properly");
		values.put("SECOND_PRIORITY", "Major");
		values.put("SECOND_COMPONENT", "Component2"); // component of new Test.
		values.put("SECOND_AFFECTED_VERSION", "Version 3.0"); // affected version of new Test.
		values.put("SECOND_FIX_VERSION", "Version 3.0"); // fix version of new Test.
		values.put("SECOND_ENVIRONMENT", "kitkat"); //environment of new Test.
		values.put("SECOND_DESCRIPTION", "check the icon moved"); //description of new Test.
		values.put("SECOND_LABEL", "Label3"); //label of new Test.
		values.put("LINKS","blocks");
		values.put("COMMENT","issue is blocked");
		
		isSuccess=zfjNavigator.linkTestToAnotherTest(values);	
		Assert.assertTrue(isSuccess,"Test linking failed...");
		logger.info("Bvt15 executed successfully...");
	}
	@Test(enabled=testEnabled, priority=16)
	public void testBvt16(){
		altID=16;
		logger.info("executing bvt16");
		Map<String, String> values= new HashMap<String, String>();
		
		//first set of test and issue to be linked.
		values.put("TEST_SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("TEST_PRIORITY", "Critical"); // priority of new Test.
		values.put("ISSUE_SUMMARY","verified the wifi");
		values.put("ISSUE_TYPE","Task");
		values.put("LINKS","clones");
		values.put("COMMENT","clones the issue");
		Assert.assertTrue(zfjNavigator.linkTestToissue(values),"Linking Test to Issue Failed...");
		logger.info("--------------------------------");
		//second set of test and issue to be linked.
		values.put("TEST_SUMMARY","Drag and drop an icon from menu to main screen verify wether that icon is displayed properly");
		values.put("TEST_PRIORITY", "Blocker");
		values.put("ISSUE_SUMMARY","verified the display");
		values.put("ISSUE_TYPE","Bug");
		values.put("LINKS","blocks");
		values.put("COMMENT","issue is blocked");
		Assert.assertTrue(zfjNavigator.linkTestToissue(values),"Linking Test to Issue Failed...");
		logger.info("--------------------------------");
		//third set of test and issue to be linked.
		values.put("TEST_SUMMARY","Enable the bluetooth and check for devices ");
		values.put("TEST_PRIORITY", "Major");
		values.put("ISSUE_SUMMARY","verified the bluetooth");
		values.put("ISSUE_TYPE","New Feature");
		values.put("LINKS","relates to");
		values.put("COMMENT","issue relates to");
		Assert.assertTrue(zfjNavigator.linkTestToissue(values),"Linking Test to Issue Failed...");
		logger.info("--------------------------------");
		//fourth set of test and issue to be linked.
		values.put("TEST_SUMMARY","Enable the data connection and browser gmail ");
		values.put("TEST_PRIORITY", "Minor");
		values.put("ISSUE_SUMMARY","verified the data connection");
		values.put("ISSUE_TYPE","Improvement");
		values.put("LINKS","duplicates");
		values.put("COMMENT","issue is duplicated");
		
		isSuccess=zfjNavigator.linkTestToissue(values);
		Assert.assertTrue(isSuccess,"Linking Test to Issue Failed...");
		logger.info("Bvt16 executed successfully...");	
	}
	@Test(enabled=testEnabled, priority=17)
	public void testBvt17(){
		altID=17;
		logger.info("executing bvt17");
		isSuccess=zfjNavigator.searchTestByKeyword();	
		Assert.assertTrue(isSuccess,"Search for Test Failed... ");
		logger.info("Bvt17 executed successfully...");
	}

	@Test(enabled=testEnabled, priority=18)
	public void testBvt18(){
		logger.info("executing bvt18");
		Map<String, String> values= new HashMap<String, String>();
		values.put("SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("PRIORITY", "Critical"); // priority of new Test.
		values.put("COMPONENT", "Component1"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 1.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 1.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "wifi"); //label of new Test.
		//first step.
		values.put("FIRST_STEP", "Open browser");
		values.put("FIRST_DATA", "Default browser");
		values.put("FIRST_EXPECTED_RESULT", "Default browser must launched");
		//second step.
		values.put("SECOND_STEP", "Enter url");
		values.put("SECOND_DATA", "www.gmail.com");
		values.put("SECOND_EXPECTED_RESULT", "should open the gmail page");
		//third step.
		values.put("THIRD_STEP", "Enter valid username and pwd");
		values.put("THIRD_DATA", "username:abcd pwd:1234");
		values.put("THIRD_EXPECTED_RESULT", "should open the home page of the user");
		values.put("TOTAL_STEPS","3");
		
		isSuccess=zfjNavigator.addStepsToTest(values);
		Assert.assertTrue(isSuccess,"Teststeps additin Failed...");
		isSuccess=zfjNavigator.exportTestFromIssueNavigator();
		Assert.assertTrue(isSuccess,"Exporting of Test from IssueNavigator Failed...");
		logger.info("Bvt18 executed successfully...");
	}

	@Test(enabled=testEnabled, priority=19)
	public void testBvt19() {
		altID=19;
		logger.info("executing bvt19...");
		isSuccess=zfjNavigator.deleteTest(testKeySet.get("Test to be Delete"));	
		Assert.assertTrue(isSuccess,"Deleting test is not successfully.");
		logger.info("Bvt19 is executed successfully.");
		
	}
	
	@Test(enabled=testEnabled, priority=20)
	public void testBvt20() {
		altID=20;
		logger.info("executing bvt20...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	// Cycle is used for creating and selecting a cycle in zfj.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		
		isSuccess=zfjNavigator.createTestCycle(values);	
		Assert.assertTrue(isSuccess,"Creating cycle is not successfully.");
		logger.info("Bvt20 is executed successfully.");
		
	}
	
	@Test(enabled=testEnabled, priority=21)
	public void testBvt21() {
		altID=21;
		logger.info("executing bvt21...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZFJ-1");	// Here Test is used to add indivisually into the cycle.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		values.put("SUMMARY", "This is a test.");	// Test summary to create a test.
		values.put("PRIORITY", "Major");	// The priority value which will need while creating atest.
		
		isSuccess=zfjNavigator.addTestToCycle(values);	
		Assert.assertTrue(isSuccess,"Adding tests into cycle is not successfully.");
		logger.info("Bvt21 is executed successfully.");
		
	}
	@Test(enabled=testEnabled, priority=22)
	public void testBvt22() {
		altID=22;
		logger.info("executing bvt22...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZFJ-2");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "PASSED");	// Test status which is used to set the status while executing a test.
		values.put("SUMMARY", "This is a test.");	// Test summary to create a test.
		values.put("PRIORITY", "Major");	// The priority value which will need while creating atest.
		
		isSuccess=zfjNavigator.executeTest(values);	
		//Assert.assertTrue(zfjNavigator.addTestToCycle(values),"Adding test into cycle is not executed successfully.");
		Assert.assertTrue(isSuccess, "Test is not executed successfully.");
		logger.info("Bvt22 is executed successfully.");
		
	}
	
	@Test(enabled=testEnabled, priority=23)
	public void testBvt23() {
		altID=23;
		logger.info("executing bvt23...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZFJ-3");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "FAIL");	// Test status which is used to set the status while executing a test.
		values.put("ISSUE_SUMMARY", "This is a issue.");	// This is the issue summary which is used for creating an issue.
		
		isSuccess=zfjNavigator.addTestToCycle(values);	
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestWithDefect(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt23 is executed successfully.");
		
	}
	@Test(enabled=testEnabled, priority=24)
	public void testBvt24() {
		altID=24;
		logger.info("executing bvt24...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZFJ-11");	// Here Test is used to add and execute in the cycle.
		values.put("STEP_EXEC_STATUS_ONE", "PASSED");	// Step status one which is used to set the status while executing a test.
		values.put("STEP_EXEC_STATUS_TWO", "FAIL");	// Step status two which is used to set the status while executing a test.
		values.put("STEP_EXEC_STATUS_THREE", "WIP");	// Step status three which is used to set the status while executing a test.
		values.put("STEP_EXEC_STATUS_FOUR", "BLOCKED");	// Step status four which is used to set the status while executing a test.
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeSteps(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt23 is executed successfully.");
		
	}
	
	@Test(enabled=testEnabled, priority=25)
	public void testBvt25() {
		altID=25;
		logger.info("executing bvt25...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZFJ-12");	// Here Test is used to add and execute in the cycle.
		values.put("STEP_EXEC_STATUS", "FAIL");	// Step status for execution which is used to set the status while executing a test.
		values.put("TEST_STEP_NUM", "2"); // Test step to execute.
		values.put("ISSUE_SUMMARY", "This is a issue.");	// This is the issue summary which is used for creating an issue.
		
		isSuccess=zfjNavigator.addTestToCycle(values);	
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeStepWithDefect(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt25 is executed successfully.");
	
	}
	@Test(enabled=testEnabled, priority=26)
	public void testBvt26() {
		altID=26;
		logger.info("executing bvt26...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle Two");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		
		values.put("TEST_ONE", "ZFJ-1");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_TWO", "ZFJ-2");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_THREE", "ZFJ-3");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_FOUR", "ZFJ-4");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_FIVE", "ZFJ-5");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_ONE_EXEC_STATUS", "PASSED");	// Test status which is used to set the status while executing a test.
		values.put("TEST_TWO_EXEC_STATUS", "FAIL");	// Test status which is used to set the status while executing a test.
		values.put("TEST_THREE_EXEC_STATUS", "WIP");	// Test status which is used to set the status while executing a test.
		values.put("TEST_FOUR_EXEC_STATUS", "BLOCKED");	// Test status which is used to set the status while executing a test.
		
		isSuccess=zfjNavigator.createTestCycle(values);	
		Assert.assertTrue(isSuccess,"Creating cycle is not successfully.");
		isSuccess=zfjNavigator.addTestsMultipleAndExecute(values);	
		Assert.assertTrue(isSuccess,"Adding tests multiple into cycle is not executed successfully.");
		logger.info("Bvt26 is executed successfully.");
		
	}
	
	@Test(enabled=testEnabled, priority=27)
	public void testBvt27() {
		altID=27;
		logger.info("executing bvt27...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle Three");	// Cycle is used for creating and selecting a cycle in zfj.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		values.put("FILTER_NAME", "Filter One"); // This key contains the filter name.
		
		isSuccess=zfjNavigator.createTestCycle(values);	
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.addTestsFromJiraSearch(values);
		Assert.assertTrue(isSuccess, "Test is not executed successfully.");
		logger.info("Bvt27 is executed successfully.");
	
	}
	
	@Test(enabled=testEnabled, priority=28)
	public void testBvt28() {
		altID=28;
		logger.info("executing bvt28...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("OLD_CYCLE_NAME", "Cycle One");	// This contains cycle name from where we can get the tests with associate defects.
		values.put("CYCLE_NAME", "Cycle Four");	// Cycle is used for creating and selecting a cycle in zfj.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		
		isSuccess=zfjNavigator.createTestCycle(values);	
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.addTestsFromOtherCycle(values);
		Assert.assertTrue(isSuccess, "Test is not executed successfully.");
		logger.info("Bvt27 is executed successfully.");
		
	}
	@Test(enabled=testEnabled, priority=29)
	public void testBvt29() {
		altID=29;
		logger.info("executing bvt29...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZFJ-4");	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "CANCEL");	// Test status which is used to set the status while executing a test.
		
		isSuccess=zfjNavigator.addTestToCycle(values);	
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTest(values);	
		Assert.assertTrue(isSuccess, "Test is not executed successfully.");
		logger.info("Bvt29 is executed successfully.");
	
	}
	
	@Test(enabled=testEnabled, priority=30)
	public void testBvt30() {
		altID=30;
		logger.info("executing bvt30...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZFJ-13");	// Here Test is used to add and execute in the cycle.
		values.put("STEP_EXEC_STATUS", "CANCEL");	// Step status one which is used to set the status while executing a test.
		values.put("STEP_NUM", "1");	// Step number for execution.
			
		isSuccess=zfjNavigator.addTestToCycle(values);	
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeStep(values);	
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt30 is executed successfully.");
	
	}
	
	@Test(enabled=testEnabled, priority=31)
	public void testBvt31() {
		altID=31;
		logger.info("executing bvt31...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", "ZAPI-14");	// Here Test is used to add and execute in the cycle.
		values.put("STEP_EXEC_STATUS", "PASSED");	// Step status one which is used to set the status while executing a test.
		values.put("NUM_OF_STEPS_EXEC", "5"); 	// Total number of tests to execute.
		
		isSuccess=zfjNavigator.addTestToCycle(values);	
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeAllSteps(values);	
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt23 is executed successfully.");
	
	}
	@Test(enabled=testEnabled, priority=32)
	public void testBvt32() {
		altID=32;
		logger.info("executing bvt32...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle Two");	// Cycle is used for creating and selecting a cycle in zfj.
		values.put("NEW_CYCLE_NAME", "Cycle Twoedit"); // This is the new cycle which replaces the original cycle.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("BUILD_NAME", "build 1.0"); // This is the build number of the project.
		values.put("ENV_NAME", "Env-1"); // This is the enviroment which is used by this project.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		values.put("CYCLE_END_DATE", "22/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		
		isSuccess=zfjNavigator.editCycle(values);	
		Assert.assertTrue(isSuccess,"Creating cycle is not successfully.");
		logger.info("Bvt32 is executed successfully.");
	
	}
	
	@Test(enabled=testEnabled, priority=33)
	public void testBvt33() {
		altID=33;
		logger.info("executing bvt33...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	// Cycle is used for creating and selecting a cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");
		values.put("BUILD_NAME", "build 1.0");
		values.put("ENVIROMENT_NAME", "Env-1");
		
		isSuccess=zfjNavigator.exportCycle(values);	
		Assert.assertTrue(isSuccess,"Test Cycle is not exported successfully.");
		logger.info("Bvt33 is executed successfully.");
		
}

	@Test(enabled=testEnabled, priority=34)
	public void testBvt34(){
		altID=34;
		Map<String, String> values= new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Testcycle");	// Cycle is used for creating and selecting a cycle in zfj.
		values.put("CLONE_CYCLE_NAME", "TestcycleClone");	// Cycle is used for creating and selecting a cycle in zfj.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		values.put("TEST_SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("TEST_PRIORITY", "Critical"); // priority of new Test.
		logger.info("executing bvt34...");
		isSuccess=zfjNavigator.cloneTestCycle(values);	
		Assert.assertTrue(isSuccess, "Test cycle cloning Failed...");
		logger.info("Bvt34 executed successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=35)
	public void testBvt35(){
		altID=35;
		logger.info("executing bvt35...");
		isSuccess=zfjNavigator.viewAndDrillDownTestSummary();
		Assert.assertTrue(isSuccess, "Test Summary validation Failed...");
		logger.info("Bvt 35 executed successfully...");
	}
	
	@Test(enabled=testEnabled, priority=36)
	public void testBvt36(){
		altID=36;
		logger.info("executing bvt36...");
		isSuccess=zfjNavigator.viewTestSummaryCharts();
		Assert.assertTrue(isSuccess,"Test Summary Charts validation Failed...");
		logger.info("Bvt 36 executed successfully...");
		
		
	}
	
	@Test(enabled=testEnabled, priority=37)
	public void testBvt37(){
		altID=37;
		logger.info("executing bvt37...");
		isSuccess=zfjNavigator.launchTestMatricsAndDispalysCreationAndExecutionGadgets();	
		Assert.assertTrue(isSuccess,"Test Creation And Execution Validation Failed");
		logger.info("Bvt 37 executed successfully...");
		
	}
	
	@Test(enabled=testEnabled, priority=38)
	public void testBvt38(){
		altID=38;
		logger.info("executing bvt38...");
		isSuccess=zfjNavigator.addTopDefectGadget();	
		Assert.assertTrue(isSuccess,"Adding Top Defect Gadget Failed...");
		logger.info("Bvt 38 executed successfully...");
		
	}
	@Test(enabled=testEnabled, priority=39)
	public void testBvt39(){
		altID=39;
		logger.info("executing bvt39...");
		isSuccess=zfjNavigator.addExecutionBurndownGadget();	
		Assert.assertTrue(isSuccess,"Adding Test Execution Burndown Gadget Failed...");
		logger.info("Bvt 39 executed successfully...");
	
	}
	@Test(enabled=testEnabled, priority=40)
	public void testBvt40(){
		altID=40;
		Map<String, String> values = new HashMap<String, String>();
		values.put("GADGET","Zephyr Test Distribution");
		values.put("PROJECT",Config.getValue("JIRA_PROJECT"));
		values.put("VERSION","Version 1.0");
		values.put("GROUPBY","Component");
		
		isSuccess=zfjNavigator.editGadget(values);	
		Assert.assertTrue(isSuccess,"Editing Gadget Failed...");
		isSuccess=TestMetricsPage.getInstance().validateTestGadget(values.get("GADGET"));	
		Assert.assertTrue(isSuccess);
		logger.info("Bvt 40 executed successfully...");
		
	}

	@Test(enabled=testEnabled, priority=57)
	public void testBvt57(){
		altID=57;
		logger.info("executing bvt57...");
		isSuccess=zfjNavigator.checkWorkflowToolbar();
		Assert.assertTrue(isSuccess,"Validating ZFJ workflow tool bar failed...");
		logger.info("Bvt 57 executed successfully...");
		
			
	}
	
	@Test(enabled=testEnabled, priority=58)
	public void testBvt58(){
		altID=58;
		logger.info("executing bvt58...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("SUMMARY", "Test one to validate Issue Link"); // summary of first Test.
		values.put("PRIORITY", "Blocker"); // priority of first Test.
		values.put("DEFECT_SUMMARY","Defect one added to validate Issue link");
		Assert.assertTrue(jiraNavigator.navigateToZfjGeneralConfigurationPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD),"Navigation to Zephyr General Coniguration Page Failed...");
		Assert.assertTrue(zfjNavigator.checkIssueLinkStatus(),"Checking Issue Link Status Failed...");
		Assert.assertTrue(jiraNavigator.leavingAdministrationPage(),"Navigating form ZFJ Admin Page Failed...");
		isSuccess = zfjNavigator.validateIssueLink(values);
		
		
		values.put("SUMMARY", "Test two to validate Issue Link"); // summary of second Test.
		values.put("PRIORITY", "Major"); // priority of second Test.
		values.put("DEFECT_SUMMARY","Defect two added to validate Issue link");
		values.put("ISSUE_TYPE", "Bug");
		Assert.assertTrue(jiraNavigator.navigateToZfjGeneralConfigurationPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD),"Navigation to Zephyr General Coniguration Page Failed...");
		Assert.assertTrue(zfjNavigator.changeIssueLinkStatus());
		Assert.assertTrue(jiraNavigator.leavingAdministrationPage());
		isSuccess = zfjNavigator.validateIssueLink(values);
		Assert.assertTrue(isSuccess, "Validating IssueLink Failed... ");
		logger.info("Bvt94 executed successfully...");
		logger.info("Bvt 58 executed successfully...");
		
	}

	@Test(enabled=testEnabled, priority=59)
	public void testBvt59(){
		altID=59;
		logger.info("executing bvt59...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("SUMMARY", "Test one to validate  Remote Issue Link"); // summary of the first Test.
		values.put("PRIORITY", "Blocker"); // priority of first Test.
		values.put("DEFECT_SUMMARY","Defect one added to validate Remote Issue link");
		Assert.assertTrue(jiraNavigator.navigateToZfjGeneralConfigurationPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD),"Navigation to Zephyr General Coniguration Page Failed...");
		Assert.assertTrue(zfjNavigator.checkRemoteIssueLinkStatus());
		Assert.assertTrue(jiraNavigator.leavingAdministrationPage());
		isSuccess = zfjNavigator.validateRemoteIssueLink(values);
		
				
		values.put("SUMMARY", "Test two to validate Issue Link"); // summary of the second Test.
		values.put("PRIORITY", "Blocker"); // priority of second Test.
		values.put("DEFECT_SUMMARY","Defect two added to validate Issue link");
		Assert.assertTrue(jiraNavigator.navigateToZfjGeneralConfigurationPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD),"Navigation to Zephyr General Coniguration Page Failed...");
		Assert.assertTrue(zfjNavigator.changeRemoteIssueLinkStatus());
		Assert.assertTrue(jiraNavigator.leavingAdministrationPage());
		isSuccess = zfjNavigator.validateRemoteIssueLink(values);
		Assert.assertTrue(isSuccess, "Validating IssueLink Failed... ");
		logger.info("Bvt 59 executed successfully...");
		
	}

	@BeforeClass
	public void beforeClass() throws Throwable{
		logger.info("beforeClass invoked");
		//JIRA_ADMIN_USERNAME=Config.getValue("JIRA_ADMIN_USERNAME");
		//JIRA_ADMIN_PASSWORD=Config.getValue("JIRA_ADMIN_PASSWORD");
		Assert.assertTrue( jiraNavigator.doLogin( JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD), "Login to jira is not successfully...");
		logger.info("Logged Into Jira Successfully...");
		JIRA_URL = Config.getValue("JIRA_URL");
		if((Driver.driver.equals(null))){
			CommonUtil.launchBrowser(JIRA_URL);
			logger.info("Initialization of all data Successfully.");
		}
		
	}
	
	
	@AfterClass
	public void afterClass() throws InterruptedException{
		logger.info("afterClass invoked");
		logger.info("logout from Jira successfully.");
		Assert.assertTrue(jiraNavigator.doLogout(),"Logout from jira is not successfully.");
		CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
	}
	
	@BeforeMethod
	public void beforeMethod(){
		logger.info("beforeMethod invoked");
		if( Driver.driver == null ){
			Driver.driver = Driver.browserFactory();
		}
		if(Driver.driver.getTitle().contains("Log in")){
			Assert.assertTrue(jiraNavigator.doLogin(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD), "Login to jira is not successfully.");
			logger.info("logged in to Jira successfully.");
		}
		isSuccess = false;
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		logger.info("afterMethod invoked");
		if( isSuccess == false ){
			logger.info("Taking Screenshot for failed testcase.");
			captureScreenshotInLog();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(jiraNavigator.doLogout(),"Logout from jira is not successfully.");
			logger.info("logged out from Jira successfully...");
			
		}
		updateStatusInExcel();
		logger.info("Excel sheet is updated successfully.");
	}

}
