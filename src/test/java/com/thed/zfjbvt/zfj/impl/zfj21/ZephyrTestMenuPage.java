package com.thed.zfjbvt.zfj.impl.zfj21;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj21.AboutZfjPage;
import com.thed.zfjbvt.zfj.impl.zfj21.CreateTestPage;
import com.thed.zfjbvt.zfj.impl.zfj21.PlanTestCyclePage;
import com.thed.zfjbvt.zfj.impl.zfj21.SearchTestsPage;
import com.thed.zfjbvt.zfj.impl.zfj21.TestMetricsPage;
import com.thed.zfjbvt.zfj.impl.zfj21.TestSummaryPage;
import com.thed.zfjbvt.zfj.impl.zfj21.ViewTestPage;
import com.thed.zfjbvt.zfj.impl.zfj21.ZfjHelpPage;
import com.thed.zfjbvt.zfj.impl.zfj21.ZfjWelcomePage;

public class ZephyrTestMenuPage {

	private static String testDropDownLink;
	
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
	//Tests Drop down Link webelement present in Jira's landing page.
	@FindBy(id="zephyr_je.topnav.tests_drop")
	private WebElement testsDropDownLink;
		
	//Create Issue link webelement in Jira's Landing Page.
	@FindBy(id="create_link")
	private WebElement createIssueLink;
	
	//Create A Tests Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(id="zephyr-je.topnav.tests.create_lnk")
	private WebElement createTestLink;
		
	//Search Tests Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(id="zephyr-je.topnav.tests.test.search_lnk")
	private WebElement searchTestsLink;
		
	//Plan Test Cycle Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(id="zephyr-je.topnav.tests.plan.cycle_lnk")
	private WebElement planTestCycleLink;
		
	//Execute Tests Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(id="zephyr-je.topnav.tests.plan.execute_lnk")
	private WebElement executeTestsLink;
		
	//Test Metrics Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(id="zephyr-je.topnav.tests.test.plan.metrics_lnk")
	private WebElement testMetricsLink;
		
	//Welcome Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(id="zfj_welcome_lnk")
	private WebElement welcomeLink;
			
	//Zephyr Help Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(id="zephyr-je.topnav.tests.help_lnk")
	private WebElement zephyrHelpLink;
			
	//About Zephyr Link webelement Present under Tests DropDown in Jira's landing page.
	@FindBy(id="add-about_lnk")
	private WebElement aboutZephyrLink;
		
	//ZFJ Test summary Link Present under Test DropDown in jira's landing page.
	@FindBy(id="zephyr-je.topnav.tests.test.plan.summary_lnk")
	private WebElement testSummaryLink;

	// Quick search textbox present in jira landing page.
	@FindBy(id="quickSearchInput")
	private WebElement quickSearchTextBox;
		
	//ZFJ Search Test Execution link Present under Test DropDown in jira's landing page.
	@FindBy(id="zephyr-je.topnav.tests.execution.search_lnk")
	private WebElement searchTestExecutionLink;
		
	//ZFJ Manage Execution Filters link Present under Test DropDown in jira's landing page.
	@FindBy(id="manage_zql_filters_link_lnk")
	private WebElement manageExecutionFiltersLink;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	public SearchTestsPage navigateToSearchTestsPage(){
		try{
			testsDropDownLink.click();
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
			testsDropDownLink.click();
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
			testsDropDownLink.click();
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
			testsDropDownLink.click();
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
			testsDropDownLink.click();
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
			testsDropDownLink.click();
			manageExecutionFiltersLink.click();
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
			testsDropDownLink.click();
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
			testsDropDownLink.click();
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
			testsDropDownLink.click();
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
			testsDropDownLink.click();
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
				testsDropDownLink.click();
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
		
		
//		public CreateIssuePage navigateToCreateIssuePage(){
//			try{
//				createIssueLink.click();
//				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
//			}catch(Exception e){
//				e.printStackTrace();
//				
//			}
//			return CreateIssuePage.getInstance();
//		}
		
	
	

	
	

}
