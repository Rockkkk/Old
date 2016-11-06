package com.thed.zfjbvt.zfj.impl.zfj25;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj25.GadgetDirectoryPage;

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
	@FindBy(xpath="//input[@value='Save' and @type='submit']")
	private WebElement xpathToSaveGadget;
	
	/*//Xpath to validate Test Execution Chart.
	@FindBy(xpath="//h3[contains(text(),'Zephyr Test Execution')]")
	private WebElement xpathOfExecutionChart;*/
	
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
	/*@FindBy(xpath="//input[@type='submit']")
	private WebElement xpathOfsaveGadgetButton;*/
	
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
	@FindBy(xpath="//table[thead[tr[th[@id='headerrow-id-exec-project']]]]/tbody[2]/tr[1]/td[4]/a")
	private WebElement xpathToGetProjectDisplayed;
	
	//xpath to get the total test executed from test execution details.
	@FindBy(xpath="//*[@id='displayDetailId']/div[1]/span[5]")
	private WebElement xpathToGetTotalTestExecuted;
	
	//xpath to get the total test selected.
	@FindBy(xpath="//*[@id='displayDetailId']/div[1]/span[3]")
	private WebElement xpathToGetExecutionDetailsDispalyed;
	
	//xpath of empty li to move gadget to.
	@FindBy(xpath="//li[@class='empty-text']")
	private WebElement addGadgetTo;
	
	//xpath of error message
	@FindBy(xpath="//*[@id='zql-message-bar']/div")
	private WebElement errorMsg;
	
	//id to restore default columns in execution details
	@FindBy(id="columns_restore_default")
	private WebElement restoreDefaultCloumns;
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
					xpathToSaveGadget.isDisplayed();
					xpathToSaveGadget.click();
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
	
	public boolean validateTestDistributionAndExecutionCharts(){
		try{
			String jiraAdmin=Config.getValue("JIRA_ADMIN_USERNAME");
			String userLoggedIn=CommonUtil.getAttributeValueUsingWebElements(xpathForGettingUserLoggedIn, "data-username");
			Assert.assertTrue(xpathOfToolOption.isDisplayed(),"TestMetrics Page Validation Failed...");
			if(jiraAdmin.equals(userLoggedIn)){
				Assert.assertTrue((xpathToAddGadget.isDisplayed()) && (xpathOfEditLayout.isDisplayed()),"Adding Gadget option for Admin Not avaliable");
			}
			Assert.assertTrue(validateTestGadget("Zephyr Test Distribution"),"Validating Test Distribution Chart Failed...");
			Assert.assertTrue(validateTestGadget("Zephyr Test Execution"),"Validating Test Execution Chart Failed...");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
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
					Assert.assertTrue((xpathToGetProjectDisplayed.getText().contains(Config.getValue("JIRA_PROJECT"))),"Not the Same Project Displayed...");
					List<WebElement> totalProjectsDispalyed= CommonUtil.getWebElements("//table[thead[tr[th[@id='headerrow-id-exec-project']]]]/tbody[2]/tr/td[4]");
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
			List<WebElement> gList;
			String jiraAdmin = Config.getValue("JIRA_ADMIN_USERNAME");
			String jiraUser = Config.getValue("JIRA_USER_USERNAME");
			String userLoggedIn=CommonUtil.getAttributeValueUsingWebElements(xpathForGettingUserLoggedIn, "data-username");
			Assert.assertTrue(xpathOfToolOption.isDisplayed(),"TestMetrics Page Validation Failed...");
			Assert.assertTrue(CommonUtil.isObjectDisplayed("//h3[contains(text(),'"+gadget+"')]"),"Chart "+gadget+" is not added...");
			if(jiraAdmin.contains(userLoggedIn)){
				Assert.assertTrue((xpathToAddGadget.isDisplayed()) && (xpathOfEditLayout.isDisplayed()),"Adding Gadget option for Admin Not avaliable");
			}
			String gadgetTitle=CommonUtil.changeToWebElement("//h3[contains(text(),'"+gadget+"')]").getText();
			String id=getFrameId(gadgetTitle);
			if(jiraUser.contains(userLoggedIn)){
				operationOnGadget(id, "Refresh", gadget);
			}
			Driver.driver.switchTo().frame(id);
			
			if(gadgetTitle.equalsIgnoreCase("execution details")){
				//int totalTest=Integer.parseInt(xpathToGetTotalTestExecuted.getText());
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				Assert.assertTrue((xpathToGetProjectDisplayed.getText().contains(Config.getValue("JIRA_PROJECT"))),"Not the Same Project Displayed...");
				List<WebElement> totalProjectsDispalyed= CommonUtil.getWebElements("//table[thead[tr[th[@id='headerrow-id-exec-project']]]]/tbody[2]/tr/td[4]");
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
				CommonUtil.waitForStaleElement(xpathToGetProject, Constants.IMPLICIT_WAIT_LOW);
				logger.info("Project Selected in "+gadget+" is:  "+xpathToGetProject.getText()+"");
				logger.info("Version selected in "+gadget+" is: "+xpathToGetVerion.getText()+"");
				logger.info(gadget+" is grouped by: "+xpathToGetGroupedby.getText()+"");
				
				if(gadget.contains("Top Defects")){
					List<String> totalDefects = CommonUtil.getValues("//*[@id='defectTable']/tbody//tr/td[1]/a");
					if(totalDefects.size()>0){
						List<String> totalTestsAffected = CommonUtil.getValues("//*[@id='defectTable']/tbody//tr/td[4]/a");
						for(int i = 0;i<totalDefects.size();i++){
							logger.info("Total number of Tests affected by "+totalDefects.get(i)+" are "+totalTestsAffected.get(i));
							
						}
					}
					
					else{
						logger.info("Top Defects for are not displayed...");
						Driver.driver.switchTo().defaultContent();
						return false;
					}
					
				}
				else{
					List<String>totalItem=CommonUtil.getValues("//*[@class='x axis']//*[@class='tick']//*[@y='9']//*[local-name()='title']");
					int total=totalItem.size();
					if(gadget.contains("Test Execution Burndown")){
						logger.info("the days showing in execution gadget are:");
						List<String>totalItems=CommonUtil.getValues("//*[@class='x axis']//*[@class='tick']//*[@y='9']");
						int totals=totalItems.size();
						for(int i=0;i<totals;i++){
							logger.info(totalItems.get(i));
							}
						List<WebElement> list= CommonUtil.getWebElements("//*[local-name()='svg']//*[local-name()='g'][@transform='translate(50,30)']/*[local-name()='circle']");
						for(int i=1; i<=list.size(); i++){
							CommonUtil.actionClass().click(CommonUtil.changeToWebElement("//*[local-name()='svg']//*[local-name()='g'][@transform='translate(50,30)']/*[local-name()='circle']["+i+"]")).perform();
							if(CommonUtil.isElementDisplayed(CommonUtil.changeToWebElement("//div[@class='d3-tip n']"))){
								logger.info((CommonUtil.changeToWebElement("//div[@class='d3-tip n']").getText()));
							}
							
						}
					}
					else if(gadget.contains("Zephyr Test Distribution")){
						if(xpathToGetGroupedby.getText().contains("Component")){
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
						gList = CommonUtil.getWebElements("//*[local-name()='svg']//*[local-name()='g'][@class='bar']");
						for(int i=0; i<gList.size(); i++){
							List<WebElement> rectList = CommonUtil.getWebElements("//*[local-name()='svg']//*[local-name()='g'][@class='bar']["+(i+1)+"]//*[local-name()='rect']"); 
							for(int j=0; j<rectList.size(); j++){
								String height = CommonUtil.getAttributeValue("//*[local-name()='svg']//*[local-name()='g'][@class='bar']["+(i+1)+"]//*[local-name()='rect']["+(j+1)+"]", "height");
								if(!(height.equals("0"))){
									logger.info(totalItem.get(i)+" Contains: ");
									CommonUtil.actionClass().click(CommonUtil.changeToWebElement("//*[local-name()='rect'][@height='"+height+"']")).perform();
									CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
									if(CommonUtil.isElementDisplayed(CommonUtil.changeToWebElement("//div[@class='d3-tip n']"))){
										logger.info((CommonUtil.changeToWebElement("//div[@class='d3-tip n']").getText()));
										CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
										//logger.info(CommonUtil.changeToWebElement("//div[@class='d3-tip n']").getText());
										}
									
								}
								
							}
							
						}
					}
					else if(gadget.contains("Zephyr Test Execution")){
						if(xpathToGetGroupedby.getText().contains("Cycle")){
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
						gList = CommonUtil.getWebElements("//*[local-name()='svg']//*[local-name()='g'][@class='g']");
						for(int i=0; i<gList.size(); i++){
							List<WebElement> rectList = CommonUtil.getWebElements("//*[local-name()='svg']//*[local-name()='g'][@class='g']["+(i+1)+"]//*[local-name()='rect']"); 
							for(int j=0; j<rectList.size(); j++){
								String height = CommonUtil.getAttributeValue("//*[local-name()='svg']//*[local-name()='g'][@class='g']["+(i+1)+"]//*[local-name()='rect']["+(j+1)+"]", "height");
								if(!(height.equals("0"))){
									logger.info(totalItem.get(i)+" Contains: ");
									CommonUtil.actionClass().click(CommonUtil.changeToWebElement("//*[local-name()='rect'][@height='"+height+"']")).perform();
									if(CommonUtil.isElementDisplayed(CommonUtil.changeToWebElement("//div[@class='d3-tip n']"))){
										logger.info((CommonUtil.changeToWebElement("//div[@class='d3-tip n']").getText()));
									}
								}
							}
							
						}
						
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
			if(Config.getValue("JIRA_VERSION").equals("6.4")){
				if(CommonUtil.isElementPresent("//*[@id='aui-flag-container']/div", Constants.IMPLICIT_WAIT_LOW)){
					if(CommonUtil.getAttributeValue("//*[@id='aui-flag-container']/div", "aria-hidden").equals("false")){
						CommonUtil.clickOnElement("//*[@id='aui-flag-container']//span");
						CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
						logger.info("Closed Unnecessory Popup.");
						Assert.assertTrue(CommonUtil.getAttributeValue("//*[@id='aui-flag-container']/div", "aria-hidden").equals("true"), "Un-necessory popup Still exists.");			
					}
				}
				boolean gadgetVisiblity = CommonUtil.isObjectDisplayed("//h3[contains(text(),'"+gadget+"')]");
				if(gadgetVisiblity == true){
					logger.info("Gadget: "+gadget+" already added to the Dashboard");
					
				}
				else{
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					xpathToAddGadget.click();
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
					//Dialog id changed //*[@id='macro-browser-dialog'] to //*[@id='gadget-dialog']
					//Assert.assertTrue(CommonUtil.visibilityOfElementLocated("//*[@id='gadget-dialog']"), "Add Gadget Popup Not Visible.");
					return GadgetDirectoryPage.getInstance().addGadget(gadget);
					
				}
			}else{
				boolean gadgetVisiblity = CommonUtil.isObjectDisplayed("//h3[contains(text(),'"+gadget+"')]");
				if(gadgetVisiblity == true){
					logger.info("Gadget: "+gadget+" already added to the Dashboard");
					
				}
				else{
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					xpathToAddGadget.click();
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
					CommonUtil.visibilityOfElementLocated("//*[@id='macro-browser-dialog']");
					return GadgetDirectoryPage.getInstance().addGadget(gadget);
					
				}
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
			if(CommonUtil.isElementPresent("//*[@id='aui-flag-container']/div", Constants.IMPLICIT_WAIT_LOW)){
				if(CommonUtil.getAttributeValue("//*[@id='aui-flag-container']/div", "aria-hidden").equals("false")){
					CommonUtil.clickOnElement("//*[@id='aui-flag-container']//span");
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					logger.info("Closed Unnecessory Popup.");
					Assert.assertTrue(CommonUtil.getAttributeValue("//*[@id='aui-flag-container']/div", "aria-hidden").equals("true"), "Un-necessory popup Still exists.");			
				}
			}
			String id=getFrameId(values.get("GADGET"));
			operationOnGadget(id,"Edit", values.get("GADGET"));
			Driver.driver.switchTo().frame(id);
			if(values.get("GADGET").contains("Execution Details")){
				Select select= new Select(xpathToGetSearchby);
				select.selectByVisibleText("Free form ZQL");
				xpathToEnterZqlQuery.click();
				String selectAll = Keys.chord(Keys.CONTROL, "a");
				xpathToEnterZqlQuery.sendKeys(selectAll);
				xpathToEnterZqlQuery.clear();
				xpathToEnterZqlQuery.sendKeys(values.get("ZQL_QUERY"));
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.actionClass().sendKeys(Keys.DOWN).perform();
				CommonUtil.actionClass().sendKeys(Keys.ENTER).perform();
				WebElement pickElement=CommonUtil.changeToWebElement("//*[@id='howMany']");
				Select selectNumberOfDefects=new Select(pickElement);
				selectNumberOfDefects.selectByVisibleText(values.get("GROUPBY"));
			}
			else{
				WebElement projectElement=CommonUtil.changeToWebElement("//*[@id='projectId']");
				//Select selectProject=new Select(projectElement);
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
			CommonUtil.actionClass().sendKeys(xpathToSaveGadget, Keys.RETURN).perform();
			//xpathToSaveGadget.click();
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
			String id=getFrameId(gadget);
			Driver.driver.switchTo().frame(id);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			try{
				if(gadget.equals("Execution Details")){
					if(errorMsg.isDisplayed()){
						logger.info(errorMsg.getText());
						
					}
				}
				
			}catch(Exception e){
				
			}
			CommonUtil.actionClass().moveToElement(xpathToSaveGadget).perform();
			CommonUtil.actionClass().click(xpathToSaveGadget).perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CommonUtil.switchToDefualtContent();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			if(gadget.equals("Unexecuted Schedules")){
				gadget="Test Execution Burndown";
			}
			//Assert.assertTrue(CommonUtil.isObjectDisplayed("//h3[contains(text(),'"+gadget+"')]"),"Gadget Addition Failed...");
			Assert.assertTrue(isGadgetPresent(gadget), "Gadget is not present in Zephyr Dash board.");
			
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
	
	public boolean customiseExecutionDetailGadget(String firstColumn, String secondColumn){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info("Getting Frame ID.");
			String id=getFrameId("Execution Details");
			operationOnGadget(id,"Edit", "Execution Details");
			logger.info("Clicked on edit on Gadget");
			Driver.driver.switchTo().frame(id);
			logger.info("Switched Successfully to the Frame.");
			CommonUtil.changeToWebElement("//*[@id='column-picker-restful-table']//tr[@data-label='"+firstColumn+"']//td[3]").click();
			CommonUtil.changeToWebElement("//*[@id='column-picker-restful-table']//tr[@data-label='"+secondColumn+"']//td[3]").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().sendKeys(xpathToSaveGadget, Keys.RETURN).perform();
			//xpathToSaveGadget.click();
			Driver.driver.switchTo().defaultContent();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			validateCustomisedExecutionGadget(firstColumn, secondColumn, "Execution Details");
			restoreDefaultCloumns();
			validateCustomisedExecutionGadget(firstColumn, secondColumn, "Execution Details");
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	
	public boolean validateCustomisedExecutionGadget(String firstColumn, String secondColumn, String gadget){
		boolean status= true;
		try{
			String gadgetTitle=CommonUtil.changeToWebElement("//h3[contains(text(),'"+gadget+"')]").getText();
			String id=getFrameId(gadgetTitle);
			Driver.driver.switchTo().frame(id);
			CommonUtil.getValues("//*[@id='issuetable']/thead//th");
			List<String> headers = CommonUtil.getValues("//*[@id='issuetable']/thead//th");
			for(int i=0; i<headers.size(); i++){
				if((headers.get(i).contains(firstColumn)) || (headers.get(i).contains(firstColumn))){
					status= false;
					break;
				}
			}
			if(status == true){
				logger.info("Columns "+firstColumn+" and "+secondColumn+" are removed...");
			}
			else{
				logger.info("Columns "+firstColumn+" and "+secondColumn+" are displayed...");
			}
			Driver.driver.switchTo().defaultContent();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean restoreDefaultCloumns(){
		try{
			String id=getFrameId("Execution Details");
			operationOnGadget(id,"Edit", "Execution Details");
			Driver.driver.switchTo().frame(id);
			restoreDefaultCloumns.click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().sendKeys(xpathToSaveGadget, Keys.RETURN).perform();
			Driver.driver.switchTo().defaultContent();
			
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
		String id = null;
		try{
			id=CommonUtil.getAttributeValue("//div[div[h3[contains(text(),'"+title+"')]]]//iframe", "id");
			logger.info("ID : "+id);
			return id;
		}catch(Exception e){
			return id;
		}
	}
	/**
	 * This method will give the total number of count of the gadget in Test Metrics Page and returns a integer value .<br/> 
	 * @return The integer value .
	 */
	private int getTotalGadgetsCount(){
		int size = 0;
		try{
			size = CommonUtil.getSizeOfElements("//*[@id='dashboard']/descendant::div[contains(@id,'gadget') and contains(@id,'renderbox')]");
			return size;
		}catch(Exception e){
			return size;
		}
	}
	/**
	 * This method will check the gadget is present or not and returns a boolean value if it present.<br/> 
	 * @param This parameter will take a parameter gadgetName as String value.
	 * @return The boolean value i.e. True or False.
	 */
	private boolean isGadgetPresent(String gadgetName){
		boolean flag = false;
		try{
			List<WebElement> listOfElements = CommonUtil.returnWebElementsFromXpath("//*[@id='dashboard']/descendant::div[contains(@id,'gadget') and contains(@id,'renderbox')]/descendant::h3[contains(@id,'gadget') and contains(@id,'title')]");
			for(int i =  0; i < listOfElements.size() ; i++){
				String gadgetTitle = listOfElements.get(i).getText();
				if(gadgetTitle.contains(gadgetName)){
					flag = true;
					break;
				}
			}
			return flag;
		}catch(Exception e){
			return flag;
		}
	}
	
	private void operationOnGadget(String id,String option,String gadget){
		try{
			String[] idNum=id.split("-");
			String gadgetPosition="rep-"+idNum[1];
			WebElement moveToGadget = CommonUtil.changeToWebElement("//div[div[div[*[@id='"+id+"']]]]/preceding-sibling::div[@class='layout layout-aa']//li[@id='"+gadgetPosition+"']");
			logger.info("Moved to Gadget Successfully.");
			CommonUtil.scrollToWebElement(moveToGadget);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//h3[contains(text(),'"+gadget+"')]")).perform();
			CommonUtil.actionClass().moveToElement(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+gadget+"')]]]//a/span[text()='Gadget menu']")).perform();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			//CommonUtil.actionClass().click(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+gadget+"')]]]//a/span[text()='Gadget menu']")).perform();
			CommonUtil.ClickOnElementUsingJS(CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+gadget+"')]]]//a/span[text()='Gadget menu']"));
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.changeToWebElement("//div[div[h3[contains(text(),'"+gadget+"')]]]/div//ul//a[text()='"+option+"']").click();
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/**
	 * This method will delete three gadgets(Execution Details, Test Execution Burndown and Top Defects) and reset two Gadget(Zephyr Test Distribution and Zephyr Test Execution) and returns a boolean value if it reset successfully.<br/> 
	 * 
	 * @return The boolean value i.e. True or False.
	 */
	public boolean resetGadget(){
		try{
			String gadgetOne = "Execution Details";
			String gadgetTwo = "Test Execution Burndown";
			String gadgetThree = "Top Defects";
			String gadgetFour = "Zephyr Test Distribution";
			String gadgetFive = "Zephyr Test Execution";
			
			int totalGadgets = getTotalGadgetsCount();
			logger.info("Total gadgets are :" + totalGadgets);
			
			Assert.assertTrue(deleteGadget(gadgetOne), gadgetOne+" is Deleted successfully.");
			Assert.assertTrue(deleteGadget(gadgetTwo), gadgetOne+" is Deleted successfully.");
			Assert.assertTrue(deleteGadget(gadgetThree), gadgetOne+" is Deleted successfully.");
			Assert.assertTrue(editGadget(gadgetFour), gadgetFour+" is Edited successfully.");
			Assert.assertTrue(editGadget(gadgetFive), gadgetFive+" is Edited successfully.");
			
			logger.info("All Gadgets are reseted successfully.");
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	/**
	 * This method will just click on edit and then it will click on save only and returns a boolean value if it edited successfully.<br/> 
	 * @param This parameter will take a parameter gadgetName as String value.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean editGadget(String gadget){
		try{			
			Assert.assertTrue(validatePage(), "Test Metrics Page is not Validated Successfully");
			if(CommonUtil.isElementPresent("//*[@id='aui-flag-container']/div", Constants.IMPLICIT_WAIT_LOW)){
				if(CommonUtil.getAttributeValue("//*[@id='aui-flag-container']/div", "aria-hidden").equals("false")){
					CommonUtil.clickOnElement("//*[@id='aui-flag-container']//span");
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					logger.info("Closed Unnecessory Popup.");
					Assert.assertTrue(CommonUtil.getAttributeValue("//*[@id='aui-flag-container']/div", "aria-hidden").equals("true"), "Un-necessory popup Still exists.");			
				}
			}
			
			logger.info("Closed the unneccory popup.");
			int gadgetCountBefore = getTotalGadgetsCount();
			logger.info("Total Gadget Present = " + gadgetCountBefore);
			if(isGadgetPresent(gadget)){
				String id=getFrameId(gadget);
				operationOnGadget(id,"Edit", gadget);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				Assert.assertTrue(CommonUtil.switchToFrame(id), "Not switched to frame successfully.");
				CommonUtil.clickOnElement("//input[@value='Save' and @type='submit']");
				Assert.assertTrue(CommonUtil.switchToDefualtContent(), "Not switched to defualt content.");
				logger.info(gadget + " gadget is Edited Successfully.");
			}else{
				logger.info(gadget + " is not present, So we can't perform operation.");
			}			
		}catch(Exception e){
			Assert.assertTrue(CommonUtil.switchToDefualtContent(), "Not switched to defualt content.");
			return false;
		}
		return true;
	}
	/**
	 * This method will delete Gadget and returns a boolean value if it deleted successfully.<br/> 
	 * @param This parameter will take a parameter gadgetName as String value.
	 * @return The boolean value i.e. True or False.
	 */

	public boolean deleteGadget(String gadgetName){
		try{
			Assert.assertTrue(validatePage(), "Test Metrics Page is not Validated Successfully");
			if(CommonUtil.isElementPresent("//*[@id='aui-flag-container']/div", Constants.IMPLICIT_WAIT_LOW)){
				if(CommonUtil.getAttributeValue("//*[@id='aui-flag-container']/div", "aria-hidden").equals("false")){
					CommonUtil.clickOnElement("//*[@id='aui-flag-container']//span");
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					logger.info("Closed Unnecessory Popup.");
					Assert.assertTrue(CommonUtil.getAttributeValue("//*[@id='aui-flag-container']/div", "aria-hidden").equals("true"), "Un-necessory popup Still exists.");			
				}
			}
			int gadgetCountBefore = getTotalGadgetsCount();
			logger.info("Total Gadget Present = " + gadgetCountBefore);
			if(isGadgetPresent(gadgetName)){
				String id=getFrameId(gadgetName);
				operationOnGadget(id,"Delete", gadgetName);
				Alert alertpopup = CommonUtil.switchToAlert();
				Assert.assertNotNull(alertpopup, "No alert popup showing.");
				String x= alertpopup.getText();
				Assert.assertTrue(alertpopup.getText().contains(gadgetName), gadgetName + " is not papulated in alert conformation popup.");
				alertpopup.accept();
				String xpathForInvisibleTitle = "//*[@id='dashboard']/descendant::div[contains(@id,'gadget') and contains(@id,'renderbox')]/descendant::h3[contains(@id,'gadget') and contains(@id,'title') and contains(text(),'"+gadgetName+"')]";
				CommonUtil.invisibilityOfElementLocatedWithString(xpathForInvisibleTitle, gadgetName, Constants.EXPLICIT_WAIT_MEDIUM);
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				//CommonUtil.refreshPage();
				Assert.assertFalse(isGadgetPresent(gadgetName), "Gadget is Still present.");
				logger.info("Gadget deletion Validated successfully.");
				int gadgetCountAfter = getTotalGadgetsCount();
				logger.info("Total Gadget Present = " + gadgetCountAfter);
				//Assert.assertTrue((gadgetCountBefore - 1) == gadgetCountAfter, "After Deleting Gadget, Count is not Decreasing");
				logger.info(gadgetName + " gadget is Deleted Successfully.");
			}else{
				logger.info(gadgetName + " is not present, So we are not performing operation.");
			}			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	/**
	 * This method will validate the page and returns a boolean value if it validated successfully.<br/> 
	 * @return The boolean value i.e. True or False.
	 */
	private boolean validatePage(){
		try{
			Assert.assertTrue(CommonUtil.titleContains("Zephyr Dashboard", Constants.EXPLICIT_WAIT_LOW), "Test Metrics Page is not verified successfully.");
			logger.info("Test Metrics Page is Validated Successfully.");			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
