package com.thed.zfjbvt.zfj.impl.zfj173;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

/**
 * This is ZFJ's Test Metrics Page, Gadget related to ZFJ can be seen in this page.
 * 
 *
 */

public class TestMetricsPage {
	private Logger logger = Logger.getLogger(this.getClass());
	public static TestMetricsPage getInstance() {
		TestMetricsPage page = PageFactory.initElements(Driver.driver, TestMetricsPage.class);
		return page;
	}
	
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	//id for getting the user loggedin.
	@FindBy(id="header-details-user-fullname")
	private WebElement xpathForGettingUserLoggedIn;
	
	
	//id of the entire dash options in test metrics page.
	@FindBy(id="dash-options")
	private WebElement xpathForDashboardOptions;
	
	//id to add gadget in test metrics page.
	@FindBy(id="add-gadget")
	private WebElement xpathToAddGadget;
	
	//id of edit layout in test metrics page.
	@FindBy(id="layout-changer")
	private WebElement xpathOfEditLayout;
	
	//xpath to get the titles of the metrics in test metrics page.
	@FindBy(className="dashboard-item-title")
	private WebElement xpathToGetGadgetTitle;
	
	//xpath of tool option in test metrics page.
	@FindBy(xpath="//span[text()='Tools']") 
	private WebElement xpathOfToolOption;
	
	//xpath of save button inside the frame of the gadget in test metrics page.
	@FindBy(xpath="//div[@class='buttons']/input[@class='button save' and @type='submit']")
	private WebElement xpathToSaveGadget;
	
	//Xpath to validate Test Execution Chart.
	@FindBy(xpath="//h3[contains(text(),'Zephyr Test Execution')]")
	private WebElement xpathOfExecutionChart;
	
	//Xpath to get the project in the gadget.
	@FindBy(xpath="//h3/a[1]")
	private WebElement xpathToGetProject;
	
	//Xpath to get the version in the gadget.
	@FindBy(xpath="//h3/a[2]/strong")
	private WebElement xpathToGetVerion;
	
	//Xpath to get grouped in the gadget.
	@FindBy(xpath="//h4")
	private WebElement xpathToGetGroupedby;
	
	//Xpath of the save gadget button in test metrices.
	@FindBy(xpath="//input[@type='submit']")
	private WebElement xpathOfsaveGadgetButton;
	
