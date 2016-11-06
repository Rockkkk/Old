package com.thed.zfjbvt.zfj.impl.zfj173;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

/**
 * This is zfj's Add Tests to cycle page, Here user can see all add tests to a cycle related webelements.
 * @author Manoj
 *
 */
public class AddTestsToCyclePage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public static AddTestsToCyclePage getInstance() {
		return PageFactory.initElements(Driver.driver, AddTestsToCyclePage.class);
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	// Add Tests indivisually popup.
	// Create a cycle page header text.
	@FindBy(xpath="//div[@id='add-tests-dialog']/div/h2[@class='dialog-title']")
	private WebElement headerTextOfAddTestToCyclePage;
	
	//add popup page select test indivisually dropdown link.
	@FindBy(xpath="//*[@id='zephyr-je-testkey-multi-select']/span")
	private WebElement selectTestMultiSelectDropdown;
	
	//Text area for adding the test
	@FindBy(id="zephyr-je-testkey-textarea")
	private WebElement addTestTextArea;
	
	// add test pop up add button.
	@FindBy(xpath="//div[@class='aui-popup box-shadow aui-dialog aui-dialog-open aui-dialog-content-ready' and @id='add-tests-dialog']/div/div/button[text()='Add']")
	private WebElement addTestsAddButton;
		
	// close link after adding the cycle.
	@FindBy(xpath="//a[@id='aui-dialog-close']")
	private WebElement closeLinkAfterAddingTest;
	
	// xpath for via search filter
	@FindBy(xpath="//button[text()='Via Search Filter']")
	private WebElement xpathForViaSearchFilter;
	
	// add test via search filter text area
	@FindBy(id="addTestsSavedSearch-textarea")
	private WebElement textAreaForSavedFilter;
	
	// xpath for From other cycle button
	@FindBy(xpath="//button[text()='From Another Cycle']")
	private WebElement xpathForFromOtherCycleBtn;
	
	
	@FindBy(id="addTestsVersion")
	private WebElement selectVersionDropDown;
	
	@FindBy(id="addTestsCycle")
	private WebElement selectCycleDropDown;
	
	@FindBy(id="addTestDefects")
	private WebElement linkDefectsCheckBox;
	
	@FindBy(xpath="//div[a[text()='Cancel']]/button[text()='Add']")
	private WebElement addButton;
	
	
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	/**
	 * This method is used to add the tests individually by taking the test.
	 * @param addTestName This parameter contains the test name which is used executing into the cycle in zfj.
	 * @return The boolean value.
	 * @throws Exception 
	 */
	public boolean addTestsIndivisually(String addTestName) throws Exception{
		try{
			Assert.assertTrue(headerTextOfAddTestToCyclePage.getText().contains("Add Tests to Cycle:"), "Add tests to cycle popup is not verified successfully.");
			logger.info("Add tests to cycle popup is verified successfully.");
			
			Assert.assertTrue(selectTest(addTestName), "Test is not selected successfully from the select test drop down.");
			logger.info("Selected indivisually tests successfully.");
			addTestsAddButton.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			closeLinkAfterAddingTest.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Added tests successfully.");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * This method is used to add tests using space bar.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>TEST_ONE</b> This parameter contains the test name while adding by using space bar.<br/>
	 * <b>TEST_TWO</b> This parameter contains the test name while adding by using space bar. <br/>
	 * <b>TEST_THREE</b> This parameter contains the test name while adding by using space bar.<br/>
	 * <b>TEST_FOUR</b> This parameter contains the test name while adding by using space bar.<br/>
	 * <b>TEST_FIVE</b> This parameter contains the test name while adding by using space bar.<br/>
	 * </p>
	 * @return
	 */
	public PlanTestCyclePage addTestsUsingSpaceBar(Map<String , String> values){
		try{
			Assert.assertTrue(headerTextOfAddTestToCyclePage.getText().contains("Add Tests to Cycle:"), "Add tests to cycle popup is not verified successfully.");
			logger.info("Add tests to cycle popup is verified successfully.");
			
			addTestTextArea.sendKeys(values.get("TEST_ONE"), Keys.SPACE, values.get("TEST_TWO"), Keys.SPACE, values.get("TEST_THREE"), Keys.SPACE, values.get("TEST_FOUR"), Keys.SPACE, values.get("TEST_FIVE"));
			logger.info("Selected indivisually tests successfully.");
			addTestsAddButton.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			closeLinkAfterAddingTest.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Added tests successfully.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PlanTestCyclePage.getInstance();
	}
	public boolean addTestFromJiraSearch(String filterName, String totalTests){
		try{
			Assert.assertTrue(headerTextOfAddTestToCyclePage.getText().contains("Add Tests to Cycle:"), "Add tests to cycle popup is not verified successfully.");
			logger.info("Add tests to cycle popup is verified successfully.");
			
			xpathForViaSearchFilter.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			textAreaForSavedFilter.sendKeys(filterName);
			//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String xpathForSelectingFilter="//a[@title='"+filterName+"']";
			CommonUtil.visibilityOfElementLocated(xpathForSelectingFilter);
			CommonUtil.navigateThroughXpath(xpathForSelectingFilter);
			String xpathForSavedSearchCount="//dt[text()='Total Tests Found:']/following-sibling::dd[@id='savedSearch-count']";
			CommonUtil.visibilityOfElementLocated(xpathForSavedSearchCount);
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForSavedSearchCount).equals(totalTests), "Saved Filter test is not matching.");
			logger.info("Tests are matched.");
			System.out.println(addTestsAddButton.isEnabled()+" : "+addTestsAddButton.isDisplayed());
			addTestsAddButton.click();
			System.out.println("clicked on add button.");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
			closeLinkAfterAddingTest.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Added tests successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean addTestFromOtherCycle(String versionName, String oldCycleName){
		try{
			Assert.assertTrue(headerTextOfAddTestToCyclePage.getText().contains("Add Tests to Cycle:"), "Add tests to cycle popup is not verified successfully.");
			logger.info("Add tests to cycle popup is verified successfully.");
					
			xpathForFromOtherCycleBtn.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			CommonUtil.selectListWithVisibleText(selectVersionDropDown, versionName);
			CommonUtil.selectListWithVisibleText(selectCycleDropDown, oldCycleName);
			linkDefectsCheckBox.click();
			addTestsAddButton.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
			closeLinkAfterAddingTest.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Added tests successfully.");
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	/**
	 * This method is used to select a test from the list of tests.
	 * @param addTestName This parameter is used while selecting a test from the test drop down menu.
	 * @return The boolean value.
	 */
	private boolean selectTestFromTestDropDown(String addTestName) {
		try{
			selectTestMultiSelectDropdown.click();
			String xpathForSelectingTestFromDropdownTest="//*[@id='history-search']/li/a[contains(text(),'"+addTestName+"')]";
			CommonUtil.navigateThroughXpath(xpathForSelectingTestFromDropdownTest);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean selectTest(String testId){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			addTestTextArea.sendKeys(testId);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().sendKeys(Keys.ENTER).build().perform();
			logger.info("Test is selected successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
