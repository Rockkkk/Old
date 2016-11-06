package com.thed.zfjbvt.zfj.impl.zfj22;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import au.com.bytecode.opencsv.CSVReader;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;
import com.thed.zfjbvt.zfj.impl.zfj22.AddTestsToCyclePage;
import com.thed.zfjbvt.zfj.impl.zfj22.CloneTestCyclePage;
import com.thed.zfjbvt.zfj.impl.zfj22.CreateNewCyclePage;
import com.thed.zfjbvt.zfj.impl.zfj22.ExecuteTestsPage;
import com.thed.zfjbvt.zfj.impl.zfj22.TestSummaryPage;
import com.thed.zfjbvt.zfj.impl.zfj22.ViewTestPage;

public class PlanTestCyclePage {
private Logger logger = Logger.getLogger(this.getClass());
	
	public static PlanTestCyclePage getInstance() {
		return PageFactory.initElements(Driver.driver, PlanTestCyclePage.class);
	}
	
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
	
	@FindBy(xpath="//*[@id='content']//ul[@class='vertical tabs']")
	private WebElement testCycleSidebar;
	
	
	@FindBy(xpath="//a[strong[text()='Test Cycles']]")
	private WebElement testCycleTabXpath;

	
	// Webelement for header Text in plan test cycle page.
	@FindBy(xpath="//*[@id='project-tab']/descendant::h2")
	private WebElement planTestCycleHeaderTextXpath;
	
	// Current cycle version name in plan test cycle.
	@FindBy(xpath="//*[@id='cyclesummarymodule']/div[2]/nav/ul")
	private WebElement xpathOfCurrentVersionName;
	
	// Select version webelement.
	@FindBy(id="select-version2")
	private WebElement selectVersionInPlanTestCyclePage;
	
	// Create a new test cyle link for creating a cycle.
	@FindBy(id="pdb-create-cycle-dialog")
	private WebElement createNewCycleLink;
	
	// webelement to Clone Testcycle.
	@FindBy(xpath="//*[@id='jira']/div/div/ul/li/a[contains(text(),'Clone Cycle')]")
	private WebElement cloneTestCycle;
	
	// Add tests to the cycle webelement where user can add tests to the cycle single and multiple.
		@FindBy(xpath="//*[@id='jira']/div/div/ul/li/a[text()='Add Tests']")
		private WebElement addTestLinkOfCycle;
		
		// Edit Cycle Link webelement.
		@FindBy(xpath="//*[@id='jira']/div/div/ul/li/a[text()='Edit Cycle']")
		private WebElement xpathForEditCycleLink;
		
		/*@FindBy(xpath="//li[div[div[label[text()='Cycle One']]]]")
		private WebElement xpathForCheckCycleIsSelected;*/
		
		// take the pagination value
		@FindBy(xpath="//label[@id='getMoreSchedulesLbl']")
		private WebElement paginationValue;
		
		//Xpath for Test Summary Link.
		@FindBy(xpath="//*[@id='pdb_test_panel_section-panel']/strong")
		private WebElement xpathForTestSummaryLink;
		
	//Export tests link in cyle manage link
	@FindBy(xpath="//*[@id='jira']/div/div/ul/li/a[contains(text(),'Export Tests')]")
	private WebElement xpathForExportTestsLink;
	
	/*@FindBy(xpath="//li[div[div[label[text()='Cycle One']]]]")
	private WebElement xpathForCheckCycleIsSelected;*/
	
	// This xpath will select all the cycles.
	@FindBy(xpath="//ul[@id='project-panel-cycle-list-summary']/li[contains(@id,'cycle-')]")
	private List<WebElement> xpathForCycles;
	
	// all header name xpath
	@FindBy(xpath="//table[@id='issuetable']/descendant::th")
	private List<WebElement> xpathForHeadersOfIssueTable;
	
	@FindBy(id="select-version2-field")
	private WebElement xpathForCurrentVersion;
	
	/*// This xpath will select all the cycles.
		@FindBy(xpath="//ul[@id='project-panel-cycle-list-summary']/li[contains(@id,'cycle-')]/div[div[label[@class='versionBanner-name singleLine']]]")
		private List<WebElement> xpathForCycles;*/

	/******************************************************
	 * 	PAGE OBJECT METHODS
	 *****************************************************/
	/**
	 * This method is used to export a cycle from the cycle and validate the cycle.
	 * @param versionName This parameter contains the version name.<br/>
	 * @param cycleName	This parameter contains the cycle name.<br/>
	 * @param cycleStartDate This parameter contains the cycle start date.<br/>
	 * @param buildName This parameter contains the build name.<br/>
	 * @param enviromentName This parameter contains the enviroment name.<br/>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean exportTestsFromCycle(String versionName, String cycleName, String cycleStartDate, String buildName, String enviromentName){
		try{
			  CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			  FileUtils.cleanDirectory(new File(Config.getValue("EXPORT_FILE_PATH")));
			  System.out.println("All files are deleted.");
			  CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			  Assert.assertTrue(selectVersion(versionName), "Version is not finding.");
			  logger.info(versionName+" is selected successfully.");
			 /* if(checkCycleIsExpanded(cycleName)){
					logger.info("Cycle is expanded.");
				}else{
					logger.info("Cycle is not expanded.");
					Assert.assertTrue(selectVersion(versionName), "Version is not selected successfully.");
					Assert.assertTrue(navigateToTestCycle(cycleName), "Cycle is not selected successfully.");
					logger.info("Cycle is expanded.");
				}*/
			/*// Assert.assertTrue(checkCycleIsExpanded(cycleName), "Cycle is not expanded.");
			  String xpathForTheCycle="//li[div[div[label[text()='"+cycleName+"']]]]";
			  System.out.println(CommonUtil.isElementPresent(xpathForTheCycle));
			 // CommonUtil.navigateThroughXpath(xpathForTheCycle);
			  Driver.driver.findElement(By.xpath(xpathForTheCycle)).click();
		      CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			  logger.info("Now it is expanded.");
			  */
			  if(checkCycleIsExpanded(cycleName)){
					logger.info("Cycle is expanded.");
				}else{
					logger.info("Cycle is not expanded.");
					Assert.assertTrue(selectVersion(versionName), "Version is not selected successfully.");
					Assert.assertTrue(navigateToTestCycle(cycleName), "Cycle is not selected successfully.");
					logger.info("Cycle is expanded.");
				}
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			  String xpathForID="//div[div[*[text()='"+cycleName+"']]]/following-sibling::div/table/thead/tr/th[text()='ID']";
			  CommonUtil.navigateThroughXpath(xpathForID);
			  CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			  hoverInTestCycle(cycleName);
			  navigateToManageLinkInCycle(cycleName);
			  xpathForExportTestsLink.click();
			  CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
			  CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			  logger.info("Navigated to Export Tests from Cycle page.");
	
			  
			  //E:\export\Cycle-Cycle+Two.csv  E:\export\Cycle-Cycle+Two.csv
			  /*String[] cycleStrings=cycleName.split(" ");
			  String newCycleName=cycleStrings[0]+"+"+cycleStrings[1];
			  System.out.println(newCycleName);*/
			  //String FilePath=Config.getValue("EXPORT_FILE_PATH")+"Cycle-"+newCycleName+".csv";
			  String FilePath=Config.getValue("EXPORT_FILE_PATH")+"Cycle-"+cycleName+".csv";
			  logger.info(FilePath);
			  Assert.assertTrue(CommonUtil.fileExists(FilePath), "File is not present in the directory.");
			  CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			  logger.info("File is downloaded successfully.");
			  Assert.assertTrue(CommonUtil.fileSize(FilePath), "File is present but size is 0 may be not downloaded properly.");
			  logger.info("File is present and the size is greater than ZERO.");
			  /*File file=new File(FilePath);
			  if(file.exists()){
					double d=file.length();
					System.out.println(d);
					if(d != 0){
						System.out.println("File is present and file lengthis"+d);
					}else{
						System.out.println("File is not present.");
					}
			  }*/
			 logger.info("File is validated successfully in local system.");
			 Assert.assertTrue(compareHeaderInCSV(FilePath, versionName, cycleName, cycleStartDate, buildName, enviromentName), "Header is not same.");
			 logger.info("Header part is same in export file.");
			
			 Assert.assertTrue(compareCycleValueInCSV(FilePath, cycleName), "All exported values are not matching.");
			
