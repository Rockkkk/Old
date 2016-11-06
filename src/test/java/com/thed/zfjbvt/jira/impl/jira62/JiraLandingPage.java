package com.thed.zfjbvt.jira.impl.jira62;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.jira.impl.jira62.BrowseProjectPage;
import com.thed.zfjbvt.jira.impl.jira62.JiraAdminAddonsPage;
import com.thed.zfjbvt.jira.impl.jira62.JiraAdministrationAuthenticatePage;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
/**
 * This is JIRA's landing page, what user sees after login.
 * @author Manoj
 *
 */
public class JiraLandingPage {
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the Jira Landing Page and returns the page instance.
	 * @return This returns the Jira Landing Page instance.
	 */
	public static JiraLandingPage getInstance() {
		JiraLandingPage page = PageFactory.initElements(Driver.driver, JiraLandingPage.class);
		return page ;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	//Administration Link webelement in Jira's landing page.
	@FindBy(xpath="//*[@id='system-admin-menu']/a[@title='Administration']")
	private WebElement administrationDropDownLink;
	
	//Addons link in admin drop down .
	@FindBy(id="admin_plugins_menu")
	private WebElement AddonsLinkInAdminDropDown;
	
	//Addons link in admin drop down .
	@FindBy(xpath="//*[@id='admin_system_menu']")
	private WebElement systemLinkInAdminDropDown;
	
	//User Drop down menu in Jira's landing page.
	@FindBy(id="header-details-user-fullname")
	private WebElement userDropDownMenu;
	
	//Project drop down link webelement present in Jira's landing page.
	@FindBy(id="browse_link")
	private WebElement projectDropdownLink;
	
	// Xpath for the current project in jira.
	@FindBy(xpath="//a[@id='admin_main_proj_link_lnk']")
	private WebElement currentProjectXpath;
	
	// Xpath for view all projects link
	@FindBy(xpath="//a[@id='project_view_all_link_lnk']")
	private WebElement xpathForViewAllProjectsLink;
		
	// Xpath for header of the project after selecting the project.
	@FindBy(xpath="//section[@id='content']/header/div/div[@class='aui-page-header-main project-details']/h1")
	private WebElement headerOfTheProject;
	
	//Create Issue link webelement in Jira's Landing Page.
	@FindBy(id="create_link")
	private WebElement createIssueLink;
	
	// By clicking on user drop down menu Logout link webelement in Jira's landing page.
	@FindBy(id="log_out")
	private WebElement logoutLink;
	
	
	
	
	//profile in user drop down menu in Jira's landing page.
	@FindBy(id="view_profile")
	private WebElement profileLinkInUserDropDownMenu;
	
	
	

	
		
	
			
	//Tests Link webelement present in Jira's landing page.
	@FindBy(id="zephyr_je.topnav.tests")
	private WebElement testsLink;
	
	//Tests Drop down Link webelement present in Jira's landing page.
	@FindBy(id="zephyr_je.topnav.tests")
	private WebElement testsDropDownLink;
/*	//Tests Drop down Link webelement present in Jira's landing page.
		@FindBy(id="zephyr_je.topnav.tests_drop")
		private WebElement testsDropDownLink;
*/	
	//Issue Link webelement present in Jira's landing page.
	@FindBy(id="find_link")
	private WebElement issueLink;
	
	//Issue drop down link webelement present in Jira's landing page.
	@FindBy(id="find_link_drop")
	private WebElement issueDropDownLink;
	
	//project link webelement present in jira's landing page.
	@FindBy(id="browse_link")
	private WebElement projectLink;
	
	
	
	//Create A Tests Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(linkText="Create a Test")
	private WebElement createTestLink;
	
	//Search Tests Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(linkText="Search Tests")
	private WebElement searchTestsLink;
	
	//Plan Test Cycle Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(linkText="Plan Test Cycle")
	private WebElement planTestCycleLink;
	
	//Execute Tests Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(linkText="Execute Tests")
	private WebElement executeTestsLink;
	
	//Test Metrics Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(linkText="Test Metrics")
	private WebElement testMetricsLink;
	
	//Welcome Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(linkText="Welcome")
	private WebElement welcomeLink;
		
	//Zephyr Help Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(linkText="Zephyr Help")
	private WebElement zephyrHelpLink;
		
	//About Zephyr Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(linkText="About Zephyr")
	private WebElement aboutZephyrLink;
	
	//ZFJ Test summary Link Present under Test DropDown in jira's landing page.
	@FindBy(linkText="Test Summary")
	private WebElement testSummaryLink;

	//
	@FindBy(xpath="//a[contains(text(),'Log in again.')]")
	private WebElement logInAgain;
	
	// Quick search textbox present in jira landing page.
	@FindBy(id="quickSearchInput")
	private WebElement quickSearchTextBox;
	
	//ZFJ Search Test Execution link Present under Test DropDown in jira's landing page.
	@FindBy(linkText="Search Test Executions")
	private WebElement searchTestExecutionLink;
	
	//ZFJ Manage Execution Filters link Present under Test DropDown in jira's landing page.
	@FindBy(linkText="Manage Execution Filters")
	private WebElement manageExecutionFiltersLink;
	
	//New Features pop dialog's header.
	@FindBy(xpath="//*[@id='whats-new-dialog']/div/h2")
	private WebElement newFeaturePopUp;
	
	//don't show again checkbox.
	@FindBy(id="dont-show-whats-new")
	private WebElement dontShowChckbox;
	
	
	//close New Features popup.
	@FindBy(xpath="//a[text()='Close']")
	private WebElement closePopUp;
	/*// Xpath for the current project in jira.
	@FindBy(xpath="//div[@id='browse_link_drop_drop']/div/h5[text()='Current Project']/following-sibling::ul[@id='project_current']/li/a")
	private WebElement currentProjectXpath;
	
	// Xpath for view all projects link
	@FindBy(xpath="//a[@id='project_view_all_link_lnk']")
	private WebElement xpathForViewAllProjectsLink;
		
	// Xpath for header of the project after selecting the project.
	@FindBy(xpath="//section[@id='content']/header/div[@class='project-details']/h1")
	private WebElement headerOfTheProject;
		*/
	
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to logout from jira and it will show the login page again. This method is implemented inside jira landing page.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean logout(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			userDropDownMenu.click();
			CommonUtil.visibilityOfElementLocated("//div[@id='user-options-content']");
			logger.info("Now Activated User drop down menu successfully.");
			//CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logoutLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			LoginPage.getInstance().loginAgain();
			logger.info("Logout from Jira successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * This method is used to validate the tests drop down menu all i.e. all links are present or not in Jira landing page. 
	 * @return The boolean value i.e. True or False.
	 */
	/*public boolean validateTestsDropdownMenu(){
		try{
			logger.info("ZFJ Test Menus are as follows...");
			String testDropDownLink="//*[@id='"+getZephyrTestLink()+"']";
			CommonUtil.scrollPage(CommonUtil.changeToWebElement(testDropDownLink));
			CommonUtil.changeToWebElement(testDropDownLink).click();
			logger.info("Test drop down clicked successfully.");
			//testsDropDownLink.click();
			CommonUtil.visibilityOfElementLocated("//*[@id='zephyr_je.topnav.tests-content']");
			List<WebElement> totalMenuItems=CommonUtil.getWebElements("//*[@id='zephyr_je.topnav.tests-content']/descendant::li");
			for(int i=0;i<totalMenuItems.size();i++){
				logger.info(totalMenuItems.get(i).getText());
			}
			Assert.assertTrue(createTestLink.getText().equals("Create a Test"), "Create a test link is not present in testdropdown link.");
			logger.info("Create a test link present inside test drop down menu.");
			
			Assert.assertTrue(searchTestsLink.getText().equals("Search Tests"), "Search Tests link is not present in testdropdown link.");
			logger.info("Search Tests link present inside test drop down menu.");
			
			Assert.assertTrue(planTestCycleLink.getText().equals("Plan Test Cycle"), "Plan Test Cycle link is not present in testdropdown link.");
			logger.info("Plan Test Cycle link present inside test drop down menu.");
			
			Assert.assertTrue(executeTestsLink.getText().equals("Execute Tests"), "Execute Tests link is not present in testdropdown link.");
			logger.info("Execute Tests link present inside test drop down menu.");
			
			Assert.assertTrue(testMetricsLink.getText().equals("Test Metrics"), "Test Metrics link is not present in testdropdown link.");
			logger.info("Test Metrics link present inside test drop down menu.");
			
			Assert.assertTrue(welcomeLink.getText().equals("Welcome"), "Welcome link is not present in testdropdown link.");
			logger.info("Welcome link present inside test drop down menu.");
			
			Assert.assertTrue(zephyrHelpLink.getText().equals("Zephyr Help"), "Zephyr Help link is not present in testdropdown link.");
			logger.info("Zephyr Help link present inside test drop down menu.");
			
			Assert.assertTrue(aboutZephyrLink.getText().equals("About Zephyr"), "About Zephyr link is not present in testdropdown link.");
			logger.info("About Zephyr link present inside test drop down menu.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
		/**
		 * navigate to create issue page from jira's landing Page.
		 * @return instance of CreateIssuePage.
		 */
		public CreateIssuePage navigateToCreateIssuePage(){
			try{
				createIssueLink.click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				logger.info("Activated Create Issue Page to create a issue.");
			}catch(Exception e){
				e.printStackTrace();
			}
			return CreateIssuePage.getInstance();
		}
		
	public String getZephyrTestLink(){
		try{
			String testLink = CommonUtil.getAttributeValue("//a[text()='Tests']", "id"); 
			return testLink;
		}catch(Exception e){
			return null;
		}
	}

		
	public boolean selectProject(String projectName){
		try{
			//Assert.assertTrue(CommonUtil.titleContains("System Dashboard", Constants.EXPLICIT_WAIT_LOW),"Not Navigated to Jira Landing page.");
			logger.info("Validated successfully Jira Landing Page.");
			projectDropdownLink.click();
			//CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.visibilityOfElementLocated("//div[@id='browse_link-content']");
			//CommonUtil.getAttributeValue("//div[@id='browse_link-content']", "aria-hidden")
			//System.out.println(CommonUtil.isElementDisplayed(CommonUtil.returnWebElement("//a[@id='admin_main_proj_link_lnk']")));
			//System.out.println(CommonUtil.isElementEnabled(CommonUtil.returnWebElement("//a[@id='admin_main_proj_link_lnk']")));
			if(CommonUtil.isElementPresent("//a[@id='admin_main_proj_link_lnk']")){
				logger.info("Current Project : "+currentProjectXpath.getText());
				if(currentProjectXpath.getText().contains(projectName)){
					logger.info(projectName + " is already selected.");
					projectDropdownLink.click();
					//Assert.assertTrue(CommonUtil.getAttributeValue("//div[@id='browse_link-content']", "aria-hidden").equals(false), "Project dropdown is closed successfully.");
				
				} else {
					xpathForViewAllProjectsLink.click();
					Assert.assertTrue(BrowseProjectPage.getInstance().selectProject(projectName), "Project is not selected from browse project page.");
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
					Assert.assertEquals(headerOfTheProject.getText(), projectName, projectName + " is not selected successfully from the project list.");
					logger.info(projectName + " is selected successfully from the project list.");
					
					projectDropdownLink.click();
					CommonUtil.visibilityOfElementLocated("//div[@id='browse_link-content']");
					Assert.assertTrue(CommonUtil.getAttributeValue("//div[@id='browse_link-content']", "aria-hidden").equals(true), "Project dropdown is selected successfully.");
					Assert.assertTrue(currentProjectXpath.getText().contains(projectName), projectName + " is not same in current project drop down list.");
					projectDropdownLink.click();
					System.out.println(CommonUtil.getAttributeValue("//div[@id='browse_link-content']", "aria-hidden"));
					//Assert.assertTrue(CommonUtil.getAttributeValue("//div[@id='browse_link-content']", "aria-hidden").equals(false), "Project dropdown is closed successfully.");
				}
				
				//CommonUtil.actionClass().sendKeys(Keys.ESCAPE).perform();
			} else {
				xpathForViewAllProjectsLink.click();
				Assert.assertTrue(BrowseProjectPage.getInstance().selectProject(projectName), "Project is not selected from browse project page.");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				Assert.assertEquals(headerOfTheProject.getText(), projectName, projectName + " is not selected successfully from the project list.");
				logger.info(projectName + " is slected successfully from the project list.");
				
				projectDropdownLink.click();
				CommonUtil.visibilityOfElementLocated("//div[@id='browse_link-content']");
				//System.out.println(currentProjectXpath.getText());
				Assert.assertTrue(currentProjectXpath.getText().contains(projectName), projectName + " is not same in current project drop down list.");
				projectDropdownLink.click();
			}
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info(projectName+" is selected successfully.");
			
		}catch(Exception e){
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean createProject(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			projectDropdownLink.click();
			CommonUtil.visibilityOfElementLocated("//div[@id='browse_link_drop_drop']");
			xpathForViewAllProjectsLink.click();
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean checkAndCloseNewFeatureDialog(){
		try{
			
			if(CommonUtil.isElementDisplayed(newFeaturePopUp)){
				dontShowChckbox.click();
				closePopUp.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * This method will navigate to Addons page i.e. First it will click on admin drop down and the click on addons link. 
	 * @return The boolean value i.e. true or false.
	 */
	public JiraAdminAddonsPage navigateToAddonsPage(String userName, String password){
		try{
			administrationDropDownLink.click();
			CommonUtil.visibilityOfElementLocated("//*[@id='system-admin-menu-content']");
			logger.info("Now Activated Admin drop down menu successfully.");
			AddonsLinkInAdminDropDown.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			if ( CommonUtil.getTitle().contains("Administrator Access") ) {
				Assert.assertTrue( JiraAdministrationAuthenticatePage.getInstance().authenticateAdminPassword(userName, password), "Jira Administrator is not authenticate successsfully." );
				logger.info("Administrator is authenticate successfully.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return JiraAdminAddonsPage.getInstance();
	}
	public JiraAdminSystemPage navigateToSystemPage(String userName, String password){
		try{
			administrationDropDownLink.click();
			CommonUtil.visibilityOfElementLocated("//*[@id='system-admin-menu-content']");
			logger.info("Now Activated Admin drop down menu successfully.");
			systemLinkInAdminDropDown.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			if ( CommonUtil.getTitle().contains("Administrator Access") ) {
				Assert.assertTrue( JiraAdministrationAuthenticatePage.getInstance().authenticateAdminPassword(userName, password), "Jira Administrator is not authenticate successsfully." );
				logger.info("Administrator is authenticate successfully.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return JiraAdminSystemPage.getInstance();
	}
	public boolean navigateToAdministrationPage(String username, String password){
		try{
			administrationDropDownLink.click();
			CommonUtil.visibilityOfElementLocated("//*[@id='system-admin-menu-content']");
			logger.info("Now Activated Admin drop down menu successfully.");
			AddonsLinkInAdminDropDown.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			if ( CommonUtil.getTitle().contains("Administrator Access") ) {
				Assert.assertTrue( JiraAdministrationAuthenticatePage.getInstance().authenticateAdminPassword(username, password), "Jira Administrator is not authenticate successsfully." );
				logger.info("Administrator is authenticate successfully.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteProject(String projectName, String userName, String password){
		try{
			//Assert.assertTrue(CommonUtil.titleContains("System Dashboard", Constants.EXPLICIT_WAIT_LOW),"Not Navigated to Jira Landing page.");
			//logger.info("Validated successfully Jira Landing Page.");
			
			Assert.assertTrue(navigateToProjectPage(userName, password), "Not Navigated to Addons page");
			
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(BrowseProjectPage.getInstance().deleteProject(projectName, userName, password), "Project is not Deleted from browse project page.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info(projectName+" is deleted successfully.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean navigateToProjectPage(String userName, String password){
		try{
			administrationDropDownLink.click();
			CommonUtil.visibilityOfElementLocated("//*[@id='system-admin-menu-content']");
			logger.info("Now Activated Admin drop down menu successfully.");
			CommonUtil.navigateThroughXpath(".//*[@id='admin_project_menu']");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			if ( CommonUtil.getTitle().contains("Administrator Access") ) {
				Assert.assertTrue( JiraAdministrationAuthenticatePage.getInstance().authenticateAdminPassword(userName, password), "Jira Administrator is not authenticate successsfully." );
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				logger.info("Administrator is authenticate successfully.");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
