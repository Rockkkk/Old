package com.thed.zfjbvt.zfj.impl.zfj21;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.jira.impl.jira52.JiraLandingPage;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj21.ViewTestPage;

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
	@FindBy(xpath="//table[@id='issuetable']/tbody//tr[1]/td[4]//a")
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
	@FindBy(xpath="//*[@id='content']/div[3]/div[2]/div/div[2]/div[1]/div[2]/span[3]")
	private WebElement xpathToValidateTotalTest;
	
	//id of the view link in Issue navigator.
	@FindBy(xpath="//a/span[text()='Views']")
	private WebElement xpathOfViewOptionLink;
	
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
	private WebElement refreshLink;
	
	
	@FindBy(linkText="Save as")
	private WebElement saveAsFilterLink;
	
	@FindBy(xpath="//div[@id='save-filter-dialog']/h2[@class='aui-popup-heading']")
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

	
	 
	@FindBy(id="project-name-val")
	private WebElement projectnameInViewIssuePage;
	
	@FindBy(id="key-val")
	private WebElement issueIdInViewIssuePage;
	
	@FindBy(id="edit-issue")
	private WebElement editIssueLinkInViewIssuePage;
	
	@FindBy(xpath="//*[@id='summary-val' and @title='Click to edit']")
	private WebElement editIssueSummaryTextInViewIssuePage;
	
	@FindBy(id="clone-issue")
	private WebElement cloneIssueLinkInViewIssuePage;
	
	@FindBy(id="link-issue")
	private WebElement linkIssueLinkInViewIssuePage;
	
	@FindBy(id="opsbar-zephyr-je-manage-plan-top_more")
	private WebElement moreActionsLinkInViewIssuePage;
	
	@FindBy(id="viewissue-add-cycle")
	private WebElement addTestToCycleLinkInViewIssuepage;
	
	@FindBy(id="attach-file")
	private WebElement attachFileLinkInViewIssuepage;
	
	@FindBy(id="attach-screenshot")
	private WebElement attachScreenshotLinkInViewissuePage;
	
	@FindBy(id="comment-issue")
	private WebElement commentissueLinkInViewissuePage;
	
	@FindBy(xpath="//ul[@id='opsbar-opsbar-zephyr-je-manage-top']/li/a[@id='zephyr-je-add-execute']")
	private WebElement executeLinkInViewissuePage;
	
	//Execute Test popup from view Issue Page webelements.
	@FindBy(id="zephyr-je-execute-adhoc")
	private WebElement executeAdHocCheckbox;
	
	@FindBy(id="zephyr-je-execute-existing")
	private WebElement addToExistingTestCycleAndExecuteCheckBox;
	
	@FindBy(id="project_version")
	private WebElement selectVersionDropDown;
	
	@FindBy(id="cycle_names")
	private WebElement selectCycleDropDown;
	
	@FindBy(xpath="//a[@id='zephyr-je-dlgclose']/following-sibling::a[@title='Execute Test']")
	private WebElement executeButtonInExecuteTestPage;
	
	@FindBy(id="zephyr-je-dlgclose")
	private WebElement cancelButton;
	
	@FindBy(xpath="//table[@id='issuetable']/tbody/tr[1]/td[@class='nav issuekey']/a")
	private WebElement xpathForSelectFirstTest;

	
	@FindBy(xpath="//table[@id='issuetable']/tbody/tr/td[@class='nav issuekey']/a")
	private List<WebElement> selectAllTestIdFromIssueTable;
	
	@FindBy(xpath="//div[@id='delete-issue-dialog']/h2")
	private WebElement xpathForheaderTextForDeletePopup;
	
	@FindBy(xpath="//a[text()='Delete']")
	private WebElement deleteLink;
	
	@FindBy(id="delete-issue-submit")
	private WebElement deleteBtnInDeletePopup;
	
	@FindBy(xpath="//form[@class='navigator-search']/following-sibling::div[@class='results-count aui-item']/span[@class='results-count-total results-count-link']")
	private WebElement totalNumberOfTests;
	
	@FindBy(xpath="//*[@id='content']/div/div/div/header/h1")
	private WebElement headerOfDeleteSearch;
	
	@FindBy(xpath="//div[@class='global-msg']/div[@class='aui-message success closeable']")
	private WebElement globalMessage;
	
	// Quick search textbox present in jira landing page.
    @FindBy(id="quickSearchInput")
    private WebElement quickSearchTextBox;
    
    // Header text of a deleted test page.
    @FindBy(xpath="//*[@id='content']/div/div/div/header/h1")
    private WebElement headerOfDeleteTest;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	
	
	public ViewTestPage navigateToFirstTest(){
		try{
			xpathForGettingTheFirstTest.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ViewTestPage.getInstance();
}
	
	public boolean quickSearch(){
		Map<String, String> values= new HashMap<String, String>();
		try{
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
			values.put("FILE_NAME",title);
			values.put("TOTAL_TEST", totalTest);
			CommonUtil.navigateBack();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			xpathOfViewOptionLink.click();
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
		try{
			File fis= new File(Config.getValue("EXPORT_FILE_PATH")+""+values.get("FILE_NAME")+".xls");
			if(fis.exists()){
				fileSize=fis.length();
				if(fileSize>0){
					logger.info("File exported successfully,with data in the excel sheet");
					
					//steps to validate the test exported...
					Document doc=Jsoup.parse(fis, "UTF-8");
					Assert.assertTrue(doc.select("title").toString().contains(values.get("FILE_NAME")), "Not the same file is been exported...");
					logger.info("File exported Validated., same file Verified...");
					Element firstTable=doc.select("table").first();
					Element firstRow=firstTable.select("tr").last();
					Element td=firstRow.select("td").first();
					Assert.assertTrue(td.toString().contains(values.get("TOTAL_TEST")), "Number of test Exported are not equal...");
					logger.info("Number of test exported are Verified., they are equal...");
					
					
					//steps to validate the last test exported...
					Element TestTable=doc.select("table[id=issuetable]").first();
					Element testTbody=TestTable.select("tbody").first();
					Element testTr=testTbody.select("tr").first();
					Elements testTds=testTr.select("td");
					Assert.assertTrue(testTds.get(0).toString().contains(Config.getValue("JIRA_PROJECT")),"Not the same project exported...");
					logger.info("Project "+Config.getValue("JIRA_PROJECT")+" Exported successfully...");
					Assert.assertTrue(testTds.get(1).toString().contains(values.get("TESTID")),"Exporting Failed...");
					logger.info("All test Exported successfully...");
					logger.info("Validating last Test data that is been Exported...");
					Assert.assertTrue(testTds.get(2).toString().contains(values.get("SUMMARY")),"summary of the first Test Validation Failed...");
					logger.info("Test sumary of the first test Validated successfully...");
					Assert.assertTrue(testTds.get(3).toString().contains("Test"), "Exported test is not of type issue type TEST...");
					logger.info("Exported Test is of issue type TEST... ");
					Assert.assertTrue(testTds.get(5).toString().contains(values.get("PRIORITY")),"Priority exported is not the same...");
					logger.info("Priority of the last test is valid...");
					Assert.assertTrue(testTds.get(7).toString().contains(values.get("ASSIGNEE")),"Assignee is not a jira user...");
					logger.info("Assignee to the last test created is: "+values.get("ASSIGNEE")+" ");
					Assert.assertTrue(testTds.get(8).toString().contains(values.get("REPORTER")),"Reporter is not a jira user...");
					logger.info("Reporter of the  last test created is: "+values.get("REPORTER")+" ");
					Assert.assertTrue(testTds.get(9).toString().contains(values.get("CREATED_DATE")),"Created Date are not the same...");
					logger.info("Last test created on: "+values.get("CREATED_DATE")+" ");
					Assert.assertTrue(testTds.get(11).toString().contains(values.get("UPDATED_DATE")),"Updated Date are not the same...");
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
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
		
	public boolean validateTest(int total){
		try{
			int testMatched=Integer.parseInt(xpathToValidateTotalTest.getText());
			if(testMatched==total){
				Driver.driver.navigate().back();
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
        	String totalTestsBeforeDeleting=totalNumberOfTests.getText();
        	logger.info("Total count before deleting : "+totalTestsBeforeDeleting);
        	//String testToDelete="//table[@id='issuetable']/tbody/tr/td[p/a[text()='Fourth Test with Test step']]/preceding-sibling::td[@class='nav issuekey']/a";
           // String testName = xpathForSelectFirstTest.getText();
            String xpathForTest = "//a[text()='" + testName + "']";
            CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForTest)).build().perform();
            logger.info("Hovering to test cycle properly.");
            String xpathForManageLink = "//td[a[text()='"+testName+"']]/following-sibling::td/div/a[contains(@id,'actions')]";
            CommonUtil.navigateThroughXpath(xpathForManageLink);
            CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
            deleteLink.click();
            CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
            logger.info("Clicked on deleted Link and waiting for delete popup.");
            Assert.assertTrue(xpathForheaderTextForDeletePopup.getText().contains("Delete Issue"));

            deleteBtnInDeletePopup.click();
            logger.info("Clicked on deleted button and waiting for successful message.");
            CommonUtil.visibilityOfElementLocated("//div[@class='aui-message success closeable']");
            logger.info(Driver.driver.findElement(By.xpath("//div[@class='aui-message success closeable']")).getText());

            refreshLink.click();
            CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
            logger.info("Page is refreshed.");
            String totalTestsAfterDeleting=totalNumberOfTests.getText();
            Assert.assertNotEquals(totalTestsBeforeDeleting, totalTestsAfterDeleting, "Total tests count is same.");
            logger.info("Test is deleted. Total number of tests count is decreased.");
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
            Assert.assertTrue(headerOfDeleteTest.getText().equals("Issue Does Not Exist"), "Issue is still exist.");
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
			
			refreshLink.click();
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
			saveAsFilterLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(saveAsFilterHeaderText.getText().equals("Save Filter"), "Save As filter popup is not verified successfully.");
			logger.info("Save As filter popup is validated successfully.");
			
			saveAsFilterNameTextBox.sendKeys(filterName);
			saveAsFilterSubmitButton.click();
			CommonUtil.visibilityOfElementLocated("//div[@class='aui-message success closeable']");
			logger.info("Filter is created successfully.");
			
			String xpathForFilter="//h4[contains(text(),'Favorite Filters')]/following-sibling::ul/li/a[contains(text(),'"+filterName+"')]";
			Assert.assertTrue(CommonUtil.searchTheTextInList(xpathForFilter, filterName), "Filter is not present");
			logger.info(filterName+" is present.");
			totalTests=totalNumberOfTests.getText();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return totalTests;
	}
	

}
