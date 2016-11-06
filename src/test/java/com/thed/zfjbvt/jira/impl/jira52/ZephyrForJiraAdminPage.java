package com.thed.zfjbvt.jira.impl.jira52;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
//import com.thed.zfjbvt.jira.impl.jira52.JiraAdministrationPage;
//import com.thed.zfjbvt.jira.impl.jira52.JiraLandingPage;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
//import com.thed.zfjbvt.zfj.impl.zfj22.ZFJAdminCustomizeStepStatusPage;
//import com.thed.zfjbvt.zfj.impl.zfj22.ZFJAdminCustomizeTestStatusPage;

public class ZephyrForJiraAdminPage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	//private static ZephyrTestMenuPage zephyrTestMenuPage=ZephyrTestMenuPage.getInstance(JiraLandingPage.getInstance().getZephyrTestLink());
	/**
	 * This method will initialize all the webelements inside the ZFJ Admin Page and returns the page instance.
	 * @return This returns the ZFJ Admin Page instance.
	 */	
	public static ZephyrForJiraAdminPage getInstance() {
		ZephyrForJiraAdminPage page = PageFactory.initElements(Driver.driver, ZephyrForJiraAdminPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	/*In Administration Under zephyr For Zira Link webelements.*/
	// zfj admin page header text inside jira administration.
	@FindBy(id="admin-page-heading")
	private WebElement zfjAdminPageHeaderText;
	
	//General configuration tab in zephyr for jira link
	@FindBy(id="zephyr_general_configuration_tab")
	private WebElement zephyrGeneralConfigurationTab;
	
	//Zephyr Licence tab in zephyr for jira link
	@FindBy(id="zephyr_license_tab")
	private WebElement zephyrLicenceTab;
		
	//Test status tab in zephyr for jira link
	@FindBy(id="zephyr_execution_statuses_tab")
	private WebElement zephyrCustomizeTestStatusTab;
	
	// Test Step status tab in zephyr for jira link
	@FindBy(id="zephyr_step_execution_statuses_tab")
	private WebElement zephyrCustomizeStepExecutionTab;
	
	// General Information tab in jira administration zephyr for jira link.
	@FindBy(id="zephyr_info_configuration_tab")
	private WebElement zephyrGeneralInformationTab;
	
	// Workflow toolbar  check box in Zephyr for jira page.
	@FindBy(id="zephyr-show-workflow")
	private WebElement workflowToolbarChckbox;
	
	//issue link check box in Zephyr for jira page.
	@FindBy(id="zephyr-issuelink-check")
	private WebElement issueLinkChckbox;
	
	//remote issue link check box in Zephyr for jira page.
	@FindBy(id="zephyr-ril-check")
	private WebElement remoteIssueLinkChckbox;
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/

	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to navigate to customize test status page.
	 * @return The instance of ZFJ Admin CustomizeTestStatus Page.
	 */
	public boolean navigateToCustomizeTestStatusTab(){
		try{
			Assert.assertTrue(zfjAdminPageHeaderText.getText().equals("Zephyr for JIRA"), "This is not zfj Administration page.");
			logger.info("zfj admin page is verified successfully.");
			zephyrCustomizeTestStatusTab.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to navigate to customize step status page.
	 * @return The instance of ZFJ Admin CustomizeStepStatus Page.
	 */
	public boolean navigateToCustomizeStepStatusTab(){
		try{
			Assert.assertTrue(zfjAdminPageHeaderText.getText().equals("Zephyr for JIRA"), "This is not zfj Administration page.");
			logger.info("zfj admin page is verified successfully.");
			zephyrCustomizeStepExecutionTab.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	public boolean navigateToZfjGeneralConfigPage() {
		
		try{
			Assert.assertTrue(zfjAdminPageHeaderText.getText().equals("Zephyr for JIRA"), "This is not zfj Administration page.");
			logger.info("zfj admin page is verified successfully.");
			zephyrGeneralConfigurationTab.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
