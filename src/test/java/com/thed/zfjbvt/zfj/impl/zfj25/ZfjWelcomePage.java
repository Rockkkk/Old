package com.thed.zfjbvt.zfj.impl.zfj25;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class ZfjWelcomePage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static ZfjWelcomePage getInstance() {
		ZfjWelcomePage page = PageFactory.initElements(Driver.driver, ZfjWelcomePage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//Xpath of the heading of the page 
	@FindBy(xpath="//*[@id='content']/div/h1")
	private WebElement pageHeading;
	
	//Xpath of the entire content of the page
	@FindBy(xpath="//*[@id='content']/div/div[2]/div[1]")
	private WebElement pageContent;
	
	
	
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	public boolean validateZfjWelcomePage(){
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(((pageHeading.isDisplayed()) && (pageContent.isDisplayed())),"launching ZFJ Welcome page Failed...");
			logger.info("ZFJ Welcome Page Confirmed...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		return true;
	}

}
