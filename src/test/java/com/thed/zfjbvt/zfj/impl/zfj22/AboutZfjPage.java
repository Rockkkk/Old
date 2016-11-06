package com.thed.zfjbvt.zfj.impl.zfj22;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class AboutZfjPage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static AboutZfjPage getInstance() {
		AboutZfjPage page = PageFactory.initElements(Driver.driver, AboutZfjPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//Xpath of the heading of the page.
	@FindBy(xpath="//*[@id='show-about-dialog']/*[@class][1]")
	private WebElement pageHeading;
	
	//Xpath of the version of ZFJ installed,that is displayed in the page.
	@FindBy(xpath="//h2[contains(text(),'Zephyr for JIRA')]/small")
	private WebElement zfjVersion;
	
	//id of the customer using ZFJ installed,that is displayed in the page.
	@FindBy(id="zCustomerId")
	private WebElement zfjCustomer;
	
	//xpath of the last support date avaliable for ZFj user,that is displayed in the page.
	@FindBy(xpath="//span[@id='zLicnese']/small/strong")
	private WebElement zfjLastSupportDate;
	
	//id of close link in Zfj page.
	@FindBy(id="aui-dialog-close")
	private WebElement zfjCloseLink;
	
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the <b>About Zephyr Page</b> when <b>About Zephyr link</b> is clicked.<br/>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	
	public boolean validateAboutZfjPage(){
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			String header=pageHeading.getText();
			String title=CommonUtil.getTitle();
			Assert.assertTrue(title.contains(header),"launching About ZFJ page Failed...");
			logger.info("About ZFJ page comfirmed...");
			
			String zephyrVersion=zfjVersion.getText();
			logger.info("Installed Zephyr for JIRA Version is: "+zephyrVersion+" ");
			
			String zephyrCustomerId=zfjCustomer.getText();
			logger.info("Zephyr for JIRA Customer id is: "+zephyrCustomerId+" ");
			
			String zephyrSupport=zfjLastSupportDate.getText();
			logger.info("Support for  Zephyr for JIRA until: "+zephyrSupport+" ");
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			zfjCloseLink.click();
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		return true;
	}
	

}
