package com.thed.zfjbvt.zfj.impl.zfj173;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

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
	@FindBy(xpath="//*[text()='Gadget Directory']")
	private WebElement xpathToConfirmGadgetDirectory;
	
	//id to search gadget in gadget directory page.
	@FindBy(id="macro-browser-search")
	private WebElement xpathOfSearchGadget;
	
	//Xpath of finish button in gadget directory page.
	@FindBy(xpath="//div[span[@class='directory-help-link']]/button[3]")
	private WebElement xpathOfFinishButton;

	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	
	public boolean addGadget(String gadget){
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
			Assert.assertTrue((xpathToConfirmGadgetDirectory.isDisplayed())&& (xpathOfSearchGadget.isDisplayed())," launching Gadget Directory Failed...");
			xpathOfSearchGadget.clear();
			xpathOfSearchGadget.sendKeys(gadget);
			CommonUtil.changeToWebElement(("//li[div[h3[a[contains(text(),'"+gadget+"')]]]]/div/input[@value='Add it Now']")).click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathOfFinishButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
		}
		return TestMetricsPage.getInstance().saveGadgetAdded(gadget);
	}

}
