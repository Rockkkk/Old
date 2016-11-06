package com.thed.zfjbvt.zfj.impl.zfj22;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj22.ViewTestPage;

public class CreateTestPage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static CreateTestPage getInstance() {
		CreateTestPage page = PageFactory.initElements(Driver.driver, CreateTestPage.class);
		return page;
	}
	
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
		
	//id for getting the user loggedin.
	@FindBy(id="header-details-user-fullname")
	private WebElement xpathForGettingUserLoggedIn;
	
	
	
	// Xpath for confirmation of create test page.
	@FindBy(xpath="//*[@id='content']//h1")
	private WebElement xpathForCreateTestConfirmation;
	
	//Xpath for issue type "test" of create test page.
	@FindBy(id="issue-create-issue-type")
	private WebElement xpathForIssueTypeTest;
	
	//Xpath for project selected in create test page
	@FindBy(id="issue-create-project-name")
	private WebElement xpathForProjectSelected;
	
	//Xpath for entering summary in create test page.
	@FindBy(id="summary")
	private WebElement xpathToEnterSummary;
	
	//Xpath for entering priority in create test page.
	@FindBy(id="priority-field")
	private WebElement xpathToEnterPriority;
	
	// Xpath for entering component in create test page.
	@FindBy(id="components-textarea")
	private WebElement xpathToEnterComponent;
	
	// Xpath for entering affected version in create test page.
	@FindBy(id="versions-textarea")
	private WebElement xpathToEnterAffectedVersion;
	
	// Xpath for entering fix version in create test page.
	@FindBy(id="fixVersions-textarea")
	private WebElement xpathToEnterFixVersion;
	
	// Xpath for entering environment in create test page.
	@FindBy(id="environment")
	private WebElement xpathToEnterEnvironment;
	
	// Xpath for entering description in create test page.
	@FindBy(id="description")
	private WebElement xpathToEnterDescription;
	
	//Xpath for entering label in create test page.
	@FindBy(id="labels-textarea")
	private WebElement xpathToEnterLabel;
	
	//Xpath for creating the test in create test page.
	@FindBy(id="issue-create-submit")
	private WebElement xpathOfCreateTestButton;
	
	//xpath for priority drop down.
	@FindBy(xpath="//*[@id='priority-single-select']/span")
	private WebElement priorityDropdown;
	
	//xpath for component drop down.
	@FindBy(xpath="//*[@id='components-multi-select']/span")
	private WebElement componentDropdown;
	
	//xpath for affected version drop down.
	@FindBy(xpath="//*[@id='versions-multi-select']/span")
	private WebElement affectedVersionDropdown;
	
	//xpath for fix version drop down.
	@FindBy(xpath="//*[@id='fixVersions-multi-select']/span")
	private WebElement fixVersionDropdown;
	
	//xpath for Next button.
	@FindBy(xpath="//*[@name='Next' and @type='submit']")
	private WebElement nextButton;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	/**
	 * this method creates an issue of type Test,
	 * @param summary
	 * @param priority
	 * @param component
	 * @param affectedVersion
	 * @param fixVersion
	 * @param environment
	 * @param description
	 * @param label
	 * 
	 */
	public ViewTestPage createTest(Map<String, String> values){
		try{
			String jiraProject=Config.getValue("JIRA_PROJECT");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(xpathForCreateTestConfirmation.getText().equals("Create Issue"), "Not inside create test page");
			logger.info("Create test page verified successfully.");
			logger.info("Project seleced is :"+jiraProject+"");
			values.put("PROJECT", jiraProject);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			Assert.assertTrue(xpathForIssueTypeTest.getText().equals("Test"),"Issue type is not Test");
			logger.info("Issue type is Test");
				
				//summary of test
				xpathToEnterSummary.clear();
				xpathToEnterSummary.sendKeys(values.get("SUMMARY"));
				
				//priority of test
				String selectedPriority=CommonUtil.getAttributeValueUsingWebElements(xpathToEnterPriority,"value");
				if(selectedPriority.equals(values.get("PRIORITY"))==false){
					priorityDropdown.click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					CommonUtil.changeToWebElement("//a[contains(text(),'"+values.get("PRIORITY")+"')]").click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					
				}
				//component for the test
				componentDropdown.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//a[contains(text(),'"+values.get("COMPONENT")+"')]").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				
				
				//affected version for the test
				affectedVersionDropdown.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//a[contains(text(),'"+values.get("AFFECTED_VERSION")+"')]").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
						
				//fixversion for the test
				if(CommonUtil.isElementPresent("//*[@id='fixVersions-textarea']")){
					/*fixVersionDropdown.click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					CommonUtil.changeToWebElement("//a[contains(text(),'"+values.get("FIX_VERSION")+"')]").click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);*/
					xpathToEnterFixVersion.clear();
					xpathToEnterFixVersion.sendKeys(values.get("FIX_VERSION"),Keys.TAB);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				}
				
				//environment for the test
				xpathToEnterEnvironment.clear();
				xpathToEnterEnvironment.sendKeys(values.get("ENVIRONMENT"));
					
				//description for the test
				xpathToEnterDescription.clear();
				xpathToEnterDescription.sendKeys(values.get("DESCRIPTION"));
					
				// label for test
				xpathToEnterLabel.clear();
				xpathToEnterLabel.sendKeys(values.get("LABEL"));
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.actionClass().sendKeys(Keys.TAB).perform();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				//click to create a issue type test.
				xpathOfCreateTestButton.click();
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return ViewTestPage.getInstance();
		
	}
	
	
	public String createTest(String summary,String priority){
		
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(xpathForCreateTestConfirmation.getText().equals("Create Issue"), "Not inside create test page");
			logger.info("Create test page verified successfully.");
			String projectSelected=xpathForProjectSelected.getText();
			logger.info("Project seleced is :"+projectSelected+"");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			Assert.assertTrue(xpathForIssueTypeTest.getText().equals("Test"),"Issue type is not Test");
			logger.info("Issue type Created is: Test");
			
			//summary of test
			xpathToEnterSummary.clear();
			xpathToEnterSummary.sendKeys(summary);
			
			//priority of test
			String selectedPriority=CommonUtil.getAttributeValueUsingWebElements(xpathToEnterPriority,"value");
			if(selectedPriority.equals(priority)==false){
				priorityDropdown.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//a[contains(text(),'"+priority+"')]").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				/*xpathToEnterPriority.clear();
				xpathToEnterPriority.sendKeys(values.get("PRIORITY"));*/
			}
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);;
			//click to create a issue type test.
			xpathOfCreateTestButton.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			}catch(Exception e){
			e.printStackTrace();
		}
		return ViewTestPage.getInstance().getTestsID();
		//return ViewTestPage.getInstance().validateTestCreated(values);
	}
	
	
	public boolean createTestWithSteps(Map<String, String> values){
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(xpathForCreateTestConfirmation.getText().equals("Create Issue"), "Not inside create test page");
			logger.info("Create test page verified successfully.");
			String projectSelected=xpathForProjectSelected.getText();
			logger.info("Project seleced is :"+projectSelected+"");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			Assert.assertTrue(xpathForIssueTypeTest.getText().equals("Test"),"Issue type is not Test");
			logger.info("Issue type is Test");
			
			//summary of test
			xpathToEnterSummary.clear();
			xpathToEnterSummary.sendKeys(values.get("SUMMARY"));
			
			//priority of test
			String selectedPriority=CommonUtil.getAttributeValueUsingWebElements(xpathToEnterPriority,"value");
			if(selectedPriority.equals(values.get("PRIORITY"))==false){
				priorityDropdown.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//a[contains(text(),'"+values.get("PRIORITY")+"')]").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				/*xpathToEnterPriority.clear();
				xpathToEnterPriority.sendKeys(values.get("PRIORITY"));*/
			}
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);;
			//click to create a issue type test.
			xpathOfCreateTestButton.click();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ViewTestPage.getInstance().addTeststeps(values);
	}
	
	public boolean editTest(Map<String, String> values){
		try{
			ViewTestPage.getInstance().validateTestCreated(values);
			ViewTestPage.getInstance().navigateToEditTestPage(values);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * this method validates the create test page.
	 * @return
	 */
	
	
	public boolean validateCreateTestPage(){
		String issueType="Test";
		String issueImage="Test";
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
			String title=CommonUtil.getTitle();
			String pageHeader= xpathForCreateTestConfirmation.getText();
			boolean titleResult=title.contains(pageHeader);
			if(CommonUtil.isElementDisplayed(nextButton)==true){
				nextButton.click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
			}
			String issueTypeDisplayed=xpathForIssueTypeTest.getText();
			boolean issueTypeResult=issueType.equals(issueTypeDisplayed);
			String issueImageDisplayed=CommonUtil.getAttributeValue("//*[@id='issue-create']/div[1]/div[4]/img", "alt");
			boolean issueImageResult=issueImage.equals(issueImageDisplayed);
			Assert.assertTrue(titleResult && issueTypeResult && issueImageResult,"launching Create Test page Failed...");
				logger.info("Create Test page confirmed...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public String createTests(Map<String, String> values){
		try{
			String jiraProject=Config.getValue("JIRA_PROJECT");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(xpathForCreateTestConfirmation.getText().equals("Create Issue"), "Not inside create test page");
			logger.info("Create test page verified successfully.");
			logger.info("Project seleced is :"+jiraProject+"");
			values.put("PROJECT", jiraProject);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			Assert.assertTrue(xpathForIssueTypeTest.getText().equals("Test"),"Issue type is not Test");
			logger.info("Issue type is Test");
				
				//summary of test
				xpathToEnterSummary.clear();
				xpathToEnterSummary.sendKeys(values.get("SUMMARY"));
				
				//priority of test
				String selectedPriority=CommonUtil.getAttributeValueUsingWebElements(xpathToEnterPriority,"value");
				if(selectedPriority.equals(values.get("PRIORITY"))==false){
					priorityDropdown.click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					CommonUtil.changeToWebElement("//a[contains(text(),'"+values.get("PRIORITY")+"')]").click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					/*xpathToEnterPriority.clear();
					xpathToEnterPriority.sendKeys(values.get("PRIORITY"));*/
				}
				//component for the test
				componentDropdown.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//a[contains(text(),'"+values.get("COMPONENT")+"')]").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				/*xpathToEnterComponent.clear();
				xpathToEnterComponent.sendKeys(values.get("COMPONENT"),Keys.TAB);*/
				
				
				//affected version for the test
				affectedVersionDropdown.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//a[contains(text(),'"+values.get("AFFECTED_VERSION")+"')]").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				/*xpathToEnterAffectedVersion.clear();
				xpathToEnterAffectedVersion.sendKeys(values.get("AFFECTED_VERSION"),Keys.TAB);*/
				
				//fixversion for the test
				if(CommonUtil.isElementPresent("//*[@id='fixVersions-textarea']")){
					/*fixVersionDropdown.click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					CommonUtil.changeToWebElement("//a[contains(text(),'"+values.get("FIX_VERSION")+"')]").click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);*/
					xpathToEnterFixVersion.clear();
					xpathToEnterFixVersion.sendKeys(values.get("FIX_VERSION"),Keys.TAB);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				}
				
				//environment for the test
				xpathToEnterEnvironment.clear();
				xpathToEnterEnvironment.sendKeys(values.get("ENVIRONMENT"));
					
				//description for the test
				xpathToEnterDescription.clear();
				xpathToEnterDescription.sendKeys(values.get("DESCRIPTION"));
					
				// label for test
				xpathToEnterLabel.clear();
				xpathToEnterLabel.sendKeys(values.get("LABEL"),Keys.TAB);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);;
				//click to create a issue type test.
				xpathOfCreateTestButton.click();
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return ViewTestPage.getInstance().getTestsID();
		
	}
	public String createTests(String summary, String priority, String component,String affectedVersion, String fixedVersion, String enviroment, String description, String label){
		try{
			String jiraProject=Config.getValue("JIRA_PROJECT");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(xpathForCreateTestConfirmation.getText().equals("Create Issue"), "Not inside create test page");
			logger.info("Create test page verified successfully.");
			logger.info("Project seleced is :"+jiraProject+"");
			//values.put("PROJECT", jiraProject);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			Assert.assertTrue(xpathForIssueTypeTest.getText().equals("Test"),"Issue type is not Test");
			logger.info("Issue type is Test");
				
				//summary of test
				xpathToEnterSummary.clear();
				xpathToEnterSummary.sendKeys(summary);
				
				//priority of test
				String selectedPriority=CommonUtil.getAttributeValueUsingWebElements(xpathToEnterPriority,"value");
				if(selectedPriority.equals(priority)==false){
					priorityDropdown.click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					CommonUtil.changeToWebElement("//a[contains(text(),'"+priority+"')]").click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					/*xpathToEnterPriority.clear();
					xpathToEnterPriority.sendKeys(values.get("PRIORITY"));*/
				}
				//component for the test
				componentDropdown.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//a[contains(text(),'"+component+"')]").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				/*xpathToEnterComponent.clear();
				xpathToEnterComponent.sendKeys(values.get("COMPONENT"),Keys.TAB);*/
				
				
				//affected version for the test
				affectedVersionDropdown.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//a[contains(text(),'"+affectedVersion+"')]").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				/*xpathToEnterAffectedVersion.clear();
				xpathToEnterAffectedVersion.sendKeys(values.get("AFFECTED_VERSION"),Keys.TAB);*/
				
				//fixversion for the test
				if(CommonUtil.isElementPresent("//*[@id='fixVersions-textarea']")){
					/*fixVersionDropdown.click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					CommonUtil.changeToWebElement("//a[contains(text(),'"+values.get("FIX_VERSION")+"')]").click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);*/
					xpathToEnterFixVersion.clear();
					xpathToEnterFixVersion.sendKeys(fixedVersion,Keys.TAB);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				}
				
				//environment for the test
				xpathToEnterEnvironment.clear();
				xpathToEnterEnvironment.sendKeys(enviroment);
					
				//description for the test
				xpathToEnterDescription.clear();
				xpathToEnterDescription.sendKeys(description);
					
				// label for test
				xpathToEnterLabel.clear();
				xpathToEnterLabel.sendKeys(label,Keys.TAB);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				//click to create a issue type test.
				xpathOfCreateTestButton.click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return ViewTestPage.getInstance().getTestsID();
		
	}
	
	

}
