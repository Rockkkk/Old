package com.thed.zfjbvt.zfj.impl.zfj22;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj22.ViewTestPage;

public class CloneTestPage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static CloneTestPage getInstance() {
		CloneTestPage page = PageFactory.initElements(Driver.driver, CloneTestPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	//Xpath of the heading of clone test page.
	@FindBy(xpath="//*[@id='clone-issue-dialog']//h2")
	private WebElement xpathForGettingHeader;
	
	//id for getting test summary.
	@FindBy(id="summary")
	private WebElement xpathForGettingSummary;
		
	//id of create clone button.
	@FindBy(id="assign-issue-submit")
	private WebElement xpathToCreateClone;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	
	public boolean cloneTest(Map<String, String> values){
		try{
			if(xpathForGettingHeader.isDisplayed()){
				xpathForGettingSummary.clear();
				xpathForGettingSummary.sendKeys(values.get("CHANGE_SUMMARY_TO"));
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				xpathToCreateClone.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				values.put("SUMMARY",values.get("CHANGE_SUMMARY_TO") );
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return ViewTestPage.getInstance().validateCloneTest(values);
	}

}
