package com.thed.zfjbvt.zfj.impl.zfj25;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj25.ViewTestPage;

public class SearchTestsPage {
	private Logger logger = Logger.getLogger(this.getClass());
	public static SearchTestsPage getInstance() {
		SearchTestsPage page = PageFactory.initElements(Driver.driver, SearchTestsPage.class);
		return page;
	}
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//Xpath to get the first test in the Search Test Page.
	@FindBy(xpath="//table[@id='issuetable']/tbody//tr[1]/td[2]/a")
	private WebElement xpathForGettingTheFirstTest;
	
	//Xpath to get the summary of the first test in the search test page.
	@FindBy(xpath="//table[@id='issuetable']/tbody//tr[1]/td[3]//a")
	private WebElement xpathForGettingTestSummary;
	
	//Xpath to get the Assignee for the first test in search test page.
	@FindBy(xpath="//table[@id='issuetable']/tbody//tr[1]/td[4]")
	private WebElement xpathForGettingAssignee;
	
	//Xpath to get the Reporter for the first test in search test page.
	@FindBy(xpath="//table[@id='issuetable']/tbody//tr[1]/td[5]//a")
	private WebElement xpathForGettingReporter;
	
	//Xpath to get the priority for the first test in search test page.
	@FindBy(xpath="//table[@id='issuetable']/tbody//tr[1]/td[6]/img")
	private WebElement xpathForGettingPriority;
	
	//id for quick search input in search test page.
	@FindBy(id="quickSearchInput")
	private WebElement xpathToQuickSearchTest;
	
	//Xpath to get the total test matching the number of test from test summary.
	@FindBy(xpath="(//span[@class='results-count-total results-count-link'])[1]")
	private WebElement xpathToValidateTotalTest;
	
	//id of the view link in Issue navigator.
	@FindBy(xpath="//*[@class='aui-dd-parent'][1]/a/span")
	private WebElement exportlink;
	
	//id to export all fields of test into excel
	@FindBy(id="allExcelFields")
	private WebElement xpathToExportAllFields;
	
	
	//xpath to get the total number of test created.
	@FindBy(xpath="//*[@class='results-count-total results-count-link']")
	private WebElement xpathToGetTotalTestCreated;
	
	//xpath to get the created date of the first test.
	@FindBy(xpath="//table[@id='issuetable']/tbody//tr[1]/td[9]/span")
	private WebElement xpathToGetCreatedDate;
	
	//xpath to get updated date of first test.
	@FindBy(xpath="//table[@id='issuetable']/tbody//tr[1]/td[10]/span")
	private WebElement xpathToGetUpdatedDate;
	
	@FindBy(xpath="//div[@id='search-header-view']/div/ul/li/a[@class='aui-button save-as-new-filter']")
	private WebElement saveAsFilterButton;
	
	
	@FindBy(linkText="Refresh")
	private List<WebElement> refreshLink;
	
	
	@FindBy(xpath="//*[text()='Save as']")
	private WebElement saveAsFilterLink;
	
	@FindBy(xpath="//div[@id='save-filter-dialog']/descendant::h2")
	private WebElement saveAsFilterHeaderText;
	
	@FindBy(id="filterName")
	private WebElement saveAsFilterNameTextBox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Submit' ]")
	private WebElement saveAsFilterSubmitButton;
		
	@FindBy(xpath="//div[@id='search-header-view']/div/h1[@title='Search']")
	private WebElement searchText;
	
	@FindBy(linkText="New filter")
	private WebElement newFilterLink;
	
	@FindBy(linkText="Find filters")
	private WebElement findFilterLink;
	
	@FindBy(linkText="My Open Issues")
	private WebElement myOpenIssuesLink;
		
	@FindBy(linkText="Reported by Me")
	private WebElement reportedByMeLink;
	
	
	@FindBy(linkText="Recently Viewed")
	private WebElement recentlyViewedLink;
	
	
	@FindBy(linkText="All Issues")
	private WebElement allIssuesLink;
	 
	@FindBy(xpath="//table[@id='issuetable']/tbody/tr/td[@class='nav issuekey']/a")
	private List<WebElement> selectAllTestIdFromIssueTable;
	
	@FindBy(xpath="//*[@id='delete-issue-dialog']/descendant::h2")
	private WebElement xpathForheaderTextForDeletePopup;
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement deleteLink;
	
