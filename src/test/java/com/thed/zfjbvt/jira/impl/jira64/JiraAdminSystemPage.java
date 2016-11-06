package com.thed.zfjbvt.jira.impl.jira64;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class JiraAdminSystemPage {
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the Jira System Page and returns the page instance.
	 * @return This returns the Jira Landing Page instance.
	 */
	public static JiraAdminSystemPage getInstance() {
		JiraAdminSystemPage page = PageFactory.initElements(Driver.driver, JiraAdminSystemPage.class);
		return page ;
	}
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	// Jelly Runner link present inside System page.
	@FindBy(xpath="//*[@id='jelly_runner']")
	private WebElement jellyRunnerLink;
	
	// Jelly Runner page Jelly Script file Path
	@FindBy(xpath="//*[contains(text(),'Jelly Script file path')]/following-sibling::td/input[@name='filename']")
	private WebElement jellyScriptFilePath;
	
	// Jelly Runner page jelly script text area where you can put your jelly script directly.
	@FindBy(xpath = "//*[contains(text(),'Jelly Script (XML)')]/following-sibling::td/textarea[@name='script']")
	private WebElement jellyRunnerTextArea;
	
	// Jelly Runner run button
	@FindBy(xpath = "//*[@id='run_submit']")
	private WebElement jellyScriptRunButton;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	public JiraAdminSystemPage navigateToJellyRunnerPage(){
		try {
			Assert.assertTrue(validatePage(), "Jira configuration Page is not validated.");	
			jellyRunnerLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info( "Clicked on in Jelly Runner Link." );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return JiraAdminSystemPage.getInstance();
	}
	
	public boolean executeJellyRunner(){
		try{
			Assert.assertTrue( CommonUtil.titleContains( "Jelly Runner", Constants.EXPLICIT_WAIT_LOW ), "Jelly Runner page title validation failed." );
			logger.info("Jelly Runner page is validated successfully.");
			
			jellyRunnerTextArea.clear();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			jellyScriptFilePath.clear();
			String x= Config.getValue("PATH") + "/jellyScript.xml";
			File ff = new File(x);
			if(ff.exists()) {
				System.out.println("pass");
			} else {
				System.out.println("fail");
			}
			System.out.println(x);
			jellyScriptFilePath.sendKeys(ff.getAbsolutePath());
			jellyScriptRunButton.click();
			CommonUtil.visibilityOfElementLocated("//tr[td[h3[text()='Jelly Runner']]]/following-sibling::tr/td/p");
			String xpathForSuccessfulMessage = "//tr[td[h3[text()='Jelly Runner']]]/following-sibling::tr/td/p";
			Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForSuccessfulMessage).contains("Jelly script completed successfully."), "Jelly Script is not executed successfully.");
			logger.info("Jelly Script is executed successfully.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	private boolean validatePage(){
		try{
			Assert.assertTrue( CommonUtil.titleContains( "JIRA Configuration", Constants.EXPLICIT_WAIT_LOW ), "JIRA Configuration page title validation failed." );
			logger.info("JIRA Configuration page is validated successfully.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
}
