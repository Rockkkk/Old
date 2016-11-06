package com.thed.zfjbvt.jira.impl.jira52;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
/**
 * This is JIRA's Administration page, what user sees after clicking on administration link.
 * @author Manoj
 *
 */
public class JiraAdministrationPage {
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the Jira Administration Page and returns the page instance.
	 * @return This returns the Jira Administration Page instance.
	 */
	public static JiraAdministrationPage getInstance() {
		JiraAdministrationPage page = PageFactory.initElements(Driver.driver, JiraAdministrationPage.class);
		return page ;
	}
	
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	//Admin page heading Text(Administration Text)
	@FindBy(id="admin-page-heading")
	private WebElement adminPageHeaderText;
	
	public WebElement getAdminPageTextForVerification() {
		return adminPageHeaderText;
	}
	// Jira Leave admin link.
	@FindBy(id="leave_admin")
	private WebElement exitAdminLink;
	
	
	//Admin page select project link where you can select a project.
	@FindBy(id="admin_project_menu")
	private WebElement adminpageSelectprojectLink;
	
	public WebElement getAdminpageSelectprojectLink() {
		return adminpageSelectprojectLink;
	}
	
	//Admin page project drop down menu link
	@FindBy(id="admin_project_menu_drop")
	private WebElement adminPageProjectDropDownMenu;
	
	public WebElement getAdminPageProjectDropDownMenu() {
		return adminPageProjectDropDownMenu;
	}
	
	//Admin page select plugin link where you can select a project.
	@FindBy(id="admin_plugins_menu")
	private WebElement adminPagePluginLink;
	
	public WebElement getAdminPagePluginLink() {
		return adminPagePluginLink;
	}
	
	//Admin page plugin dropdown menu where u can select the plugins, source control and builds.
	@FindBy(id="admin_plugins_menu_drop")
	private WebElement adminPagePluginDropDownMenu;
	
	public WebElement getAdminPagePluginDropDownMenu() {
		return adminPagePluginDropDownMenu;
	}
	
	//Admin page users link
	@FindBy(id="admin_users_menu")
	private WebElement adminPageUserLink;
	
	public WebElement getAdminPageUserLink() {
		return adminPageUserLink;
	}
	
	//Admin page users link where You can manage the users.
	@FindBy(id="admin_users_menu_drop")
	private WebElement adminPageUsersDropDownMenu;
	
	public WebElement getAdminPageUsersDropDownMenu() {
		return adminPageUsersDropDownMenu;
	}
	
	//Admin Page Issues Link.
	@FindBy(id="admin_issues_menu")
	private WebElement adminPageIssuesLink;
	
	public WebElement getAdminPageIssuesLink() {
		return adminPageIssuesLink;
	}
	
	//Admin Page Issues Link where you can manage the issues.
	@FindBy(id="admin_issues_menu")
	private WebElement adminPageIssuesDropDownMenu;
	
	public WebElement getAdminPageIssuesDropDownMenu() {
		return adminPageIssuesDropDownMenu;
	}
	
	//Admin Page system Link
	@FindBy(id="admin_system_menu")
	private WebElement adminPageSystemLink;
	
	public WebElement getAdminPageSystemLink() {
		return adminPageSystemLink;
	}
	
	//Admin Page system Link
	@FindBy(id="admin_system_menu_drop")
	private WebElement adminPageSystemDropDownMenu;
	
	public WebElement getAdminPageSystemDropDownMenu() {
		return adminPageSystemDropDownMenu;
	}
	
	// Admin Page Quick search text box where u can search any thing.
	@FindBy(id="admin-quick-nav-field")
	private WebElement adminPageQuickSearchTextBox;
	
	public WebElement getAdminPageQuickSearchTextBox() {
		return adminPageQuickSearchTextBox;
	}
		
	/*Submenu webelements of all Menus*/
	//For Plugin menu
	//Find new Add-ons link present in plugin drop down menu.
	@FindBy(id="upm-marketplace-link")
	private WebElement findNewAddonsLink;
	
	public WebElement getFindNewAddonsLink() {
		return findNewAddonsLink;
	}
		//Search in the market place SearchBox where you can find any plugin
		@FindBy(id="upm-install-search-box")
		private WebElement findAddonsSearchBox;
	
		public WebElement getFindAddonsSearchBox() {
			return findAddonsSearchBox;
		}
	
	//manage addons link present in plugin drop down menu.
	@FindBy(id="upm-admin-link")
	private WebElement manageAddonsLink;
	
	public WebElement getManageAddonsLink() {
		return manageAddonsLink;
	}
				/***
				 * All manage plugin webelements are keeping here.
				 */
					@FindBy(id="upm-upload")
					private WebElement fileUploadLink;
					
					public WebElement getFileUploadLink(){
						return fileUploadLink;
					}
					
					@FindBy(xpath="//body[@id='jira']/div[@id='upm-upload-dialog']/div/h2[@class='dialog-title']")
					private WebElement fileUploadHeaderText;
					
					public WebElement getFileUploadHeaderText(){
						return fileUploadHeaderText;
					}
					
					@FindBy(xpath="//*[@id='upm-upload-dialog']/div/div/button[text()='Upload']")
					private WebElement uploadButtonInUploadPlugIn;
					
					
	
	// Requested addons link present in plugin drop down menu.
	@FindBy(id="upm-viewrequests-link")
	private WebElement requestedAddonsLink;
	
	public WebElement getRequestedAddonsLink() {
		return requestedAddonsLink;
	}
	