	@FindBy(id="delete-issue-submit")
	private WebElement deleteBtnInDeletePopup;
	
	@FindBy(xpath="//*[@id='content']/descendant::span[@class='results-count-total results-count-link']")
	private List<WebElement> totalNumberOfTests;
	
	@FindBy(xpath="//*[@id='content']/div/div/div/header/h1")
	private WebElement headerOfDeleteSearch;
	
	@FindBy(xpath="//div[@class='global-msg']/div[@class='aui-message success closeable']")
	private WebElement globalMessage;
	
	// Quick search textbox present in jira landing page.
    @FindBy(id="quickSearchInput")
    private WebElement quickSearchTextBox;
    
    // Header text of a deleted test page.
    @FindBy(xpath="//*[@id='content']/descendant::h1")
    private WebElement headerOfDeleteTest;
    
    //Description of all test
    @FindBy(xpath="//table[@id='issuetable']/tbody/tr/td[contains(@class,'summary')]")
    private List<WebElement> issueSummary;
    
    @FindBy(xpath="//*[text()='Favourite Filters']/following-sibling::ul/li/a[@class='filter-link']")
    private WebElement xpathForFavouriteFilters;
    
    //Layout switch button where you can switch from one view to anather.
    @FindBy ( xpath="//*[@id='layout-switcher-button']" )
    private WebElement layoutSwitchBtn;
    
    @FindBy( xpath = "//*[@id='issuetable']/descendant::th")
    private List<WebElement> issueTableHeaders;
    
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	
	
