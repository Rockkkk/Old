package com.thed.zfjbvt.jira.impl.jira52;

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
	 * This method will initialize all the webelements inside the JiraA dministration Authenticate Page and returns the page instance.
	 * @return This returns the JJira Administration Authenticate Page instance.
	 */
	public static JiraAdministrationAuthenticatePage getInstance() {
		JiraAdministrationAuthenticatePage page = PageFactory.initElements(Driver.driver, JiraAdministrationAuthenticatePage.class);
		return page ;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	// Administrator authenticate page header text webelement.
	@FindBy(xpath="//section[@id='content']/div/div/header")
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
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to validate the administrator by giving admin password. Here first it will check the admin username then it will give password and validate it.
	 * @param userName This parameter contains the username of the admin for validating.
	 * @param password This parameter contains the password of the admin for validating.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean authenticateAdminPassword(String userName, String password){
		try{
			Assert.assertTrue(administratorPageheadertext.getText().equals("Administrator Access")," This is not Administration authenticate page.");
			logger.info("Administrator authenticate page is verified successfully.");
			if(userName.equals(getUsername())){
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
