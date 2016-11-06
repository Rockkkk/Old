package com.thed.zfjbvt.zfj.impl.zfj25;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj25.ViewTestPage;

public class LinkIssuePage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static LinkIssuePage getInstance() {
		LinkIssuePage page = PageFactory.initElements(Driver.driver, LinkIssuePage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	//Xpath to validate the link issue page.
	@FindBy(xpath="//*[@id='link-issue-dialog']//h2")
	private WebElement xpathForLinkIssueHeader;
	
	//id for link type.
	@FindBy(id="link-type")
	private WebElement xpathForLinkType;
	
	//xpath of drop down for selecting issue.
	@FindBy(xpath="//*[@id='jira-issue-keys-multi-select']/span")
	private WebElement xpathForSelectingIssue;
	
	//id for comment for the link issue page.
	@FindBy(id="comment")
	private WebElement xpathForComment;
	
	//name for link button in link issue page.
	@FindBy(name="Link")
	private WebElement xpathForLinkButton;
	
	//id to enter the issue id.
	@FindBy(id="jira-issue-keys-textarea")
	private WebElement xpathForIssueType;
	
	
	
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	public boolean linkTest(Map<String, String> values){
		try{
			String[] issueId=values.get("TESTID").split("-");
			int idNum=Integer.parseInt(issueId[1]);
			String issue=issueId[0]+"-"+""+(idNum-1);
			values.put("TESTID", issue);
			Assert.assertTrue(xpathForLinkIssueHeader.isDisplayed(),"Not in Link Issue Page");
			String selectLinkType=CommonUtil.getAttributeValueUsingWebElements(xpathForLinkType, "value");
			if(selectLinkType.equals(values.get("LINKS"))==false){
				Select select= new Select(xpathForLinkType);
				select.selectByVisibleText(values.get("LINKS"));
				
			}
			xpathForIssueType.sendKeys(issue);
			CommonUtil.actionClass().sendKeys(Keys.TAB).perform();
			CommonUtil.actionClass().sendKeys(Keys.TAB).perform();
			CommonUtil.actionClass().sendKeys(values.get("COMMENT")).perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForLinkButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return ViewTestPage.getInstance().validateLinkIssue(values);
	}
	
	
	public boolean linkIssue(Map<String, String> values){
		try{
			values.put("ISSUE_TYPE", values.get("LINKS"));
			String[] issueId=values.get("TESTID").split("-");
			int idNum=Integer.parseInt(issueId[1]);
			String issue=issueId[0]+"-"+""+(idNum+1);
			values.put("TESTID", issue);
			Assert.assertTrue(xpathForLinkIssueHeader.isDisplayed(),"Not in Link Issue Page");
			String selectLinkType=CommonUtil.getAttributeValueUsingWebElements(xpathForLinkType, "value");
			if(selectLinkType.equals(values.get("ISSUE_TYPE"))==false){
				Select select= new Select(xpathForLinkType);
				select.selectByVisibleText(values.get("ISSUE_TYPE"));
				
			}
			xpathForIssueType.sendKeys(issue);
			CommonUtil.actionClass().sendKeys(Keys.TAB).perform();
			CommonUtil.actionClass().sendKeys(Keys.TAB).perform();
			CommonUtil.actionClass().sendKeys(values.get("COMMENT")).perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathForLinkButton.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return ViewTestPage.getInstance().validateLinkIssue(values);
	}

}
