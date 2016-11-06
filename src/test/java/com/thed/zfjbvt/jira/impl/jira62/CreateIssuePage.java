package com.thed.zfjbvt.jira.impl.jira62;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
/**
 * This is zfj's create issue page, Here user can create an issue.
 * @author Manoj
 *
 */
public class CreateIssuePage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the Create Issue Page Page and returns the page instance.
	 * @return This returns the Create Issue Page Page instance.
	 */
	public static CreateIssuePage getInstance() {
		return PageFactory.initElements(Driver.driver, CreateIssuePage.class);
	}
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	// issue summary text box.
	@FindBy(id="summary")
	private WebElement issueSummaryTextBox;
	
	// create issue submit button
	@FindBy(id="create-issue-submit")
	private WebElement createIssueSubmitBtn;

	
	//xpath to validate create issue page.
	@FindBy(xpath="//*[@id='create-issue-dialog']//h2")
	private WebElement validateCreateIssuePage;
	
	//id of configure fields link.
	@FindBy(xpath= "//*[@id='qf-field-picker-trigger']/span[2]")
	private WebElement configureFieldLink;
	
	//xpath to customise field.
	@FindBy(xpath="//*[text()='Custom']")
	private WebElement customiseField;
	
	//id of issue type in create issue page.
	@FindBy(id="issuetype-field")
	private WebElement issueTypeField;
	
	//xpath to get the Test id created.
	@FindBy(xpath="//div[@class='aui-message success closeable']/a")
	private WebElement fetchId;
	
	//xpath to close the created issue pop-up.
	@FindBy(xpath="//div[@class='aui-message success closeable']/span[2]")
	private WebElement closePopup;
	
	/*public WebElement getCreateIssueSubmitBtn() {
		return createIssueSubmitBtn;
	}*/
	
	@FindBy(id="current-defectpicker-status-dd-schedule")
	private WebElement currentDefectPicker;
	
	@FindBy(xpath="//a[@class='cancel']")
	private WebElement cancelLink;

	//xpath of next button.
	@FindBy(xpath="//*[@name='Next' and @type='submit']")
	private WebElement nextButton;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to configure the Fields in create issue page. by giving Fields as argument.
	 * @param two fields that has to configured in the create issue page.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean configureField(String firstField, String secondField){
		try{
			Assert.assertTrue(validateCreateIssuePage.isDisplayed(), "Create Issue Validation Failed..."); 
			//CommonUtil.actionClass().sendKeys(configureFieldLink, Keys.ENTER).perform();
			configureFieldLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			customiseField.click();
			checkFieldVisibility(firstField);
			checkFieldVisibility(secondField);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().click(cancelLink).perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().click(cancelLink).perform();
			
		}catch(Exception e){
			CommonUtil.actionClass().click(cancelLink).perform();
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).perform();
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	
	
	

	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to create a issue by giving summary as argument.
	 * @param issueSummary This parameter contains the issue summary, by giving the issue summary we can create an issue.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean createIssue(String issueSummary){
		try{
			issueSummaryTextBox.clear();
			issueSummaryTextBox.sendKeys(issueSummary);
			createIssueSubmitBtn.click();
			//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			CommonUtil.visibilityOfElementLocated("//div[@class='global-msg']/div[@class='aui-message success closeable']");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to create a issue by giving summary and issue type as argument.
	 * @param issueSummary This parameter contains the issue summary, by giving the issue summary we can create an issue.
	 * @param issueType This parameter contains the issue type, which spcifies the type of issue thats been created.
	 * @return The boolean value i.e. True or False.
	 */
	public String createIssue(String issueSummary,String issueType){
		String issueId = null;
		try{
			String issue= CommonUtil.getAttributeValueUsingWebElements(issueTypeField, "value");
			if(issue.equals(issueType)==false){
				issueTypeField.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				issueTypeField.clear();
				issueTypeField.sendKeys(Keys.DELETE);
				issueTypeField.sendKeys(issueType,Keys.TAB);
			}
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			issueSummaryTextBox.click();
			issueSummaryTextBox.clear();
			issueSummaryTextBox.sendKeys(issueSummary);
			createIssueSubmitBtn.click();
			CommonUtil.ExplicitWaitForElement(fetchId);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String[] test = fetchId.getText().split("- "+issueSummary);
			issueId = test[0].trim();
			closePopup.click();
			
		}catch(Exception e){
			e.printStackTrace();
			return issueId;
		}
		return issueId;
	}
	
	public String createDefect(String issueSummary,String issueType){
		String issueId = null;
		try{
			if(CommonUtil.isElementDisplayed(nextButton)==true){
				String issue= CommonUtil.getAttributeValueUsingWebElements(issueTypeField, "value");
				if(issue.equals(issueType)==false){
					issueTypeField.click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
					issueTypeField.clear();
					issueTypeField.sendKeys(Keys.DELETE);
					issueTypeField.sendKeys(issueType,Keys.TAB);
				}
				nextButton.click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				issueSummaryTextBox.click();
				issueSummaryTextBox.clear();
				issueSummaryTextBox.sendKeys(issueSummary);
				CommonUtil.changeToWebElement("//*[@id='issue-create-submit']").click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
				issueId = CommonUtil.getTextFromUIByXpath("//*[@id='key-val']");
				
			}
			else{
				String issue= CommonUtil.getAttributeValueUsingWebElements(issueTypeField, "value");
				if(issue.equals(issueType)==false){
					issueTypeField.click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
					issueTypeField.clear();
					issueTypeField.sendKeys(Keys.DELETE);
					issueTypeField.sendKeys(issueType,Keys.TAB);
				}
				
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				issueSummaryTextBox.click();
				issueSummaryTextBox.clear();
				issueSummaryTextBox.sendKeys(issueSummary);
				createIssueSubmitBtn.click();
				CommonUtil.ExplicitWaitForElement(fetchId);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				String[] test = fetchId.getText().split("- "+issueSummary);
				issueId = test[0].trim();
				closePopup.click();
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return issueId;
		}
		return issueId;
	}

	public String createIssues(String issueSummary,String issueType){
		String issueId = null;
		try{
			String issue= CommonUtil.getAttributeValueUsingWebElements(issueTypeField, "value");
			if(issue.equals(issueType)==false){
				issueTypeField.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				issueTypeField.clear();
				issueTypeField.sendKeys(Keys.DELETE);
				issueTypeField.sendKeys(issueType,Keys.TAB);
			}
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			issueSummaryTextBox.click();
			issueSummaryTextBox.clear();
			issueSummaryTextBox.sendKeys(issueSummary);
			createIssueSubmitBtn.click();
			CommonUtil.ExplicitWaitForElement(fetchId);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String[] test = fetchId.getText().split("- "+issueSummary);
			issueId = test[0].trim();
			//createIssueSubmitBtn.sendKeys(Keys.RETURN);
			//CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).perform();
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).perform();
			//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			//CommonUtil.visibilityOfElementLocated("//div[@class='global-msg']/div[@class='aui-message success closeable']");
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).perform();
			
		}catch(Exception e){
			e.printStackTrace();
			return issueId;
		}
		return issueId;
	}
	

	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	private boolean checkFieldVisibility(String field){
		try{
			if(CommonUtil.getAttributeValue("//*[@id='inline-dialog-field_picker_popup']//a[contains(text(),'"+field+"')]", "class").contains("qf-active")){
				logger.info("Field "+field+" Already checked");
				if(field.equalsIgnoreCase("Attachment")){
					CommonUtil.scrollToWebElement(CommonUtil.changeToWebElement("//legend[span[text()='Attachment']]"));
					Assert.assertTrue(CommonUtil.changeToWebElement("//legend[span[text()='Attachment']]").isDisplayed());
					logger.info("Field "+field+" is Displayed... ");
					
				}
				else if(field.equalsIgnoreCase("Time Tracking")){
						CommonUtil.scrollToWebElement(CommonUtil.changeToWebElement("//label[contains(text(),'Original Estimate')]"));
						CommonUtil.scrollToWebElement(CommonUtil.changeToWebElement("//label[contains(text(),'Remaining Estimate')]"));
						Assert.assertTrue((CommonUtil.changeToWebElement("//label[contains(text(),'Original Estimate')]").isDisplayed()) && (CommonUtil.changeToWebElement("//label[contains(text(),'Remaining Estimate')]").isDisplayed()));
						logger.info("Field "+field+" is Displayed... ");
							
				}
				else{
					CommonUtil.scrollToWebElement(CommonUtil.changeToWebElement("//label[contains(text(),'"+field+"')]"));
					Assert.assertTrue(CommonUtil.changeToWebElement("//label[contains(text(),'"+field+"')]").isDisplayed());
					logger.info("Field "+field+" is Displayed... ");
				}
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//*[@id='inline-dialog-field_picker_popup']//a[contains(text(),'"+field+"')]").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				if(field.equalsIgnoreCase("Attachment")){
					Assert.assertFalse(CommonUtil.changeToWebElement("//legend[span[text()='Attachment']]").isDisplayed());
					logger.info("Field "+field+" Deselected now");
				}
				else if(field.equalsIgnoreCase("Time Tracking")){
					Assert.assertFalse((CommonUtil.changeToWebElement("//label[contains(text(),'Original Estimate')]").isDisplayed()) && (CommonUtil.changeToWebElement("//label[contains(text(),'Remaining Estimate')]").isDisplayed()));
					logger.info("Field "+field+" Deselected now");
				}
				else{
					Assert.assertFalse(CommonUtil.changeToWebElement("//label[contains(text(),'"+field+"')]").isDisplayed());
					logger.info("Field "+field+" Deselected now");
				}
				
			}
			
			else{
				logger.info("Field "+field+" Unchecked");
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//*[@id='inline-dialog-field_picker_popup']//a[contains(text(),'"+field+"')]").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				if(field.equalsIgnoreCase("Attachment")){
					CommonUtil.scrollToWebElement(CommonUtil.changeToWebElement("//legend[span[text()='Attachment']]"));
					Assert.assertTrue(CommonUtil.changeToWebElement("//legend[span[text()='Attachment']]").isDisplayed());
						logger.info("Field "+field+" Selected now");
						logger.info("Field "+field+" is Displayed... ");					
				}
				else if(field.equalsIgnoreCase("Time Tracking")){
					Assert.assertTrue((CommonUtil.changeToWebElement("//label[contains(text(),'Original Estimate')]").isDisplayed()) && (CommonUtil.changeToWebElement("//label[contains(text(),'Remaining Estimate')]").isDisplayed()));
					logger.info("Field "+field+" Selected now");
					logger.info("Field "+field+" is Displayed... ");
				}
				else{
					Assert.assertTrue(CommonUtil.changeToWebElement("//label[contains(text(),'"+field+"')]").isDisplayed());
					logger.info("Field "+field+" Selected now");
					logger.info("Field "+field+" is Displayed... ");
				}
				
			}
				
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
