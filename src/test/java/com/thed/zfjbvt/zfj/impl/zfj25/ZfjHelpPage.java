package com.thed.zfjbvt.zfj.impl.zfj25;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class ZfjHelpPage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static ZfjHelpPage getInstance() {
		ZfjHelpPage page = PageFactory.initElements(Driver.driver, ZfjHelpPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//Xpath of the heading of the page 
	@FindBy(xpath="//*[@id='title-text']/a")
	private WebElement pageHeading;
	
	//id of the tooltip option of Zfj help page
	@FindBy(id="action-menu-link")
	private WebElement pageTooltip;
	
	//Xpath of the header on Zfj help page
	@FindBy(xpath="//*[@id='header']/nav")
	private WebElement pageHeader;
	
	//id of the sidebar options in Zfj help page
	@FindBy(id="splitter-sidebar")
	private WebElement pageSidebar;
	
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	public boolean validateZfjHelpPage(){
		try{
			String header=pageHeading.getText();
			Assert.assertTrue(CommonUtil.titleContains(header, Constants.IMPLICIT_WAIT_MEDIUM),"Launching ZFJ Help Page Failed...");
			Assert.assertTrue((pageTooltip.isDisplayed()) && (pageHeader.isDisplayed()) && (pageSidebar.isDisplayed()),"ZFJ Help page Objects are not Shown properly...");
			logger.info("ZFJ Help Page Confirmed...");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			CommonUtil.navigateBack();
		}catch(Exception e){
			CommonUtil.navigateBack();
			e.printStackTrace();
			return false;
			}
		return true;
	}

}