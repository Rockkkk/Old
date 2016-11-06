package com.thed.zfjbvt.zfj.impl.zfj21;

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
	@FindBy(xpath="//*[@id='displayDetailId']/div/span/span[3]")
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
	@FindBy(xpath="//div[@id='displayDetailId']/div/span/span[@class='results-count-total results-count-link']")
	private WebElement xpathForTotalTests;
	
	// xpath for fixedversion column in issue table.
	@FindBy(xpath="//table[@id='issuetable']/tbody/tr/td[7]/a")
	private List<WebElement> xpathForFixedVersionColumn;
	
	// xpath for component column in issue table.
	@FindBy(xpath="//table[@id='issuetable']/tbody/tr/td[6]/a")
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
	@FindBy(xpath="//div[@id='displayDetailId']/div/span/a[@id='refreshZQLId']")
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
			selectAndValidatePredefinedFilters("All Executed Tests");
			Assert.assertTrue(totalTest<=(Integer.parseInt(totalTestExecuted.getText())),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> tests= getIdsOfTestSelected(totalTest);
			navigateToBulkChangeStatusPage().validateBulkChangeStatusPage();
			BulkChangeStatusPage.getInstance().changeStatus(status);
			validateIdsOfTestsSelected(tests, totalTest);
			validateStatusChange(status,totalTest);
			
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
			selectAndValidatePredefinedFilters("All Unexecuted Tests");
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
			selectAndValidatePredefinedFilters("All Executed Tests");
			refreshPage();
			validateIdsOfTestsSelected(tests, totalTest);
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			validateStatusChange(testStatus,totalTest);
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
				allExecutedTests.click();
				CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td[12]/a").click();
				Assert.assertTrue(ExecuteTestsPage.getInstance().validateTestStepStatus(teststepStatus),"Validating teststep status change Failed...");
				
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean bulkAssociateDefect(int totalTest){
		String issueId;
		try{
			selectAndValidatePredefinedFilters("All Executed Tests");
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> test=getIdsOfTestSelected(totalTest);
			navigateToBlukAssociateDefectPage().validateBulkAssociateDefectPage();
			issueId=BlukAssociateDefectPage.getInstance().associateDefect();
			Assert.assertNotNull(issueId, "Defect Assocition Failed...");
			Assert.assertTrue(validateIdsOfTestsSelected(test, totalTest));
			Assert.assertTrue(validateBulkAssociateDefects(issueId,totalTest),"Validation of Bluk Associate Defect Failed...");
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
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			navigateToBulkChangeStatusPage().validateBulkChangeStatusPage();
			BulkChangeStatusPage.getInstance().clearDefect(status);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			selectAndValidatePredefinedFilters("All Unexecuted Tests");
			validateClearedDefect(totalTest);
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean bulkMoveTestToCycle(String version, String cycle,int totalTest){
		try{
			selectAndValidatePredefinedFilters("All Executed Tests");
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> testId=getIdsOfTestSelected(totalTest);
			getStatusOfTestSelected(totalTest);
			getCyclesOfTestSelected(totalTest);
			navigateToBulkMoveToCyclePage().validateBulkMoveToCyclePage();
			BulkMoveToCyclePage.getInstance().moveBulkTestToCycle(version, cycle);
			selectAndValidatePredefinedFilters("All Unexecuted Tests");
			refreshPage();
			validateTestChanged(testId, totalTest);
			validateCycleChange(cycle, totalTest,testId);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean bulkCopyTestToCycle(String version, String cycle,int totalTest){
		try{
			selectAndValidatePredefinedFilters("All Executed Tests");
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> testId=getIdsOfTestSelected(totalTest);
			getStatusOfTestSelected(totalTest);
			getCyclesOfTestSelected(totalTest);
			navigateToBulkCopyToCyclePage().validateBulkCopyToCyclePage();
			BulkCopyToCyclePage.getInstance().copyBulkTestToCycle(version, cycle);
			selectAndValidatePredefinedFilters("All Unexecuted Tests");
			refreshPage();
			validateTestChanged(testId, totalTest);
			validateCycleChange(cycle, totalTest,testId);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean bulkMoveTestToCycleWithDefects(String version, String cycle,int totalTest){
		try{
			selectAndValidatePredefinedFilters("All Executed Tests");
			Assert.assertTrue(totalTest<=(totalTests()),"Total Test executed is less than the totalTest selected...");
			Assert.assertTrue(selectTests(totalTest),"Tests Not Selected...");
			List<String> test=getIdsOfTestSelected(totalTest);
			getCyclesOfTestSelected(totalTest);
			navigateToBulkMoveToCyclePage().validateBulkMoveToCyclePage();
			BulkMoveToCyclePage.getInstance().moveBulkTestToCycleWithDefects(version, cycle);
			refreshPage();
			validateIdsOfTestsSelected(test, totalTest);
			validateCycleChange(cycle, totalTest, test);
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
			List<String> test=getIdsOfTestSelected(totalTest);
			getCyclesOfTestSelected(totalTest);
			navigateToBulkCopyToCyclePage().validateBulkCopyToCyclePage();
			BulkCopyToCyclePage.getInstance().copyBulkTestToCycleWithDefects(version, cycle);
			refreshPage();
			validateIdsOfTestsSelected(test, totalTest);
			validateCycleChange(cycle, totalTest,test);
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
		}catch(Exception e){
			e.printStackTrace();
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
	
	
	public boolean validateStatusChange(String status,int totalTests){
		try{
			
			for(int i=1;i<=totalTests;i++){
				String getStatus=CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-exec-status']]]]/tbody/tr["+i+"]/td[8]//dd").getText();
				Assert.assertEquals(status, getStatus,"Status Validation Failed...");
				
			}
			logger.info("Bulk Stauts Changed Successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateBulkAssociateDefects(String issueId,int totalTest){
		try{
			for(int i=1; i<=totalTest;i++){
				CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td[12]/a").click();
				Assert.assertTrue(ExecuteTestsPage.getInstance().validateDefectAdded(issueId),"Adding of Defect to test Failed...");
				allExecutedTests.click();
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateClearedDefect(int totalTest){
		try{
			for(int i=1; i<=totalTest;i++){
				CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td[12]/a").click();
				Assert.assertTrue(ExecuteTestsPage.getInstance().validateClearedDefects(),"Cleairng of Defect to test Failed...");
				allUnexecutedTests.click();
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean validateCycleChange(String cycle, int totalTests, List<String> tests){
try{
	for(int i=0;i<totalTests;i++){
		String getCycle=getCycleOfGivenTest(tests.get(i));
		Assert.assertEquals(cycle, getCycle,"Cycle Validation Failed...");
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

			xpathForRefreshLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String loginUserName=xpathForUserName.getAttribute("data-username");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);

			if(filterName.equals("My Executed Tests")){
				Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "data-query"),"executionStatus != \"UNEXECUTED\" AND executedBy = "+loginUserName+"", "Not showing the result of "+filterName+".");
				logger.info(filterName+" results are showing.");
				logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
				Assert.assertFalse(CommonUtil.searchTheTextInList(allCurrentExecStatus, "UNEXECUTED"), "UNEXECUTED is found in this current execution status.");
				logger.info(filterName+" is verified successfully.");
				
			}else if (filterName.equals("My Failed Executions")) {
				Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "data-query"),"executionStatus = \"FAIL\" AND executedBy = "+loginUserName+"", "Not showing the result of "+filterName+".");
				logger.info(filterName+" filter results are showing.");
				logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
				Assert.assertTrue(CommonUtil.searchTextInList(allCurrentExecStatus, "FAIL"), "FAIL is not found in this current execution status.");
				logger.info(filterName+" is verified successfully.");
				
			}else if (filterName.equals("All Unexecuted Tests")) {
				Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "data-query"),"executionStatus = \"UNEXECUTED\"", "Not showing the result of "+filterName+".");
				logger.info(filterName+" filter results are showing.");
				logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
				Assert.assertTrue(CommonUtil.searchTextInList(allCurrentExecStatus, "UNEXECUTED"), "UNEXECUTED is not found in this current execution status.");
				logger.info(filterName+" is verified successfully.");
				
			}else if (filterName.equals("All Executed Tests")) {
				Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "data-query"),"executionStatus != \"UNEXECUTED\"", "Not showing the result of "+filterName+".");
				logger.info(filterName+" filter results are showing.");
				logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
				Assert.assertFalse(CommonUtil.searchTheTextInList(allCurrentExecStatus, "UNEXECUTED"), "UNEXECUTED is found in this current execution status.");
				logger.info(filterName+" is verified successfully.");
				
			}else if (filterName.equals("All Failed Executions")) {
				Assert.assertEquals(CommonUtil.getAttributeValueUsingWebElements(zqlSearchTextbox, "data-query"),"executionStatus = \"FAIL\"", "Not showing the result of "+filterName+".");
				logger.info(filterName+" filter results are showing.");
				logger.info("Total Number of tests present in "+filterName+" : "+totalTests());
				Assert.assertTrue(CommonUtil.searchTextInList(allCurrentExecStatus, "FAIL"), "FAIL is not found in this current execution status.");
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
			Assert.assertTrue(CommonUtil.searchTextInList(xpathForFixedVersionColumn, fixVersionName), "This ZQL Query is not giving the correct result.");
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
			Assert.assertTrue(CommonUtil.searchTextInList(xpathForComponentColumn, componentName), "This ZQL Query is not giving the correct result.");
			logger.info("ZQL Query for component is executed successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executeZQLQuery(String ZQLQuery){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			//zqlSearchTextbox.clear();
			zqlSearchTextbox.sendKeys(ZQLQuery);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			zqlSubmitBtn.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			logger.info("Total Number of tests present for fixed version : "+totalTests());
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
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			logger.info("Gave filtername.");
			CommonUtil.actionClass().sendKeys(Keys.TAB, Keys.RETURN).build().perform();
			
			/*//CommonUtil.actionClass().moveToElement(searchExecFilterExecuteBtn).build().perform();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			System.out.println(searchExecFilterExecuteBtn.isDisplayed());
			searchExecFilterExecuteBtn.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			logger.info("Clicked on execute link.");*/
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			
			Assert.assertTrue(zqlSearchTextbox.getAttribute("filterid").equals(filterName), "Filter is not verified.");
			logger.info("Filter is verified.");
			
			Assert.assertNotNull(zqlSearchTextbox.getAttribute("data-query"), "TextBox contains some query.");
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
	public boolean exportTestExecutions(String filterName,String projectName, String versionName, String cycleName, String testOne, String testTwo, String totalTestsToExport, String totalTestStep){
		try{
			FileUtils.cleanDirectory(new File(Config.getValue("EXPORT_FILE_PATH")));
			logger.info("All files are deleted.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(validateSearchTestExecutionPage(),"Not validated Search Test Execution Page.");
			logger.info("Search Test executions page is validated successfully.");
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterName), "Filter is not executed.");
			logger.info("Query is executed and showing the result.");
			int totalTests=totalTests();
			
			List<String> list=CommonUtil.getValues("//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/a[contains(text(),'ZFJ-')]");
			if( totalTestsToExport.equals("1")){
				//String xpath="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/preceding-sibling::td/input";
				String xpathForTest="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+list.get(0)+"']]/preceding-sibling::td/input[@type='checkbox']";
				CommonUtil.clickOnElement(xpathForTest);
				logger.info("Selected a particular test and select check box for exporting.");
			}else if(totalTestsToExport.equals("2")){
				String xpathForTestOne="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+list.get(0)+"']]/preceding-sibling::td/input[@type='checkbox']";
				CommonUtil.clickOnElement(xpathForTestOne);
				String xpathForTestTwo="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+list.get(1)+"']]/preceding-sibling::td/input[@type='checkbox']";
				CommonUtil.clickOnElement(xpathForTestTwo);
				logger.info("Selected two particular tests and select check box for exporting.");
			}
			/*if( totalTestsToExport.equals("1")){
				String xpath=
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
					System.out.println(d);
					if(d != 0){
						System.out.println("File is present and file lengthis"+d);
					}else{
						System.out.println("File is not present.");
					}
			  }
			  logger.info("File is validated successfully in local system.");
			  Assert.assertTrue(validateExportedData(fileName, filterName, projectName, versionName, cycleName, list.get(0), list.get(1), totalTestsToExport, totalTestStep), "Header part is not validated after exporting.");
			  logger.info("Header part is validated successfully.");
			  
			  
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean validateExportedData(String fileName, String filterName, String projectName, String versionName, String cycleName, String testOne, String testTwo, String totalTestsToExport, String totalTestStep){
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
				Assert.assertTrue(setFirstRowData.containsAll(testDataFromUI), "UI Test Details are not matching in excel.");
				logger.info("UI Test Details are matching after exporting to excel.");
				
				String xpathForExecutionButton="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/a[text()='E']";
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
				Assert.assertTrue(selectAndValidatePredefinedFilters(filterName), "Filter is not executed.");
				logger.info("Query is executed and showing the result.");
				
			}
			
			logger.info("Exported data validated successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
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
			Assert.assertTrue(column.size() == 18, "Header size is not 18");
			for(int i=0; i<column.size(); i++){
				String rowData=row.select("th").get(i).toString();
				String[] splitColumnData=rowData.split(">", 2);
				//System.out.println(x1[0]+" "+x1[1]);
				String[] columnData=splitColumnData[1].split("</");
				System.out.println(columnData[0]);
				set.add(columnData[0]);
			}
			for(int i=0; i<xpathForIssueTableHeaders.size(); i++){
				if(xpathForIssueTableHeaders.get(i).getText().equals(null) || xpathForIssueTableHeaders.get(i).getText().equals("") || xpathForIssueTableHeaders.get(i).getText().equals(" ")){
					continue;
				}else if (xpathForIssueTableHeaders.get(i).getText().contains("Cycle") ||  xpathForIssueTableHeaders.get(i).getText().contains("Issue") || xpathForIssueTableHeaders.get(i).getText().contains("Project") ){
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
			
			List<WebElement> list=Driver.driver.findElements(By.xpath(xpathForRowDataFromUI));
			for(int l=0; l<list.size(); l++){
				if(list.get(l).getText().equals(null) || list.get(l).getText().equals("") || list.get(l).getText().equals(" ") || list.get(l).getText().equals("E")){
					continue;
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
					testStepFromUI.add(X);
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
				//System.out.println(x2[0]);
				//set.add(x2[0]);
				if(x2[0].equals(" ") || x2[0].equals("")){	
				}else{
					set.add(x2[0]);
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
					setRowData.add(x2[0]);
				}
			} else {
				String[] x1=x.split(">", 2);
				String[] x2=x1[1].split("</");
				//System.out.println(x2[0]);
				//setRowData.add(x2[0]);
				if(x2[0].equals(" ") || x2[0].equals("")){
				}else{
					setRowData.add(x2[0]);
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
			/*List<Map<String, String>> list=new ArrayList<Map<String,String>>();
			for(int i=0;i<Integer.parseInt(numberOfExec);i++){
				
				Map<String, String> values= new HashMap<String, String>();
				values.put("PROJECT_NAME", "v1");
				values.put("CYCLE_NAME", "abc");
				values.put("VERSION_NAME", "v1");
				values.put("ISSUE_KEY", "v1");
				list.add(values);
			}
			loop
			list.get(0).get*/
			for(int i=0;i<Integer.parseInt(numberOfExec);i++){
				xpathForAllCheckBoxInIssueTableTest.get(i).click();
			}
			logger.info("Selected "+numberOfExec+" of tests for deletion.");
			
			Assert.assertTrue(clickOnDeleteLink(), "Not clicked on delete link.");
			logger.info("Clicked on delete link.");
			if(CommonUtil.visibilityOfElementLocated("//div[@id='execution-delete-dialog']")){
				confirmationDeleteButton.click();
				//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);

				if(CommonUtil.visibilityOfElementLocated("//div[@id='warning-message-dialog']")){
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
			throw e;
		}
		return totalTests;
	}

	public boolean executeTestFromExecutionNavigator(String filterNameOne, String filterNameTwo, String projectName,String versionName,String cycleName, String testName, String testExecStatus){
		try{
			
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameOne), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			int totalTestsExecuted=totalTests();
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameTwo), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			int totalTestsUnexecuted=totalTests();
			
			String xpathForSelectTest="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td/a[text()='"+testName+"']";
			CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForSelectTest)).build().perform();
			logger.info("Hovering to test cycle properly.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String xpathForExecutionButton="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/a[text()='E']";
			CommonUtil.navigateThroughXpath(xpathForExecutionButton);
			logger.info("Navigated to Execute Tests page.");
			
			Map<String, String> returnValues=ExecuteTestsPage.getInstance().changeTestExcutionStatusOnly(testExecStatus);
			
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameTwo), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			int totalTestsUnexecutedAfterExec=totalTests();
			Assert.assertTrue((totalTestsUnexecutedAfterExec + 1 == totalTestsUnexecuted), "Total tests are not decresing by one.");
			logger.info("Total unexecuted tests decresed by one after execution.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameOne), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			int totalTestsExecutedAfterExec=totalTests();
			Assert.assertTrue((totalTestsExecuted +  1 == totalTestsExecutedAfterExec), "Total tests are not incresed by one after execution.");
			logger.info("Total tests are incresed by one after execution.");
			
			String xpathForCurrentExecStatus="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/div/dl/dd[contains(@id,'current-execution-status-dd-schedule-')]";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForCurrentExecStatus).equals(testExecStatus), testExecStatus+" is not matched in this page.");
			logger.info(testExecStatus+" is is validated successfully for "+testName+".");
			
			String xpathForExecutedBy="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td[6]/a";
			System.out.println(CommonUtil.getTextFromUIByXpath(xpathForExecutedBy)+" : "+returnValues.get("executedUser"));
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForExecutedBy).equals(returnValues.get("executedUser")), "Executed by is not matching after execution.");
			logger.info("Executed by is validated successfully.");
			
			String xpathForExecutedOn="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td[7]";
			Assert.assertNotNull(CommonUtil.getTextFromUIByXpath(xpathForExecutedOn), "Executed on is not there.");
			logger.info("Executed on is validated successfully.");
			//Assert.assertTrue(PlanTestCyclePage.getInstance().executeTestAndValidate(versionName, cycleName, testName, testExecStatus),"Test is not executed successfully.");
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean executeTestDirectlyFromExecutionNavigator(String filterNameOne, String filterNameTwo, String projectName,String versionName,String cycleName, String testName, String testExecStatus){
		try{
			Assert.assertTrue(validateSearchTestExecutionPage(),"Not validated Search Test Execution Page.");
			logger.info("Search Test executions page is validated successfully.");
			
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameOne), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			int totalTestsExecuted=totalTests();
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameTwo), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			int totalTestsUnexecuted=totalTests();
			
			//Assert.assertTrue(selectAndValidatePredefinedFilters(filterName), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String xpathForStatusLabel="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/div/dl/a[contains(@id,'executionStatus-labels-schedule-')]";
			CommonUtil.navigateThroughXpath(xpathForStatusLabel);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			String xpathForSelectStatusList="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/div/select[contains(@id,'exec_status-schedule-')]";
			CommonUtil.selectListWithVisibleText(CommonUtil.returnWebElement(xpathForSelectStatusList), testExecStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			searchHeader.click();
			CommonUtil.visibilityOfElementLocated("//*[@id='aui-message-bar']/div");
			logger.info("Test is executed successfully.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			int totalTestsUnexecutedAfterExec=totalTests();
			Assert.assertTrue((totalTestsUnexecutedAfterExec + 1 == totalTestsUnexecuted), "Total tests are not decresing by one.");
			logger.info("Total unexecuted tests decresed by one after execution.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			Assert.assertTrue(selectAndValidatePredefinedFilters(filterNameOne), "Filter is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			int totalTestsExecutedAfterExec=totalTests();
			Assert.assertTrue((totalTestsExecuted +  1 == totalTestsExecutedAfterExec), "Total tests are not incresed by one after execution.");
			logger.info("Total tests are incresed by one after execution.");
			
			String xpathForCurrentExecStatus="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td/div/dl/dd[contains(@id,'current-execution-status-dd-schedule-')]";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForCurrentExecStatus).equals(testExecStatus), "Test Execution status s not changed in execution navigator.");
			logger.info("Test Execution status is validated successfully in execution navigator.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			String xpathForExecutedBy="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td[6]/a";
			Assert.assertNotNull(CommonUtil.getTextFromUIByXpath(xpathForExecutedBy), "Executed by is not present after execution.");
			logger.info("Executed by is validated successfully.");
			
			String xpathForExecutedOn="//table[@id='issuetable']/tbody/tr/td[a[@title='"+projectName+"']]/following-sibling::td[a[text()='"+versionName+"']]/preceding-sibling::td[a[text()='"+cycleName+"']]/following-sibling::td[a[text()='"+testName+"']]/following-sibling::td[7]";
			Assert.assertNotNull(CommonUtil.getTextFromUIByXpath(xpathForExecutedOn), "Executed on is not present after execution.");
			logger.info("Executed on is validated successfully.");
			
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public boolean validateTestChanged(List<String>testId, int totalTest){
		try{
			for(int i=0;i<totalTest;i++){
				Assert.assertTrue(CommonUtil.searchTheTextInList(listOfTest,testId.get(i)),"Copying Tests Failed...");
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

	
	private boolean clickBulkChangeTool(){
		try{
			xpathOfTool.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(bulkChangeOptions.isDisplayed());
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
			for(int i=1;i<=totalTest;i++){
				String test= CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td[3]/a").getText();
				logger.info(test);
				testIdsSelected.add(test);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return testIdsSelected;
			
		}
		return testIdsSelected;
	}
	
	private boolean validateIdsOfTestsSelected(List<String> tests,int totalTest){
		try{
			logger.info("Tests on which bluk operations is performed: ");
			for(int i=1;i<=totalTest;i++){
				String getTest=tests.get((i-1));
				String test= CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td[3]/a").getText();
				Assert.assertTrue(getTest.equals(test),"Same Test not selected...");
				logger.info(test);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private List<String> getCyclesOfTestSelected(int totalTest){
		List<String> testCyclesSelected = new ArrayList<String>();
		try{
			logger.info("Cycles Selected to do bluk operations are: ");
			for(int i=1;i<=totalTest;i++){
				String cycle= CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td[2]/a").getText();
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
	
	private List<String> getStatusOfTestSelected(int totalTest){
		List<String> testStatusSelected = new ArrayList<String>();
		try{
			logger.info("Statuses Selected to do bluk operations are: ");
			for(int i=1;i<=totalTest;i++){
				String status= CommonUtil.changeToWebElement("//table[thead[tr[th[@id='headerrow-id-select_executions']]]]/tbody[@id='resultBodyId']/tr["+i+"]/td[8]//dd").getText();
				logger.info(status);
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
		String cycle=null;
		try{
			cycle=CommonUtil.changeToWebElement("//td[a[text()='"+test+"']]/preceding-sibling::td[1]/a").getText();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return cycle;
		
	}
	@FindBy(xpath="//table[@id='issuetable']/thead/tr/th")
	private List<WebElement> xpathForAllHeaders;
	private Integer returnHeaderColNum(String headerColName){
		//String xpathForHeader="//table[@id='issuetable']/thead/tr/th[text()='Cycle Name']";
		int colNum=0;
		for(int i=0; i < xpathForAllHeaders.size() ; i++){
			if(xpathForAllHeaders.get(i).equals(headerColName)){
				colNum=i+1;
				break;
			} /*else {
				colNum++;
			}*/
		}
		return colNum;
	}
}
