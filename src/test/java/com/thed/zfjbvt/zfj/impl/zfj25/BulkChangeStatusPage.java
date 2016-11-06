package com.thed.zfjbvt.zfj.impl.zfj25;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class BulkChangeStatusPage {
	
private Logger logger = Logger.getLogger(this.getClass());
	
	public static BulkChangeStatusPage getInstance() {
		BulkChangeStatusPage page = PageFactory.initElements(Driver.driver, BulkChangeStatusPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//xpath to Validate Bulk Change Status Page.
	@FindBy(xpath="//*[@id='bulk-change-id']//h2")
	private WebElement xpathToValidateBulkChangeStatusPage;
	
	//id to select new change in status.
	@FindBy(id="exec_status-bulk_change")
	private WebElement bulkTestStatusChange;
	
	//id of save button in bulk change status page.
	@FindBy(id="bulk-update-status-form-submit")
	private WebElement xpathOfSaveBtn;
	
	//xpath of bluk change success message.
	@FindBy(xpath="//*[@id='cycle-aui-message-bar']/div[@id=\"\"]/strong")
	private WebElement bulkChangeSuccessMsg;
	
	//id to select change test step status.
	@FindBy(id="exec_status_step_bulk_change")
	private WebElement selectTeststepChange;
	
	//id to select new change in step level status.
	@FindBy(id="exec_step_status_bulk_change")
	private WebElement bulkTeststepStatusChange;
	
	//id to clear defect mapping.
	@FindBy(id="exec-clear-defectmapping-id")
	private WebElement clearDefectsChckbox;
	
	//id to close bulk change status page.
	@FindBy(id="aui-dialog-close")
	private WebElement closeLink;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the <b>Bulk Status Change Page</b> when <b>Status link</b> is clicked from Search Test Execution Page.<br/>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	public boolean validateBulkChangeStatusPage(){
		try{
			Assert.assertTrue(xpathToValidateBulkChangeStatusPage.getText().equals("Bulk Change Status"),"Validating Bulk Change Status Page Failed...");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean changeStatus(String status){
		try{
			Select testStatusChange= new Select(bulkTestStatusChange);
			testStatusChange.selectByVisibleText(status);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathOfSaveBtn.click();
			validateStatusChangeMsg();
			  
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method clears the defect associated with the Test and Changes the Status to the specified Status.<br/>
	 * @param status, String value which will change the test status to specified status.</br>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	
	
	public boolean clearDefect(String status){
		try{
			clearDefectsChckbox.click();
			Select testStatusChange= new Select(bulkTestStatusChange);
			testStatusChange.selectByVisibleText(status);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathOfSaveBtn.click();
			validateStatusChangeMsg();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method changes both the Test and Test step Status to the specified status values.
	 * @param testStatus, String value which specifies the new Test Status that will be changed.</br> 
	 * @param teststepStatus, String value which specifies the new Test step Status that will be changed.</br>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	public boolean changeTeststepStatus(String testStatus, String teststepStatus){
		try{
			Select testStatusChange= new Select(bulkTestStatusChange);
			testStatusChange.selectByVisibleText(testStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			selectTeststepChange.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			Select teststepStatusChange= new Select(bulkTeststepStatusChange);
			teststepStatusChange.selectByVisibleText(teststepStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathOfSaveBtn.click();
			validateStatusChangeMsg();
			
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
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the <b>Bulk Status change Success Page</b> after <b>Bulk Tests Status are changed</b>.<br/>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	private boolean validateStatusChangeMsg(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(bulkChangeSuccessMsg.getText().contains("successfully updated"),"Bulk Change Failed...");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			closeLink.click();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

}




