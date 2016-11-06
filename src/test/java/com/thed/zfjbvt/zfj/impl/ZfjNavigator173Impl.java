package com.thed.zfjbvt.zfj.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.jira.JiraNavigatorFactory;
import com.thed.zfjbvt.jira.impl.jira52.JiraAdministrationPage;

import com.thed.zfjbvt.jira.impl.jira52.JiraLandingPage;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.zfj.ZfjNavigator;
import com.thed.zfjbvt.zfj.impl.zfj173.ExecuteTestsPage;
import com.thed.zfjbvt.zfj.impl.zfj173.PlanTestCyclePage;
import com.thed.zfjbvt.zfj.impl.zfj173.ViewTestPage;
import com.thed.zfjbvt.zfj.impl.zfj173.ZephyrTestMenuPage;
import com.thed.zfjbvt.zfj.impl.zfj22.ZFJAdminCustomizeStepStatusPage;
import com.thed.zfjbvt.zfj.impl.zfj22.ZFJAdminCustomizeTestStatusPage;

/**
 * This is the zfj navigator implementation class for zfj plugin 1.7.3.
 * @author Manoj
 *
 */

public class ZfjNavigator173Impl implements ZfjNavigator{
	
	private Logger logger = Logger.getLogger(this.getClass());
	private JiraLandingPage jiraLandingPage=JiraLandingPage.getInstance();
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateTestExecutionStatus(Map<String, String> values){
		try{
			Assert.assertTrue( ZFJAdminCustomizeTestStatusPage.getInstance().updateTestExecutionStatus(values));
			logger.info("Test execution status is updated successfully.");
			JiraAdministrationPage.getInstance().leavingAdministrationPage();//added by Karthik
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
			/*Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage()
					.navigateToCustomizeTestStatusTab()
					.addTestExecutionStatus(values),"Adding test execution status is not successfully.");
			logger.info("Test execution status is added successfully.");*/
			Assert.assertTrue( ZFJAdminCustomizeTestStatusPage.getInstance().addTestExecutionStatus(values));
			logger.info("Test execution status is updated successfully.");
			JiraAdministrationPage.getInstance().leavingAdministrationPage();//added by Karthik
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
	public boolean updateStepExecutionStatus(Map<String, String> values){
		try{
			/*Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage()
					.navigateToCustomizeStepStatusTab()
					.updateStepExecutionStatus(values),"Updating Step execution status is not successfully.");
			logger.info("Step execution status is added successfully.");*/
			JiraAdministrationPage.getInstance().leavingAdministrationPage();//added by Karthik
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
	public boolean addStepExecutionStatus(Map<String, String> values){
		try{
			/*Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage()
					.navigateToCustomizeStepStatusTab()
					.addStepExecutionStatus(values),"Adding step execution status is not added successfully.");
			logger.info("Step execution status is added successfully.");*/
			Assert.assertTrue( ZFJAdminCustomizeStepStatusPage.getInstance().updateStepExecutionStatus(values));
			logger.info("Step execution status is updated successfully.");
			JiraAdministrationPage.getInstance().leavingAdministrationPage();//added by Karthik
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
			Assert.assertTrue(addTestToCycle(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME")),"Adding test into cycle is not executed successfully.");
			
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME")), "Not navigated to execution page.");
					
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("TEST_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_NAME")+" is executed successfully.");
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
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME")).changeTestExcutionStatusWithDefect(values), "Test status with defect is not executed successfully.");
					
			Assert.assertTrue(PlanTestCyclePage.getInstance().validateTestExecutionWithDefect(values), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_NAME")+" is executed successfully.");
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
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME")).changeTestStatusWithDefectAndAttachment(values), "Test status with defect is not executed successfully.");
					
			Assert.assertTrue(PlanTestCyclePage.getInstance().validateTestExecutionWithDefect(values), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_NAME")+" is executed successfully.");
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
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME")), "Not navigated to execution status page");
					
			Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus("1", values.get("STEP_EXEC_STATUS_ONE")),"Step execution status is not verified successfully.");
			logger.info("Step one is executed successfully.");
			
			Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus("2", values.get("STEP_EXEC_STATUS_TWO")),"Step execution status is not verified successfully.");
			logger.info("Step two is executed successfully.");
			
			Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus("3", values.get("STEP_EXEC_STATUS_THREE")),"Step execution status is not verified successfully.");
			logger.info("Step three is executed successfully.");
			
			Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus("4", values.get("STEP_EXEC_STATUS_FOUR")),"Step execution status is not verified successfully.");
			logger.info("Step four is executed successfully.");
		
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
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME"))
					.changeStepExcutionStatus(values.get("STEP_NUM"), values.get("STEP_EXEC_STATUS")),"Step execution status is not verified successfully.");
					
			//Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus(values.get("STEP_NUM"), values.get("STEP_EXEC_STATUS")),"Step execution status is not verified successfully.");
			logger.info("Step is executed successfully.");
			
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
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME"))
					.changeStepExcutionStatusWithDefect(values), "Step is not executed with defect.");
			logger.info("Step is executed successfully with defect.");
			
			
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
			Assert.assertTrue(PlanTestCyclePage.getInstance().navigateToAddTestToCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME"))
					.addTestsUsingSpaceBar(values)
					.verifyAddedTestsInCycle(values),"Tests are not added successfully to the cycle.");
			logger.info("Tests are added successfully to the cycle.");
			
			//Assert.assertTrue(executeTest(values),"");
			//logger.info("Step is executed successfully with defect.");
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_ONE")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_ONE"), values.get("TEST_ONE_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_ONE")+" is executed successfully.");
			
			//Driver.driver.navigate().back();
			
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_TWO")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_TWO"), values.get("TEST_TWO_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_TWO")+" is executed successfully.");
			
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_THREE")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_THREE"), values.get("TEST_THREE_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_THREE")+" is executed successfully.");
			
			Assert.assertNotNull(PlanTestCyclePage.getInstance().navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_FOUR")), "Not navigated to execution page.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_FOUR"), values.get("TEST_FOUR_EXEC_STATUS")), "Test execution status is not verified successfully.");
			logger.info(values.get("TEST_FOUR")+" is executed successfully.");
			
			
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
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToExecuteTestsPageUsingE(values.get("VERSION_NAME"),values.get("CYCLE_NAME"), values.get("TEST_NAME")), "Not navigated to execution status page");
			Assert.assertTrue(PlanTestCyclePage.getInstance().executeAllStepsAndValidate(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("NUM_OF_STEPS_EXEC"), values.get("STEP_EXEC_STATUS")));
			logger.info("Test is executed Successfully with test step.");
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
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.executeTestDirectly(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("TEST_EXEC_STATUS")), "Test is not executed directly.");
			logger.info("Test is executed directly.");
			
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
			e.printStackTrace();
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
			//Assert.assertTrue(jiraLandingPage.quickSearchByID(values.get("TEST_ID")));
			
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
			/*Assert.assertTrue(jiraLandingPage.navigateToExecuteTestsPage()
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
	public boolean addTestsFromJiraSearch(Map<String, String> values){
		try{
			String totalTests=getZephyrTestMenuPage().navigateToSearchTestsPage().saveAsJiraSearch(values.get("FILTER_NAME"));
			logger.info("Filter is created and validated successfully.");
			
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToAddTestToCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME"))
					.addTestFromJiraSearch(values.get("FILTER_NAME"), totalTests), "Filter is not saved.");
			Assert.assertTrue(PlanTestCyclePage.getInstance().verifyAddedTest(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), totalTests), "Added tests are not verified in cycle.");
			logger.info("Added test is validated successfully.");
			logger.info("Filter tests added successfully to cycle.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean addTestsFromOtherCycle(Map<String, String> values){
		try{
			
			List<String> defectList=getZephyrTestMenuPage().navigateToPlanTestCyclePage().checkDefectsInCycle(values.get("VERSION_NAME"), values.get("OLD_CYCLE_NAME"));
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToAddTestToCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME"))
					.addTestFromOtherCycle(values.get("VERSION_NAME"), values.get("OLD_CYCLE_NAME")));
			logger.info("Tests are added successfully.");
					
			Assert.assertTrue(PlanTestCyclePage.getInstance().verifyAddedTest(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), Integer.toString(defectList.size())), "Added tests are not verified in cycle.");
			logger.info("Added test is validated successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean SearchByID(Map<String, String> values){
		try{
			//Assert.assertTrue(jiraLandingPage.quickSearchByID(values.get("TEST_ID")));
			
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
			Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage().validateCreateTestPage(),"launching Create Test Page Failed ");
			logger.info("Create Test page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().validateSearchTestPage(),"launching Search Test Page Failed");
			logger.info("Search Test Page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage().validatePlanTestCyclePage(),"launching Plan Test Cycle page Failed");
			logger.info("Plan Test Cycle Page Verified Successfully...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToExecuteTestsPage().validateExecuteTestCyclePage(),"launching Execute Test Cycle Page Failed");
			logger.info("Execute Test Cycle Page Verified Successfully...");
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
	
	/*@Override
	*//**
	 * {@inheritDoc}
	 *//*
	public boolean setFieldVisibilityInCreateIssueDialog(String firstField, String secondField){
		try{
			Assert.assertTrue(jiraLandingPage.navigateToCreateIssuePage().configureField(firstField, secondField));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	@Override
	/**
	 * {@inheritDoc}
	 */
	public boolean addStepsToTest(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage()
					.createTest(values).validateTestCreated(values));
			Assert.assertTrue(ViewTestPage.getInstance().addTeststeps(values));
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
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().reArrangeTestSteps(srcStep, destStep),"Teststep Re-Arrange Failed...");
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
			
			Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage().createTestWithSteps(values));
			Assert.assertTrue(ViewTestPage.getInstance().editTeststep(values));
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
			Assert.assertTrue(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values)
					.validateTestCreated(values),"New Test Creation Failed...");
			Assert.assertTrue(ViewTestPage.getInstance().navigateToEditTestPage(values).editTest(values));
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
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values.get("TEST_SUMMARY"), values.get("TEST_PRIORITY")));
			Assert.assertNotNull(jiraLandingPage.navigateToCreateIssuePage().createIssue(values.get("ISSUE_SUMMARY"), values.get("ISSUE_TYPE")));
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
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().quickSearch());
			logger.info("Test Searched Using ID Successfully...");
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
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().validateTestGadget());
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
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
		/*try{
			Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage().checkWorkflowToolbar());
			Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage().navigateToZFJAdminPage().changeWorkflowStatus());
			Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage().checkWorkflowToolbar());
					
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;*/
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
	 * {@inheritDoc}
	 */
	public boolean editGadget(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToTestMatricsPage().editGadget(values), "Gadget Edition Failed...");
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
	public boolean cloneTestCycle(Map<String, String> values){
		try{
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage()
					.navigateToCreateNewCyclePage(values)
					.createNewCycle(values), "Cycle is not created successfully.");
			logger.info(values.get("CYCLE_NAME")+" is created successfully.");
			String testId;
			Assert.assertNotNull(testId=getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values.get("TEST_SUMMARY"), values.get("TEST_PRIORITY")), "Test Creation Failed...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage().navigateToAddTestToCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME")).addTestsIndivisually(testId));
			Assert.assertTrue(getZephyrTestMenuPage().navigateToPlanTestCyclePage().navigateToClonetTestCyclePage(values.get("VERSION_NAME"), values.get("CYCLE_NAME")).cloneTestCycle(values),"Test Cycle Cloning Failed...");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/*@Override
	*//**
	 * {@inheritDoc}
	 *//*
	public boolean changeIssueLinkFormIssuesToTest(){

		String status="fail";
		try{

			Map<String, String> values= new HashMap<String, String>();
			values.put("SUMMARY", "Open default Browser and login to Gmail"); // summary of the new Test.
			values.put("PRIORITY", "Blocker"); // priority of new Test.
			Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage().checkIssueLink());

			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().navigateToExecuteTestPage().executeTest(status));

			Assert.assertTrue(ViewTestPage.getInstance().checkIssueLinked());
			Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
					.navigateToZFJAdminPage().changeIssueLinkStatus());
			Assert.assertNotNull(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values.get("SUMMARY"), values.get("PRIOIRITY")),"Test Creation Failed...");
			Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().navigateToExecuteTestPage().executeTest(status));
			Assert.assertTrue(ViewTestPage.getInstance().checkIssueLinked());
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	*//**
	 * {@inheritDoc}
	 *//*
	public boolean changeRemoteIssueLInkFormIssuesToTestExecution(){

		String status="fail";
		try{
			Map<String, String> values= new HashMap<String, String>();

		values.put("SUMMARY", "Open default Browser and login to Gmail"); // summary of the new Test.
		values.put("PRIORITY", "Blocker"); // priority of new Test.
		//checks remote issue link status.
		Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
				.navigateToZFJAdminPage().checkRemoteIssueLink());
		
		
		//executes the test by adding the issue as a defect.
		Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().navigateToExecuteTestPage().executeTest(status));
		//checks the test for remote issue link. 
		Assert.assertTrue(ViewTestPage.getInstance().checkRemoteIssueLinked());
		//changes remote issue link status.
		//Assert.assertTrue(jiraLandingPage.navigateToAdministrationPage()
		//		.navigateToZFJAdminPage().changeRemoteIssueLinkStatus());
		
		//creates a test for execution.
		Assert.assertNotNull(getZephyrTestMenuPage().navigateToCreateTestPage().createTest(values.get("SUMMARY"), values.get("PRIOIRITY")),"Test Creation Failed...");
		
		//executes the test by adding the issue as a defect.
		Assert.assertTrue(getZephyrTestMenuPage().navigateToSearchTestsPage().navigateToFirstTest().navigateToExecuteTestPage().executeTest(status));
		//checks the test for remote issue link.
		Assert.assertTrue(ViewTestPage.getInstance().checkRemoteIssueLinked());
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	*/
	
	
	/*@Override
	public boolean addTestExecutionDetailsGadget() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean viewTestExecutionDetailsGadget(String gadget) {
		throw new UnsupportedOperationException();
	}*/
	@Override
	public boolean changeBulkTestsStatus(String status, int totalTest) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean executePredefinedFilters(Map<String, String> values){
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean executeZQLQueryForFixVersion(Map<String, String> values){
		throw new UnsupportedOperationException();
	}
	/*@Override
	public boolean bulkAssociateDefect(int totalTest) {
		throw new UnsupportedOperationException();
	}*/
	@Override
	public boolean changeBulkTestsStatusWithTeststeps(String testStatus, String teststepStatus, int totaltest) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean createExecFilterAndSaveToFavourite(Map<String, String> values){
		
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean searchExecutionFilter(Map<String, String> values){
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean exportTestExecutions(Map<String, String> values){
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean deleteExecutions(Map<String, String> values){
		throw new UnsupportedOperationException();
	}

	/*@Override
	public boolean changeBulkTestStatusToUnexecutedWithDefectsCleared(int totalTest) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean bulkMoveTestsToCycle(String version, String cycle, int totalTest) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean bulkMoveTestsToCycleWithDefects(String version, String cycle, int totalTest) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean bulkMoveTestToCycleWithDefectsAndStatusNotCarried(String version, String cycle, int totalTest) {
		throw new UnsupportedOperationException();
	}
*/
	@Override
	public boolean searchExecFilterInManageExecFilter(Map<String, String> values){
		throw new UnsupportedOperationException();
	}

	/*@Override
	public boolean bulkCopyTestToCycleWithDefectsAndStatusNotCarried(String version, String cycle, int totalTest) {
		throw new UnsupportedOperationException();
	}*/
	@Override
	public boolean executeTestFromExecutionNavigator(Map<String, String> values){
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean executeTestDirectlyFromExecutionNavigator(Map<String, String> values){
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean executeZQLQueryForComponent(Map<String, String> values){
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, String> createMultipleTestsWithStep(){
		throw new UnsupportedOperationException();
	}
	@Override
	public Map<String, String> createMultipleTests(){
		throw new UnsupportedOperationException();
	}
		
	public ZephyrTestMenuPage getZephyrTestMenuPage() {
		return ZephyrTestMenuPage.getInstance(JiraNavigatorFactory.getInstance().getZephyrTestLink());
	}
	@Override
	public boolean validateTestsDropDown(){
		try{
			//Assert.assertTrue(getZephyrTestMenuPage().validateTestsDropdownMenu(), "Tests drop down is not verified.");
			logger.info("Test Drop down is validated successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean searchTestById() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean bulkAssociateDefect(String issueId, int totalTests) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean changeBulkTestStatusToUnexecutedWithDefectsCleared(String bugId, int totalTest) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean bulkMoveTestsToCycle(String version, String cycle,int totalTest) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean bulkMoveTestsToCycleWithDefects(String version,String cycle, String bugId, int totalTest) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean bulkMoveTestToCycleWithDefectsAndStatusNotCarried(String version, String cycle, String bugId, int totalTest) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean bulkCopyTestToCycleWithDefectsAndStatusNotCarried(String version, String cycle, String issueId, int totalTest) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean viewTestExecutionDetailsGadget() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean changeIssueLinkStatus() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean changeRemoteIssueLinkStatus() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean createTest(String summary, String priority) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean changeWorkflowStatus() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean validateWorkflowOptions() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean checkIssueLinkStatus() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean checkRemoteIssueLinkStatus() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean validateIssueLink(Map<String, String> values) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean validateRemoteIssueLink(Map<String, String> values) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean executeMultipleTests(Map<String, String> values) {
		throw new UnsupportedOperationException();
	}
	@Override
	public Map<String, List<String>> returnTests() {
		throw new UnsupportedOperationException();
	}
	@Override
	public List<String> getTest(List<String> list, String type) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean searchVersion(String versionName) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean switchViewFromEN(String viewOne, String viewTwo) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean executeTestInDetailViewFromExecutionNavigator(Map<String, String> values) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean navigateTestUsingPrevAndNextInDetailediew(String filterName) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean navigatePageInDetailediew(String filterName, String type) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean customizeColumnDisplayEN(String filterName, String type) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean restoreDefualtsColumnInEN(String filterName, String type) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean navigateTestInFSUsingPrevAndNextInDetailedview(String filterName) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean cloneTeststepInsertAfterStep(int teststep) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean cloneTeststepByEnteringAValidNumber(int teststep, int cloneAt) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean customizeColumnsInZqlGadget(String firstColumn,
			String secondColumn) {
		throw new UnsupportedOperationException();
	}
	//@Override
	public boolean resetData() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean resetFilters() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<String> getTests(int number) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteTestExecutionStatus(String testStatus) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteStepExecutionStatus(String stepStatus) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean resetGadget() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean bulkMoveTests(Map<String, String> values) {
		// TODO Auto-generated method stub
		return false;
	}
}
