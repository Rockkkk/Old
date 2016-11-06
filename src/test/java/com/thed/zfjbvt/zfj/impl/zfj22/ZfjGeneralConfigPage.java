package com.thed.zfjbvt.zfj.impl.zfj22;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thed.zfjbvt.util.Driver;

public class ZfjGeneralConfigPage {
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the ZFJ Admin Page and returns the page instance.
	 * @return This returns the ZFJ Admin Page instance.
	 */	
	public static ZfjGeneralConfigPage getInstance() {
		ZfjGeneralConfigPage page = PageFactory.initElements(Driver.driver, ZfjGeneralConfigPage.class);
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

	public boolean checkWorkflowOption(){
		try{
			
			if(workflowToolbarChckbox.isSelected()){
				logger.info("Workflow Toolbar option is Checked...");
				
			}
			else{
				logger.info("Workflow Toolbar option is Unchecked...");
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean changeWorkflowStatus(){
		try{
			workflowToolbarChckbox.click();
			if(workflowToolbarChckbox.isSelected()){
				logger.info("Workflow Toolbar option Checked now...");
			}
			else{
				logger.info("Workflow Toolbar option UnChecked now...");
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean checkIssueLink(){
		try{
			if(issueLinkChckbox.isSelected()){
				logger.info("Issue link for issue test checked...");
			}
			else{
				logger.info("Issue link for issue test unchecked...");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean changeIssueLinkStatus(){
		try{
			issueLinkChckbox.click();
			if(issueLinkChckbox.isSelected()){
				logger.info("Issue link for issue test checked now...");
			}
			else{
				logger.info("Issue link for issue test unchecked now...");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean checkRemoteIssueLink(){
		try{
			if(remoteIssueLinkChckbox.isSelected()){
				logger.info(" Remote Issue link for issue test checked...");
			}
			else{
				logger.info(" Remote Issue link for issue test unchecked...");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean changeRemoteIssueLinkStatus(){
		try{
			remoteIssueLinkChckbox.click();
			if(remoteIssueLinkChckbox.isSelected()){
				logger.info("Remote Issue link for issue test checked now...");
			}
			else{
				logger.info("Remote Issue link for issue test unchecked now...");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
