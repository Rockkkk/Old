package com.thed.zfjbvt.zfj.impl.zfj25;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj25.TestMetricsPage;

public class GadgetDirectoryPage {
	
	private Logger logger = Logger.getLogger(this.getClass());
	public static GadgetDirectoryPage getInstance() {
		GadgetDirectoryPage page = PageFactory.initElements(Driver.driver, GadgetDirectoryPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	//Xpath to confirm gadget directory page.
	@FindBy(xpath="//*[@id='gadget-dialog']/header//h1")
	private WebElement xpathToConfirmGadgetDirectory;
	
	//id to search gadget in gadget directory page.
	@FindBy(xpath="//*[@id='search']")
	private WebElement xpathOfSearchGadget;

	// Old Gadgets for Test metrics will work in 6.3 and below
	//Xpath to confirm gadget directory page.
	@FindBy(xpath="//*[text()='Gadget Directory']")
	private WebElement xpathToConfirmGadgetDirectoryOld;
	
	// Old Gadgets for Test metrics will work in 6.3 and below
	//id to search gadget in gadget directory page.
	@FindBy(id="macro-browser-search")
	private WebElement xpathOfSearchGadgetOld;
	
	//Xpath of finish button in gadget directory page.
	@FindBy(xpath="//div[span[@class='directory-help-link']]/button[3]")
	private WebElement xpathOfFinishButton;

	
	//Xpath of close link in gadget directory page[in jira 6.1.x and 6.2]
	@FindBy(xpath="//*[@id='gadget-dialog']/header//a/span[text()='Close']")
	private WebElement closeLink;

	//Xpath of close link in gadget directory page[in jira 6.1.x and 6.2]
	@FindBy(xpath="//*[@id='macro-browser-dialog']/div[1]/div[2]/a")
	private WebElement closeLinkOld;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	
	public boolean addGadget(String gadget){
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
			if(Config.getValue("JIRA_VERSION").equals("6.4")){
				CommonUtil.ExplicitWaitForElement(xpathToConfirmGadgetDirectory);
				CommonUtil.ExplicitWaitForElement(xpathOfSearchGadget);
				Assert.assertTrue((xpathToConfirmGadgetDirectory.isDisplayed())&& (xpathOfSearchGadget.isDisplayed())," launching Gadget Directory Failed...");
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				xpathOfSearchGadget.clear();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				xpathOfSearchGadget.sendKeys(gadget);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement(("//div[*[contains(text(),'"+gadget+"')]]/following-sibling::div/button[text()='Add gadget']")).click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				try{
					closeLink.click();
					
				}catch(Exception e){
					//xpathOfFinishButton.click();
					closeLink.click();
				}
			}else{
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
				CommonUtil.ExplicitWaitForElement(xpathToConfirmGadgetDirectoryOld);
				CommonUtil.ExplicitWaitForElement(xpathOfSearchGadgetOld);
				Assert.assertTrue((xpathToConfirmGadgetDirectoryOld.isDisplayed())&& (xpathOfSearchGadgetOld.isDisplayed())," launching Gadget Directory Failed...");
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				xpathOfSearchGadgetOld.clear();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				xpathOfSearchGadgetOld.sendKeys(gadget);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.changeToWebElement(("//li[div[h3[a[contains(text(),'"+gadget+"')]]]]/div/input[@value='Add it Now']")).click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				try{
					closeLinkOld.click();
					
				}catch(Exception e){
					xpathOfFinishButton.click();
				}
			}
			
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
		return TestMetricsPage.getInstance().saveGadgetAdded(gadget);
	}

}
