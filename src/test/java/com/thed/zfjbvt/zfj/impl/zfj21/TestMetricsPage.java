package com.thed.zfjbvt.zfj.impl.zfj21;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj21.GadgetDirectoryPage;

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
	
	//id to get the search by in test execution details.
	@FindBy(id="zfjQueryType")
	private WebElement xpathToGetSearchby;
	
	//id to enter ZQL Qurey in test execution details.
	@FindBy(id="zqltext")
	private WebElement xpathToEnterZqlQuery;
	
	//xpath to get the project from test execution details.
	@FindBy(xpath="//table[thead[tr[th[@id='headerrow-id-exec-project']]]]/tbody[2]/tr[1]/td[3]/a[1]")
	private WebElement xpathToGetProjectDisplayed;
	
	//xpath to get the total test executed from test execution details.
	@FindBy(xpath="//*[@id='displayDetailId']/div[1]/span[3]")
	private WebElement xpathToGetTotalTestExecuted;
	
	//xpath to get the total test selected.
	@FindBy(xpath="//*[@id='displayDetailId']/div[1]/span[2]")
	private WebElement xpathToGetExecutionDetailsDispalyed;
	
	//xpath of empty li to move gadget to.
	@FindBy(xpath="//li[@class='empty-text']")
	private WebElement addGadgetTo;
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the <b>TestMetricsPage</b> when <b>Test Metrics link</b> is clicked.<br/>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	
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
					Driver.driver.switchTo().defaultContent();
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
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates all the <b>GADGETS </b> displayed when the <b>Test Metrics Page<b> is launched.<br/>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	
	public boolean validateTestGadgets(){
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
				if(gadgetTitle.equalsIgnoreCase("execution details")){
					//int totalTest=Integer.parseInt(xpathToGetTotalTestExecuted.getText());
					Assert.assertTrue(Config.getValue("JIRA_PROJECT").equals(xpathToGetProjectDisplayed.getText()),"Not the Same Project Displayed...");
					List<WebElement> totalProjectsDispalyed= CommonUtil.getWebElements("//table[thead[tr[th[@id='headerrow-id-exec-project']]]]/tbody[2]/tr/td[3]");
					Assert.assertEquals(Integer.parseInt(xpathToGetExecutionDetailsDispalyed.getText()),totalProjectsDispalyed.size(),"Number of Execution Details picked is not the same...");
					logger.info("Total number of Execution Details picked to be dispalyed in the chart is: "+xpathToGetExecutionDetailsDispalyed.getText());
					//Assert.assertTrue(totalTest==totalProjects.size(),"Total Test executed are not the same...");
					logger.info("Projects Displayed are: ");
					for(int j=0;j<totalProjectsDispalyed.size();j++){
						logger.info(totalProjectsDispalyed.get(j).getText());
					}
					List<WebElement> totalCycles= CommonUtil.getWebElements("//table[thead[tr[th[@id='headerrow-id-exec-cycle']]]]/tbody[2]/tr/td[1]");
					logger.info("Cycles Displayed are: ");
					for(int j=0;j<totalCycles.size();j++){
						logger.info(totalCycles.get(j).getText());
					}
					
					List<WebElement> totalIssueKeys= CommonUtil.getWebElements("//table[thead[tr[th[@id='headerrow-id-exec-issue']]]]/tbody[2]/tr/td[2]");
					logger.info("Issue Keys Displayed are: ");
					for(int j=0;j<totalIssueKeys.size();j++){
						logger.info(totalIssueKeys.get(j).getText());
					}
				}
				else{
					logger.info("Project Selected in "+chartDisplayed+" is:  "+xpathToGetProject.getText()+"");
					logger.info("Version selected in "+chartDisplayed+" is: "+xpathToGetVerion.getText()+"");
					logger.info(chartDisplayed+" is grouped by: "+xpathToGetGroupedby.getText()+"");
				}
				
				Driver.driver.switchTo().defaultContent();
		}
			
		}catch(Exception e){
			Driver.driver.switchTo().defaultContent();
			e.printStackTrace();
			return false;
			}
		return true;
	}
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the <b>GADGET </b> specified when the <b>Test Metrics Page<b> is launched.<br/>
	 * <p>
	 * <b>gadget</b>String value which specifies the GADGET which has to be validated.<br/> 
	 * </p>
	 * @return The boolean value i.e. True or False.<br/>
	 */
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
			if(gadgetTitle.equalsIgnoreCase("execution details")){
				//int totalTest=Integer.parseInt(xpathToGetTotalTestExecuted.getText());
				Assert.assertTrue(Config.getValue("JIRA_PROJECT").equals(xpathToGetProjectDisplayed.getText()),"Not the Same Project Displayed...");
				List<WebElement> totalProjectsDispalyed= CommonUtil.getWebElements("//table[thead[tr[th[@id='headerrow-id-exec-project']]]]/tbody[2]/tr/td[3]");
				Assert.assertEquals(Integer.parseInt(xpathToGetExecutionDetailsDispalyed.getText()),totalProjectsDispalyed.size(),"Number of Execution Details picked is not the same...");
				logger.info("Total number of Execution Details picked to be dispalyed in the chart is: "+xpathToGetExecutionDetailsDispalyed.getText());
				//Assert.assertTrue(totalTest==totalProjects.size(),"Total Test executed are not the same...");
				logger.info("Projects Displayed are: ");
				for(int i=0;i<totalProjectsDispalyed.size();i++){
					logger.info(totalProjectsDispalyed.get(i).getText());
				}
				List<WebElement> totalCycles= CommonUtil.getWebElements("//table[thead[tr[th[@id='headerrow-id-exec-cycle']]]]/tbody[2]/tr/td[1]");
				logger.info("Cycles Displayed are: ");
				for(int i=0;i<totalCycles.size();i++){
					logger.info(totalCycles.get(i).getText());
				}
				
				List<WebElement> totalIssueKeys= CommonUtil.getWebElements("//table[thead[tr[th[@id='headerrow-id-exec-issue']]]]/tbody[2]/tr/td[2]");
				logger.info("Issue Keys Displayed are: ");
				for(int i=0;i<totalIssueKeys.size();i++){
					logger.info(totalIssueKeys.get(i).getText());
				}
			}
			else{
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
			}
			
			Driver.driver.switchTo().defaultContent();
		}catch(Exception e){
			Driver.driver.switchTo().defaultContent();
			e.printStackTrace();
			return false;
			}
		return true;
	}
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method navigates to  the  <b>GADGET DIRECTORY </b> adds the specified <b>GADGET</b>to the <b>Test Metrics Page<b>.<br/>
	 * @param gadget,String value which specifies the GADGET which has to be added.<br/> 
	 * @return The boolean value i.e. True or False.<br/>
	 * 
	 */
	public boolean navigateToGadgetDirectoryAndAddGadget(String gadget){
		try{
			boolean gadgetVisiblity = CommonUtil.isObjectDisplayed("//h3[contains(text(),'"+gadget+"')]");
			if(gadgetVisiblity == true){
				logger.info("Gadget: "+gadget+" already added to the Dashboard");
				
			}
			else{
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				xpathToAddGadget.click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
				return GadgetDirectoryPage.getInstance().addGadget(gadget);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			}
		return true;
	}
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method edits a specified GADGET in the TEST METRICS page.
	 * @param values Map contains values to edit a GADGET.
	 * <p>
	 * <b>GADGET</b> This parameter contains the gadget name that has to be edited.<br/> 
	 * <b>PROJECT</b> This parameter contains the project that has to selected.<br/> 
	 * <b>VERSION</b> This parameter contains the version to be shown.<br/>
	 * <b>GROUPBY</b> This parameter contains the group by option that has to selected.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean editGadget(Map<String, String> values){
		try{
			String id=getFrameId(values.get("GADGET"));
			String[] idNum=id.split("-");
			String gadgetPosition="rep-"+idNum[1];
			WebElement moveToGadget = CommonUtil.changeToWebElement("//div[div[div[*[@id='"+id+"']]]]/preceding-sibling::div[@class='layout layout-aa']//li[@id='"+gadgetPosition+"']");
			CommonUtil.scrollToWebElement(moveToGadget);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//h3[contains(text(),'"+values.get("GADGET")+"')]")).build().perform();
			//CommonUtil.scrollToWebElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']")).build().perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul//li/a/span[text()='Gadget menu']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.scrollToWebElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul/li[@class='aui-dd-parent dd-allocated']//ul[@class]"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			//CommonUtil.scrollToWebElement(moveToGadget);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+values.get("GADGET")+"')]]]/div[2]//ul/li[4]/a[text()='Edit']").click();
			Driver.driver.switchTo().frame(id);
			if(values.get("GADGET").contains("Execution Details")){
				Select select= new Select(xpathToGetSearchby);
				select.selectByVisibleText("Free form ZQL");
				xpathToEnterZqlQuery.click();
				String selectAll = Keys.chord(Keys.CONTROL, "a");
				xpathToEnterZqlQuery.sendKeys(selectAll);
				xpathToEnterZqlQuery.clear();
				xpathToEnterZqlQuery.sendKeys(values.get("ZQL_QUERY"),Keys.ENTER);
				WebElement pickElement=CommonUtil.changeToWebElement("//*[@id='howMany']");
				Select selectNumberOfDefects=new Select(pickElement);
				selectNumberOfDefects.selectByVisibleText(values.get("GROUPBY"));
			}
			else{
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
				else if(values.get("GADGET").contains("Top Defects")){
					WebElement pickElement=CommonUtil.changeToWebElement("//*[@id='howMany']");
					Select selectNumberOfDefects=new Select(pickElement);
					selectNumberOfDefects.selectByVisibleText(values.get("GROUPBY"));
				}
				else{
					WebElement groupbyElement=CommonUtil.changeToWebElement("//*[@id='groupFld']");
					Select selectGroupby=new Select(groupbyElement);
					selectGroupby.selectByVisibleText(values.get("GROUPBY"));
				}
			}
			
			
			
			
			xpathOfsaveGadgetButton.click();
			Driver.driver.switchTo().defaultContent();
			
				
			
		}catch(Exception e){
			Driver.driver.switchTo().defaultContent();
			e.printStackTrace();
			return false;
			}
		return true;
	}
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method saves a specified GADGET in the TEST METRICS page after the gadget is added.<br/>
	 * @param gadget, String which specifies the gadget that has to be saved. <br/>
	 * @return The boolean value i.e. True or False.
	 */
	
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
	
	/**
	 * 
	 * @param title
	 * @return
	 */
	
	
	public boolean dragAndDropGadget(String title){
		try{
			JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
			String id=getFrameId(title);
			id=id+"-title";
			System.out.println(id);
			WebElement gadget = CommonUtil.changeToWebElement("//*[@id='"+id+"']");
			CommonUtil.actionClass().moveToElement(gadget).perform();
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//*[@id='"+id+"']/following-sibling::div[@class='gadget-menu']//li[text()='move']")).perform();
			CommonUtil.actionClass().clickAndHold().perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			WebElement moveToGadget = CommonUtil.changeToWebElement("//ul[@class='column second sortable ui-sortable']");
			System.out.println(moveToGadget.getSize());
			CommonUtil.actionClass().moveToElement(moveToGadget, -(moveToGadget.getSize().height+2000), -(moveToGadget.getSize().width+2000)).perform();
			js.executeScript("window.scrollBy(0,"+(500)+");");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			//CommonUtil.actionClass().release().build().perform();
		}catch(Exception e){
			e.printStackTrace();
			return false;
			}
		return true;
	}
	
	
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	/**
	 * Returns a String value of the frame w.r.t to the GADGET specified.<br/>
	 * @param title, String which specifies the GADGET of the frame id has to returned. <br/> 
	 * @return String <b>id</b>, w.r.t the GADGET specified. 
	 */
	
	private String getFrameId(String title){
		String id=CommonUtil.getAttributeValue("//div[div[h3[contains(text(),'"+title+"')]]]//iframe", "id");
		return id;
	}
	
}