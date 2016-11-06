package com.thed.zfjbvt.zfj.impl.zfj173;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class EditTestPage {
	
private Logger logger = Logger.getLogger(this.getClass());
	
	public static EditTestPage getInstance() {
		EditTestPage page = PageFactory.initElements(Driver.driver, EditTestPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//id for getting the user loggedin.
	@FindBy(id="header-details-user-fullname")
	private WebElement xpathForGettingUserLoggedIn;
		
	//Xpath to validate edit test page.
	@FindBy(xpath="//*[@id='edit-issue-dialog']/h2")
	private WebElement  xpathForHeaderOfEditPage;
	
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
		
		//id for updateButton in edit test page.
		@FindBy(id="edit-issue-submit")
		private WebElement xpathForEditTestButton;
	
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
		public boolean editTest(Map<String, String>values){
			try{
				String jiraProject=Config.getValue("JIRA_PROJECT");
				if(xpathForHeaderOfEditPage.isDisplayed()){
					logger.info("Navigated to Edit Test Page Successfully...");
						//summary of test
						xpathToEnterSummary.clear();
						xpathToEnterSummary.sendKeys(values.get("CHANGE_SUMMARY_TO"));
						
						//priority of test
						String selectedPriority=CommonUtil.getAttributeValueUsingWebElements(xpathToEnterPriority,"value");
						if(selectedPriority.equals(values.get("CHANGE_PRIORITY_TO"))==false){
							xpathToEnterPriority.clear();
							xpathToEnterPriority.sendKeys(values.get("CHANGE_PRIORITY_TO"));
						}
						//component for the test
						xpathToEnterComponent.sendKeys(Keys.BACK_SPACE);
						xpathToEnterComponent.sendKeys(Keys.BACK_SPACE);
						xpathToEnterComponent.sendKeys(values.get("CHANGE_COMPONENT_TO"),Keys.TAB);
						CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
						
						//affected version for the test
						xpathToEnterAffectedVersion.sendKeys(Keys.BACK_SPACE);
						xpathToEnterAffectedVersion.sendKeys(Keys.BACK_SPACE);
						xpathToEnterAffectedVersion.sendKeys(values.get("CHANGE_AFFECTED_VERSION_TO"),Keys.TAB);
						if(CommonUtil.isElementPresent("//*[@id='fixVersions-textarea']")){	
							//fixversion for the test
							xpathToEnterFixVersion.sendKeys(Keys.BACK_SPACE);
							xpathToEnterFixVersion.sendKeys(Keys.BACK_SPACE);
							xpathToEnterFixVersion.sendKeys(values.get("CHANGE_FIXVERSION_TO"),Keys.TAB);
							CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
						}	
						//environment for the test
						xpathToEnterEnvironment.clear();
						xpathToEnterEnvironment.sendKeys(values.get("CHANGE_ENVIRONMENT_TO"));
							
						//description for the test
						xpathToEnterDescription.clear();
						xpathToEnterDescription.sendKeys(values.get("CHANGE_DESCRIPTION_TO"));
							
						// label for test
						xpathToEnterLabel.sendKeys(Keys.BACK_SPACE);
						xpathToEnterLabel.sendKeys(Keys.BACK_SPACE);
						xpathToEnterLabel.sendKeys(values.get("CHANGE_LABEL_TO"),Keys.TAB);
						CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
						
						//click on edit test button.
						xpathForEditTestButton.click();
						CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
						
					
					logger.info("Test After Editing....");
					values.put("PROJECT",jiraProject);
					values.put("SUMMARY",values.get("CHANGE_SUMMARY_TO"));
					values.put("PRIORITY",values.get("CHANGE_PRIORITY_TO"));
					values.put("COMPONENT", values.get("CHANGE_COMPONENT_TO"));
					values.put("AFFECTED_VERSION", values.get("CHANGE_AFFECTED_VERSION_TO"));
					values.put("FIX_VERSION", values.get("CHANGE_FIXVERSION_TO"));
					values.put("ENVIRONMENT", values.get("CHANGE_ENVIRONMENT_TO"));
					values.put("DESCRIPTION", values.get("CHANGE_DESCRIPTION_TO"));
					values.put("LABEL", values.get("CHANGE_LABEL_TO"));
					CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				}
				
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			
			return ViewTestPage.getInstance().validateTestCreated(values);
		}
		
		
	/*public boolean editTest(Map<String, String>values){
		try{
			String jiraProject=Config.getValue("JIRA_PROJECT");
			if(xpathForHeaderOfEditPage.isDisplayed()){
				logger.info("Navigated to Edit Test Page Successfully...");
				//summary of test
					xpathToEnterSummary.clear();
					xpathToEnterSummary.sendKeys(values.get("CHANGESUMMARYTO"));
					
					//priority of test
					String selectedPriority=CommonUtil.getAttributeValueUsingWebElements(xpathToEnterPriority,"value");
					if(selectedPriority.equals(values.get("CHANGEPRIORITYTO"))==false){
						xpathToEnterPriority.clear();
						xpathToEnterPriority.sendKeys(values.get("CHANGEPRIORITYTO"));
					}
					//component for the test
					xpathToEnterComponent.sendKeys(Keys.BACK_SPACE);;
					xpathToEnterComponent.sendKeys(Keys.BACK_SPACE);;
					xpathToEnterComponent.sendKeys(values.get("CHANGECOMPONENTTO"),Keys.TAB);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					
					//affected version for the test
					xpathToEnterAffectedVersion.sendKeys(Keys.BACK_SPACE);;
					xpathToEnterAffectedVersion.sendKeys(Keys.BACK_SPACE);;
					xpathToEnterAffectedVersion.sendKeys(values.get("CHANGEAFFECTEDVERSIONTO"),Keys.TAB);
					if(xpathToEnterFixVersion.isDisplayed()){	
					//fixversion for the test
					xpathToEnterFixVersion.sendKeys(Keys.BACK_SPACE);;
					xpathToEnterFixVersion.sendKeys(Keys.BACK_SPACE);;
					xpathToEnterFixVersion.sendKeys(values.get("CHANGEFIXVERSIONTO"),Keys.TAB);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					}	
					//environment for the test
					xpathToEnterEnvironment.clear();
					xpathToEnterEnvironment.sendKeys(values.get("CHANGEENVIRONMENTTO"));
						
					//description for the test
					xpathToEnterDescription.clear();
					xpathToEnterDescription.sendKeys(values.get("CHANGEDESCRIPTIONTO"));
						
					// label for test
					xpathToEnterLabel.sendKeys(Keys.BACK_SPACE);
					xpathToEnterLabel.sendKeys(Keys.BACK_SPACE);
					xpathToEnterLabel.sendKeys(values.get("CHANGELABELTO"),Keys.TAB);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					
					//click on edit test button.
					xpathForEditTestButton.click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
					
				
				logger.info("Test After Editing....");
				values.put("PROJECT",jiraProject);
				values.put("SUMMARY",values.get("CHANGESUMMARYTO"));
				values.put("PRIORITY",values.get("CHANGEPRIORITYTO"));
				values.put("COMPONENT", values.get("CHANGECOMPONENTTO"));
				values.put("AFFECTEDVERSION", values.get("CHANGEAFFECTEDVERSIONTO"));
				values.put("FIXVERSION", values.get("CHANGEFIXVERSIONTO"));
				values.put("ENVIRONMENT", values.get("CHANGEENVIRONMENTTO"));
				values.put("DESCRIPTION", values.get("CHANGEDESCRIPTIONTO"));
				values.put("LABEL", values.get("CHANGELABELTO"));
			}
			
		}catch(Exception e){
			logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
			return false;
		}
		
		return ViewTestPage.getInstance().validateTestCreated(values);
	}*/
	

}
