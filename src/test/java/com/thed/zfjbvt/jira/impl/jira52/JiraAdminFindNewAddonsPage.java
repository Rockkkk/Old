package com.thed.zfjbvt.jira.impl.jira52;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
/**
 * This is JIRA's Find new Addons page, where admin can see the marketplace and find new addons.
 * @author Manoj
 *
 */

public class JiraAdminFindNewAddonsPage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * This method will initialize all the webelements inside the Jira Admin FindNewAddons Page and returns the page instance.
	 * @return This returns the Jira Admin FindNewAddons Page instance.
	 */
	public static JiraAdminFindNewAddonsPage getInstance() {
		JiraAdminFindNewAddonsPage page = PageFactory.initElements(Driver.driver, JiraAdminFindNewAddonsPage.class);
		return page ;
	}
	
	/******************************************************
	 * 	XPATH
	 *****************************************************/
	
	//Search in the market place SearchBox where you can find any plugin.
	@FindBy(id="upm-install-search-box")
	private WebElement findAddonsSearchBox;
	
	// Find New Add-ons page header text.
	@FindBy(xpath="//div[@id='upm-container']/h2/span[@id='upm-title']")
	private WebElement findNewAddonsPageheadertext;
	
	@FindBy(xpath="//*[@class='upm-plugin-name']")
	private List<WebElement> pluginNames;
		
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to find new add-ons on Atlassian Marketplace in JIRA
	 * @param searchText This parameter contains the search text which is used to find the add-ons on marketplace.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean findNewAddons(String searchText){
		try{
			//commonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			//Assert.assertTrue(jiraAdminAuthenticatePage.authenticateAdminPassword(userName, password));
			//System.out.println(findNewAddonsPageheadertext.getText());
			Assert.assertTrue((findNewAddonsPageheadertext.getText()).equals("Atlassian Marketplace for JIRA"), "This is not Find New Add-ons Page.");
			logger.info("Find new Add-ons page is verified.");
			findAddonsSearchBox.sendKeys(searchText, Keys.ENTER);
			CommonUtil.visibilityOfElementLocated("//*[@id='upm-install-search']/div/div[@class='upm-plugin-list expandable install']");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("New plugin is searched successfully");
			JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
		    js.executeScript("javascript:window.scrollBy(250,400)"); 
		    CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(CommonUtil.searchTheTextInList(pluginNames, "Zephyr for JIRA - Test Management"),"Zephyr for JIRA is not found in search list of Addons.");
			logger.info("Zephyr for JIRA plug-in is verified successfully.");
			Assert.assertTrue(CommonUtil.searchTheTextInList(pluginNames, "Zephyr Enterprise Connector for JIRA"),"Zephyr Enterprise Connector for JIRA is not found in search list of Addons.");
			logger.info("Zephyr Enterprise Connector for JIRA plug-in is verified successfully.");
			Assert.assertTrue(CommonUtil.searchTheTextInList(pluginNames, "ZAPI"),"ZAPI is not found in search list of Addons.");
			logger.info("ZAPI plug-in is verified successfully.");
			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


}