	public ViewTestPage navigateToFirstTest(){
		try{
			Assert.assertTrue(changeView("list view"), "View is not selected successfully.");
			xpathForGettingTheFirstTest.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ViewTestPage.getInstance();
}
	
	public boolean quickSearchById(){
		Map<String, String> values= new HashMap<String, String>();
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(changeView("list view"), "View is not selected successfully.");
			values.put("TESTSUMMARY", xpathForGettingTestSummary.getText());
			values.put("TESTID", xpathForGettingTheFirstTest.getText());
			values.put("TESTASSIGNEE", xpathForGettingAssignee.getText());
			values.put("TESTREPORTER", xpathForGettingReporter.getText());
			values.put("TESTPRIORITY", CommonUtil.getAttributeValueUsingWebElements(xpathForGettingPriority, "alt"));
			values.put("TESTCREATEDDATE",CommonUtil.getAttributeValueUsingWebElements(xpathToGetCreatedDate, "title"));
			values.put("TESTUPDATEDDATE",CommonUtil.getAttributeValueUsingWebElements(xpathToGetUpdatedDate, "title"));
			xpathToQuickSearchTest.clear();
			xpathToQuickSearchTest.sendKeys(xpathForGettingTheFirstTest.getText());
			xpathToQuickSearchTest.sendKeys(Keys.ENTER);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return ViewTestPage.getInstance().validateQuickSearch(values);
	}
	
	public boolean quickSearchBySummary(){
		Map<String, String> values= new HashMap<String, String>();
		try{
			Assert.assertTrue(changeView("list view"), "View is not selected successfully.");
			values.put("TESTSUMMARY", xpathForGettingTestSummary.getText());
			values.put("TESTID", xpathForGettingTheFirstTest.getText());
			values.put("TESTASSIGNEE", xpathForGettingAssignee.getText());
			values.put("TESTREPORTER", xpathForGettingReporter.getText());
			values.put("TESTPRIORITY", CommonUtil.getAttributeValueUsingWebElements(xpathForGettingPriority, "alt"));
			values.put("TESTCREATEDDATE",CommonUtil.getAttributeValueUsingWebElements(xpathToGetCreatedDate, "title"));
			values.put("TESTUPDATEDDATE",CommonUtil.getAttributeValueUsingWebElements(xpathToGetUpdatedDate, "title"));
			xpathToQuickSearchTest.clear();
			xpathToQuickSearchTest.sendKeys(xpathForGettingTestSummary.getText());
			xpathToQuickSearchTest.sendKeys(Keys.ENTER);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(values.get("TESTSUMMARY").equals(xpathForGettingTestSummary.getText()));
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return navigateToFirstTest().validateQuickSearch(values);
	}
	
	
	public boolean exportTest(){
		String title = null;
		String totalTest = null;
		Map<String, String> values= new HashMap<String, String>();
		try{
			String getTitle=CommonUtil.getTitle();
			String[] titleOfPage=getTitle.split("- ");
			title=titleOfPage[1];
			totalTest=xpathToGetTotalTestCreated.getText();
			SearchTestsPage.getInstance().navigateToFirstTest();
			values=ViewTestPage.getInstance().getAllTestDetails();
			values.putAll(ViewTestPage.getInstance().getAllTeststepsDetails());
			values.put("FILE_NAME",title);
			values.put("TOTAL_TEST", totalTest);
			CommonUtil.navigateBack();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			exportlink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			Assert.assertTrue(xpathToExportAllFields.isDisplayed(),"Export All Fields option Doesn't exists");
			xpathToExportAllFields.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
			CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CommonUtil.actionClass().sendKeys(Keys.ESCAPE).build().perform();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return SearchTestsPage.getInstance().validateExportedFile(values);
	}
	
	public boolean validateExportedFile(Map<String, String> values){
		long fileSize;
		int id;
		try{
			File fis= new File(Config.getValue("EXPORT_FILE_PATH")+""+values.get("FILE_NAME")+".xls");
			if(fis.exists()){
				fileSize=fis.length();
				if(fileSize>0){
					logger.info("File exported successfully,with data in the excel sheet");
					
					//To validate the test exported...
					Document doc=Jsoup.parse(fis, "UTF-8");
					Assert.assertTrue(doc.select("title").toString().contains(values.get("FILE_NAME")), "Not the same file is been exported...");
					logger.info("File exported Validated., same file Verified...");
					Element firstTable=doc.select("table").first();
					Element firstRow=firstTable.select("tr").last();
					Element td=firstRow.select("td").first();
					Assert.assertTrue(td.toString().contains(values.get("TOTAL_TEST")), "Number of test Exported are not equal...");
					logger.info("Number of test exported are Verified., they are equal...");
					
					
					//To validate the last test exported...
					Element testTable=doc.select("table[id=issuetable]").first();
					Element testTbody=testTable.select("tbody").first();
					Element testTr=testTbody.select("tr").first();
					Elements testTds=testTr.select("td");
					// validating project.
					id= returnHeaderNum("project", testTable);
					Assert.assertTrue(testTds.get(id).toString().contains(Config.getValue("JIRA_PROJECT")),"Not the same project exported...");
					logger.info("Project "+Config.getValue("JIRA_PROJECT")+" Exported successfully...");
					
					// validating test key.
					id= returnHeaderNum("key", testTable);
					Assert.assertTrue(testTds.get(id).toString().contains(values.get("TESTID")),"Exporting Failed...");
					logger.info("All test Exported successfully...");
					
					logger.info("Validating last Test data that is been Exported...");
					
					// validating test summary.
					id= returnHeaderNum("summary", testTable);
					Assert.assertTrue(testTds.get(id).toString().contains(values.get("SUMMARY")),"summary of the first Test Validation Failed...");
					logger.info("Test sumary of the first test Validated successfully...");
					
					// validating test issue type.
					id= returnHeaderNum("issuetype", testTable);
					Assert.assertTrue(testTds.get(id).toString().contains("Test"), "Exported test is not of type issue type TEST...");
					logger.info("Exported Test is of issue type TEST... ");
					
					//validating test priority.
					id= returnHeaderNum("priority", testTable);
					Assert.assertTrue(testTds.get(id).toString().contains(values.get("PRIORITY")),"Priority exported is not the same...");
					logger.info("Priority of the last test is valid...");
					
					//validating test assignee.
					id= returnHeaderNum("assignee", testTable);
					Assert.assertTrue(testTds.get(id).toString().contains(values.get("ASSIGNEE")),"Assignee is not a jira user...");
					logger.info("Assignee to the last test created is: "+values.get("ASSIGNEE")+" ");
					
					//validating test reporter.
					id= returnHeaderNum("reporter", testTable);
					Assert.assertTrue(testTds.get(id).toString().contains(values.get("REPORTER")),"Reporter is not a jira user...");
					logger.info("Reporter of the  last test created is: "+values.get("REPORTER")+" ");
					
					//validating test creation date.
					id = returnHeaderNum("created", testTable);
					Assert.assertTrue(testTds.get(id).toString().contains(values.get("CREATED_DATE")),"Created Date are not the same...");
					logger.info("Last test created on: "+values.get("CREATED_DATE")+" ");
					
					//validating test updated date.
					id = returnHeaderNum("updated", testTable);
					Assert.assertTrue(testTds.get(id).toString().contains(values.get("UPDATED_DATE")),"Updated Date are not the same...");
					logger.info("Last test updated on: "+values.get("UPDATED_DATE")+" ");
					
					//steps to validate the test steps added to the last test.
					Element teststepTable=doc.select("table[id=project-config-steps-table]").first();
					Element teststepTbody=teststepTable.select("tbody").first();
					
					Element firstTeststepTr=teststepTbody.select("tr").first();
					Element lastTeststepTr=teststepTbody.select("tr").last();
					Element secondTeststepTr=teststepTbody.select("tr").get(1);
					
					Elements firstTeststepTds=firstTeststepTr.select("td");
					Elements lastTeststepTds=lastTeststepTr.select("td");
					Elements secondTeststepTds=secondTeststepTr.select("td");
							
					Assert.assertTrue(firstTeststepTds.get(1).toString().contains(values.get("STEP_1")),"First teststep exported is not the same...");
					logger.info("First teststep exported from the last test created is: "+values.get("STEP_1")+"");
					Assert.assertTrue(firstTeststepTds.get(2).toString().contains(values.get("DATA_1")),"First teststep exported is not the same...");
					logger.info("First testdata exported from the last test created is: "+values.get("DATA_1")+"");
					Assert.assertTrue(firstTeststepTds.get(3).toString().contains(values.get("EXPECTED_RESULT_1")),"First expected result is not the same...");
					logger.info("First expected result exported from the last test created is: "+values.get("EXPECTED_RESULT_1")+"");
					
					Assert.assertTrue(secondTeststepTds.get(1).toString().contains(values.get("STEP_2")),"Second teststep exported is not the same...");
					logger.info("Second teststep exported from the last test created is: "+values.get("STEP_2")+"");
					Assert.assertTrue(secondTeststepTds.get(2).toString().contains(values.get("DATA_2")),"Second teststep exported is not the same...");
					logger.info("Second testdata exported from the last test created is: "+values.get("DATA_2")+"");
					Assert.assertTrue(secondTeststepTds.get(3).toString().contains(values.get("EXPECTED_RESULT_2")),"Second expected result is not the same...");
					logger.info("Second expected result exported from the last test created is: "+values.get("EXPECTED_RESULT_2")+"");
					
					Assert.assertTrue(lastTeststepTds.get(1).toString().contains(values.get("STEP_3")),"Second teststep exported is not the same...");
					logger.info("Third teststep exported from the last test created is: "+values.get("STEP_3")+"");
					Assert.assertTrue(lastTeststepTds.get(2).toString().contains(values.get("DATA_3")),"Second teststep exported is not the same...");
					logger.info("Third testdata exported from the last test created is: "+values.get("DATA_3")+"");
					Assert.assertTrue(lastTeststepTds.get(3).toString().contains(values.get("EXPECTED_RESULT_3")),"Second expected result is not the same...");
					logger.info("Third expected result exported from the last test created is: "+values.get("EXPECTED_RESULT_3")+"");
					
				}
				else if(fileSize<=0){
					return false;
				}
				
			}
			else{
				logger.info("File export failed");
				return false;
			}
			
			FileUtils.cleanDirectory(new File(Config.getValue("EXPORT_FILE_PATH")));
			//fis.delete();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	

	
	public boolean validateSearchTestPage(){
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			String title=CommonUtil.getTitle();
			if(title.contains("Issue Navigator")){
				logger.info("Search Test Page Confirmed...");
			}
			Assert.assertTrue(changeView("list view"), "View is not selected successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
		
	public boolean validateTest(int total){
		try{
			CommonUtil.waitForStaleElement(xpathToValidateTotalTest, Constants.IMPLICIT_WAIT_LOW);
			int testMatched=Integer.parseInt(xpathToValidateTotalTest.getText());
			if(testMatched==total){
				CommonUtil.navigateBack();
			}
			else{
				logger.info("Total test count Validation Failed...");
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteTest(String testName) { 
        try {
        	Assert.assertTrue(changeView("list view"), "View is not selected successfully.");
			logger.info("View is changed to List View.");
        	String totalTestsBeforeDeleting = returnFirstTextFromList( totalNumberOfTests );
        	logger.info("Total count before deleting : "+totalTestsBeforeDeleting);
            //String testName = xpathForSelectFirstTest.getText();
            String xpathForTest = "//a[text()='" + testName + "']";
            CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForTest)).build().perform();
            logger.info("Hovering to test cycle properly.");
            String xpathForManageLink = "//td[a[text()='"+testName+"']]/following-sibling::td[@class='issue_actions']/a[contains(@id,'actions')]";
            CommonUtil.navigateThroughXpath(xpathForManageLink);
            Assert.assertTrue(CommonUtil.visibilityOfElementLocated("//div[contains(@id,'actions_')]"), "Actions popup is not displaying after clicking in actions link.");
            //CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
            deleteLink.click();
           // CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
            Assert.assertTrue(CommonUtil.visibilityOfElementLocated("//*[@id='delete-issue-dialog']"), "Not Showing delete popup after clicking on delete.");
            logger.info("Clicked on deleted Link and waiting for delete popup.");
            Assert.assertTrue(xpathForheaderTextForDeletePopup.getText().contains("Delete Issue"));

            deleteBtnInDeletePopup.click();
            logger.info("Clicked on deleted button and waiting for successful message.");
            //Changing in 6.4.4 //div[@class='aui-message success closeable'] to //div[contains(@class,'aui-message-success')] 
            CommonUtil.visibilityOfElementLocated("//div[contains(@class,'aui-message-success')]");
            logger.info( CommonUtil.getTextFromUIByXpath("//div[contains(@class,'aui-message-success')]") );
            //logger.info(Driver.driver.findElement(By.xpath("//div[@class='aui-message success closeable']")).getText());

            //returnFirstElement(refreshLink).click();
            //CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
            logger.info("Page is refreshed.");
            String totalTestsAfterDeleting = returnFirstTextFromList( totalNumberOfTests );
            Assert.assertNotEquals( totalTestsBeforeDeleting, totalTestsAfterDeleting, "Total tests count is same.");
            logger.info("Test is deleted . Total number of tests count is decreased.");
            logger.info("Total count after deleting : "+totalTestsAfterDeleting);
            /*Driver.driver.navigate().refresh();
            CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
            logger.info("Page is refreshed secondtime.");
            boolean b=CommonUtil.searchTheTextInList(selectAllTestIdFromIssueTable, testName);
            System.out.println("deleted : "+b);
            Assert.assertFalse(b,    "Test is still present.");
            logger.info(testName + " is deleted successfully.");*/
            CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
            Assert.assertTrue(quickSearchForDeleteTest(testName), "Test is not deleted. Still present.");
            logger.info("Test is deleted and validated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

	public boolean quickSearchForDeleteTest(String testToSearch){
        try{
            quickSearchTextBox.sendKeys(testToSearch, Keys.ENTER);
            CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
            logger.info("Searched result is showing.");
            Assert.assertTrue(headerOfDeleteTest.getText().equalsIgnoreCase("Issue Does Not Exist"), "Issue is still exist.");
            logger.info("Test is deleted successfully.");
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
	/*public boolean deleteTest(){
		try{
			String testName=xpathForSelectFirstTest.getText();
			String xpathForTest="//a[text()='"+testName+"']";	
			CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForTest)).build().perform();
			logger.info("Hovering to test cycle properly.");
			String xpathForManageLink="//td[a[text()='"+testName+"']]/following-sibling::td/div/a[contains(@id,'actions')]";
			CommonUtil.navigateThroughXpath(xpathForManageLink);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			deleteLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(xpathForheaderTextForDeletePopup.getText().contains("Delete Issue"), "Not navigated to delete test popup.");
			logger.info("Delete popup is verified successfully.");
			deleteBtnInDeletePopup.click();
			logger.info("Selected Delete Link.");
			CommonUtil.visibilityOfElementLocated("//div[@class='global-msg']/div[@class='aui-message success closeable']");
			logger.info(globalMessage.getText());
			CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
			refreshLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Driver.driver.navigate().refresh();
			Assert.assertNotNull(JiraLandingPage.getInstance().navigateToSearchTestsPage(), "Not navigated to search tests page.");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			//CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(CommonUtil.searchTheTextInList(selectAllTestIdFromIssueTable, testName), "Test is still present.");
			logger.info(testName+" is deleted successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertNotNull(JiraLandingPage.getInstance().quickSearchByID(testName), "Test is not searched successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertFalse(headerOfDeleteSearch.getText().equals("Issue Does Not Exist"), "Searched Deletetest page is not showing.");
			logger.info("Deleted test is verified successfully.");
			
			
		}catch(Exception e){
			logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	private boolean selectInTest(String testName, String selectActions){
		try{
			String xpathForTest="//a[text()='"+testName+"']";	
			CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForTest)).build().perform();
			logger.info("Hovering to test cycle properly.");
			String xpathForManageLink="//td[a[text()='"+testName+"']]/following-sibling::td/div/a[contains(@id,'actions')]";
			CommonUtil.navigateThroughXpath(xpathForManageLink);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForManageStatus="//a[text()='"+selectActions+"']";
			CommonUtil.navigateThroughXpath(xpathForManageStatus);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(xpathForheaderTextForDeletePopup.getText().contains("Delete Issue"));
			
			deleteBtnInDeletePopup.click();
			
			CommonUtil.visibilityOfElementLocated("//div[@class='aui-message success closeable']");
			
			 returnFirstElement(refreshLink).click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			Assert.assertFalse(CommonUtil.searchTheTextInList(selectAllTestIdFromIssueTable, testName), "Test is still present.");
			logger.info(testName+" is deleted successfully.");
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean selectManageLinkAndSelectActions(String testName, String selectActions){
		try{
			String xpathForManageLink="//td[a[text()='"+testName+"']]/following-sibling::td/div/a[contains(@id,'actions')]";
			CommonUtil.navigateThroughXpath(xpathForManageLink);
			String xpathForManageStatus="//a[text()='"+selectActions+"']";
			CommonUtil.navigateThroughXpath(xpathForManageStatus);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public String saveAsJiraSearch(String filterName){
		String totalTests=null;
		try{
			Assert.assertTrue(CommonUtil.getTitle().contains("Issue Navigator"), "Search test Page/ Issue Navigator page not verified.");
			logger.info("Search test Page/ Issue Navigator page validated successfully.");
			Assert.assertTrue(changeView("list view"), "View is not selected successfully.");
			logger.info("View is changed to List View.");
			saveAsFilterLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(saveAsFilterHeaderText.getText().equals("Save Filter"), "Save As filter popup is not verified successfully.");
			logger.info("Save As filter popup is validated successfully.");
			
			saveAsFilterNameTextBox.sendKeys(filterName);
			saveAsFilterSubmitButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			//CommonUtil.visibilityOfElementLocated("//div[@class='aui-message success closeable']");
			logger.info("Filter is created successfully.");
			
			//String xpathForFilter="//h4[contains(text(),'Favorite Filters')]/following-sibling::ul/li/a[contains(text(),'"+filterName+"')]";
			//String xpathForFilter = "//*[text()='Favourite Filters']/following-sibling::ul/li/a[contains(@class,'filter-link')]";
			String xpathForFilter = "//*[@class='saved-filter filter-list favourite-filters']/descendant::a[contains(@class,'filter-link')]";
			Assert.assertTrue(CommonUtil.searchTheTextInList(xpathForFilter, filterName), "Filter is not present");
			logger.info(filterName + " is present in Favourite Filters.");
			//totalTests=totalNumberOfTests.getText();
			totalTests = returnFirstTextFromList( totalNumberOfTests );
			
		}catch(Exception e){
			e.printStackTrace();
			return totalTests;
		}
		return totalTests;
	}
	
	public boolean searchTestDescription(String summary){
		boolean flag=false;
		try{
			for(int i=0; i< issueSummary.size(); i++){
				if(issueSummary.get(i).getText().equals(summary)){
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
	public String returnFirstTextFromList(List<WebElement> list){
		String totalTests=null;
		try{
			for(int i=0; i< list.size(); i++){
				totalTests = list.get(i).getText();
				break;
			}
		}catch (Exception e){
			e.printStackTrace();
			return totalTests;
		}
		return totalTests;
	}
	public WebElement returnFirstElement(List<WebElement> list){
		WebElement element = null ;
		try{
			for(int i=0; i< list.size(); i++){
				element = list.get(i);
				break;
			}
		}catch (Exception e){
			e.printStackTrace();
			return element;
		}
		return element;
	}

	
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	private int returnHeaderNum(String field,Element table){
		Element testhead=table.select("thead").first();
		Element headTr= testhead.select("tr").first();
		Element th= headTr.getElementsByAttributeValueContaining("class", field).first();
		return th.elementSiblingIndex();
	}

	public boolean changeView(String view){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			if(CommonUtil.isElementPresent("//*[@id='layout-switcher-button']")) {
				layoutSwitchBtn.click();
				CommonUtil.visibilityOfElementLocated("//div[@id='layout-switcher-button_drop']");
				logger.info("Shitch view drop-down activated successfully.");
				if (view.equals("list view")) {
					//String xpthaForView="//li[a[@data-layout-key='list-view']]";
					String xpthaForView="//a[@data-layout-key='list-view']";
					CommonUtil.clickOnElement(xpthaForView);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				}	else if (view.equals("detailed view")){
					String xpthaForView="//a[@data-layout-key='split-view']";
					CommonUtil.clickOnElement(xpthaForView);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				}
				/*layoutSwitchBtn.click();
				CommonUtil.visibilityOfElementLocated("//div[@id='layout-switcher-button_drop']");
				logger.info("Shitch view drop-down activated successfully.");
				if (view.equals("list view")) {
					String xpthaForView="//li[a[@data-layout-key='list-view']]";
					CommonUtil.clickOnElement(xpthaForView);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					String x=CommonUtil.getAttributeValue(xpthaForView, "class");
					Assert.assertTrue(CommonUtil.getAttributeValue(xpthaForView, "class").contains("active"), "View is not changed to list view.");
				}	else if (view.equals("detailed view")){
					String xpthaForView="//li[a[@data-layout-key='split-view']]";
					CommonUtil.clickOnElement(xpthaForView);
					//Assert.assertTrue(CommonUtil.getAttributeValue(xpthaForView, "class").contains("active"), "View is not changed to list view.");
				}
				logger.info("View is changed to "+view+" successfully.");*/
			} else {
				logger.info("Any View is not present, By defualt it is selected List View.");
			}
			
		} catch ( Exception e ) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<String> getTest(List<String> list){
		//List<String> listadd= list;
		boolean flag = false;
		String s=null;
		try{
			Assert.assertTrue(changeView("list view"), "View is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			List<WebElement> allIssues = CommonUtil.returnWebElementsFromXpath("//*[@id='issuetable']/tbody/tr/td["+returnHeaderNum("Key")+"]");
			//if(allIssues.size() > list.size()){
				for (int i=0; i < allIssues.size(); i++){
					if(flag){
						break;
					}
					s=allIssues.get(i).getText();
					if(list.isEmpty()){
						System.out.println("Empty list.");
						list.add(s);
						break;
					}else{
						for (int j=i; j<= list.size();j++) {
				            String data=null;
							try{ data=list.get(j);}catch(Exception e){}  
							if(s.equals(data)){
				            	  // flag = true;
				            	   System.out.println("breaked.");
				            	   System.out.println(list.get(j));
				                   break;
				            }else{
				            	   flag=true;
				            	   list.add(s);
				            	   break;
				            }
				        }
					}
					
				}
			
			
			
			System.out.println("Working Success");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return list;
	}
	public List<String> getTests(int numberOfIssue){
		List<String> listadd= new ArrayList<String>();
		boolean flag = false;
		String s=null;
		try{
			Assert.assertTrue(changeView("list view"), "View is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			List<WebElement> allIssues = CommonUtil.returnWebElementsFromXpath("//*[@id='issuetable']/tbody/tr/td["+returnHeaderNum("Key")+"]");
			if(allIssues.size() > numberOfIssue){
				for (int i=0; i < allIssues.size(); i++){
					if(i <= numberOfIssue){
						s=allIssues.get(i).getText();
						listadd.add(s);
					}else{
						logger.info("In Search Test page less than 5 tests are there.");
						break;
					}
					
				}
			}
			
			
			
			System.out.println("Working Success");
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return listadd;
	}
	public Map<String, List<String>> returnTests(){
		Map<String, List<String>> map=new HashMap<String, List<String>>();
		List<String> list=new ArrayList<String>();
		List<String> list1=new ArrayList<String>();
		try{
			Assert.assertTrue(changeView("list view"), "View is not selected successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			List<WebElement> allIssues = CommonUtil.returnWebElementsFromXpath("//*[@id='issuetable']/tbody/tr/td["+returnHeaderNum("Summary")+"]");
			for (int i=0; i < allIssues.size(); i++){
				if(allIssues.get(i).getText().contains("Test step")){
					String s= CommonUtil.getTextFromUIByXpath("//*[@id='issuetable']/tbody/tr["+(i+1)+"]/td["+returnHeaderNum("Key")+"]");
					list.add(s);
				}else{
					String s= CommonUtil.getTextFromUIByXpath("//*[@id='issuetable']/tbody/tr["+(i+1)+"]/td["+returnHeaderNum("Key")+"]");
					list1.add(s);
				}
			}
			map.put("Test with Test Step", list);
			map.put("Test without Test Step", list1);
		}catch(Exception e){
			e.printStackTrace();
			return map;
		}
		return map;
	}
	private int returnHeaderNum(String headerName){
		int headerNum = 0;
		try{
			for (int i=0 ; i < issueTableHeaders.size() ; i++){
				if(issueTableHeaders.get(i).getText().equals(headerName)){
					headerNum=i+1;
					break;
				}
			}
		}catch(Exception e){
			//e.printStackTrace();
			return headerNum;
		}
		return headerNum;
	}
	public boolean navigateToTest(String testName){
		try{
			String xpathForTest="//*[@id='issuetable']/tbody/tr/td["+returnHeaderNum("Key")+"]/a[text()='"+testName+"']";
			CommonUtil.navigateThroughXpath(xpathForTest);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean validatePage(){
		try{
			Assert.assertTrue(CommonUtil.titleContains("Issue Navigator", Constants.EXPLICIT_WAIT_LOW), "Execute Tests Page is not verified successfully.");
			logger.info("Execute Tests Page is Validated Successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public int totalTests(){
		int totalTests=0;
		try{
			boolean b = CommonUtil.isElementPresent("//*[@class='results-count-total results-count-link']", 3000);
			totalTests = Integer.parseInt(returnFirstTextFromList(CommonUtil.getWebElements("//*[@class='results-count-total results-count-link']")));
			return totalTests;
		}catch(Exception e){
			//e.printStackTrace();
			return totalTests;
		}
	}
	public boolean deleteAllFilters(){
		try{
			if(CommonUtil.isElementPresent(".//*[@class='saved-filter filter-list favourite-filters']/li")){
							
			List<WebElement> listOfElements = CommonUtil.returnWebElementsFromXpath(".//*[@class='saved-filter filter-list favourite-filters']/li");
			for(int i=1; i<=listOfElements.size();i++){
				CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(".//*[@class='saved-filter filter-list favourite-filters']/li[1]")).perform();
				String actions = "//*[@class='saved-filter filter-list favourite-filters']/li[1]/a[@class='filter-actions']";
				CommonUtil.navigateThroughXpath(actions);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.navigateThroughXpath("//a[@class='aui-list-item-link delete-filter']");
				CommonUtil.visibilityOfElementLocated(".//*[@id='delete-filter-dialog']");
				CommonUtil.navigateThroughXpath("//*[@id='delete-filter-form']/descendant::input[@class='aui-button submit']");
				CommonUtil.visibilityOfElementLocated("//*[@class='aui-message success closeable']");
				logger.info(CommonUtil.getTextFromUIByXpath("//*[@class='aui-message success closeable']"));
				
				logger.info("Filter "+i+" deleted successfully.");
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			}
			logger.info("Filters are deleted successfully.");
			}else{
				logger.info("There is no filters present.");
			}
			List<WebElement> listOfElement = CommonUtil.returnWebElementsFromXpath(".//*[@class='saved-filter filter-list favourite-filters']/li");
			logger.info("size : "+listOfElement.size());
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
