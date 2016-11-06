package com.thed.zfjbvt.zfj.impl.zfj25;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.jira.JiraNavigatorFactory;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj25.AboutZfjPage;
import com.thed.zfjbvt.zfj.impl.zfj25.CreateTestPage;
import com.thed.zfjbvt.zfj.impl.zfj25.PlanTestCyclePage;
import com.thed.zfjbvt.zfj.impl.zfj25.SearchTestsPage;
import com.thed.zfjbvt.zfj.impl.zfj25.TestMetricsPage;
import com.thed.zfjbvt.zfj.impl.zfj25.TestSummaryPage;
import com.thed.zfjbvt.zfj.impl.zfj25.ViewTestPage;
import com.thed.zfjbvt.zfj.impl.zfj25.ZfjHelpPage;
import com.thed.zfjbvt.zfj.impl.zfj25.ZfjWelcomePage;

public class ZephyrTestMenuPage {
	private static String testDropDownLink = null;
	
	public static void setTestdropdownlink(String id) {
		testDropDownLink=id;
	}
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the Zephyr Test Menu page and returns the page instance.
	 * @return This returns the Zephyr Test Menu Page instance.
	 */
	public static ZephyrTestMenuPage getInstance(String testLinkId) {
		setTestdropdownlink(testLinkId);
		ZephyrTestMenuPage page = PageFactory.initElements(Driver.driver, ZephyrTestMenuPage.class);
		return page ;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/	
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

	// Quick search textbox present in jira landing page.
	@FindBy(id="quickSearchInput")
	private WebElement quickSearchTextBox;
		
	//ZFJ Search Test Execution link Present under Test DropDown in jira's landing page.
	@FindBy(linkText="Search Test Executions")
	private WebElement searchTestExecutionLink;
		
	//ZFJ Manage Execution Filters link Present under Test DropDown in jira's landing page.
	@FindBy(linkText="Manage Execution Filters")
	private WebElement manageExecutionFiltersLink;
		
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	public SearchTestsPage navigateToSearchTestsPage(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			for(int i=0;i<2;i++){
				CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				if(searchTestsLink.isDisplayed()){
					searchTestsLink.click();
					break;
				}
				
			}
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to Search Tests page.");
		}catch(Exception e){
			e.printStackTrace();
		}
		return SearchTestsPage.getInstance();
	}
	/**
	 * This method is used to navigate to plan test cycle page from Jira landing page. 
	 * @return Returns a instance of Plan Test Cycle Page.
	 * @throws Exception 
	 */
	public PlanTestCyclePage navigateToPlanTestCyclePage() throws Exception{
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			planTestCycleLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to Plan Test Cycle page.");
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		
		return PlanTestCyclePage.getInstance();
	}
	/**
	 * This method is used to navigate to Execute tests page from Jira landing page. 
	 * @return Returns a instance of Plan Test Cycle Page.
	 */
	public PlanTestCyclePage navigateToExecuteTestsPage(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			executeTestsLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to Execute Tests page.");
		}catch(Exception e){
			e.printStackTrace();
		}
		return PlanTestCyclePage.getInstance();
	}
	
	public ViewTestPage quickSearchByID(String testToSearch){
		try{
			quickSearchTextBox.sendKeys(testToSearch, Keys.ENTER);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Searched successfully by ID.");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ViewTestPage.getInstance();
	}
	
	public CreateTestPage navigateToCreateTestPage(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			createTestLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to ZFJ Create Test Page.");
		}catch(Exception e){
			e.printStackTrace();
		}
		return CreateTestPage.getInstance();
	}
		public SearchTestExecutionsPage navigateToSearchTestExecutionsPage(){
		try{
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			searchTestExecutionLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to Search Test Execution Page.");
		}catch(Exception e){
			e.printStackTrace();
		}
		return SearchTestExecutionsPage.getInstance();
	}
	
	public ManageExecutionFiltersPage navigateToManageExecutionFiltersPage(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			manageExecutionFiltersLink.click();
			logger.info("Navigated to Manage Execution Filters Page.");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ManageExecutionFiltersPage.getInstance();
	}
	
	
	
	/**
	 * This method navigates to test matrices page from jira's Landing Page.
	 * @return instance of TestMetricsPage.
	 */
	public TestMetricsPage navigateToTestMatricsPage(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			testMetricsLink.click();
			logger.info("Navigated to Test Metrics Page.");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
		return TestMetricsPage.getInstance();
	}
	
	/**
	 * This method navigates to ZFJ Welcome page from jira's Landing Page.
	 * @return instance of ZfjWelcomePage.
	 */
	public ZfjWelcomePage navigateToZfjWelcomePage(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			welcomeLink.click();
			logger.info("Navigated Zephyr Welcome Page.");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ZfjWelcomePage.getInstance();
	}
	
	/**
	 * This method navigates to ZFJ Help Page from jira's Landing Page.
	 * @return instance of ZfjHelpPage.
	 */
	public ZfjHelpPage navigateToZfjHelpPage(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			zephyrHelpLink.click();
			logger.info("Navigated to Zephyr Help Page.");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ZfjHelpPage.getInstance();
	}
	
	/**
	 * This method navigates to About  ZFJ page from jira's Landing Page.
	 * @return instance of AboutZfjPage.
	 */
	public AboutZfjPage navigateToAboutZfjPage(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			aboutZephyrLink.click();
			logger.info("Navigated to About Zephyr Page.");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
		return AboutZfjPage.getInstance();
	}

	/**
	 * This method navigates to ZFJ Test Summary page from jira's Landing Page.
	 * @return instance of TestSummaryPage.
	 */
	public TestSummaryPage navigateToTestSummaryPage(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			try{
				if(CommonUtil.isElementPresent(testSummaryLink)){
					logger.info("Navigated to Test Summary Page.");
					testSummaryLink.click();
				}
			}catch(Exception e){
				planTestCycleLink.click();
				PlanTestCyclePage.getInstance().navigateToTestSummaryPage();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return TestSummaryPage.getInstance();
	}
	public boolean validateTestsDropdownMenu(){
		try{
			//JiraNavigatorFactory.getInstance().selectProject(Config.getValue("JIRA_PROJECT"));
			//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			//logger.info("ZFJ Test Menus are as follows...");
			String testDropDownxpath="//*[@id='"+testDropDownLink+"']";
			CommonUtil.scrollPage(CommonUtil.changeToWebElement(testDropDownxpath));
			CommonUtil.changeToWebElement(testDropDownxpath).click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			logger.info("Test drop down clicked successfully.");
			//testsDropDownLink.click();
			/*CommonUtil.visibilityOfElementLocated("//*[@id='zephyr_je.topnav.tests-content']");
			List<WebElement> totalMenuItems=CommonUtil.getWebElements("//*[@id='zephyr_je.topnav.tests-content']/descendant::li");
			for(int i=0;i<totalMenuItems.size();i++){
				logger.info(totalMenuItems.get(i).getText());
			}*/
			Assert.assertTrue(createTestLink.getText().contains("Create a Test"), "Create a test link is not present in testdropdown link.");
			logger.info("Create a test link present inside test drop down menu.");
			
			Assert.assertTrue(searchTestsLink.getText().contains("Search Tests"), "Search Tests link is not present in testdropdown link.");
			logger.info("Search Tests link present inside test drop down menu.");
			
			Assert.assertTrue(planTestCycleLink.getText().contains("Plan Test Cycle"), "Plan Test Cycle link is not present in testdropdown link.");
			logger.info("Plan Test Cycle link present inside test drop down menu.");
			
			Assert.assertTrue(executeTestsLink.getText().contains("Execute Tests"), "Execute Tests link is not present in testdropdown link.");
			logger.info("Execute Tests link present inside test drop down menu.");
			
			Assert.assertTrue(testMetricsLink.getText().contains("Test Metrics"), "Test Metrics link is not present in testdropdown link.");
			logger.info("Test Metrics link present inside test drop down menu.");
			
			Assert.assertTrue(welcomeLink.getText().contains("Welcome"), "Welcome link is not present in testdropdown link.");
			logger.info("Welcome link present inside test drop down menu.");
			
			Assert.assertTrue(zephyrHelpLink.getText().contains("Zephyr Help"), "Zephyr Help link is not present in testdropdown link.");
			logger.info("Zephyr Help link present inside test drop down menu.");
			
			Assert.assertTrue(aboutZephyrLink.getText().contains("About Zephyr"), "About Zephyr link is not present in testdropdown link.");
			logger.info("About Zephyr link present inside test drop down menu.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement(testDropDownxpath).click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
