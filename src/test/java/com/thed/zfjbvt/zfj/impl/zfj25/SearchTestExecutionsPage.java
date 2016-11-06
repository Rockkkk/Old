package com.thed.zfjbvt.zfj.impl.zfj25;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class SearchTestExecutionsPage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static SearchTestExecutionsPage getInstance() {
		SearchTestExecutionsPage page = PageFactory.initElements(Driver.driver, SearchTestExecutionsPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//id for  ZQL search text area.
	@FindBy(id="zqltext")
	private WebElement zqlSearchTextbox;
	
	//id for ZQL search button.
	@FindBy(id="zephyr-transform-all")
	private WebElement zqlSubmitBtn;
	
	//xpath for search heading in search test execution page.
	@FindBy(xpath="//*[@id='search-header-view']/div/h1")
	private WebElement searchHeader;
	
	//class name for header Search test execution page.
	@FindBy(className="filter-title")
	private WebElement searchTestExecutionHeader;
	
	//class name for predefined filters.
	@FindBy(className="filter-panel-section")
	private WebElement predefinedFilters; 
	
	//xpath of the total number of predefined filters.
	@FindBy(xpath="//*[text()='Predefined Filters']/following-sibling::ul[@id='predefinedFilters']/li/a")
	private List<WebElement> totalPredefinedFilters;
	
	//xpath of My Executed Test in predefined filter.
	@FindBy(linkText="My Executed Tests")
	private WebElement myExecutedTests;
	
	//xpath of My Failed Executions in predefined filter.
	@FindBy(linkText="My Failed Executions")
	private WebElement myFailedExecutions;
	
	//xpath of All Unexecuted Tests in predefined filter.
	@FindBy(linkText="All Unexecuted Tests")
	private WebElement allUnexecutedTests;
	
	//xpath of All Executed Tests in predefined filter.
	@FindBy(linkText="All Executed Tests")
	private WebElement allExecutedTests;
	
	//xpath of All Failed Executions in predefined filter.
	@FindBy(linkText="All Failed Executions")
	private WebElement allFailedExecutions;
	
	//xpath of checkboxes that can be selected for bulk execution.
	@FindBy(xpath="//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr/td[1]/input[@type='checkbox']")
	private WebElement selectTestChckboxes;
	//xpath to get the total Test Executed.
	@FindBy(xpath="//*[@id='displayDetailId']/div/div/span/span[3]")
	private WebElement totalTestExecuted;
	
	//xpath of Tools to do bulk operations.
	@FindBy(xpath="//span[text()='Tools']")
	private WebElement xpathOfTool;
	
	//id to validate the total number of Test selected.
	@FindBy(id="countCheckId")
	private WebElement totalTestSelected;
	
	//xpath of bulk change options.
	@FindBy(xpath="//*[@id='jira']/div[4]")
	private WebElement bulkChangeOptions;
	
	//id of status link in bulk change options.
	@FindBy(id="zfj-bulkstatuschange-id")
	private WebElement statusLink;
	
	//id of move to cycle link in bulk change options.
	@FindBy(id="zfj-bulkmovecycle-id")
	private WebElement moveToCycleLink;
	
	//id of copy cycle link in bulk change options.
	@FindBy(id="zfj-bulkcopycycle-id")
	private WebElement copyToCycleLink;
	
	//id of associate defect link in bulk change options.
	@FindBy(id="zfj-bulkassociatedefect-id")
	private WebElement associateDefectLink;
	
	//id of delete link in bulk change options.
	@FindBy(id="zfj-bulkdelete-id")
	private WebElement deleteLink;
	
	// Xpath for total number of tests
	@FindBy(xpath="//div[@id='displayDetailId']/div/div/span/span[@class='results-count-total results-count-link']")
	private WebElement xpathForTotalTests;
	
	// xpath for fixedversion column in issue table.
	@FindBy(xpath="//table[@id='issuetable']/tbody/tr/td[8]/a")
	private List<WebElement> xpathForFixedVersionColumn;
	
	// xpath for component column in issue table.
	@FindBy(xpath="//table[@id='issuetable']/tbody/tr/td[7]/a")
	private List<WebElement> xpathForComponentColumn;
	
	//
	@FindBy(id="zephyr-zql-save-filter")
	private WebElement saveAsZQLFilter;
	
	//
	@FindBy(id="filterName")
	private WebElement saveAsFilterName;
	
	//
	@FindBy(id="filterDescription")
	private WebElement saveAsFilterDescription;
	
	//
	@FindBy(id="isFavFilter")
	private WebElement favouriteCheckbox;
	
	//
	@FindBy(id="bulk-update-status-form-submit")
	private WebElement saveAsFilterSaveBtn;
	
	
	// xpath for all the list of filters present inside the favourite filters.
	@FindBy(xpath="//div[*[text()='Favourite Filters']]/following-sibling::ul[@id='executionFilterId']/li/a")
	private List<WebElement> favouriteFilters;
	
	// Search execution filter text box for searching the filters in favourite filters.
	@FindBy(id="searchZQLFilterName-field")
	private WebElement searchExecFilterTextBox;
	
	// Search execution filter execute button.
	@FindBy(xpath="//*[text()='Search Execution Filter']/following-sibling::div/div/a")
	private WebElement searchExecFilterExecuteBtn;
	
	// Select all tests check box in isssue table.
	@FindBy(id="selectAllID")
	private WebElement selectAllTestsCheckBoxFromIssueTable;
	
	// Xpath for export drop down menu for exporting executions.
	@FindBy(xpath="//span[text()='Export']")
	private WebElement exportDropDownmenu;
	
	// id for excel link for exporting file in excel format.
	@FindBy(id="xlsExecutionId")
	private WebElement excelLinkIdForExport;
	
	// All webelements xpath for all tests present in issue table. 
	@FindBy(xpath="//table[@id='issuetable']/tbody/tr/td[1]/input[@type='checkbox']")
	private List<WebElement> xpathForAllCheckBoxInIssueTableTest;
	
	// test execution delete Link
	@FindBy(id="zfj-bulkdelete-id")
	private WebElement deleteLinkForTestExec;
	
	// Delete button for conformation after clicking on delete link.
	@FindBy(id="execution-delete-form-submit")
	private WebElement confirmationDeleteButton;
	
	// header of warning popup.
	@FindBy(xpath="//div[@id='warning-message-dialog']/h2")
	private WebElement warningMsgDialogBox;
	
	// close link of warning popup.
	@FindBy(id="aui-dialog-close")
	private WebElement warningCloseLink;
	
	// refresh result link
	@FindBy(xpath="//div[@id='displayDetailId']/div/div/span/a[@id='refreshZQLId']")
	private WebElement xpathForRefreshLink;
	
	// Login Name xpath for taking the name and attribute.
	@FindBy(xpath="//a[@id='header-details-user-fullname']")
	private WebElement xpathForUserName;
	
	// All Current execution status xpath
	@FindBy(xpath="//table[@id='issuetable']/tbody/tr/td/div/dl/dd[contains(@id,'current-execution-status-dd-schedule-')]")
	private List<WebElement> allCurrentExecStatus;
	
	// xpath for all issue table header part.
	@FindBy(xpath="//table[@id='issuetable']/thead/tr/th")
	private List<WebElement> xpathForIssueTableHeaders;
		
	//list of test ids in search test execution page.
	@FindBy(xpath="//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr/td[3]/a")
	private List<WebElement> listOfTest;
	
	//list of cycles in search test execution page.
	@FindBy(xpath="//table[thead[tr[th[@id='headerrow-id-exec-status']]]]/tbody/tr/td[2]/a")
	private List<WebElement> listOfCycles;
	
	@FindBy(xpath="//table[@id='issuetable']/thead/tr/th")
	private List<WebElement> allHeadersOfIssueTable;
	
	@FindBy(xpath="//*[@class='no-results-message']")
	private WebElement xpathForNoResultMsg;
	
	//Layout switch button where you can switch from one view to anather.
    @FindBy ( xpath = "//*[@id='layout-switcher-button']" )
    private WebElement layoutSwitchBtn;

	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	public boolean validateSearchTestExecutionPage(){
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
			String title=CommonUtil.getTitle();
			Assert.assertTrue(title.contains("Execution Navigator"),"Validating SearchTestExecutionPage Failed...");
			String header=searchTestExecutionHeader.getText();
			Assert.assertTrue((zqlSearchTextbox.isDisplayed())&&(zqlSubmitBtn.isDisplayed()&&(header.equals("FILTERS"))));
			Assert.assertTrue(predefinedFilters.isDisplayed(),"PreDefiend Filters Validation Failed...");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean changeBulkTestStatus(String status, int totalTest){
		try{
			status= status.toUpperCase();
			//selectAndValidatePredefinedFilters("My Executed Tests");
			myExecutedTests.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(totalTest<=(Integer.parseInt(totalTestExecuted.getText())),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> tests = getIdsOfTestSelected(totalTest);
			getStatusOfTestSelected(tests); 
			navigateToBulkChangeStatusPage().validateBulkChangeStatusPage();
			BulkChangeStatusPage.getInstance().changeStatus(status);
			refreshPage();
			Assert.assertTrue(validateIdsOfTestsSelected(tests), "Same Test not selected...");
			Assert.assertTrue(validateStatusChange(status,tests), "Status Validation Failed...");
			logger.info("Bulk Stauts Changed Successfully...");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean changeBulkTeststepStatus(String testStatus, String teststepStatus, int totalTest){
		try{
			testStatus= testStatus.toUpperCase();
			teststepStatus= teststepStatus.toUpperCase();
			//selectAndValidatePredefinedFilters("All Unexecuted Tests");
			allUnexecutedTests.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> tests= getIdsOfTestSelected(totalTest);
			navigateToBulkChangeStatusPage().validateBulkChangeStatusPage();
			BulkChangeStatusPage.getInstance().changeTeststepStatus(testStatus, teststepStatus);
			validateTeststepStatusChange(testStatus, teststepStatus, totalTest,tests);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateTeststepStatusChange(String testStatus, String teststepStatus, int totalTest,List<String> tests){
		
		try{
			String zqlQuery = createZqlQueryForIssues(tests);
			executeZQLQuery(zqlQuery);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			//selectAndValidatePredefinedFilters("All Executed Tests");
			//allExecutedTests.click();
			//refreshPage();
			validateIdsOfTestsSelected(tests);
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			validateStatusChange(testStatus,tests);
			navigateToExecuteTest();
			validateTeststepChange(teststepStatus,totalTest);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateTeststepChange(String teststepStatus, int totalTest){
		try{
			for(int i=1; i<=totalTest;i++){
				//allExecutedTests.click();
				//CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]//a[@title='Execute Test']").click();
				Assert.assertTrue(ExecuteTestsPage.getInstance().validateTestStepStatus(teststepStatus),"Validating teststep status change Failed...");
				if(i < totalTest){
					ExecuteTestsPage.getInstance().navigateToNextExecution();
				}
				
			}
			ExecuteTestsPage.getInstance().returnToSearchTestExecutions();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean bulkAssociateDefect(String bugId,int totalTest){
		String issueId;
		try{
			//selectAndValidatePredefinedFilters("All Executed Tests");
			allExecutedTests.click();
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> tests=getIdsOfTestSelected(totalTest);
			navigateToBlukAssociateDefectPage().validateBulkAssociateDefectPage();
			issueId=BlukAssociateDefectPage.getInstance().associateDefect(bugId);
			Assert.assertNotNull(issueId, "Defect Assocition Failed...");
			Assert.assertTrue(validateIdsOfTestsSelected(tests));
			Assert.assertTrue(validateBulkAssociateDefects(issueId,tests),"Validation of Bluk Associate Defect Failed...");
			logger.info("Bulk Association of Defects validated successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean changeBulkTestStatusToUnexecutedWithDefectsCleared(int totalTest){
		try{
			String status="UNEXECUTED";
			refreshPage();
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			navigateToBulkChangeStatusPage().validateBulkChangeStatusPage();
			BulkChangeStatusPage.getInstance().clearDefect(status);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			//selectAndValidatePredefinedFilters("All Unexecuted Tests");
			navigateToExecuteTest();
			validateClearedDefect(totalTest);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean bulkMoveTestToCycle(String version, String cycle,int totalTest){
		try{
			//selectAndValidatePredefinedFilters("All Executed Tests");
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> testId=getIdsOfTestSelected(totalTest);
			getStatusOfTestSelected(testId);
			getCyclesOfTestSelected(testId);
			navigateToBulkMoveToCyclePage().validateBulkMoveToCyclePage();
			BulkMoveToCyclePage.getInstance().moveBulkTestToCycle(version, cycle);
			//selectAndValidatePredefinedFilters("All Unexecuted Tests");
			refreshPage();
			validateTestChanged(testId);
			validateCycleChange(cycle, testId);
			navigateToExecuteTest();
			validateClearedDefect(totalTest);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean bulkCopyTestToCycle(String version, String cycle,int totalTest){
		try{
			//selectAndValidatePredefinedFilters("All Executed Tests");
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> testId=getIdsOfTestSelected(totalTest);
			getStatusOfTestSelected(testId);
			getCyclesOfTestSelected(testId);
			navigateToBulkCopyToCyclePage().validateBulkCopyToCyclePage();
			BulkCopyToCyclePage.getInstance().copyBulkTestToCycle(version, cycle);
			//selectAndValidatePredefinedFilters("All Unexecuted Tests");
			refreshPage();
			validateTestChanged(testId);
			validateCycleChange(cycle, testId);
			navigateToExecuteTest();
			validateClearedDefect(totalTest);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean bulkMoveTestToCycleWithDefects(String version, String cycle,int totalTest, String issue){
		try{
			//selectAndValidatePredefinedFilters("All Executed Tests");
			//allExecutedTests.click();
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> tests=getIdsOfTestSelected(totalTest);
			getCyclesOfTestSelected(tests);
			navigateToBulkMoveToCyclePage().validateBulkMoveToCyclePage();
			BulkMoveToCyclePage.getInstance().moveBulkTestToCycleWithDefects(version, cycle);
			refreshPage();
			validateIdsOfTestsSelected(tests);
			validateCycleChange(cycle, tests);
			navigateToExecuteTest();
			for(int i = 1; i<= tests.size(); i++){
				ExecuteTestsPage.getInstance().validateDefectAdded(issue);
				if(i < tests.size()){
					ExecuteTestsPage.getInstance().navigateToNextExecution();
					
				}
				
			}
			ExecuteTestsPage.getInstance().returnToSearchTestExecutions();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean bulkCopyTestToCycleWithDefects(String version, String cycle,int totalTest){
		try{
			selectAndValidatePredefinedFilters("All Executed Tests");
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> tests=getIdsOfTestSelected(totalTest);
			getCyclesOfTestSelected(tests);
			navigateToBulkCopyToCyclePage().validateBulkCopyToCyclePage();
			BulkCopyToCyclePage.getInstance().copyBulkTestToCycleWithDefects(version, cycle);
			refreshPage();
			validateIdsOfTestsSelected(tests);
			validateCycleChange(cycle, tests);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	
	public BulkChangeStatusPage navigateToBulkChangeStatusPage(){
		try{
			clickBulkChangeTool();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			statusLink.click();
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return BulkChangeStatusPage.getInstance();
	}
	
	public BlukAssociateDefectPage navigateToBlukAssociateDefectPage(){
		try{
			clickBulkChangeTool();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			associateDefectLink.click();
		}catch(Exception e){
			e.printStackTrace();
		}
		return BlukAssociateDefectPage.getInstance();
	}
	
	public BulkMoveToCyclePage navigateToBulkMoveToCyclePage(){
		try{
			clickBulkChangeTool();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			moveToCycleLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return BulkMoveToCyclePage.getInstance();
	}
	
	public BulkCopyToCyclePage navigateToBulkCopyToCyclePage(){
		try{
			clickBulkChangeTool();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			copyToCycleLink.click();
		}catch(Exception e){
			e.printStackTrace();
		}
		return BulkCopyToCyclePage.getInstance();
	}
	
	
	public boolean validateStatusChange(String status, List<String> tests){
		try{
			
			for(int i=0;i<tests.size();i++){
				String getStatus=CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-exec-status']]]]/tbody/tr["+(i+1)+"]//td/div//dd").getText();
				Assert.assertEquals(status, getStatus,"Status Validation Failed...");
				logger.info("Status of "+tests.get(i)+ " Changed to: "+getStatus);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateBulkAssociateDefects(String issueId, List <String> tests){
		try{
			String zqlQuery = createZqlQueryForIssues(tests);
			executeZQLQuery(zqlQuery);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			navigateToExecuteTest();
			for(int i=1; i<=tests.size();i++){
				Assert.assertTrue(ExecuteTestsPage.getInstance().validateDefectAdded(issueId),"Adding of Defect to test Failed...");
				if(i < tests.size()){
					ExecuteTestsPage.getInstance().navigateToNextExecution();
				}
				
			}
			ExecuteTestsPage.getInstance().returnToSearchTestExecutions();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateClearedDefect(int totalTest){
		try{
			for(int i=1; i<=totalTest;i++){
				Assert.assertTrue(ExecuteTestsPage.getInstance().validateClearedDefects(),"Cleairng of Defect to test Failed...");
				if(i < totalTest){
					ExecuteTestsPage.getInstance().navigateToNextExecution();
				}
				
			}
			ExecuteTestsPage.getInstance().returnToSearchTestExecutions();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateCycleChange(String cycle, List<String> tests){
try{
	String zqlQuery = createZqlQueryForIssues(tests);
	zqlQuery = zqlQuery+ " AND cycleName in("+cycle+")";
	executeZQLQuery(zqlQuery);
	CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
	for(int i=0;i<tests.size();i++){
		String getCycle=getCycleOfGivenTest(tests.get(i));
		Assert.assertEquals(cycle, getCycle,"Cycle Validation Failed...");
		logger.info("test schedule "+tests.get(i)+" is moved to cycle "+cycle);
	}
	logger.info("Bulk move to Cycle "+cycle+" Successfully...");
	}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	
	public boolean selectAndValidatePredefinedFilters(String filterName){
		try{
			Assert.assertTrue(validateSearchTestExecutionPage(),"Not validated Search Test Execution Page.");
			logger.info("Search Test execution page is validated successfully.");
			Assert.assertTrue(CommonUtil.searchAndClickFromList(totalPredefinedFilters, filterName), "Predefined filter is not found.");
			logger.info("Filter found and clicked successfully.");

			//xpathForRefreshLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String loginUserName=xpathForUserName.getAttribute("data-username");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);

			if(filterName.equals("My Executed Tests")){
				Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "value"),"executionStatus != \"UNEXECUTED\" AND executedBy = "+loginUserName+"", "Not showing the result of "+filterName+".");
				logger.info(filterName+" filter results are showing.");
				//logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
				//Assert.assertFalse(CommonUtil.searchTheTextInList(allCurrentExecStatus, "UNEXECUTED"), "UNEXECUTED is found in this current execution status.");
				if(CommonUtil.isElementPresent("//*[@class='no-results-message']")){
					logger.info(xpathForNoResultMsg.getText());
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
					
				} else {
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
					logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
					Assert.assertFalse(CommonUtil.searchTheTextInList(allCurrentExecStatus, "UNEXECUTED"), "UNEXECUTED is found in this current execution status.");
				}
				
				logger.info(filterName+" is verified successfully.");
				
			}else if (filterName.equals("My Failed Executions")) {
				Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "value"),"executionStatus = \"FAIL\" AND executedBy = "+loginUserName+"", "Not showing the result of "+filterName+".");
				logger.info(filterName+" filter results are showing.");
				//logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
				//Assert.assertTrue(CommonUtil.searchTextInList(allCurrentExecStatus, "FAIL"), "FAIL is not found in this current execution status.");
				if(CommonUtil.isElementPresent("//*[@class='no-results-message']")){
					logger.info(xpathForNoResultMsg.getText());
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
					
				} else {
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
					logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
					Assert.assertTrue(searchTextInList(allCurrentExecStatus, "FAIL"), "FAIL is not found in this current execution status.");
				}
				logger.info(filterName+" is verified successfully.");
				
			}else if (filterName.equals("All Unexecuted Tests")) {
				Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "value"),"executionStatus = \"UNEXECUTED\"", "Not showing the result of "+filterName+".");
				logger.info(filterName+" filter results are showing.");
				//logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
				//Assert.assertTrue(CommonUtil.searchTextInList(allCurrentExecStatus, "UNEXECUTED"), "UNEXECUTED is not found in this current execution status.");
				if(CommonUtil.isElementPresent("//*[@class='no-results-message']")){
						logger.info(xpathForNoResultMsg.getText());
						CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
						
				} else {
						CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
						logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
						Assert.assertTrue(searchTextInList(allCurrentExecStatus, "UNEXECUTED"), "UNEXECUTED is not found in this current execution status.");
				}
				logger.info(filterName+" is verified successfully.");
				
			}else if (filterName.equals("All Executed Tests")) {
				Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "value"),"executionStatus != \"UNEXECUTED\"", "Not showing the result of "+filterName+".");
				logger.info(filterName+" filter results are showing.");
				//logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
				//Assert.assertFalse(CommonUtil.searchTheTextInList(allCurrentExecStatus, "UNEXECUTED"), "UNEXECUTED is found in this current execution status.");
				if(CommonUtil.isElementPresent("//*[@class='no-results-message']")){
						logger.info(xpathForNoResultMsg.getText());
						CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
						
				} else {
						CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
						logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
						Assert.assertFalse(CommonUtil.searchTheTextInList(allCurrentExecStatus, "UNEXECUTED"), "UNEXECUTED is found in this current execution status.");
				}
				logger.info(filterName+" is verified successfully.");
				
			}else if (filterName.equals("All Failed Executions")) {
				Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "value"),"executionStatus = \"FAIL\"", "Not showing the result of "+filterName+".");
				logger.info(filterName+" filter results are showing.");
				//logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
				//Assert.assertTrue(CommonUtil.searchTextInList(allCurrentExecStatus, "FAIL"), "FAIL is not found in this current execution status.");
				 if(CommonUtil.isElementPresent("//*[@class='no-results-message']")){
						logger.info(xpathForNoResultMsg.getText());
						CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
						
				} else {
						CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
						logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
						Assert.assertTrue(searchTextInList(allCurrentExecStatus, "FAIL"), "FAIL is not found in this current execution status.");
				}
				logger.info(filterName+" is verified successfully.");
			}
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executeZQLQueryForFixVersion(String ZQLQuery, String fixVersionName){
		try{
			Assert.assertTrue(validateSearchTestExecutionPage(),"Not validated Search Test Execution Page.");
			logger.info("Search Test executions page is validated successfully.");
			Assert.assertTrue(executeZQLQuery(ZQLQuery), "ZQL Query is not searched.");
			logger.info("ZQL Query is searched successfully.");
			/*CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			zqlSearchTextbox.clear();
			zqlSearchTextbox.sendKeys(ZQLQuery);
			zqlSubmitBtn.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			logger.info("Total Number of tests present for fixed version : "+totalTests());*/
			/*String xpathForFixedCol="//table[@id='issuetable']/tbody/tr/td["+returnHeaderNum("Version")+"]/a";
			List<WebElement> allRowVersions=CommonUtil.returnWebElementsFromXpath(xpathForFixedCol);
			Assert.assertTrue(CommonUtil.searchTextInList(allRowVersions, fixVersionName), "This ZQL Query is not giving the correct result.");
			*/
			if(CommonUtil.isElementPresent("//*[@class='no-results-message']")){
				logger.info(xpathForNoResultMsg.getText());
			} else {
				String xpathForFixedCol="//table[@id='issuetable']/tbody/tr/td["+returnHeaderNum("Version")+"]";
				List<WebElement> allRowVersions=CommonUtil.returnWebElementsFromXpath(xpathForFixedCol);
				Assert.assertTrue(searchTextInList(allRowVersions, fixVersionName), "This ZQL Query is not giving the correct result.");
			}
			logger.info("ZQL Query is executed successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executeZQLQueryForComponent(String ZQLQuery, String componentName){
		try{
			Assert.assertTrue(validateSearchTestExecutionPage(),"Not validated Search Test Execution Page.");
			logger.info("Search Test executions page is validated successfully.");
			Assert.assertTrue(executeZQLQuery(ZQLQuery), "ZQL Query is not searched.");
			logger.info("ZQL Query is searched successfully.");
			/*CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			zqlSearchTextbox.clear();
			zqlSearchTextbox.sendKeys(ZQLQuery);
			zqlSubmitBtn.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			logger.info("Total Number of tests present for fixed version : "+totalTests());*/
			if(CommonUtil.isElementPresent("//*[@class='no-results-message']")){
				logger.info(xpathForNoResultMsg.getText());
			} else {
				String xpathForFixedCol="//table[@id='issuetable']/tbody/tr/td["+returnHeaderNum("Component")+"]";
				List<WebElement> allRowComponents=CommonUtil.returnWebElementsFromXpath(xpathForFixedCol);
				Assert.assertTrue(searchTextInList(allRowComponents, componentName), "This ZQL Query is not giving the correct result.");
			}
			logger.info("ZQL Query for component is executed successfully.");
			/*String xpathForFixedCol="//table[@id='issuetable']/tbody/tr/td["+returnHeaderNum("Component")+"]";
			List<WebElement> allRowComponents=CommonUtil.returnWebElementsFromXpath(xpathForFixedCol);
			Assert.assertTrue(CommonUtil.searchTextInList(allRowComponents, componentName), "This ZQL Query is not giving the correct result.");
			logger.info("ZQL Query for component is executed successfully.");*/
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executeZQLQuery(String ZQLQuery){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			zqlSearchTextbox.clear();
			zqlSearchTextbox.sendKeys(ZQLQuery);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			zqlSubmitBtn.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "value"),ZQLQuery, "Not showing the result of zql query.");
			logger.info("ZQL Query results are showing.");
			if(CommonUtil.isElementPresent("//*[@class='no-results-message']")){
				logger.info(xpathForNoResultMsg.getText());
			} else {
				logger.info("Total Number of test(s) fetched for the query : "+totalTests());
			}
			//logger.info("Total Number of tests present : "+totalTests());
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean createExecFilterAndSaveToFavourite(String ZQLQuery, String filterName){
		try{
			Assert.assertTrue(validateSearchTestExecutionPage(),"Not validated Search Test Execution Page.");
			logger.info("Search Test executions page is validated successfully.");
			Assert.assertTrue(executeZQLQuery(ZQLQuery), "ZQL Query is not searched.");
			logger.info("ZQL Query is searched successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			saveAsZQLFilter.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			saveAsFilterName.sendKeys(filterName);
			/*if(favouriteCheckbox.getAttribute("checked").equals("checked")){
				
			}else{
				favouriteCheckbox.click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			}*/
			logger.info("Favourite checkbox is checked.");
			saveAsFilterSaveBtn.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			String changeFilterName=filterName+" ("+totalTests()+")";
			Assert.assertTrue(CommonUtil.searchTheTextInList(favouriteFilters, changeFilterName), "Filter is not found in Favourite filter list.");
			logger.info("Filter is saved and searched successfully in favourite filters.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean searchExecutionFilter(String filterName){
		try{
			Assert.assertTrue(validateSearchTestExecutionPage(),"Not validated Search Test Execution Page.");
			logger.info("Search Test executions page is validated successfully.");
			//Assert.assertTrue(createExecFilterAndSaveToFavourite(ZQLQuery, filterName),"Execution Filter is not created in favourite filters." );
			//logger.info("Execution Filter is successfully created in Favourite filters.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			searchExecFilterTextBox.sendKeys(filterName,Keys.ENTER);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info("Gave filtername.");
			CommonUtil.actionClass().sendKeys(Keys.TAB, Keys.RETURN).build().perform();
			
			/*//CommonUtil.actionClass().moveToElement(searchExecFilterExecuteBtn).build().perform();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			System.out.println(searchExecFilterExecuteBtn.isDisplayed());
			searchExecFilterExecuteBtn.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			logger.info("Clicked on execute link.");*/
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			//System.out.println(zqlSearchTextbox.getAttribute("filterid"));
			//Assert.assertTrue(zqlSearchTextbox.getAttribute("filterid").equals(filterName), "Filter is not verified.");
			//logger.info("Filter is verified.");
			
			Assert.assertNotNull(zqlSearchTextbox.getAttribute("value"), "TextBox contains some query.");
			logger.info("Filter is verified.");
			
			
			String changeFilterName=filterName+" ("+totalTests()+")";
			Assert.assertTrue(CommonUtil.searchTheTextInList(favouriteFilters, changeFilterName), "Filter is not found in Favourite filter list.");
			logger.info("Filter is searched successfully in favourite filters.");
			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean exportTestExecutions(String filterName, String ZQLQuery,String projectName, String versionName, String cycleName, String testOne, String testTwo, String totalTestsToExport, String totalTestStep){
		try{
			FileUtils.cleanDirectory(new File(Config.getValue("EXPORT_FILE_PATH")));
			logger.info("All files are deleted.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(validateSearchTestExecutionPage(),"Not validated Search Test Execution Page.");
			logger.info("Search Test executions page is validated successfully.");
			Assert.assertTrue(executeZQLQuery(ZQLQuery));
			//Assert.assertTrue(selectAndValidatePredefinedFilters(filterName), "Filter is not executed.");
			logger.info("Query is executed and showing the result.");
			//int totalTests=totalTests();
			//List<String> list=CommonUtil.getValues("//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/a[contains(text(),'"+Config.getValue("PROJECT_KEY")+"-')]");
			List<String> list=CommonUtil.getValues("//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]]/descendant::td/a[contains(text(),'"+Config.getValue("PROJECT_KEY")+"-')]");
			if( totalTestsToExport.equals("1")){
				//String xpath="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/preceding-sibling::td/input";
				String xpathForTest="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+list.get(0)+"']]/preceding-sibling::td/input[@type='checkbox']";
				CommonUtil.clickOnElement(xpathForTest);
				logger.info("Selected a particular test and select check box for exporting.");
			}else if(totalTestsToExport.equals("2")){
				//String xpathForTestOne="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+list.get(0)+"']]/preceding-sibling::td/input[@type='checkbox']";
				String xpathForTestOne="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+list.get(0)+"']]]/descendant::td/input[@type='checkbox']";
				CommonUtil.clickOnElement(xpathForTestOne);
				//String xpathForTestTwo="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+list.get(1)+"']]/preceding-sibling::td/input[@type='checkbox']";
				String xpathForTestTwo="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+list.get(1)+"']]]/descendant::td/input[@type='checkbox']";
				CommonUtil.clickOnElement(xpathForTestTwo);
				logger.info("Selected two particular tests and select check box for exporting.");
			}
			/*if( totalTestsToExport.equals("1")){
				String xpathForTest="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testOne+"']]/preceding-sibling::td/input[@type='checkbox']";
				CommonUtil.clickOnElement(xpathForTest);
				logger.info("Selected a particular test and select check box for exporting.");
			}else if(totalTestsToExport.equals("2")){
				String xpathForTestOne="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testOne+"']]/preceding-sibling::td/input[@type='checkbox']";
				CommonUtil.clickOnElement(xpathForTestOne);
				String xpathForTestTwo="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testTwo+"']]/preceding-sibling::td/input[@type='checkbox']";
				CommonUtil.clickOnElement(xpathForTestTwo);
				logger.info("Selected two particular tests and select check box for exporting.");
			}*/
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			exportDropDownmenu.click();
			excelLinkIdForExport.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			String fileName="ZFJ-Executions-"+CommonUtil.returnDateFormat("MM-dd-yyyy");
			//String fileName="ZFJ-Executions-01-06-2014";
			String FilePath=Config.getValue("EXPORT_FILE_PATH")+""+fileName+".xls";
			logger.info("File path with name : "+FilePath);
			System.out.println(CommonUtil.fileExists(FilePath));
			 Assert.assertTrue(CommonUtil.fileExists(FilePath), "File is not present in the directory.");
			 logger.info("File is present in that directory.");
			  CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			  logger.info("File is downloaded successfully.");
			  File file=new File(FilePath);
			  if(file.exists()){
					double d=file.length();
					//System.out.println(d);
					if(d != 0){
						logger.info("File is present and file length is : "+d);
					}else{
						logger.info("File is not present.");
					}
			  }
			  logger.info("File is validated successfully in local system.");
			  logger.info("File is exported successfully to local system.");
			  Assert.assertTrue(validateExportedData(fileName, filterName, projectName, versionName, cycleName, list.get(0), list.get(1), totalTestsToExport, totalTestStep, ZQLQuery), "Exported data is not validated after exporting.");
			  logger.info("Exported file is validated successfully.");
			  
			  
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean validateExportedData(String fileName, String filterName, String projectName, String versionName, String cycleName, String testOne, String testTwo, String totalTestsToExport, String totalTestStep, String ZQLQuery){
		try{
			File fis= new File(Config.getValue("EXPORT_FILE_PATH")+""+fileName+".xls");
			Document doc=Jsoup.parse(fis, "UTF-8");
			// Taking Header data for validation.
			Element firstTable=doc.select("table").first();
			int totalRow=firstTable.select("tr").size();
			Element header=firstTable.select("tr").first();
			// Validating header data from UI to excel.
			Assert.assertTrue(validateTableHeader(header), "Header is not validating successfully.");
			logger.info("Header validated successfully.");
			
			for(int k=1; k <= (totalRow - 1); k++){
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				Set<String> testDataFromUI= new HashSet<String>();
				Element firstRowData=firstTable.select("tr").get(k);
				int totalColBefore=firstRowData.select("td").size();
				Set<String> setFirstRowData =returnRowDataFromExcel(firstRowData);
				logger.info("Row Data Fetched successfully.");
				
				int totalTestStepsInExcel=returnTotalTestStep(firstRowData);	
				//System.out.println("Check test : "+setFirstRowData.contains(testOne));
				String testName=null;
				if(setFirstRowData.contains(testOne)){
					testName=testOne;
					testDataFromUI=returnTestDataFromUI(projectName, versionName, cycleName, testOne);
				} else {
					testName=testTwo;
					testDataFromUI=returnTestDataFromUI(projectName, versionName, cycleName, testTwo);
				}
				// Comparing two sets for excel data and ui data.
				logger.info(setFirstRowData.containsAll(testDataFromUI));
				Assert.assertTrue(setFirstRowData.containsAll(testDataFromUI), "UI Test Details are not matching in excel After Exporting.");
				logger.info("UI Test Details are matching successfully after exporting to excel.");
				
				//String xpathForExecutionButton="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/a[text()='E']";
				String xpathForExecutionButton="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+testName+"']]]/descendant::td/a[text()='E']";
				CommonUtil.navigateThroughXpath(xpathForExecutionButton);
				logger.info("Navigated to Execute Tests page.");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				
				JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
			    js.executeScript("javascript:window.scrollBy(250,400)"); 
			    CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				
				String xpath="//*[@id='teststepDetails_heading']/following-sibling::div/table/tbody/tr";
				boolean testStepFindStatus=CommonUtil.isElementPresent(xpath);
				logger.info("Test step present : "+testStepFindStatus);
								
				if(testStepFindStatus){
					int totalTestStepsInUI=CommonUtil.returnWebElementsFromXpath(xpath).size();
					// Comparing total number of test steps in excel and in ui.
					Assert.assertTrue( totalTestStepsInUI == totalTestStepsInExcel, "Total Test steps are not matching in Excel.");
					logger.info("Total Test steps are same in excel as well as in UI.");
					//logger.info("Total test step : "+returnTotalTestStep(firstRowData))
					
					// Comparing test steps .
					for(int i=k; i< k+totalTestStepsInExcel; i++){
						Element row=firstTable.select("tr").get(i);
						Set<String> testStepFromExcel=returnTestStepData(row);
						int teststepNum=i-k+1;
						logger.info("Fetched ExcelData for test step "+(teststepNum));
						Set<String> testStepDataFromUI=returnTestStepDataFromUI(teststepNum);
						logger.info("Fetched UI Data for test step "+(teststepNum));
						// Comparing two sets for comparing test steps between excel data and ui data.
						logger.info(testStepFromExcel.containsAll(testStepDataFromUI));
						Assert.assertTrue(testStepFromExcel.containsAll(testStepDataFromUI), "Test steps are not matching after exporting to excel.");
						logger.info("TestStep "+teststepNum+" Validated in after exporting.");
					} 
					if(testStepFindStatus){
						k=(k+totalTestStepsInExcel)-1;
						//k=i;
						//System.out.println(k);
					}
				}else {
					logger.info("Test steps are not present in this test.");
				}
				Driver.driver.navigate().back();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				logger.info("Returned successfully to Execution Navigator.");
				Assert.assertTrue(validateSearchTestExecutionPage(),"Not validated Search Test Execution Page.");
				logger.info("Search Test executions page is validated successfully.");
				//Assert.assertTrue(selectAndValidatePredefinedFilters(filterName), "Filter is not executed.");
				Assert.assertTrue(executeZQLQuery(ZQLQuery));
				logger.info("Query is executed and showing the result.");
				
			}
			
			logger.info("Exported data validated successfully.");
			
		}catch(Exception e){
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/** Due to bug ZFJ-1234 the headers and data don't come in same order as shown in UI.
	 * So verifying it in random order.
	 * @param row
	 */
	private boolean validateTableHeader(Element row) {
		try{
			Set<String> set = new HashSet<String>();
			Set<String> setForUIData = new HashSet<String>();
			Elements column=row.select("th");
			System.out.println(column.size());
			// put all column headers in set
			// verify that all column headers are preset.
			// check count
			Assert.assertTrue(column.size() >= 19, "Header size is not matching");
			for(int i=0; i<column.size(); i++){
				String rowData=row.select("th").get(i).toString();
				String[] splitColumnData=rowData.split(">", 2);
				//System.out.println(x1[0]+" "+x1[1]);
				String[] columnData=splitColumnData[1].split("</");
				System.out.println(columnData[0]);
				set.add(columnData[0]);
			}
			for(int i=0; i<xpathForIssueTableHeaders.size(); i++){
				String x=xpathForIssueTableHeaders.get(i).getText();
				if(xpathForIssueTableHeaders.get(i).getText().equals(null) || xpathForIssueTableHeaders.get(i).getText().equals("") || xpathForIssueTableHeaders.get(i).getText().equals(" ")){
					continue;
				}else if (xpathForIssueTableHeaders.get(i).getText().contains("Cycle") || xpathForIssueTableHeaders.get(i).getText().contains("Project") ){
					if(xpathForIssueTableHeaders.get(i).getText().contains("Project")){
						if(xpathForIssueTableHeaders.get(i).getText().contains(" ")){
							String[] data1=xpathForIssueTableHeaders.get(i).getText().split(" ");
							//System.out.println(data[0]+""+data1);
							//String newString=data1[0]+""+data1[1];
							String newString=data1[0];
							setForUIData.add(newString);
						}
					}else{
						if(xpathForIssueTableHeaders.get(i).getText().contains(" ")){
							String[] data1=xpathForIssueTableHeaders.get(i).getText().split(" ");
							//System.out.println(data[0]+""+data1);
							String newString=data1[0]+""+data1[1];
							//String newString=data1[0];
							setForUIData.add(newString);
						}
					}
				}else if((xpathForIssueTableHeaders.get(i).getText().trim()).equals("Test Summary") ){
					setForUIData.add(xpathForIssueTableHeaders.get(i).getText());
					logger.info("Test Summary is eliminated while validating.");
					
				}else if((xpathForIssueTableHeaders.get(i).getText().trim()).equals("Execution Defect(s)") ){
					//setForUIData.add(xpathForIssueTableHeaders.get(i).getText());
					logger.info("Execution Defect(s) column is eliminated while validating.");
					
				}else{
					setForUIData.add(xpathForIssueTableHeaders.get(i).getText());
				}
			}
					
			logger.info(set.containsAll(setForUIData));
			Assert.assertTrue(set.containsAll(setForUIData), "Excel data's and UI data's are not matching.");
			System.out.println("UI data's are validating in excel successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean returnStatus(Set<String> set, String text){
		boolean flag=false;
		try{
			Iterator itr = set.iterator();
	        while(itr.hasNext())
	        {
	            System.out.println(itr.next());
	            if(itr.next().equals(text)){
	            	flag=true;
	            	break;
	            }
	            
	        }
		}catch(Exception e){
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	/** Verifies table data for first row.
	 * As the values are not in proper order, using a Set for non-testStep fields. */
	private void validateTableData() {
		Set<String> nonStepFields = new HashSet<String>();
		List<List<String>> testSteps = new ArrayList<List<String>>();
		// for every loop get the data for that test step 
		// put in a List<String>
		// and put that List<String> in testSteps
	}
	private Set<String> returnTestDataFromUI(String projectName, String versionName, String cycleName, String testName){
		Set<String> rowDataFromUI= new HashSet<String>();
		try{
			String xpathForRowDataFromUI="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]]/td";
			String testSummaryxpath="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td/a[text()='"+versionName+"']][td/a[text()='"+cycleName+"']][td/a[text()='"+testName+"']]/td["+returnHeaderNum("Test Summary")+"]";
			String testSummary=CommonUtil.getTextFromUIByXpath(testSummaryxpath);
			String executionDefectxpath="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td/a[text()='"+versionName+"']][td/a[text()='"+cycleName+"']][td/a[text()='"+testName+"']]/td["+returnHeaderNum("Execution Defect(s)")+"]";
			int execDefColNum = returnHeaderNum("Execution Defect(s)");
			List<WebElement> list=Driver.driver.findElements(By.xpath(xpathForRowDataFromUI));
			for(int l=0; l<list.size(); l++){
				if(list.get(l).getText().equals(null) || list.get(l).getText().equals("") || list.get(l).getText().equals(" ") || list.get(l).getText().equals("E") || (execDefColNum-1) == l){
					continue;
				}else if(list.get(l).getText().trim().equals(testSummary.trim())){
					rowDataFromUI.add(list.get(l).getText());
					//logger.info("Test Summary skipped for validation.");
				}else{
					rowDataFromUI.add(list.get(l).getText());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rowDataFromUI;
	}
	private Set<String> returnTestStepDataFromUI(int testStep){
		Set<String> testStepFromUI=new HashSet<String>();
		try{
			String xpathForTestStep="//*[@id='teststepDetails_heading']/following-sibling::div/table/tbody/tr[td[text()='"+testStep+"']]/td";
			
			//List<WebElement> listTestStep=Driver.driver.findElements(By.xpath(xpathForTestStep));
			List<WebElement> listTestStep=CommonUtil.returnWebElementsFromXpath(xpathForTestStep);
			for(int j=0; j<listTestStep.size(); j++){
				if(listTestStep.get(j).getText().equals(null) || listTestStep.get(j).getText().equals("") || listTestStep.get(j).getText().equals(" ")){
					continue;
				}else{
					String X=listTestStep.get(j).getText();
					if(X.trim().equals("Enter Comment") || X.trim().contains("Defects") || X.trim().contains("-") ){
						logger.info("Skipping Text Enter Comment or Enter Defects, if there is no defect or comment.");
					} else {
						testStepFromUI.add(X);
					}
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return testStepFromUI;
	}
	private Set<String> returnTestStepData(Element row){
		Set<String> set = new HashSet<String>();
		Elements column=row.select("td");
		//System.out.println(column.size());
		for(int i=0; i<column.size(); i++){
			String x=row.select("td").get(i).toString();
			if(x.contains("<td>")){
				String[] x1=x.split("<td>");
				String[] x2=x1[1].split("</");
				String addData=x2[0].trim();
				//System.out.println(x2[0]);
				//set.add(x2[0]);
				if(addData.contains(">")){
					String[] a=x2[0].split(">");
					addData=a[1].trim();
					//System.out.println(a[1]);
				}
				if(addData.equals(" ") || addData.equals("")){	
				}else{
					set.add(addData);
				}
			}
		}
		return set;
	}
	private Set<String> returnRowDataFromExcel(Element row){
		Set<String> setRowData = new HashSet<String>();
		Elements column=row.select("td");
		//System.out.println(column.size());
		for(int i=0; i<column.size(); i++){
			String x=row.select("td").get(i).toString();
			if(x.contains("rowspan")){
				/*int ii=x.indexOf("=\"");
				String num=x.substring(ii, 3);
				System.out.println(num);*/
				String[] x1=x.split(">", 2);
				String[] x2=x1[1].split("</");
				//System.out.println(x2[0]);
				//setRowData.add(x2[0]);
				if(x2[0].equals(" ") || x2[0].equals("")){
				}else{
					setRowData.add(x2[0].trim());
				}
			} else {
				String[] x1=x.split(">", 2);
				String[] x2=x1[1].split("</");
				//System.out.println(x2[0]);
				//setRowData.add(x2[0]);
				if(x2[0].equals(" ") || x2[0].equals("")){
				}else{
					setRowData.add(x2[0].trim());
				}
			}
			
		}
		return setRowData;
	}
	private int returnTotalTestStep(Element row){
		int totalTeststeps=0;
		try{
			Set<String> setRowData = new HashSet<String>();
			Elements column=row.select("td");
			//System.out.println(column.size());
			for(int i=0; i<column.size(); i++){
				String x=row.select("td").get(i).toString();
				if(x.contains("rowspan")){
					int ii=x.indexOf("=\"");
					//System.out.println(x.charAt(ii));
					String num=x.substring(ii+2,ii+3);
					totalTeststeps=Integer.parseInt(num);
					logger.info("Total Test Steps : "+totalTeststeps);
					break;
				}else{
					logger.info("This row does not contains any test steps");
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return totalTeststeps;
	}
	
	
	public boolean validateExportedData(String fileName){
		try{
			File fis= new File(Config.getValue("EXPORT_FILE_PATH")+""+fileName+".xls");
			Document doc=Jsoup.parse(fis, "UTF-8");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteExecutions(String ZQLQuery, String numberOfExec){
		try{
			Assert.assertTrue(validateSearchTestExecutionPage(),"Not validated Search Test Execution Page.");
			logger.info("Search Test executions page is validated successfully.");
			
			Assert.assertTrue(executeZQLQuery(ZQLQuery), "ZQL Query is not executed successfully.");
			
			int totalNumberOfTestsInIssueTable = totalTests();
			Assert.assertTrue(Integer.parseInt(numberOfExec) <= xpathForAllCheckBoxInIssueTableTest.size(),"Number of deleting tests are not lessthan the tests present in issue table.");
			logger.info("Deleting tests are less than total tests.");
			for(int i=0;i<Integer.parseInt(numberOfExec);i++){
				xpathForAllCheckBoxInIssueTableTest.get(i).click();
			}
			logger.info("Selected "+numberOfExec+" of tests for deletion.");
			
			Assert.assertTrue(clickOnDeleteLink(), "Not clicked on delete link.");
			logger.info("Clicked on delete link.");
			if(CommonUtil.visibilityOfElementLocated("//div[@id='execution-delete-dialog']")){
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				confirmationDeleteButton.click();
				//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);

				if(CommonUtil.visibilityOfElementLocated("//div[@id='warning-message-dialog']")){
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					warningCloseLink.click();
					//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
					CommonUtil.invisibilityOfElementLocated("//div[@id='warning-message-dialog']");
				}
			}
			
			//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			
			
			
			logger.info("Successfully deleted tests.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			xpathForRefreshLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			System.out.println(totalNumberOfTestsInIssueTable+" : "+totalTests()+" = "+(totalTests() < totalNumberOfTestsInIssueTable ));
			Assert.assertTrue(totalTests() < totalNumberOfTestsInIssueTable , "Total number of tests are not less than after deletion.");
			logger.info("Deleted tests are verified successfully.");
			System.out.println((totalNumberOfTestsInIssueTable - Integer.parseInt(numberOfExec)) == totalTests());
			Assert.assertTrue((totalNumberOfTestsInIssueTable - Integer.parseInt(numberOfExec)) == totalTests(), "Total number of tests are not less than after deletion.");
			logger.info("Deleted tests are verified successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public int totalTests() throws Exception{
		int totalTests=0;
		try{
			totalTests=Integer.parseInt(xpathForTotalTests.getText());
			
		}catch(Exception e){
			e.printStackTrace();
			return totalTests;
		}
		return totalTests;
	}

	public boolean executeTestFromExecutionNavigator(String zqlQuery, String projectName, String versionName,String cycleName, String testName, String testExecStatus){
		try{
			Assert.assertTrue(executeZQLQuery(zqlQuery), "ZQL Query is not executed successfully.");
			/*Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameOne), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			int totalTestsExecuted=totalTests();
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameTwo), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);*/
			int totalTestsUnexecuted=totalTests();
			
			String xpathForSelectTest="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/a[text()='"+testName+"']";
			CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForSelectTest)).build().perform();
			logger.info("Hovering to test cycle properly.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForExecutionButton="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/a[text()='E']";
			CommonUtil.navigateThroughXpath(xpathForExecutionButton);
			logger.info("Navigated to Execute Tests page.");
			
			Map<String, String> returnValues = ExecuteTestsPage.getInstance().changeTestExcutionStatusEN(testExecStatus);
			
			Assert.assertTrue(executeZQLQuery(zqlQuery), "ZQL Query is not executed successfully.");
			/*Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameTwo), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			int totalTestsUnexecutedAfterExec=totalTests();
			Assert.assertTrue((totalTestsUnexecutedAfterExec + 1 == totalTestsUnexecuted), "Total tests are not decresing by one.");
			logger.info("Total unexecuted tests decresed by one after execution.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameOne), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			int totalTestsExecutedAfterExec=totalTests();
			Assert.assertTrue((totalTestsExecuted +  1 == totalTestsExecutedAfterExec), "Total tests are not incresed by one after execution.");
			logger.info("Total tests are incresed by one after execution.");*/
			
			//String xpathForCurrentExecStatus="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/div/dl/dd[contains(@id,'current-execution-status-dd-schedule-')]";
			String xpathForCurrentExecStatus="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+testName+"']]]/descendant::dd[contains(@id,'current-execution-status-dd-schedule-')]";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForCurrentExecStatus).equals(testExecStatus), testExecStatus+" is not matched in this page.");
			logger.info(testName + " is Executed to " + testExecStatus + " successfully .");
			
			String xpathForExecutedBy="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+testName+"']]]/td["+returnHeaderNum("Executed By")+"]/a";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForExecutedBy).equals(returnValues.get("executedUser")), "Executed by is not matching after execution.");
			logger.info("Test Executed User is Validated Successfully .");
			
			String xpathForExecutedOn="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+testName+"']]]/td["+returnHeaderNum("Executed On")+"]";
			Assert.assertNotNull(CommonUtil.getTextFromUIByXpath(xpathForExecutedOn), "Executed on is not there.");
			logger.info("Test Executed Time is Validated Successfully .");
			//Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestAndValidate(versionName, cycleName, testName, testExecStatus),"Test is not executed successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executeTestInDetailViewFromExecutionNavigator(String zqlQuery, String projectName, String versionName,String cycleName, String testName, String testExecStatus){
		try{
			Assert.assertTrue(validatePage(), "Search Test Page is not Validated successfully.");
			Assert.assertTrue(executeZQLQuery(zqlQuery), "ZQL Query is not executed successfully.");
			Assert.assertTrue(changeView("detailed view"), "Detailed view is not selected successfuly.");
			
			
			String xpathForTest="//*[@id='list-results-panel']/descendant::*[@class='issue-list']/li/ul[li[a[text()='"+cycleName+"']]]/li/a[text()='"+testName+"']";
			CommonUtil.navigateThroughXpath(xpathForTest);
			System.out.println("Navigated to the test for execution.");
			
			
			
			/*int totalTestsUnexecuted=totalTests();
			
			String xpathForSelectTest="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/a[text()='"+testName+"']";
			CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForSelectTest)).build().perform();
			logger.info("Hovering to test cycle properly.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForExecutionButton="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/a[text()='E']";
			CommonUtil.navigateThroughXpath(xpathForExecutionButton);*/
			logger.info("Navigated to Execute Tests page in Detailed View.");
			
			Map<String, String> returnValues = ExecuteTestsPage.getInstance().changeStepAndTestExcutionStatusInDetailViewFromEN(testExecStatus, "1", "WIP");
			
			
			Assert.assertTrue(changeView("list view"), "Detailed view is not selected successfuly.");
			
			//Assert.assertTrue(executeZQLQuery(zqlQuery), "ZQL Query is not executed successfully.");
			
			
			//String xpathForCurrentExecStatus="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/div/dl/dd[contains(@id,'current-execution-status-dd-schedule-')]";
			String xpathForCurrentExecStatus="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+testName+"']]]/descendant::dd[contains(@id,'current-execution-status-dd-schedule-')]";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForCurrentExecStatus).equals(testExecStatus), testExecStatus+" is not matched in this page.");
			logger.info(testName + " is Executed to " + testExecStatus + " successfully .");
			
			String xpathForExecutedBy="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+testName+"']]]/td["+returnHeaderNum("Executed By")+"]/a";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForExecutedBy).equals(returnValues.get("executedUser")), "Executed by is not matching after execution.");
			logger.info("Test Executed User is Validated Successfully .");
			
			String xpathForExecutedOn="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+testName+"']]]/td["+returnHeaderNum("Executed On")+"]";
			Assert.assertNotNull(CommonUtil.getTextFromUIByXpath(xpathForExecutedOn), "Executed on is not there.");
			logger.info("Test Executed Time is Validated Successfully .");
			//Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestAndValidate(versionName, cycleName, testName, testExecStatus),"Test is not executed successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executeTestDirectlyFromExecutionNavigator(String zqlQuery, String projectName,String versionName,String cycleName, String testName, String testExecStatus){
		try{
			Assert.assertTrue(validatePage(),"Not validated Search Test Execution Page.");
						
			Assert.assertTrue(executeZQLQuery(zqlQuery), "ZQL Query is not executed successfully.");
		
			String xpathForStatusLabel="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/div/dl/a[contains(@id,'executionStatus-labels-schedule-')]";
			CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForStatusLabel)).build().perform();
			CommonUtil.navigateThroughXpath(xpathForStatusLabel);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			String xpathForSelectStatusList="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/div/select[contains(@id,'exec_status-schedule-')]";
			CommonUtil.selectListWithVisibleText(CommonUtil.returnWebElement(xpathForSelectStatusList), testExecStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			searchHeader.click();
			CommonUtil.visibilityOfElementLocated("//*[@id='aui-message-bar']/div");
			logger.info("Test Status is Changed Successfully.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			//String xpathForCurrentExecStatus="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/div/dl/dd[contains(@id,'current-execution-status-dd-schedule-')]";
			String xpathForCurrentExecStatus="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+testName+"']]]/descendant::dd[contains(@id,'current-execution-status-dd-schedule-')]";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForCurrentExecStatus).equals(testExecStatus), "Test is not executed directly from Execution Navigator.");
			logger.info("Test Execution status is validated successfully in execution navigator.");
			
			String xpathForExecutedBy="//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+testName+"']]]/td["+returnHeaderNum("Executed By")+"]/a";
			String executedBy = CommonUtil.getTextFromUIByXpath(xpathForExecutedBy);
			Assert.assertNotNull(executedBy, "Executed by should not be null after execution.");
			logger.info("Test is executed By : " + executedBy);
			
			String xpathForExecutedOn = "//table[@id='issuetable']/tbody/tr[td[a[@title='"+projectName+"']]][td[a[text()='"+versionName+"']]][td[a[text()='"+cycleName+"']]][td[a[text()='"+testName+"']]]/td["+returnHeaderNum("Executed On")+"]";
			String executedOn = CommonUtil.getTextFromUIByXpath(xpathForExecutedOn);
			Assert.assertNotNull( executedOn, "Executed on should not be null after execution.");
			logger.info("Test is executed On : " + executedOn);
						
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public boolean validateTestChanged(List<String>testId){
		try{
			for(int i=0;i<testId.size();i++){
				Assert.assertTrue(CommonUtil.searchTheTextInList(listOfTest,testId.get(i)),"Moving Tests Failed...");
				logger.info("Test"+testId.get(i)+" Moved successfully...");
				
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	private boolean selectTests(int totalTest){
		try{
			for(int i=1;i<=totalTest;i++){
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td[1]/input[@type='checkbox']").click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				
			}
			String[] testSelected=totalTestSelected.getText().split(" ");
			int testNum=Integer.parseInt(testSelected[1]);
			Assert.assertTrue(testNum>=totalTest);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean navigateToExecuteTest(){
		try{
			//CommonUtil.waitForStaleElement(CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']//a[@title='Execute Test']"),Constants.IMPLICIT_WAIT_LOW );
			CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr[1]//a[@title='Execute Test']").click();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
	private boolean clickBulkChangeTool(){
		try{
			xpathOfTool.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			//Assert.assertTrue(bulkChangeOptions.isDisplayed(),"Bulk Change Tools not dispalyed...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean clickOnDeleteLink(){
		try{
			xpathOfTool.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			deleteLinkForTestExec.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private List<String> getIdsOfTestSelected(int totalTest){
		List<String> testIdsSelected = new ArrayList<String>();
		try{
			logger.info("Tests Selected to do bluk operations are: ");
			int position = returnHeaderNum("Issue Key");
			for(int i=1;i<=totalTest;i++){
				String test= CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td["+position+"]/a").getText();
				logger.info(test);
				testIdsSelected.add(test);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return testIdsSelected;
			
		}
		return testIdsSelected;
	}
	
	private boolean validateIdsOfTestsSelected(List<String> tests){
		try{
			logger.info("Tests on which bluk operations is performed: ");
			int position=returnHeaderNum("Issue Key");
			for(int i=0;i<tests.size();i++){
				String getTest=tests.get(i);
				String test= CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+(i+1)+"]/td["+position+"]/a").getText();
				Assert.assertTrue(getTest.equals(test),"Same Test not selected...");
				logger.info(test);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private List<String> getCyclesOfTestSelected(List<String> tests){
		List<String> testCyclesSelected = new ArrayList<String>();
		try{
			logger.info("Cycles Selected to do bluk operations are: ");
			int position= returnHeaderNum("Cycle Name");
			for(int i=0;i<tests.size();i++){
				String cycle= CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+(i+1)+"]/td["+position+"]/a").getText();
				logger.info(cycle);
				testCyclesSelected.add(cycle);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return testCyclesSelected;
			
		}
		return testCyclesSelected;
	}
	
	/*private boolean validateCyclesOfTestsSelected(List<String> cycles,int totalTest){
		try{
			logger.info("Cycles on which bluk operations is performed: ");
			for(int i=1;i<=totalTest;i++){
				String getCycle=cycles.get((i-1));
				String cycle= CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td[2]/a").getText();
				Assert.assertTrue(getCycle.equals(cycle),"Same Cycle not selected...");
				logger.info(cycle);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	private List<String> getStatusOfTestSelected(List<String> tests){
		List<String> testStatusSelected = new ArrayList<String>();
		try{
			logger.info("Statuses Selected to do bluk operations are: ");
			int position= returnHeaderNum("Execution Status");
			for(int i=0;i<tests.size();i++){
				String status= CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-exec-status']]]]/tbody[@id='resultBodyId']/tr["+(i+1)+"]/td["+position+"]/div//dd").getText();
				logger.info("Status of "+tests.get(i)+" is: "+ status);
				testStatusSelected.add(status);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return testStatusSelected;
			
		}
		return testStatusSelected;
	}
	
	/*private boolean validateStatusOfTestsSelected(List<String> statuses,int totalTest){
		try{
			logger.info("Status on which bluk operations is performed: ");
			for(int i=1;i<=totalTest;i++){
				String getStatus=statuses.get((i-1));
				String status= CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td[8]/dd").getText();
				Assert.assertTrue(getStatus.equals(status),"Same Status not selected...");
				logger.info(status);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	private void refreshPage(){
		
		try {
			xpathForRefreshLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	private String getCycleOfGivenTest(String test){
		String cycle = null;
		try{
			int position = returnHeaderNum("Cycle Name"); 
			cycle=CommonUtil.changeToWebElement("//tr[td[a[text()='"+test+"']]]/td["+position+"]/a").getText();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return cycle;
		
	}
	private int returnHeaderNum(String headerName){
		int rowNum = 0;
		try{
			for (int i=0 ; i < allHeadersOfIssueTable.size() ; i++){
				if(allHeadersOfIssueTable.get(i).getText().equals(headerName)){
					rowNum=i+1;
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rowNum;
	}
	
	private String createZqlQueryForIssues(List<String> tests){
		String zqlQuery = "Issue in (";
			try{
				for(int i = 0 ; i< tests.size(); i++){
					zqlQuery = zqlQuery+tests.get(i);
					if(i<(tests.size()-1)){
						zqlQuery = zqlQuery+",";
					}
				}
				zqlQuery = zqlQuery+")";
		}catch(Exception e){
			e.printStackTrace();
			return zqlQuery;
		}
		return zqlQuery;
	}
	
	public boolean searchTextInList(List<WebElement> list, String searchText){
		boolean flag=false;
		try{
			for(int i=0; i<list.size(); i++){
				for(int j=i; j<=20; j++){
					//String s=list.get(i).getText();
					if(list.get(i).getText().contains(searchText)){
						flag=true;
					}else{
						flag=false;
						break;
					}
				}
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
			return flag;
		}
		return flag;
	}
	public boolean changeView(String view){
		try{
			if(CommonUtil.isElementPresent("//*[@id='layout-switcher-button']")) {
				layoutSwitchBtn.click();
				CommonUtil.visibilityOfElementLocated("//div[@id='layout-switcher-button_drop']");
				logger.info("Shitch view drop-down activated successfully.");
				if (view.equals("list view")) {
					//String xpthaForView="//li[a[@data-layout-key='list-view']]";
					String xpthaForView="//a[@data-layout-key='list-view']";
					CommonUtil.clickOnElement(xpthaForView);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					Assert.assertTrue(CommonUtil.getCurrentUrl().contains("view=list"), "List View is not showing current Url.");
					Assert.assertTrue(CommonUtil.isObjectDisplayed("//*[@id='displayDetailId']"), "In List view total tests are not visible.");
					
				}	else if (view.equals("detailed view")){
					//String xpthaForView="//li[a[@data-layout-key='split-view']]";
					String xpthaForView="//a[@data-layout-key='split-view']";
					CommonUtil.clickOnElement(xpthaForView);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					Assert.assertTrue(CommonUtil.getCurrentUrl().contains("view=detail"), "List View is not showing current Url.");
					Assert.assertTrue(CommonUtil.isElementPresent("//*[@id='prev-next-return-container']/li[@class='previous prevnext-wrapper']"), "In Detail view total tests are not visible.");
					
				}
				
			} else {
				logger.info("Any View is not present, By defualt it is selected List View.");
			}
			
		} catch ( Exception e ) {
			return false;
		}
		return true;
	}
	private boolean validatePage(){
		try{
			Assert.assertTrue(CommonUtil.titleContains("Execution Navigator", Constants.EXPLICIT_WAIT_LOW), "Search Test Execution Page is not verified successfully.");
			logger.info("Search Test Execution Page is Validated Successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean navigateTestUsingPrevAndNextInDetailediew(String filterName){
		try{
			Assert.assertTrue(validatePage(), "Search Test Page is not Validated successfully.");
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterName), filterName+" filter is not executed successfully.");
			Assert.assertTrue(changeView("list view"), "Detailed view is not selected successfuly.");
			int totalTestsInListView = totalTests();
			Assert.assertTrue(changeView("detailed view"), "Detailed view is not selected successfuly.");
			
			int startTestInDetailView = startTestsInDetailView(); 
			logger.info("Tests started from : " + startTestInDetailView);
			int totalTestInDetailView = totalTestsInDetailView();
			logger.info("Toatl Tests are : " + totalTestInDetailView);
			Assert.assertTrue(totalTestsInListView == totalTestInDetailView, "Total Tests are not same in both View.");
			logger.info("Total Tests are same in both view.");
			
			logger.info("In-Detail View Now Present in Test number : "+ startTestInDetailView);
			Assert.assertTrue(navigateUsingPrevAndNext("next"), "Not clicked on Next Execution Link");
			int nextTotalTests = startTestsInDetailView();
			Assert.assertTrue( (startTestInDetailView + 1) == nextTotalTests, "After clicking Next Link tests are not showing same.");
			startTestInDetailView = nextTotalTests;
			logger.info("In-Detail View Now Present in Test number : "+ startTestInDetailView);
			Assert.assertTrue(navigateUsingPrevAndNext("next"), "Not clicked on Next Execution Link");
			nextTotalTests = startTestsInDetailView();
			Assert.assertTrue( (startTestInDetailView + 1) == nextTotalTests, "After clicking Next Link tests are not showing same.");
			startTestInDetailView = nextTotalTests;
			logger.info("In-Detail View Now Present in Test number : "+ startTestInDetailView);
			
			logger.info("Navigated Successfully to executions in detailed view using Next Link.");
			
			Assert.assertTrue(navigateUsingPrevAndNext("prev"), "Not clicked on Next Execution Link");
			nextTotalTests = startTestsInDetailView();
			Assert.assertTrue( (startTestInDetailView - 1) == nextTotalTests, "After clicking Previous Link tests are not showing same.");
			startTestInDetailView = nextTotalTests;
			logger.info("In-Detail View Now Present in Test number : "+ startTestInDetailView);
			Assert.assertTrue(navigateUsingPrevAndNext("prev"), "Not clicked on Next Execution Link");
			nextTotalTests = startTestsInDetailView();
			Assert.assertTrue( (startTestInDetailView - 1) == nextTotalTests, "After clicking Previous Link tests are not showing same.");
			startTestInDetailView = nextTotalTests;
			logger.info("In-Detail View Now Present in Test number : "+ startTestInDetailView);
			
			logger.info("Changing Test Executions using Prev and Next Link Navigated Successfully.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean navigateTestInFullScreenUsingPrevAndNextInDetailedview(String filterName){
		try{
			Assert.assertTrue(validatePage(), "Search Test Page is not Validated successfully.");
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterName), filterName+" filter is not executed successfully.");
			Assert.assertTrue(changeView("list view"), "Detailed view is not selected successfuly.");
			int totalTestsInListView = totalTests();
			Assert.assertTrue(changeView("detailed view"), "Detailed view is not selected successfuly.");
			
			int startTestInDetailView = startTestsInDetailView(); 
			logger.info("Tests started from : " + startTestInDetailView);
			int totalTestInDetailView = totalTestsInDetailView();
			logger.info("Toatl Tests are : " + totalTestInDetailView);
			Assert.assertTrue(totalTestsInListView == totalTestInDetailView, "Total Tests are not same in both View.");
			logger.info("Total Tests are same in both view.");
			int totalTestsInFullScreen = totalTestsInDetailView();
			logger.info("Toatl Tests In Full Screen are : " + totalTestsInFullScreen);
			Assert.assertTrue(totalTestInDetailView == totalTestsInFullScreen, "Total Tests are not same in Full Screen View.");
			
			CommonUtil.navigateThroughXpath("//a[@id='view-full-screen']");
			logger.info("Navigated Successfully to Full Screen Mode.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			logger.info("In-Detail View Now Present in Test number : "+ startTestInDetailView);
			Assert.assertTrue(navigateUsingPrevAndNext("next"), "Not clicked on Next Execution Link");
			int nextTotalTests = startTestsInDetailView();
			Assert.assertTrue( (startTestInDetailView + 1) == nextTotalTests, "After clicking Next Link tests are not showing same.");
			startTestInDetailView = nextTotalTests;
			logger.info("In-Detail View Now Present in Test number : "+ startTestInDetailView);
			Assert.assertTrue(navigateUsingPrevAndNext("next"), "Not clicked on Next Execution Link");
			nextTotalTests = startTestsInDetailView();
			Assert.assertTrue( (startTestInDetailView + 1) == nextTotalTests, "After clicking Next Link tests are not showing same.");
			startTestInDetailView = nextTotalTests;
			logger.info("In-Detail View Now Present in Test number : "+ startTestInDetailView);
			
			logger.info("Navigated Successfully to executions in detailed view using Next Link.");
			
			Assert.assertTrue(navigateUsingPrevAndNext("prev"), "Not clicked on Next Execution Link");
			nextTotalTests = startTestsInDetailView();
			Assert.assertTrue( (startTestInDetailView - 1) == nextTotalTests, "After clicking Previous Link tests are not showing same.");
			startTestInDetailView = nextTotalTests;
			logger.info("In-Detail View Now Present in Test number : "+ startTestInDetailView);
			Assert.assertTrue(navigateUsingPrevAndNext("prev"), "Not clicked on Next Execution Link");
			nextTotalTests = startTestsInDetailView();
			Assert.assertTrue( (startTestInDetailView - 1) == nextTotalTests, "After clicking Previous Link tests are not showing same.");
			startTestInDetailView = nextTotalTests;
			logger.info("In-Detail View Now Present in Test number : "+ startTestInDetailView);
			
			logger.info("Changing Test Executions using Prev and Next Link Navigated Successfully.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean customizeColumnDisplayEN(String filterName, String type){
		try{
			Assert.assertTrue(validatePage(), "Search Test Page is not Validated successfully.");
			if(type.equals("predefined")){
				Assert.assertTrue(selectAndValidatePredefinedFilters(filterName), filterName+" filter is not executed successfully.");
			}else if(type.equals("custom")){
				Assert.assertTrue(executeZQLQuery(filterName), filterName+" filter is not executed successfully.");
			}
			
			Assert.assertTrue(changeView("list view"), "Detailed view is not selected successfuly.");
			
			Assert.assertTrue(columnDisplays("Cycle Name", "hide"),"Column display is not working. ");
			
			Assert.assertTrue(columnDisplays("Cycle Name", "show"),"Column display is not working. ");
			
			/*List<String> allHeaderList = CommonUtil.getValues("//*[@id='issuetable']/thead/tr/th");
			Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", "Cycle Name"));
			CommonUtil.navigateThroughXpath("//*[@id='column-selector']/button");
			Assert.assertTrue(CommonUtil.isElementDisplayed(CommonUtil.returnWebElement("//*[@id='inline-dialog-column-selector']/div[@class='contents']")), "Element is not diaplayed currently.");
			
			Assert.assertTrue(columnDisplay("Cycle Name", "hide"),"Column is not hided successfully");
			
			Assert.assertFalse(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", "Cycle Name"));
			CommonUtil.clickOnElement("//*[@id='column-dialog-save']");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info("Column hided successfully.");
			
			Assert.assertFalse(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", "Cycle Name"));
			CommonUtil.navigateThroughXpath("//*[@id='column-selector']/button");
			Assert.assertTrue(CommonUtil.isElementDisplayed(CommonUtil.returnWebElement("//*[@id='inline-dialog-column-selector']/div[@class='contents']")), "Element is not diaplayed currently.");
			
			Assert.assertTrue(columnDisplay("Cycle Name", "show"),"Column is not showing successfully");
			
			Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", "Cycle Name"));
			CommonUtil.clickOnElement("//*[@id='column-dialog-save']");
*/			
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean restoreDefualtsColEN(String filterName, String type){
		try{
			Assert.assertTrue(validatePage(), "Search Test Page is not Validated successfully.");
			if(type.equals("predefined")){
				Assert.assertTrue(selectAndValidatePredefinedFilters(filterName), filterName+" filter is not executed successfully.");
			}else if(type.equals("custom")){
				Assert.assertTrue(executeZQLQuery(filterName), filterName+" filter is not executed successfully.");
			}
			
			Assert.assertTrue(changeView("list view"), "Detailed view is not selected successfuly.");
			
			//List<String> allHeaderList = CommonUtil.getValues("//*[@id='issuetable']/thead/tr/th");
			//int totalCol = allHeaderList.size();
			int totalCol = CommonUtil.getSizeOfElements("//*[@id='issuetable']/thead/tr/th");
			//Assert.assertTrue(reorderColumn( "Cycle Name","Issue Key"), "Reodering of column not successful.");
			Assert.assertTrue(reorderColumn( "Test Summary", "Priority"), "Reodering of column not successful.");
			//columnDisplays("Cycle Name", "hide");
			/*int n= CommonUtil.getSizeOfElements("//*[@id='issuetable']/thead/tr/th");
			logger.info("Total Columns :"+totalCol);
			Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", "Cycle Name"));
			CommonUtil.navigateThroughXpath("//*[@id='column-selector']/button");
			Assert.assertTrue(CommonUtil.isElementDisplayed(CommonUtil.returnWebElement("//*[@id='inline-dialog-column-selector']/div[@class='contents']")), "Element is not diaplayed currently.");
			Assert.assertTrue(columnDisplay("Cycle Name", "hide"),"Column is not hided successfully");
			
			Assert.assertFalse(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", "Cycle Name"));
			CommonUtil.clickOnElement("//*[@id='column-dialog-save']");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info("Column hided successfully.");*/
			/*CommonUtil.clickOnElement("//*[@id='columns-restore-defaults']");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);*/
			Assert.assertTrue(restoreDefualtsCol(), "Restore columns not successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			//List<String> allHeaderListAfter = CommonUtil.getValues("//*[@id='issuetable']/thead/tr/th");
			CommonUtil.refreshPage();
			int totalColAfter = CommonUtil.getSizeOfElements("//*[@id='issuetable']/thead/tr/th");
			Assert.assertTrue(totalCol == totalColAfter, "After restore defualts column Size is not same.");
			//int headerOne = returnHeaderNum("Cycle Name");
			//int headerTwo = returnHeaderNum("Issue Key");
			
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean navigatePageInDetailediew(String filterName, String type){
		try{
			Assert.assertTrue(validatePage(), "Search Test Page is not Validated successfully.");
			if(type.equals("predefined")){
				Assert.assertTrue(selectAndValidatePredefinedFilters(filterName), filterName+" filter is not executed successfully.");
			}else if(type.equals("custom")){
				Assert.assertTrue(executeZQLQuery(filterName), filterName+" filter is not executed successfully.");
			}
			
			Assert.assertTrue(changeView("list view"), "Detailed view is not selected successfuly.");
			int totalTestsInListView = totalTests();
			if (totalTestsInListView > 20){
				Assert.assertTrue(changeView("detailed view"), "Detailed view is not selected successfuly.");
				int startTestInDetailView = startTestsInDetailView(); 
				logger.info("Tests started from : " + startTestInDetailView);
				int totalTestInDetailView = totalTestsInDetailView();
				logger.info("Toatl Tests are : " + totalTestInDetailView);
				Assert.assertTrue(totalTestsInListView == totalTestInDetailView, "Total Tests are not same in both View.");
				logger.info("Total Tests are same in both view.");
				
				int lastPageInDetailView = (totalTestsInListView/20)+1;
				logger.info("Total Pages in Detail View :"+lastPageInDetailView);
				for(int i=1; i<=lastPageInDetailView; i++){
					int currentPage = currentPage();
					logger.info("currentPage() : "+currentPage());
					logger.info("Current Page : "+currentPage);
					Assert.assertTrue(validatePaginationPage(currentPage), currentPage+" is not validated .");
					if(currentPage < lastPageInDetailView){
						int nextPage = currentPage+1;
						Assert.assertTrue(navigatePaginationPage(nextPage), "Not navigated to nextPage.");
						CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					}
					//currentPage = currentPage();
					//Assert.assertTrue(validatePaginationPage(currentPage), currentPage+" is not validated .");
					
				}
				
				
			}else{
				logger.info("Total tests are less than 20.");
			}
			
			logger.info("Pagination Page is checked successfully.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public int totalTestsInDetailView(){
		int totalTests = 0;
		try{
			Assert.assertTrue(CommonUtil.isElementPresent("//*[@id='prev-next-return-container']/li[@class='previous prevnext-wrapper']"), "In Detail view total tests are not visible.");
			String totalTest = CommonUtil.getTextFromUIByXpath("//*[@id='prev-next-return-container']/li[@class='previous prevnext-wrapper']/span[1]");
			String[] tests = totalTest.split("of");
			totalTests = Integer.parseInt(tests[1].trim());
		}catch(Exception e){
			return totalTests;
		}
		return totalTests;
	}
	public int startTestsInDetailView(){
		int startTest = 0;
		try{
			CommonUtil.scrollPage(CommonUtil.returnWebElement("//*[@id='prev-next-return-container']/li[@class='previous prevnext-wrapper']"));
			Assert.assertTrue(CommonUtil.isElementPresent("//*[@id='prev-next-return-container']/li[@class='previous prevnext-wrapper']"), "In Detail view total tests are not visible.");
			String totalTest = CommonUtil.getTextFromUIByXpath("//*[@id='prev-next-return-container']/li[@class='previous prevnext-wrapper']/span[1]");
			String[] tests = totalTest.split("of");
			startTest = Integer.parseInt(tests[0].trim());
		}catch(Exception e){
			return startTest;
		}
		return startTest;
	}
	private boolean navigateUsingPrevAndNext(String navigateType){
		try{
			if (navigateType.equals("prev")){
				Assert.assertTrue(CommonUtil.navigateThroughXpath(".//*[@id='previous-execution']/span"), "Prev Execution link is not found.");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
				logger.info("Previous link is clicked successfully in Detail view Page.");
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			}else if(navigateType.equals("next")){
				Assert.assertTrue(CommonUtil.navigateThroughXpath("//*[@id='next-execution']/span"), "Next Execution link is not found.");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
				logger.info("Next link is clicked successfully in Detail view Page.");
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			}
		}catch(Exception e){
			return false;
		}
		return true;
	}
	private boolean validatePaginationPage(int page){
		//int pageNum  = 0;
		try{
			int	pageNum  = 1 + ((page-1)*20);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(startTestsInDetailView() == pageNum, "Pagination Page in Detail view is not validated successfully.");
			logger.info("Pagination page "+page+" is validated successfully");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	private boolean navigatePaginationPage(int page){
		try{
			String xpathForPage = "//a[@id='zql-pagination-"+(page-1)+"*20']";
			Assert.assertTrue(CommonUtil.navigateThroughXpath(xpathForPage),"Not clicked successfully in the page.");
			//Assert.assertTrue(startTestsInDetailView() == pageNum, "Pagination Page in Detail view is not validated successfully.");
			logger.info("Pagination page "+page+" is clicked successfully");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	private int currentPage(){
		int page = 0;
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String pageNum = CommonUtil.getTextFromUIByXpath("//*[@id='zqlPageId']/strong");
			page = Integer.parseInt(pageNum.trim());
		}catch(Exception e){
			return page;
		}
		return page;
	}
	private boolean columnDisplay(String colName, String typeDisplay){
		try{
			List<String> allShowCol = CommonUtil.getValues("//*[@id='column-items-selected']/li/label");
			List<String> allHideCol = CommonUtil.getValues("//*[@id='column-items-unselected']/li/label");
			if(typeDisplay.equals("show")){
				Assert.assertFalse(CommonUtil.searchTheTextInList("//*[@id='column-items-selected']/li/label", colName), "Searching... for column is showing or not.");
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-unselected']/li/label", colName), "After hiding column is still showing.");
				CommonUtil.clickOnElement("//*[@id='column-items-unselected']/li/label[text()='"+colName+"']/input");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-selected']/li/label", colName), "After hiding column is still showing.");
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-unselected']/li/label", colName), "After hiding column, Searching... for column is hiding or not.");
				logger.info(colName + " is showing successfully in column name.");
			}else if(typeDisplay.equals("hide")){
				//Assert.assertTrue(allHideCol.equals(null));
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-unselected']/li/label", colName), "After hiding column, Searching... for column is hiding or not.");
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-selected']/li/label", colName), "Searching... for column is showing or not.");
				CommonUtil.clickOnElement("//*[@id='column-items-selected']/li/label[text()='"+colName+"']/input");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
				Assert.assertFalse(CommonUtil.searchTheTextInList("//*[@id='column-items-selected']/li/label", colName), "After hiding column is still showing.");
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-unselected']/li/label", colName), "After hiding column, Searching... for column is hiding or not.");
				logger.info(colName + " is Hiding successfully from column name.");
			}
		}catch(Exception e){
			return false;
		}
		return true;
	}
	private boolean columnDisplays(String colName, String typeDisplay){
		try{
			int totalCol = CommonUtil.getSizeOfElements("//*[@id='issuetable']/thead/tr/th");
			logger.info("Total Columns :"+totalCol);
			if(typeDisplay.equals("show")){
				Assert.assertFalse(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", colName));
			}else if(typeDisplay.equals("hide")){
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", colName));
			}
			
			CommonUtil.navigateThroughXpath("//*[@id='column-selector']/button");
			Assert.assertTrue(CommonUtil.isElementDisplayed(CommonUtil.returnWebElement("//*[@id='inline-dialog-column-selector']/div[contains(@class,'contents')]")), "Column Show/hide popup is not diaplayed currently.");
			//Assert.assertTrue(columnDisplay("Cycle Name", "hide"),"Column is not hided successfully");
			
			
			//List<String> allShowCol = CommonUtil.getValues("//*[@id='column-items-selected']/li/label");
			//List<String> allHideCol = CommonUtil.getValues("//*[@id='column-items-unselected']/li/label");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			if(typeDisplay.equals("show")){
				Assert.assertFalse(CommonUtil.searchTheTextInList("//*[@id='column-items-selected']/li/label", colName), "Searching... for column is showing or not.");
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-unselected']/li/label", colName), "After hiding column is still showing.");
				CommonUtil.clickOnElement("//*[@id='column-items-unselected']/li/label[text()='"+colName+"']/input");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-selected']/li/label", colName), "After hiding column is still showing.");
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-unselected']/li/label", colName), "After hiding column, Searching... for column is hiding or not.");
				logger.info(colName + " is showing successfully in column name.");
			}else if(typeDisplay.equals("hide")){
				//Assert.assertTrue(allHideCol.equals(null));
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-unselected']/li/label", colName), "After hiding column, Searching... for column is hiding or not.");
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-selected']/li/label", colName), "Searching... for column is showing or not.");
				CommonUtil.clickOnElement("//*[@id='column-items-selected']/li/label[text()='"+colName+"']/input");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				Assert.assertFalse(CommonUtil.searchTheTextInList("//*[@id='column-items-selected']/li/label", colName), "After hiding column is still showing.");
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-unselected']/li/label", colName), "After hiding column, Searching... for column is hiding or not.");
				logger.info(colName + " is Hiding successfully from column name.");
			}
			
			CommonUtil.clickOnElement("//*[@id='column-dialog-save']");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			if(typeDisplay.equals("show")){
				Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", colName));
				int colAfterShow = CommonUtil.getSizeOfElements("//*[@id='issuetable']/thead/tr/th");
				Assert.assertTrue((colAfterShow-1) == totalCol,"Total Column size is not increasing after showing.");
			}else if(typeDisplay.equals("hide")){
				Assert.assertFalse(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", colName));
				int colAfterHide = CommonUtil.getSizeOfElements("//*[@id='issuetable']/thead/tr/th");
				Assert.assertTrue((colAfterHide+1) == totalCol,"Total Column size is not decreasing after showing.");
			}
				
			
			logger.info(colName+" is "+typeDisplay+" successfully.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	private boolean restoreDefualtsCol(){
		try{
			//Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='issuetable']/thead/tr/th", "Cycle Name"));
			CommonUtil.navigateThroughXpath("//*[@id='column-selector']/button");
			Assert.assertTrue(CommonUtil.isElementDisplayed(CommonUtil.returnWebElement("//*[@id='inline-dialog-column-selector']/div[contains(@class,'contents')]")), "Column show/hide popup is not diaplayed currently.");
			
			CommonUtil.clickOnElement("//*[@id='columns-restore-defaults']");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			//CommonUtil.refreshPage();
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	private boolean reorderColumn(String colOne, String colTwo){
		try{
			int headerOneBefore = returnHeaderNum(colOne);
			int headerTwoBefore = returnHeaderNum(colTwo);
			
			CommonUtil.navigateThroughXpath("//*[@id='column-selector']/button");
			Assert.assertTrue(CommonUtil.isElementDisplayed(CommonUtil.returnWebElement("//*[@id='inline-dialog-column-selector']/div[contains(@class,'contents')]")), "Column show/hide popup is not diaplayed currently.");
			Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-selected']/li/label", colOne), colOne+" is searching");
			Assert.assertTrue(CommonUtil.searchTheTextInList("//*[@id='column-items-selected']/li/label", colTwo), colTwo+" is searching");
			
			//CommonUtil.returnWebElement("//*[@id='column-items-selected']/li[label[text()='"+colOne+"']]/span");
			WebElement dragSrc = CommonUtil.returnWebElement("//*[@id='column-items-selected']/li[label[text()='"+colOne+"']]/span");
			WebElement dropSrc = CommonUtil.returnWebElement("//*[@id='column-items-selected']/li[label[text()='"+colTwo+"']]/span");
			//CommonUtil.actionClass().dragAndDrop(dragSrc,dropSrc).build().perform();
			//CommonUtil.actionClass().clickAndHold(dragSrc).moveToElement(dropSrc).release(dropSrc).perform();
			CommonUtil.actionClass().dragAndDrop(dragSrc, dropSrc).build().perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CommonUtil.clickOnElement("//*[@id='column-dialog-save']");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info("Drag and drop successfully.");
			int headerOneAfter = returnHeaderNum(colOne);
			int headerTwoAfter = returnHeaderNum(colTwo);
			Assert.assertTrue(headerTwoBefore == headerOneAfter,"Column place is not same after restoring.");
			//Assert.assertTrue(headerOneBefore+1 == headerTwoAfter,"");
			logger.info("validated after column drag and drop.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean deleteAllFilters(){
		try{
			if(CommonUtil.isElementPresent("//*[@id='executionFilterId']/li")){
			
			List<WebElement> listOfElements = CommonUtil.returnWebElementsFromXpath("//*[@id='executionFilterId']/li");
			for(int i=1; i<=listOfElements.size();i++){
				CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement("//*[@id='executionFilterId']/li[1]")).perform();
				String actions = "//*[@id='executionFilterId']/li[1]/a[@class='filter-actions']";
				CommonUtil.navigateThroughXpath(actions);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.navigateThroughXpath(".//*[contains(@id,'zfj-filter-delete')]");
				CommonUtil.visibilityOfElementLocated(".//*[@id='remove-zql-filter-id']");
				CommonUtil.navigateThroughXpath(".//*[@id='zql-filter-delete-form-submit']");
				//CommonUtil.visibilityOfElementLocated("//*[@class='aui-message success closeable']");
				//logger.info(CommonUtil.getTextFromUIByXpath("//*[@class='aui-message success closeable']"));
				logger.info("Filter "+i+" deleted successfully.");
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			}
			logger.info("Filters are deleted successfully.");
			}else{
				logger.info("Filters are deleted successfully.");
			}
		}catch(Exception e){
			return false;
		}
		return true;
	}
	//Regression
	public boolean bulkMoveTestToCycle(String oldCycle,String projectName, String version, String cycle,int totalTest){
		try{
			//selectAndValidatePredefinedFilters("All Executed Tests");
			//allExecutedTests.click();
			String zqlQueryOne = returnzqlQueryForCycle(projectName, version, cycle);
			Assert.assertNotNull(zqlQueryOne, "Zql Query for cycle returning Null value.");
			Assert.assertTrue(executeZQLQuery(zqlQueryOne), "Query is not executed.");
			int totalTestsBeforeMoveInCycleOne = totalTests();
			String zqlQueryTwo = returnzqlQueryForCycle(projectName, version, oldCycle);
			Assert.assertNotNull(zqlQueryTwo, "Zql Query for cycle returning Null value.");
			Assert.assertTrue(executeZQLQuery(zqlQueryTwo), "Query is not executed.");
			int totalTestsBeforeMoveCycleTwo = totalTests();
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> tests=getIdsOfTestSelected(totalTest);
			Assert.assertTrue(tests.size()== totalTest, "Issue size is not same.");
			Map<String, List<String>> issueDetailsBeforeMove = new HashMap<String, List<String>>();
			issueDetailsBeforeMove.put("PROJ_DETAILS", getColDetails(tests, "Project Name"));
			issueDetailsBeforeMove.put("CYCLE_DETAILS", getColDetails(tests, "Cycle Name"));
			issueDetailsBeforeMove.put("VERSION_DETAILS", getColDetails(tests, "Version"));
			issueDetailsBeforeMove.put("EXECSTATUS_DETAILS", getColDetails(tests, "Execution Status"));
			/*Map<String , Map<String, String>> issueDetailsBeforeMove = new HashMap<String, Map<String, String>>();
			for(int i=1; i<= tests.size(); i++){
				Map<String , String> issues = getissueDetails(tests.get(i));
				issueDetailsBeforeMove.put("ISSUE_"+i, issues);
				issues.clear();
			}*/
			Assert.assertTrue(navigateToBulkMoveToCyclePage().bulkMoveToCycle(projectName, version, cycle, totalTest), "Bulk Move is not successsful.");
			
			CommonUtil.refreshPage();
			Assert.assertTrue(executeZQLQuery(zqlQueryTwo), "Query is not executed.");
			int totalTestsAfterMoveCycleTwo = totalTests();
			Assert.assertTrue((totalTestsBeforeMoveCycleTwo - totalTest) == totalTestsAfterMoveCycleTwo, "After bulk move tests number count is not matching.");
			logger.info("After bulk move tests number count is matching.");
			
			Assert.assertTrue(executeZQLQuery(zqlQueryOne), "Query is not executed.");
			int totalTestsAfterMoveInCycleOne = totalTests();
			Assert.assertTrue((totalTestsBeforeMoveInCycleOne + totalTest) == totalTestsAfterMoveInCycleOne, "After bulk move tests number count is matching.");
			logger.info("After bulk move tests number count is matching.");
			
			Map<String, List<String>> issueDetailsAfterMove = new HashMap<String, List<String>>();
			issueDetailsAfterMove.put("PROJ_DETAILS", getColDetails(tests, "Project Name"));
			issueDetailsAfterMove.put("CYCLE_DETAILS", getColDetails(tests, "Cycle Name"));
			issueDetailsAfterMove.put("VERSION_DETAILS", getColDetails(tests, "Version"));
			issueDetailsAfterMove.put("EXECSTATUS_DETAILS", getColDetails(tests, "Execution Status"));
			
			Assert.assertTrue(issueDetailsBeforeMove.get("PROJ_DETAILS").contains(issueDetailsAfterMove.get("PROJ_DETAILS")), "Project details are not matching.");
			Assert.assertTrue(issueDetailsBeforeMove.get("VERSION_DETAILS").contains(issueDetailsAfterMove.get("VERSION_DETAILS")), "Version details are not matching.");
			Assert.assertFalse(issueDetailsBeforeMove.get("CYCLE_DETAILS").contains(issueDetailsAfterMove.get("CYCLE_DETAILS")), "Cycle details are not matching.");
			Assert.assertFalse(issueDetailsBeforeMove.get("EXECSTATUS_DETAILS").contains(issueDetailsAfterMove.get("EXECSTATUS_DETAILS")), "Execution Status details are not matching.");
			Assert.assertTrue(issueDetailsAfterMove.get("CYCLE_DETAILS").contains(cycle), "Cycle details are matching.");
			
			logger.info("Bulk Execution is moved successful.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	private String returnzqlQueryForCycle(String projName,  String versionName, String cycleName){
		String zqlQuery = null;
		try{
			zqlQuery = "project = \""+projName+"\" AND fixVersion = \""+versionName+"\" AND cycleName in (\""+cycleName+"\")";
			return zqlQuery;
		}catch(Exception e){
			return zqlQuery;
		}
	}
	private List<String> getColDetails(List<String> issues, String colName){
		try{
			List<String> colDetails = new ArrayList<String>();
			if(colName.equals("Cycle Nmae")){
				int cycleColNum = returnHeaderNum("Cycle Name");
				for(int i=0; i<issues.size(); i++){
					String cycleName = CommonUtil.getTextFromUIByXpath("//tr[td[a[text()='"+issues.get(i)+"']]]/td["+cycleColNum+"]");
					colDetails.add(cycleName);
				}
				
			}else if (colName.equals("Project Name")) {
				int projectColNum = returnHeaderNum("Project Name");
				for(int i=0; i<issues.size(); i++){
					String cycleName = CommonUtil.getTextFromUIByXpath("//tr[td[a[text()='"+issues.get(i)+"']]]/td["+projectColNum+"]");
					colDetails.add(cycleName);
				}
			}else if (colName.equals("Version")) {
				int versionColNum = returnHeaderNum("Version");
				for(int i=0; i<issues.size(); i++){
					String cycleName = CommonUtil.getTextFromUIByXpath("//tr[td[a[text()='"+issues.get(i)+"']]]/td["+versionColNum+"]");
					colDetails.add(cycleName);
				}
				
			}else if (colName.equals("Execution Status")){
				int issueStatusColBum = returnHeaderNum("Execution Status");
				for(int i=0; i<issues.size(); i++){
					String cycleName = CommonUtil.getTextFromUIByXpath("//tr[td[a[text()='"+issues.get(i)+"']]]/td["+issueStatusColBum+"]");
					colDetails.add(cycleName);
				}
			}
			
			return colDetails;
		}catch(Exception e){
			return null;
		}
	}
	private Map<String , String> getissueDetails(String issueKey, String colName){
		try{
			Map<String , String> issueDetails = new HashMap<String, String>();
			int cycleColNum = returnHeaderNum("Cycle Nmae");
			int versionColNum = returnHeaderNum("Issue Key");
			int issueStatusColBum = returnHeaderNum("Issue Key");
			String cycleName = CommonUtil.getTextFromUIByXpath("//tr[td[a[text()='"+issueKey+"']]]/td["+cycleColNum+"]");
			issueDetails.put("CYCLE_Name", cycleName);
			String versionName = CommonUtil.getTextFromUIByXpath("//tr[td[a[text()='"+issueKey+"']]]/td["+versionColNum+"]");
			issueDetails.put("VERSION_NAME", versionName);
			String issueStatus = CommonUtil.getTextFromUIByXpath("//tr[td[a[text()='"+issueKey+"']]]/td["+issueStatusColBum+"]");
			issueDetails.put("ISSUE_STATUS", issueStatus);
			return issueDetails;
		}catch(Exception e){
			return null;
		}
	}
}