			 logger.info("All exported values are matching in CSV file.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * This method comapares the header part of the cycle after exporting the cycle.
	 * @param fileName This parameter contains the filename of the csv file.
	 * @param versionName This parameter contains the version name.<br/>
	 * @param cycleName	This parameter contains the cycle name.<br/>
	 * @param cycleStartDate This parameter contains the cycle start date.<br/>
	 * @param buildName This parameter contains the build name.<br/>
	 * @param enviromentName This parameter contains the enviroment name.<br/>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean compareHeaderInCSV(String fileName, String versionName, String cycleName, String startDate, String buildName, String enviromentName){
		try{
			CSVReader reader = new CSVReader(new FileReader(fileName));
		      String [] nextLine;
		      int lineNumber = 0;
		      while ((nextLine = reader.readNext()) != null) {
			    	 
			    	 for(int i=0; i< nextLine.length ; i++ ){
			    		 if(lineNumber == 0){
			    			 Assert.assertTrue(nextLine[i].contains(Config.getValue("JIRA_PROJECT")), "Project name is not matching in csv file.");
				        	 logger.info("Project name is matching in csv file.");
				    		 
			    		 } else if (lineNumber == 1) {
			    			 Assert.assertTrue(nextLine[i].contains(versionName), "Version name is not matching in csv file.");
				        	 logger.info("Version name is matching in csv file.");
			   
						 }else if (lineNumber == 2) {
							if(nextLine[i].contains("Cycle")){
								Assert.assertTrue(nextLine[i].contains(cycleName), "Cycle name is not matching in csv file.");
					        	logger.info("Cycle name is matching in csv file.");
							}else if (nextLine[i].contains("Starting On")) {
								String cycleStartDate=CommonUtil.dateConversion(startDate);
								Assert.assertTrue(nextLine[i].contains(cycleStartDate), "Cycle start date is not matching in csv file.");
					        	logger.info("Cycle startdate is matching in csv file.");
							}else if (nextLine[i].contains("Build")) {
								//String[] str=nextLine[i].split(":");
								String[] str=nextLine[i].split("-");
								if (str.length <= 1) {
									logger.info("Build name is not given for the cycle.");
								}else{
									Assert.assertTrue(nextLine[i].contains(buildName), "Cycle start date is not matching in csv file.");
									logger.info("Build name is verified in exported csv file.");
								}
							}else if (nextLine[i].contains("Environment")) {
								String[] str=nextLine[i].split("-");
								
								if (str.length <= 1) {
									logger.info("Enviroment name is not given for the cycle.");
								}else{
									Assert.assertTrue(nextLine[i].contains(enviromentName), "Cycle start date is not matching in csv file.");
									logger.info("Enviroment name is verified in exported csv file.");
								}
							}
					        
						}
			    		
			    	 }
			    	 lineNumber++;
		      }
		      logger.info("Cycle Header is verified successfully after exporting.");
		}catch(Exception e){
			logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	/**
	 * This method contains the  number of rows present inside the csv file.
	 * @param fileName This parameter contains the filename of the csv file.
	 * @return The integer value.
	 */
	public int rowCountInCSV(String fileName){
		 int rowCount=0;
		try{
			CSVReader reader = new CSVReader(new FileReader(fileName));
		      String [] nextLine;
		      	     
		      while ((nextLine = reader.readNext()) != null) {
		    	  rowCount++;
		      }
		     // System.out.println("Total rows : "+rowCount);
		      
		}catch(Exception e){
			e.printStackTrace();
		
		}
		return rowCount;
	}
	/**
	 * This method comapares the Values of the cycle after exporting the cycle.
	 * @param fileName This parameter contains the filename of the csv file.
	 * @param versionName This parameter contains the version name.<br/>
	 * @param cycleName	This parameter contains the cycle name.<br/>
	 * @param cycleStartDate This parameter contains the cycle start date.<br/>
	 * @param buildName This parameter contains the build name.<br/>
	 * @param enviromentName This parameter contains the enviroment name.<br/>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean compareCycleValueInCSV(String fileName, String cycleName){
		try{
			String xpath="//div[div[*[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr";
			
			List<WebElement> list=Driver.driver.findElements(By.xpath(xpath));
			//logger.info("Size of the list:"+list.size());
						
			  CSVReader reader = new CSVReader(new FileReader(fileName));
		      String [] nextLine;
		      int lineNumber = 0;
		      String compareLine=null;
		      int rowCount=0;
		      while ((nextLine = reader.readNext()) != null) {
		    	  rowCount++;
		      }
		      System.out.println("Total rows : "+rowCount);
		      while ((nextLine = reader.readNext()) != null) {
			    String line;	 
			    	 
		    	  if(lineNumber > 3){
		    		  //logger.info("Line number is greater than 4.");
		    		 
			    	 for(int i=lineNumber; i < rowCountInCSV(fileName) ; i++ ){
			    		 for(int j=0; j<= nextLine.length - 1 ; j++ ){
			    			 logger.info("-------------------------------------");
			    			 logger.info(list.get(lineNumber-4).getText()+""+nextLine[j]);
			    			 logger.info("-------------------------------------");
			    			 
			    			 if(j == 0){
			    				 for(int k=0; k< list.size();k++){
			    					 if(list.get(k).getText().contains(nextLine[j])){
			    						 compareLine=list.get(k).getText();
			    						 break;
			    					 }
			    					 
			    					 
			    					 
			    				 }
			    			 }
			    			 
			    			 if(!(nextLine[j].equals("-"))) {
			    				 System.out.println(compareLine+" : "+nextLine[j]);
			    				if(compareLine.contains(nextLine[j])){
			    					//logger.info(nextLine[j]);
				    				logger.info("column "+(j+1)+" is matched.");
				    			//} else if(j == nextLine.length - 1) {
			    				} else if(j+1 == 8) {
				    				Assert.assertNotNull(nextLine[j]);
				    				logger.info("column "+(j+1)+" contains some Date.");
				    			} else {
				    				 //logger.info(nextLine[j]);
				    				 logger.info("column "+(j+1)+" is not matched.");
								}
			    			} else {
			    				logger.info("column "+(j+1)+" contains null value.");
							}
			    		 }
			    		 logger.info("Line-"+(lineNumber - 3)+" is matching.");
			    		 break;
			    	 }
		    	  }
		    	  
		    	  lineNumber++;
		      }
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * This method is used to navigate to 
	 * @param versionName
	 * @param cycleName
	 * @return
	 *//*
	public CreateNewCyclePage navigateToExport(String versionName, String cycleName){
		try{
			Assert.assertTrue(selectVersion(versionName), versionName+" is not selected successfully.");
			logger.info(versionName+" is selected successfully.");
			
			hoverInTestCycle(cycleName);
			navigateToManageLinkInCycle(cycleName);
			xpathForEditCycleLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to Edit Cycle page.");
			
		}catch(Exception e){
			logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
		}
		return CreateNewCyclePage.getInstance();
	}*/

	/**
	 * 
	 * This method is used to navigate to create new cycle page i.e. where you can give the cycle value and create a new cycle.
	 * This method will take a map which contains VERSION_NAME, CYCLE_NAME and TEST_NAME.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used for adding into the cycle in zfj. <br/>
	 * </p>
	 * @return It returns the Create NewCycle Page instance.
	 */
	//public CreateNewCyclePage navigateToCreateNewCyclePage(String versionName){
	public CreateNewCyclePage navigateToCreateNewCyclePage(Map<String, String> values){
		try{
			Assert.assertTrue( validatePage(), "Plan Test Cycle page is not Validated successfully.");
						
			Assert.assertTrue(selectVersion(values.get("VERSION_NAME")), values.get("VERSION_NAME")+" is not selected successfully.");
			logger.info(values.get("VERSION_NAME")+" is selected successfully.");
			createNewCycleLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Clicked on create new Cycle Link.");
			
		}catch(Exception e){
			logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
		}
		return CreateNewCyclePage.getInstance();
	}
	
	/**
	 *  This method is used to navigate to create new cycle page i.e. where you can give the cycle value and create a new cycle.
	 * @param versionName  This parameter contains version name.<br/>
	 * @param cycleName  This parameter contains cycle name.<br/>
	 * @return The AddTestsToCyclePage page instance. 
	 * @throws Exception 
	 */
	public AddTestsToCyclePage navigateToAddTestToCyclePage(String versionName, String cycleName) throws Exception{
		try{
			Assert.assertTrue( validatePage(), "Plan Test Cycle page is not Validated successfully.");
			
			Assert.assertTrue(selectVersion(versionName), versionName+" is not selected successfully.");
			logger.info(versionName+" is selected successfully.");
			CommonUtil.scrollToWebElement(CommonUtil.changeToWebElement("//ul[@id='project-panel-cycle-list-summary']/li/div/div/a[text()='"+cycleName+"']"));
			hoverInTestCycle(cycleName);
			navigateToManageLinkInCycle(cycleName);
			addTestLinkOfCycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Clicked on add tests to the Cycle page.");
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return AddTestsToCyclePage.getInstance();
	}

	/**
	 * This method is used to navigate to edit cycle page.
	 * @param versionName  This parameter contains version name.<br/>
	 * @param cycleName  This parameter contains cycle name.<br/>
	 * @return The CreateNewCyclePage page instance.
	 */
	public CreateNewCyclePage navigateToEditCyclePage(String versionName, String cycleName){
		try{
			Assert.assertTrue(selectVersion(versionName), versionName+" is not selected successfully.");
						
			hoverInTestCycle(cycleName);
			navigateToManageLinkInCycle(cycleName);
			xpathForEditCycleLink.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to Edit Cycle page.");
			
		}catch(Exception e){
			e.printStackTrace();
		
		}
		
		return CreateNewCyclePage.getInstance();
	}
	/**
	 * Method to clone a Testcycle.
	 * 
	 * @param versionName
	 * @param cycleName
	 * @return
	 */
	public CloneTestCyclePage navigateToCloneTestCyclePage(String versionName, String cycleName){
		try{
			Assert.assertTrue(selectVersion(versionName), versionName+" is not selected successfully.");
			logger.info(versionName+" is selected successfully.");
			CommonUtil.scrollToWebElement(CommonUtil.changeToWebElement("//ul[@id='project-panel-cycle-list-summary']/li/div/div/a[text()='"+cycleName+"']"));
			hoverInTestCycle(cycleName);
			navigateToManageLinkInCycle(cycleName);
			cloneTestCycle.click();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to add tests to the Cycle page.");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return CloneTestCyclePage.getInstance();
	}
	

	
	/**
	 * This method is used to execute a test directly from plan test cycle page.	
	 * @param versionName  This parameter contains version name.
	 * @param cycleName  This parameter contains cycle name.
	 * @param testName This parameter contains the test name which is going to execute.
	 * @param testExecStatus This parameter contains the test execution status.
	 * @return The boolean value.
	 */
	
	
	public boolean executeTestDirectly(String versionName, String cycleName, String testName, String testExecStatus){
		try{
			//System.out.println("Tets xpath= "+linkForTest);
			Assert.assertTrue(planTestCycleHeaderTextXpath.getText().equals("Test Cycles"), "Plan Test cycle page is not verified successfully.");
            logger.info("Plan Test cycle page not verified successfully.");
			Assert.assertTrue(selectVersion(versionName), "Version is not selected successfully.");
			Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
			
			String xpathForClickingOnLabelOfStatus="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td[1]/div/div/div[@class='labels exec-status-container']/dl/dd";
			CommonUtil.navigateThroughXpath(xpathForClickingOnLabelOfStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			String xpathForSelectTestStatus="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td/div/div[contains(@id,'execution-field-select-schedule')]/select";
			CommonUtil.selectListWithVisibleText(CommonUtil.returnWebElement(xpathForSelectTestStatus), testExecStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			String xpathForCycleSummaryHeader="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/thead/tr/th[text()='Summary']";
			CommonUtil.navigateThroughXpath(xpathForCycleSummaryHeader);
			logger.info("test is executed successfully directly.");
			
			String xpathForTestExecutedByNameInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td/a[@class='user-hover']";
			String executedUser=CommonUtil.getTextFromUIByXpath(xpathForTestExecutedByNameInPlanTestCycle);
			String xpathForTestExecutedOnTimeInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td[contains(@id,'executed-on')]";
			String executedTime=CommonUtil.getTextFromUIByXpath(xpathForTestExecutedOnTimeInPlanTestCycle);
			
			Assert.assertTrue(validateTestExecutedStatus(cycleName, testName, testExecStatus), "Test Status is not validated successfully in Plan Test Cycle Page.");
			logger.info("Test Status is Validated Sucessfully in Plan Test Cycle Page.");
			/*String xpathForTestExecutionStatusInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td[1]/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			Assert.assertTrue(testExecStatus.equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInPlanTestCycle)), "Test status is not matched in Test execution page.");
			logger.info("Test execution status is matched in the cycle after returning to the cycle.");
			*/
			Assert.assertTrue(navigateToTestViewIssuePage(testName)
								.validateTestStatus(versionName, cycleName, testExecStatus, executedUser, executedTime), "Test Execution Details is not validated in View Issue Page.");
			//logger.info("Navigated to View Issue page successfully.");
			
			//Assert.assertTrue(ViewTestPage.getInstance().validateTestStatus(versionName, cycleName, testExecStatus, executedUser, executedTime), "Executed Test Details is not validated in View Issue Page.");
			logger.info("Executed Test Details is validated successfully in View Issue Page.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
		return true;
	}
	/**
	 * This method is used to verify the tests which are added to the cycle.
	 * @param cycleName This parameter contains the cycle name.
	 * @param testName This parameter contains the test name.
	 * @return The boolean value.
	 */
	public boolean verifyAddedTestsInCycle(String cycleName, String testName){
		try{
			//Assert.assertTrue(navigateToTestCycle(cycleName), "Navigated to test cycle is not successfully.");
			Assert.assertTrue(expandCycle(cycleName), "Not Navigated to Cycle.");
			logger.info("Now Showing all the tests in the cycle.");
			Assert.assertTrue(searchTestInCycle(cycleName, testName));
			logger.info(testName+" is verified in "+cycleName+".");
			Assert.assertTrue(navigateToTestCycle(cycleName), "Navigated to test cycle is not successfully.");
			logger.info(cycleName+" is closed successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * This method is used to verify tests in the cycle i.e. all tests are present inside the cycle or not.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name.<br/>
	 * <b>TEST_ONE</b> This parameter contains test one which is goig to add and execute.<br/>
	 * <b>TEST_TWO</b> This parameter contains test two which is goig to add and execute.<br/>
	 * <b>TEST_THREE</b> This parameter contains test two which is goig to add and execute. <br/>
	 * <b>TEST_FOUR</b> This parameter contains test four which is going to add and execute.<br/>
	 * <b>TEST_FIVE</b> This parameter contains test five which is going to add and execute.<br/>
	 * </p>
	 * @return
	 */
	public boolean verifyAddedTestsInCycle(Map<String, String> values){
		try{
			Assert.assertTrue(expandCycle(values.get("CYCLE_NAME")), "Not selected the test cycle is not successfully.");
			logger.info("Now Showing all tests in "+values.get("CYCLE_NAME")+".");
			
			Assert.assertTrue(searchTestInCycle(values.get("CYCLE_NAME"), values.get("TEST_ONE")));
			logger.info(values.get("TEST_ONE")+" is verified in the cycle.");
			
			Assert.assertTrue(searchTestInCycle(values.get("CYCLE_NAME"), values.get("TEST_TWO")));
			logger.info(values.get("TEST_TWO")+" is verified in the cycle.");
			
			Assert.assertTrue(searchTestInCycle(values.get("CYCLE_NAME"), values.get("TEST_THREE")));
			logger.info(values.get("TEST_THREE")+" is verified in the cycle.");
			
			Assert.assertTrue(searchTestInCycle(values.get("CYCLE_NAME"), values.get("TEST_FOUR")));
			logger.info(values.get("TEST_FOUR")+" is verified in the cycle.");
			
			Assert.assertTrue(searchTestInCycle(values.get("CYCLE_NAME"), values.get("TEST_FIVE")));
			logger.info(values.get("TEST_FIVE")+" is verified in the cycle.");
			
			Assert.assertTrue(closeCycle(values.get("CYCLE_NAME")), "Navigated to test cycle is not successfully.");
			logger.info(values.get("CYCLE_NAME")+" is closed Successfully.");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * This method is used to navigate to execution page for the execution.
	 * @param versionName  This parameter contains cycle name which is used while creating the cycle and selecting the cycle.
	 * @param cycleName This parameter contains the cycle name which is used for creating and selecting a cycle.
	 * @param testName This parameter contains the test name which is used executing into the cycle in zfj.
	 * @return The boolean value i.e. True or False.
	 *//*
		
	/**
	 * This method is used to navigate to execution page for the execution.
	 * @param versionName  This parameter contains cycle name which is used while creating the cycle and selecting the cycle.
	 * @param cycleName This parameter contains the cycle name which is used for creating and selecting a cycle.
	 * @param testName This parameter contains the test name which is used executing into the cycle in zfj.
	 * @return The boolean value i.e. True or False.
	 */
	public ExecuteTestsPage navigateToExecuteTestsPageUsingE(String versionName, String cycleName, String testName){
		try{
			Assert.assertTrue(selectVersion(versionName), "Version is not selected successfully.");
			//Assert.assertTrue(expandedCycle(cycleName), "Cycle is not expanded.");
			//logger.info("Cycle is expanded successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			/*Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
			Assert.assertTrue(hoverOnTestAndNavigateToExecutionPageUsingE(cycleName, testName), "Not Navigated properly to execute Tests page.");
			logger.info("Navigated to Execute test page.");*/
			try{
				String xpathForCycle="//ul[@id='project-panel-cycle-list-summary']/li/div/div[a[text()='"+cycleName+"']]";	
				Assert.assertTrue(CommonUtil.scrollPage(CommonUtil.returnWebElement(xpathForCycle)),"Not Scrolled to the cycle.");
			
				Assert.assertTrue(expandCycle(cycleName), "Version is not selected successfully.");
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				Assert.assertTrue(hoverOnTestAndNavigateToExecutionPageUsingE(cycleName, testName), "Not Navigated properly to execute Tests page.");
				logger.info("Navigated to Execute test page.");
			}catch(Exception e){
				try{
					JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
				    js.executeScript("javascript:window.scrollBy(250,400)"); 
				    logger.info("Scroll bar is scrolled.");
				    Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
				    Assert.assertTrue(hoverOnTestAndNavigateToExecutionPageUsingE(cycleName, testName), "Not Navigated properly to execute Tests page.");
					logger.info("Navigated to Execute test page.");
				}catch(Exception ee){
					JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
				    js.executeScript("javascript:window.scrollBy(250,400)"); 
				    logger.info("Scroll bar is scrolled.");
				    Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
				    Assert.assertTrue(hoverOnTestAndNavigateToExecutionPageUsingE(cycleName, testName), "Not Navigated properly to execute Tests page.");
					logger.info("Navigated to Execute test page.");
				}
				//e.printStackTrace();
			}
			
		}catch(Exception e){
			//logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
		}
		return ExecuteTestsPage.getInstance();
	}
	public ExecuteTestsPage navigateToExecuteTestPage(String versionName, String cycleName, String testName){
		try{
			Assert.assertTrue(selectVersion(versionName), "Version is not selected successfully.");
			//Assert.assertTrue(expandedCycle(cycleName), "Cycle is not expanded.");
			//logger.info("Cycle is expanded successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			//Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
			try{
				Assert.assertTrue(expandCycle(cycleName), "Version is not selected successfully.");
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				Assert.assertTrue(hoverOnTestAndNavigateToExecutionPageUsingE(cycleName, testName), "Not Navigated properly to execute Tests page.");
				logger.info("Navigated to Execute test page.");
			}catch(Exception e){
				try{
					JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
				    js.executeScript("javascript:window.scrollBy(250,400)"); 
				    logger.info("Scroll bar is scrolled.");
				    Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
				    Assert.assertTrue(hoverOnTestAndNavigateToExecutionPageUsingE(cycleName, testName), "Not Navigated properly to execute Tests page.");
					logger.info("Navigated to Execute test page.");
				}catch(Exception ee){
					JavascriptExecutor js = (JavascriptExecutor) Driver.driver;
				    js.executeScript("javascript:window.scrollBy(250,400)"); 
				    logger.info("Scroll bar is scrolled.");
				    Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
				    Assert.assertTrue(hoverOnTestAndNavigateToExecutionPageUsingE(cycleName, testName), "Not Navigated properly to execute Tests page.");
					logger.info("Navigated to Execute test page.");
				}
				//e.printStackTrace();
			}
		}catch(Exception e){
			//logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
		}
		return ExecuteTestsPage.getInstance();
	}
	
	

	
	
	/**
	 * This method is used to execute a test and validate it.
	 * @param versionName This parameter contains cycle name which is used while creating the cycle and selecting the cycle.
	 * @param cycleName This parameter contains the cycle name which is used for creating and selecting a cycle.
	 * @param testName This parameter contains the test name which is used executing into the cycle in zfj. 
	 * @param testExecStatus This parameter contains test execution status which is used for set the status while executing test.
	 * @return The boolean value.
	 */
	public boolean executeTestsAndValidate(String versionName, String cycleName, String testName, String testExecStatus){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Map<String, String> returnValues=ExecuteTestsPage.getInstance().changeTestExcutionStatus(testExecStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(planTestCycleHeaderTextXpath.getText().equals("Test Cycles"), "Plan Test cycle page is not verified successfully.");
            logger.info("Plan Test cycle page not verified successfully.");
            
			Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded.");
			logger.info("Cycle is expanded successfully.");
			
			
			
			String xpathForTestExecutionStatusInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td[1]/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			/*String a=CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInPlanTestCycle);
			String data=Driver.driver.findElement(By.xpath(xpathForTestExecutionStatusInPlanTestCycle)).getText();
			System.out.println(a+"=="+data);*/
			Assert.assertTrue(testExecStatus.equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInPlanTestCycle)), "Test status is not matched in Test execution page.");
			logger.info("Test execution status is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedByNameInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td/a[@class='user-hover']";
			String x=CommonUtil.getTextFromUIByXpath(xpathForTestExecutedByNameInPlanTestCycle);
			//System.out.println("-----"+x+"-------");
			Assert.assertTrue(returnValues.get("executedUser").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedByNameInPlanTestCycle)), "Test executed by is not matched in Test execution page.");
			logger.info("Test executed by is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedOnTimeInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td[contains(@id,'executed-on')]";
			Assert.assertTrue(returnValues.get("executedTime").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedOnTimeInPlanTestCycle)), "Test executed on time is not matched in Test execution page.");
			logger.info("Test executed on time is matched in the cycle after returning to the cycle.");
			
			/*Assert.assertTrue(navigateToTestViewIssuePage(testName), "Not navigated to view issue page.");
			logger.info("Navigated to View Issue page successfully.");*/
			
			Assert.assertTrue(navigateToTestViewIssuePage(testName)
								.validateTestStatus(versionName, cycleName, testExecStatus, returnValues.get("executedUser"), returnValues.get("executedTime")), "Test execution Details is not validated in View Issue Page.");
			logger.info("Test Execution details is validated successfully in View issue page.");
			
			CommonUtil.navigateBack();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(closeCycle(cycleName), "Not Closed properly to the cycle.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public boolean executeTestAndValidate(String versionName, String cycleName, String testName, String testExecStatus){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Map<String, String> returnValues=ExecuteTestsPage.getInstance().changeTestExcutionStatus(testExecStatus);
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(planTestCycleHeaderTextXpath.getText().equals("Test Cycles"), "Plan Test cycle page is not verified successfully.");
            logger.info("Plan Test cycle page not verified successfully.");
           
            Assert.assertTrue(selectVersion(versionName), "Version is not selected successfully.");
            logger.info("Version is Selected Successfully.");
            Assert.assertTrue(expandCycle(cycleName), "Cycle is not opened properly.");
            logger.info("Cycle is expanded successfully.");
            System.out.println("correct");
           // Assert.assertTrue(navigateToTestCycle(cycleName), "Cycle is not selected successfully.");
			/*if(checkCycleIsExpanded(cycleName)){
				logger.info("Cycle is expanded.");
			}else{
				logger.info("Cycle is not expanded.");
				Assert.assertTrue(navigateToTestCycle(cycleName), "Version is not selected successfully.");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				logger.info("Cycle is expanded.");
				logger.info("Cycle is expanded or not : "+checkCycleIsExpanded(cycleName));
			}
			
			logger.info("Cycle is expanded successfully.");*/
			
            Assert.assertTrue(validateTestExecutedStatus(cycleName, testName, testExecStatus), "Test Status is not validated in Plan Test Cycle Page");
            logger.info("Test Status is validated successfully in Plan Test Cycle Page");
			
            Assert.assertTrue(validateTestExecutedUser(cycleName, testName, returnValues.get("executedUser")), "Test Executed User is not validated.");
            logger.info("Test Executed User is validated successfully in Plan Test Cycle.");
            
            Assert.assertTrue(validateTestExecutedTime(cycleName, testName, returnValues.get("executedTime")), "Test Executed Time is not validated.");
            logger.info("Test Executed time is validated successfully in Plan Test Cycle.");
			/*
			String xpathForTestExecutionStatusInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td[1]/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			Assert.assertTrue(testExecStatus.equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInPlanTestCycle)), "Test status is not matched in Test execution page.");
			logger.info("Test execution status is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedByNameInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td/a[@class='user-hover']";
			Assert.assertTrue(returnValues.get("executedUser").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedByNameInPlanTestCycle)), "Test executed by is not matched in Test execution page.");
			logger.info("Test executed by is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedOnTimeInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td[contains(@id,'executed-on')]";
			Assert.assertTrue(returnValues.get("executedTime").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedOnTimeInPlanTestCycle)), "Test executed on time is not matched in Test execution page.");
			logger.info("Test executed on time is matched in the cycle after returning to the cycle.");
			*/
			/*Assert.assertTrue(navigateToTestViewIssuePage(testName), "Not navigated to view issue page.");
			logger.info("Navigated to View Issue page successfully.");*/
			
			Assert.assertTrue(navigateToTestViewIssuePage(testName)
									.validateTestStatus(versionName, cycleName, testExecStatus), "Executed Test Details is not validated in View Issue Page.");
			logger.info("Executed Test Details is validated in View Issue Page.");
			
			CommonUtil.navigateBack();
			//Driver.driver.navigate().back();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(navigateToTestCycle(cycleName), "Not Navigated properly to the cycle.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	public boolean executeAllStepsAndValidate(String versionName, String cycleName, String testName, String totalSteps, String stepExecStatus){
		try{
			Map<String, String> returnValues=ExecuteTestsPage.getInstance().executeAllSteps(totalSteps, stepExecStatus);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(planTestCycleHeaderTextXpath.getText().equals("Test Cycles"), "Plan Test cycle page is not verified successfully.");
            logger.info("Plan Test cycle page not verified successfully.");
			Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded.");
			logger.info("Cycle is expanded successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForTestExecutionStatusInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td[1]/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			
			Assert.assertTrue(stepExecStatus.equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInPlanTestCycle)), "Test status is not matched in Test execution page.");
			logger.info("Test execution status is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedByNameInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td/a[@class='user-hover']";
			Assert.assertTrue(returnValues.get("EXECUTED_USER").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedByNameInPlanTestCycle)), "Test executed by is not matched in Test execution page.");
			logger.info("Test executed by is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedOnTimeInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td[contains(@id,'executed-on')]";
			Assert.assertTrue(returnValues.get("EXECUTED_TIME").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedOnTimeInPlanTestCycle)), "Test executed on time is not matched in Test execution page.");
			logger.info("Test executed on time is matched in the cycle after returning to the cycle.");
			
			/*Assert.assertTrue(navigateToTestViewIssuePage(testName), "Not navigated to view issue page.");
			logger.info("Navigated to View Issue page successfully.");*/
			
			Assert.assertTrue(navigateToTestViewIssuePage(testName)
									.validateTestStatus(versionName, cycleName, stepExecStatus), "Executed Test Details is not validated Successfully in View Issue Page.");
			logger.info("Executed Test Details is validated Successfully in View Issue Page.");
			
			CommonUtil.navigateBack();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			Assert.assertTrue(navigateToTestCycle(cycleName), "Not Navigated properly to the cycle.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;

		}

		return true;
	}
	
	
	
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test in test cycle and change the status to any and create a defect asssociated with the test by taking version name, cycle name, test name, test execution status and issue summary from the map.
	 * This method will take a map which contains <b>VERSION_NAME, CYCLE_NAME, TEST_NAME, TEST_EXEC_STATUS and ISSUE_SUMMARY</b>.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * <b>EXECUTED_TIME</b> This parameter is used to give the executed time for the test.
	 * <b>EXECUTED_USER</b> This parameter is used to give the executed user for the test.
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean validateTestExecutionWithDefect(Map<String, String> values){
		try{
			Assert.assertTrue(planTestCycleHeaderTextXpath.getText().equals("Test Cycles"), "Plan Test cycle page is not verified successfully.");
            logger.info("Plan Test cycle page not verified successfully.");
            CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			//Map<String, String> returnValues=ExecuteTestsPage.getInstance().changeTestExcutionStatusWithDefect(values);
			Assert.assertTrue(expandCycle(values.get("CYCLE_NAME")), "Cycle is not expanded.");
			logger.info("Cycle is expanded successfully.");
			
			Assert.assertTrue(getTestExecutedStatus(values.get("CYCLE_NAME"), values.get("TEST_NAME")).equals(values.get("TEST_EXEC_STATUS")), "Test Execution Status is not validated in Plan Test Cycle.");
			logger.info("Test Execution Status is validated successfully in Plan Test Cycle.");
			
			Assert.assertTrue(getAddedDefectToTest(values.get("CYCLE_NAME"), values.get("TEST_NAME")).equals(values.get("ISSUE_ID")), "Added Defect is not Validated in Plan Test Cycle.");
			logger.info("Added Defect is validated successfully in Plan Test Cycle.");
			
			Assert.assertTrue(getTestExecutedUser(values.get("CYCLE_NAME"), values.get("TEST_NAME")).equals(values.get("EXECUTED_USER")), "Test Executed User is not validated in Plan Test Cycle.");
			logger.info("Test Executed User is validated successfully in Plan Test Cycle.");
			
			Assert.assertTrue(getTestExecutedTime(values.get("CYCLE_NAME"), values.get("TEST_NAME")).equals(values.get("EXECUTED_TIME")), "Test Executed Time is not validated in Plan Test Cycle.");
			logger.info("Test Executed Time is validated successfully in Plan Test Cycle.");
			
			/*
			String xpathForTestExecutionStatusInPlanTestCycle="//div[div[a[text()='"+values.get("CYCLE_NAME")+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+values.get("TEST_NAME")+"')]]/following-sibling::td[1]/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			System.out.println(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInPlanTestCycle)+" : "+values.get("TEST_EXEC_STATUS"));
			Assert.assertTrue(values.get("TEST_EXEC_STATUS").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInPlanTestCycle)), "Test status is not matched in Test execution page.");
			logger.info("Test execution status is matched in the cycle after returning to the cycle.");
			
			String getIssueIdFromCycle="//td[a[contains(text(),'"+values.get("TEST_NAME")+"')]]/following-sibling::td[3]/a";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(getIssueIdFromCycle), values.get("ISSUE_ID"), "Issue is not added to the test properly in plan test cycle page.");
			logger.info(values.get("ISSUE_ID")+" issue is verified in plan test cycle page.");
			
			String xpathForTestExecutedByNameInPlanTestCycle="//div[div[a[text()='"+values.get("CYCLE_NAME")+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+values.get("TEST_NAME")+"')]]/following-sibling::td/a[@class='user-hover']";
			Assert.assertTrue(values.get("EXECUTED_USER").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedByNameInPlanTestCycle)), "Test executed by is not matched in Test execution page.");
			logger.info("Test executed by is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedOnTimeInPlanTestCycle="//div[div[a[text()='"+values.get("CYCLE_NAME")+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+values.get("TEST_NAME")+"')]]/following-sibling::td[contains(@id,'executed-on')]";
			Assert.assertTrue(values.get("EXECUTED_TIME").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedOnTimeInPlanTestCycle)), "Test executed on time is not matched in Test execution page.");
			logger.info("Test executed on time is matched in the cycle after returning to the cycle.");*/
			
			Assert.assertTrue(navigateToTestViewIssuePage(values.get("TEST_NAME"))
									.validateTestStatusWithDefect(values), "Test Executed details is not Validated to View Issue Page.");
			logger.info("Test executed details is validated Successfully in View Issue Page.");
			
			/*Assert.assertTrue(ViewTestPage.getInstance().validateTestStatusWithDefect(values), "Added issue in test is not validated in view issue page.");
			logger.info("Test status and added defect is validated in View issue page.");
			*/
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	

	
	/**
	 * 
	 * This method is used to validate the cycle  by taking cycle name, description and start datefrom the map.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>CYCLE_DESC</b> This parameter contains the cycle description which is used for creating the cycle in zfj. <br/>
	 * <b>CYCLE_START_DATE</b>  This parameter contains the cycle start date which is used for creating the cycle in zfj.<br/>
	 * </p>
	 * @return It returns the boolean value True or False.
	 */
	public boolean validateCycle(Map<String, String> values){
		try{
			String xpathForCycleName="//ul[@id='project-panel-cycle-list-summary']/li/div/div/a[text()='"+values.get("CYCLE_NAME")+"']";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForCycleName), values.get("CYCLE_NAME"), "Cycle name is not matching in this version.");
			logger.info(values.get("CYCLE_NAME")+" is Validated successfully.");
			
			String xpathForTakingDescriptionFromCycle="//a[text()='"+values.get("CYCLE_NAME")+"']/following-sibling::span[contains(@class,'versionBanner-description')]";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingDescriptionFromCycle), values.get("CYCLE_DESC"), "Cycle description is not verified properly.");
			logger.info(values.get("CYCLE_NAME")+" description is verified successfully.");
			
			String xpathForCycleStartDate="//div[a[text()='"+values.get("CYCLE_NAME")+"']]/following-sibling::div/label/span[@class='date']";
			Assert.assertEquals(CommonUtil.dateConversion(values.get("CYCLE_START_DATE")), CommonUtil.getTextFromUIByXpath(xpathForCycleStartDate));
			logger.info(values.get("CYCLE_NAME")+" start date is verified successfully.");
						
		}catch(Exception e){
			//logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
			return false;

		}
		return true;
	}
	
	
	
	public boolean validateEditCycle(Map<String, String> values){
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForCycleName="//ul[@id='project-panel-cycle-list-summary']/li/div/div/a[text()='"+values.get("NEW_CYCLE_NAME")+"']";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForCycleName), values.get("NEW_CYCLE_NAME"), "Cycle name is not matching in this version.");
			logger.info(values.get("NEW_CYCLE_NAME")+" is verified successfully.");
			
			String xpathForTakingDescriptionFromCycle="//a[text()='"+values.get("NEW_CYCLE_NAME")+"']/following-sibling::span[contains(@class,'versionBanner-description')]";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingDescriptionFromCycle), values.get("CYCLE_DESC"), "Cycle description is not verified properly.");
			logger.info(values.get("NEW_CYCLE_NAME")+" description is verified successfully.");
			
			String xpathForTakingBuildFromCycle="//div[a[text()='"+values.get("NEW_CYCLE_NAME")+"']]/following-sibling::div/span/label[text()='Build: ']/following-sibling::label";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingBuildFromCycle), values.get("BUILD_NAME"), "Build name is not verified properly.");
			logger.info(values.get("NEW_CYCLE_NAME")+" build name is verified successfully.");
			
						
			String xpathForTakingEnvFromCycle="//div[a[text()='"+values.get("NEW_CYCLE_NAME")+"']]/following-sibling::div/span/label[text()='Environment: ']/following-sibling::span";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingEnvFromCycle), values.get("ENV_NAME"), "Enviroment is not verified properly.");
			logger.info(values.get("NEW_CYCLE_NAME")+" enviroment is verified successfully.");
			
						
			String xpathForCycleStartDate="//div[a[text()='"+values.get("NEW_CYCLE_NAME")+"']]/following-sibling::div/label/span[@class='date']";
			Assert.assertEquals(CommonUtil.dateConversion(values.get("CYCLE_START_DATE")), CommonUtil.getTextFromUIByXpath(xpathForCycleStartDate));
			logger.info(values.get("NEW_CYCLE_NAME")+" start date is verified successfully.");
			
			
		}catch(Exception e){
			//logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/*public boolean executeTestInViewIssuePageAndValidate(String versionName, String cycleName, String testName, String testExecStatus){
		try{
			Assert.assertTrue(navigateToTestCycle(cycleName), "Not navigated to cycle.");
			Assert.assertTrue(navigateToTestViewIssuePage(testName), "Not navigated to View issue page.");
			
			
			Map<String , String> returnValues=ViewTestPage.getInstance().executeTestDirectly(versionName, cycleName, testName, testExecStatus);
			logger.info("Executed successfully in view issue page.");
			
			Driver.driver.navigate().back();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForTestExecutionStatusInPlanTestCycle="//div[div[label[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td[1]/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			
			Assert.assertTrue(testExecStatus.equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInPlanTestCycle)), "Test status is not matched in Test execution page.");
			logger.info("Test execution status is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedByNameInPlanTestCycle="//div[div[label[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td/a[@class='user-hover']";
			Assert.assertTrue(returnValues.get("EXECUTED_BY").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedByNameInPlanTestCycle)), "Test executed by is not matched in Test execution page.");
			logger.info("Test executed by is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedOnTimeInPlanTestCycle="//div[div[label[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td[contains(@id,'executed-on')]";
			Assert.assertTrue(returnValues.get("EXECUTED_ON").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedOnTimeInPlanTestCycle)), "Test executed on time is not matched in Test execution page.");
			logger.info("Test executed on time is matched in the cycle after returning to the cycle.");
			
			logger.info("Test is validated successfully.");
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	
	/*public boolean verifyAddedTest(String versionName, String cycleName, String totalTests){
		try{
			if(checkCycleIsExpanded(cycleName)){
				logger.info("Cycle is expanded.");
			}else{
				logger.info("Cycle is not expanded.");
				Assert.assertTrue(selectVersion(versionName), "Version is not selected successfully.");
				Assert.assertTrue(navigateToTestCycle(cycleName), "Version is not selected successfully.");
				logger.info("Cycle is expanded.");
			}
			String xpathForTakingBuildFromCycle="//div[label[text()='"+values.get("NEW_CYCLE_NAME")+"']]/following-sibling::div/span/label[text()='Build: ']/following-sibling::label";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingBuildFromCycle), values.get("BUILD_NAME"), "Build name is not verified properly.");
			logger.info(values.get("NEW_CYCLE_NAME")+" build name is verified successfully.");
			
						
			String xpathForTakingEnvFromCycle="//div[label[text()='"+values.get("NEW_CYCLE_NAME")+"']]/following-sibling::div/span/label[text()='Environment: ']/following-sibling::span";
			Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingEnvFromCycle), values.get("ENV_NAME"), "Enviroment is not verified properly.");
			logger.info(values.get("NEW_CYCLE_NAME")+" enviroment is verified successfully.");
			
						
			String xpathForCycleStartDate="//div[label[text()='"+values.get("NEW_CYCLE_NAME")+"']]/following-sibling::div/label/span[@class='date']";
			Assert.assertEquals(CommonUtil.dateConversion(values.get("CYCLE_START_DATE")), CommonUtil.getTextFromUIByXpath(xpathForCycleStartDate));
			logger.info(values.get("NEW_CYCLE_NAME")+" start date is verified successfully.");
			
			
		}catch(Exception e){
			logger.error(CommonUtil.captureScreenshotInLog());
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	public boolean executeTestInViewIssuePageAndValidate(String versionName, String cycleName, String testName, String testExecStatus){
		try{
			Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
			Assert.assertNotNull(navigateToTestViewIssuePage(testName), "Not navigated to View issue page.");
			
			
			Map<String , String> returnValues=ViewTestPage.getInstance().executeTestDirectly(versionName, cycleName, testName, testExecStatus);
			logger.info("Executed successfully in view issue page.");
			
			CommonUtil.navigateBack();
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			
			Assert.assertTrue(getTestExecutedStatus(cycleName, testName).equals(testExecStatus), "Test Execution Status is not validated in Plan Test Cycle.");
			logger.info("Test Execution Status is validated successfully in Plan Test Cycle.");
			
			Assert.assertTrue(getTestExecutedUser(cycleName, testName).equals(returnValues.get("EXECUTED_BY")), "Test Executed User is not validated in Plan Test Cycle.");
			logger.info("Test Executed User is validated successfully in Plan Test Cycle.");
			
			Assert.assertTrue(getTestExecutedTime(cycleName, testName).equals(returnValues.get("EXECUTED_ON")), "Test Executed Time is not validated in Plan Test Cycle.");
			logger.info("Test Executed Time is validated successfully in Plan Test Cycle.");
			
			/*String xpathForTestExecutionStatusInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td[1]/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
			
			Assert.assertTrue(testExecStatus.equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutionStatusInPlanTestCycle)), "Test status is not matched in Test execution page.");
			logger.info("Test execution status is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedByNameInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td/a[@class='user-hover']";
			Assert.assertTrue(returnValues.get("EXECUTED_BY").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedByNameInPlanTestCycle)), "Test executed by is not matched in Test execution page.");
			logger.info("Test executed by is matched in the cycle after returning to the cycle.");
			
			String xpathForTestExecutedOnTimeInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[contains(text(),'"+testName+"')]]/following-sibling::td[contains(@id,'executed-on')]";
			Assert.assertTrue(returnValues.get("EXECUTED_ON").equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedOnTimeInPlanTestCycle)), "Test executed on time is not matched in Test execution page.");
			logger.info("Test executed on time is matched in the cycle after returning to the cycle.");
			
			logger.info("Test is validated successfully.");*/
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public ViewTestPage navigateToViewIssuePage(String cycleName, String testName){
		try{
			Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
			Assert.assertNotNull(navigateToTestViewIssuePage(testName), "Not navigated successfully to View issue page.");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ViewTestPage.getInstance();
	}
	
	public boolean verifyAddedTest(String versionName, String cycleName, String totalTests){
		try{
			/*if(checkCycleIsExpanded(cycleName)){
				logger.info("Cycle is expanded.");
			}else{
				logger.info("Cycle is not expanded.");
				Assert.assertTrue(selectVersion(versionName), "Version is not selected successfully.");
				Assert.assertTrue(navigateToTestCycle(cycleName), "Version is not selected successfully.");
				logger.info("Cycle is expanded.");
			}*/
			Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			if(CommonUtil.isElementPresent("//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/a[text()='Next']")){
				Assert.assertTrue(getTotalTestsInCycle().equals(totalTests), "Total tests are not matching.");
			}else{
				String xpathForTestsInCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div[@class='versionBanner-content']/table/tbody/tr/td["+returnHeaderNum("ID")+"]/a";
				List<WebElement> list=Driver.driver.findElements(By.xpath(xpathForTestsInCycle));
				String testsCount=Integer.toString(list.size());
				Assert.assertTrue(testsCount.equals(totalTests), "Total tests are not matching.");
				
			}
			logger.info("Added number of tests are matching in cycle.");
			
			closeCycle(cycleName);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean verifyAddedTest(String versionName, String cycleName, List<String> addedDefectToTest){
		List<String> allTests = new ArrayList<String>() ;
		try{
			String totalTestInCycle = Integer.toString(addedDefectToTest.size());
			Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			if(CommonUtil.isElementPresent("//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/a[text()='Next']")){
				Assert.assertTrue(getTotalTestsInCycle().equals(totalTestInCycle), "Total tests are not matching.");
				logger.info("Added number of tests are matching in cycle.");
				
			}else{
				String xpathForTestsInCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div[@class='versionBanner-content']/table/tbody/tr/td["+returnHeaderNum("ID")+"]/a";
				List<WebElement> list=Driver.driver.findElements(By.xpath(xpathForTestsInCycle));
				for (int i=0; i< list.size(); i++) {
					String addTest=list.get(i).getText();
					allTests.add(addTest);
				}
				String testsCount=Integer.toString(list.size());
				Assert.assertTrue(testsCount.equals(totalTestInCycle), "Total tests are not matching.");
				logger.info("Added number of tests are matching in cycle.");
				Assert.assertTrue(allTests.size() == addedDefectToTest.size() && allTests.containsAll(addedDefectToTest), "Added Test-Ids are not matching in the Cycle.");
			}
			logger.info("Added Tests are validated successfully in the Cycle.");
			
			closeCycle(cycleName);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public List<String> checkDefectsInCycle(String versionName, String sourseCycleName){
		
		List<String> defectId=new ArrayList<String>();
		try{
			Assert.assertTrue(selectVersion(versionName), "Version is not present.");
			Assert.assertTrue(expandCycle(sourseCycleName), "Cycle is not expanded successfully.");
			
			String xpathForTests="//div[div[a[text()='"+sourseCycleName+"']]]/following-sibling::div[@class='versionBanner-content']/table/tbody/tr/td[1]/a";
			List<WebElement> listForDefects=Driver.driver.findElements(By.xpath(xpathForTests));
			for(int i=0;i<listForDefects.size();i++){
				String testID=listForDefects.get(i).getText();
				String defect = getAddedDefectToTest(sourseCycleName, testID);
				if( defect != null){
					defectId.add(testID);
				}
				/*String xpathForGettingDefectID="//td[a[text()='"+testID+"']]/following-sibling::td[3]";
				if(CommonUtil.isElementPresent(xpathForGettingDefectID)){
					defectId.add(testID);
					//System.out.println("added Test is= "+testID);
				}*/
			}
			Assert.assertTrue(navigateToTestCycle(sourseCycleName), "Cycle is not present.");
			logger.info("All defect associate with tests are taken.");
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return defectId;
	}
	
	/******************************************************
	 * 	UTIL METHODS
	 *****************************************************/
	
	private String getTotalTestsInCycle(){
		String totalTests=null;
		try{
			String[] allValue=paginationValue.getText().split(" ");
			totalTests=allValue[3];
			
		}catch(Exception e){
			e.printStackTrace();
			return totalTests;
		}
		return totalTests;
	}
	
	private boolean checkCycleIsExpanded(String cycleName){
		boolean status=false;
		try{
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForCycle="//li[div[div[a[text()='"+cycleName+"']]]]";
			//Assert.assertTrue(CommonUtil.scrollPage(CommonUtil.returnWebElement(xpathForTheCycle))"Not Scrolled to the cycle.");
			
			//String xpathForCycle="//ul[@id='project-panel-cycle-list-summary']/li/div/div[label[text()='"+cycleName+"']]";	
			Assert.assertTrue(CommonUtil.scrollPage(CommonUtil.returnWebElement(xpathForCycle)),"Not Scrolled to the cycle.");
			
			//System.out.println(CommonUtil.getAttributeValue(xpathForCycle, "class")+" : "+"expando");
			if(CommonUtil.getAttributeValue(xpathForCycle, "class").equals("expando")){
				
			}else {
				status=true;
			}
		}catch(Exception e){
			//e.printStackTrace();
			return status;
		}
		return status;
	}
	private boolean expandCycle(String cycleName){
		try{
			//System.out.println(checkCycleIsExpanded(cycleName));
			if(checkCycleIsExpanded(cycleName)){
				//logger.info("Cycle is expanded.");
			}else{
				//logger.info("Cycle is not expanded.");
				Assert.assertTrue(navigateToTestCycle(cycleName), "Version is not selected successfully.");
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				//logger.info("Cycle is expanded.");
				//logger.info("Cycle is expanded or not : "+checkCycleIsExpanded(cycleName));
			}
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean closeCycle(String cycleName){
		try{
			if(checkCycleIsExpanded(cycleName)){
				//logger.info("Cycle is expanded.");
				Assert.assertTrue(navigateToTestCycle(cycleName), "Cycle is not selected successfully.");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				//logger.info("Cycle is closed.");
				logger.info("Cycle is closed or not : "+checkCycleIsExpanded(cycleName));
			}else{
				//logger.info("Cycle is not expanded.");
				
			}
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * This method is used to navigate to view issue page.
	 * @param testName This parameter is used to give the test name by which we can go to view issue page from plan test cycle page.
	 * @return The boolean value.
	 */
	private ViewTestPage navigateToTestViewIssuePage(String testName){
		try{
			String xpathForTest="//a[text()='"+testName+"']";
			CommonUtil.navigateThroughXpath(xpathForTest);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			logger.info("Navigated to view issue page.");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ViewTestPage.getInstance();
	}
	private boolean hoverOnTestAndNavigateToExecutionPageUsingE(String cycleName, String testName) throws Exception{
		try{
			//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
			logger.info(cycleName+" is expanded successfully.");
			
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			logger.info("Cycle is expanded successfully.");
			String xpathForTest="//a[text()='"+testName+"']";
			CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForTest)).build().perform();
			logger.info("Hovering to test properly.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			String xpathForExecution="//td[a[text()='"+testName+"']]/following-sibling::td/a[text()='E']";
			CommonUtil.navigateThroughXpath(xpathForExecution);
			CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
			//logger.info("Navigated to Execute Tests page.");
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean selectVersion(String versionName){
		try {
			String v=xpathForCurrentVersion.getAttribute("value");
			 if(versionName.equals(xpathForCurrentVersion.getAttribute("value"))){
				}else{
					/*CommonUtil.returnWebElement("//div[@id='select-version2-single-select']/span").click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);*/
					xpathForCurrentVersion.clear();
					xpathForCurrentVersion.sendKeys(versionName);
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					planTestCycleHeaderTextXpath.click();
					//CommonUtil.actionClass().sendKeys(Keys.RETURN);
					//CommonUtil.returnWebElement("//*[@id='unreleased-versions']/li/a");
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				}
			/*if(versionName.equals(xpathOfCurrentVersionName.getText())){
			}else{
				CommonUtil.selectListWithVisibleText(selectVersionInPlanTestCyclePage, versionName);
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
			}*/
			 logger.info( versionName + " is selected successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean hoverInTestCycle(String cycleName){
		try{
			String xpathForCycle="//ul[@id='project-panel-cycle-list-summary']/li/div/div[a[text()='"+cycleName+"']]";	
			CommonUtil.actionClass().moveToElement(CommonUtil.returnWebElement(xpathForCycle)).build().perform();
			logger.info("Hovering to test cycle properly.");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean navigateToTestCycle(String cycleName){
		try{
			String xpathForCycle="//ul[@id='project-panel-cycle-list-summary']/li/div/div[a[text()='"+cycleName+"']]";	
			Assert.assertTrue(CommonUtil.scrollPage(CommonUtil.returnWebElement(xpathForCycle)),"Not Scrolled to the cycle.");
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			CommonUtil.navigateThroughXpath(xpathForCycle);
			CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
			logger.info("Navigated to test cycle successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean navigateToManageLinkInCycle(String cycleName){
		try{
			String xpathForManageLinkOfCycle="//div[a[text()='"+cycleName+"']]/following-sibling::div/div/a";
			//CommonUtil.actionClass().doubleClick().build().perform();
			CommonUtil.navigateThroughXpath(xpathForManageLinkOfCycle);
			CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
			logger.info("Navigated to manage link in the cycle successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private boolean searchTestInCycle(String cycleName, String testName){
		try{
			String xpathForAllTestsFromCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[1]";
			Assert.assertTrue(CommonUtil.searchTheTextInList(xpathForAllTestsFromCycle, testName), testName+" is not present in the cycle.");
						
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
			public boolean validatePlanTestCyclePage(){
				try{
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
					boolean pageResult=(CommonUtil.isElementDisplayed(testCycleSidebar))&&(CommonUtil.isElementDisplayed(testCycleTabXpath));
					Assert.assertTrue(pageResult,"Launching Plan Test Cycle page Failed...");
					logger.info("Plan Test Cycle Page Confirmed...");
							
				}catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
			}
			
			public boolean validateExecuteTestCyclePage(){
				try{
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
					boolean pageResult=(CommonUtil.isElementDisplayed(testCycleSidebar))&&(CommonUtil.isElementDisplayed(testCycleTabXpath));
					Assert.assertTrue(pageResult,"launching Execute Test Cycle page Failed...");
						logger.info("Execute Test Cycle Confirmed...");		
				}catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public TestSummaryPage navigateToTestSummaryPage(){
				try{
					xpathForTestSummaryLink.click();
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				}catch(Exception e){
					e.printStackTrace();
					
				}
				return TestSummaryPage.getInstance();
			}
			
		  public boolean closeAllCycle(){
			  try{
				  if(CommonUtil.isElementPresent(planTestCycleHeaderTextXpath)){
					   for (int i=0; i<xpathForCycles.size() ; i++) {
						  CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
						  //System.out.println(xpathForCycles.get(i).getAttribute("class") +" : "+"expando" );
						  if(xpathForCycles.get(i).getAttribute("class").trim().equalsIgnoreCase("expando")){
							  
						  } else {
							  String xpathForCycleForClick="//ul[@id='project-panel-cycle-list-summary']/li["+(i+1)+"]/div/div[a[@class='versionBanner-name singleLine']]";
							  CommonUtil.navigateThroughXpath(xpathForCycleForClick);
							  //xpathForCycles.get(i).click();
							  CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
							  CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
							 
						  }
					   }
					   logger.info("Closed all cycles.");
				  }
				  
			  }catch(Exception e){
				  e.printStackTrace();
				  return false;
			  }
			  return true;
		  }
			
		  private boolean validateTestExecutedStatus(String cycleName, String testName, String testExecStatus){
			  try{
				  //String xpathForTestExecutionStatusInPlanTestCycle="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td[1]/div/div/div/dl/dd[contains(@id,'current-execution-status')]";
				  String xpathForCurrentExecStatus="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td/descendant::dd[contains(@id,'current-execution-status')]";
				  CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				  Assert.assertTrue(testExecStatus.equals(CommonUtil.getTextFromUIByXpath(xpathForCurrentExecStatus)), "Test status is not matched in Test execution page.");
				  logger.info("Test execution status is matched in Plan Test Cycle Page.");
			  }catch(Exception e){
				  e.printStackTrace();
				  return false;
			  }
			  return true;
		  }
		  private String getTestExecutedStatus(String cycleName, String testName){
			  String executedStatus = null;
			  try{
				  String xpathForTestExecutedUser = "//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td/descendant::dd[contains(@id,'current-execution-status')]";
				  executedStatus = CommonUtil.getTextFromUIByXpath(xpathForTestExecutedUser);
				 
			  }catch(Exception e){
				  e.printStackTrace();
				  return executedStatus;
			  }
			  return executedStatus;
		  }
		  private String getTestExecutedUser(String cycleName, String testName){
			  String executedUser = null;
			  try{
				  String xpathForTestExecutedUser = "//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr[td[a[text()='"+testName+"']]]/td["+returnHeaderNum("Executed By")+"]";
				  String user = CommonUtil.getTextFromUIByXpath(xpathForTestExecutedUser);
				  if (user.equals(" -")) {
					  executedUser = null;
				  } else if (user.equals("-")) {
					  executedUser = null;
				  } else {
					  executedUser = user;
				  }
				  
				  //Assert.assertTrue(testExecutedUser.equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedUser)), "Test executed by is not matched in Test execution page.");
				  //logger.info("Test executed by is matched in the cycle after returning to the cycle.");
			  }catch(Exception e){
				  e.printStackTrace();
				  return executedUser;
			  }
			  return executedUser;
		  }
		  private String getTestExecutedTime(String cycleName, String testName){
			  String executedTime = null;
			  try{
				  String xpathForTestExecutedUser = "//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr[td[a[text()='"+testName+"']]]/td["+returnHeaderNum("Executed On")+"]";
				  String user = CommonUtil.getTextFromUIByXpath(xpathForTestExecutedUser);
				  if (user.equals(" -")) {
					  executedTime = null;
				  } else if (user.equals("-")) {
					  executedTime = null;
				  } else {
					  executedTime = user;
				  }
				 
			  }catch(Exception e){
				  e.printStackTrace();
				  return executedTime;
			  }
			  return executedTime;
		  }
		  private String getAddedDefectToTest(String cycleName, String testName){
			  String defectID = null;
			  try{
				  String xpathForAddedDefectToTest = "//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr[td[a[text()='"+testName+"']]]/td["+returnHeaderNum("Defect")+"]";
				  String defectTest = CommonUtil.getTextFromUIByXpath(xpathForAddedDefectToTest);
				  if (defectTest.equals(" -")) {
					  defectID = null;
				  } else if (defectTest.equals("-")) {
					  defectID = null;
				  } else {
					  String xpathForAssociateDefect= "//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr[td[a[text()='"+testName+"']]]/td["+returnHeaderNum("Defect")+"]/descendant::a";
					  defectID = CommonUtil.getTextFromUIByXpath(xpathForAssociateDefect);
					 // defectID = defectTest;
				  }
				 
			  }catch(Exception e){
				  e.printStackTrace();
				  return defectID;
			  }
			  return defectID;
		  }
		  private boolean validateTestExecutedUser(String cycleName, String testName, String testExecutedUser){
			  try{
				  String xpathForTestExecutedUser="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td/a[@class='user-hover']";
				  Assert.assertTrue(testExecutedUser.equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedUser)), "Test executed by is not matched in Test execution page.");
				  //logger.info("Test executed by is matched in the cycle after returning to the cycle.");
			  }catch(Exception e){
				  e.printStackTrace();
				  return false;
			  }
			  return true;
		  }
		  private boolean validateTestExecutedTime(String cycleName, String testName, String testExecutedOn){
			  try{
				  String xpathForTestExecutedTime="//div[div[a[text()='"+cycleName+"']]]/following-sibling::div/table/tbody/tr/td[a[text()='"+testName+"']]/following-sibling::td[contains(@id,'executed-on')]";
				  Assert.assertTrue(testExecutedOn.equals(CommonUtil.getTextFromUIByXpath(xpathForTestExecutedTime)), "Test executed on time is not matched in Test execution page.");
					//logger.info("Test executed on time is matched in the cycle after returning to the cycle.");
			  }catch(Exception e){
				  e.printStackTrace();
				  return false;
			  }
			  return true;
		  }
		  private int returnHeaderNum(String headerName){
				int rowNum=0;
				try{
					for (int i=0 ; i < xpathForHeadersOfIssueTable.size() ; i++){
						if(xpathForHeadersOfIssueTable.get(i).getText().equals(headerName)){
							rowNum=i+1;
							break;
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				return rowNum;
		}
		 private boolean validatePage(){
			try{
				Assert.assertTrue(planTestCycleHeaderTextXpath.getText().equals("Test Cycles"), "Plan Test Cycle page is not verified successfully.");
				logger.info("Plan Test cycle page validated successfully.");
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		 }
		 public boolean searchVersion(String versionName){
			 boolean flag = false;
			 try{
				 Assert.assertTrue(validatePage(), "Plan Test Cycle Page is not Validated successfully.");
				 
				 if(versionName.equals(xpathForCurrentVersion.getAttribute("value"))){
					flag = true;
				 }else{
					 CommonUtil.returnWebElement(" //div[@id='select-version2-single-select']/span").click();
					 CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					 List<WebElement> list = CommonUtil.returnWebElementsFromXpath(".//*[@id='select-version2-suggestions']/descendant::ul[@id='unreleased-versions']/li/a");
					 flag = CommonUtil.searchTheTextInList(list, versionName);
					 Assert.assertTrue(flag, versionName + " is not found in the list.");
					 /*for(int i=0; i<list.size(); i++){
						 String s=list.get(i).getText();
						 System.out.println(s);
						 if(versionName.equals(s)){
							 flag= true;
							 //list.get(i).click();
							 break;
						 }
					 }*/
					 /*CommonUtil.returnWebElement("//div[@id='select-version2-single-select']/span").click();
						CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
						xpathForCurrentVersion.clear();
						xpathForCurrentVersion.sendKeys(versionName);
						CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
						planTestCycleHeaderTextXpath.click();
						//CommonUtil.actionClass().sendKeys(Keys.RETURN);
						//CommonUtil.returnWebElement("//*[@id='unreleased-versions']/li/a");
						CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);*/
					}
				/*if(versionName.equals(xpathOfCurrentVersionName.getText())){
				}else{
					CommonUtil.selectListWithVisibleText(selectVersionInPlanTestCyclePage, versionName);
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				}*/
				 logger.info( versionName + " is Searched successfully.");
				 
			 }catch(Exception e){
				 //logger.error( versionName + " is not Found successfully.");
				 return flag;
			 }
			 return flag;
		 }
		  
		 public List<String> getCycleInfo(String cycleName){
				List<String> cycleInfo = new ArrayList<String>();
				try{
					String xpathForCycleName="//ul[@id='project-panel-cycle-list-summary']/li/div/div/a[contains(@class,'versionBanner-name')]";
					Assert.assertTrue(CommonUtil.searchTheTextInList(xpathForCycleName, cycleName), "Cycle name is not finding in plan test cycle.");
					logger.info(cycleName+" is Validated successfully.");
					
					String xpathForTakingDescriptionFromCycle="//a[text()='"+cycleName+"']/following-sibling::span[contains(@class,'versionBanner-description')]";
					String cycleDesc = CommonUtil.getTextFromUIByXpath(xpathForTakingDescriptionFromCycle);
					Assert.assertNotNull(cycleDesc, "Cycle Description is returning null");
					logger.info(cycleName+" Description is : " + cycleDesc);
					cycleInfo.add(cycleDesc);
					String xpathForCycleStartDate="//div[a[text()='"+cycleName+"']]/following-sibling::div/label/span[@class='date']";
					String cycleStartDate = CommonUtil.getTextFromUIByXpath(xpathForCycleStartDate);
					Assert.assertNotNull(cycleStartDate, "Cycle Start date is returning null");
					logger.info(cycleName+" start date is : " + cycleStartDate);
					cycleInfo.add(cycleStartDate);
					
				}catch(Exception e){
					return cycleInfo;
				}
				return cycleInfo;
		}
		 public List<String> getTestInfoFromCycle(String projectName, String versionName, String cycleName){
			 List<String> list =  new ArrayList<String>();
			 Map<String, List<String>> values= new HashMap<String, List<String>>();
			 try{
				 String projName= CommonUtil.getTextFromUIByXpath(".//*[@id='content']/descendant::*[@class='aui-page-header-main project-details']/h1");
				 Assert.assertTrue(projectName.equals(projName), "Project name is not same.");
				 Assert.assertTrue(selectVersion(versionName), "Version is not selected.");
				 CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				 Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
				 CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				 //String totalTestInCycle = getTotalTestsInCycle();
				 String xpathForAllTestsFromCycle="//li[div[div[a[text()='"+cycleName+"']]]]/div/table[@id='issuetable']/tbody/tr/td["+returnHeaderNum("ID")+"]";
				List<String> allTestID = CommonUtil.getValues(xpathForAllTestsFromCycle);
				list =  CommonUtil.getValues(xpathForAllTestsFromCycle);
				 // Assert.assertTrue(CommonUtil.searchTheTextInList(xpathForAllTestsFromCycle, testName), testName+" is not present in the cycle.");
				 
				 //values.put("TOTAL_TESTS", totalTestInCycle);
				return list;
			 }catch(Exception e){
				 return list;
			 }
		 }
		 public boolean validateCycle(String cycleName, List<String> cycleInfo){
				try{
					String xpathForCycleName="//ul[@id='project-panel-cycle-list-summary']/li/div/div/a[contains(@class,'versionBanner-name')]";
					Assert.assertTrue(CommonUtil.searchTheTextInList(xpathForCycleName, cycleName), "Cycle name is not finding in plan test cycle.");
					//String xpathForCycleName="//ul[@id='project-panel-cycle-list-summary']/li/div/div/a[text()='"+values.get("CYCLE_NAME")+"']";
					//Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForCycleName), values.get("CYCLE_NAME"), "Cycle name is not matching in this version.");
					logger.info(cycleName+" is Validated successfully.");
					
					String xpathForTakingDescriptionFromCycle="//a[text()='"+cycleName+"']/following-sibling::span[contains(@class,'versionBanner-description')]";
					Assert.assertEquals(CommonUtil.getTextFromUIByXpath(xpathForTakingDescriptionFromCycle),cycleInfo.get(0), "Cycle description is not verified properly.");
					logger.info(cycleName+" description is verified successfully.");
					
					String xpathForCycleStartDate="//div[a[text()='"+cycleName+"']]/following-sibling::div/label/span[@class='date']";
					Assert.assertEquals(CommonUtil.dateConversion(cycleInfo.get(1)), CommonUtil.getTextFromUIByXpath(xpathForCycleStartDate), "Cycle Start Date is not matching.");
					logger.info(cycleName+" start date is verified successfully.");
								
				}catch(Exception e){
					return false;
				}
				return true;
			}
		 public boolean validateTestInfoInCycle(String cycleName, List<String> testInfoInCycle){
			 try{
				 Assert.assertTrue(validatePage(), "Plan Test Cycle is validated successfully."); 
				 Assert.assertTrue(expandCycle(cycleName), "Cycle is not expanded successfully.");
				 CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				 
				 String xpathForAllTestsFromCycle="//li[div[div[a[text()='"+cycleName+"']]]]/div/table[@id='issuetable']/tbody/tr/td["+returnHeaderNum("ID")+"]";
				List<String> allTestID = CommonUtil.getValues(xpathForAllTestsFromCycle);
				Assert.assertTrue(allTestID.size() == testInfoInCycle.size(), "Size of test information after cloning is not same.");
				logger.info("Total tests size is same in new cycle.");
				Assert.assertTrue(testInfoInCycle.containsAll(allTestID), "All tests are not same after cloning.");
				logger.info("Total tests are same in new cycle.");
				return true;
			 }catch(Exception e){
				 return false;
			 }
		 }
}
