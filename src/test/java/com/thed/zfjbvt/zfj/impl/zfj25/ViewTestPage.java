package com.thed.zfjbvt.zfj.impl.zfj25;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;




public class ViewTestPage {
	private Logger logger = Logger.getLogger(this.getClass());
	Map<String , String > returnValues=new HashMap<String, String>();
	/**
	 * This method will initialize all the webelements inside the View Issue Page and returns the page instance.
	 * @return This returns the View Issue Page instance.
	 */	
	public static ViewTestPage getInstance() {
		return PageFactory.initElements(Driver.driver, ViewTestPage.class);
	}
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	@FindBy(id="key-val")
	private WebElement keyValueInViewIssuePage;
	
	
	// Test execution status label
	@FindBy(xpath="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/thead/tr/th[text()='Status']")
	private WebElement xpathForStatusLabel;
	
	// Execute button present in view issue page.
	@FindBy(id="zephyr-je-add-execute")
	private WebElement executeButton;

	// Execute test popup header text.
	@FindBy(xpath="//div[@id='zephyr-je-add-execute-link']/h2")
	private WebElement executeTestPopupHeaderText;
	
	// Execute test in ad hoc radio button in execute test popup.
	@FindBy(xpath="//*[text()='Execute Ad Hoc']")
	private WebElement executeAdhocRadioBtn;
		
	// Execute button present inside execute test popup.
	@FindBy(xpath="//a[@id='zephyr-je-dlgclose']/following-sibling::a[text()='Execute']")
	private WebElement executeBtnInExecuteTestPopup;
	
	//Xpath for type of issue linked.
	@FindBy(xpath="//*[@class='mod-content']/dl/dd/div/p/img")
	private WebElement xpathForGettingIssueTypeLinked;
	
	
	//id to get the value of affected version.
	@FindBy(id="versions-val")
	private WebElement xpathToGetAffectedVersion;
	
	
	//id to get the value of compomnent.
	@FindBy(id="components-val")
	private WebElement xpathToGetComponent;
	
	
	
	//xpath to get the value of label.
	@FindBy(xpath=".//*[@id='wrap-labels']/div")
	private WebElement xpathToGetLabel;
	
	//xpath for start progress link of workflow in view test page.
	@FindBy(xpath="//*[text()='Start Progress']")
	private WebElement xpathOfStartProgressLink;

	//id for getting the user loggedin.
	@FindBy(id="header-details-user-fullname")
	private WebElement xpathForGettingUserLoggedIn;
		
	//id for getting the project that the test belongs to.
	@FindBy(id="project-name-val")
	private WebElement xpathForGettingProject;
	
	//id for getting the issue type.
	@FindBy(id="type-val")
	private WebElement xpathForGettingIssueType;
		
	//id of the testId of the Test.
	@FindBy(id="key-val")
	private WebElement xpathForTestId;
			
	//id of edit test button.
	@FindBy(xpath="//*[@id='edit-issue']/span[text()='Edit']")
	private WebElement xpathForEditTestButton;
	
	//id for getting test summary.
	@FindBy(id="summary-val")
	private WebElement xpathForGettingSummary;
		
	//id for getting the priority.
	@FindBy(id="priority-val")
	private WebElement xpathForGettingPriority;
		
	//Xpath for getting the environment.
	@FindBy(xpath="//*[@id='environment-val']/p")
	private WebElement xpathForGettingEnvironment;
		
	//Xpath for getting the description.
	@FindBy(xpath="//*[@id='description-val']/div/p")
	private WebElement xpathForGettingDescription;
		
	//Xpath for getting the assignee.
	@FindBy(xpath="//li[@class='people-details']/dl/dd/span[@id='assignee-val']")
	private WebElement xpathForGettingAssignee;
		
	//Xpath for getting the reporter.
	@FindBy(xpath="//li[@class='people-details']/dl/dd/span[@id='reporter-val']/span")
	private WebElement xpathForGettingReporter;
		
	//Xpath for getting the test creation date.
	@FindBy(xpath="//dl[dt[text()='Created:']]/dd")
	private WebElement xpathForGettingCreationDate;

	//Xpath for getting the test updation date.
	@FindBy(xpath="//dl[dt[text()='Updated:']]/dd")
	private WebElement xpathForGettingUpdationDate;
		
	//Xpath to add new teststep to a test.
	@FindBy(xpath="//*[@id='project-config-steps-table']/tbody[2]/tr/td[3]/textarea")
	private WebElement xpathForAddingTeststep;
		
	//Xpath to add new testdata to a test.
	@FindBy(xpath="//*[@id='project-config-steps-table']/tbody[2]/tr/td[4]/textarea")
	private WebElement xpathForAddingTestdata;
		
	//Xpath to add new expected result to a test.
	@FindBy(xpath="//*[@id='project-config-steps-table']/tbody[2]/tr/td[5]/textarea")
	private WebElement xpathForAddingExpectedResult;
		
	//Xpath of addButton which adds the new teststep added.
	@FindBy(xpath="//*[@type='submit'and @value='Add'and @class='aui-button']")
	private WebElement xpathForTeststepAddButton;
		
	//Xpath of update button of teststatus.
	@FindBy(xpath="//*[@value='Update']")
	private WebElement xpathToUpdateTeststep;
		
	//id of clone test button.
	@FindBy(id="clone-issue")
	private WebElement xpathToCloneTest;
		
	//Xpath for cloned by test confirmation message.
	@FindBy(xpath="//*[@class='mod-content']/dl/dt[@title='is cloned by']")
	private WebElement xpathToValidateClonedByTest;
		
	//Xpath for the test cloned by.
	@FindBy(xpath="//dl[dt[@title='is cloned by']]/dd/div/p/span/a")
	private WebElement xpathForTestClonedBy;
		
	//Xpath for the clones test confirmation message .
	@FindBy(xpath="//*[@class='mod-content']/dl/dt[@title='clones']")
	private WebElement xpathToValidateClonesTest;
		
	//Xpath for the test clones.
	@FindBy(xpath="//dl[dt[@title='clones']]/dd/div/p/span/a")
	private WebElement xpathForTestClones;
		
	//id for the link issue button.
	@FindBy(id="link-issue")
	private WebElement xpathToLinkTest;
	
			
	//Xpath for getting type of link.
	@FindBy(xpath="//*[@class='mod-content']/dl/dt")
	private WebElement xpathForGettingTypeOfLink;
	
					
	//id to get the value of fix version.
	@FindBy(id="fixfor-val")
	private WebElement xpathToGetFixVersion;
		
	//xpath for resolve issue link of workflow in view test page.
	@FindBy(xpath="//*[text()='Resolve Issue']")
	private WebElement xpathOfResolveIssueLink;
	
