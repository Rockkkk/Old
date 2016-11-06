package com.thed.zfjbvt.bvt;
import java.util.HashMap;
import java.util.List;
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

public class AdminBvt_22 extends BaseTest {
		
	public AdminBvt_22() {
		logger = Logger.getLogger(this.getClass());
	}
	
	@Test(enabled = testEnabled, priority=1)
	public void testBvt1() {
		altID=1;
		CommonUtil.alertMsg("executing bvt1...");
		logger.info("Executing bvt1...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("ADMIN_AUTHENTICATE_USERNAME", JIRA_ADMIN_USERNAME);	// Used for authenticate administration username.
		values.put("ADMIN_AUTHENTICATE_PASSWORD", JIRA_ADMIN_PASSWORD);	// Used for authenticate Administrative password.
		values.put("FIND_NEW_PLUGIN_NAME", "zephyr");	// Used for Find new plugin 
		
		isSuccess=jiraNavigator.searchForNewPlugIn(values);
		Assert.assertTrue(isSuccess,"New plugin is not found successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("bvt1 is executed successfully.");	
	}
	@Test(enabled = testEnabled, priority=2)
	public void testBvt2() {
		altID=2;
		CommonUtil.alertMsg("executing bvt2...");
		logger.info("Executing bvt2...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("ADMIN_AUTHENTICATE_USERNAME", JIRA_ADMIN_USERNAME);	// Used for authenticate administration username.
		values.put("ADMIN_AUTHENTICATE_PASSWORD", JIRA_ADMIN_PASSWORD);	//Used for authenticate Administrative password.
				
		isSuccess=jiraNavigator.installZFJPlugIn(values);
		Assert.assertTrue(isSuccess,"zfj plugin is not installed successfully.");
		
		isSuccess = zfjNavigator.validateTestsDropDown();
		Assert.assertTrue(isSuccess,"Tests drop down link is not validated successfully.");
		
		logger.info("bvt2 is executed successfully.");
		
	}
	
	@Test(enabled = testEnabled, priority=3)
	public void testBvt3() {
		altID=3;
		CommonUtil.alertMsg("executing bvt3...");
		logger.info("executing bvt3...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("TEST_EXEC_STATUS", "PASS"); // Main test execution status which is used to finding the status.
		values.put("NEW_TEST_EXEC_STATUS", "PASSED"); // used for updating the test status.
		values.put("NEW_TEST_EXEC_STATUS_DESC", "Test was executed and passed successfully.(edited)"); // Used for updating test status description.
		
		
		isSuccess = jiraNavigator.navigateToAdminCustomizeTestStatusPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD );
		Assert.assertTrue(isSuccess,"Not Navigated Successfully to Customize Test Status page.");
		
		isSuccess=zfjNavigator.updateTestExecutionStatus(values);
		Assert.assertTrue(isSuccess,"Test status is not updated successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("bvt3 is executed successfully.");
		
		
	}
	
	@Test(enabled = testEnabled, priority=4)
	public void testBvt4() {
		altID=4;
		CommonUtil.alertMsg("executing bvt4...");
		logger.info("executing bvt4...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("NEW_TEST_EXEC_STATUS", "CANCEL"); // New test status for adding into step status.
		values.put("NEW_TEST_EXEC_STATUS_DESC", "It will cancel the test."); // New test status description for adding into the step status.
		values.put("NEW_TEST_EXEC_STATUS_COLORCODE", "#ff33ff"); // New color code for adding into the test status.
		
		isSuccess = jiraNavigator.navigateToAdminCustomizeTestStatusPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD );
		Assert.assertTrue(isSuccess,"Not Navigated Successfully to Customize Test Status page.");
		
		isSuccess=zfjNavigator.addTestExecutionStatus(values);
		Assert.assertTrue(isSuccess,"New Test status is not added successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("bvt4 is executed successfully.");
		
	}
	@Test(enabled = testEnabled, priority=5)
	public void testBvt5() {
		altID=5;
		CommonUtil.alertMsg("executing bvt5...");
		logger.info("executing bvt5...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("STEP_EXEC_STATUS", "PASS"); // Old Step status for editing and updating.
		values.put("NEW_STEP_EXEC_STATUS", "PASSED"); // New step status used for updating into old status.
		values.put("NEW_STEP_EXEC_STATUS_DESC", "Test step was executed and passed successfully.(edited)"); // New step status description for adding into the new step status.
		
		isSuccess = jiraNavigator.navigateToAdminCustomizeStepStatusPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD );
		Assert.assertTrue(isSuccess,"Not Navigated Successfully to Customize Step Status page.");
		
		isSuccess=zfjNavigator.updateStepExecutionStatus(values);
		Assert.assertTrue(isSuccess,"Step status is not updated successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("Bvt5 is executed successfully.");
		
	}
	@Test(enabled = testEnabled, priority=6)
	public void testBvt6() {
		altID=6;
		CommonUtil.alertMsg("executing bvt6...");
		logger.info("executing bvt6...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("NEW_STEP_EXEC_STATUS", "CANCEL"); // New step status for adding into the step statuses.
		values.put("NEW_STEP_EXEC_STATUS_DESC", "This is cancelled status."); // New Step description for adding into the step status.
		values.put("NEW_STEP_EXEC_STATUS_COLORCODE", "#ff33ff"); // New step status color code for adding into the step status.
		
		isSuccess = jiraNavigator.navigateToAdminCustomizeStepStatusPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD );
		Assert.assertTrue(isSuccess,"Not Navigated Successfully to Customize Step Status page.");
		
		isSuccess=zfjNavigator.addStepExecutionStatus(values);
		Assert.assertTrue(isSuccess,"New Step status is not added successfully.");
		
		isSuccess = jiraNavigator.leavingAdministrationPage();
		Assert.assertTrue( isSuccess, "Leaving from Administration is not successfully." );
		
		logger.info("Bvt6 is executed successfully.");
		
	}
	
	@Test(enabled = testEnabled, priority=7) 
	public void testBvt7() {
		altID=7;
		CommonUtil.alertMsg("executing bvt7...");
		logger.info("executing bvt7...");
		isSuccess=zfjNavigator.verifyZfjTestMenus();
		Assert.assertTrue(isSuccess, "ZFJ test menus validation failed");
		logger.info("Bvt7 executed successfully...");
		
	}
	@Test(enabled = testEnabled, priority=8)
	public void testBvt8(){
		altID=8;
		CommonUtil.alertMsg("executing bvt8...");
		logger.info("executing bvt8...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("SUMMARY", "First Test By Admin"); // summary of the new Test.
		values.put("PRIORITY", "Trivial"); // priority of new Test.
		values.put("COMPONENT", "Component2"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 1.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 1.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "Label3"); //label of new Test.
		
		isSuccess=zfjNavigator.createTest(values);
		Assert.assertTrue(isSuccess, "New Test Creation Failed...");
		logger.info("Bvt8 executed successfully...");
		
		
		/*testKeySet=zfjNavigator.createMultipleTests();
		Assert.assertTrue(testKeySet.size() > 0 , "Creating test size is 0.");
		isSuccess=true;
		logger.info("Bvt8 executed successfully...");*/
		
	}
	
	@Test(enabled = testEnabled, priority=9)  // compatible with JIRA version 5.2.x, 6.1.x and 6.2
	public void testBvt9(){
		altID=9;
		CommonUtil.alertMsg("executing bvt9...");
		logger.info("executing bvt9...");
		isSuccess=jiraNavigator.setFieldVisibilityInCreateIssueDialog("Environment", "Fix Version/s");
		Assert.assertTrue(isSuccess,"Setting Fields Visibility Failed...");
		logger.info("Bvt9 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=10)
	public void testBvt10(){
		altID=10;
		CommonUtil.alertMsg("executing bvt10...");
		logger.info("executing bvt10..");
		
		Map<String, String> values= new HashMap<String, String>();
		//first step.
		values.put("STEP_1", "Test step 1");
		values.put("DATA_1", "Test data 1");
		values.put("EXPECTED_RESULT_1", "Expected result 1");
		//second step.
		values.put("STEP_2", "Test step 2");
		values.put("DATA_2", "Test data 2");
		values.put("EXPECTED_RESULT_2", "Expected result 2");
		//third step.
		values.put("STEP_3", "Test step 3");
		values.put("DATA_3", "Test data 3");
		values.put("EXPECTED_RESULT_3", "Expected result 3");
		//fourth step.
		values.put("STEP_4", "Test step 4");
		values.put("DATA_4", "Test data 4");
		values.put("EXPECTED_RESULT_4", "Expected result 4");
		//fifth step.
		values.put("STEP_5", "Test step 5");
		values.put("DATA_5", "Test data 5");
		values.put("EXPECTED_RESULT_5", "Expected result 5");
		values.put("TOTAL_STEPS","5");
		isSuccess=zfjNavigator.addStepsToTest(values);
		Assert.assertTrue(isSuccess,"Teststeps additin Failed...");
		logger.info("Teststeps added Successfully...");
		
		/*// Creating multiple test cases with test step
		testStepKeySet=zfjNavigator.createMultipleTestsWithStep();
		Assert.assertTrue(testStepKeySet.size() > 0 , "Creating test with test step size is 0.");
		isSuccess=true;
		logger.info("Tests created successfully.");*/
		logger.info("Bvt10 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=11)
	public void testBvt11(){
		altID=11;
		CommonUtil.alertMsg("executing bvt11...");
		logger.info("executing bvt11...");
		isSuccess=zfjNavigator.reArrangeTeststeps(1,3);
		Assert.assertTrue(isSuccess,"Re-Arranging of teststep failed...");
		logger.info("Bvt11 executed successfully...");
		
	}
	@Test(enabled = testEnabled, priority=12)
	public void testBvt12(){
		altID=12;
		CommonUtil.alertMsg("executing bvt12...");
		logger.info("executing bvt12...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("TEST_STEP_TO_EDIT","3");
		values.put("CHANGE_STEP_TO","Test step (edited)");
		values.put("CHANGE_DATA_TO","Test data (edited)");
		values.put("CHANGE_EXPECTED_RESULT_TO","Expected result (edited)");
		isSuccess=zfjNavigator.editTeststeps(values);
		Assert.assertTrue(isSuccess, "Editing Test Step Failed");
		logger.info("Bvt12 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=13)
	public void testBvt13(){
		altID=13;
		CommonUtil.alertMsg("executing bvt13...");
		logger.info("executing bvt13...");
		isSuccess=zfjNavigator.cloneTeststepInsertAfterStep(2);
		Assert.assertTrue(isSuccess,"Appending a Cloned Teststep after a teststep Failed...");
		logger.info("Bvt13 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority= 14)
	public void testBvt14(){
		altID=14;
		CommonUtil.alertMsg("executing bvt14...");
		logger.info("executing bvt14...");
		isSuccess = zfjNavigator.cloneTeststepByEnteringAValidNumber(1, 6);
		Assert.assertTrue(isSuccess,"Inserting a Cloned Teststep at a valid number Failed...");
	}
	
	@Test(enabled = testEnabled, priority=15)
	public void testBvt15(){
		altID=15;
		CommonUtil.alertMsg("executing bvt15...");
		logger.info("executing bvt15...");
		Map<String, String> values = new HashMap<String, String>();
		
		//edit the test details to.
		values.put("CHANGE_SUMMARY_TO","Test by admin(Edited)");
		values.put("CHANGE_PRIORITY_TO", "Major");
		values.put("CHANGE_COMPONENT_TO", "Component1"); // component of new Test.
		values.put("CHANGE_AFFECTED_VERSION_TO", "Version 1.0"); // affected version of new Test.
		values.put("CHANGE_FIX_VERSION_TO", "Version 1.0"); // fix version of new Test.
		values.put("CHANGE_ENVIRONMENT_TO", "kitkat"); //environment of new Test.
		values.put("CHANGE_DESCRIPTION_TO", "check the icon moved"); //description of new Test.
		values.put("CHANGE_LABEL_TO", "Label3"); //label of new Test.
		
		isSuccess=zfjNavigator.editTestDetails(values);
		Assert.assertTrue(isSuccess, "Editing Test Failed...");
		logger.info("Bvt15 executed successfully...");
		
		
	}
	
	@Test(enabled = testEnabled, priority=16)
	public void testBvt16(){
		altID=16;
		CommonUtil.alertMsg("executing bvt16...");
		logger.info("executing bvt16...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("SUMMARY", "Test to be cloned"); // summary of the new Test.
		values.put("PRIORITY", "Major"); // priority of new Test.
		values.put("COMPONENT", "Component2"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 1.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 3.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "Label1"); //label of new Test.
		//first step.
		values.put("STEP_1", "Test step 1");
		values.put("DATA_1", "Test data 1");
		values.put("EXPECTED_RESULT_1", "Expected result 1");
		//second step.
		values.put("STEP_2", "Test step 2");
		values.put("DATA_2", "Test data 2");
		values.put("EXPECTED_RESULT_2", "Expected result 2");
		//third step.
		values.put("STEP_3", "Test step 3");
		values.put("DATA_3", "Test data 3");
		values.put("EXPECTED_RESULT_3", "Expected result 3");
		//fourth step.
		values.put("STEP_4", "Test step 4");
		values.put("DATA_4", "Test data 4");
		values.put("EXPECTED_RESULT_4", "Expected result 4");
		//fifth step.
		values.put("STEP_5", "Test step 5");
		values.put("DATA_5", "Test data 5");
		values.put("EXPECTED_RESULT_5", "Expected result 5");
		values.put("TOTAL_STEPS","5");
		values.put("CHANGE_SUMMARY_TO", "Test cloned");
		isSuccess=zfjNavigator.cloneTest(values);
		Assert.assertTrue(isSuccess,"Test cloning Failed...");
		logger.info("Bvt16 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=17)
	public void testBvt17(){
		altID=17;
		CommonUtil.alertMsg("executing bvt17...");
		logger.info("executing bvt17...");
		Map<String, String> values = new HashMap<String, String>();
		values.put("SUMMARY", "Test one to link to another Test"); // summary of the new Test.
		values.put("PRIORITY", "Major"); // priority of new Test.
		values.put("COMPONENT", "Component1"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 3.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 3.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "Label2"); //label of new Test.
		
		//edit the test details to.
		values.put("SECOND_SUMMARY","Test two to link to another Test");
		values.put("SECOND_PRIORITY", "Major");
		values.put("SECOND_COMPONENT", "Component3"); // component of new Test.
		values.put("SECOND_AFFECTED_VERSION", "Version 3.0"); // affected version of new Test.
		values.put("SECOND_FIX_VERSION", "Version 3.0"); // fix version of new Test.
		values.put("SECOND_ENVIRONMENT", "kitkat"); //environment of new Test.
		values.put("SECOND_DESCRIPTION", "check the icon moved"); //description of new Test.
		values.put("SECOND_LABEL", "Label3"); //label of new Test.
		values.put("LINKS","blocks");
		values.put("COMMENT","issue is blocked");
		
		isSuccess=zfjNavigator.linkTestToAnotherTest(values);	
		Assert.assertTrue(isSuccess,"Test linking failed...");
		logger.info("Bvt17 executed successfully...");
		
	}
	@Test(enabled = testEnabled, priority=18)
	public void testBvt18(){
		altID=18;
		CommonUtil.alertMsg("executing bvt18...");
		logger.info("executing bvt18");
		Map<String, String> values= new HashMap<String, String>();
		
		//first set of test and issue to be linked.
		values.put("TEST_SUMMARY", "Test to be linked to Task"); // summary of the new Test.
		values.put("TEST_PRIORITY", "Major"); // priority of new Test.
		values.put("ISSUE_SUMMARY","Task to be linked to Test");
		values.put("ISSUE_TYPE","Task");
		values.put("LINKS","clones");
		values.put("COMMENT","clones the issue");
		Assert.assertTrue(zfjNavigator.createTest(values.get("TEST_SUMMARY"), values.get("TEST_PRIORITY")));
		Assert.assertNotNull(jiraNavigator.createIssue(values.get("ISSUE_SUMMARY"), values.get("ISSUE_TYPE")));
		Assert.assertTrue(zfjNavigator.linkTestToissue(values),"Linking Test to Issue Failed...");
		logger.info("--------------------------------");
		//second set of test and issue to be linked.
		values.put("TEST_SUMMARY","Test to be linked to Bug");
		values.put("TEST_PRIORITY", "Blocker");
		values.put("ISSUE_SUMMARY","Bug to be linked to Test");
		values.put("ISSUE_TYPE","Bug");
		values.put("LINKS","blocks");
		values.put("COMMENT","issue is blocked");
		Assert.assertTrue(zfjNavigator.createTest(values.get("TEST_SUMMARY"), values.get("TEST_PRIORITY")));
		Assert.assertNotNull(jiraNavigator.createIssue(values.get("ISSUE_SUMMARY"), values.get("ISSUE_TYPE")));
		Assert.assertTrue(zfjNavigator.linkTestToissue(values),"Linking Test to Issue Failed...");
		logger.info("--------------------------------");
		//third set of test and issue to be linked.
		values.put("TEST_SUMMARY","Test to be linked to New Feature");
		values.put("TEST_PRIORITY", "Major");
		values.put("ISSUE_SUMMARY","New Feature to be linked to Test");
		values.put("ISSUE_TYPE","New Feature");
		values.put("LINKS","relates to");
		values.put("COMMENT","issue relates to");
		Assert.assertTrue(zfjNavigator.createTest(values.get("TEST_SUMMARY"), values.get("TEST_PRIORITY")));
		Assert.assertNotNull(jiraNavigator.createIssue(values.get("ISSUE_SUMMARY"), values.get("ISSUE_TYPE")));
		Assert.assertTrue(zfjNavigator.linkTestToissue(values),"Linking Test to Issue Failed...");
		logger.info("--------------------------------");
		//fourth set of test and issue to be linked.
		values.put("TEST_SUMMARY","Test to be linked to Improvement");
		values.put("TEST_PRIORITY", "Minor");
		values.put("ISSUE_SUMMARY","verified the data connection");
		values.put("ISSUE_TYPE","Improvement");
		values.put("LINKS","duplicates");
		values.put("COMMENT","issue is duplicated");
		Assert.assertTrue(zfjNavigator.createTest(values.get("TEST_SUMMARY"), values.get("TEST_PRIORITY")));
		Assert.assertNotNull(jiraNavigator.createIssue(values.get("ISSUE_SUMMARY"), values.get("ISSUE_TYPE")));
		isSuccess=zfjNavigator.linkTestToissue(values);
		Assert.assertTrue(isSuccess,"Linking Test to Issue Failed...");
		logger.info("Bvt18 executed successfully...");
		
			
	}
	@Test(enabled = testEnabled, priority=19)
	public void testBvt19(){
		altID=19;
		CommonUtil.alertMsg("executing bvt19...");
		logger.info("executing bvt19");
		isSuccess=zfjNavigator.searchTestByKeyword();	
		Assert.assertTrue(isSuccess,"Search for Test Failed... ");
		logger.info("Bvt19 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=20) 
	public void testBvt20(){
		altID = 20;
		CommonUtil.alertMsg("executing bvt20...");
		logger.info("executing bvt20");
		Map<String, String> values= new HashMap<String, String>();
		values.put("SUMMARY", "Test created to validate Exported"); // summary of the new Test.
		values.put("PRIORITY", "Critical"); // priority of new Test.
		values.put("COMPONENT", "Component3"); // component of new Test.
		values.put("AFFECTED_VERSION", "Version 1.0"); // affected version of new Test.
		values.put("FIX_VERSION", "Version 1.0"); // fix version of new Test.
		values.put("ENVIRONMENT", "jelly bean"); //environment of new Test.
		values.put("DESCRIPTION", "check the wifi device"); //description of new Test.
		values.put("LABEL", "wifi"); //label of new Test.
		//first step.
		values.put("STEP_1", "Test step 1");
		values.put("DATA_1", "Test data 1");
		values.put("EXPECTED_RESULT_1", "Expected result 1");
		//second step.
		values.put("STEP_2", "Test step 2");
		values.put("DATA_2", "Test data 2");
		values.put("EXPECTED_RESULT_2", "Expected result 2");
		//third step.
		values.put("STEP_3", "Test step 3");
		values.put("DATA_3", "Test data 3");
		values.put("EXPECTED_RESULT_3", "Expected result 3");
		values.put("TOTAL_STEPS","3");
		Assert.assertTrue(zfjNavigator.createTest(values), "Test Creation Failed");
		isSuccess=zfjNavigator.addStepsToTest(values);
		Assert.assertTrue(isSuccess,"Teststeps additin Failed...");
		isSuccess=zfjNavigator.exportTestFromIssueNavigator();
		Assert.assertTrue(isSuccess,"Exporting of Test from IssueNavigator Failed...");
		logger.info("Bvt20 executed successfully...");
		
	}
		
	@Test(enabled = testEnabled, priority=21)
	public void testBvt21() {
		altID=21;
		CommonUtil.alertMsg("executing bvt21...");
		logger.info("executing bvt21...");
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
		//values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		//isSuccess=zfjNavigator.deleteTest(testKeySet.get("Test to be Delete"));	
		isSuccess=zfjNavigator.deleteTest(listOfExecTest.get(listOfExecTest.size() - 1));
		Assert.assertTrue(isSuccess,"Deleting test is not successfully.");
		listOfExecTest.clear();
		logger.info("Bvt21 is executed successfully.");
	}
	
	@Test(enabled = testEnabled, priority=22)
	public void testBvt22() {
		altID=22;
		CommonUtil.alertMsg("executing bvt22...");
		logger.info("executing bvt22...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	// Cycle is used for creating and selecting a cycle in zfj.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		//values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		values.put("CYCLE_START_DATE", "11/December/2014");
		values.put("BUILD_NAME", "build 1.0");
		values.put("ENVIROMENT_NAME", "Env-1");
		
		isSuccess=zfjNavigator.createTestCycle(values);	
		Assert.assertTrue(isSuccess,"Creating cycle is not successfully.");
		//logger.info("Bvt22 is executed successfully.");
		
		Map<String, String> valuesUserMap = new HashMap<String, String>();
		valuesUserMap.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		valuesUserMap.put("CYCLE_NAME", "User Cycle");	// Cycle is used for creating and selecting a cycle in zfj.
		valuesUserMap.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		valuesUserMap.put("CYCLE_START_DATE", "22/January/2014");	// Cycle start date is used for selecting the start date while creating the cycle.
		
		isSuccess=zfjNavigator.createTestCycle(valuesUserMap);	
		Assert.assertTrue(isSuccess,"Creating cycle is not successfully.");
		logger.info("Bvt22 is executed successfully.");
		
	}
	
@Test(enabled = testEnabled, priority=23)
	public void testBvt23() {
		altID=23;
		CommonUtil.alertMsg("executing bvt23...");
		logger.info("executing bvt23...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		//values.put("TEST_NAME", testKeySet.get("First test for add"));	// Here Test is used to add indivisually into the cycle.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "11/December/2013");	// Cycle start date is used for selecting the start date while creating the cycle.
		values.put("SUMMARY", "This is a test.");	// Test summary to create a test.
		values.put("PRIORITY", "Major");	// The priority value which will need while creating atest.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.addTestToCycle(values);	
		Assert.assertTrue(isSuccess,"Adding tests into cycle is not successfully.");
		logger.info("Bvt23 is executed successfully.");
		
	}
	@Test(enabled = testEnabled, priority=24)
	public void testBvt24() {
		altID=24;
		CommonUtil.alertMsg("executing bvt24...");
		logger.info("executing bvt24...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		//values.put("TEST_NAME", testKeySet.get("First test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "PASSED");	// Test status which is used to set the status while executing a test.
		values.put("SUMMARY", "This is a test.");	// Test summary to create a test.
		values.put("PRIORITY", "Major");	// The priority value which will need while creating atest.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.executeTest(values);	
		//Assert.assertTrue(zfjNavigator.addTestToCycle(values),"Adding test into cycle is not executed successfully.");
		Assert.assertTrue(isSuccess, "Test is not executed successfully.");
		logger.info("Bvt24 is executed successfully.");
		
	}
	
	@Test(enabled = testEnabled, priority=25)
	public void testBvt25() {
		altID=25;
		CommonUtil.alertMsg("executing bvt25...");
		logger.info("executing bvt25...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		//values.put("TEST_NAME",  testKeySet.get("Second test for execute test status")); // Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "FAIL");	// Test status which is used to set the status while executing a test.
		values.put("ISSUE_SUMMARY", "This is a issue.");	// This is the issue summary which is used for creating an issue.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.addTestToCycle(values);	
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeTestWithDefect(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt25 is executed successfully.");
		
	}
	@Test(enabled = testEnabled, priority=26)
	public void testBvt26() {
		altID=26;
		CommonUtil.alertMsg("executing bvt26...");
		logger.info("executing bvt26...");
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		//values.put("TEST_NAME", testStepKeySet.get("First Test with Test step"));	// Here Test is used to add and execute in the cycle.
		values.put("STEP_EXEC_STATUS_ONE", "PASSED");	// Step status one which is used to set the status while executing a test.
		values.put("STEP_EXEC_STATUS_TWO", "FAIL");	// Step status two which is used to set the status while executing a test.
		values.put("STEP_EXEC_STATUS_THREE", "WIP");	// Step status three which is used to set the status while executing a test.
		values.put("STEP_EXEC_STATUS_FOUR", "BLOCKED");	// Step status four which is used to set the status while executing a test.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test step");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.addTestToCycle(values);
		Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
		isSuccess=zfjNavigator.executeSteps(values);
		Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
		logger.info("Bvt26 is executed successfully.");
		
	}
	
	@Test(enabled = testEnabled, priority=27)
	public void testBvt27() {
	altID=27;
	CommonUtil.alertMsg("executing bvt27...");
	logger.info("executing bvt27...");
	
	Map<String, String> values = new HashMap<String, String>();
	values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
	values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
	//values.put("TEST_NAME", testStepKeySet.get("Second Test with Test step"));	// Here Test is used to add and execute in the cycle.
	values.put("STEP_EXEC_STATUS", "FAIL");	// Step status for execution which is used to set the status while executing a test.
	values.put("TEST_STEP_NUM", "5"); // Test step to execute.
	values.put("ISSUE_SUMMARY", "This is a issue.");	// This is the issue summary which is used for creating an issue.
	
	listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test step");
	values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
	
	isSuccess=zfjNavigator.addTestToCycle(values);	
	Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
	isSuccess=zfjNavigator.executeStepWithDefect(values);
	Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
	logger.info("Bvt27 is executed successfully.");
	
	}
	
	@Test(enabled = testEnabled, priority=28)
	public void testBvt28() {
	altID=28;
	CommonUtil.alertMsg("executing bvt28...");
	logger.info("executing bvt28...");
	
	Map<String, String> values = new HashMap<String, String>();
	values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
	values.put("CYCLE_NAME", "Cycle Two");	//	Here cycle is used for selecting a cycle in zfj.
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
	values.put("TEST_FOUR_EXEC_STATUS", "BLOCKED");	// Test status which is used to set the status while executing a test.
	
	
	/*isSuccess=zfjNavigator.createTestCycle(values);	
	Assert.assertTrue(isSuccess,"Creating cycle is not successfully.");*/
	isSuccess=zfjNavigator.addTestsMultipleAndExecute(values);	
	Assert.assertTrue(isSuccess,"Adding tests multiple into cycle is not executed successfully.");
	logger.info("Bvt28 is executed successfully.");
	
	}
	
	@Test(enabled = testEnabled, priority=29)
	public void testBvt29() {
	altID=29;
	CommonUtil.alertMsg("executing bvt29...");
	logger.info("executing bvt29...");
	
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
	logger.info("Bvt29 is executed successfully.");
	
	}
	
	@Test(enabled = testEnabled, priority=30)
	public void testBvt30() {
	altID=30;
	CommonUtil.alertMsg("executing bvt30...");
	logger.info("executing bvt30...");
	
	Map<String, String> values = new HashMap<String, String>();
	values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
	values.put("OLD_CYCLE_NAME", "Cycle One");	// This contains cycle name from where we can get the tests with associate defects.
	values.put("CYCLE_NAME", "Cycle Four");	// Cycle is used for creating and selecting a cycle in zfj.
	values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
	values.put("CYCLE_START_DATE", "15/May/2014");	// Cycle start date is used for selecting the start date while creating the cycle.
	
	isSuccess=zfjNavigator.createTestCycle(values);	
	Assert.assertTrue(isSuccess,"Cycle is not created successful.");
	isSuccess=zfjNavigator.addTestsFromOtherCycle(values);
	Assert.assertTrue(isSuccess, "Add Test From other cycle is not successful.");
	logger.info("Bvt30 is executed successfully.");
	
	}
@Test(enabled = testEnabled, priority=31)
public void testBvt31() {
	altID=31;
	CommonUtil.alertMsg("executing bvt31...");
	logger.info("executing bvt31...");
	
	Map<String, String> values = new HashMap<String, String>();
	values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
	values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
	//values.put("TEST_NAME", testKeySet.get("Third test for execute test status"));	// Here Test is used to add and execute in the cycle.
	values.put("TEST_EXEC_STATUS", "CANCEL");	// Test status which is used to set the status while executing a test.
	
	listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
	values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
	
	isSuccess=zfjNavigator.addTestToCycle(values);	
	Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
	isSuccess=zfjNavigator.executeTest(values);	
	Assert.assertTrue(isSuccess, "Test is not executed successfully.");
	logger.info("Bvt31 is executed successfully.");
	
}
	
	@Test(enabled = testEnabled, priority=32)
	public void testBvt32() {
	altID=32;
	CommonUtil.alertMsg("executing bvt32...");
	logger.info("executing bvt32...");
	
	Map<String, String> values = new HashMap<String, String>();
	values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
	values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
	//values.put("TEST_NAME", testStepKeySet.get("Third Test with Test step"));	// Here Test is used to add and execute in the cycle.
	values.put("STEP_EXEC_STATUS", "CANCEL");	// Step status one which is used to set the status while executing a test.
	values.put("STEP_NUM", "1");	// Step number for execution.
	
	listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test step");
	values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
	
	isSuccess=zfjNavigator.addTestToCycle(values);	
	Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
	isSuccess=zfjNavigator.executeStep(values);	
	Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
	logger.info("Bvt32 is executed successfully.");
	
	}
	
	@Test(enabled = testEnabled, priority=33)
	public void testBvt33() {
	altID=33;
	CommonUtil.alertMsg("executing bvt33...");
	logger.info("executing bvt33...");
	Map<String, String> values = new HashMap<String, String>();
	values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
	values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
	//values.put("TEST_NAME", testStepKeySet.get("Fourth Test with Test step"));	// Here Test is used to add and execute in the cycle.
	values.put("STEP_EXEC_STATUS", "PASSED");	// Step status one which is used to set the status while executing a test.
	values.put("NUM_OF_STEPS_EXEC", "5"); 	// Total number of tests to execute.
	
	listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test step");
	values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
	
	isSuccess=zfjNavigator.addTestToCycle(values);	
	Assert.assertTrue(isSuccess,"Adding test into cycle is not executed successfully.");
	isSuccess=zfjNavigator.executeAllSteps(values);	
	Assert.assertTrue(isSuccess, "Executing test with defect is not executed successfully.");
	logger.info("Bvt33 is executed successfully.");
	
	}
	@Test(enabled = testEnabled, priority=34)
	public void testBvt34() {
	altID=34;
	CommonUtil.alertMsg("executing bvt34...");
	logger.info("executing bvt34...");
	
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
	logger.info("Bvt34 is executed successfully.");
	
	}
	
	@Test(enabled = testEnabled, priority=35)
	public void testBvt35() {
	altID=35;
	CommonUtil.alertMsg("executing bvt35...");
	logger.info("executing bvt35...");
	
	Map<String, String> values = new HashMap<String, String>();
	values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
	values.put("CYCLE_NAME", "Cycle One");	// Cycle is used for creating and selecting a cycle in zfj.
	values.put("CYCLE_START_DATE", "11/December/2014");
	values.put("BUILD_NAME", "build 1.0");
	values.put("ENVIROMENT_NAME", "Env-1");
	
	isSuccess=zfjNavigator.exportCycle(values);	
	Assert.assertTrue(isSuccess,"Test Cycle is not exported successfully.");
	logger.info("Bvt35 is executed successfully.");
	
}

	@Test(enabled = testEnabled, priority=36)
	public void testBvt36(){
		altID=36;
		CommonUtil.alertMsg("executing bvt36...");
		logger.info("executing bvt36...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	// Cycle is used for creating and selecting a cycle in zfj.
		values.put("CLONE_CYCLE_NAME", "Cycle One");	// Cycle is used for creating and selecting a cycle in zfj.
		values.put("CYCLE_DESC", "This is description part."); // Cycle description is used for creating the cycle in zfj.
		values.put("CYCLE_START_DATE", "7/January/2014");	// Cycle start date is used for selecting the start date while creating the cycle.
		values.put("TEST_SUMMARY", "Enable the wifi and check for network"); // summary of the new Test.
		values.put("TEST_PRIORITY", "Critical"); // priority of new Test.
				
		isSuccess=zfjNavigator.cloneTestCycle(values);	
		Assert.assertTrue(isSuccess, "Test cycle cloning Failed...");
		logger.info("Bvt36 executed successfully...");	
	}
	@Test(enabled = testEnabled, priority=37)
	public void testBvt37(){
		altID=37;
		CommonUtil.alertMsg("executing bvt37...");
		logger.info("executing bvt37...");
		
		isSuccess = zfjNavigator.searchVersion("Version 3.0");
		Assert.assertTrue(isSuccess, "Validating IssueLink Failed... ");
		logger.info("Bvt37 executed successfully...");
		
	}
	@Test(enabled = testEnabled, priority=38)
	public void testBvt38(){
		altID=38;
		CommonUtil.alertMsg("executing bvt38...");
		logger.info("executing bvt38...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("PREDEFINED_FILTER_NAME_ONE", "My Executed Tests");	// Name of the predefined filter one
		values.put("PREDEFINED_FILTER_NAME_TWO", "My Failed Executions");	// Name of the predefined filter two
		values.put("PREDEFINED_FILTER_NAME_THREE", "All Unexecuted Tests");	// Name of the predefined filter three
		values.put("PREDEFINED_FILTER_NAME_FOUR", "All Executed Tests");	// Name of the predefined filter four
		values.put("PREDEFINED_FILTER_NAME_FIVE", "All Failed Executions");	// Name of the predefined filter five
		
		isSuccess=zfjNavigator.executePredefinedFilters(values);
		Assert.assertTrue(isSuccess, "Execution of predefined filters failed.");
		logger.info("Bvt38 executed successfully...");
	}
	@Test(enabled = testEnabled, priority=39)
	public void testBvt39(){
		altID=39;
		CommonUtil.alertMsg("executing bvt39...");
		logger.info("executing bvt39...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("FIX_VERSION_NAME", "Version 1.0");	// Name of the version of the project.
		values.put("FIX_VERSION_ZQLQUERY", "fixVersion = \"Version 1.0\"");	// ZQL Query for fixed version.
		
		isSuccess=zfjNavigator.executeZQLQueryForFixVersion(values);
		Assert.assertTrue(isSuccess, "Execution of zql query for fixed version failed.");
		logger.info("Bvt39 executed successfully...");
	}
	@Test(enabled = testEnabled, priority=40)
	public void testBvt40(){
		altID=40;
		CommonUtil.alertMsg("executing bvt40...");
		logger.info("executing bvt40...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("FIX_VERSION_NAME", "Version 1.0");	// Name of the version of the project.
		values.put("ZQLQUERY", "fixVersion = \"Version 1.0\"");	// ZQL Query for fixed version.
		values.put("EXECUTION_FILTER_NAME", "ExecFilter1");	// Execution filter name for saving the filter.
		
		isSuccess=zfjNavigator.createExecFilterAndSaveToFavourite(values);
		Assert.assertTrue(isSuccess, "Create filter and save to filter failed.");
		logger.info("Bvt40 executed successfully...");
	}
	@Test(enabled = testEnabled, priority=41)
	public void testBvt41(){
		altID=41;
		CommonUtil.alertMsg("executing bvt41...");
		logger.info("executing bvt41...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("EXECUTION_FILTER_NAME", "ExecFilter1");	// Execution filter name for searching the filter.
		
		isSuccess=zfjNavigator.searchExecutionFilter(values);
		Assert.assertTrue(isSuccess, "Searching filter failed.");
		logger.info("Bvt 41 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=42)
	public void testBvt42(){
		altID=42;
		CommonUtil.alertMsg("executing bvt42...");
		logger.info("executing bvt42...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("FILTER_NAME", "All Unexecuted Tests");	// Name of the filter
		values.put("ZQL_QUERY", "executionStatus in (UNEXECUTED, PASSED, FAIL, WIP)  AND cycleName = \"Cycle One\"");
		values.put("PROJECT_NAME", Config.getValue("JIRA_PROJECT"));	// Name of the project
		values.put("VERSION_NAME", "Version 1.0");	// Name of the version
		values.put("CYCLE_NAME", "Cycle One");	// Name of the cycle.
		values.put("TEST_ONE", "DELL-24");	// Name of the testcase one.
		values.put("TEST_TWO", "DELL-12");	// Name of the testcase two.
		values.put("TOTAL_TEST_TO_EXPORT", "2");	// Total tests to be export.
		values.put("TOTAL_TEST_STEP", "2");	// Total test steps to be exported.
		
		isSuccess=zfjNavigator.exportTestExecutions(values);
		Assert.assertTrue(isSuccess, "Tests are exported successfully from execution navigator.");
		logger.info("Bvt 42 executed successfully...");
	}
	@Test(enabled = testEnabled, priority=43)
	public void testBvt43(){
		altID=43;
		CommonUtil.alertMsg("executing bvt43...");
		logger.info("executing bvt43...");
		
		isSuccess = zfjNavigator.customizeColumnDisplayEN("All Executed Tests", "predefined");
		Assert.assertTrue(isSuccess, "Switching view from Execution Navigator is not Successful.");
		logger.info("Bvt43 executed successfully...");
	}
	@Test(enabled = testEnabled, priority=44)
	public void testBvt44(){
		altID=44;
		CommonUtil.alertMsg("executing bvt44...");
		logger.info("executing bvt44...");
		
		isSuccess = zfjNavigator.restoreDefualtsColumnInEN("All Executed Tests", "predefined");
		Assert.assertTrue(isSuccess, "Switching view from Execution Navigator is not Successful.");
		logger.info("Bvt44 executed successfully...");
		
	}
	@Test(enabled = testEnabled, priority=45)
	public void testBvt45(){
		altID=45;
		CommonUtil.alertMsg("executing bvt45...");
		logger.info("executing bvt45...");
		
		isSuccess = zfjNavigator.switchViewFromEN("list view", "detailed view");
		Assert.assertTrue(isSuccess, "Switching view from Execution Navigator is not Successful.");
		logger.info("Bvt45 executed successfully...");
		
	}
	@Test(enabled = testEnabled, priority=46)
	public void testBvt46(){
		altID=46;
		CommonUtil.alertMsg("executing bvt46...");
		logger.info("executing bvt46...");
		//"All Executed Tests"
		isSuccess = zfjNavigator.navigatePageInDetailediew("project = "+Config.getValue("JIRA_PROJECT")+"","custom");
		Assert.assertTrue(isSuccess, "Validating IssueLink Failed... ");
		logger.info("Bvt46 executed successfully...");
		
	}
	@Test(enabled = testEnabled, priority=47)
	public void testBvt47(){
		altID=47;
		CommonUtil.alertMsg("executing bvt47...");
		logger.info("executing bvt47...");
		
		isSuccess = zfjNavigator.navigateTestUsingPrevAndNextInDetailediew("All Executed Tests");
		Assert.assertTrue(isSuccess, "Switching view from Execution Navigator is not Successful.");
		logger.info("Bvt47 executed successfully...");
		
	}
	@Test(enabled = testEnabled, priority=48)
	public void testBvt48(){
		altID=48;
		CommonUtil.alertMsg("executing bvt48...");
		logger.info("executing bvt48...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("ZQL_QUERY", "project = \""+Config.getValue("JIRA_PROJECT")+"\" AND fixVersion = \"Version 1.0\" AND cycleName in (\"Cycle One\")");	// Name of the filter.
		values.put("PROJECT_NAME", Config.getValue("JIRA_PROJECT"));	// Name of the project.
		values.put("VERSION_NAME", "Version 1.0");	// Name of the version.
		values.put("CYCLE_NAME", "Cycle One");	//	Name of the cycle.
		//values.put("TEST_NAME", testKeySet.get("Fourth test for execute test status"));	// Name of the test.
		values.put("TEST_EXEC_STATUS", "BLOCKED");	// Name of the status to be execute.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test step");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.executeTestInDetailViewFromExecutionNavigator(values);
		Assert.assertTrue(isSuccess, "Test is not executes from execution navigator.");
		logger.info("Bvt48 executed successfully...");
	}

	@Test(enabled = testEnabled, priority=49)
	public void testBvt49(){
		altID=49;
		CommonUtil.alertMsg("executing bvt49...");
		logger.info("executing bvt49...");
		
		isSuccess = zfjNavigator.navigateTestInFSUsingPrevAndNextInDetailedview("All Executed Tests");
		Assert.assertTrue(isSuccess, "Switching view from Execution Navigator is not Successful.");
		logger.info("Bvt49 executed successfully...");
		
	}
	
	
	
	@Test(enabled = testEnabled, priority=50)
	public void testBvt50(){
		altID=50;
		CommonUtil.alertMsg("executing bvt50...");
		logger.info("executing bvt50...");
		isSuccess=zfjNavigator.changeBulkTestsStatus("blocked",3);
		Assert.assertTrue(isSuccess, "Bulk Tests status changed Failed...");
		logger.info("Bvt50 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=51)
	public void  testBvt51(){
		altID=51;
		CommonUtil.alertMsg("executing bvt51...");
		logger.info("executing bvt51...");
		isSuccess=zfjNavigator.changeBulkTestsStatusWithTeststeps("wip", "fail", 3);
		Assert.assertTrue(isSuccess, "Bulk Tests status changed With teststeps Failed...");
		logger.info("Bvt51 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=52)
	public void testBvt52(){
		altID=52;
		CommonUtil.alertMsg("executing bvt52...");
		logger.info("executing bvt52...");
		String bugId = jiraNavigator.createIssue("Defect to Associate in Bulk change status with defect not carried", "Bug");
		isSuccess=zfjNavigator.changeBulkTestStatusToUnexecutedWithDefectsCleared(bugId, 3);
		Assert.assertTrue(isSuccess, "Bulk Tests status changed with defects cleared Failed...");
		logger.info("Bvt52 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=53)
	public void testBvt53(){
		altID=53;
		CommonUtil.alertMsg("executing bvt53...");
		logger.info("executing bvt53...");
		String bugId = jiraNavigator.createIssue("Defect to Associate in Bulk move with defect carried", "Bug");
		isSuccess=zfjNavigator.bulkMoveTestsToCycleWithDefects("Version 1.0", "cycles_Tests",bugId, 3);
		Assert.assertTrue(isSuccess, "Bulk Tests Move to cycle with defects Failed...");
		logger.info("Bvt53 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=54)
	public void testBvt54(){
		altID=54;
		CommonUtil.alertMsg("executing bvt54...");
		logger.info("executing bvt54...");
		String bugId = jiraNavigator.createIssue("Defect to Associate in Bulk move with defect not carried", "Bug");
		isSuccess=zfjNavigator.bulkMoveTestToCycleWithDefectsAndStatusNotCarried("Version 2.0","cycleOne",bugId, 2);
		Assert.assertTrue(isSuccess, "Bulk Tests Move to cycle with defects and status not carried Failed...");
		logger.info("Bvt54 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=55)
	public void testBvt55(){
		altID=55;
		CommonUtil.alertMsg("executing bvt55...");
		logger.info("executing bvt55...");
		String bugId = jiraNavigator.createIssue("Defect to Associate in Bulk copy with defect not carried", "Bug");
		isSuccess=zfjNavigator.bulkCopyTestToCycleWithDefectsAndStatusNotCarried("Version 2.0","cycleTests",bugId, 2);
		Assert.assertTrue(isSuccess,"Bulk Tests Copy to cycle with defects and status not carried Failed...");
		logger.info("Bvt55 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=56)
	public void testBvt56(){
		altID=56;
		CommonUtil.alertMsg("executing bvt56...");
		logger.info("executing bvt56");
		String bugId = jiraNavigator.createIssue("Defect to Associate in Bulk", "Bug");
		isSuccess=zfjNavigator.bulkAssociateDefect(bugId,2);
		Assert.assertTrue(isSuccess,"Bulk AssociateDefect To Test Failed...");
		logger.info("Bvt56 executed successfully...");
	}
			

	
	@Test(enabled = testEnabled, priority=57)
	public void testBvt57(){
		altID=57;
		CommonUtil.alertMsg("executing bvt57...");
		logger.info("executing bvt47...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("ZQLQUERY", "fixVersion = \"Version 1.0\"");	// ZQL Query for executing the query.
		values.put("NUM_OF_TESTS", "1"); //Number of tests to be delete
		
		isSuccess=zfjNavigator.deleteExecutions(values);
		Assert.assertTrue(isSuccess, "Test executions are not deleted successfully.");
		logger.info("Bvt 57 executed successfully...");
	}
	@Test(enabled = testEnabled, priority=58)
	public void testBvt58(){
		altID=58;
		CommonUtil.alertMsg("executing bvt58...");
		logger.info("executing bvt 58...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("ZQL_QUERY", "project = \""+Config.getValue("JIRA_PROJECT")+"\" AND fixVersion = \"Version 1.0\" AND cycleName in (\"Cycle One\")");	// Name of the filter.
		values.put("PROJECT_NAME", Config.getValue("JIRA_PROJECT"));	// Name of the project.
		values.put("VERSION_NAME", "Version 1.0");	// Name of the version.
		values.put("CYCLE_NAME", "Cycle One");	//	Name of the cycle.
		//values.put("TEST_NAME", testKeySet.get("Fourth test for execute test status"));	// Name of the test.
		values.put("TEST_EXEC_STATUS", "BLOCKED");	// Name of the status to be execute.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.executeTestFromExecutionNavigator(values);
		Assert.assertTrue(isSuccess, "Test is not executes from execution navigator.");
		logger.info("Bvt 58 executed successfully...");
	}
	@Test(enabled = testEnabled, priority=59)
	public void testBvt59(){
		altID=59;
		CommonUtil.alertMsg("executing bvt59...");
		logger.info("executing bvt 59...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("ZQL_QUERY", "project = \""+Config.getValue("JIRA_PROJECT")+"\" AND fixVersion = \"Version 1.0\" AND cycleName in (\"Cycle One\")");
		values.put("PROJECT_NAME", Config.getValue("JIRA_PROJECT"));
		values.put("VERSION_NAME", "Version 1.0");	// Version is used for selecting the version in jira.
		values.put("CYCLE_NAME", "Cycle One");	//	Here cycle is used for selecting a cycle in zfj.
		values.put("TEST_NAME", testKeySet.get("Fifth test for execute test status"));	// Here Test is used to add and execute in the cycle.
		values.put("TEST_EXEC_STATUS", "WIP");	// Test status which is used to set the status while executing a test.
		
		listOfExecTest=zfjNavigator.getTest(listOfExecTest, "test");
		values.put("TEST_NAME", listOfExecTest.get(listOfExecTest.size() - 1));
		
		isSuccess=zfjNavigator.executeTestDirectlyFromExecutionNavigator(values);
		Assert.assertTrue(isSuccess, "Test is not executes directly from execution navigator.");
		logger.info("Bvt 59 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=60)
	public void testBvt60(){
		altID=60;
		CommonUtil.alertMsg("executing bvt60...");
		logger.info("executing bvt 60...");
		Map<String, String> values= new HashMap<String, String>();
		values.put("ZQLQUERY", "fixVersion = \"Version 1.0\"");	// ZQL Query to be execute.
		values.put("EXECUTION_FILTER_NAME", "ExecFilter3"); // Name of the filter.
		
		isSuccess=zfjNavigator.searchExecFilterInManageExecFilter(values);
		Assert.assertTrue(isSuccess, "Search execution filter is not searching in manage execute filter.");
		logger.info("Bvt60 executed successfully...");
	}
	

	@Test(enabled = testEnabled, priority=61)
	public void testBvt61(){
		altID=61;
		CommonUtil.alertMsg("executing bvt61...");
		logger.info("executing bvt61...");
		isSuccess=zfjNavigator.viewAndDrillDownTestSummary();
		Assert.assertTrue(isSuccess, "Test Summary validation Failed...");
		logger.info("Bvt61 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=62)
	public void testBvt62(){
		altID=62;
		CommonUtil.alertMsg("executing bvt62...");
		logger.info("executing bvt62...");
		isSuccess=zfjNavigator.viewTestSummaryCharts();
		Assert.assertTrue(isSuccess,"Test Summary Charts validation Failed...");
		logger.info("Bvt62 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=63)
	public void testBvt63(){
		altID=63;
		CommonUtil.alertMsg("executing bvt63...");
		logger.info("executing bvt63...");
		isSuccess=zfjNavigator.launchTestMatricsAndDispalysCreationAndExecutionGadgets();	
		Assert.assertTrue(isSuccess,"Test Creation And Execution Validation Failed");
		logger.info("Bvt63 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=64)
	public void testBvt64(){
		altID=64;
		CommonUtil.alertMsg("executing bvt64...");
		logger.info("executing bvt54...");

		isSuccess=zfjNavigator.addTopDefectGadget();	
		Assert.assertTrue(isSuccess,"Adding Top Defect Gadget Failed...");
		logger.info("Bvt64 executed successfully...");

		
	}
	@Test(enabled= testEnabled, priority=65)
	public void testBvt65(){
		altID=65;
		CommonUtil.alertMsg("executing bvt65...");
		logger.info("executing bvt65...");
		isSuccess=zfjNavigator.addExecutionBurndownGadget();	
		Assert.assertTrue(isSuccess,"Adding Test Execution Burndown Gadget Failed...");
		logger.info("Bvt65 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=66)
	public void testBvt66(){
		altID=66;
		CommonUtil.alertMsg("executing bvt66...");
		logger.info("executing bvt66...");
		isSuccess=zfjNavigator.addTestExecutionDetailsGadget();
		Assert.assertTrue(isSuccess,"Adding Test Execution Details Gadget Failed...");
		logger.info("Bvt66 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority= 67)
	public void testBvt67(){
		altID=67;
		CommonUtil.alertMsg("executing bvt67...");
		logger.info("executing bvt67...");
		isSuccess=zfjNavigator.customizeColumnsInZqlGadget("Issue Key", "Cycle Name");
		Assert.assertTrue(isSuccess,"Customising columns in  Execution Details Gadget Failed...");
		logger.info("Bvt67 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=68)
	public void testBvt68(){
		altID=68;
		CommonUtil.alertMsg("executing bvt68...");
		logger.info("executing bvt68...");
		Map<String, String> values = new HashMap<String, String>();
		
		values.put("GADGET", "Execution Details");
		values.put("SEARCHBY", "Free form ZQL");
		values.put("ZQL_QUERY","project = "+"\""+Config.getValue("JIRA_PROJECT")+"\"");
		values.put("GROUPBY","5");
		isSuccess=zfjNavigator.editGadget(values);	
		Assert.assertTrue(isSuccess,"Editing "+values.get("GADGET")+" Gadget Failed...");
		logger.info(values.get("GADGET")+" Gagdet Edited Successfully...");
		
		
		values.put("GADGET", "Test Execution Burndown");
		values.put("PROJECT",Config.getValue("JIRA_PROJECT"));
		values.put("VERSION","Version 1.0");
		values.put("GROUPBY","Cycle One");
		isSuccess=zfjNavigator.editGadget(values);	
		Assert.assertTrue(isSuccess,"Editing "+values.get("GADGET")+" Gadget Failed...");
		logger.info(values.get("GADGET")+" Gagdet Edited Successfully...");
		
		
		values.put("GADGET", "Top Defects");
		values.put("PROJECT",Config.getValue("JIRA_PROJECT"));
		values.put("VERSION","Version 1.0");
		values.put("GROUPBY","5");
		isSuccess=zfjNavigator.editGadget(values);	
		Assert.assertTrue(isSuccess,"Editing "+values.get("GADGET")+" Gadget Failed...");
		logger.info(values.get("GADGET")+" Gagdet Edited Successfully...");
		
			
		
		values.put("GADGET","Zephyr Test Distribution");
		values.put("PROJECT",Config.getValue("JIRA_PROJECT"));
		values.put("VERSION","Version 1.0");
		values.put("GROUPBY","Component");
		isSuccess=zfjNavigator.editGadget(values);	
		Assert.assertTrue(isSuccess,"Editing "+values.get("GADGET")+" Gadget Failed...");
		logger.info(values.get("GADGET")+" Gagdet Edited Successfully...");
		
		
		
		values.put("GADGET", "Zephyr Test Execution");
		values.put("PROJECT",Config.getValue("JIRA_PROJECT"));
		values.put("VERSION","Version 1.0");
		values.put("GROUPBY","Cycle");
		isSuccess=zfjNavigator.editGadget(values);	
		Assert.assertTrue(isSuccess,"Editing "+values.get("GADGET")+" Gadget Failed...");
		logger.info(values.get("GADGET")+" Gagdet Edited Successfully...");
		logger.info("Bvt68 executed successfully...");
		
	}
	
	@Test(enabled = testEnabled, priority=93) 	
	public void testBvt93(){
		altID=93;
		CommonUtil.alertMsg("executing bvt93...");
		logger.info("executing bvt93...");
		Assert.assertTrue(jiraNavigator.navigateToZfjGeneralConfigurationPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD),"Navigation to Zephyr General Coniguration Page Failed...");
		Assert.assertTrue(zfjNavigator.checkWorkflowToolbar());
		Assert.assertTrue(jiraNavigator.leavingAdministrationPage());
		Assert.assertTrue(zfjNavigator.validateWorkflowOptions());
		Assert.assertTrue(jiraNavigator.navigateToZfjGeneralConfigurationPage(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD),"Navigation to Zephyr General Coniguration Page Failed...");
		Assert.assertTrue(zfjNavigator.changeWorkflowStatus());
		Assert.assertTrue(jiraNavigator.leavingAdministrationPage());
		isSuccess = zfjNavigator.validateWorkflowOptions();
		Assert.assertTrue(isSuccess,"Validating ZFJ workflow tool bar failed...");
		logger.info("Bvt93 executed successfully...");
	}
	
	@Test(enabled = testEnabled, priority=94)
	public void testBvt94(){
		altID=94;
		CommonUtil.alertMsg("executing bvt94...");
		logger.info("executing bvt94...");
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
	}
	
	@Test(enabled = testEnabled, priority=95)
	public void testBvt95(){
		altID=95;
		CommonUtil.alertMsg("executing bvt95...");
		logger.info("executing bvt95...");
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
 		logger.info("Bvt95 executed successfully...");
 		
	}
	
	
	
	

	@BeforeClass
	public void beforeClass() throws Throwable{
		logger.info("beforeClass invoked");
		//JIRA_ADMIN_USERNAME=Config.getValue("JIRA_ADMIN_USERNAME");
		//JIRA_ADMIN_PASSWORD=Config.getValue("JIRA_ADMIN_PASSWORD");
		Assert.assertTrue(jiraNavigator.doLogin(JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD), "Login to jira is not successfully...");
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