package com.thed.zfjbvt.zfj.impl.zfj25;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class BulkCopyToCyclePage {

private Logger logger = Logger.getLogger(this.getClass());
	
	public static BulkCopyToCyclePage getInstance() {
		BulkCopyToCyclePage page = PageFactory.initElements(Driver.driver, BulkCopyToCyclePage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	//xpath to validate bulk copy to cycle page.
	@FindBy(xpath="//*[@id='bulk-move-cycle-id']//h2")
	private WebElement xpathToValidateBulkCopyToCyclePage;
	
	//id to select project.
	@FindBy(id="execProjectId")
	private WebElement selectProject;
		
	//id to select version.
	@FindBy(id="projectVersionId")
	private WebElement selectVersion;
		
	//id to select cycle.
	@FindBy(id="versionCycleId")
	private WebElement selectCycle;
	
	//id of clear defect mapping in bulk move to cycle page.
	@FindBy(id="exec-clear-defectmapping-id")
	private WebElement clearDefectLink;
		
	//id of clear execution status in bulk move to cycle page.
	@FindBy(id="exec-clear-execstatus-id")
	private WebElement clearExecutionStatusLink;
	
	//id of save button in bulk move to cycle page.
	@FindBy(id="bulk-move-cycle-form-submit")
	private WebElement saveButn;
	
	//id to create a new cycle in bulk move to cycle page.
	@FindBy(id="cycle_name")
	private WebElement createNewCycle;
	
	//id to close bulk associate defect page.
	@FindBy(id="aui-dialog-close")
	private WebElement closeLink;
	
	//xpath to get the number of Executed Test Copied.
	@FindBy(xpath="//*[@id='cycle-aui-message-bar']/div/strong")
	private WebElement listOfTestCopied;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	public boolean validateBulkCopyToCyclePage(){
		try{
			Assert.assertTrue(xpathToValidateBulkCopyToCyclePage.getText().equals("Bulk Copy to existing/new Cycle"),"Validating Bulk Associate Page Failed...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean copyBulkTestToCycle(String version, String cycle){
		try{
			Select project= new Select(selectProject);
			project.selectByVisibleText(Config.getValue("JIRA_PROJECT"));
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			Select versionselect= new Select(selectVersion);
			versionselect.selectByVisibleText(version);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			Select cycleSelect= new Select(selectCycle);
			for(int i = 0; i<cycleSelect.getOptions().size();i++){
				if(cycleSelect.getOptions().get(i).getText().equals(cycle)){
					cycleSelect.selectByVisibleText(cycle);
					break;
				}
			}
			if(cycleSelect.getFirstSelectedOption().getText().equals(cycle)==false){
				cycleSelect.selectByVisibleText("Create New Cycle");
				createNewCycle.clear();
				createNewCycle.sendKeys(cycle);
			}
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			saveButn.click();
			validateBulkCopySuccessMsg();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean copyBulkTestToCycleWithDefects(String version, String cycle){
		try{
			if(clearDefectLink.isSelected()){
				clearDefectLink.click();
			}
			if(clearExecutionStatusLink.isSelected()){
				clearExecutionStatusLink.click();
			}
			Select project= new Select(selectProject);
			project.selectByVisibleText(Config.getValue("JIRA_PROJECT"));
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			Select versionselect= new Select(selectVersion);
			versionselect.selectByVisibleText(version);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			Select cycleSelect= new Select(selectCycle);
			for(int i = 0; i<cycleSelect.getOptions().size();i++){
				if(cycleSelect.getOptions().get(i).getText().equals(cycle)){
					cycleSelect.selectByVisibleText(cycle);
					break;
				}
			}
			if(cycleSelect.getFirstSelectedOption().getText().equals(cycle)==false){
				cycleSelect.selectByVisibleText("Create New Cycle");
				createNewCycle.clear();
				createNewCycle.sendKeys(cycle);
			}
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			saveButn.click();
			validateBulkCopySuccessMsg();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	
	private boolean validateBulkCopySuccessMsg(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(listOfTestCopied.isDisplayed(),"Test Copying Failed...");
			logger.info("Execution Copied are: "+listOfTestCopied.getText()+"");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			closeLink.click();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