	//xpath for workflow link in view test page.
	@FindBy(xpath="//a/span[text()='Workflow']")
	private WebElement xpathOfWorkFlowLink;
	
	//xpath to validate issue link in view test page.
	@FindBy(xpath="//div[@id='linkingmodule']/div[@class='mod-content']//dt[text()='relates to']")
	private WebElement xpathToValidateIssueLink;
	
	//xpath to validate remote issue link in view test page.
	@FindBy(xpath="//div[@id='linkingmodule']/div[@class='mod-content']//dt[text()='Affects test execution of']")
	private WebElement xpathToValidateRemoteIssueLink;
	
	
	//xpath to get created date from view test page.
	@FindBy(xpath="//*[span[@id='create-date']]")
	private WebElement xpathToGetCreatedDate;
	
	//xpath to get updated date from view test page.
	@FindBy(xpath="//*[span[@id='updated-date']]")
	private WebElement xpathToGetUpdatedDate;
	
	//xpath for More Action button.
	@FindBy(xpath="//*[@id='opsbar-zephyr-je-manage-plan-top_more']")
	private WebElement xpathForMoreAction;
	
	//xpath for Test Executions
	@FindBy(xpath="//div[*[text()='Test Executions']]")
	private WebElement xpathForTestExecutions;
	
