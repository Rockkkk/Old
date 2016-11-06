package com.thed.zfjbvt.jira.impl.jira616;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

/**
 * This is JIRA's landing page, what user sees after login.
 * @author Manoj
 *
 */
public class JiraAdminAddonsPage {
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the Jira Landing Page and returns the page instance.
	 * @return This returns the Jira Landing Page instance.
	 */
	public static JiraAdminAddonsPage getInstance() {
		JiraAdminAddonsPage page = PageFactory.initElements(Driver.driver, JiraAdminAddonsPage.class);
		return page ;
	}
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	// Manage Addons link present inside addons page.
	//@FindBy(xpath="//li[a[@id='upm-admin-link']]")
	@FindBy(linkText="Manage add-ons")
	private WebElement manageAddonsLink;
	
	// Find New Addons link present inside addons page.
	@FindBy(xpath="//li[a[@id='upm-marketplace-link']]")
	private WebElement findNewAddonsLink;
	
	// Customize Test status Link in zephyr for jira link
	@FindBy(id="zephyr_execution_statuses")
	private WebElement zephyrCustomizeTestStatusTab;
	
	// Customize Step status Link in zephyr for jira link
	@FindBy(id="zephyr_step_execution_statuses")
	private WebElement zephyrCustomizeStepStatusTab;
	
	//ZFj General Configaration link.
	@FindBy(id="zephyr_general_configuration")
	private WebElement zephyrGeneralConfigurationLink;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * This method will navigate to Find new add-ons page from Addons page.
	 * @return JiraAdminFindNewAddonsPage instance.
	 */
	public JiraAdminFindNewAddonsPage navigateToFindNewAddonsPage(){
		try {
			if ( checkSelectedLink( findNewAddonsLink ) ) {
				Assert.assertTrue( CommonUtil.titleContains( "Find new add-ons", Constants.EXPLICIT_WAIT_LOW ) );
			} else {
				findNewAddonsLink.click();
				Assert.assertTrue( CommonUtil.titleContains( "Find new add-ons", Constants.EXPLICIT_WAIT_LOW ) );
			}
			logger.info( "Navigated Successfully to Find new add-ons page." );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return JiraAdminFindNewAddonsPage.getInstance();
	}
	/**
	* This method will navigate to Manage add-ons page from Addons page.
	* @return JiraAdminManageAddonsPage instance.
	*/
	public JiraAdminManageAddonsPage navigateToManageAddonsPage(){
		try {
				if (CommonUtil.titleContains( "Find new add-ons", Constants.EXPLICIT_WAIT_LOW )) {
					manageAddonsLink.click();
					Assert.assertTrue( CommonUtil.titleContains( "Manage add-ons", Constants.EXPLICIT_WAIT_LOW ) );
					
				} else {
					manageAddonsLink.click();
					Assert.assertTrue( CommonUtil.titleContains( "Manage add-ons", Constants.EXPLICIT_WAIT_LOW ) );
					
				}
					
				logger.info( "Navigated Successfully in Manage add-ons page." );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return JiraAdminManageAddonsPage.getInstance();
	}
	
	/**
	* This method will navigate to Customize Test Status tab from Addons page.
	* @return  The boolean Value True or False.
	*/
	public boolean navigateToCustomizeTestStatusTab(){
		try{
			if (CommonUtil.titleContains( "Find new add-ons", Constants.EXPLICIT_WAIT_LOW )) {
				zephyrCustomizeTestStatusTab.click();
				Assert.assertTrue( CommonUtil.titleContains( "Zephyr Testcase Execution Statuses Configuration", Constants.EXPLICIT_WAIT_LOW ) , "Zephyr Testcase Execution Statuses title is not versified successfully");
				
			} else {
				zephyrCustomizeTestStatusTab.click();
				Assert.assertTrue( CommonUtil.titleContains( "Zephyr Testcase Execution Statuses Configuration", Constants.EXPLICIT_WAIT_LOW ) , "Zephyr Testcase Execution Statuses title is not versified successfully");
				
			}
			logger.info( "Navigated Successfully to Customize Test Status Tab." );
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	* This method will navigate to Customize Step Status tab from Addons page.
	* @return The boolean Value True or False.
	*/
	public boolean navigateToCustomizeStepStatusTab(){
		try{
			if (CommonUtil.titleContains( "Find new add-ons", Constants.EXPLICIT_WAIT_LOW )) {
				zephyrCustomizeStepStatusTab.click();
				Assert.assertTrue( CommonUtil.titleContains( "Zephyr Step Execution Statuses Configuration ", Constants.EXPLICIT_WAIT_LOW ) , "Zephyr Testcase Execution Statuses title is not versified successfully");
				
			} else {
				zephyrCustomizeStepStatusTab.click();
				Assert.assertTrue( CommonUtil.titleContains( "Zephyr Step Execution Statuses Configuration ", Constants.EXPLICIT_WAIT_LOW ) , "Zephyr Testcase Execution Statuses title is not versified successfully");
				
			}
			logger.info( "Navigated Successfully to Customize Step Status Tab." );
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean checkSelectedLink(WebElement wb){
		try {
			if( wb.getAttribute("class").equals("aui-nav-selected") ){
				return true;
			} else {
				return false;
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean navigateToGeneralConfigarationPage(){
			try{
				Assert.assertTrue(CommonUtil.getTitle().contains("Find new add-ons"),"Launching Jira Admin page Failed...");
				zephyrGeneralConfigurationLink.click();
				Assert.assertTrue( CommonUtil.titleContains( "Zephyr Testcase Execution Statuses Configuration ", Constants.EXPLICIT_WAIT_LOW ) , "Zephyr General Configuration Page Validation Failed...");
				logger.info( "Successfully Navigated to General Configuration Page..." );
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
	
}
