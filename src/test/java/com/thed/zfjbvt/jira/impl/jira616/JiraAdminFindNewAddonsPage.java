package com.thed.zfjbvt.jira.impl.jira616;

import java.util.List;
import org.apache.log4j.Logger;
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
	@FindBy(xpath="//div[@id='upm-container']/descendant::span[@id='upm-title']")
	private WebElement findNewAddonsPageheadertext;
	
	/*@FindBy(xpath="//div[@id='upm-panel-install']/descendant::div[@class='upm-plugin']")
	private List<WebElement> pluginNames;*/
	
	@FindBy(xpath="//div[@id='upm-panel-install']/descendant::div[@class='upm-plugin']/descendant:: *[@class='upm-plugin-name']")
	private List<WebElement> pluginNames;
	
		
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to find new add-ons on Atlassian Marketplace in JIRA and validating all plugins related to zephyr.
	 * @param searchText This parameter contains the search text which is used to find the add-ons on marketplace.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean findNewAddons(String searchText){
		try{
			Assert.assertTrue( CommonUtil.titleContains( "Find new add-ons", Constants.EXPLICIT_WAIT_LOW ) );
			logger.info( "Navigated Successfully to Find new add-ons page." );
			
			Assert.assertTrue(findNewAddonsPageheadertext.getText().equals("Atlassian Marketplace for JIRA"), "Header text is not validating for find new addons page.");
			logger.info("Find new Add-ons page is verified successfully.");
			
			CommonUtil.visibilityOfElementLocated("//div[@id='upm-panel-install']/descendant::div[@class='upm-plugin']/descendant:: *[@class='upm-plugin-name']");
			Assert.assertTrue(CommonUtil.scrollPage(findAddonsSearchBox), "Page is not scrolled to the plugin table.");
			logger.info("Page is Scrolled to find new plugin search text box.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			findAddonsSearchBox.sendKeys(searchText, Keys.ENTER);
			logger.info("Searching for new plugin list.");
			
			CommonUtil.presenceOfAllElementsLocatedBy("//div[@id='upm-panel-install']/descendant::div[@class='upm-plugin']/descendant:: *[@class='upm-plugin-vendor']");
			logger.info("New plugin is searched successfully");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			Assert.assertTrue(CommonUtil.scrollPage(CommonUtil.changeToWebElement("//div[@id='upm-panel-install']/descendant::div[@class='upm-plugin']/descendant:: *[@class='upm-plugin-name']")), "Page is not scrolled to the plugin table.");
			logger.info("Page is Scrolled to zephyr plugin table.");
			
			Assert.assertTrue( validatePlugin(), "Zephyr plugins are not validated.");
			logger.info("Zephyr plugins are validated successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	/**
	 * This method will validate all zephyr plugins present inside Atlassian Marketplace for JIRA.
	 * @return The boolean value True or False.
	 */
	private boolean validatePlugin(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			Assert.assertTrue(CommonUtil.searchTheTextInList(pluginNames, "Zephyr for JIRA - Test Management"),"Zephyr for JIRA is not found in search list of Addons.");
			logger.info("Zephyr for JIRA plug-in is verified successfully.");
			
			Assert.assertTrue(CommonUtil.searchTheTextInList(pluginNames, "Zephyr Enterprise Connector for JIRA"),"Zephyr Enterprise Connector for JIRA is not found in search list of Addons.");
			logger.info("Zephyr Enterprise Connector for JIRA plug-in is verified successfully.");
			
			Assert.assertTrue(CommonUtil.searchTheTextInList(pluginNames, "ZAPI"),"ZAPI is not found in search list of Addons.");
			logger.info("ZAPI plug-in is verified successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


}
