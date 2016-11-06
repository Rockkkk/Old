package com.thed.zfjbvt.zfj.impl.zfj21;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.jira.impl.jira52.JiraAdministrationPage;
import com.thed.zfjbvt.jira.impl.jira52.JiraLandingPage;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj21.ZFJAdminCustomizeStepStatusPage;
import com.thed.zfjbvt.zfj.impl.zfj21.ZFJAdminCustomizeTestStatusPage;
import com.thed.zfjbvt.zfj.impl.zfj21.ZephyrTestMenuPage;

public class ZephyrForJiraAdminPage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private static ZephyrTestMenuPage zephyrTestMenuPage=ZephyrTestMenuPage.getInstance(JiraLandingPage.getInstance().getZephyrTestLink());
	/**
	 * This method will initialize all the webelements inside the ZFJ Admin Page and returns the page instance.
	 * @return This returns the ZFJ Admin Page instance.
	 */	
	public static ZephyrForJiraAdminPage getInstance() {
		ZephyrForJiraAdminPage page = PageFactory.initElements(Driver.driver, ZephyrForJiraAdminPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	/*In Administration Under zephyr For Zira Link webelements.*/
	// zfj admin page header text inside jira administration.
	@FindBy(id="admin-page-heading")
	private WebElement zfjAdminPageHeaderText;
	
	//General configuration tab in zephyr for jira link
	@FindBy(id="zephyr_general_configuration_tab")
	private WebElement zephyrGeneralConfigurationTab;
	
	//Zephyr Licence tab in zephyr for jira link
	@FindBy(id="zephyr_license_tab")
	private WebElement zephyrLicenceTab;
		
	//Test status tab in zephyr for jira link
	@FindBy(id="zephyr_execution_statuses_tab")
	private WebElement zephyrCustomizeTestStatusTab;
	
	// Test Step status tab in zephyr for jira link
	@FindBy(id="zephyr_step_execution_statuses_tab")
	private WebElement zephyrCustomizeStepExecutionTab;
	
	// General Information tab in jira administration zephyr for jira link.
	@FindBy(id="zephyr_info_configuration_tab")
	private WebElement zephyrGeneralInformationTab;
	
	// Workflow toolbar  check box in Zephyr for jira page.
	@FindBy(id="zephyr-show-workflow")
	private WebElement workflowToolbarChckbox;
	
	//issue link check box in Zephyr for jira page.
	@FindBy(id="zephyr-issuelink-check")
	private WebElement issueLinkChckbox;
	
	//remote issue link check box in Zephyr for jira page.
	@FindBy(id="zephyr-ril-check")
	private WebElement remoteIssueLinkChckbox;
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to navigate to customize test status page.
	 * @return The instance of ZFJ Admin CustomizeTestStatus Page.
	 */
	public ZFJAdminCustomizeTestStatusPage navigateToCustomizeTestStatusTab(){
		try{
			Assert.assertTrue(zfjAdminPageHeaderText.getText().equals("Zephyr for JIRA"), "This is not zfj Administration page.");
			logger.info("zfj admin page is verified successfully.");
			zephyrCustomizeTestStatusTab.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ZFJAdminCustomizeTestStatusPage.getInstance();
	}
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to navigate to customize step status page.
	 * @return The instance of ZFJ Admin CustomizeStepStatus Page.
	 */
	public ZFJAdminCustomizeStepStatusPage navigateToCustomizeStepStatusTab(){
		try{
			Assert.assertTrue(zfjAdminPageHeaderText.getText().equals("Zephyr for JIRA"), "This is not zfj Administration page.");
			logger.info("zfj admin page is verified successfully.");
			zephyrCustomizeStepExecutionTab.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ZFJAdminCustomizeStepStatusPage.getInstance();
	}
	
	
	public boolean checkWorkflowToolbar(){
		try{
			boolean workflowChckboxStatus=workflowToolbarChckbox.isSelected();
			if(workflowChckboxStatus){
				logger.info("Workflow Toolbar is Checked...");
				JiraAdministrationPage.getInstance().leavingAdministrationPage();
				Assert.assertTrue(zephyrTestMenuPage.navigateToSearchTestsPage()
						.navigateToFirstTest().checkWorkflowToolbar(workflowChckboxStatus));//change this ASAP....
			}
			else{
				JiraAdministrationPage.getInstance().leavingAdministrationPage();
				Assert.assertTrue(zephyrTestMenuPage.navigateToSearchTestsPage()
						.navigateToFirstTest().checkWorkflowToolbar(workflowChckboxStatus));//change this ASAP....
			}
			
		}catch(Exception e){
			logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean changeWorkflowStatus(){
		try{
			workflowToolbarChckbox.click();
			JiraAdministrationPage.getInstance().leavingAdministrationPage();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean checkIssueLink(){
		try{
			boolean issueLink= issueLinkChckbox.isSelected();
			if(issueLink){
				logger.info("Issue link for issue test checked...");
			}
			else{
				logger.info("Issue link for issue test unchecked...");
			}
			JiraAdministrationPage.getInstance().leavingAdministrationPage();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean changeIssueLinkStatus(){
		try{
			issueLinkChckbox.click();
			if(issueLinkChckbox.isSelected()){
				logger.info("Issue link for issue test checked now...");
			}
			else{
				logger.info("Issue link for issue test unchecked now...");
			}
			JiraAdministrationPage.getInstance().leavingAdministrationPage();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean checkRemoteIssueLink(){
		try{
			boolean remoteIssueLink= remoteIssueLinkChckbox.isSelected();
			if(remoteIssueLink){
				logger.info(" Remote Issue link for issue test checked...");
			}
			else{
				logger.info(" Remote Issue link for issue test unchecked...");
			}
			JiraAdministrationPage.getInstance().leavingAdministrationPage();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean changeRemoteIssueLinkStatus(){
		try{
			remoteIssueLinkChckbox.click();
			if(remoteIssueLinkChckbox.isSelected()){
				logger.info("Remote Issue link for issue test checked now...");
			}
			else{
				logger.info("Remote Issue link for issue test unchecked now...");
			}
			JiraAdministrationPage.getInstance().leavingAdministrationPage();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
//**************************************************************/
	// xpath for header for test execution status page. 
	/*	@FindBy(xpath="//td[@class='jiraformheader']/h3[@class='formtitle formtitle-bamboo']")
		private WebElement headerForTestExecutionStatusPageXpath;
		
		public WebElement getHeaderForTestExecutionStatusPageXpath(){
			return headerForTestExecutionStatusPageXpath;
		}
		
		@FindBy(xpath="//table[thead[tr[th[contains(text(),'Status')]]]]/tbody/tr/td[1]")
		private WebElement allTestExecutionStatuses;
		
		public WebElement getAllTestExecutionStatuses(){
			return allTestExecutionStatuses;
		}
				Edit Test status page webelements.
				@FindBy(name="name")
				private WebElement statusTextBoxInEditTestExecutionStatus;
				
				public WebElement getStatusTextBoxInEditTestExecutionStatus(){
					return statusTextBoxInEditTestExecutionStatus;
				}
				
				@FindBy(name="description")
				private WebElement statusDescriptionInEditTestExecutionStatus;
				
				public WebElement getStatusDescriptionInEditTestExecutionStatus(){
					return statusDescriptionInEditTestExecutionStatus;
				}
				
				@FindBy(id="edit_submit")
				private WebElement submitButtonInEditTestExecutionStatus;
				
				public WebElement getSubmitButtonInEditTestExecutionStatus(){
					return submitButtonInEditTestExecutionStatus;
				}
				add new status webelements
				@FindBy(name="statusColor")
				private WebElement executionStatusColorTextBox;
				
				public WebElement getExecutionStatusColorTextBox(){
					return executionStatusColorTextBox;
				}
				@FindBy(id="add_submit")
				private WebElement submitButtonInAddTestExecutionStatus;
				
				public WebElement getSubmitButtonInAddTestExecutionStatus(){
					return submitButtonInAddTestExecutionStatus;
				}
		



public WebElement getZephyrTestStepExecutionTab() {
return zephyrCustomizeStepExecutionTab;
}

	// Test step status page
	@FindBy(xpath="//td[@class='jiraformheader']/h3[@class='formtitle formtitle-bamboo']")
	private WebElement headerForTestStepExecutionStatusPageXpath;
	
	public WebElement getHeaderForTestStepExecutionStatusPageXpath(){
		return headerForTestStepExecutionStatusPageXpath;
	}
	
	@FindBy(xpath="//table[thead[tr[th[contains(text(),'Status')]]]]/tbody/tr/td[1]")
	private WebElement allTestStepExecutionStatuses;
	
	public WebElement getAllTestStepExecutionStatuses(){
		return allTestStepExecutionStatuses;
	}
			Edit Test status page webelements.
			@FindBy(name="name")
			private WebElement testStepStatusTextBoxInEditTestStatus;
			
			public WebElement getTestStepStatusTextBoxInEditTestStatus(){
				return testStepStatusTextBoxInEditTestStatus;
			}
			
			@FindBy(name="description")
			private WebElement statusDescriptionInEditTestStepExecutionStatus;
			
			public WebElement getStatusDescriptionInEditTestStepExecutionStatus(){
				return statusDescriptionInEditTestStepExecutionStatus;
			}
			
			@FindBy(id="edit_submit")
			private WebElement submitButtonInEditTestStepExecutionStatus;
			
			public WebElement getSubmitButtonInEditTestStepExecutionStatus(){
				return submitButtonInEditTestStepExecutionStatus;
			}
			add new status webelements
			@FindBy(name="statusColor")
			private WebElement testStepExecutionStatusColorCodeTextBox;
			
			public WebElement getTestStepExecutionStatusColorCodeTextBox(){
				return testStepExecutionStatusColorCodeTextBox;
			}
			@FindBy(id="add_submit")
			private WebElement submitButtonInAddTestStepExecutionStatus;
			
			public WebElement getSubmitButtonInAddTestStepExecutionStatus(){
				return submitButtonInAddTestStepExecutionStatus;
			}
	


public WebElement getZephyrGeneralInformationTab() {
return zephyrGeneralInformationTab;
}

	
	public WebElement getZephyrGeneralConfigurationTab() {
		return zephyrGeneralConfigurationTab;
	}

	public WebElement getZephyrLicenceTab() {
		return zephyrLicenceTab;
	}		
		
	public WebElement getZephyrTestExecutionStatusTab() {
		return zephyrCustomizeStepExecutionTab;
	}
				*/
		

}
