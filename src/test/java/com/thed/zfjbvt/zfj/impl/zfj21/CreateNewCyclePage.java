package com.thed.zfjbvt.zfj.impl.zfj21;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj21.CalenderPopupPage;
import com.thed.zfjbvt.zfj.impl.zfj21.PlanTestCyclePage;

public class CreateNewCyclePage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static CreateNewCyclePage getInstance() {
		return PageFactory.initElements(Driver.driver, CreateNewCyclePage.class);
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	// Create new cycle header text.
	@FindBy(xpath="//div[@id='create-cycle-dialog']/h2[@class='aui-popup-heading']")
	private WebElement createNewCycleHeadingText;
	
	// Create new cycle header text.
	@FindBy(xpath="//div[@id='edit-cycle-dialog']/h2[@class='aui-popup-heading']")
	private WebElement editCycleHeadingText;
		
	// Select the cycle version from select cycle drop down list.
	@FindBy(id="cycle_version")
	private WebElement selectVersionDropDownSelectList;
	
	// Test cycle name textbox Where we can give the name for the cycle.
	@FindBy(id="cycle_name")
	private WebElement cycleNameTextBox;
		
	// Test cycle description textarea Where we can give the description for the cycle.
	@FindBy(id="cycle_description")
	private WebElement cycleDescriptionTextArea;
	
	// Test cycle build textbox Where we can give the buildname for the cycle.
	@FindBy(id="cycle_build")
	private WebElement cycleBuildNameTextBox;
	
	// Test cycle enviroment textbox Where we can give the description for the cycle.
	@FindBy(id="cycle_environment")
	private WebElement cycleEnviromentNameTextBox;
	
	// Test cycle start date link Where we can select the date for the cycle.
	@FindBy(xpath="//a[@id='startDate-trigger']/span")
	private WebElement cycleStartDateLink;
		
	//  Test cycle end date link Where we can select the end date for the cycle.		 
	@FindBy(xpath="//a[@id='endDate-trigger']/span")
	private WebElement cycleEndDateLink;
	
	// Test cycle cancel button .
	@FindBy(id="zephyr-je-dlgclose")
	private WebElement cancelButtonInCreateCycle;
	
	// Test cycle submit button.
	@FindBy(xpath="//a[@id='zephyr-je-dlgclose']/following-sibling::input[@type='submit']")
	private WebElement saveButtonInCreateACycle;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * 
	 * This method is used to create a new cycle  by taking cycle name, description and start date from the map.
	 * This method will take a map which contains VERSION_NAME, CYCLE_NAME, CYCLE_DESC and CYCLE_START_DATE.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>CYCLE_DESC</b> This parameter contains the cycle description which is used for creating the cycle in zfj. <br/>
	 * <b>CYCLE_START_DATE</b>  This parameter contains the cycle start date which is used for creating the cycle in zfj.<br/>
	 * </p>
	 * @return It returns the boolean value True or False.
	 */
	//public boolean createANewCycle(String cycleName, String cycleDescription, String cycleStartDate){
	public boolean createNewCycle(Map<String, String> values){
		try{
			Assert.assertTrue(createNewCycleHeadingText.getText().equals("Create New Cycle"), "Create New Cycle page is not verified successfully.");
			logger.info("Create New Cycle page is verified successfully.");
			cycleNameTextBox.clear();
			cycleNameTextBox.sendKeys(values.get("CYCLE_NAME"));
			cycleDescriptionTextArea.clear();
			cycleDescriptionTextArea.sendKeys(values.get("CYCLE_DESC"));
			cycleStartDateLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(CalenderPopupPage.getInstance().selectCalender(values.get("CYCLE_START_DATE")), "Date is not selected successfully from calender.");
			saveButtonInCreateACycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info(values.get("CYCLE_NAME")+" cycle is created successfully.");
			
			Assert.assertTrue(PlanTestCyclePage.getInstance().validateCycle(values), values.get("CYCLE_NAME")+" is not validated successfully.");
			logger.info(values.get("CYCLE_NAME")+" is validated successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//public boolean editCycle(String cycleName, String cycleDesc, String buildName, String envName, String cycleStartDate, String cycleEndDate){
	public boolean editCycle(Map<String, String> values){
		
		try{
			Assert.assertTrue(editCycleHeadingText.getText().equals("Edit Cycle"), "Create New Cycle page is not verified successfully.");
			logger.info("Create New Cycle page is verified successfully.");
			
			cycleNameTextBox.clear();
			cycleNameTextBox.sendKeys(values.get("NEW_CYCLE_NAME"));
			cycleDescriptionTextArea.clear();
			cycleDescriptionTextArea.sendKeys(values.get("CYCLE_DESC"));
			cycleBuildNameTextBox.clear();
			cycleBuildNameTextBox.sendKeys(values.get("BUILD_NAME"));
			cycleEnviromentNameTextBox.clear();
			cycleEnviromentNameTextBox.sendKeys(values.get("ENV_NAME"));
			cycleStartDateLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(CalenderPopupPage.getInstance().selectCalender(values.get("CYCLE_START_DATE")), "Start date is not selected successfully from calender.");
			cycleEndDateLink.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(CalenderPopupPage.getInstance().selectCalender(values.get("CYCLE_END_DATE")), "End date is not selected successfully from calender.");
			
			saveButtonInCreateACycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info(values.get("CYCLE_NAME")+" cycle is created successfully.");
			
			//Assert.assertTrue(PlanTestCyclePage.getInstance().validateCycle(values), cycleName+" is not validated successfully.");
			//logger.info(cycleName+" is validated successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

}

