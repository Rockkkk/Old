package com.thed.zfjbvt.jira.impl.jira64;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.*;
/**
 * This is JIRA's Login page, what user sees before login i.e. where user gives username and password.
 * @author Manoj
 *
 */

public class LoginPage {
	/**
	 * This method will initialize all the webelements inside the Login Page and returns the page instance.
	 * @return This returns the Login Page instance.
	 */
	public static LoginPage getInstance() {
		LoginPage page = PageFactory.initElements(Driver.driver, LoginPage.class);
		return page;
	}
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	/******************************************************
	 * 	XPATH
	 *****************************************************/
	// username edit box in jira's login page.	
	@FindBy(id="login-form-username")
	private WebElement usernameEditbox;
	
	// password edit box in jira's login page.		
	@FindBy(id="login-form-password")
	private WebElement passwordEditbox;
	
	// Lohin button in jira's login page.		
	@FindBy(id="login-form-submit")
	private WebElement loginButton;
	
	// Login again link in Jira's login page.
	@FindBy(xpath="//a[text()='Log in again.']")
	private WebElement xpathForLogInAgain;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * 
	 * This method is used to login to jira and it will show jira landing page.
	 * @param JIRA_USERNAME This parameter contains jira's username for lagin to jira.
	 * @param JIRA_PASSWORD This parameter contains jira's password for lagin to jira.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean login(String userName, String password){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			usernameEditbox.clear();
			usernameEditbox.sendKeys(userName);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			passwordEditbox.clear();
			passwordEditbox.sendKeys(password);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			loginButton.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Login to Jira Successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * This method is used to click on login again link after logout from jira.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean loginAgain(){
		try{
			Assert.assertTrue(CommonUtil.titleContains("Logout", Constants.EXPLICIT_WAIT_LOW), "Not Validated Logout Page.");
			logger.info("Validated Logout Page.");
			xpathForLogInAgain.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Clicked in login again link.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