	//xpath of test detail history tab.
	@FindBy(xpath="//*[@id='je-audit-tabpanel']/strong")
	private WebElement xpathOfTestHistoryDetails;
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	public String getTestsID(){
		return xpathForTestId.getText();
	}
	/**
	 * This method is used to validate the test status in view issue page after execution.
	 * @param versionName This parameter contains version name which is used for selecting the version.
	 * @param cycleName This parameter contains the cycle name which is used for selecting a cycle.
	 * @param testExecStatus This parameter contains test execution status which is used for set the status while executing test.
	 * @return
	 */
	public boolean validateTestStatus(String versionName, String cycleName, String testExecStatus){
		try{
			Assert.assertTrue(CommonUtil.scrollPage(xpathForTestExecutions), "Page is not scrolled.");
			logger.info("Page is Scrolled Successfully to Test Executions.");
			
			Assert.assertTrue(validateTestExecutedStatus(versionName, cycleName, testExecStatus), "Test Execution Status is not Validated Successfully.");
			logger.info("Test Execution Status is Validated Successfully in View Issue Page.");
			
			/*CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForTestExecutionStatusInViewIssuePage="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			Assert.assertTrue(CommonUtil.scrollPage(CommonUtil.returnWebElement(xpathForTestExecutionStatusInViewIssuePage)), "Page is not scrolled.");
			logger.info("Page is scrolled successfully.");
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInViewIssuePage).equals(testExecStatus),"Test execution status is not matched in view issue page.");
			//logger.info("Test execution status is matched in view issue page.");
*/		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public CloneTestPage navigateToCloneTest(Map<String, String> values){
		try{
			CommonUtil.waitForStaleElement(xpathToCloneTest,Constants.IMPLICIT_WAIT_LOW);
			xpathToCloneTest.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
		return CloneTestPage.getInstance();
	}
				
	public boolean validateTestCreated(Map <String,String> values){
		CommonUtil.implicitWait(Constants.EXPLICIT_WAIT_MEDIUM);
		Map<String, String>testDetails = getAllTestDetails();
		String issueType="Test";
		try{
			CommonUtil.refreshPage();	
			String title=CommonUtil.getTitle();
			Assert.assertTrue(title.contains(testDetails.get("TESTID")) && (title.contains(testDetails.get("SUMMARY"))),"Not the same Test...");
			logger.info("Test "+testDetails.get("TESTID")+" "+testDetails.get("SUMMARY")+" created Successfully... ");
			Assert.assertTrue(xpathForGettingProject.getText().trim().equals(testDetails.get("PROJECT")), "Not the same Project selected");
			Assert.assertTrue(xpathForGettingIssueType.getText().equals(issueType),"Not a TEST");
			Assert.assertTrue(testDetails.get("SUMMARY").equals(values.get("SUMMARY")), "Not same Summary");
			Assert.assertTrue(testDetails.get("PRIORITY").equals(values.get("PRIORITY")), "Not same Priority");
			
			//Validate component.
			if(xpathToGetComponent.getText().contains("None")==false){
				List<String> actCompList=CommonUtil.getValues("//*[@id='issuedetails']/li[7]/div/span/span/a");
				int c=actCompList.size();
				for(int i=0;i<=c-1;i++){
					String component=actCompList.get(i);
					Assert.assertTrue(component.equals(values.get("COMPONENT")), "Not same Component");
					logger.info("Component Selected: "+component);
					}
				
			}
			else{
				logger.info("No Component is Selected...");
				
			}
			
			Assert.assertTrue(testDetails.get("ENVIRONMENT").equals(values.get("ENVIRONMENT")), "Not same Environment");
			Assert.assertTrue(testDetails.get("DESCRIPTION").equals(values.get("DESCRIPTION")), "Not same Description");
			Assert.assertTrue(xpathForGettingReporter.getAttribute("rel").equals(testDetails.get("REPORTER")));
			logger.info("Test Reported by: "+xpathForGettingReporter.getText()+"");
			
			//Validate affected version.
			if(xpathToGetAffectedVersion.getText().contains("None")==false){
				List<String> actAfctVersionList=CommonUtil.getValues("//*[@id='issuedetails']/li[5]/div/span/span/span");
				int a=actAfctVersionList.size();
				for(int i=0;i<=a-1;i++){
					String affectedVersion=actAfctVersionList.get(i);
					logger.info(affectedVersion+" : "+values.get("AFFECTED_VERSION"));
					Assert.assertEquals(affectedVersion, values.get("AFFECTED_VERSION"), "NOT Same AffectedVersion");
					logger.info("Affected Version Selected is: "+ affectedVersion);
				}
				
			}
			
			else{
				logger.info("No Affected Version is Selected...");
				
			}
						
			//Validate fix version.
			if(xpathToGetFixVersion.getText().contains("None")==false){
					List<String> actFixVersionList=CommonUtil.getValues("//*[@id='issuedetails']/li[6]/div/span/span/a");
					int f=actFixVersionList.size();
					for(int i=0;i<=f-1;i++){
						String fixVersion=actFixVersionList.get(i);
						Assert.assertEquals(fixVersion, values.get("FIX_VERSION"), "NOT Same FixVersion");
						logger.info("Fix Version Selected is: "+fixVersion);
					}
					
				}
				else{
					logger.info("No Fix Version is Selected...");
					
				}
				
			
			
			//Validate label.
			if(xpathToGetLabel.getText().contains("None")==false){
				List<String> lablesList=CommonUtil.getValues("//*[@id='wrap-labels']/div/ul/li/a/span");
				int l=lablesList.size();
				for(int i=0;i<=l-2;i++){
					String labels=lablesList.get(i);
					Assert.assertEquals(labels,values.get("LABEL"), "NOT Same Label");
					logger.info("Label Selected is: "+labels);
				}
				
			}
			else{
				
				logger.info("No Label is Selected...");
				}
				logger.info("Test created on: "+testDetails.get("CREATED_DATE")+"");
				logger.info("Test updated on: "+testDetails.get("UPDATED_DATE")+"");
				
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

		
	/**
	 * This method is used to validate test execution in view issue page i.e. It will validate status, executed user and executed time.
	 * @param versionName This parameter contains the version name.
	 * @param cycleName This parameter contains the cycle name.
	 * @param testExecStatus This parameter contains the test execution status of the test.
	 * @param executedUser This parameter contains the executed user name of the test.
	 * @param executedTime This parameter contains the execution time of a test after execution.
	 * @return The boolean value.
	 */
	public boolean validateTestStatus(String versionName, String cycleName, String testExecStatus, String executedUser, String executedTime){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(CommonUtil.scrollPage(xpathForTestExecutions), "Page is not scrolled.");
			logger.info("Page is Scrolled Successfully to Test Executions.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(validateTestExecutedStatus(versionName, cycleName, testExecStatus), "Test Execution Status is not Validated Successfully.");
			logger.info("Test Execution Status is Validated Successfully in View Issue Page.");
			
			Assert.assertTrue(validateTestExecutedUser(versionName, cycleName, executedUser), "Test Executed User is not Validated Successfully.");
			logger.info("Test Executed User is Validated Successfully in View Issue Page.");
			
			Assert.assertTrue(validateTestExecutedTime(versionName, cycleName, executedTime), "Test Executed time is not Validated Successfully.");
			logger.info("Test Executed time is Validated Successfully in View Issue Page.");
			//logger.info("Test Execution Status is Validated Successfully in View Issue Page.");
			/*String xpathForTestExecutionStatusInViewIssuePage="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			Assert.assertTrue(CommonUtil.scrollPage(CommonUtil.returnWebElement(xpathForTestExecutionStatusInViewIssuePage)), "Page is not scrolled.");
			logger.info("Page is scrolled successfully.");
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInViewIssuePage).equals(testExecStatus),"Test execution status is not matched in view issue page.");
			logger.info("Test execution status is matched in view issue page.");
			
			String xpathForExecutedUserInViewIssuePage="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/a[@class='user-hover']";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForExecutedUserInViewIssuePage).equals(executedUser),"Test execution status is not matched in view issue page.");
			logger.info("Executed user is matched in view issue page.");
			
			String xpathForExecutedTimeInViewIssuePage="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[contains(@id,'executed-on-schedule')]";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForExecutedTimeInViewIssuePage).equals(executedTime),"Test execution status is not matched in view issue page.");
			logger.info("Executed time is matched in view issue page.");*/
		}catch(Exception e){
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addTeststeps(Map <String,String> values){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(CommonUtil.getTitle().contains(getTestsID()),"View Issue page displayed is not the Test selected...");
			int totalTestSteps=Integer.parseInt(values.get("TOTAL_STEPS"));
			for(int i = 1; i<=totalTestSteps; i++){
				createTestStep(values.get("STEP_"+i+""), values.get("DATA_"+i+""), values.get("EXPECTED_RESULT_"+i+""));
				
			}
			validateTeststepAdded(values);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
		return true;
		
	}
			
public boolean validateTeststepAdded(Map <String,String> values){
	try{
		CommonUtil.refreshPage();
		List<String> totalTestStepsAdded=CommonUtil.getValues("//*[@id='project-config-versions-add']//tbody[@class='ui-sortable']/tr/td/span[@data-field-name='orderId']");
		for(int i = 1; i<=totalTestStepsAdded.size();i++){
			validateTeststep(values.get("STEP_"+i+""), values.get("DATA_"+i+""), values.get("EXPECTED_RESULT_"+i+""),i);
		}
		
	}
	catch(Exception e){
				e.printStackTrace();
				return false;
			}
	
	return true;
		
}
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.</br>
	 * This method is used to validate the test status and issue id in view issue page after execution.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * <b>ISSUE_ID</b> This parameter contains the issue id.</br>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	/*public boolean validateTestStatusWithDefect(Map<String, String> values){
		try{

			String xpathForTestExecutionStatusInViewIssuePage="//div[h3[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+values.get("VERSION_NAME")+"']/following-sibling::td[a[text()='"+values.get("CYCLE_NAME")+"']]/following-sibling::td/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInViewIssuePage).equals(values.get("TEST_EXEC_STATUS")),"Test execution status is not matched in view issue page.");
			logger.info("Test execution status is matched in view issue page.");

			String xpathForAddedDefectInViewIssuePage="//div[h3[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+values.get("VERSION_NAME")+"']/following-sibling::td[a[text()='"+values.get("CYCLE_NAME")+"']]/following-sibling::td[@class='zephyr-test-execution-entry-defect']/a";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForAddedDefectInViewIssuePage).equals(values.get("ISSUE_ID")),"Issue id is not matched in view issue page for the test.");
			logger.info("Issue is verified in view issue page for the test.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	
	/*

	/**
	 * Returns a boolean value to verify the method is executed successfully or not.</br>
	 * This method is used to validate the test status and issue id in view issue page after execution.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * <b>ISSUE_ID</b> This parameter contains the issue id.</br>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean validateTestStatusWithDefect(Map<String, String> values){
		try{
			Assert.assertTrue(CommonUtil.scrollPage(xpathForTestExecutions), "Page is not scrolled.");
			logger.info("Page is Scrolled Successfully to Test Executions.");
			
			Assert.assertTrue(validateTestExecutedStatus(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_EXEC_STATUS")), "Test Execution Status is not Validated Successfully.");
			logger.info("Test Execution Status is Validated Successfully in View Issue Page.");
			
			Assert.assertTrue(validateAddedDefectToTest(values.get("VERSION_NAME"), values.get("CYCLE_NAME"), values.get("TEST_NAME"), values.get("ISSUE_ID")));
			logger.info("Defect is validated Successfully in View Issue Page.");
			/*String xpathForTestExecutionStatusInViewIssuePage="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+values.get("VERSION_NAME")+"']/following-sibling::td[a[text()='"+values.get("CYCLE_NAME")+"']]/following-sibling::td/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			Assert.assertTrue(CommonUtil.scrollPage(CommonUtil.returnWebElement(xpathForTestExecutionStatusInViewIssuePage)), "Page is not scrolled.");
			logger.info("Page is scrolled successfully.");
			
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInViewIssuePage).equals(values.get("TEST_EXEC_STATUS")),"Test execution status is not matched in view issue page.");
			logger.info("Test execution status is matched in view issue page.");

			String xpathForAddedDefectInViewIssuePage="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+values.get("VERSION_NAME")+"']/following-sibling::td[a[text()='"+values.get("CYCLE_NAME")+"']]/following-sibling::td[@class='zephyr-test-execution-entry-defect']/a";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForAddedDefectInViewIssuePage).equals(values.get("ISSUE_ID")),"Issue id is not matched in view issue page for the test.");
			logger.info("Issue is verified in view issue page for the test.");*/
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
			
	public boolean validateCloneTest(Map<String, String> values){
		try{
			Assert.assertTrue(xpathToValidateClonesTest.isDisplayed(),"Test not cloned...");
			String testClones=xpathForTestClones.getText();
			Assert.assertTrue(ViewTestPage.getInstance().validateTestCreated(values),"Test cloned data doesn't match...");
			Assert.assertTrue(ViewTestPage.getInstance().validateTeststepAdded(values),"Teststep Validation Failed...");
			logger.info("Test Cloned Successfully...");
			CommonUtil.clickOnElement("//*[text()='"+testClones+"']");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(testClones.equals(xpathForTestId.getText()),"Not the same Test cloned...");
			Assert.assertTrue(xpathToValidateClonedByTest.isDisplayed());
			String testClonedBy= xpathForTestClonedBy.getText();
			logger.info("Test "+testClones+" is cloned by test "+testClonedBy+"");
			logger.info("Test "+testClonedBy+" clones test "+testClones+"");
			CommonUtil.clickOnElement("//*[text()='"+testClones+"']");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public ExecuteTestsPage navigateToExecuteTestPage(){
		try{
			executeButton.click();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return ExecuteTestsPage.getInstance();
	}
	
	

			
		
	
	public boolean editTeststep(Map<String, String>values){
			Map<String, String> oldStepDetails = new HashMap<String, String>();
			Map<String, String> newStepDetails = new HashMap<String, String>();
			try{
				logger.info("Test steps brfore editing...");
				displayTeststeps();
				oldStepDetails = getDetailsOfstep(Integer.parseInt(values.get("TEST_STEP_TO_EDIT")));
				
				String teststep=CommonUtil.getAttributeValue("//*[@id='project-config-steps-table']/tbody[@class='ui-sortable']/tr["+values.get("TEST_STEP_TO_EDIT")+"]","id");
				CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//*[@id='"+teststep+"']/td[3]")).build().perform();
				// To click on the Teststep and edit it.
				WebElement targetTeststep= CommonUtil.changeToWebElement("//*[@id='"+teststep+"']/td[3]/span");
				targetTeststep.click();
				CommonUtil.changeToWebElement("//*[@id='"+teststep+"']/td[3]/textarea").clear();
				CommonUtil.changeToWebElement("//*[@id='"+teststep+"']/td[3]/textarea").sendKeys(values.get("CHANGE_STEP_TO"));
				CommonUtil.changeToWebElement("//*[@id='"+teststep+"']/td[4]/textarea").clear();
				CommonUtil.changeToWebElement("//*[@id='"+teststep+"']/td[4]/textarea").sendKeys(values.get("CHANGE_DATA_TO"));
				CommonUtil.changeToWebElement("//*[@id='"+teststep+"']/td[5]/textarea").clear();
				CommonUtil.changeToWebElement("//*[@id='"+teststep+"']/td[5]/textarea").sendKeys(values.get("CHANGE_EXPECTED_RESULT_TO"));
				xpathToUpdateTeststep.click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
				newStepDetails = getDetailsOfstep(Integer.parseInt(values.get("TEST_STEP_TO_EDIT")));
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			validateTeststepAdded(getAllTeststepsDetails());
			validateTestDetailHistory(oldStepDetails, newStepDetails, Integer.parseInt(values.get("TEST_STEP_TO_EDIT")));
			
			return true;
	}
		
		public boolean validateTestDetailHistory(Map<String, String> oldDetails,Map<String, String> newDetails, int stepNumber){
			String id = null;
			try{
				CommonUtil.refreshPage();
				xpathOfTestHistoryDetails.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				for(int i = 1; i<=CommonUtil.getWebElements("//*[@class='issue-data-block']").size(); i++){
					id = (CommonUtil.getAttributeValue("//*[@id='testdetails-wrapper']/div[@class='issuePanelContainer']["+i+"]/div[@class='issue-data-block']", "id"));
					String field = CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[3]");
					if(field.equals("step")){
						Assert.assertTrue(CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[4]").equals(oldDetails.get("STEP_"+stepNumber+"")),"Not the same Old step Value displayed...");
						Assert.assertTrue(CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[5]").equals(newDetails.get("STEP_"+stepNumber+"")),"Not the same New step Value displayed...");
						logger.info("Old step Value: "+CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[4]"));
						logger.info("New step Value: "+CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[5]"));
					}
					else if(field.equals("result")){
						Assert.assertTrue(CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[4]").equals(oldDetails.get("EXPECTED_RESULT_"+stepNumber+"")),"Not the same Old result Value displayed...");
						Assert.assertTrue(CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[5]").equals(newDetails.get("EXPECTED_RESULT_"+stepNumber+"")),"Not the same New result Value displayed...");
						logger.info("Old result Value: "+CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[4]"));
						logger.info("New result Value: "+CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[5]"));
						
					}
					else{
						Assert.assertTrue(CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[4]").equals(oldDetails.get("DATA_"+stepNumber+"")));
						Assert.assertTrue(CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[5]").equals(newDetails.get("DATA_"+stepNumber+"")));
						logger.info("Old data Value: "+CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[4]"));
						logger.info("New data Value: "+CommonUtil.getValue("//div[@id='"+id+"']//table/tbody/tr/td[5]"));
						
					}
					
				}
				
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		
	/**
	 * This method is used to execute a test directly from view issue page.
	 * @param versionName This parameter contains the version name.
	 * @param cycleName This parameter contains the cycle name.
	 * @param testName This parameter contains the test name.
	 * @param testExecStatus This parameter contains the test execution status of the test.
	 * @return The Map which contains EXECUTED_BY and EXECUTED_ON.
	 */
	public Map<String , String> executeTestDirectly(String versionName, String cycleName, String testName, String testExecStatus){
		try{

			Assert.assertTrue(keyValueInViewIssuePage.getText().equals(testName), "Not in View Issue Page.");
			logger.info("View Issue Page is Verified Successfully.");
			
			String xpathForExecStatusLabel="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/div/div/div/dl/a[contains(@id,'executionStatus-labels-schedule-')]";
			CommonUtil.navigateThroughXpath(xpathForExecStatusLabel);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			String xpathForSelectTestStatus="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/div/div/select[contains(@id,'exec_status-schedule')]";
			CommonUtil.selectListWithVisibleText(CommonUtil.returnWebElement(xpathForSelectTestStatus), testExecStatus);
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			xpathForStatusLabel.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info("test is executed successfully directly.");
			
			String executedUser=getExecutedUser(versionName, cycleName);
			String executedTime=getExecutedTime(versionName, cycleName);
			
			
			Assert.assertTrue(validateTestStatus(versionName, cycleName, testExecStatus), "Test status is not verified successfully in view issue page.");
			logger.info("Test Status is validated Successfully in View Issue Page.");
			
			returnValues.put("EXECUTED_BY", executedUser);
			returnValues.put("EXECUTED_ON", executedTime);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return returnValues;
	}

			
	public LinkIssuePage navigateToLinkIssue(Map<String, String> values){
		try{
			values.put("TESTID", xpathForTestId.getText());
			try{
				xpathForMoreAction.click();
				xpathToLinkTest.click();
				
			}catch(Exception e){
				xpathToLinkTest.click();
			}
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);		
		}catch(Exception e){
			e.printStackTrace();
		}
		return LinkIssuePage.getInstance();
	}
	
	public boolean validateLinkIssue(Map<String, String> values){
		String issueTest="Test";
		String issueBug="Bug";
		String issueNewFeature="New Feature";
		String issueTask="Task";
		String issueImprovement="Improvement"; 
		try{
			String issueId=xpathForTestId.getText();
			if(CommonUtil.isObjectDisplayed("//dt[@title='"+values.get("LINKS")+"']")){
				String issueTypeLinked=CommonUtil.getAttributeValueUsingWebElements(xpathForGettingIssueTypeLinked, "alt");
				if(issueTypeLinked.contains(issueTest)){
					logger.info("Issue linked is Test");
				}
				else if(issueTypeLinked.contains(issueBug)){
					logger.info("Issue linked is Bug");
				}
				else if(issueTypeLinked.contains(issueNewFeature)){
					logger.info("Issue linked is New Feature");
				}
				else if(issueTypeLinked.contains(issueTask)){
					logger.info("Issue linked is Task");
				}
				else if(issueTypeLinked.contains(issueImprovement)){
					logger.info("Issue linked is Improvement");
				}
				Assert.assertTrue(CommonUtil.getValue("//dl[dt[@title='"+values.get("LINKS")+"']]/dd/div/p/span/a").equals(values.get("TESTID")),"Test Linked is not the same...");
				CommonUtil.scrollToWebElement(CommonUtil.changeToWebElement("//*[text()='"+values.get("TESTID")+"']"));
				CommonUtil.clickOnElement("//*[text()='"+values.get("TESTID")+"']");
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				String linkMsg=xpathForGettingTypeOfLink.getText();
				Assert.assertTrue(CommonUtil.getValue("//dl[dt[@title='"+linkMsg+"']]/dd/div/p/span/a").equals(issueId),"Test linked to is not the same...");
				String issueType[] = issueTypeLinked.split(" -"); 
				logger.info("Test "+issueId+" "+values.get("LINKS")+" "+issueType[0] +" " +values.get("TESTID")+"");
				logger.info(issueType[0]+" "+ values.get("TESTID")+" "+linkMsg+" Test " +issueId+"");
						
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public boolean reArrangeTestSteps(int srcStep, int destStep){
		try{
			displayTeststeps();
			logger.info("Teststeps before Re-arranging:");
			displayTestStep(srcStep);
			displayTestStep(destStep);
			Assert.assertTrue(dragAndDropTeststep(srcStep, destStep), "Not successful rearrenged.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
public boolean checkIssueLinked(){
		try{
			try{
				if(CommonUtil.isElementDisplayed(xpathToValidateIssueLink) == true){
					logger.info("Issue link enabled");
				}
				else{
					logger.info("Issue link disabled");
				}
				
			}catch(Exception e){
				logger.info("Issue link disabled");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		
		return true;
	}
	
	public boolean checkRemoteIssueLinked(){
		try{
			
			try{
				if(CommonUtil.isElementDisplayed(xpathToValidateRemoteIssueLink) == true){
				logger.info("Remote Issue link enabled");
				}
				else{
					logger.info(" Remote Issue link disabled");
				}
			}catch(Exception e){
				logger.info(" Remote Issue link disabled");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		
		return true;
	}

	public boolean validateQuickSearch(Map<String, String>values){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(xpathForTestId.getText().equals(values.get("TESTID")),"Not the same Testid");
			logger.info("TestId: "+xpathForTestId.getText()+"");
			Assert.assertTrue(xpathForGettingSummary.getText().equals(values.get("TESTSUMMARY")),"Not the same summary");
			logger.info("Test Summary: "+xpathForGettingSummary.getText()+"");
			Assert.assertTrue(xpathForGettingPriority.getText().equals(values.get("TESTPRIORITY")),"Not the same priority");
			logger.info("Test Priority: "+xpathForGettingPriority.getText()+"");
			Assert.assertTrue(xpathForGettingAssignee.getText().equals(values.get("TESTASSIGNEE")),"Not the same assignee");
			logger.info("Test Assigned To: "+xpathForGettingAssignee.getText()+"");
			Assert.assertTrue(xpathForGettingReporter.getText().equals(values.get("TESTREPORTER")),"Not the same Reporter");
			logger.info("Test Reporter By: "+xpathForGettingReporter.getText()+"");
			Assert.assertTrue(CommonUtil.getAttributeValueUsingWebElements(xpathToGetCreatedDate, "title").equals(values.get("TESTCREATEDDATE")),"not the same creation date");
			logger.info("Test Created On: "+CommonUtil.getAttributeValueUsingWebElements(xpathToGetCreatedDate, "title")+"");
			Assert.assertTrue(CommonUtil.getAttributeValueUsingWebElements(xpathToGetUpdatedDate, "title").equals(values.get("TESTUPDATEDDATE")),"not the same updation date");
			logger.info("Test Updated On: "+CommonUtil.getAttributeValueUsingWebElements(xpathToGetUpdatedDate, "title")+"");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Map<String, String> getAllTestDetails(){
		Map<String, String> values= new HashMap<String, String>();
		String jiraProject=Config.getValue("JIRA_PROJECT");
		try{
			values.put("TESTID",xpathForTestId.getText());
			values.put("SUMMARY",xpathForGettingSummary.getText());
			values.put("PRIORITY",xpathForGettingPriority.getText());
			values.put("ASSIGNEE", xpathForGettingAssignee.getText());
			values.put("REPORTER", xpathForGettingReporter.getText());
			values.put("CREATED_DATE", CommonUtil.getAttributeValueUsingWebElements(xpathToGetCreatedDate, "title"));
			values.put("UPDATED_DATE", CommonUtil.getAttributeValueUsingWebElements(xpathToGetUpdatedDate, "title"));
			values.put("ENVIRONMENT", xpathForGettingEnvironment.getText());
			values.put("DESCRIPTION",xpathForGettingDescription.getText());
			values.put("PROJECT", jiraProject);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return values;
		
	}
	
	
	public Map<String, String> getAllTeststepsDetails(){
		Map<String, String> values= new HashMap<String, String>();
		try{
			List<String> totalTestStepsAdded=CommonUtil.getValues("//*[@id='project-config-versions-add']//tbody[@class='ui-sortable']/tr/td/span[@data-field-name='orderId']");
			Assert.assertNotEquals(totalTestStepsAdded, 0,"Test steps are not present...");
			int testNo=totalTestStepsAdded.size();
			for(int i=1;i<=testNo;i++){
				String testStep=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+i+"']]]/td[3]/span");
				String testData=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+i+"']]]/td[4]/span");
				String expRes=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+i+"']]]/td[5]/span");
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				values.put("STEP_"+i+"",testStep);
				values.put("DATA_"+i+"",testData);
				values.put("EXPECTED_RESULT_"+i+"", expRes);
				
			}
				
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return values;
	}		
			
			
			
	/**
	 * This method is used to click on execute and schedule a test for execution.
	 * @return The plan test cyle instance.
	 */
	public PlanTestCyclePage executeTestInAdhoc(){
		try{

			executeButton.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to execute test popup.");
			Assert.assertTrue(selectExecAdhocAndExecute(), "Not selected execute adhoc link successfully.");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Test is scheduled Adhoc Successfully.");
		}catch(Exception e){
			e.printStackTrace();
		}
		return PlanTestCyclePage.getInstance();
	}
	public boolean dragAndDropTeststep(int sourceStep, int destinationStep){
		try{
			CommonUtil.scrollToWebElement(CommonUtil.returnWebElement("//div[@id='view_issue_steps_section']/descendant::*[text()='Test Details']"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String sourceStepId=CommonUtil.getAttributeValue("//*[@id='project-config-steps-table']/tbody[@class='ui-sortable']/tr["+sourceStep+"]","id");
			String destinationStepId=CommonUtil.getAttributeValue("//*[@id='project-config-steps-table']/tbody[@class='ui-sortable']/tr["+((destinationStep))+"]","id");
			WebElement sourceTestStep=CommonUtil.changeToWebElement("//*[@id='"+sourceStepId+"']/td[1]/span");
			WebElement destTestStep=CommonUtil.changeToWebElement("//*[@id='"+destinationStepId+"']/td[1]/span");
			Point prvLoc=CommonUtil.changeToWebElement("//*[@id='"+sourceStepId+"']/td[1]/span").getLocation();
			
			WebElement src = CommonUtil.returnWebElement("//*[@id='project-config-steps-table']/tbody/tr[td/span[@data-field-name='orderId'][text()='"+sourceStep+"']]/descendant::span[@class='jira-restfultable-draghandle']");
			WebElement dest = CommonUtil.returnWebElement("//*[@id='project-config-steps-table']/tbody/tr[td/span[@data-field-name='orderId'][text()='"+destinationStep+"']]/descendant::span[@class='jira-restfultable-draghandle']");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			//CommonUtil.actionClass().dragAndDrop(dest, src).build().perform();
			CommonUtil.actionClass().clickAndHold(dest).moveToElement(src).build().perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CommonUtil.actionClass().release().build().perform();
			//CommonUtil.actionClass().dragAndDrop(destTestStep,sourceTestStep).build().perform();
			//CommonUtil.actionClass().clickAndHold(sourceTestStep).moveToElement(destTestStep).release().build().perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			xpathForTestId.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Point currLoc=CommonUtil.changeToWebElement("//*[@id='"+sourceStepId+"']/td[1]/span").getLocation();
			String sourceStepIdAfter = CommonUtil.getAttributeValue("//*[@id='project-config-steps-table']/tbody[@class='ui-sortable']/tr["+destinationStep+"]","id");
			String destinationStepIdAfter = CommonUtil.getAttributeValue("//*[@id='project-config-steps-table']/tbody[@class='ui-sortable']/tr["+((sourceStep))+"]","id");
			logger.info("Source before :"+sourceStepId+":::"+"Source after :"+sourceStepIdAfter);
			logger.info("Destination before :"+destinationStepId+":::"+"Destination after :"+destinationStepIdAfter);
			//Assert.assertTrue(sourceStepId.equals(sourceStepIdAfter), "Source is not same");
			Assert.assertTrue(destinationStepId.equals(destinationStepIdAfter), "Destination is not same");
			//Assert.assertFalse(prvLoc.equals(currLoc),"Teststeps not Re-arranging");
			logger.info("Teststeps After Re-arranging:");
			displayTestStep(sourceStep);
			displayTestStep(destinationStep);
 		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
			
	public EditTestPage navigateToEditTestPage(Map<String, String>values){
		try{
			CommonUtil.waitForStaleElement(xpathForEditTestButton,Constants.IMPLICIT_WAIT_LOW);
			xpathForEditTestButton.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
		return EditTestPage.getInstance();
		
	}
	
	
	public boolean displayTeststeps(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			List<String> totalTestStepsAdded=CommonUtil.getValues("//*[@id='project-config-versions-add']//tbody[@class='ui-sortable']/tr/td/span[@data-field-name='orderId']");
			int testNo=totalTestStepsAdded.size();
			logger.info("total number of Teststeps: "+testNo+"");
			logger.info("Teststeps in the test are: ");
			for(int i=1;i<=testNo;i++){
					String teststep=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+i+"']]]/td[3]/span");
					String testdata=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+i+"']]]/td[4]/span");
					String expRes=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+i+"']]]/td[5]/span");
						logger.info("test step no: "+""+i+"");
						logger.info(teststep);
						logger.info(testdata);
						logger.info(expRes);
						logger.info("------------");
						}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean displayTestStep(int step){
		try{
			String teststep=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+step+"']]]/td[3]/span");
			String testdata=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+step+"']]]/td[4]/span");
			String expRes=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+step+"']]]/td[5]/span");
			
			logger.info("test step no: "+""+step+"");
			logger.info(teststep);
			logger.info(testdata);
			logger.info(expRes);
			logger.info("------------");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
		

	public boolean cloneTeststepAfterStep(int teststep){
		String clonedStep = null;
		try{
			clonedStep = navigateToCloneTeststepPage(teststep).appendAfterStep(teststep);
			Assert.assertNotNull(clonedStep,"Test step cloning failed...");
			validateClonedStep(clonedStep,(teststep+1));
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cloneTeststepByEnteringAValidNumber(int step, int cloneAt){
		String clonedStep = null;
		try{
			List<String> totalTestStepsAdded=CommonUtil.getValues("//*[@id='project-config-versions-add']//tbody[@class='ui-sortable']/tr/td/span[@data-field-name='orderId']");
			Assert.assertTrue(cloneAt<=(totalTestStepsAdded.size()+1),"step selected is Invalid...");
			clonedStep = navigateToCloneTeststepPage(step).insertAtStep(cloneAt, step);
			validateClonedStep(clonedStep, cloneAt);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateClonedStep(String stepValue,int step){
		try{
			validateTeststep(getDetailsOfstep(step).get("STEP_"+step+""), getDetailsOfstep(step).get("DATA_"+step+"") , getDetailsOfstep(step).get("EXPECTED_RESULT_"+step+""), step);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	/**
	 * This method is used to get the executed user name from view issue page.
	 * @param versionName This parameter contains the version name.
	 * @param cycleName This parameter contains the cycle name.
	 * @return The String Value.
	 */
	private String getExecutedUser(String versionName, String cycleName){
		String executedUser = null;
		try{
			String xpathForExecutedUser = "//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/a[@class='user-hover']";
			executedUser = CommonUtil.getTextFromUIByXpath(xpathForExecutedUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return executedUser;
	}
	/**
	 * This method is used to get the executed time in view issue page after executed a test.
	 * @param versionName This parameter contains the version name.
	 * @param cycleName This parameter contains the cycle name.
	 * @return The String Value.
	 */
	private String getExecutedTime( String versionName, String cycleName ){
		String executedTime = null;
		try{
			String xpathForExecutedTime = "//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[contains(@id,'executed-on-schedule')]";
			executedTime = CommonUtil.getTextFromUIByXpath( xpathForExecutedTime );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return executedTime;
	}
	/**
	 * This method is used to schedule a test for execution 
	 * @return The boolean value.
	 */
	private boolean selectExecAdhocAndExecute(){
		try{
			//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			//Assert.assertTrue(executeTestPopupHeaderText.getText().equals("Execute Test"), "Execute Test popup is not verified successfully.");
			//logger.info("Execute Test popup is verified successfully.");
			logger.info("Navigated to Execute Test popup successfully.");
			executeAdhocRadioBtn.click();
			executeBtnInExecuteTestPopup.click();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public boolean checkWorkflowToolbar(){
		try{
			if(CommonUtil.isObjectDisplayed("//*[text()='Start Progress']") && CommonUtil.isObjectDisplayed("//*[text()='Resolve Issue']")){
				logger.info("Workflow toolbar is selected");
			}
			else{
				logger.info("Workflow toolbar is deselected");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public CloneTeststepPage navigateToCloneTeststepPage(int teststep){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info("Navigating to Clone step page.");
			String stepId=CommonUtil.getAttributeValue("//*[@id='project-config-steps-table']/tbody[@class='ui-sortable']/tr["+teststep+"]","id");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			WebElement teststepOptions=CommonUtil.changeToWebElement("//*[@id='"+stepId+"']/td[6]//span");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//tbody[@class='ui-sortable']/tr[td[span[text()='"+teststep+"']]]")).perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().moveToElement(teststepOptions).perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			teststepOptions.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String action[] = stepId.split("-row");
			String clone = action[0]+"-action-clone";
			CommonUtil.clickOnElement("//*[@id='"+clone+"']");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return CloneTeststepPage.getInstance();
	}
	
	private Map<String,String> getDetailsOfstep(int stepNo){
		Map<String,String> stepDetails = new HashMap<String, String>();
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String testStep=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+(stepNo)+"']]]/td[3]/span");
			String testData=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+(stepNo)+"']]]/td[4]/span");
			String expRes=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+(stepNo)+"']]]/td[5]/span");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			stepDetails.put("STEP_"+(stepNo)+"",testStep);
			stepDetails.put("DATA_"+(stepNo)+"",testData);
			stepDetails.put("EXPECTED_RESULT_"+(stepNo)+"", expRes);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return stepDetails;
	}
	
	private void addOneTeststep(Map<String, String> values){
		try{
			xpathForAddingTeststep.sendKeys(values.get("FIRST_STEP"));
			xpathForAddingTestdata.sendKeys(values.get("FIRST_DATA"));
			xpathForAddingExpectedResult.sendKeys(values.get("FIRST_EXPECTED_RESULT"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForTeststepAddButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void addTwoTeststeps(Map<String, String> values){
		try{
			addOneTeststep(values);			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForAddingTeststep.sendKeys(values.get("SECOND_STEP"));
			xpathForAddingTestdata.sendKeys(values.get("SECOND_DATA"));
			xpathForAddingExpectedResult.sendKeys(values.get("SECOND_EXPECTED_RESULT"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForTeststepAddButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void addThreeTestSteps(Map<String, String>values){
		try{
					
			addTwoTeststeps(values);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForAddingTeststep.sendKeys(values.get("THIRD_STEP"));
			xpathForAddingTestdata.sendKeys(values.get("THIRD_DATA"));
			xpathForAddingExpectedResult.sendKeys(values.get("THIRD_EXPECTED_RESULT"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForTeststepAddButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void addFourTestSteps(Map<String, String> values){
		try{
			addThreeTestSteps(values);			
			xpathForAddingTeststep.sendKeys(values.get("FOURTH_STEP"));
			xpathForAddingTestdata.sendKeys(values.get("FOURTH_DATA"));
			xpathForAddingExpectedResult.sendKeys(values.get("FOURTH_EXPECTED_RESULT"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForTeststepAddButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void addFiveTeststeps(Map<String, String> values){
		try{
			addFourTestSteps(values);
			xpathForAddingTeststep.sendKeys(values.get("FIFTH_STEP"));
			xpathForAddingTestdata.sendKeys(values.get("FIFTH_DATA"));
			xpathForAddingExpectedResult.sendKeys(values.get("FIFTH_EXPECTED_RESULT"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForTeststepAddButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void validateOneTeststeps(Map<String, String>values){
		String teststep;
		String testdata;
		String expRes;
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			teststep=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+1+"']]]/td[3]/span");
			testdata=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+1+"']]]/td[4]/span");
			expRes=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+1+"']]]/td[5]/span");
			Assert.assertTrue(teststep.equals(values.get("FIRST_STEP"))&&(testdata.equals(values.get("FIRST_DATA")))&&(expRes.equals(values.get("FIRST_EXPECTED_RESULT"))),"Teststeps are not same");
				logger.info("test step no: "+""+1+"");
				logger.info(teststep);
				logger.info(testdata);
				logger.info(expRes);
				logger.info("--------------");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void validateTwoTeststeps(Map<String, String> values){
		String teststep;
		String testdata;
		String expRes;
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			validateOneTeststeps(values);
			teststep=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+2+"']]]/td[3]/span");
			testdata=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+2+"']]]/td[4]/span");
			expRes=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+2+"']]]/td[5]/span");
			Assert.assertTrue(teststep.equals(values.get("SECOND_STEP"))&&(testdata.equals(values.get("SECOND_DATA")))&&(expRes.equals(values.get("SECOND_EXPECTED_RESULT"))),"Teststeps are not same");
				logger.info("test step no: "+""+2+"");
				logger.info(teststep);
				logger.info(testdata);
				logger.info(expRes);
				logger.info("--------------");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void validateThreeTeststeps(Map<String, String>values){
		String teststep;
		String testdata;
		String expRes;
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			validateTwoTeststeps(values);
			teststep=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+3+"']]]/td[3]/span");
			testdata=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+3+"']]]/td[4]/span");
			expRes=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+3+"']]]/td[5]/span");
			Assert.assertTrue(teststep.equals(values.get("THIRD_STEP"))&&(testdata.equals(values.get("THIRD_DATA")))&&(expRes.equals(values.get("THIRD_EXPECTED_RESULT"))),"Teststeps are not same");
				logger.info("test step no: "+""+3+"");
				logger.info(teststep);
				logger.info(testdata);
				logger.info(expRes);
				logger.info("--------------");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void validateFourTeststeps(Map<String, String> values){
		String teststep;
		String testdata;
		String expRes;
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			validateThreeTeststeps(values);
			teststep=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+4+"']]]/td[3]/span");
			testdata=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+4+"']]]/td[4]/span");
			expRes=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+4+"']]]/td[5]/span");
			Assert.assertTrue(teststep.equals(values.get("FOURTH_STEP"))&&(testdata.equals(values.get("FOURTH_DATA")))&&(expRes.equals(values.get("FOURTH_EXPECTED_RESULT"))),"Teststeps are not same");
				logger.info("test step no: "+""+4+"");
				logger.info(teststep);
				logger.info(testdata);
				logger.info(expRes);
				logger.info("--------------");
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	private void validateFiveTeststeps(Map<String, String> values){
		String teststep;
		String testdata;
		String expRes;
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			validateFourTeststeps(values);
			teststep=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+5+"']]]/td[3]/span");
			testdata=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+5+"']]]/td[4]/span");
			expRes=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+5+"']]]/td[5]/span");
			Assert.assertTrue(teststep.equals(values.get("FIFTH_STEP"))&&(testdata.equals(values.get("FIFTH_DATA")))&&(expRes.equals(values.get("FIFTH_EXPECTED_RESULT"))),"Teststeps are not same");
				logger.info("test step no: "+""+5+"");
				logger.info(teststep);
				logger.info(testdata);
				logger.info(expRes);
				logger.info("--------------");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean createTestStep(String testStep, String testData, String testRes){
		try{
			xpathForAddingTeststep.sendKeys(testStep);
			xpathForAddingTestdata.sendKeys(testData);
			xpathForAddingExpectedResult.sendKeys(testRes);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForTeststepAddButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateTeststep(String step, String data, String exp_res,int teststepNumber){
		String teststep;
		String testdata;
		String expRes;
		try{
			teststep=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+teststepNumber+"']]]/td[3]/span");
			testdata=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+teststepNumber+"']]]/td[4]/span");
			expRes=CommonUtil.getValue("//tbody[@class='ui-sortable']/tr[td[span[text()='"+teststepNumber+"']]]/td[5]/span");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(teststep.equals(step)&&(testdata.equals(data)&&(expRes.equals(exp_res))),"Teststeps are not same");
				logger.info("test step no: "+teststepNumber+"");
				logger.info(teststep);
				logger.info(testdata);
				logger.info(expRes);
				logger.info("--------------");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	private boolean validateTestExecutedStatus(String versionName, String cycleName, String testExecStatus){
		try{
			String xpathForTestExecutionStatus="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			//Assert.assertTrue(CommonUtil.scrollPage(CommonUtil.returnWebElement(xpathForTestExecutionStatusInViewIssuePage)), "Page is not scrolled.");
			//logger.info("Page is scrolled successfully.");
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatus).equals(testExecStatus),"Test execution status is not matched in view issue page.");
			//logger.info("Test execution status is matched in view issue page.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean validateTestExecutedUser(String versionName, String cycleName, String executedUser){
		try{
			String xpathForExecutedUser="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/a[@class='user-hover']";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForExecutedUser).equals(executedUser),"Test execution status is not matched in view issue page.");
			//logger.info("Executed user is matched in view issue page.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean validateTestExecutedTime(String versionName, String cycleName, String executedTime){
		try{
			//String xpathForExecutedTime="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[contains(@id,'executed-on-schedule')]";
			String xpathForExecutedTime = "//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr[td[text()='"+versionName+"']][td[a[text()='"+cycleName+"']]]/td[contains(@id,'executed-on-schedule')]";
			String executedTimeInViewIssuePage = CommonUtil.getTextFromUIByXpath(xpathForExecutedTime);
			logger.info("Executed time for test in view Issue Page :"+executedTimeInViewIssuePage);
			//Assert.assertTrue(executedTimeInViewIssuePage.equals(executedTime),"Test execution status is not matched in view issue page.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean validateAddedDefectToTest(String versionName, String cycleName, String testName, String defectID){
		try{
			String xpathForAddedDefect="//div[*[text()='Test Executions']]/following-sibling::div/table[@id='ztestSchedulesTable']/tbody/tr/td[text()='"+versionName+"']/following-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[@class='zephyr-test-execution-entry-defect']/div";
			Assert.assertTrue(CommonUtil.getAttributeValue(xpathForAddedDefect, "data-issuekey").equals(testName), "This test is different in View Issue Page.");
			logger.info("Test Selected Same in View Issue Page.");
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForAddedDefect).contains(defectID),"Defect id is not matched in View Issue Page");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public int totalAssociateSteps(){
		int totalSteps=0;
		try{
			List<WebElement> list = CommonUtil.getWebElements("//table[@id='project-config-steps-table']/tbody[@class='ui-sortable']/tr[contains(@id,'step')]");
			if(list.size() == 0){
				
			}else{
				totalSteps = list.size();
			}
			return totalSteps;
		}catch(Exception e){
			e.printStackTrace();
			return totalSteps;
		}
	}
	public boolean createTestSteps(){
		try{
			int steps = totalAssociateSteps();
			if(steps < 5){
				for(int i=0;i < (5-steps); i++){
					createTestStep("test"+(i+1), "step"+(i+1), "res"+(i+1));
					//CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					logger.info("step "+(i+1)+" created successfully");
				}
			}else{
				logger.info("Steps are 5 or greater than 5.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