	// Audit log present in plugin drop down link.
	@FindBy(id="upm-audit-link")
	private WebElement auditLogLink;
	
	public WebElement getAuditLogLink() {
		return auditLogLink;
	}
	
	// Application links link present in plugin drop down menu.
	@FindBy(id="upm-update-check-link")
	private WebElement applicationLinksLink;
	
	public WebElement getApplicationLinksLink() {
		return applicationLinksLink;
	}
	
	//zephyr for jira link present in plugin menu.
	@FindBy(linkText="Zephyr for JIRA")
	private WebElement zephyrForJiraAdminLink;

	public WebElement getZephyrForJiraLink() {
		return zephyrForJiraAdminLink;
	}
			/*In Administration Under zephyr For Zira Link webelements.*/
			//General configuration tab in zephyr for jira link
			@FindBy(id="zephyr_general_configuration_tab")
			private WebElement zephyrGeneralConfigurationTab;
			
			public WebElement getZephyrGeneralConfigurationTab() {
				return zephyrGeneralConfigurationTab;
			}
			//Zephyr Licence tab in zephyr for jira link
			@FindBy(id="zephyr_license_tab")
			private WebElement zephyrLicenceTab;
			
			public WebElement getZephyrLicenceTab() {
				return zephyrLicenceTab;
			}		
					// xpath for header for test execution status page. 
					@FindBy(xpath="//td[@class='jiraformheader']/h3[@class='formtitle formtitle-bamboo']")
					private WebElement headerForTestExecutionStatusPageXpath;
					
					public WebElement getHeaderForTestExecutionStatusPageXpath(){
						return headerForTestExecutionStatusPageXpath;
					}
					
					@FindBy(xpath="//table[thead[tr[th[contains(text(),'Status')]]]]/tbody/tr/td[1]")
					private WebElement allTestExecutionStatuses;
					
					public WebElement getAllTestExecutionStatuses(){
						return allTestExecutionStatuses;
					}
							/*Edit Test status page webelements.*/
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
							/*add new status webelements*/
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
					
			//Test status tab in zephyr for jira link
			@FindBy(id="zephyr_execution_statuses_tab")
			private WebElement zephyrTestExecutionStatusTab;
			
			public WebElement getZephyrTestExecutionStatusTab() {
				return zephyrTestExecutionStatusTab;
			}
			//Test Step status tab in zephyr for jira link
			@FindBy(id="zephyr_step_execution_statuses_tab")
			private WebElement zephyrTestStepExecutionTab;
			
			public WebElement getZephyrTestStepExecutionTab() {
				return zephyrTestStepExecutionTab;
			}
			//General Information tab in zephyr for jira link
			@FindBy(id="zephyr_info_configuration_tab")
			private WebElement zephyrGeneralInformationTab;
			
			public WebElement getZephyrGeneralInformationTab() {
				return zephyrGeneralInformationTab;
			}
		
	/******************************************************
	* 	PAGE OBJECT METHODS
	*****************************************************/
	/**
	 * This method is used to navigate to find new add-ons page administration page from Jira Administration page and it will first show the administration authenticate page and after validating admin  it will show find new add-ons page. 
	 * @return Returns a instance of Jira Administration AuthenticatePage.
	 */
	public JiraAdministrationAuthenticatePage navigateToFindNewPlugInPage(){
		try{
			Assert.assertTrue(adminPageHeaderText.getText().equals("Administration"), "This is not Administration page.");
			logger.info("Administration page is verified successfully.");
			adminPagePluginDropDownMenu.click();
			findNewAddonsLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
	return JiraAdministrationAuthenticatePage.getInstance();
	}
	/**
	 * This method is used to navigate to manage add-ons page administration page from Jira Administration page and it will first show the administration authenticate page and after validating admin  it will show manage add-ons page. 
	 * @return Returns a instance of Jira Administration AuthenticatePage.
	 */
	public JiraAdministrationAuthenticatePage navigateToManageAddonsPage(){
		try{
			Assert.assertTrue(adminPageHeaderText.getText().equals("Administration"), "This is not Administration page.");
			logger.info("Administration page is verified successfully.");
			adminPagePluginDropDownMenu.click();
			manageAddonsLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);		
		}catch(Exception e){
			e.printStackTrace();
		}
		return JiraAdministrationAuthenticatePage.getInstance();
	}
	/**
	 * This method is used to navigate to zfj administration page from Jira Administration page. 
	 * @return Returns a instance of zfj administration page.
	 */		
	public ZephyrForJiraAdminPage navigateToZFJAdminPage(){
		try{
			Assert.assertTrue(adminPageHeaderText.getText().equals("Administration"), "This is not Administration page.");
			logger.info("Administration page is verified successfully.");
			adminPagePluginDropDownMenu.click();
			zephyrForJiraAdminLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return ZephyrForJiraAdminPage.getInstance();
	}
	/**
	 * This method is used to leave administration page and goes to jira landing page. 
	 * @return Returns a instance of Jira Landing Page.
	 */		
	/*public JiraLandingPage leavingAdministrationPage(){
		try{
			exitAdminLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Leaving Administration page and navigated to jira landing page.");				
		}catch(Exception e){
			e.printStackTrace();
		}
		return JiraLandingPage.getInstance();
	}*/
	public boolean leavingAdministrationPage(){
		try{
			exitAdminLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Leaving Administration page and navigated to jira landing page.");				
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
		
	
				
			
	
	
	
	
	
	
	
	
	
	

}
