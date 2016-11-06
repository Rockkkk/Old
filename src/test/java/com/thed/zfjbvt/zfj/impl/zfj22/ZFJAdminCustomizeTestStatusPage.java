package com.thed.zfjbvt.zfj.impl.zfj22;

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

public class ZFJAdminCustomizeTestStatusPage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the ZFJ Admin CustomizeTestStatus Page and returns the page instance.
	 * @return This returns the ZFJ Admin CustomizeTestStatus Page instance.
	 */
	public static ZFJAdminCustomizeTestStatusPage getInstance() {
		ZFJAdminCustomizeTestStatusPage page = PageFactory.initElements(Driver.driver, ZFJAdminCustomizeTestStatusPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
		// Webelements for header text for test execution status page. 
		@FindBy(xpath="//td[@class='jiraformheader']/h3[@class='formtitle formtitle-bamboo']")
		private WebElement headerForTestExecutionStatusPageXpath;
					
		// Webelements for all test execution statuses in test execution status page.
		@FindBy(xpath="//table[thead[tr[th[contains(text(),'Status')]]]]/tbody/tr/td[1]")
		private List<WebElement> allTestExecutionStatuses;
			
		/*Edit Test status page webelements.*/
		@FindBy(name="name")
		private WebElement statusTextBoxForTestStatus;
		
		// Test status description text box present in edit test status page.
		@FindBy(name="description")
		private WebElement descriptionTextBoxForTestStatus;
		
		// Color code textbox present in edit test status page.
		@FindBy(name="color")
		private WebElement colorTextBoxForTestStatus;
		
		// Submit button in edit test status page.
		@FindBy(id="edit_submit")
		private WebElement submitButtonInEditTestExecutionStatus;
		
		/*add new status webelements*/
		// Test status text box in add step status form.
		@FindBy(name="name")
		private WebElement statusTextBoxForAddTestStatus;
		
		// Test status description text box in add step status form.
		@FindBy(name="description")
		private WebElement descriptionTextBoxForAddTestStatus;
		
		// Test status color code text box in add step status form.
		@FindBy(name="statusColor")
		private WebElement colorTextBoxForAddingTestStatus;
		
		// Add test status form header text.	
		@FindBy(xpath="//form[@id='AddExecStatusForm']/following-sibling::tbody/tr/td/h3[@class='formtitle']")
		private WebElement headerTextOfAddTestExecutionStatus;
		
		// Submit button in add a new test status page.
		@FindBy(id="add_submit")
		private WebElement submitButtonInAddTestExecutionStatus;
		
		@FindBy(xpath="//*[@id='delete_submit']")
		private WebElement deleteButtonInDeleteTestExecutionStatus;
		
		
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to update the test execution status.
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status.<br/>
     * <b>NEW_TEST_EXEC_STATUS</b> This parameter contains the new test execution status. <br/>
	 * <b>NEW_TEST_EXEC_STATUS_DESC</b> This parameter contains the new test execution status description. <br/>
	 * </p>
	 *  @return The boolean value i.e. True or False.
	 */
			
	public boolean updateTestExecutionStatus(Map<String, String> values){
		try{
			Assert.assertTrue(headerForTestExecutionStatusPageXpath.getText().equals("View Test Execution Statuses"), "This is not zfj Admin customize test status page.");
			logger.info("zfj admin customize test status page is verified successfully.");
			
			String xpathForMainTestExecutionStatusEditButton="//td[contains(text(),'"+values.get("TEST_EXEC_STATUS")+"')]/following-sibling::td/descendant::a[contains(text(),'Edit')]";
			CommonUtil.navigateThroughXpath(xpathForMainTestExecutionStatusEditButton);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				
			Assert.assertTrue(headerForTestExecutionStatusPageXpath.getText().equals("Edit Test Execution Status:"), "This is not zfj Admin edit test status page.");
			logger.info("zfj admin edit test status page is verified successfully.");
				
			statusTextBoxForTestStatus.clear();
			statusTextBoxForTestStatus.sendKeys(values.get("NEW_TEST_EXEC_STATUS"));
			descriptionTextBoxForTestStatus.clear();
			descriptionTextBoxForTestStatus.sendKeys(values.get("NEW_TEST_EXEC_STATUS_DESC"));
			submitButtonInEditTestExecutionStatus.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Test status is updated successfully.");
				
			Assert.assertTrue(headerForTestExecutionStatusPageXpath.getText().equals("View Test Execution Statuses"), "This is not zfj Admin customize test status page.");
			logger.info("zfj admin customize test status page is verified successfully.");
				
			Assert.assertTrue(CommonUtil.searchTheTextInList(allTestExecutionStatuses, values.get("NEW_TEST_EXEC_STATUS")), "zfj test execution status is not present in all test execution status list");
			logger.info("zfj test execution status ia present inside all test execution status.");
				
			String xpathForTakingDescForNewTestExecutionStatus="//td[text()='"+values.get("NEW_TEST_EXEC_STATUS")+"']/following-sibling::td[1]";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingDescForNewTestExecutionStatus), values.get("NEW_TEST_EXEC_STATUS_DESC"), "Test execution status description is not matched.");
			logger.info("Test execution Status Description is verified Successfully.");
			logger.info("Test status is updated successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to add a new test execution status.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>NEW_TEST_EXEC_STATUS</b> This parameter contains a new test execution status.<br/>
	 * <b>NEW_TEST_EXEC_STATUS_DESC</b> This parameter contains the new test execution status description. <br/>
	 * <b>NEW_TEST_EXEC_STATUS_COLORCODE</b> This parameter contains the new test execution status color code. <br/>
	 * </p>
	 *  @return The boolean value i.e. True or False.
	 */	
	//public boolean addTestExecutionStatus(String newTestStatusName, String testStatusDescription, String testStatusColor){
	
	public boolean addTestExecutionStatus(Map<String, String> values){
		try{
			Assert.assertTrue(headerForTestExecutionStatusPageXpath.getText().equals("View Test Execution Statuses"), "This is not zfj Admin customize test status page.");
			logger.info("zfj admin customize test status page is verified successfully.");
										
			Assert.assertTrue(headerTextOfAddTestExecutionStatus.getText().equals("Add a New Test Execution Status"), "Add a New Test Execution Status form is not present in this page.");
			logger.info("Add a New Test Execution Status form is present in this page.");
			
			statusTextBoxForAddTestStatus.clear();
			statusTextBoxForAddTestStatus.sendKeys(values.get("NEW_TEST_EXEC_STATUS"));
			descriptionTextBoxForAddTestStatus.clear();
			descriptionTextBoxForAddTestStatus.sendKeys(values.get("NEW_TEST_EXEC_STATUS_DESC"));
			colorTextBoxForAddingTestStatus.clear();
			colorTextBoxForAddingTestStatus.sendKeys(values.get("NEW_TEST_EXEC_STATUS_COLORCODE"));
			
			submitButtonInAddTestExecutionStatus.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Test status is crated successfully.");
								
			Assert.assertTrue(CommonUtil.searchTheTextInList(allTestExecutionStatuses, values.get("NEW_TEST_EXEC_STATUS")), "zfj test execution status is not present in all test execution status list");
			logger.info("zfj test execution status ia present inside all test execution status.");
			
			String xpathForTakingDescForNewTestExecutionStatus="//td[text()='"+values.get("NEW_TEST_EXEC_STATUS")+"']/following-sibling::td[1]";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingDescForNewTestExecutionStatus), values.get("NEW_TEST_EXEC_STATUS_DESC"), "Test execution status description is not matched.");
			logger.info(values.get("NEW_TEST_EXEC_STATUS")+" test execution Status Description is verified Successfully.");
			
			String xpathForTestExecutionStatusColorCode="//td[text()='"+values.get("NEW_TEST_EXEC_STATUS")+"']/following-sibling::td/table/tbody/tr/td";
			Assert.assertEquals(CommonUtil.getAttributeValue(xpathForTestExecutionStatusColorCode, "bgcolor"), values.get("NEW_TEST_EXEC_STATUS_COLORCODE"), "Test execution status color code is not matched.");
			logger.info(values.get("NEW_TEST_EXEC_STATUS")+" test Status colorcode is verified Successfully.");
				
			logger.info(values.get("NEW_TEST_EXEC_STATUS")+" test status is added successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}	
	public boolean deleteTestExecutionStatus(String testStatus){
		try{
			Assert.assertTrue(headerForTestExecutionStatusPageXpath.getText().equals("View Test Execution Statuses"), "This is not zfj Admin customize test status page.");
			logger.info("zfj admin customize test status page is verified successfully.");
			
			/*Assert.assertFalse(CommonUtil.searchTheTextInList(allTestExecutionStatuses, newTestStatus), "zfj new test execution status is present in all test execution status list already");
			logger.info("zfj test execution status ia present inside all test execution status.");*/
						
			Assert.assertTrue(CommonUtil.searchTheTextInList(allTestExecutionStatuses, testStatus), "zfj test execution status is not present in all test execution status list");
			logger.info("zfj test execution status ia present inside all test execution status.");
				
			String xpathForStepExecutionStatusEditButton="//td[contains(text(),'"+testStatus+"')]/following-sibling::td/descendant::a[contains(text(),'Delete')]";
			CommonUtil.navigateThroughXpath(xpathForStepExecutionStatusEditButton);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				
			Assert.assertTrue(headerForTestExecutionStatusPageXpath.getText().contains("Delete Zephyr Execution Status:"), "This is not zfj Admin Delete test status page.");
			logger.info("zfj admin edit test status page is verified successfully.");
			
			deleteButtonInDeleteTestExecutionStatus.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				
			/*statusTextBoxForTestStatus.clear();
			statusTextBoxForTestStatus.sendKeys(newTestStatus);
			descriptionTextBoxForTestStatus.clear();
			descriptionTextBoxForTestStatus.sendKeys(newTestDescription);
			submitButtonInEditTestExecutionStatus.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Test status is updated successfully.");
				*/
			Assert.assertTrue(headerForTestExecutionStatusPageXpath.getText().equals("View Test Execution Statuses"), "This is not zfj Admin customize test status page.");
			logger.info("zfj admin customize test status page is verified successfully.");
				
			Assert.assertFalse(CommonUtil.searchTheTextInList(allTestExecutionStatuses, testStatus), "zfj test execution status is not present in all test execution status list");
			logger.info("zfj test execution status ia present inside all test execution status.");
			
			/*Assert.assertFalse(CommonUtil.searchTheTextInList(allTestExecutionStatuses, oldTestStatus), "zfj test execution status is not present in all test execution status list");
			logger.info("zfj test execution status ia present inside all test execution status.");
						
			String xpathForTakingDescForNewTestExecutionStatus="//td[text()='"+newTestStatus+"']/following-sibling::td[1]";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingDescForNewTestExecutionStatus), newTestDescription, "Test execution status description is not matched.");
			logger.info("Test execution Status Description is verified Successfully.");*/
			logger.info("Test status is deleted successfully.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}

}