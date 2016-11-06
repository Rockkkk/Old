package com.thed.zfjbvt.zfj.impl.zfj21;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class ManageExecutionFiltersPage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static ManageExecutionFiltersPage getInstance() {
		ManageExecutionFiltersPage page = PageFactory.initElements(Driver.driver, ManageExecutionFiltersPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//xpath for Manage Execution Filters header.
	@FindBy(xpath="//*[@id='content']/header/h1")
	private WebElement manageExecutionFiltersHeader;
	
	//xpath for the filter image in Manage Execution Page.
	@FindBy(xpath="//*[@id='heading-avatar']/img")
	private WebElement filterImage;
	
	// Search filter tab link
	@FindBy(id="search-filters-tab")
	private WebElement searchFilterTab;
	
	//Search Execution Filters page web elements.
	// search tab filter name text box.
	@FindBy(id="filterName")
	private WebElement filterNameTextBox;
	
	// Search button in Search Execution Filters page.
	@FindBy(id="mzf-search-btn")
	private WebElement searchBtn;
	
	// All favourite filters list
	@FindBy(xpath="//table[@id='mzf_filterz']/tbody/tr/td[1]/div/a[@class='filter-link']")
	private List<WebElement> favouriteFiltersList;
	
	//
	@FindBy(xpath="//table[@id='mzf_filterz']/tbody/tr/td[@title='Number of Test Execution returned by this execution filter.']/a")
	private WebElement totalNumOfTestsReturnedByThisFilter;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	
	public boolean validateManageExecutionFiltersPage(){
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
			String title=CommonUtil.getTitle();
			Assert.assertTrue(title.contains(manageExecutionFiltersHeader.getText())&&(filterImage.isDisplayed()),"Validating ManageExecutionFiltersPage Failed...");
			int totalMenus = CommonUtil.getSizeOfElements("//*[@id='content']/div/ul//a" );
			List<String> menus= CommonUtil.getValues("//*[@id='content']/div/ul//a"); 
			for(int i=0; i<totalMenus;i++){
				logger.info("Tab Menu "+(i+1) +" in Manage Execution Filters Page is : "+menus.get(i));
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean searchExecFilterInManageExecFilter(String filterName, int testsInThisFilter){
		try{
			Assert.assertTrue(validateManageExecutionFiltersPage(), "Manage Execution filter page is not verified successfully.");
			logger.info("Manage Execution filter page is verified successfully.");
			
			searchFilterTab.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			filterNameTextBox.sendKeys(filterName);
			searchBtn.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			CommonUtil.visibilityOfElementLocated("//div[@id='mng-srh-filters-content-id']/div/table[@id='mzf_filterz']");
			logger.info("Searched execution filters list showing successfully.");
			
			Assert.assertTrue(CommonUtil.searchTextInList(favouriteFiltersList, filterName));
			logger.info("Filter is searched successfully.");
			Assert.assertTrue(Integer.parseInt(totalNumOfTestsReturnedByThisFilter.getText()) == testsInThisFilter, "Total number of tests are not same.");
			logger.info("Total number of tests verified in this filter .");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
