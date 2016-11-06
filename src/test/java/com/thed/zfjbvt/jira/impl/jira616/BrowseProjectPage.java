package com.thed.zfjbvt.jira.impl.jira616;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class BrowseProjectPage {
	private Logger logger = Logger.getLogger( this.getClass() );
	public static BrowseProjectPage getInstance() {
		return PageFactory.initElements( Driver.driver, BrowseProjectPage.class);
	}
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	// All projects link text.
	@FindBy(id="all-panel-tab-lnk")
	private WebElement allProjectsLink;
	
	// xpath for all projects list
	@FindBy(xpath="//div[@id='none-panel']/descendant::tbody[@class='projects-list']/tr/td[@data-cell-type='name']/a")
	private List<WebElement> allProjectList;
	
	// id of create project
	@FindBy(id="browse-projects-create-project")
	private WebElement createProjectButton;

	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	public boolean selectProject(String projectName){
		try{
			Assert.assertTrue(CommonUtil.titleContains("Browse Projects", Constants.EXPLICIT_WAIT_LOW), "Browse Project Page title is not same.");
			logger.info("Browse Projects page is selected successfully.");
			//allProjectsLink.click();
			//Assert.assertTrue(CommonUtil.visibilityOfElementLocated("//div[@id='none-panel' and @class='module inall active']"));
			Assert.assertTrue(CommonUtil.searchAndClickFromList(allProjectList, projectName), "Project is not selected successfully.");
			logger.info(projectName + " is selected successfully.");
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteProject(String projectName, String userName, String password){
		try{
			//Assert.assertTrue(CommonUtil.titleContains("Browse Projects", Constants.EXPLICIT_WAIT_LOW), "Browse Project Page title is not same.");
			//logger.info("Browse Projects page is selected successfully.");
			//allProjectsLink.click();
			//Assert.assertTrue(CommonUtil.visibilityOfElementLocated("//div[@id='none-panel' and @class='module inall active']"));
			Assert.assertTrue(CommonUtil.searchTheTextInList(".//*[@id='project-list']/descendant::a[contains(@id,'view-project-')]", projectName), "Project is not searched successfully.");
			logger.info(projectName + " is Searched successfully.");
			
			CommonUtil.navigateThroughXpath("//td[a[text()='"+projectName+"']]/following-sibling::td/descendant::a[contains(@id,'delete_project')]");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			if ( CommonUtil.getTitle().contains("Administrator Access") ) {
				Assert.assertTrue( JiraAdministrationAuthenticatePage.getInstance().authenticateAdminPassword(userName, password), "Jira Administrator is not authenticate successsfully." );
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				logger.info("Administrator is authenticate successfully.");
			}
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath("//td/*[@class='formtitle']").contains("Delete Project:"), "Delete project confirmation popup is not validated.");
			logger.info("Delete project confirmation popup is validated successfully.");
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath("//td/*[@class='formtitle']").contains(projectName), "Delete project name in popup is not validated.");
			logger.info("Delete project Name in confirmation popup is validated successfully.");
			CommonUtil.navigateThroughXpath(".//*[@id='delete_submit']");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			
			Assert.assertFalse(CommonUtil.searchTheTextInList(".//*[@id='project-list']/descendant::a[contains(@id,'view-project-')]", projectName), "Project is still present After delete.");
			logger.info(projectName + " is Deleted successfully.");
			
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
}
