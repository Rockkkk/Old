package com.thed.zfjbvt.jira.impl.jira52;

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
	
	// xpath for all projects list
	@FindBy(xpath="//div[@id='none-panel']/descendant::tbody[@class='projects-list']/tr/td/img/following-sibling::a")
	private List<WebElement> allProjectList;
	
	// id of create project
	@FindBy(id="browse-projects-create-project")
	private WebElement createProjectButton;
	
	// id for create project Name
	@FindBy(id="add-project-name")
	private WebElement idForProjectName;
	
	// id for add project submit button
	@FindBy(id="dd-project-submit")
	private WebElement addProjectSubmitButton;
	public boolean selectProject(String projectName){
		try{
			Assert.assertTrue(CommonUtil.titleContains("Browse Projects", Constants.EXPLICIT_WAIT_LOW), "Page title is not same.");
			logger.info("Browse Projects page is selected successfully.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(CommonUtil.searchAndClickFromList(allProjectList, projectName), "Project is not present in the project list.");
			logger.info(projectName + " is selected successfully.");
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean createProject(String projectName){
		try{
			Assert.assertTrue(CommonUtil.titleContains("Browse Projects", Constants.EXPLICIT_WAIT_LOW), "Page title is not same.");
			logger.info("Browse Projects page is selected successfully.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(CommonUtil.searchTextInList(allProjectList, projectName), "Project is not selected successfully.");
			if(CommonUtil.searchTextInList(allProjectList, projectName)){
				
			} else {
				createProjectButton.click();
				CommonUtil.visibilityOfElementLocated("//div[@id='browse-projects-create-project-dialog']");
				idForProjectName.sendKeys(projectName);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				addProjectSubmitButton.click();
			}
			logger.info(projectName + " is selected successfully.");
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
