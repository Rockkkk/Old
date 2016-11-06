package com.thed.zfjbvt.zfj.impl.zfj21;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

public class TestSummaryPage {
	private Logger logger = Logger.getLogger(this.getClass());
	public static TestSummaryPage getInstance() {
		TestSummaryPage page = PageFactory.initElements(Driver.driver, TestSummaryPage.class);
		return page;
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	//Xpath to validate Test Summary Page.
	@FindBy(xpath="//*[@id='project-tab']/h2")
	private WebElement xpathToValidateTestSummaryPage;
	
	//Xpath to confirm test summary in test summary page.
	@FindBy(xpath="//h3[contains(text(),'Test Summary')]")
	private WebElement xpathTovalidateTestSummary;
	
	//Xpath to confirm test by version in test summary page.
	@FindBy(xpath="//h3[contains(text(),'Tests By Version')]")
	private WebElement xapthToValidateTestUnderVersion;
	
	//Xpath to confirm test by component in test summary page.
	@FindBy(xpath="//h3[contains(text(),'Tests By Component')]")
	private WebElement xpathToValidateTestUnderComponent;
	
	//Xpath to confirm test by label in test summary page.
	@FindBy(xpath="//h3[contains(text(),'Tests By Label')]")
	private WebElement xpathToValidateTestUnderLabel;

	//Xpath to confirm test creation chart.
	@FindBy(xpath="//*[@id='testcases-creation-chart-id']/canvas[2]")
	private WebElement xpathToConfirmTestCreationChart;
	
	//Xpath to confirm test execution chart.
	@FindBy(xpath="//*[@id='execution-creation-chart-id']/canvas[2]")
	private WebElement xpathToConfirmTestExecutionChart;
	
	//Xpath to get test created in last 30 days.
	@FindBy(xpath="//*[@id='chart-details-id']//strong[1]")
	private WebElement xpathToGetTotalTestCreatedFromCreationChart;
	
	//Xpath to get test executed in last 30 days.
	@FindBy(xpath="//*[@id='execution-details-id']//strong[1]")
	private WebElement xpathToGetTotalTestExecutedFromExecutionChart;
	
	//Xpath to get total test created under the project.
	@FindBy(xpath="//div[a[@title='Total Tests']]/span")
	private WebElement xpathToGetTotalTestCreated;
	
	//Xapth to get total test executed under the project.
	@FindBy(xpath="//div[a[@title='Total Tests']]/following-sibling::div[1]/span")
	private WebElement xpathToGetTotalTestExecuted;
	
	//xpath to get total test remaining under the project.
	@FindBy(xpath="//div[a[@title='Total Tests']]/following-sibling::div[2]/span")
	private WebElement xpathToGetTotalTestRemaining;
	
	//xpath to click on total test created under a project.
	@FindBy(xpath="//a[@title='Total Tests']")
	private WebElement xpathToSelectTotalTestCreated;
	
	//Xpath to get total test unscheduled under a project.
	@FindBy(xpath="//div[@class='results-count aui-item']/span[2]/strong")
	private WebElement xpathToSelectTestUnsheduled;
	
	
	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	public boolean validateTestSummaryPage(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(xpathToValidateTestSummaryPage.isDisplayed(),"Test summary page validation Failed...");
			Assert.assertTrue((xpathToConfirmTestCreationChart.isDisplayed())&&(xpathToConfirmTestExecutionChart.isDisplayed())
					,"Test Creation And Execution Charts not dispalyed");
					Assert.assertTrue(xpathTovalidateTestSummary.isDisplayed(),"Test Summary heading not displayed...");
					
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	
	public boolean validateTestSummary(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(xpathToValidateTestSummaryPage.isDisplayed(),"Test summary page validation Failed...");
			Assert.assertTrue((xpathToConfirmTestCreationChart.isDisplayed())&&(xpathToConfirmTestExecutionChart.isDisplayed())
					,"Test Creation And Execution Charts not dispalyed");
					Assert.assertTrue(xpathTovalidateTestSummary.isDisplayed(),"Test Summary heading not displayed...");
						int testCreated= Integer.parseInt(xpathToGetTotalTestCreated.getText());
						int testExecuted= Integer.parseInt(xpathToGetTotalTestExecuted.getText());
						int testRemaining= Integer.parseInt(xpathToGetTotalTestRemaining.getText());
						Assert.assertTrue(testCreated==(testExecuted+testRemaining)&&(testCreated==Integer.parseInt(xpathToGetTotalTestCreatedFromCreationChart.getText()))
								,"Total test count Validation Failed");
							logger.info("total tests= "+testCreated+"");
							logger.info("total tests Executed= "+testExecuted+"");
							logger.info("total tests Remaning= "+testRemaining+"");
						/*else{
							logger.info("Total test count Validation Failed...");
							return false;
						}*/
						if((testCreated>0)){
							xpathToSelectTotalTestCreated.click();
							SearchTestsPage.getInstance().validateTest(testCreated);
						}
						
						logger.info("Total number of Test under Version: ");
						List<String> version= CommonUtil.getValues("//div[h3[contains(text(),'Tests By Version')]]/following-sibling::div//a");
						for(int i=0;i<=(version.size()-1);i++){
							 String versionName=version.get(i);
							 int count=Integer.parseInt(CommonUtil.getValue("//div[a[contains(text(),'"+versionName+"')]]/span"));
							 if(count>0){
								 CommonUtil.clickOnElement("//a[contains(text(),'"+versionName+"')]");
								 SearchTestsPage.getInstance().validateTest(count);
								 logger.info("Total test under "+versionName+"= "+count+"");
								 
							 }
							 else{
								 count=0;
								 logger.info("Total test under "+versionName+"= "+count+"");
							 }
						}
						
						logger.info("Total number of Test under Component: ");
						List<String> component=CommonUtil.getValues("//div[h3[contains(text(),'Tests By Component')]]/following-sibling::div//a");
						for(int i=0;i<=(component.size()-1);i++){
							 String componentName=component.get(i);
							 int count=Integer.parseInt(CommonUtil.getValue("//div[a[contains(text(),'"+componentName+"')]]/span"));
							 if(count>0){
								 CommonUtil.clickOnElement("//a[contains(text(),'"+componentName+"')]");
								 SearchTestsPage.getInstance().validateTest(count);
								 logger.info("Total test under "+componentName+"= "+count+"");
								 
							 }
							 else{
								 count=0;
								 logger.info("Total test under "+componentName+"= "+count+"");
							 }
							 
						}
						
						logger.info("Total number of Test under Label: ");
						List<String> label=CommonUtil.getValues("//div[h3[contains(text(),'Tests By Label')]]/following-sibling::div//a");
						for(int i=0;i<=(label.size()-1);i++){
							 String labelName=label.get(i);
							 int count=Integer.parseInt(CommonUtil.getValue("//div[a[contains(text(),'"+labelName+"')]]/span"));
							 if(count>0){
								 CommonUtil.clickOnElement("//a[contains(text(),'"+labelName+"')]");
								 SearchTestsPage.getInstance().validateTest(count);
								 logger.info("Total test under "+labelName+"= "+count+"");
							 }
							 else{
								 count=0;
								 logger.info("Total test under "+labelName+"= "+count+"");
								 
							 }
							 
						}
						
					
					
				
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public SearchTestsPage navigateToSearchTestPage(){
		return SearchTestsPage.getInstance();
	}
	
	public boolean validateSummaryCharts(){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(xpathToValidateTestSummaryPage.isDisplayed(),"Test Summary page Validation Failed...");
			Assert.assertTrue((xpathToConfirmTestCreationChart.isDisplayed())&&(xpathToConfirmTestExecutionChart.isDisplayed())
					,"Test Creation And Execution Charts not displayed...");
					String testCreated= xpathToGetTotalTestCreatedFromCreationChart.getText();
					String totalTest= xpathToGetTotalTestCreated.getText();
					String testExecuted=xpathToGetTotalTestExecutedFromExecutionChart.getText();
					Assert.assertTrue(testCreated.equals(totalTest),"Total number Tests created are not equal...");
						List<String> creationDateDisplayed=CommonUtil.getValues("//*[@id='testcases-creation-chart-id']//div[@class='tickLabels']/div[1]/div");
						List<String> executionDateDisplayed=CommonUtil.getValues("//*[@id='execution-creation-chart-id']/div[1]/div[1]/div");
						List<String> testCreationRange=CommonUtil.getValues("//*[@id='testcases-creation-chart-id']//div[@class='tickLabels']/div[2]/div");
						List<String> testExecutionrange=CommonUtil.getValues("//*[@id='execution-creation-chart-id']/div[1]/div[2]/div");
						String creationDate=creationDateDisplayed.get((creationDateDisplayed.size()-1));
						String executionDate=executionDateDisplayed.get((executionDateDisplayed.size()-1));
						if((testCreationRange.size()>1)&&((testExecutionrange.size()>1))){
							String maximumTestCreated=testCreationRange.get(testCreationRange.size()-2)+" to "+testCreationRange.get(testCreationRange.size()-1);
							String maximumTestExecuted=testExecutionrange.get(testExecutionrange.size()-2)+" to "+testExecutionrange.get(testExecutionrange.size()-1);
							logger.info("Maximum number of test created in a day is between: "+maximumTestCreated+"");
							logger.info("Maximum number of test executed in a day is between: "+maximumTestExecuted+"");
						}
						logger.info("Test Creation Graph is dated till : "+creationDate+"");
						logger.info("Test Execution Graph is dated till : "+executionDate+"");
						logger.info("total test created for the last 30 days are: "+testCreated+"");
						logger.info("total test executed for the last 30 days are: "+testExecuted+"");
					
					/*else{
						logger.info("Total number Tests created are not equal...");
						return false;
					}*/
					
				
				
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
			
		return true;
	}
	
	
}
