package com.thed.zfjbvt.zfj.impl.zfj22;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.jira.JiraNavigatorFactory;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class ExecuteTestsPage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	public static ExecuteTestsPage getInstance() {
		return PageFactory.initElements(Driver.driver, ExecuteTestsPage.class);
	}
	Map<String, String> returnValues = null;
	
	
/******************************************************
 * 	WEBELEMENTS
 *****************************************************/

	@FindBy(xpath="//*[@id='zexecute']/fieldset/div/label[@for='executionStatus']/following-sibling::div/descendant::dd/following-sibling::a")
	private WebElement xpathForChangeTestExecStatusLabel;

	// xpath for execution page test execution status label. 
	@FindBy(xpath="//*[@id='zexecute']/fieldset/div/label[@for='executionStatus']/following-sibling::div/descendant::dd/following-sibling::a")
	private WebElement xpathForChangeTestExecutionStatusLabel;

	// xpath for the test status select box.
	@FindBy(xpath="//form[@id='zexecute']/fieldset/div/div/select")
	private WebElement selectStatusOfTestExecStatus;
	
	// Execution page execution status Text.
	@FindBy(xpath="//label[contains(text(),'Execution Status:')]")
	private WebElement executionStatusText;
	
	// Successful execution message after execution .
	@FindBy(xpath="//div[@id='aui-message-bar']/div")
	private WebElement xpathForSuccessfulExecutedTestMessage;
	
	// Xpath for current execution status of the test.
	@FindBy(xpath="//label[contains(text(),'Execution Status:')]/following-sibling::div/div[@class='labels exec-status-container']/dl/div/dd[contains(@id,'current-execution-status')]")
	private WebElement xpathForTestExecutionStatus;
	
	// Test executed by user
	@FindBy(xpath="//a[@class='user-hover']")
	private WebElement xpathForTestExecutedByUser;
	
	// Test executed on time
	@FindBy(xpath="//span[contains(@id,'executed-on')]")
	private WebElement xpathForTestExecutedOnTime;
	
	//Return to test cycle
	@FindBy(xpath="//*[@id='zephyr-je-block-back-to-cycle']")
	private WebElement returnToTestCycle;
	
	// Defect label xpath i.e. for creating a defect first click on defect label then create the status.
	@FindBy(xpath="//label[contains(text(),'Defects:')]/following-sibling::div/div/dl/div[@class='execution-defects-wrapper zfj-editable-field']/a")
	private WebElement xpathForDefectLabelToClick;
	
	// Submit button while changing a status
	@FindBy(xpath="//label[@for='executionStatus']/following-sibling::div/div[@class='update_cancel-buttons']/button[contains(@id,'exec_status_update-schedule-')]")
	private WebElement xpathForStatusSubmitBtn;
	
	
	//Return to search test execution.
	@FindBy(id="return-to-search")
	private WebElement returnToSearch;
	/*// Create new issue link for creating a defect.
	@FindBy(xpath="//a[contains(text(),'Create New Issue')]")
	private WebElement createNewIssueLink;
	
	// Defect test label for saving the defect.
	@FindBy(xpath="//label[contains(text(),'Defects:')]")
	private WebElement defectLabelInExecuteTestsPage;
	
	// get the current defect picker.
	@FindBy(id="current-defectpicker-status-dd-schedule")
	private WebElement currentDefectPicker;
	
	// Test level attachment 
	@FindBy(xpath="//*[text()='Attachments (Execution)']/preceding-sibling::ul/li/a[@id='add-attachments-link']")
	private WebElement testAttachmentLink;
	
	// Attachment popup browse button.
	@FindBy(xpath="//input[@class='ignore-inline-attach upfile' and @name='tempFilename']")
	private WebElement browseBtnOfAttchmentFile;
	
	// Attachment popup comment area.
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement commentForAttchment;
	
	// Attachment popup attach button.
	@FindBy(id="attach-file-submit1")
	private WebElement attachBtn;*/
	
	/*// This is the web element by which we can know the files are attached
	@FindBy(xpath="//div[*[text()='Attachments (Execution)']]/following-sibling::div/ol/li/dl/dt/a")
	private WebElement viewAttachment;
	
	
	
	 These web elements are related to test step only
	// Label of  step status for changing the status.
	@FindBy(xpath="//*[@id='zexecute']/fieldset/div/label[@for='executionStatus']/following-sibling::div/descendant::dd/following-sibling::a")
	private WebElement xpathForChangeStepExecStatusLabel;
	
	@FindBy(xpath="//form[@id='zexecute']/fieldset/div/div/select")
	private WebElement xpathForSelectStepExecStatus;
	
	
	//autoSuggest popup status text.
	@FindBy(xpath="//div[@id='schedule-confirmation-dialog']/div/form/div[@class='form-body']")
	private WebElement autoSuggestPopupStatusText;
	
	// Execute button while executing all steps into one status.
	@FindBy(xpath="//input[@id='attachment-delete-form-submit']")
	private WebElement executeBtnInAllStepExecIntoOneStatus;*/
	
	//Test id in execute test page.
	@FindBy(xpath="//*[@id='content']/header/div/ul[1]/li[4]/a")
	private WebElement testIdToexecute;
	
	//Execute Test button.
	@FindBy(xpath="//*[@class='aui-button floatright'][text()='Execute']")
	private WebElement executeTestButton;
	
	//link to select the status of the Test.
	@FindBy(xpath="//div[label[@for='executionStatus']]//a")
	private WebElement linkToSelectExecutionStatus;
	
	//xpath to get the detail of executed by.
	@FindBy(xpath="//div[label[@for='executedBy']]//a")
	private WebElement executedBy;
	
	//xpath to get executed on details.
	@FindBy(xpath="//div[label[@for='executedOn']]//span[2]")
	private WebElement executedOn;
	
	//xpath to add defect.
	@FindBy(xpath="//div[label[@for='defects']]//a")
	private WebElement addDefectLink;
	
	//xapth to add issue.
	@FindBy(xpath="//div[label[@for='defects']]/div[2]/div/div/textarea")
	private WebElement addDefectTxtbox;
	
	//xpath to validate the issue added as defect.
	@FindBy(xpath="//div[label[@for='defects']]//a")
	private WebElement validateDefectAdded;
	
	//xpath to navigate back to view test page.
	@FindBy(id="zephyr-je-block-back-to-test")
	private WebElement navigateBackToTest;
	// Create new issue link for creating a defect.
	@FindBy(xpath="//a[contains(text(),'Create New Issue')]")
	private WebElement createNewIssueLink;
			
	// Defect test label for saving the defect.
	@FindBy(xpath="//label[contains(text(),'Defects:')]")
	private WebElement defectLabelInExecuteTestsPage;
	
	@FindBy(id="zephyr_je_create_issue_link-schedule-update")
	private WebElement updateDefectButton;
	
	// get the current defect picker.
	@FindBy(id="current-defectpicker-status-dd-schedule")
	private WebElement currentDefectPicker;
		
	// Test level attachment 
	@FindBy(xpath="//*[text()='Attachments (Execution)']/preceding-sibling::ul/li/a[@id='add-attachments-link']")
	private WebElement testAttachmentLink;
			
	// Attachment popup browse button.
	@FindBy(xpath="//input[@class='ignore-inline-attach upfile' and @name='tempFilename']")
	private WebElement browseBtnOfAttchmentFile;
		
	// Attachment popup comment area.
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement commentForAttchment;
			
	// Attachment popup attach button.
	@FindBy(xpath="//input[@id='attach-file-submit1']")
	private WebElement attachBtn;
			
	// This is the web element by which we can know the files are attached
	@FindBy(xpath="//div[*[text()='Attachments (Execution)']]/following-sibling::div/ol/li/dl/dt/a")
	private WebElement viewAttachment;
			
	
	/* These web elements are related to test step only*/
	// Label of  step status for changing the status.
	@FindBy(xpath="//*[@id='zexecute']/fieldset/div/label[@for='executionStatus']/following-sibling::div/descendant::dd/following-sibling::a")
	private WebElement xpathForChangeStepExecStatusLabel;
			
	@FindBy(xpath="//form[@id='zexecute']/fieldset/div/div/select")
	private WebElement xpathForSelectStepExecStatus;
			
			
	//autoSuggest popup status text.
	@FindBy(xpath="//div[@id='schedule-confirmation-dialog']/div/form/div[@class='form-body']")
	private WebElement autoSuggestPopupStatusText;
			
	// Execute button while executing all steps into one status.
	@FindBy(xpath="//input[@id='attachment-delete-form-submit']")
	private WebElement executeBtnInAllStepExecIntoOneStatus;
	
	//id for quick search input in search test page.
	@FindBy(id="quickSearchInput")
	private WebElement xpathToQuickSearchTest;
	
	//xpath to update the status.
	@FindBy(xpath="//*[@class='exec_status_update-schedule zfj-button submit']")
	private WebElement updateStatus;
	
	@FindBy(xpath="//*[contains(@id, 'execution_update-schedule') and @class='zfj-button submit']")
	private WebElement stepStatusUpdateButton;
	
	@FindBy(xpath= "//*[@id='next-execution']/span")
	private WebElement nextExecution;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	/**
	 * This method is used to change the test execution status while execution of  a test.
	 * @param testExecStatus This parameter contains test execution status which is used for set the status while executing test.
	 * @return The Map<String , String> values.
	 */
	public Map<String , String> changeTestExcutionStatus(String testExecStatus){
		returnValues = new HashMap<String, String>();
		try{
			Assert.assertTrue( validatePage(), "Execute Test Page is not Validated Successfully.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue( executeTestStatus(testExecStatus), "Test status is not changed successfully.");
						
			String executedBy = getExecutedUser();
			Assert.assertNotNull( executedBy, "Test is not executed, So User is not available.");
						
			String executedOn = getExecutedTime();
			Assert.assertNotNull( executedOn, "Test is not executed, So Time is not available.");
						
			Assert.assertTrue(returnToTestCycle(), "Not Returned to Plan Test Cycle Page.");				
			
			returnValues.put("executedUser", executedBy);
			returnValues.put("executedTime", executedOn);
		}catch(Exception e){
			e.printStackTrace();
			return returnValues;
		}
		return returnValues;
	}
	public Map<String , String> changeTestExcutionStatusEN(String testExecStatus){
		returnValues = new HashMap<String, String>();
		try{
			Assert.assertTrue( validatePage(), "Execute Test Page is not Validated Successfully.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue( executeTestStatus(testExecStatus), "Test status is not changed successfully.");
						
			String executedBy = getExecutedUser();
			Assert.assertNotNull( executedBy, "Test is not executed, So User is not available.");
						
			String executedOn = getExecutedTime();
			Assert.assertNotNull( executedOn, "Test is not executed, So Time is not available.");
						
			Assert.assertTrue(returnToExecutionNavigator(), "Not Clicked on Return to Search Link Properly.");				
						
			returnValues.put("executedUser", executedBy);
			returnValues.put("executedTime", executedOn);
		}catch(Exception e){
			e.printStackTrace();
			return returnValues;
		}
		return returnValues;
	}
	public Map<String , String> changeTestExcutionStatusInDetailViewFromEN(String testExecStatus){
		returnValues = new HashMap<String, String>();
		try{
			//Assert.assertTrue( validatePage(), "Execute Test Page is not Validated Successfully.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue( executeTestStatus(testExecStatus), "Test status is not changed successfully.");
						
			String executedBy = getExecutedUser();
			Assert.assertNotNull( executedBy, "Test is not executed, So User is not available.");
						
			String executedOn = getExecutedTime();
			Assert.assertNotNull( executedOn, "Test is not executed, So Time is not available.");
						
			//Assert.assertTrue(returnToExecutionNavigator(), "Not Clicked on Return to Search Link Properly.");				
						
			returnValues.put("executedUser", executedBy);
			returnValues.put("executedTime", executedOn);
		}catch(Exception e){
			e.printStackTrace();
			return returnValues;
		}
		return returnValues;
	}
	public Map<String , String> changeStepAndTestExcutionStatusInDetailViewFromEN(String testExecStatus, String testStepNum, String stepStatus){
		returnValues = new HashMap<String, String>();
		try{
			//Assert.assertTrue( validatePage(), "Execute Test Page is not Validated Successfully.");
			
			CommonUtil.scrollToWebElement(CommonUtil.returnWebElement("//*[@id='teststepDetails']"));
			
			Assert.assertTrue(changeStepStatus(testStepNum, stepStatus), "Step status is not changed.");
			logger.info("Step status is changed sccessfully.");
			Assert.assertTrue(validateStepStatus(testStepNum, stepStatus), "Step status is not validated in Execute Test page.");
			logger.info("Step Status is validated successfully.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue( executeTestStatus(testExecStatus), "Test status is not changed successfully.");
			
						
			String executedBy = getExecutedUser();
			Assert.assertNotNull( executedBy, "Test is not executed, So User is not available.");
						
			String executedOn = getExecutedTime();
			Assert.assertNotNull( executedOn, "Test is not executed, So Time is not available.");
						
			//Assert.assertTrue(returnToExecutionNavigator(), "Not Clicked on Return to Search Link Properly.");				
						
			returnValues.put("executedUser", executedBy);
			returnValues.put("executedTime", executedOn);
		}catch(Exception e){
			e.printStackTrace();
			return returnValues;
		}
		return returnValues;
	}
	/*public Map<String , String> changeTestExcutionStatusOnly(String testExecStatus){
		try{
			//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			//Assert.assertTrue(CommonUtil.getTitle().contains("Execute Tests"), "Execute Test page is not verified successfully.");
			Assert.assertTrue(CommonUtil.titleContains("Execute Test", Constants.EXPLICIT_WAIT_LOW), "Execute Test page is not verified successfully.");
			logger.info("Execute Tests page is verified successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			Assert.assertTrue( executeTestStatus(testExecStatus), "Test status is not changed successfully.");
			logger.info("Test status is changed snd validated successfully.");
			xpathForChangeTestExecutionStatusLabel.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, testExecStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			xpathForStatusSubmitBtn.click();
			//executionStatusText.click();
			logger.info("Clicking in execution status and waiting for successful message.");
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(xpathForSuccessfulExecutedTestMessage.getText().contains("Successfully Executed Test."));
			logger.info("Test is executed successfully.");
			
			Assert.assertTrue((xpathForTestExecutionStatus.getText()).equals(testExecStatus), "Expected test execution status is not matched after execution in execute tests page.");
			logger.info("Test status is matched in execute tests page after execution.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String executedByUserNameOfTest=xpathForTestExecutedByUser.getText();
			String executedOnTimeOfTest=xpathForTestExecutedOnTime.getText();
							
			Driver.driver.navigate().back();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Returned to Execution Navigator page successfully");
			returnValues.put("executedUser", executedByUserNameOfTest);
			returnValues.put("executedTime", executedOnTimeOfTest);
		}catch(Exception e){
			e.printStackTrace();
		}
		return returnValues;
	}
	*/
	/*public Map<String , String> changeTestExecStatus(String testExecStatus){
		try{
			Assert.assertTrue(validateTitle(), "Execute Test Page Title is not Validated.");
			
			Assert.assertTrue( executeTestStatus(testExecStatus), "Test status is not changed successfully.");
			logger.info("Test status is changed snd validated successfully.");
			xpathForChangeTestExecutionStatusLabel.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, testExecStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			xpathForStatusSubmitBtn.click();
			//executionStatusText.click();
			logger.info("Clicking in execution status and waiting for successful message.");
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(xpathForSuccessfulExecutedTestMessage.getText().contains("Successfully Executed Test."));
			logger.info("Test is executed successfully.");
			
			Assert.assertTrue((xpathForTestExecutionStatus.getText()).equals(testExecStatus), "Expected test execution status is not matched after execution in execute tests page.");
			logger.info("Test status is matched in execute tests page after execution.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String executedByUserNameOfTest=xpathForTestExecutedByUser.getText();
			String executedOnTimeOfTest=xpathForTestExecutedOnTime.getText();
							
			Driver.driver.navigate().back();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Returned to Execution Navigator page successfully");
			returnValues.put("executedUser", executedByUserNameOfTest);
			returnValues.put("executedTime", executedOnTimeOfTest);
		}catch(Exception e){
			e.printStackTrace();
		}
		return returnValues;
	}*/
	
	/**
	 * This method is used to execute a test by changing the status and will associate a new defect while execution.
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * 	<b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *  <b>ISSUE_SUMMARY</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * </p>
	 * @return The Map<String, String> values.
	 */
	public boolean changeTestExcutionStatusWithDefect(Map<String, String> values){
		returnValues = new HashMap<String, String>();
		try{
			Assert.assertTrue(validatePage(), "Execute Test Page Title is not Validated Successfully.");
			
			Assert.assertTrue( executeTestStatus(values.get("TEST_EXEC_STATUS")), "Test Execution Status is not changed.");
						
			String issueId = attachNewDefect(values.get("ISSUE_SUMMARY"));
			Assert.assertNotNull(issueId, "Defect is not attached, returning null value.");
			logger.info( issueId + " is attached successfully to the Test.");
			
			String executedBy = getExecutedUser();
			Assert.assertNotNull( executedBy, "Test is not executed, So User is not available.");
						
			String executedOn = getExecutedTime();
			Assert.assertNotNull( executedOn, "Test is not executed, So Time is not available.");
						
			Assert.assertTrue(returnToTestCycle(), "Not Returned to Plan Test Cycle Page.");				
			
			values.put("EXECUTED_USER", executedBy);
			values.put("EXECUTED_TIME", executedOn);
			values.put("ISSUE_ID", issueId);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/*public boolean changeTestExcutionStatusWithDefect(Map<String, String> values){
		try{
			//Assert.assertTrue(CommonUtil.getTitle().contains("Execute Tests"), "Execute Test page is not verified successfully.");
			Assert.assertTrue(CommonUtil.titleContains("Execute Test", Constants.EXPLICIT_WAIT_LOW), "Execute Test page is not verified successfully.");
			logger.info("Execute Tests page is verified successfully.");
			Assert.assertTrue(validateTitle(), "Execute Test Title not Validated.");
		
			Assert.assertTrue( executeTestStatus(values.get("TEST_EXEC_STATUS")), "Test Execution Status is not changed.");
			logger.info("Test Execution status is executed and validated successfully.");
			
			String issueId = attachNewDefect(values.get("ISSUE_SUMMARY"));
			Assert.assertNotNull(issueId, "Attach Defect returning null value.");
			logger.info("Defect is attached successfully.");
			xpathForChangeTestExecutionStatusLabel.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, values.get("TEST_EXEC_STATUS"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			//executionStatusText.click();
			xpathForStatusSubmitBtn.click();
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			Assert.assertTrue(xpathForSuccessfulExecutedTestMessage.getText().contains("Successfully Executed Test."));
			logger.info("Test is executed successfully.");
			if(!(xpathForTestExecutionStatus.getText().equals(values.get("TEST_EXEC_STATUS")))){
				xpathForChangeTestExecutionStatusLabel.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, values.get("TEST_EXEC_STATUS"));
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				executionStatusText.click();
				CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
				//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				Assert.assertTrue(xpathForSuccessfulExecutedTestMessage.getText().contains("Successfully Executed Test."));
			}
			Assert.assertTrue((xpathForTestExecutionStatus.getText()).equals(values.get("TEST_EXEC_STATUS")), "Expected test execution status is not matched after execution in execute tests page.");
			logger.info("Test status is matched in execute tests page after execution.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			CommonUtil.actionClass().moveToElement(xpathForDefectLabelToClick).build().perform();
			xpathForDefectLabelToClick.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			createNewIssueLink.click();
			CommonUtil.visibilityOfElementLocated("//div[contains(@id,'create-issue-dialog-schedule')]");
			//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			JiraNavigatorFactory.getInstance().createIssue(values.get("ISSUE_SUMMARY"));
			//CreateIssuePage.getInstance().createIssue(values.get("ISSUE_SUMMARY"));
			defectLabelInExecuteTestsPage.click();
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			logger.info("Issue is created successfully for the test.");
			
			String issueId=currentDefectPicker.getText();
			logger.info(issueId+" is created successfully.");	
			
			String executedByUserNameOfTest=xpathForTestExecutedByUser.getText();
			String executedOnTimeOfTest=xpathForTestExecutedOnTime.getText();
							
			returnToTestCycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Returned to plan test cycle page successfully");
			values.put("EXECUTED_USER", executedByUserNameOfTest);
			values.put("EXECUTED_TIME", executedOnTimeOfTest);
			values.put("ISSUE_ID", issueId);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	
	/**
	 * This method is used to execute a test by changing the status and create a defect while execution.
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * 	<b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *  <b>ISSUE_SUMMARY</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * </p>
	 * @return The Map<String, String> values.
	 */
	/*public boolean changeTestStatusWithDefectAndAttachment(Map<String, String> values){
		try{
			Assert.assertTrue(CommonUtil.getTitle().contains("Execute Tests"), "Execute Test page is not verified successfully.");
			logger.info("Execute Tests page is verified successfully.");
			
			xpathForChangeTestExecutionStatusLabel.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, values.get("TEST_EXEC_STATUS"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			executionStatusText.click();
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			Assert.assertTrue(xpathForSuccessfulExecutedTestMessage.getText().contains("Successfully Executed Test."));
			logger.info("Test is executed successfully.");
			Assert.assertTrue((xpathForTestExecutionStatus.getText()).equals(values.get("TEST_EXEC_STATUS")), "Expected test execution status is not matched after execution in execute tests page.");
			logger.info("Test status is matched in execute tests page after execution.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			
			xpathForDefectLabelToClick.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			createNewIssueLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CreateIssuePage.getInstance().createIssue(values.get("ISSUE_SUMMARY"));
			defectLabelInExecuteTestsPage.click();
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			logger.info("Issue is created successfully for the test.");
			
			String issueId=currentDefectPicker.getText();
			logger.info(issueId+" is created successfully.");	
			
			String executedByUserNameOfTest=xpathForTestExecutedByUser.getText();
			String executedOnTimeOfTest=xpathForTestExecutedOnTime.getText();
			
			testAttachmentLink.click();
			browseBtnOfAttchmentFile.sendKeys(Config.getValue("EXEC_ATTCHMENT_FILE_PATH"));
			attachBtn.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(Config.getValue("EXEC_ATTCHMENT_FILE_PATH").contains(viewAttachment.getText()));
			logger.info("Attachment is validated successfully in this test.");
			
			
			returnToTestCycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Returned to plan test cycle page successfully");
			values.put("EXECUTED_USER", executedByUserNameOfTest);
			values.put("EXECUTED_TIME", executedOnTimeOfTest);
			values.put("ISSUE_ID", issueId);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/

	/**
	 * This method is used to execute a test by changing the status and create a defect while execution.
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * 	<b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *  <b>ISSUE_SUMMARY</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * </p>
	 * @return The Map<String, String> values.
	 */
	public boolean changeTestStatusWithDefectAndAttachment(Map<String, String> values){
		returnValues = new HashMap<String, String>();
		try{
			Assert.assertTrue( validatePage(), "Execute Test Page Title is not Validated Successfully.");
			
			Assert.assertTrue( executeTestStatus(values.get("TEST_EXEC_STATUS")), "Test Status is changed and validated successfully.");
			
			String issueId = attachNewDefect(values.get("ISSUE_SUMMARY"));
			Assert.assertNotNull( issueId , "Issue is not added to the test.");
			logger.info( issueId + " is created successfully.");
			
			String executedBy = getExecutedUser();
			Assert.assertNotNull( executedBy, "Test is not executed, So User is not available.");
						
			String executedOn = getExecutedTime();
			Assert.assertNotNull( executedOn, "Test is not executed, So Time is not available.");
			
			Assert.assertTrue( attachScreenshotToTest() , "Screenshot is not added to the Test." );
			
			Assert.assertTrue(returnToTestCycle() , "Not Clicked on Return to test cycle link.");
			
			values.put("EXECUTED_USER", executedBy);
			values.put("EXECUTED_TIME", executedOn);
			values.put("ISSUE_ID", issueId);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * This method is used to change the test step execution status. 
	 * @param testStepNum This parameter is used to select and execute the step.
	 * @param stepStatus This parameter is used to change the status while execution.
	 * @return The boolean value i.e. True or False.
	 */
	/*public boolean changeStepExcutionStatus(String testStepNum, String stepStatus){
		try{
			Assert.assertTrue(CommonUtil.getTitle().contains("Execute Tests"), "Execute Test page is not verified successfully.");
			logger.info("Execute Tests page is verified successfully.");
			
			Assert.assertTrue(changeStepStatus(testStepNum, stepStatus), "Step status is not changed.");
			logger.info("Step status is changed sccessfully.");
			Assert.assertTrue(validateStepStatus(testStepNum, stepStatus), "Step status is not validated in Execute Test page.");
			logger.info("Step Status is validated successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Map<String , String> executeAllSteps(String totalSteps, String stepExecStatus){
		try{
			for(int i=1;i<= Integer.parseInt(totalSteps); i++){
				String stepNumInString=""+i+"";
				Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus(stepNumInString, stepExecStatus),"Step execution status is not verified successfully.");
				logger.info("Step "+i+" is executed successfully.");
			}
			Assert.assertTrue(autoSuggestPopupStatusText.getText().contains(stepExecStatus), "All step statuses are not executed properly.");
			logger.info("All step statuses are executed to "+stepExecStatus);
			executeBtnInAllStepExecIntoOneStatus.click();
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue((xpathForTestExecutionStatus.getText()).equals(stepExecStatus), "Expected test execution status is not matched after execution in execute tests page.");
			logger.info("Test status is matched in execute tests page after execution.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			String executedByUserNameOfTest=xpathForTestExecutedByUser.getText();
			String executedOnTimeOfTest=xpathForTestExecutedOnTime.getText();
							
			returnToTestCycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Returned to plan test cycle page successfully");
			returnValues.put("EXECUTED_USER", executedByUserNameOfTest);
			returnValues.put("EXECUTED_TIME", executedOnTimeOfTest);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return returnValues;
	}*/

	public boolean executeTest(String status){
		try{
			executeTestButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			linkToSelectExecutionStatus.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			WebElement element=CommonUtil.changeToWebElement("//div[label[@for='executionStatus']]//select");
			Select sel=new Select(element);
			status=status.toUpperCase();
			sel.selectByVisibleText(status);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			updateStatus.click();
			CommonUtil.actionClass().sendKeys(Keys.TAB).perform();
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info("Executed By: "+executedBy.getText()+"");
			logger.info("Executed On: "+executedOn.getText()+"");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).perform();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean  addDefectToTest(String Summary){
		try{
			addDefectLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			createNewIssueLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(JiraNavigatorFactory.getInstance().createIssue(Summary),"Creating new defect failed...");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			updateDefectButton.click();
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			Assert.assertTrue((currentDefectPicker.isDisplayed()),"issue not added...");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info("issue added successfully");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public ViewTestPage navigateToDefect(){
		try{
			if(validateDefectAdded.isDisplayed()){
				validateDefectAdded.click();
			}
			
		}catch(Exception e){
			xpathToQuickSearchTest.clear();
			xpathToQuickSearchTest.sendKeys(currentDefectPicker.getText());
			xpathToQuickSearchTest.sendKeys(Keys.ENTER);
		}
		return ViewTestPage.getInstance();
	}
	
	
	
	/**
	 * This method is used to change the step execution status and add a defect to it while execution.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>TEST_STEP_NUM</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>STEP_EXEC_STATUS</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>ISSUE_SUMMARY</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * </p>
	 * @return
	 */
	public boolean changeStepExcutionStatusWithDefect(Map<String , String> values){
		try{
			Assert.assertTrue( validatePage(), "Execute Test Page Title is not Validated Successfully.");
			
			Assert.assertTrue( changeStepExcutionStatus(values.get("TEST_STEP_NUM"), values.get("STEP_EXEC_STATUS")), "Step Status is not changed and not validated successfully.");
			
			String issueId=createIssueAssociateToStep(values.get("TEST_STEP_NUM"), values.get("ISSUE_SUMMARY"));
			Assert.assertNotNull(issueId, "Not created and attached defect to the step.");
			logger.info(issueId+" issue is added to step- "+values.get("TEST_STEP_NUM"));
			
			Assert.assertTrue(returnToPlanTestCycle(), "Not returned Successfully to plan test cycle.");
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
	 * This method is used to change the test step execution status. 
	 * @param testStepNum This parameter is used to select and execute the step.
	 * @param stepStatus This parameter is used to change the status while execution.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean changeStepExcutionStatus(String testStepNum, String stepStatus){
		try{
			Assert.assertTrue( validatePage(), "Execute Test Page Title is not Validated Successfully.");
			
			Assert.assertTrue(changeStepStatus(testStepNum, stepStatus), "Step status is not changed.");
			logger.info("Step status is changed sccessfully.");
			Assert.assertTrue(validateStepStatus(testStepNum, stepStatus), "Step status is not validated in Execute Test page.");
			logger.info("Step Status is validated successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean returnToPlanTestCycle(){
		try{
			Assert.assertTrue( validatePage(), "Execute Test Page Title is not Validated Successfully.");
			returnToTestCycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		/*
			if(CommonUtil.getTitle().contains("Execute Test")){
				returnToTestCycle.click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			}
		*/	logger.info("Returned to plan test cycle page successfully");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Map<String , String> executeAllSteps(String totalSteps, String stepExecStatus){
		returnValues = new HashMap<String, String>();
		try{
			Assert.assertTrue( validatePage(), "Execute Test Page Title is not Validated Successfully.");
			for(int i=1;i<= Integer.parseInt(totalSteps); i++){
				String stepNumInString=String.valueOf(i);
				Assert.assertTrue(ExecuteTestsPage.getInstance().changeStepExcutionStatus(stepNumInString, stepExecStatus),"Step execution status is not verified successfully.");
				logger.info("Step "+i+" is executed successfully.");
			}
			Assert.assertTrue(autoSuggestPopupStatusText.getText().contains(stepExecStatus), "All step statuses are not executed properly.");
			logger.info("All step statuses are executed to "+stepExecStatus);
			executeBtnInAllStepExecIntoOneStatus.click();
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue((xpathForTestExecutionStatus.getText()).equals(stepExecStatus), "Expected test execution status is not matched after execution in execute tests page.");
			logger.info("Test status is matched in execute tests page after execution.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			String executedBy = getExecutedUser();
			Assert.assertNotNull( executedBy, "Test is not executed, So User is not available.");
						
			String executedOn = getExecutedTime();
			Assert.assertNotNull( executedOn, "Test is not executed, So Time is not available.");
							
			Assert.assertTrue(returnToTestCycle() , "Not Clicked on Return to test cycle link.");
			
			returnValues.put("EXECUTED_USER", executedBy);
			returnValues.put("EXECUTED_TIME", executedOn);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return returnValues;
	}
	
	public boolean validateDefectAdded(String issueId){
		try{
			CommonUtil.waitForStaleElement(CommonUtil.changeToWebElement("//div[label[@for='defects']]//a"), Constants.IMPLICIT_WAIT_LOW);
			List<String> totalDefects= CommonUtil.getValues("//div[label[@for='defects']]//a");
			for(int i=0;i<totalDefects.size();i++){
				
				if(totalDefects.get(i).equals(issueId)){
					logger.info("Defect "+issueId+" is added to the test "+testIdToexecute.getText()+ " successfully...");
					break;
					
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateClearedDefects(){
		try{
			try{
				CommonUtil.changeToWebElement("//div[label[@for='defects']]//dl/dd/a").isDisplayed();
				logger.info("Clearing defect Failed...");
				return false;
			}catch(Exception e){
				logger.info("Defect cleared successfully...");
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean validateTestStepStatus(String teststepStatus){
		try{
			CommonUtil.waitForStaleElement(CommonUtil.changeToWebElement("//table[thead[tr[th[text()='Status']]]]/tbody/tr/td[5]//dd"), Constants.IMPLICIT_WAIT_LOW);
			List<String> totalTeststepStatus= CommonUtil.getValues("//table[thead[tr[th[text()='Status']]]]/tbody/tr/td[5]//dd");
			logger.info("Test "+testIdToexecute.getText()+" has "+totalTeststepStatus.size()+" Teststeps");
			for(int i=1;i<=totalTeststepStatus.size();i++){
				String status=CommonUtil.changeToWebElement("//table[thead[tr[th[text()='Status']]]]/tbody/tr["+i+"]/td[5]//dd").getText();
				Assert.assertTrue(status.equals(teststepStatus),"teststep Status Change failed...");
				logger.info("teststep "+i+" has the status as "+status+ "...");
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean navigateToNextExecution(){
		try{
			nextExecution.click();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean addTestToAdhoc(){
		try{
			executeTestButton.click();
			navigateBackToTest.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean returnToSearchTestExecutions(){
		try{
			returnToSearch.click();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * This method is used to change the step execution status and add a defect to it while execution.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>TEST_STEP_NUM</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>STEP_EXEC_STATUS</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>ISSUE_SUMMARY</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * </p>
	 * @return
	 */
	/*public boolean changeStepExcutionStatusWithDefect(Map<String , String> values){
		try{
			Assert.assertTrue(CommonUtil.getTitle().contains("Execute Tests"), "Execute Test page is not verified successfully.");
			logger.info("Execute Tests page is verified successfully.");
			
			Assert.assertTrue(changeStepStatus(values.get("TEST_STEP_NUM"), values.get("STEP_EXEC_STATUS")), "Step status is not changed.");
			logger.info("Step status is changed sccessfully.");
			Assert.assertTrue(validateStepStatus(values.get("TEST_STEP_NUM"), values.get("STEP_EXEC_STATUS")), "Step status is not validated in Execute Test page.");
			logger.info("Step Status is validated successfully.");
			String issueId=createIssueAssociateToStep(values.get("TEST_STEP_NUM"), values.get("ISSUE_SUMMARY"));
			Assert.assertNotNull(issueId, "Not created any defect in the step.");
			logger.info(issueId+" issue is added to step- "+values.get("TEST_STEP_NUM"));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	

/*	*//******************************************************
	 * 	UTIL METHODS
	 *****************************************************//*
	*//**
	 * This method is used to change step status while executing step of a test.
	 * @param testStepNum  This parameter is used to select and execute the step.
	 * @param stepStatus This parameter is used to change the status while execution.
	 * @return The boolean value i.e. True or False.
	 *//*
	private boolean changeStepStatus(String testStepNum, String stepStatus){
		try{
			String xPathForStepExecStatusLabel="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/fieldset/div/div/div/dl/a";
			CommonUtil.navigateThroughXpath(xPathForStepExecStatusLabel);
			String xpathForTestStepStatusChange="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/fieldset/div/div/select";
			CommonUtil.selectListWithVisibleText(CommonUtil.returnWebElement(xpathForTestStepStatusChange), stepStatus);
			String xpathForTestStep="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']";
			CommonUtil.navigateThroughXpath(xpathForTestStep);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	*//**
	 * This method is used to validate step status after execution of a step.
	 * @param testStepNum  This parameter is used to select and execute the step.
	 * @param stepStatus This parameter is used to change the status while execution.
	 * @return The boolean value i.e. True or False.
	 *//*
	private boolean validateStepStatus(String testStepNum, String stepStatus){
		try{
			Assert.assertTrue(currentStepStatus(testStepNum).equals(stepStatus),"Current Step status is not matching");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	*//**
	 * This method is used to return the current step status.
	 * @param testStepNum This parameter is used to select the test step .
	 * @return The string value.
	 *//*
	private String currentStepStatus(String testStepNum){
		String xpathForCurrentStepStatus="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/fieldset/div/div/div/dl/dd[contains(@id,'current-execution-status-dd-stepresult-')]";
		return CommonUtil.getTextFromUIByXpath(xpathForCurrentStepStatus);
	}
	*//**
	 * This method is used to create a issue associate to test step while execution.
	 * @param testStepNum This parameter is used to select the test step .
	 * @param issueSummary This parameter is used while create a new issue.
	 * @return
	 *//*
	private String createIssueAssociateToStep(String testStepNum, String issueSummary){
		try{
			String xpathForStepDefectLabel="//div[@id='teststepDetails_heading']/following-sibling::div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/div/div/div/dl/a[contains(@id,'defectpicker-stepresult')]";
			CommonUtil.navigateThroughXpath(xpathForStepDefectLabel);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForCreateIssueForStep="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/div/div/a[contains(text(),'Create New Issue')]";
			CommonUtil.navigateThroughXpath(xpathForCreateIssueForStep);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CreateIssuePage.getInstance().createIssue(issueSummary);
			
			CommonUtil.visibilityOfElementLocated("//*[@id='jira']/div/div[@class='aui-message success closeable' and contains(text(),'Issue')]");
			selectStepNum(testStepNum);
			logger.info("Issue is created successfully for the test.");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return currentDefectPicker.getText();
	}
	*//**
	 * This method is used to select a test step according to test step.
	 * @param testStepNum This parameter is used to select the test step.
	 *//*
	private void selectStepNum(String testStepNum){
		try{
			String xpathForTestStep="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']";
			CommonUtil.navigateThroughXpath(xpathForTestStep);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

=======*/

	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	/**
	 * This method is used to change step status while executing step of a test.
	 * @param testStepNum  This parameter is used to select and execute the step.
	 * @param stepStatus This parameter is used to change the status while execution.
	 * @return The boolean value i.e. True or False.
	 */
	private boolean changeStepStatus(String testStepNum, String stepStatus){
		try{
			String xPathForStepExecStatusLabel = "//div[@id='teststepDetails']/descendant::td[text()='"+testStepNum+"']/following-sibling::td/descendant::a[contains(@id,'executionStatus-labels-stepresult')]";
			CommonUtil.scrollPage(CommonUtil.returnWebElement(xPathForStepExecStatusLabel));
			CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xPathForStepExecStatusLabel)).build().perform();
			CommonUtil.navigateThroughXpath(xPathForStepExecStatusLabel);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForTestStepStatusChange = "//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/fieldset/div/div/select";
			CommonUtil.selectListWithVisibleText(CommonUtil.returnWebElement(xpathForTestStepStatusChange), stepStatus);
			String xpathForTestStep = "//div[@id='teststepDetails']/descendant::td[text()='"+testStepNum+"']/following-sibling::td/descendant::*[contains(@id, 'execution_update-schedule') and @class='zfj-button submit']";
			CommonUtil.navigateThroughXpath(xpathForTestStep);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * This method is used to validate step status after execution of a step.
	 * @param testStepNum  This parameter is used to select and execute the step.
	 * @param stepStatus This parameter is used to change the status while execution.
	 * @return The boolean value i.e. True or False.
	 */
	private boolean validateStepStatus(String testStepNum, String stepStatus){
		try{
			Assert.assertTrue(currentStepStatus(testStepNum).equals(stepStatus),"Current Step status is not matching with actual status.");
			logger.info("Current Step Status is validated successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * This method is used to return the current step status.
	 * @param testStepNum This parameter is used to select the test step .
	 * @return The string value.
	 */
	private String currentStepStatus(String testStepNum){
		String currentStepStatus = null;
		try{
			//String xpathForCurrentStepStatus="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/fieldset/div/div/div/dl/div/dd[contains(@id,'current-execution-status-dd-stepresult-')]";
			String xpathForCurrentStepStatus = "//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/descendant::dd[contains(@id,'current-execution-status-dd-stepresult-')]";
			currentStepStatus = CommonUtil.getTextFromUIByXpath(xpathForCurrentStepStatus);
		}catch(Exception e){
			e.printStackTrace();
			return currentStepStatus;
		}
		return currentStepStatus;
	}
	/**
	 * This method is used to create a issue associate to test step while execution.
	 * @param testStepNum This parameter is used to select the test step .
	 * @param issueSummary This parameter is used while create a new issue.
	 * @return
	 */
	private String createIssueAssociateToStep(String testStepNum, String issueSummary){
		String currentDefect = null;
		try{
			String xpathForStepDefectLabel = "//div[@id='teststepDetails_heading']/following-sibling::div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/descendant::a[contains(@id,'defectpicker-stepresult')]";
			CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForStepDefectLabel)).build().perform();
			CommonUtil.navigateThroughXpath(xpathForStepDefectLabel);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForCreateIssueForStep = "//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/div/div/a[contains(text(),'Create New Issue')]";
			CommonUtil.navigateThroughXpath(xpathForCreateIssueForStep);
			CommonUtil.visibilityOfElementLocated("//div[contains(@id,'create-issue-dialog-stepresult') and contains(@class,'dialog-content-ready')]");
			Assert.assertTrue(JiraNavigatorFactory.getInstance().createIssue(issueSummary), "Issue is not created successfully.");
			logger.info("Issue is created successfully.");
			CommonUtil.visibilityOfElementLocated("//*[@id='jira']/div/div[@class='aui-message success closeable' and contains(text(),'Issue')]");
			selectStepNum(testStepNum);
			currentDefect = currentDefectPicker.getText();
		}catch(Exception e){
			e.printStackTrace();
			return currentDefect;
		}
		return currentDefect;
	}
	/**
	 * This method is used to select a test step according to test step.
	 * @param testStepNum This parameter is used to select the test step.
	 * @throws Exception 
	 */
	private void selectStepNum(String testStepNum) throws Exception{
		try{
			String xpathForTestStep = "//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']";
			CommonUtil.navigateThroughXpath(xpathForTestStep);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	/*private boolean executeStatus(String execStatus){
		try{
			xpathForChangeTestExecutionStatusLabel.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, execStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForStatusSubmitBtn.click();
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			Assert.assertTrue(xpathForSuccessfulExecutedTestMessage.getText().contains("Successfully Executed Test."), "Successful execution message is not Validated.");
			logger.info("Test Status is changed successfully.");
			Assert.assertTrue((xpathForTestExecutionStatus.getText()).equals(execStatus), "Test execution status is not validated successfully after execution.");
			logger.info("Test status is Validated successfully after execution.");
			//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	private boolean executeTestStatus(String execStatus){
		try{
			xpathForChangeTestExecutionStatusLabel.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(xpathForStatusSubmitBtn.isDisplayed(), "Test Status drop down is not displaying for selecting status.");
			CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, execStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForStatusSubmitBtn.click();
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			Assert.assertTrue(xpathForSuccessfulExecutedTestMessage.getText().contains("Successfully Executed Test."), "Successful execution message is not Validated.");
			logger.info("Test Status is changed successfully.");
			Assert.assertTrue((xpathForTestExecutionStatus.getText()).equals(execStatus), "Test execution status is not validated successfully after execution.");
			logger.info("Test Execution status is changed to "+execStatus+" and validated successfully.");
			//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private String attachNewDefect(String issueSummary){
		String issueId = null;
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().moveToElement(xpathForDefectLabelToClick).build().perform();
			xpathForDefectLabelToClick.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(updateDefectButton.isDisplayed(), "Adding defect popup in not displaying after clicking on label.");
			logger.info("Adding Defect Popup is now displaying for adding Defect.");
			createNewIssueLink.click();
			CommonUtil.visibilityOfElementLocated("//div[contains(@id,'create-issue-dialog-schedule')]");
			Assert.assertTrue( JiraNavigatorFactory.getInstance().createIssue(issueSummary), "New Defect is not created successfully.");
			logger.info("New Defect is created successfully.");
			updateDefectButton.click();
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			logger.info("Issue is created successfully for the test.");
			
			issueId = currentDefectPicker.getText();
		}catch(Exception e){
			e.printStackTrace();
			return issueId;
		}
		return issueId;
	}
	private boolean validatePage(){
		try{
			Assert.assertTrue(CommonUtil.titleContains("Execute Test", Constants.EXPLICIT_WAIT_LOW), "Execute Test Page is not verified successfully.");
			logger.info("Execute Tests Page is Validated Successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean attachScreenshotToTest(){
		try{
			testAttachmentLink.click();
			browseBtnOfAttchmentFile.sendKeys(Config.getValue("EXEC_ATTCHMENT_FILE_PATH"));
			attachBtn.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String x=Config.getValue("EXEC_ATTCHMENT_FILE_PATH");
			String xx=viewAttachment.getText();
			Assert.assertTrue(Config.getValue("EXEC_ATTCHMENT_FILE_PATH").contains(viewAttachment.getText()));
			logger.info("Attachment is added and validated successfully to the Test.");
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean returnToTestCycle(){
		try{
			returnToTestCycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Clicked on returned to plan Test Cycle link Successfully");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean returnToExecutionNavigator(){
		try{
			returnToSearch.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Clicked on returned to Search link Successfully");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private String getExecutedUser(){
		String executedBy = null;
		try{
			executedBy = xpathForTestExecutedByUser.getText();
			logger.info("Test Executed By : " + executedBy);
		}catch(Exception e){
			e.printStackTrace();
			return executedBy;
		}
		return executedBy;
	}
	private String getExecutedTime(){
		String executedOn = null;
		try{
			executedOn = xpathForTestExecutedOnTime.getText();
			logger.info("Test Executed On : " + executedOn);
		}catch(Exception e){
			e.printStackTrace();
			return executedOn;
		}
		return executedOn;
	}

}
