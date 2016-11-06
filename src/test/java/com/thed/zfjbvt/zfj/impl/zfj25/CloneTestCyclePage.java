package com.thed.zfjbvt.zfj.impl.zfj25;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;


public class CloneTestCyclePage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public static CloneTestCyclePage getInstance() {
		CloneTestCyclePage page = PageFactory.initElements(Driver.driver, CloneTestCyclePage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//webelement to validate clone Testcycle page.
	@FindBy(xpath="//*[@id='create-cycle-dialog']//h2")
	private WebElement xpathToValidateCloneTestCyclePage;
	
	// Test cycle name textbox Where we can give the name for the cycle.
	@FindBy(id="cycle_name")
	private WebElement cycleNameTextBox;
	
	// Test cycle submit button.
	@FindBy(xpath="//a[@id='zephyr-je-dlgclose']/following-sibling::input[@type='submit']")
	private WebElement saveButtonInCreateACycle;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	public String cloneTestCycle(){
		try{
			Assert.assertTrue(validatePage(), "Clone Test cycle page not validated.");
			String cycleName = CommonUtil.getAttributeValueUsingWebElements(cycleNameTextBox, "value");
			saveButtonInCreateACycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			return cycleName;
		}catch (Exception e) {
			return null;
		}
			
	}
	private boolean validatePage(){
		try{
			Assert.assertTrue(xpathToValidateCloneTestCyclePage.isDisplayed(),"Validating Clone TestCycle Page Failed...");
			logger.info("Clone Test cycle page validated successfully.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	/*public boolean cloneTestCycle(){
		try{
			Assert.assertTrue(xpathToValidateCloneTestCyclePage.isDisplayed(),"Validating Clone TestCycle Page Failed...");
			//cycleNameTextBox.clear();
			//cycleNameTextBox.sendKeys(values.get("CLONE_CYCLE_NAME"));
			saveButtonInCreateACycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			//values.put("CYCLE_NAME", values.get("CLONE_CYCLE_NAME"));
		}catch (Exception e) {
			return false;
		}
		//return PlanTestCyclePage.getInstance().validateCycle(values);
		
	}
		*/

}

