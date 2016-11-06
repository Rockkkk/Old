package com.thed.zfjbvt.zfj.impl.zfj173;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;


public class ZephyrTestMenuPage {
private static String testDropDownLink;
	
	public static void setTestdropdownlink(String id) {
		testDropDownLink=id;
	}
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the Zephyr Test Menu page and returns the page instance.
	 * @param string 
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
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			searchTestsLink.click();
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
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
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
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			createTestLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to ZFJ Create Test Page.");
		}catch(Exception e){
			e.printStackTrace();
		}
		return CreateTestPage.getInstance();
	}
	
	
	/**
	 * This method navigates to test matrices page from jira's Landing Page.
	 * @return instance of TestMetricsPage.
	 */
	public TestMetricsPage navigateToTestMatricsPage(){
		try{
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			testMetricsLink.click();
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
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			welcomeLink.click();
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
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			zephyrHelpLink.click();
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
			CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
			aboutZephyrLink.click();
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
				CommonUtil.changeToWebElement("//a[@id='"+testDropDownLink+"']").click();
				try{
					if(testSummaryLink.isDisplayed()){
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
		
		
	
	

	
	

}
