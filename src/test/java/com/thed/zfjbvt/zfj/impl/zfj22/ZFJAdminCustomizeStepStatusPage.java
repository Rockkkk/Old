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

public class ZFJAdminCustomizeStepStatusPage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the ZFJ Admin CustomizeStepStatus Page and returns the page instance.
	 * @return This returns the ZFJ Admin CustomizeStepStatus Page instance.
	 */
	public static ZFJAdminCustomizeStepStatusPage getInstance() {
		ZFJAdminCustomizeStepStatusPage page = PageFactory.initElements(Driver.driver, ZFJAdminCustomizeStepStatusPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	// Webelements for header text for step execution status page. 
	@FindBy(xpath="//td[@class='jiraformheader']/h3[@class='formtitle formtitle-bamboo']")
	private WebElement headerForStepExecutionStatusPageXpath;
				
	// Webelements for all step execution statuses in test execution status page.
	@FindBy(xpath="//table[thead[tr[th[contains(text(),'Status')]]]]/tbody/tr/td[1]")
	private List<WebElement> allStepExecutionStatuses;
		
	/*Edit Test status page webelements.*/
	// Test status text box present in edit test status page.
	@FindBy(name="name")
	private WebElement statusTextBoxForStepStatus;
	
	// Test status description text box present in edit test status page.
	@FindBy(name="description")
	private WebElement descriptionTextBoxForStepStatus;
	
	// Color code textbox present in edit test status page.
	@FindBy(name="color")
	private WebElement colorTextBoxForStepStatus;
	
	// Submit button in edit test status page.
	@FindBy(id="edit_submit")
	private WebElement submitButtonInEditStepExecutionStatus;
	
	/*add new status webelements*/
	// Step status text box in add step status form.
	@FindBy(name="name")
	private WebElement statusTextBoxForAddStepStatus;
	
	// Step status description text box in add step status form.
	@FindBy(name="description")
	private WebElement descriptionTextBoxForAddStepStatus;
	
	// Step status color code text box in add step status form.
	@FindBy(name="statusColor")
	private WebElement colorTextBoxForAddingStepStatus;
	
	// Add step status form header text.	
	@FindBy(xpath="//form[@id='AddExecStatusForm']/following-sibling::tbody/tr/td/h3[@class='formtitle']")
	private WebElement headerTextOfAddStepExecutionStatus;
	
	// Submit button in add a new step status page.
	@FindBy(id="add_submit")
	private WebElement submitButtonInAddStepExecutionStatus;
							
	@FindBy(xpath="//*[@id='delete_submit']")
	private WebElement deleteButtonInDeleteTestExecutionStatus;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to update the step execution status.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>STEP_EXEC_STATUS</b> This parameter contains test execution status.<br/>
	 * <b>NEW_STEP_EXEC_STATUS</b> This parameter contains the new test execution status. <br/>
	 * <b>NEW_STEP_EXEC_STATUS_DESC</b> This parameter contains the new test execution status description. <br/>
	 * </p>
	 *  @return The boolean value i.e. True or False.
	 */
	//public boolean updateStepExecutionStatus(String stepExecutionStatus, String newStepStatusName, String newStepExecutionStatusDescription){
	
	public boolean updateStepExecutionStatus(Map<String, String> values){
		try{
			Assert.assertTrue(headerForStepExecutionStatusPageXpath.getText().equals("View Step Execution Statuses"), "This is not zfj Admin customize step status page.");
			logger.info("zfj admin customize test status page is verified successfully.");
			
			String xpathForStepExecutionStatusEditButton="//td[contains(text(),'"+values.get("STEP_EXEC_STATUS")+"')]/following-sibling::td/descendant::a[contains(text(),'Edit')]";
			CommonUtil.navigateThroughXpath(xpathForStepExecutionStatusEditButton);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			Assert.assertTrue(headerForStepExecutionStatusPageXpath.getText().equals("Edit Step Execution Status:"), "This is not zfj Admin edit step status page.");
			logger.info("zfj admin edit step status page is verified successfully.");
			
			statusTextBoxForStepStatus.clear();
			statusTextBoxForStepStatus.sendKeys(values.get("NEW_STEP_EXEC_STATUS"));
			descriptionTextBoxForStepStatus.clear();
			descriptionTextBoxForStepStatus.sendKeys(values.get("NEW_STEP_EXEC_STATUS_DESC"));
			submitButtonInEditStepExecutionStatus.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Step status is updated successfully.");
			
			Assert.assertTrue(headerForStepExecutionStatusPageXpath.getText().equals("View Step Execution Statuses"), "This is not zfj Admin customize step status page.");
			logger.info("zfj admin customize step status page is verified successfully.");
			
			Assert.assertTrue(CommonUtil.searchTheTextInList(allStepExecutionStatuses, values.get("NEW_STEP_EXEC_STATUS")), "zfj step execution status is not present in all step execution status list");
			logger.info("zfj step execution status ia present inside all step execution status.");
			
			String xpathForDescForNewStepExecutionStatus="//td[text()='"+values.get("NEW_STEP_EXEC_STATUS")+"']/following-sibling::td[1]";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForDescForNewStepExecutionStatus), values.get("NEW_STEP_EXEC_STATUS_DESC"), "Step execution status description is not matched.");
			logger.info("Step execution Status Description is verified Successfully.");
			logger.info("Step status is updated successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to add a new step execution status.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>NEW_STEP_EXEC_STATUS</b> This parameter contains a new test execution status.<br/>
	 * <b>NEW_STEP_EXEC_STATUS_DESC</b> This parameter contains the new test execution status description. <br/>
	 * <b>NEW_STEP_EXEC_STATUS_COLORCODE</b> This parameter contains the new test execution status color code. <br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	// public boolean addStepExecutionStatus(String newStepStatusName, String newStepStatusDescription, String newStepStatusColorCode){
	
	public boolean addStepExecutionStatus(Map<String, String> values){
		try{
			Assert.assertTrue(headerForStepExecutionStatusPageXpath.getText().equals("View Step Execution Statuses"), "This is not zfj Admin customize step status page.");
			logger.info("zfj admin customize test status page is verified successfully.");
							
			Assert.assertTrue(headerTextOfAddStepExecutionStatus.getText().equals("Add a New Step Execution Status"), "Add a New Step Execution Status form is not present in this page.");
			logger.info("Add a New Step Execution Status form is present in this page.");
			
			statusTextBoxForAddStepStatus.clear();
			statusTextBoxForAddStepStatus.sendKeys(values.get("NEW_STEP_EXEC_STATUS"));
			descriptionTextBoxForAddStepStatus.clear();
			descriptionTextBoxForAddStepStatus.sendKeys(values.get("NEW_STEP_EXEC_STATUS_DESC"));
			colorTextBoxForAddingStepStatus.clear();
			colorTextBoxForAddingStepStatus.sendKeys(values.get("NEW_STEP_EXEC_STATUS_COLORCODE"));
			submitButtonInAddStepExecutionStatus.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Step status is created successfully.");
						
			Assert.assertTrue(CommonUtil.searchTheTextInList(allStepExecutionStatuses, values.get("NEW_STEP_EXEC_STATUS")), "zfj step execution status is not present in all step execution status list");
			logger.info("zfj step execution status ia present inside all step execution status.");
			
			String xpathForTakingDescForNewTestExecutionStatus="//td[text()='"+values.get("NEW_STEP_EXEC_STATUS")+"']/following-sibling::td[1]";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingDescForNewTestExecutionStatus), values.get("NEW_STEP_EXEC_STATUS_DESC"), "Step execution status description is not matched.");
			logger.info(values.get("NEW_STEP_EXEC_STATUS")+" step execution Status Description is verified Successfully.");
			
			String xpathForTestExecutionStatusColorCode="//td[text()='"+values.get("NEW_STEP_EXEC_STATUS")+"']/following-sibling::td/table/tbody/tr/td";
			Assert.assertEquals(CommonUtil.getAttributeValue(xpathForTestExecutionStatusColorCode, "bgcolor"), values.get("NEW_STEP_EXEC_STATUS_COLORCODE"), "Step execution status color code is not matched.");
			logger.info(values.get("NEW_STEP_EXEC_STATUS")+" step execution status colorcode is verified Successfully.");
			
			
			logger.info(values.get("NEW_STEP_EXEC_STATUS")+" step execution status is added successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteStepExecutionStatus(String stepStatus){
		try{
			Assert.assertTrue(headerForStepExecutionStatusPageXpath.getText().equals("View Step Execution Statuses"), "This is not zfj Admin customize step status page.");
			logger.info("zfj admin customize test status page is verified successfully.");
			
			Assert.assertTrue(CommonUtil.searchTheTextInList(allStepExecutionStatuses, stepStatus), "zfj step execution status is not present in all step execution status list");
			logger.info("zfj step execution status ia present inside all step execution status.");
			
			String xpathForStepExecutionStatusEditButton="//td[contains(text(),'"+stepStatus+"')]/following-sibling::td/descendant::a[contains(text(),'Delete')]";
			CommonUtil.navigateThroughXpath(xpathForStepExecutionStatusEditButton);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			Assert.assertTrue(headerForStepExecutionStatusPageXpath.getText().contains("Delete Zephyr Execution Status:"), "This is not zfj Admin edit step status page.");
			logger.info("zfj admin Delete step status page is verified successfully.");
			
			deleteButtonInDeleteTestExecutionStatus.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			/*
			statusTextBoxForStepStatus.clear();
			statusTextBoxForStepStatus.sendKeys(values.get("NEW_STEP_EXEC_STATUS"));
			descriptionTextBoxForStepStatus.clear();
			descriptionTextBoxForStepStatus.sendKeys(values.get("NEW_STEP_EXEC_STATUS_DESC"));
			submitButtonInEditStepExecutionStatus.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Step status is updated successfully.");
			*/
			Assert.assertTrue(headerForStepExecutionStatusPageXpath.getText().equals("View Step Execution Statuses"), "This is not zfj Admin customize step status page.");
			logger.info("zfj admin customize step status page is verified successfully.");
			
			Assert.assertFalse(CommonUtil.searchTheTextInList(allStepExecutionStatuses, stepStatus), "zfj step execution status is still present in all step execution status list");
			logger.info("zfj step execution status ia present inside all step execution status.");
			
			/*String xpathForDescForNewStepExecutionStatus="//td[text()='"+values.get("NEW_STEP_EXEC_STATUS")+"']/following-sibling::td[1]";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForDescForNewStepExecutionStatus), values.get("NEW_STEP_EXEC_STATUS_DESC"), "Step execution status description is not matched.");
			logger.info("Step execution Status Description is verified Successfully.");*/
			logger.info("Step status is deleted successfully.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	

}
