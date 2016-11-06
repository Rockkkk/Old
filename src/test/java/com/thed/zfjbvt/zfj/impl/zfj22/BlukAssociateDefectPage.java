package com.thed.zfjbvt.zfj.impl.zfj22;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class BlukAssociateDefectPage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static BlukAssociateDefectPage getInstance() {
		BlukAssociateDefectPage page = PageFactory.initElements(Driver.driver, BlukAssociateDefectPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//xpath to validate bulk associate defect page.
	@FindBy(xpath="//*[@id='bulk-associate-defect-id']//h2")
	private WebElement xpathToValidateBulkAssociateDefectPage;
	
	//xpath of drop down to select defect in bulk associate defect page.
	@FindBy(xpath="//*[@id='zephyr-je-testkey-multi-select']/span")
	private WebElement dropDownLink;
	
	//id of save button in bulk associate defect page.
	@FindBy(id="bulk-move-cycle-form-submit")
	private WebElement xpathOfSaveBtn;
	
	//xpath of bulkAssociateDefectSuccessMsg.
	@FindBy(xpath="//*[@id='cycle-aui-message-bar']/div")
	private WebElement blukAssociateSuccessMsg;
	
	//id to close bulk associate defect page.
	@FindBy(id="aui-dialog-close")
	private WebElement closeLink;
	
	//xpath to get the defect added.
	@FindBy(xpath="//*[@id='zephyr-je-testkey-multi-select']/div[2]/ul/li/button/span/span")
	private WebElement getDefect;
	
	//xpath to add bulk defect.
	@FindBy(id="zephyr-je-testkey-textarea")
	private WebElement bulkAddDefect;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the <b>Bulk Associates Defects Page</b> when <b>Associate Defects link</b> is clicked from Search Test Execution Page.<br/>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	
	public boolean validateBulkAssociateDefectPage(){
		try{
			Assert.assertTrue(xpathToValidateBulkAssociateDefectPage.getText().equals("Bulk Associate Defect(s)"),"Validating Bulk Associate Page Failed...");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * Returns The issue_id which is Bulk Associated with the Tests Selected.</br>
	 * This Method Associates the Defect to Bulk Tests.</br>
	 * @return String <b>ISSUEID</b> the issue which is associated to the bulk tests.</br>
	 */
	
	
	
	public String associateDefect(String id){
		String issueId;
		try{
			bulkAddDefect.sendKeys(id);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().sendKeys(Keys.TAB).perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			issueId=getDefect.getText();
			xpathOfSaveBtn.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			validateStatusChangeMsg();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return issueId;
	}
	
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the <b>Bulk Associates Defects Success Page</b> after <b>Bulk Tests are Associated with the defect</b>.<br/>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	
	private boolean validateStatusChangeMsg(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(blukAssociateSuccessMsg.getText().contains("successfully updated"),"Bulk Change Failed...");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			closeLink.click();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
