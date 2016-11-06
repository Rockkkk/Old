package com.thed.zfjbvt.zfj.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.jira.JiraNavigatorFactory;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.util.TestDataExcelUtil;
import com.thed.zfjbvt.zfj.ZfjNavigator;
import com.thed.zfjbvt.zfj.impl.zfj25.SearchTestsPage;
import com.thed.zfjbvt.zfj.impl.zfj25.TestMetricsPage;
import com.thed.zfjbvt.zfj.impl.zfj25.ExecuteTestsPage;
import com.thed.zfjbvt.zfj.impl.zfj25.PlanTestCyclePage;
import com.thed.zfjbvt.zfj.impl.zfj25.SearchTestExecutionsPage;
import com.thed.zfjbvt.zfj.impl.zfj25.ViewTestPage;
import com.thed.zfjbvt.zfj.impl.zfj25.ZFJAdminCustomizeStepStatusPage;
import com.thed.zfjbvt.zfj.impl.zfj25.ZFJAdminCustomizeTestStatusPage;
import com.thed.zfjbvt.zfj.impl.zfj25.ZephyrTestMenuPage;
import com.thed.zfjbvt.zfj.impl.zfj25.ZfjGeneralConfigPage;

public class ZfjNavigator25Impl implements ZfjNavigator{
	private Logger logger = Logger.getLogger(this.getClass());
	
	//private JiraLandingPage jiraLandingPage=JiraLandingPage.getInstance();
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateTestExecutionStatus(Map<String, String> values){
		try{
			/*Assert.assertTrue(jiraLandingPage.navigateToAddonsPage(values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD"))
												.navigateToCustomizeTestStatusTab(), "Not Navigated Successfully to Customize Test Status Page. ");
			logger.info("Navigated Successfully to Customize Test Status Page. ");*/
			//Assert.assertTrue( ZFJAdminCustomizeTestStatusPage.getInstance().updateTestExecutionStatus(values.get("OLD_TEST_STATUS"), values.get("NEW_TEST_STATUS"), values.get("NEW_TEST_STATUS_DESC")), "Test Status is not updated successfully.");
			Assert.assertTrue( ZFJAdminCustomizeTestStatusPage.getInstance().updateTestExecutionStatus(values), "Test Status is not updated successfully.");
			logger.info("Test execution status is updated successfully.");
			/*Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage()
					.navigateToCustomizeTestStatusTab()
					.updateTestExecutionStatus(values),"Test status updation is not successfully.");
			logger.info("Test execution status is updated successfully.");
			JiraAdministrationPage.getInstance().leavingAdministrationPage();//added by Karthik
*/	
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addTestExecutionStatus(Map<String, String> values){
		try{
			/*Assert.assertTrue( jiraLandingPage.navigateToAddonsPage(values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD"))
					.navigateToCustomizeTestStatusTab(), "Not Navigated Successfully to Customize Test Status Page. ");
			logger.info("Navigated Successfully to Customize Test Status Page. ");*/
			Assert.assertTrue( ZFJAdminCustomizeTestStatusPage.getInstance().addTestExecutionStatus(values));
			logger.info("Test execution status is updated successfully.");
			/*Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage()
					.navigateToCustomizeTestStatusTab()
					.addTestExecutionStatus(values),"Adding test execution status is not successfully.");
			logger.info("Test execution status is added successfully.");
			JiraAdministrationPage.getInstance().leavingAdministrationPage();//added by Karthik
*/		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/*@Override
	public boolean updateTestExecutionStatus(Map<String, String> values){
		try{
			Assert.assertTrue(jiraLandingPage.navigateToAddonsPage(values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD"))
												.navigateToCustomizeTestStatusTab(), "Not Navigated Successfully to Customize Test Status Page. ");
			logger.info("Navigated Successfully to Customize Test Status Page. ");
			Assert.assertTrue( ZFJAdminCustomizeTestStatusPage.getInstance().updateTestExecutionStatus(values), "Test Status is not updated successfully.");
			logger.info("Test execution status is updated successfully.");
			Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage()
					.navigateToCustomizeTestStatusTab()
					.updateTestExecutionStatus(values),"Test status updation is not successfully.");
			logger.info("Test execution status is updated successfully.");
			JiraAdministrationPage.getInstance().leavingAdministrationPage();//added by Karthik
	
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	public boolean deleteTestExecutionStatus(String testStatus){
		try{
			Assert.assertTrue( ZFJAdminCustomizeTestStatusPage.getInstance().deleteTestExecutionStatus(testStatus), "Test Status is not deleted.");
			logger.info("Test execution status is Deleted successfully.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateStepExecutionStatus(Map<String, String> values){
		try{
			/*Assert.assertTrue( jiraLandingPage.navigateToAddonsPage(values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD"))
					.navigateToCustomizeStepStatusTab(), "Not Navigated Successfully to Customize Step Status Page. ");
			logger.info("Navigated Successfully to Customize Step Status Page. ");*/
			Assert.assertTrue( ZFJAdminCustomizeStepStatusPage.getInstance().updateStepExecutionStatus(values));
			logger.info("Step execution status is updated successfully.");
			/*Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage()
					.navigateToCustomizeStepStatusTab()
					.updateStepExecutionStatus(values),"Updating Step execution status is not successfully.");
			logger.info("Step execution status is added successfully.");
			JiraAdministrationPage.getInstance().leavingAdministrationPage();//added by Karthik
*/		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addStepExecutionStatus(Map<String, String> values){
		try{
			/*Assert.assertTrue( jiraLandingPage.navigateToAddonsPage(values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD"))
					.navigateToCustomizeStepStatusTab(), "Not Navigated Successfully to Customize Step Status Page. ");
			logger.info("Navigated Successfully to Customize Step Status Page. ");*/
			Assert.assertTrue( ZFJAdminCustomizeStepStatusPage.getInstance().addStepExecutionStatus(values));
			logger.info("Step execution status is Added successfully.");
			/*Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage()
					.navigateToCustomizeStepStatusTab()
					.addStepExecutionStatus(values),"Adding step execution status is not added successfully.");
			logger.info("Step execution status is added successfully.");
			JiraAdministrationPage.getInstance().leavingAdministrationPage();//added by Karthik
*/		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteStepExecutionStatus(String stepStatus){
		try{
			Assert.assertTrue( ZFJAdminCustomizeStepStatusPage.getInstance().deleteStepExecutionStatus(stepStatus));
			logger.info("Step execution status is Deleted successfully.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean createTestCycle(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToCreateNewCyclePage(values)
					.createNewCycle(values), "Cycle is not created successfully.");
			logger.info(values.get("CYCLE_NAME")+" is created successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addTestToCycle(Map<String, String> values){
		try{
			//String testID=jiraLandingPage.navigateToCreateTestPage().createTest(values.get("SUMMARY"), values.get("PRIORITY"));
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToAddTestToCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME"))
					.addTestsIndivisually(values.get("TEST_NAME")), values.get("TEST_NAME")+" test is not added successfully.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().verifyAddedTestsInCycle(values.get("CYCLE_NAME"), values.get("TEST_NAME")), "Added test is not verified successfully.");
			logger.info(values.get("TEST_NAME")+" test is added successfully to "+values.get("CYCLE_NAME"));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean addTestToCycle(String versionName, String cycleName, String testName){
		try{
			//String testID=jiraLandingPage.navigateToCreateTestPage().createTest(values.get("SUMMARY"), values.get("PRIORITY"));
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToAddTestToCyclePage(versionName, cycleName)
					.addTestsIndivisually(testName), testName+" test is not added successfully.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().verifyAddedTestsInCycle(cycleName, testName), "Added test is not verified successfully.");
			logger.info(testName+" test is added successfully to "+cycleName);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean executeTest(Map<String, String> values){
		try{
			/*String testID=jiraLandingPage.navigateToCreateTestPage().createTest(values.get("SUMMARY"), values.get("PRIORITY"));
			values.put("TEST_NAME", testID);
			System.out.println(values.get("TEST_NAME"));*/
			//Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertTrue(addTestToCycle(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME")),"Adding test into cycle is not executed successfully.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME")), "Not navigated to execution page.");
					
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("TEST_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_NAME")+" is executed successfully.");
			
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeCycle(values.get("CYCLE_NAME")), "Not Closed test cycle.");
			logger.info("Closed successfully Test Cycle.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean executeTestWithDefect(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME"))
					.changeTestExcutionStatusWithDefect(values), "Test status with defect is not executed successfully.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().validateTestExecutionWithDefect(values), "Test execution Defect is not verified successfully.");
			logger.info(values.get("TEST_NAME")+" is executed successfully.");
			
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeCycle(values.get("CYCLE_NAME")), "Not Closed test cycle.");
			logger.info("Closed successfully Test Cycle.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean executeTestWithDefectAndAttachment(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME"))
					.changeTestStatusWithDefectAndAttachment(values), "Test status with defect is not executed successfully.");
			
			Assert.assertTrue(PlanTestCyclePage.getInstance().validateTestExecutionWithDefect(values), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_NAME")+" is executed successfully.");
					
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeCycle(values.get("CYCLE_NAME")), "Not Closed test cycle.");
			logger.info("Closed successfully Test Cycle.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean executeSteps(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME")), "Not navigated to execution status page");
					
			Assert.assertTrue(ExecuteTestsPage.getInstance()
					.changeStepExcutionStatus("1", values.get("STEP_EXEC_STATUS_ONE")),"Step execution status is not verified successfully.");
			logger.info("Step one is executed successfully.");
			
			Assert.assertTrue(ExecuteTestsPage.getInstance()
					.changeStepExcutionStatus("2", values.get("STEP_EXEC_STATUS_TWO")),"Step execution status is not verified successfully.");
			logger.info("Step two is executed successfully.");
			
			Assert.assertTrue(ExecuteTestsPage.getInstance()
					.changeStepExcutionStatus("3", values.get("STEP_EXEC_STATUS_THREE")),"Step execution status is not verified successfully.");
			logger.info("Step three is executed successfully.");
			
			Assert.assertTrue(ExecuteTestsPage.getInstance()
					.changeStepExcutionStatus("4", values.get("STEP_EXEC_STATUS_FOUR")),"Step execution status is not verified successfully.");
			logger.info("Step four is executed successfully.");
		
			Assert.assertTrue(ExecuteTestsPage.getInstance().returnToPlanTestCycle(), "Not returned to Plan Test Cycle.");
			logger.info("Returned successfully to Plan Test Cycle.");
			
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeCycle(values.get("CYCLE_NAME")), "Not Closed the test cycle.");
			logger.info("Closed successfully Test Cycle.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean executeStep(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME"))
					.changeStepExcutionStatus(values.get("STEP_NUM"), values.get("STEP_EXEC_STATUS")),"Step execution status is not verified successfully.");
					
			//Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus(values.get("STEP_NUM"), values.get("STEP_EXEC_STATUS")),"Step execution status is not verified successfully.");
			logger.info("Step is executed successfully.");
			
			Assert.assertTrue(ExecuteTestsPage.getInstance().returnToPlanTestCycle(), "Not returned to Plan Test Cycle.");
			logger.info("Returned successfully to Plan Test Cycle.");
			
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeCycle(values.get("CYCLE_NAME")), "Not Closed test cycle.");
			logger.info("Closed successfully Test Cycle.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean executeStepWithDefect(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME"))
					.changeStepExcutionStatusWithDefect(values), "Step is not executed with defect.");
			logger.info("Step is executed successfully with defect.");
			
