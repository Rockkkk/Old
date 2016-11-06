package com.thed.zfjbvt.zfj.impl.zfj21;

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
import com.thed.zfjbvt.jira.impl.jira52.CreateIssuePage;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class ExecuteTestsPage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	
	public static ExecuteTestsPage getInstance() {
		return PageFactory.initElements(Driver.driver, ExecuteTestsPage.class);
	}
	Map<String, String> returnValues = new HashMap<String, String>();
	
	
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
	@FindBy(xpath="//label[contains(text(),'Execution Status:')]/following-sibling::div/div/dl/dd")
	private WebElement xpathForTestExecutionStatus;
	
	// Test executed by user
	@FindBy(xpath="//a[@class='user-hover']")
	private WebElement xpathForTestExecutedByUser;
	
	// Test executed on time
	@FindBy(xpath="//span[contains(@id,'executed-on')]")
	private WebElement xpathForTestExecutedOnTime;
	
	//Return to test cycle
	@FindBy(id="zephyr-je-block-back-to-cycle")
	private WebElement returnToTestCycle;
	
	// Defect label xpath i.e. for creating a defect first click on defect label then create the status.
	@FindBy(xpath="//label[contains(text(),'Defects:')]/following-sibling::div/div/dl/a")
	private WebElement xpathForDefectLabelToClick;
	
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
	@FindBy(xpath="//*[@type='button']")
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
	@FindBy(xpath="//div[label[@for='defects']]//dl/dd/a")
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
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	/**
	 * This method is used to change the test execution status while execution of  a test.
	 * @param testExecStatus This parameter contains test execution status which is used for set the status while executing test.
	 * @return The Map<String , String> values.
	 */
	public Map<String , String> changeTestExcutionStatus(String testExecStatus){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(CommonUtil.getTitle().contains("Execute Tests"), "Execute Test page is not verified successfully.");
			logger.info("Execute Tests page is verified successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			xpathForChangeTestExecutionStatusLabel.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, testExecStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			executionStatusText.click();
			logger.info("Clicking in execution status and waiting for successful message.");
			CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
			//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(xpathForSuccessfulExecutedTestMessage.getText().contains("Successfully Executed Test."));
			logger.info("Test is executed successfully.");
			/*if(!(xpathForTestExecutionStatus.getText().equals(testExecStatus))){
				xpathForChangeTestExecutionStatusLabel.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, testExecStatus);
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				executionStatusText.click();
				CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
				//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				Assert.assertTrue(xpathForSuccessfulExecutedTestMessage.getText().contains("Successfully Executed Test."));
			}*/
			Assert.assertTrue((xpathForTestExecutionStatus.getText()).equals(testExecStatus), "Expected test execution status is not matched after execution in execute tests page.");
			logger.info("Test status is matched in execute tests page after execution.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String executedByUserNameOfTest=xpathForTestExecutedByUser.getText();
			String executedOnTimeOfTest=xpathForTestExecutedOnTime.getText();
							
			returnToTestCycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Returned to plan test cycle page successfully");
			returnValues.put("executedUser", executedByUserNameOfTest);
			returnValues.put("executedTime", executedOnTimeOfTest);
		}catch(Exception e){
			e.printStackTrace();
		}
		return returnValues;
	}
	public Map<String , String> changeTestExcutionStatusOnly(String testExecStatus){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(CommonUtil.getTitle().contains("Execute Tests"), "Execute Test page is not verified successfully.");
			logger.info("Execute Tests page is verified successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			xpathForChangeTestExecutionStatusLabel.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, testExecStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			executionStatusText.click();
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
	/**
	 * This method is used to execute a test by changing the status and create a defect while execution.
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * 	<b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *  <b>ISSUE_SUMMARY</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * </p>
	 * @return The Map<String, String> values.
	 */
	public boolean changeTestExcutionStatusWithDefect(Map<String, String> values){
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
			/*if(!(xpathForTestExecutionStatus.getText().equals(values.get("TEST_EXEC_STATUS")))){
				xpathForChangeTestExecutionStatusLabel.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.selectListWithVisibleText(selectStatusOfTestExecStatus, values.get("TEST_EXEC_STATUS"));
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				executionStatusText.click();
				CommonUtil.visibilityOfElementLocated("//div[@id='aui-message-bar']/div");
				//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				Assert.assertTrue(xpathForSuccessfulExecutedTestMessage.getText().contains("Successfully Executed Test."));
			}*/
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
	}
	
	
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
			linkToSelectExecutionStatus.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			WebElement element=CommonUtil.changeToWebElement("//div[label[@for='executionStatus']]//select");
			Select sel=new Select(element);
			status=status.toUpperCase();
			sel.selectByVisibleText(status);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).perform();
			logger.info("Executed By: "+executedBy.getText()+"");
			logger.info("Executed On: "+executedOn.getText()+"");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).perform();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean  addedDefectToTest(){
		try{
			addDefectLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			createNewIssueLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CreateIssuePage.getInstance().createIssue("Defect Associated to the Test", "Bug");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			//addDefectTxtbox.sendKeys(issue);
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
			CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
			Assert.assertTrue((currentDefectPicker.isDisplayed()),"issue not added...");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			logger.info("issue added successfully");
			try{
				if(validateDefectAdded.isDisplayed()){
					validateDefectAdded.click();
				}
				
			}catch(Exception e){
				xpathToQuickSearchTest.clear();
				xpathToQuickSearchTest.sendKeys(currentDefectPicker.getText());
				xpathToQuickSearchTest.sendKeys(Keys.ENTER);
			}
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
	public boolean changeStepExcutionStatusWithDefect(Map<String , String> values){
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
			Assert.assertTrue(CommonUtil.getTitle().contains("Execute Tests"), "Execute Test page is not verified successfully.");
			logger.info("Execute Tests page is verified successfully.");
			
			Assert.assertTrue(changeStepStatus(testStepNum, stepStatus), "Step status is not changed.");
			logger.info("Step status is changed sccessfully.");
			Assert.assertTrue(validateStepStatus(testStepNum, stepStatus), "Step status is not validated in Execute Test page.");
			logger.info("Step Status is validated successfully.");
		}catch(Exception e){
			logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean returnToPlanTestCycle(){
		try{
			if(CommonUtil.getTitle().contains("Execute Tests")){
				returnToTestCycle.click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			}
			logger.info("Returned to plan test cycle page successfully");
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
	}
	
	public boolean validateDefectAdded(String issueId){
		try{
			List<String> totalDefects= CommonUtil.getValues("//div[label[@for='defects']]//dl/dd/a");
			for(int i=0;i<totalDefects.size();i++){
				
				if(totalDefects.get(i).equals(issueId)){
					logger.info("Defect "+issueId+" is added to the test "+testIdToexecute.getText()+ " successfully...");
					break;
					
				}
			}
			Driver.driver.navigate().back();
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
				Driver.driver.navigate().back();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean validateTestStepStatus(String teststepStatus){
		try{
			List<String> totalTeststepStatus= CommonUtil.getValues("//table[thead[tr[th[text()='Status']]]]/tbody/tr/td[5]//dd");
			logger.info("Test "+testIdToexecute.getText()+" has "+totalTeststepStatus.size()+" Teststeps");
			for(int i=1;i<=totalTeststepStatus.size();i++){
				String status=CommonUtil.changeToWebElement("//table[thead[tr[th[text()='Status']]]]/tbody/tr["+i+"]/td[5]//dd").getText();
				if(status.equals(status)){
					logger.info("teststep has the status as "+status+ "...");
					break;
					
				}
			}
			Driver.driver.navigate().back();
			
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
			String xPathForStepExecStatusLabel="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/fieldset/div/div/div/dl/a";
			CommonUtil.navigateThroughXpath(xPathForStepExecStatusLabel);
			String xpathForTestStepStatusChange="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/fieldset/div/div/select";
			CommonUtil.selectListWithVisibleText(CommonUtil.returnWebElement(xpathForTestStepStatusChange), stepStatus);
			String xpathForTestStep="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']";
			CommonUtil.navigateThroughXpath(xpathForTestStep);
			CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
		}catch(Exception e){
			logger.error(CommonUtil.captureScreenshotInLog());
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
			Assert.assertTrue(currentStepStatus(testStepNum).equals(stepStatus),"Current Step status is not matching");
		}catch(Exception e){
			logger.error(CommonUtil.captureScreenshotInLog());
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
		String xpathForCurrentStepStatus="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/fieldset/div/div/div/dl/dd[contains(@id,'current-execution-status-dd-stepresult-')]";
		return CommonUtil.getTextFromUIByXpath(xpathForCurrentStepStatus);
	}
	/**
	 * This method is used to create a issue associate to test step while execution.
	 * @param testStepNum This parameter is used to select the test step .
	 * @param issueSummary This parameter is used while create a new issue.
	 * @return
	 */
	private String createIssueAssociateToStep(String testStepNum, String issueSummary){
		try{
			String xpathForStepDefectLabel="//div[@id='teststepDetails_heading']/following-sibling::div/table/tbody/tr/td[text()='"+testStepNum+"']/following-sibling::td/descendant::a[contains(@id,'defectpicker-stepresult')]";
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
			logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
		}
		return currentDefectPicker.getText();
	}
	/**
	 * This method is used to select a test step according to test step.
	 * @param testStepNum This parameter is used to select the test step.
	 * @throws Exception 
	 */
	private void selectStepNum(String testStepNum) throws Exception{
		try{
			String xpathForTestStep="//div[@id='teststepDetails']/div/table/tbody/tr/td[text()='"+testStepNum+"']";
			CommonUtil.navigateThroughXpath(xpathForTestStep);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}


}
