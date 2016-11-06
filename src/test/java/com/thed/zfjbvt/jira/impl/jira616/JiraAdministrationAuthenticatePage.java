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
 * This is JIRA's Administrator access page, what administrator authenticate by validating username and password.
 * @author Manoj
 *
 */

public class JiraAdministrationAuthenticatePage {
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the JiraAdministration Authenticate Page and returns the page instance.
	 * @return This returns the Jira Administration Authenticate Page instance.
	 */
	public static JiraAdministrationAuthenticatePage getInstance() {
		JiraAdministrationAuthenticatePage page = PageFactory.initElements(Driver.driver, JiraAdministrationAuthenticatePage.class);
		return page ;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	// Administrator authenticate page header text webelement.
	@FindBy(xpath="//*[@id='content']/descendant::header")
	private WebElement administratorPageheadertext;
	
	// Administrator username textbox webelement.
	@FindBy(id="login-form-username")
	private WebElement adminUsernameTextBox;
	
	// Administrator authenticate page password textbox.
	@FindBy(id="login-form-authenticatePassword")
	private WebElement adminPasswordTextBox;
	
	// Administrator authenticate page confirmation button.
	@FindBy(id="login-form-submit")
	private WebElement adminAuthenticateConfirmButton;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * This method is used to validate the administrator. Here first it will check the admin username then it will give password and validate it.
	 * @param userName This parameter contains the admin username.
	 * @param password This parameter contains the admin password.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean authenticateAdminPassword(String userName, String password){
		try{
			Assert.assertTrue(CommonUtil.titleContains("Administrator Access", Constants.EXPLICIT_WAIT_LOW), "Administrator access page title validation failed.");
			logger.info("Administrator Access page title validated successfully.");
			Assert.assertEquals(administratorPageheadertext.getText(), "Administrator Access", "Administrator access page header validation failed.");
			logger.info("Administrator Access page header validated successfully.");
			if(userName.trim().equals(getUsername())){
					adminPasswordTextBox.sendKeys(password);
					adminAuthenticateConfirmButton.click();
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			}else{
					adminUsernameTextBox.sendKeys(userName);
					adminPasswordTextBox.sendKeys(password);
					adminAuthenticateConfirmButton.click();
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
	     	}
			logger.info("Administrator authenticate successfully by giving password.");		
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	private String getUsername(){
		return adminUsernameTextBox.getText();
	}
	

}