	//Xpath to get cycle in test execution burndown.
	@FindBy(xpath="cycleId")
	private  WebElement xpathToGetCycle;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	
	public boolean validateTestMetricsPage(){
		try{
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			List<String> chartNames=CommonUtil.getValues("//h3[@class='dashboard-item-title']");
			int charts= chartNames.size();
			boolean chartHeader= false;
			Assert.assertTrue((CommonUtil.isElementDisplayed(xpathForDashboardOptions)),"launching TestMetrics page failed...");
			logger.info("Total Number of Charts dispalyed: "+charts+"" );
			for(int i=0;i<=charts-1;i++){
				String chartDisplayed=chartNames.get(i);
				logger.info((i+1)+" chart: "+chartDisplayed+"" );
				chartHeader=CommonUtil.isObjectDisplayed("//h3[text()='"+chartDisplayed+"']");
				String gadgetTitle=CommonUtil.changeToWebElement("//h3[text()='"+chartDisplayed+"']").getText();
				String id=getFrameId(gadgetTitle);
				Driver.driver.switchTo().frame(id);
				try{
					xpathOfsaveGadgetButton.isDisplayed();
					xpathOfsaveGadgetButton.click();
				}catch(Exception e){
					
				}
				Driver.driver.switchTo().defaultContent();
		}
			if(chartHeader==true){
				logger.info("TestMetrics page Comfirmed...");
			}
				
				
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		return true;
	}
	
	public boolean validateTestGadget(){
		try{
			String jiraAdmin=Config.getValue("JIRA_ADMIN_USERNAME");
			String userLoggedIn=CommonUtil.getAttributeValueUsingWebElements(xpathForGettingUserLoggedIn, "data-username");
			Assert.assertTrue(xpathOfToolOption.isDisplayed(),"TestMetrics Page Validation Failed...");
			List<String> chartNames=CommonUtil.getValues("//h3[@class='dashboard-item-title']");
			int charts= chartNames.size();
			for(int i=0;i<=charts-1;i++){
				String chartDisplayed=chartNames.get(i);
				Assert.assertTrue(CommonUtil.isObjectDisplayed("//h3[text()='"+chartDisplayed+"']"),"Chart "+chartDisplayed+" is not added...");
				if(jiraAdmin.equals(userLoggedIn)){
					Assert.assertTrue((xpathToAddGadget.isDisplayed()) && (xpathOfEditLayout.isDisplayed()),"Adding Gadget option for Admin Not avaliable");
				}
				String gadgetTitle=CommonUtil.changeToWebElement("//h3[text()='"+chartDisplayed+"']").getText();
				String id=getFrameId(gadgetTitle);
				Driver.driver.switchTo().frame(id);
				logger.info("Project Selected in "+chartDisplayed+" is:  "+xpathToGetProject.getText()+"");
				logger.info("Version selected in "+chartDisplayed+" is: "+xpathToGetVerion.getText()+"");
				logger.info(chartDisplayed+" is grouped by: "+xpathToGetGroupedby.getText()+"");
				Driver.driver.switchTo().defaultContent();
		}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		return true;
	}
	
	
	public boolean validateTestGadget(String gadget){
		try{
			String jiraAdmin=Config.getValue("JIRA_ADMIN_USERNAME");
			String userLoggedIn=CommonUtil.getAttributeValueUsingWebElements(xpathForGettingUserLoggedIn, "data-username");
			Assert.assertTrue(xpathOfToolOption.isDisplayed(),"TestMetrics Page Validation Failed...");
			Assert.assertTrue(CommonUtil.isObjectDisplayed("//h3[contains(text(),'"+gadget+"')]"),"Chart "+gadget+" is not added...");
			if(jiraAdmin.equals(userLoggedIn)){
				Assert.assertTrue((xpathToAddGadget.isDisplayed()) && (xpathOfEditLayout.isDisplayed()),"Adding Gadget option for Admin Not avaliable");
			}
			String gadgetTitle=CommonUtil.changeToWebElement("//h3[contains(text(),'"+gadget+"')]").getText();
			String id=getFrameId(gadgetTitle);
			Driver.driver.switchTo().frame(id);
			logger.info("Project Selected in "+gadget+" is:  "+xpathToGetProject.getText()+"");
			logger.info("Version selected in "+gadget+" is: "+xpathToGetVerion.getText()+"");
			logger.info(gadget+" is grouped by: "+xpathToGetGroupedby.getText()+"");
			
			List<String>totalItem=CommonUtil.getValues("//div[@class='xAxis x1Axis']/div");
			int total=totalItem.size();
			
			if(gadget.contains("Test Execution Burndown")){
				logger.info("the days showing in execution gadget are:");
				for(int i=0;i<total;i++){
					logger.info(totalItem.get(i));
					}
				
			}
			
			
			else if(xpathToGetGroupedby.getText().contains("Cycle")){
				logger.info("Cycles in "+xpathToGetVerion.getText()+ ": ");
					for(int i=0;i<total;i++){
							logger.info(totalItem.get(i));
					}
				}
			else if(xpathToGetGroupedby.getText().contains("Component")){
				logger.info("Components in "+xpathToGetVerion.getText()+ ": ");
				for(int i=0;i<total;i++){
						logger.info(totalItem.get(i));
				}
			}
			
			else if(xpathToGetGroupedby.getText().contains("User")){
				logger.info("Users in "+xpathToGetVerion.getText()+ ": ");
				for(int i=0;i<total;i++){
						logger.info(totalItem.get(i));
				}
			}
			
			if(gadgetTitle.equalsIgnoreCase("execution details")){
				System.out.println("inside execution details gadget");
				
			}
	
			Driver.driver.switchTo().defaultContent();
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		return true;
	}
	
	public boolean navigateToGadgetDirectoryAndAddGadget(String gadget){
		try{
			if(CommonUtil.isObjectDisplayed("//h3[contains(text(),'"+gadget+"')]")==true){
				logger.info("Gadget: "+gadget+" already added to the Dashboard");
				
			}
			else{
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				xpathToAddGadget.click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
				CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
				return GadgetDirectoryPage.getInstance().addGadget(gadget);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			}
		return true;
	}
	
	
	public boolean editGadget(Map<String, String> values){
		boolean visible=false;
		try{
			Assert.assertTrue(xpathOfToolOption.isDisplayed(),"TestMetrics Page Validation Failed...");
			Assert.assertTrue(CommonUtil.isObjectDisplayed("//h3[contains(text(),'"+values.get("GADGET")+"')]"),"Chart "+values.get("GADGET")+" is not added...");
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//h3[contains(text(),'"+values.get("GADGET")+"')]")).build().perform();
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']")).build().perform();
			visible=CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']").isDisplayed();
			if(visible==false){
				JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
				js.executeScript("javascript:window.scrollBy(450,400)");
				CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//h3[contains(text(),'"+values.get("GADGET")+"')]")).build().perform();
				CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']")).build().perform();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				
			}
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//h3[contains(text(),'"+values.get("GADGET")+"')]")).build().perform();
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']")).build().perform();
			visible=CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']").isDisplayed();
			if(visible==false){
				JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
				js.executeScript("javascript:window.scrollBy(300,300)");
				CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//h3[contains(text(),'"+values.get("GADGET")+"')]")).build().perform();
				CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']")).build().perform();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				
			}
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//h3[contains(text(),'"+values.get("GADGET")+"')]")).build().perform();
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']")).build().perform();
			visible=CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']").isDisplayed();
			if(visible==false){
				JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
				js.executeScript("javascript:window.scrollBy(-300,-300)");
				CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//h3[contains(text(),'"+values.get("GADGET")+"')]")).build().perform();
				CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']")).build().perform();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				
			}
			
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//h3[contains(text(),'"+values.get("GADGET")+"')]")).build().perform();
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']")).build().perform();
			visible=CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']").isDisplayed();
			if(visible==false){
				JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
				js.executeScript("javascript:window.scrollBy(-450,-400)");
				CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//h3[contains(text(),'"+values.get("GADGET")+"')]")).build().perform();
				CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']")).build().perform();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				
			}
			
			CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']").click();
			CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a[text()='Edit']").click();
			String id=getFrameId(values.get("GADGET"));
			Driver.driver.switchTo().frame(id);
			
			WebElement projectElement=CommonUtil.changeToWebElement("//*[@id='projectId']");
			Select selectProject=new Select(projectElement);
			selectProject.selectByVisibleText(values.get("PROJECT"));
			
			WebElement versionElement=CommonUtil.changeToWebElement("//*[@id='version']");
			Select selectVersion=new Select(versionElement);
			selectVersion.selectByVisibleText(values.get("VERSION"));
			if(values.get("GADGET").contains("Test Execution Burndown")){
				WebElement cycleElement=CommonUtil.changeToWebElement("//*[@id='cycleId']");
				Select selectCycle=new Select(cycleElement);
				selectCycle.selectByVisibleText(values.get("GROUPBY"));
				
			}
			else{
				WebElement groupbyElement=CommonUtil.changeToWebElement("//*[@id='groupFld']");
				Select selectGroupby=new Select(groupbyElement);
				selectGroupby.selectByVisibleText(values.get("GROUPBY"));
			}
			
			if(values.get("GADGET").contains("Execution Details")){
				System.out.println("inside test execution details...");
			}
			xpathOfsaveGadgetButton.click();
			Driver.driver.switchTo().defaultContent();	
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		return true;
	}
	
	
	
	public boolean saveGadgetAdded(String gadget){
		try{
			if(gadget.equals("Test Execution Burndown")){
				gadget="Unexecuted Schedules";
			}
			else if(gadget.equals("Test Execution Details")){
				gadget="Execution Details";
			}
			String id=getFrameId(gadget);
			Driver.driver.switchTo().frame(id);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			xpathToSaveGadget.click();
			Driver.driver.switchTo().defaultContent();
			Assert.assertTrue(CommonUtil.isObjectDisplayed("//h3[contains(text(),'"+gadget+"')]"),"Gadget Addition Failed...");
			if(gadget.equals("Unexecuted Schedules")){
				gadget="Test Execution Burndown";
			}
			else if(gadget.equals("Execution Details")){
				gadget="Test Execution Details";
			}
			logger.info("Gadget "+gadget+" Added successfully...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		return true;
	}
	
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	private String getFrameId(String title){
		String id=CommonUtil.getAttributeValue("//div[div[h3[contains(text(),'"+title+"')]]]//iframe", "id");
		return id;
	}

}