			//Assert.assertTrue(ExecuteTestsPage.getInstance().returnToPlanTestCycle(), "Not returned to Plan Test Cycle.");
			//logger.info("Returned successfully to Plan Test Cycle.");
			
			//Assert.assertTrue(PlanTestCyclePage.getInstance().closeCycle(values.get("CYCLE_NAME")), "Not Closed test cycle.");
			//logger.info("Closed successfully Test Cycle.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addTestsMultipleAndExecute(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(createTestCycle(values), "Cycle is not created successfully.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(PlanTestCyclePage.getInstance().navigateToAddTestToCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME"))
					.addTestsUsingSpaceBar(values)
					.verifyAddedTestsInCycle(values),"Tests are not added successfully to the cycle.");
			logger.info("Tests are added successfully to the cycle.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			//Assert.assertTrue(executeTest(values),"");
			//logger.info("Step is executed successfully with defect.");
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestPage(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_ONE")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_ONE"), values.get("TEST_ONE_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_ONE")+" is executed successfully.");
			
			//Driver.driver.navigate().back();
			
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestPage(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_TWO")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_TWO"), values.get("TEST_TWO_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_TWO")+" is executed successfully.");
			
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestPage(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_THREE")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_THREE"), values.get("TEST_THREE_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_THREE")+" is executed successfully.");
			
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestPage(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_FOUR")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_FOUR"), values.get("TEST_FOUR_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_FOUR")+" is executed successfully.");
					
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeCycle(values.get("CYCLE_NAME")), "Not Closed test cycle.");
			logger.info("Closed successfully Test Cycle.");
			logger.info("All tests are executed successfully.");
			//Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values), "Test execution status is not verified successfully.");
			//logger.info(values.get("TEST_NAME")+" is executed successfully.");
		
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executeMultipleTests(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(createTestCycle(values), "Cycle is not created successfully.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(PlanTestCyclePage.getInstance().navigateToAddTestToCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME"))
					.addTestsUsingSpaceBar(values)
					.verifyAddedTestsInCycle(values),"Tests are not added successfully to the cycle.");
			logger.info("Tests are added successfully to the cycle.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			//Assert.assertTrue(executeTest(values),"");
			//logger.info("Step is executed successfully with defect.");
			
					
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestPage(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_ONE")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_ONE"), values.get("TEST_ONE_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_ONE")+" is executed successfully.");
			
			
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestPage(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_TWO")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_TWO"), values.get("TEST_TWO_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_TWO")+" is executed successfully.");
			
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestPage(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_THREE")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_THREE"), values.get("TEST_THREE_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_THREE")+" is executed successfully.");
			
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestPage(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_FOUR")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_FOUR"), values.get("TEST_FOUR_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_FOUR")+" is executed successfully.");
			
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestPage(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_FIVE")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_FIVE"), values.get("TEST_FIVE_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_FIVE")+" is executed successfully.");
					
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeCycle(values.get("CYCLE_NAME")), "Not Closed test cycle.");
			logger.info("Closed successfully Test Cycle.");
			logger.info("All tests are executed successfully.");
			//Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values), "Test execution status is not verified successfully.");
			//logger.info(values.get("TEST_NAME")+" is executed successfully.");
		
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean executeAllSteps(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME")), "Not navigated to execution status page");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeAllStepsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("NUM_OF_STEPS_EXEC"), values.get("STEP_EXEC_STATUS")));
			logger.info("Test is executed Successfully with test step.");
			
			//Assert.assertTrue(ExecuteTestsPage.getInstance().returnToPlanTestCycle(), "Not returned to Plan Test Cycle.");
			//logger.info("Returned successfully to Plan Test Cycle.");
			
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeCycle(values.get("CYCLE_NAME")), "Not Closed test cycle.");
			logger.info("Closed successfully Test Cycle.");
		/*	for(int i=1;i< Integer.parseInt(values.get("NUM_OF_STEPS_EXEC")); i++){
				String stepNum=""+i+"";
				Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus(stepNum, values.get("STEP_EXEC_STATUS")),"Step execution status is not verified successfully.");
				logger.info("Step "+i+" is executed successfully.");
			}*/
			
			
			/*Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus("1", values.get("STEP_EXEC_STATUS_ONE")),"Step execution status is not verified successfully.");
			logger.info("Step one is executed successfully.");
			
			Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus("2", values.get("STEP_EXEC_STATUS_TWO")),"Step execution status is not verified successfully.");
			logger.info("Step two is executed successfully.");
			
			Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus("3", values.get("STEP_EXEC_STATUS_THREE")),"Step execution status is not verified successfully.");
			logger.info("Step three is executed successfully.");
			
			Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus("4", values.get("STEP_EXEC_STATUS_FOUR")),"Step execution status is not verified successfully.");
			logger.info("Step four is executed successfully.");*/
		
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean executeTestDirectlyInPlanTest(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.executeTestDirectly(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("TEST_EXEC_STATUS")), "Test is not executed directly.");
			logger.info("Test is executed directly.");
			
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeCycle(values.get("CYCLE_NAME")), "Not Closed test cycle.");
			logger.info("Closed successfully Test Cycle.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean executeTestDirectlyInViewIssue(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.executeTestInViewIssuePageAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("TEST_EXEC_STATUS")), "Test is not executed directly.");
			logger.info("Test is executed directly.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean editCycle(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToEditCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME"))
					.editCycle(values), "Cycle is not edited properly.");
			logger.info("Cycle is edited successfully.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().validateEditCycle(values), "Edited cycle is not validated successfully.");
							
			logger.info(values.get("CYCLE_NAME")+" is validated successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exportCycle(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
						.exportTestsFromCycle(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("CYCLE_START_DATE"), values.get("BUILD_NAME"), values.get("ENVIROMENT_NAME")), "Cycle Tests are not exported successfully.");
			logger.info("Test cycle is exported successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	public boolean quickSearchByID(Map<String, String> values){
		try{
			logger.info("Created test Successfully.");
			//Assert.assertTrue(zephyrTestMenuPage.quickSearchByID(values.get("TEST_ID")));
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	/**
	 * {@inheritDoc}
	 */
	public boolean executeTestInAdhoc(Map<String, String> values){
		try{
			logger.info("Created test Successfully.");
			
			Assert.assertTrue(getZephyrTestMenuPage().quickSearchByID(values.get("TEST_NAME"))
					.executeTestInAdhoc()
					.executeTestAndValidate(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("TEST_EXEC_STATUS")), "Test execution status is not verified successfully.");
			/*Assert.assertTrue(zephyrTestMenuPage.navigateToExecuteTestsPage()
							.navigateToViewIssuePage(values.get("CYCLE_NAME"), values.get("TEST_NAME"))
							.executeTestInAdhoc()
							.executeTestsAndValidate(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("TEST_EXEC_STATUS")), "Test execution status is not verified successfully.");
			*/
			logger.info("Test is executed successfully in Ad-hoc.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	/*public boolean deleteTest(){
		try{
			Assert.assertTrue(zephyrTestMenuPage.navigateToSearchTestsPage()
					.deleteTest(), "Test is not deleted successfully.");
			logger.info("Test is deleted successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;	
	}*/
	public boolean addTestsFromJiraSearch(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String totalTests = getZephyrTestMenuPage().navigateToSearchTestsPage().saveAsJiraSearch(values.get("FILTER_NAME"));
			Assert.assertNotNull(totalTests, "Created Filters but it is returning null tests.");
			logger.info("Filter is created and validated successfully.");
			
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToAddTestToCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME"))
					.addTestFromJiraSearch(values.get("FILTER_NAME"), totalTests), "Filter is not saved.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().verifyAddedTest(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), totalTests), "Added tests are not verified in cycle.");
			//logger.info("Added test is validated successfully.");
			logger.info("Filter tests added successfully to cycle.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean addTestsFromOtherCycle(Map<String, String> values){
		try{
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "All Cycles are not closing.");
			List<String> defectList=getZephyrTestMenuPage().navigateToPlanTestCyclePage().checkDefectsInCycle(values.get("VERSION_NAME"), values.get("OLD_CYCLE_NAME"));
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToAddTestToCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME"))
					.addTestFromOtherCycle(values.get("VERSION_NAME"), values.get("OLD_CYCLE_NAME")));
			logger.info("Tests are added successfully.");
					
			Assert.assertTrue(PlanTestCyclePage.getInstance().verifyAddedTest(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), defectList), "Added tests are not verified in cycle.");
			logger.info("Added test is validated successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean SearchByID(Map<String, String> values){
		try{
			//Assert.assertTrue(zephyrTestMenuPage.quickSearchByID(values.get("TEST_ID")));
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verifyZfjTestMenus(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().validateSearchTestPage(),"launching Search Test Page Failed");
			logger.info("Search Test Page Verified Successfully...");
			
			Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage().validateCreateTestPage(),"launching Create Test Page Failed ");
			logger.info("Create Test page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage().validatePlanTestCyclePage(),"launching Plan Test Cycle page Failed");
			logger.info("Plan Test Cycle Page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToExecuteTestsPage().validateExecuteTestCyclePage(),"launching Execute Test Cycle Page Failed");
			logger.info("Execute Test Cycle Page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().validateSearchTestExecutionPage(),"launching Search Test Execution Page Failed...");
			logger.info("Search Test Execution Page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToManageExecutionFiltersPage().validateManageExecutionFiltersPage(),"launching Manage Execution Filters Page Failed...");
			logger.info("Manage Execution Filters Page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestSummaryPage().validateTestSummaryPage(),"launching Test Summary Page Failed");
			logger.info("Test Summary Page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().validateTestMetricsPage(),"launching Test Metrics Page Failed");
			logger.info("Test Metrics Page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToZfjWelcomePage().validateZfjWelcomePage(), "launching ZFJ Welcome Page Failed");
			logger.info("ZFJ Welcome Page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToZfjHelpPage().validateZfjHelpPage(), "launching ZFJ Help Page Failed");
			logger.info("ZFJ Help Page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToAboutZfjPage().validateAboutZfjPage(),"launching About ZFJ Page Failed");
			logger.info("About ZFJ Page Verified Successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean createTest(Map<String, String> values){
		try{

			Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage()
					.createTest(values)
					.validateTestCreated(values),"New Test Creation Failed...");

			logger.info("New Test Created Successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean addStepsToTest(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().addTeststeps(values));
			//Assert.assertTrue(ViewTestPage.getInstance().addTeststeps(values));
			logger.info("Teststeps added Successfully...");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean reArrangeTeststeps(int srcStep, int destStep){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest()
					.reArrangeTestSteps(srcStep, destStep),"Teststep Re-Arrange Failed...");
			logger.info("TestSteps Re-Arranged Successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean editTeststeps(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest()
					.editTeststep(values), "Test Step edition failed.");
			logger.info("Teststep Edited Successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean editTestDetails(Map<String, String> values){
		try{
			/*Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values)
					.validateTestCreated(values),"New Test Creation Failed...");*/
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().navigateToEditTestPage(values).editTest(values), "Test is not edited.");
			//Assert.assertTrue(ViewTestPage.getInstance().navigateToEditTestPage(values).editTest(values));
			logger.info("Test Edited Successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean cloneTest(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values)
					.validateTestCreated(values),"New Test Creation Failed...");
			Assert.assertTrue( ViewTestPage.getInstance().addTeststeps(values), "Test step Addition Failed...");
			logger.info("Teststeps Added Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage()
					.navigateToFirstTest()
					.navigateToCloneTest(values)
					.cloneTest(values), "Test Cloning Failed...");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean linkTestToAnotherTest(Map<String, String> values){
		try{
			
			Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values)
					.validateTestCreated(values),"New Test Creation Failed...");
			values.put("SUMMARY",values.get("SECOND_SUMMARY"));
			values.put("PRIORITY",values.get("SECOND_PRIORITY"));
			values.put("COMPONENT", values.get("SECOND_COMPONENT"));
			values.put("AFFECTEDVERSION", values.get("SECOND_AFFECTED_VERSION"));
			values.put("FIXVERSION", values.get("SECOND_FIX_VERSION"));
			values.put("ENVIRONMENT", values.get("SECOND_ENVIRONMENT"));
			values.put("DESCRIPTION", values.get("SECOND_DESCRIPTION"));
			values.put("LABEL", values.get("SECOND_LABEL"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values)
					.validateTestCreated(values),"New Test Creation Failed...");
			Assert.assertTrue(ViewTestPage.getInstance().navigateToLinkIssue(values).linkTest(values),"Linking Two Tests Failed...");
			logger.info("Test Linked successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean linkTestToissue(Map<String, String>values){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(ViewTestPage.getInstance().navigateToLinkIssue(values).linkIssue(values),"Linking Test to issue Failed...");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean searchTestByKeyword(){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().quickSearchBySummary());
			logger.info("Test Searched Using Test Summary Successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean changeBulkTestsStatus(String status, int totalTest){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().changeBulkTestStatus(status, totalTest));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean bulkAssociateDefect(String bugId,int totalTest){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().bulkAssociateDefect(bugId,totalTest));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {inheritDoc}
	 */
	public boolean changeBulkTestsStatusWithTeststeps(String testStatus, String teststepStatus, int totalTest){
		try{
			Map<String, String> values= new HashMap<String, String>();
			for(int i=1; i<=totalTest;i++){
				values.put("SUMMARY", "Test "+i+" for bulk test and status change "); // summary of the new Test.
				values.put("PRIORITY", Config.getValue("PRIORITY_THREE")); // priority of new Test.
				values.put("STEP_1", "test step "+i+"");
				values.put("DATA_1", "test data "+i+"");
				values.put("EXPECTED_RESULT_1", "test expected result "+i+"");
				values.put("STEP_2", "test step "+i+"");
				values.put("DATA_2", "test data "+i+"");
				values.put("EXPECTED_RESULT_2", "test expected result "+i+"");
				values.put("STEP_3", "test step "+i+"");
				values.put("DATA_3", "test data "+i+"");
				values.put("EXPECTED_RESULT_3", "test expected result "+i+"");
				values.put("TOTAL_STEPS","3");
				Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage().createTestWithSteps(values));
				ViewTestPage.getInstance().navigateToExecuteTestPage().addTestToAdhoc();
			}
			
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().changeBulkTeststepStatus(testStatus, teststepStatus, totalTest));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean changeBulkTestStatusToUnexecutedWithDefectsCleared(String bugId,int totalTest){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().bulkAssociateDefect(bugId,totalTest));
			Assert.assertTrue(SearchTestExecutionsPage.getInstance().changeBulkTestStatusToUnexecutedWithDefectsCleared(totalTest));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean bulkMoveTestsToCycle(String version,String cycle,int totalTest){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().bulkMoveTestToCycle(version, cycle, totalTest));			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean bulkMoveTestsToCycleWithDefects(String version, String cycle, String bugId,  int totalTest){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().bulkAssociateDefect(bugId, totalTest));
			Assert.assertTrue(SearchTestExecutionsPage.getInstance().bulkMoveTestToCycleWithDefects(version, cycle, totalTest, bugId));
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean bulkMoveTestToCycleWithDefectsAndStatusNotCarried(String version, String cycle,String bugId,int totalTest){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().bulkAssociateDefect(bugId,totalTest));
			Assert.assertTrue(SearchTestExecutionsPage.getInstance().bulkMoveTestToCycle(version, cycle, totalTest));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean bulkCopyTestToCycleWithDefectsAndStatusNotCarried(String version, String cycle,String bugId,int totalTest){
		//String status="wip";
		try{
			/*Map<String, String> values= new HashMap<String, String>();
				for(int i=1; i<=totalTest;i++){
					values.put("SUMMARY", "Test "+i+" created for bulk copy"); // summary of the new Test.
					values.put("PRIORITY", "Blocker"); // priority of new Test.
					Assert.assertNotNull(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values.get("SUMMARY"), values.get("PRIORITY")));
					ViewTestPage.getInstance().navigateToExecuteTestPage().executeTest(status);
				}*/
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().bulkAssociateDefect(bugId,totalTest));
			Assert.assertTrue(SearchTestExecutionsPage.getInstance().bulkCopyTestToCycle(version, cycle, totalTest));
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@Override
	/**
	 * {@inheritDoc}
	 */

	public boolean viewAndDrillDownTestSummary(){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestSummaryPage().validateTestSummary());
			logger.info("Test Summary validated Successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean viewTestSummaryCharts(){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestSummaryPage().validateSummaryCharts());
			logger.info("Test Summary Charts validated Successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean launchTestMatricsAndDispalysCreationAndExecutionGadgets(){

		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().validateTestDistributionAndExecutionCharts());
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean addTopDefectGadget(){
		try{
			String gadget = "Top Defects";
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage()
					.navigateToGadgetDirectoryAndAddGadget(gadget));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean addExecutionBurndownGadget(){
		try{
			String gadget = "Test Execution Burndown";
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage()
					.navigateToGadgetDirectoryAndAddGadget(gadget));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean addTestExecutionDetailsGadget(){
		try{
			String gadget = "Execution Details";
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage()
					.navigateToGadgetDirectoryAndAddGadget(gadget));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean exportTestFromIssueNavigator(){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().exportTest());
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean checkWorkflowToolbar(){
		try{
			
			ZfjGeneralConfigPage.getInstance().checkWorkflowOption();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean viewTopDefectGadget(){
		try{
			String gadget = "Top Defects";
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().validateTestGadget(gadget));
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean viewTestDistributonGadget(){
		try{
			String gadget = "Zephyr Test Distribution";
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().validateTestGadget(gadget));
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean viewTestExecutionGadget(){
		try{
			String gadget = "Zephyr Test Execution";
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().validateTestGadget(gadget));
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean viewExecutionBurndownGadget(){
		try{
			String gadget = "Test Execution Burndown";
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().validateTestGadget(gadget));
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {inheritDoc}
	 */
	public boolean viewTestExecutionDetailsGadget() {
		try{
			String gadget = "Execution Details";
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().validateTestGadget(gadget));
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean editGadget(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().editGadget(values),"Edition of Gadget "+ values.get("GADGET")+" Falied...");
			Assert.assertTrue(TestMetricsPage.getInstance().validateTestGadget(values.get("GADGET")),"Validation of Gadget "+ values.get("GADGET")+" Falied...");
		}catch(Exception e){
			Driver.driver.switchTo().defaultContent();
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean cloneTestCycle(Map<String, String> values){
		try{
			
			List<String> cycleInfo = getZephyrTestMenuPage().navigateToPlanTestCyclePage().getCycleInfo(values.get("CYCLE_NAME"));
			Assert.assertTrue(cycleInfo.size() > 0, "There is no information for the cycle.");
			logger.info("Cycle info taken successfully before cloning.");
			
			List<String> cycleTestsInfo = getZephyrTestMenuPage().navigateToPlanTestCyclePage().getTestInfoFromCycle(Config.getValue("JIRA_PROJECT"), values.get("VERSION_NAME"), values.get("CYCLE_NAME"));
			Assert.assertTrue(cycleTestsInfo.size() > 0, "There is no tests in the cycle.");
			logger.info("Cycle test info taken successfully before cloning.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "Not Closed All test cycle.");
			logger.info("Closed successfully Test Cycle.");
			/*Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToCreateNewCyclePage(values)
					.createNewCycle(values), "Cycle is not created successfully.");
			logger.info(values.get("CYCLE_NAME")+" is created successfully.");*/
			/*String testId;
			Assert.assertNotNull(testId=getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values.get("TEST_SUMMARY"), values.get("TEST_PRIORITY")), "Test Creation Failed...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage().navigateToAddTestToCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME")).addTestsIndivisually(testId));
			*/
			String cloneCycleName = getZephyrTestMenuPage().navigateToPlanTestCyclePage().navigateToCloneTestCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME")).cloneTestCycle();
			Assert.assertNotNull(cloneCycleName,"Test Cycle Cloning Failed...");
			logger.info("Cycle cloned successfully.");
			CommonUtil.refreshPage();
			Assert.assertTrue(PlanTestCyclePage.getInstance().validateCycle(cloneCycleName, cycleInfo),"Not the same Test added...");
			logger.info("Cycle info validated successfully after cloning.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().validateTestInfoInCycle(cloneCycleName, cycleTestsInfo),"Not the same Test added...");
			logger.info("Cycle test info is validated successfully after cloning.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().closeAllCycle(), "Not Closed All test cycle.");
			logger.info("Closed successfully Test Cycle.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean changeIssueLinkStatus(){
		try{

			ZfjGeneralConfigPage.getInstance().changeIssueLinkStatus();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean changeRemoteIssueLinkStatus(){
		try{
			ZfjGeneralConfigPage.getInstance().changeRemoteIssueLinkStatus();
			/*Map<String, String> values= new HashMap<String, String>();

		values.put("SUMMARY", "Test to validate Remote Issue Link"); // summary of the new Test.
		values.put("PRIORITY", "Blocker"); // priority of new Test.
		//checks remote issue link status.
		Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
				.navigateToZFJAdminPage().checkRemoteIssueLink());
		
		
		//executes the test by adding the issue as a defect.
		Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().navigateToExecuteTestPage().executeTest(status));
		Assert.assertTrue(ExecuteTestsPage.getInstance().addedDefectToTest(),"Validating Issue Failed...");
		//checks the test for remote issue link. 
		Assert.assertTrue(ViewTestPage.getInstance().checkRemoteIssueLinked());
		//changes remote issue link status.
		Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
				.navigateToZFJAdminPage().changeRemoteIssueLinkStatus());
		
		//creates a test for execution.
		Assert.assertNotNull(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values.get("SUMMARY"), values.get("PRIORITY")),"Test Creation Failed...");
		
		//executes the test by adding the issue as a defect.
		Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().navigateToExecuteTestPage().executeTest(status));
		Assert.assertTrue(ExecuteTestsPage.getInstance().addedDefectToTest(),"Validating Issue Failed...");
		//checks the test for remote issue link.
		Assert.assertTrue(ViewTestPage.getInstance().checkRemoteIssueLinked());*/
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executePredefinedFilters(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().selectAndValidatePredefinedFilters(values.get("PREDEFINED_FILTER_NAME_ONE")),values.get("PREDEFINED_FILTER_NAME_ONE")+" is not executed successfully.");
			logger.info(values.get("PREDEFINED_FILTER_NAME_ONE")+" is executed successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(SearchTestExecutionsPage.getInstance().selectAndValidatePredefinedFilters(values.get("PREDEFINED_FILTER_NAME_TWO")),values.get("PREDEFINED_FILTER_NAME_TWO")+" is not executed successfully.");
			logger.info(values.get("PREDEFINED_FILTER_NAME_TWO")+" is executed successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(SearchTestExecutionsPage.getInstance().selectAndValidatePredefinedFilters(values.get("PREDEFINED_FILTER_NAME_THREE")),values.get("PREDEFINED_FILTER_NAME_THREE")+" is not executed successfully.");
			logger.info(values.get("PREDEFINED_FILTER_NAME_THREE")+" is executed successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(SearchTestExecutionsPage.getInstance().selectAndValidatePredefinedFilters(values.get("PREDEFINED_FILTER_NAME_FOUR")),values.get("PREDEFINED_FILTER_NAME_FOUR")+" is not executed successfully.");
			logger.info(values.get("PREDEFINED_FILTER_NAME_FOUR")+" is executed successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(SearchTestExecutionsPage.getInstance().selectAndValidatePredefinedFilters(values.get("PREDEFINED_FILTER_NAME_FIVE")),values.get("PREDEFINED_FILTER_NAME_FIVE")+" is not executed successfully.");
			logger.info(values.get("PREDEFINED_FILTER_NAME_FIVE")+" is executed successfully.");
			logger.info("Predefined filters is executed successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executeZQLQueryForFixVersion(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.executeZQLQueryForFixVersion(values.get("FIX_VERSION_ZQLQUERY"),values.get("FIX_VERSION_NAME")),"ZQL Query is not executed for fix version.");
			logger.info("ZQL Query is is executed successfully for fix version.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean createExecFilterAndSaveToFavourite(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().createExecFilterAndSaveToFavourite(values.get("ZQLQUERY"),values.get("EXECUTION_FILTER_NAME")),"Execution filter is not created and saved to favourite filters.");
			logger.info("Execution filter is created and saved to favourite filters.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean searchExecutionFilter(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.searchExecutionFilter(values.get("EXECUTION_FILTER_NAME")),"Execution filter is not created and saved to favourite filters.");
			logger.info("Execution filter is searched successfully in favourite filters.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean exportTestExecutions(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.exportTestExecutions(values.get("FILTER_NAME"),values.get("ZQL_QUERY"), values.get("PROJECT_NAME"), values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_ONE"), values.get("TEST_TWO"), values.get("TOTAL_TEST_TO_EXPORT"), values.get("TOTAL_TEST_STEP")),"Test executions are not exported.");
			logger.info("Test executions are exported successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteExecutions(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.deleteExecutions(values.get("ZQLQUERY"), values.get("NUM_OF_TESTS")),"Test executions are not deleted successfully.");
			logger.info("Test executions are deleted successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean searchExecFilterInManageExecFilter(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().createExecFilterAndSaveToFavourite(values.get("ZQLQUERY"),values.get("EXECUTION_FILTER_NAME")),"Execution filter is not created and saved to favourite filters.");
			logger.info("Execution filter is created and saved to favourite filters.");
			int totalTests=SearchTestExecutionsPage.getInstance().totalTests();
			Assert.assertTrue(getZephyrTestMenuPage().navigateToManageExecutionFiltersPage().searchExecFilterInManageExecFilter(values.get("EXECUTION_FILTER_NAME"), totalTests),"Execution filter is not searched in manage execution filter page.");
			logger.info("Execution filter is searched successfully in manage execution filter page.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean executeTestFromExecutionNavigator(Map<String, String> values){
		try{
			logger.info("execution starts..");
			Assert.assertTrue(addTestToCycle(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME")),"Test is not added successfully.");
			logger.info("Test is added successfully to the cycle.");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.executeTestFromExecutionNavigator(values.get("ZQL_QUERY"), values.get("PROJECT_NAME"), values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("TEST_EXEC_STATUS")));
			/*Assert.assertTrue(zephyrTestMenuPage.navigateToSearchTestExecutionsPage().createExecFilterAndSaveToFavourite(values.get("ZQLQUERY"),values.get("EXECUTION_FILTER_NAME")),"Execution filter is not created and saved to favourite filters.");
			logger.info("Execution filter is created and saved to favourite filters.");
			int totalTests=SearchTestExecutionsPage.getInstance().totalTests();
			Assert.assertTrue(zephyrTestMenuPage.navigateToManageExecutionFiltersPage().searchExecFilterInManageExecFilter(values.get("EXECUTION_FILTER_NAME"), totalTests),"Execution filter is not searched in manage execution filter page.");
			logger.info("Execution filter is searched successfully in manage execution filter page.");*/
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean executeTestDirectlyFromExecutionNavigator(Map<String, String> values){
		try{
			logger.info("execution starts..");
			Assert.assertTrue(addTestToCycle(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME")),"Test is not added successfully.");
			logger.info("Test is added successfully to the cycle.");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().executeTestDirectlyFromExecutionNavigator(values.get("ZQL_QUERY"), values.get("PROJECT_NAME"), values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("TEST_EXEC_STATUS")));
			/*Assert.assertTrue(zephyrTestMenuPage.navigateToSearchTestExecutionsPage().createExecFilterAndSaveToFavourite(values.get("ZQLQUERY"),values.get("EXECUTION_FILTER_NAME")),"Execution filter is not created and saved to favourite filters.");
			logger.info("Execution filter is created and saved to favourite filters.");
			int totalTests=SearchTestExecutionsPage.getInstance().totalTests();
			Assert.assertTrue(zephyrTestMenuPage.navigateToManageExecutionFiltersPage().searchExecFilterInManageExecFilter(values.get("EXECUTION_FILTER_NAME"), totalTests),"Execution filter is not searched in manage execution filter page.");
			logger.info("Execution filter is searched successfully in manage execution filter page.");*/
			logger.info("Test is Directly Executed successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executeZQLQueryForComponent(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.executeZQLQueryForComponent(values.get("ZQLQUERY"),values.get("COMPONENT_NAME")),"ZQL Query is not executed for fix version.");
			logger.info("ZQL Query is is executed successfully for fix version.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Map<String, String> createMultipleTestsWithStep(){
		Map<String, String> testKeySet=new HashMap<String, String>();
		try{
			List<String> testStepSummary=TestDataExcelUtil.getTestStepDescription( "test step", "Issue type");
			Map<String, Map<String, String>> testData=TestDataExcelUtil.getRowData("Test with test step", "Issue type");
			Map<String, Map<String, String>> testStep=TestDataExcelUtil.getStepData("test step", "Issue type");
			for(String summary : testData.keySet()){
				Map<String, String> rowData = testData.get(summary);

				String testKey=getZephyrTestMenuPage().navigateToCreateTestPage()
						.createTests(rowData.get("summary"), rowData.get("priority"), rowData.get("component"),  rowData.get("affectedVersion") ,
								 rowData.get("fixedVersion"), rowData.get("enviroment"),  rowData.get("description"), rowData.get("label"));
				// creating test step.
				for(int i=0; i< testStepSummary.size(); i++){
					Map<String, String> stepRowData = testStep.get(testStepSummary.get(i));
					ViewTestPage.getInstance().createTestStep(stepRowData.get("test step"), stepRowData.get("test data"), stepRowData.get("test result"));
					logger.info("step "+(i+1)+" created");
				}
				testKeySet.put(summary, testKey);
				logger.info(testKey + " is added to " + summary);
			}
			logger.info("Tests created successfully.");
			getZephyrTestMenuPage().navigateToSearchTestsPage();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(SearchTestsPage.getInstance().changeView("list view"), "View is not selected successfully.");
			logger.info("View is changed to List View.");
			for(String summary: testKeySet.keySet()){
				Assert.assertTrue(SearchTestsPage.getInstance().searchTestDescription(summary), "Tests are not validated.");
			}
			
			logger.info("Tests are Validated successfully.");
		} catch (Throwable e){
			e.printStackTrace();
		}
		return testKeySet;
	}
	/*public boolean createTestWithSteps(){
		try{
			
			String testKey=getZephyrTestMenuPage().navigateToCreateTestPage()
					.createTests("Test with multiple 300 test steps","Major" ,"Component1", "Version 1.0", "Version 1.0", "Win-8", "This is des.","Label1");
			logger.info("Test created successfully");
				// creating test step.
				for(int i=1; i<= 10; i++){
					String testStep="Step "+i;
					String testData="Data "+i;
					String testRes="Res "+i;
					ViewTestPage.getInstance().createTestStep(testStep,testData, testRes);
					logger.info("step "+(i)+" created");
				}
			logger.info("Test with test step created successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean createTests(){
		try{
			
			
				// creating tests
				for(int i=1; i<= 100; i++){
					String[] component={"Component1", "Component2", "Component3"};
					int index = new Random().nextInt(component.length);
					String components = component[index];
					String[] priority={"Major", "Minor", "Blocker", "Critical"};
					int index1 = new Random().nextInt(priority.length);
					String priorities = priority[index1];
					String testSummary="Test "+i+" for create and execute.";
					String testKey=getZephyrTestMenuPage().navigateToCreateTestPage()
							.createTests(testSummary,priorities , components, "Version 1.0", "Version 2.0", "Win-8", "This is des.","Label1");
										
					logger.info("Test "+(i)+" created");
				}
			logger.info("Tests created successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	public boolean deleteTest(String testToDelete){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage()
					.deleteTest(testToDelete), "Test is not deleted successfully.");
			logger.info("Test is deleted successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	
	
	public Map<String, String> createMultipleTests(){
		Map<String, String> key=new HashMap<String, String>();
		try{
			//List<String> testSummary=ExcelUtil.getIssueTypeSummary( "Test", "issue type");
			
			Map<String, Map<String, String>> testData=TestDataExcelUtil.getRowData("Test", "Issue type");
			//for(String summary : testData.keySet()){
			for(int i=0;i<500;i++){
			for(String summary : testData.keySet()){
				Map<String, String> rowData = testData.get(summary);
				/*String testKey=getZephyrTestMenuPage().navigateToCreateTestPage()
						.createTests(rowData.get("summary"), rowData.get("priority"), rowData.get("component"),  rowData.get("affectedVersion") ,
								 rowData.get("fixedVersion"), rowData.get("enviroment"),  rowData.get("description"), rowData.get("label"));
				*/
				String testKey=getZephyrTestMenuPage().navigateToCreateTestPage()
						.createTest(rowData.get("summary"), rowData.get("priority"));
				
				key.put(summary, testKey);
				logger.info(testKey + " is added to " + summary);
			}if(i==500){break;}}
			logger.info("Tests created successfully.");
			getZephyrTestMenuPage().navigateToSearchTestsPage();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(SearchTestsPage.getInstance().changeView("list view"), "View is not selected successfully.");
			logger.info("View is changed to List View.");
			for(String summary: key.keySet()){
				Assert.assertTrue(SearchTestsPage.getInstance().searchTestDescription(summary), "Tests are not validated.");
			}
			
			logger.info("Tests created successfully.");
		}catch (Throwable th){
			th.printStackTrace();
		}
		return key;
	}
	
	public ZephyrTestMenuPage getZephyrTestMenuPage() {
		try{
			String testMenu = JiraNavigatorFactory.getInstance().getZephyrTestLink();
			Assert.assertNotNull(testMenu, "Test menu is not finding.");
			return ZephyrTestMenuPage.getInstance(testMenu);
		}catch(Exception e){
			return null;
		}
	}
	public boolean validateTestsDropDown(){
		try{
			CommonUtil.refreshPage();
			Assert.assertTrue(getZephyrTestMenuPage().validateTestsDropdownMenu(), "Tests drop down is not verified.");
			logger.info("Test Drop down is validated successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean createTest(String summary, String priority) {
		try{
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(summary, priority));
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean changeWorkflowStatus() {
		try{
			
			ZfjGeneralConfigPage.getInstance().changeWorkflowStatus();
	
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean validateWorkflowOptions() {
		try{
			getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().checkWorkflowToolbar();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean checkIssueLinkStatus() {
		try{
			ZfjGeneralConfigPage.getInstance().checkIssueLink();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean checkRemoteIssueLinkStatus() {
		try{
			ZfjGeneralConfigPage.getInstance().checkRemoteIssueLink();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean validateIssueLink(Map<String, String> values) {
		String status="FAIL";
		try{
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values.get("SUMMARY"), values.get("PRIORITY")),"Test Creation Failed...");
			Assert.assertNotNull(ViewTestPage.getInstance().executeTestInAdhoc(), "Navigated successfully to ExecuteTest page.");
			Assert.assertTrue(ExecuteTestsPage.getInstance().executeTestWithDefect(status, values.get("DEFECT_SUMMARY")));
			/*Assert.assertTrue(ViewTestPage.getInstance().navigateToExecuteTestPage().executeTest(status));
			Assert.assertTrue(ExecuteTestsPage.getInstance().addDefectToTest(values.get("DEFECT_SUMMARY")),"Validating Issue Failed...");
			*/
			Assert.assertTrue(ExecuteTestsPage.getInstance().navigateToDefect().checkIssueLinked());
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean validateRemoteIssueLink(Map<String, String> values) {
		String status="FAIL";
		try{
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values.get("SUMMARY"), values.get("PRIORITY")),"Test Creation Failed...");
			Assert.assertNotNull(ViewTestPage.getInstance().executeTestInAdhoc(), "Navigated successfully to ExecuteTest page.");
			Assert.assertTrue(ExecuteTestsPage.getInstance().executeTestWithDefect(status, values.get("DEFECT_SUMMARY")));
			
			/*Assert.assertTrue(ViewTestPage.getInstance().navigateToExecuteTestPage().executeTest(status));
			Assert.assertTrue(ExecuteTestsPage.getInstance().addDefectToTest(values.get("DEFECT_SUMMARY")),"Validating Issue Failed...");
			*/
			Assert.assertTrue(ExecuteTestsPage.getInstance().navigateToDefect().checkRemoteIssueLinked());
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean searchTestById() {
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().quickSearchById());
			logger.info("Test Searched Using ID Successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Map<String, List<String>> returnTests(){
		try{
			Map<String, List<String>> map = getZephyrTestMenuPage().navigateToSearchTestsPage().returnTests();
			Assert.assertTrue(map.size()==2, "MAp size is not equals to two");
			int ii=map.get("Test with Test Step").size();
			int iii=map.get("Test without Test Step").size();
			if( ii < 5){
				String testKey=null;
				// creating test step.
				for(int i=0; i< (5-ii); i++){
					testKey=getZephyrTestMenuPage().navigateToCreateTestPage()
							.createTests("Test with Test step", "Major", "Component1",  "Version 1.0" ,
									 "Version 1.0", "env2",  "sdgh", "ghg");
					for(int j=0; j< 5; j++){
					//Map<String, String> stepRowData = testStep.get(testStepSummary.get(i));
					ViewTestPage.getInstance().createTestStep("test"+j+1, "step"+j+1, "res"+j+1);
					logger.info("step "+(j+1)+" created");
					}
				}
				//testKeySet.put(summary, testKey);
				//logger.info(testKey + " is added to " + summary);
				map.get("Test with Test Step").add(testKey);
			}else if(iii<10){
				String testKey=null;
				for(int i=0; i< (10-iii); i++){
					testKey=getZephyrTestMenuPage().navigateToCreateTestPage()
							.createTests("Test with Test step", "Major", "Component1",  "Version 1.0" ,
									 "Version 1.0", "env2",  "sdgh", "ghg");
					map.get("Test without Test Step").add(testKey);
				}
			}
			return map;
		}catch(Exception e){
			
			return null;
		}
	}
	public List<String> getTest(List<String> list, String type){
		List<String> list1 = null;
		try{
			getZephyrTestMenuPage().navigateToSearchTestsPage();
			if(SearchTestsPage.getInstance().totalTests() > list.size()){
				list1=SearchTestsPage.getInstance().getTest(list);
				if(type.equals("test step")){
					navigateToTest(list1.get(list1.size() - 1));
					//for(int j=0; j< 5; j++){
						//Map<String, String> stepRowData = testStep.get(testStepSummary.get(i));
						ViewTestPage.getInstance().createTestSteps();
						//logger.info("step "+(j+1)+" created");
						//}
				}else{
					System.out.println("Not required test steps.");
				}
			}else{
				if(type.equals("test step")){
					String testKey=getZephyrTestMenuPage().navigateToCreateTestPage()
							.createTests("Test for execution", "Major", "Component1",  "Version 1.0" ,
									 "Version 1.0", "env2",  "sdgh", "ghg");
					ViewTestPage.getInstance().createTestSteps();
					list.add(testKey);
					list1 = list;
				}else{
					String testKey=getZephyrTestMenuPage().navigateToCreateTestPage()
							.createTests("Test for execution", "Major", "Component1",  "Version 1.0" ,
									 "Version 1.0", "env2",  "sdgh", "ghg");
					list.add(testKey);
					list1 = list;

				}
				
			}
			getZephyrTestMenuPage().navigateToSearchTestsPage();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			return list1;
		}catch(Exception e){
			return null;
		}
	}
	public List<String> getTests(int number){
		List<String> list1 = null;
		try{
			getZephyrTestMenuPage().navigateToSearchTestsPage();
			list1=SearchTestsPage.getInstance().getTests(number);
			Assert.assertNotNull(list1.size()>0,"tests are less.");
			return list1;
		}catch(Exception e){
			return null;
		}
	}
	public boolean navigateToTest(String testName){
		try{
			SearchTestsPage.getInstance().navigateToTest(testName);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean searchVersion(String versionName){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage().searchVersion(versionName), "Version is not searched successfully.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean switchViewFromEN(String viewOne, String viewTwo){
		try{
			Assert.assertTrue(getZephyrTestMenuPage()
					.navigateToSearchTestExecutionsPage()
					.changeView(viewOne), "Not changed the "+viewOne+" in Execution Navigator.");
			Assert.assertTrue(getZephyrTestMenuPage()
					.navigateToSearchTestExecutionsPage()
					.changeView(viewTwo), "Not changed the "+viewTwo+" in Execution Navigator.");
			Assert.assertTrue(getZephyrTestMenuPage()
					.navigateToSearchTestExecutionsPage()
					.changeView(viewOne), "Not changed the "+viewOne+" in Execution Navigator.");
			logger.info("Switching view from Execution Navigator is Successfully.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	@Override
	public boolean executeTestInDetailViewFromExecutionNavigator(Map<String, String> values){
		try{
			
			Assert.assertTrue(addTestToCycle(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME")),"Test is not added successfully.");
			logger.info("Test is added successfully to the cycle.");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.executeTestInDetailViewFromExecutionNavigator(values.get("ZQL_QUERY"), values.get("PROJECT_NAME"), values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("TEST_EXEC_STATUS")));
			/*Assert.assertTrue(zephyrTestMenuPage.navigateToSearchTestExecutionsPage().createExecFilterAndSaveToFavourite(values.get("ZQLQUERY"),values.get("EXECUTION_FILTER_NAME")),"Execution filter is not created and saved to favourite filters.");
			logger.info("Execution filter is created and saved to favourite filters.");
			int totalTests=SearchTestExecutionsPage.getInstance().totalTests();
			Assert.assertTrue(zephyrTestMenuPage.navigateToManageExecutionFiltersPage().searchExecFilterInManageExecFilter(values.get("EXECUTION_FILTER_NAME"), totalTests),"Execution filter is not searched in manage execution filter page.");
			logger.info("Execution filter is searched successfully in manage execution filter page.");*/
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean cloneTeststepInsertAfterStep(int teststep) {
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().cloneTeststepAfterStep(teststep));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean cloneTeststepByEnteringAValidNumber(int teststep, int cloneAt) {
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().cloneTeststepByEnteringAValidNumber(teststep, cloneAt));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean customizeColumnsInZqlGadget(String firstColumn,
			String secondColumn) {
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().customiseExecutionDetailGadget(firstColumn, secondColumn)," Falied...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//@Override
	public boolean navigateTestUsingPrevAndNextInDetailediew(String filterName){
		try{
			
			//Assert.assertTrue(addTestToCycle(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME")),"Test is not added successfully.");
			//logger.info("Test is added successfully to the cycle.");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.navigateTestUsingPrevAndNextInDetailediew(filterName), "Navigate Test using prev and Next is not successfully.");
			/*Assert.assertTrue(zephyrTestMenuPage.navigateToSearchTestExecutionsPage().createExecFilterAndSaveToFavourite(values.get("ZQLQUERY"),values.get("EXECUTION_FILTER_NAME")),"Execution filter is not created and saved to favourite filters.");
			logger.info("Execution filter is created and saved to favourite filters.");
			int totalTests=SearchTestExecutionsPage.getInstance().totalTests();
			Assert.assertTrue(zephyrTestMenuPage.navigateToManageExecutionFiltersPage().searchExecFilterInManageExecFilter(values.get("EXECUTION_FILTER_NAME"), totalTests),"Execution filter is not searched in manage execution filter page.");
			logger.info("Execution filter is searched successfully in manage execution filter page.");*/
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean navigateTestInFSUsingPrevAndNextInDetailedview(String filterName){
		try{
			
			
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.navigateTestInFullScreenUsingPrevAndNextInDetailedview(filterName), "Navigate to Test through Prev and Nextbutton in Detailed view is not successful.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean navigatePageInDetailediew(String filterName, String type){
		try{
			
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.navigatePageInDetailediew(filterName, type), "Navigate Page using Pagination is not successfully.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean customizeColumnDisplayEN(String filterName, String type){
		try{
			
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.customizeColumnDisplayEN(filterName, type), "Navigate Page is not successfully.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean restoreDefualtsColumnInEN(String filterName, String type){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.restoreDefualtsColEN(filterName, type), "Restore column and Reorder is not successfully.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean resetFilters(){
		try{		
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage()
					.deleteAllFilters(), "All filters are deleted successfully from Search Test Execution Page.");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage()
					.deleteAllFilters(), "All filters are deleted successfully from Search Test Page.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean resetGadget(){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().resetGadget(), "Gadgets are not deleted successfully.");
			logger.info("Gadgets are reseted successfully.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean bulkMoveTests(Map<String , String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestExecutionsPage().bulkMoveTestToCycle(values.get("OLD_CYCLE_NAME"), values.get("PROJ_NAME"), values.get("VERSION_NAME"), values.get("NEW_CYCLE_NAME"), Integer.parseInt(values.get("TOTAL_TESTS"))), "Bulk Move is not successful.");
			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
		
}
