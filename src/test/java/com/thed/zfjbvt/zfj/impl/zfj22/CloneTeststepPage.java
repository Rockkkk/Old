package com.thed.zfjbvt.zfj.impl.zfj22;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class CloneTeststepPage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static CloneTeststepPage getInstance() {
		CloneTeststepPage page = PageFactory.initElements(Driver.driver, CloneTeststepPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	@FindBy(xpath="//div[@class='jira-dialog-heading']/h2")
	private WebElement cloneStepHeadder;
	
	@FindBy(id="clone-test-step")
	private WebElement cloneStepValue;
	
	@FindBy(id="clone-append-below")
	private WebElement appendAfter;
	
	@FindBy(id="clone-append-above")
	private WebElement appendBefore;
	
	@FindBy(id="clone-insert-at")
	private WebElement insertAt;
	
	@FindBy(id="assign-issue-submit")
	private WebElement cloneStep;
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	public String appendAfterStep(int step){
		String cloneValue = null;
		try{
			validateCloneStepPage(step);
			if(!(appendAfter.isSelected())){
				appendAfter.click();
			}
			cloneValue = CommonUtil.getAttributeValueUsingWebElements(cloneStepValue, "title");
			cloneStep.click();
		}catch(Exception e){
			e.printStackTrace();
			return cloneValue;
		}
		return cloneValue;
	}
	
	public String insertAtStep(int step , int teststep){
		String cloneValue = null;
		try{
			validateCloneStepPage(teststep);
			insertAt.clear();
			insertAt.sendKeys(""+step);
			cloneValue = CommonUtil.getAttributeValueUsingWebElements(cloneStepValue, "title");
			cloneStep.click();
		}catch(Exception e){
			e.printStackTrace();
			return cloneValue;
		}
		return cloneValue;
	}
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	private boolean validateCloneStepPage(int step){
		try{
			Assert.assertTrue(CommonUtil.getAttributeValueUsingWebElements(cloneStepHeadder, "title").contains(""+step),"Not the same test step selected for cloning...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
