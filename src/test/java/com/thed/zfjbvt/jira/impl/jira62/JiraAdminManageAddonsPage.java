package com.thed.zfjbvt.jira.impl.jira62;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.thed.zfjbvt.Config;
import com.thed.zfjbvt.Constants;
import com.thed.zfjbvt.util.CommonUtil;
import com.thed.zfjbvt.util.Driver;

/**
 * This is JIRA's Manage Addons page, where admin can manage all user installed addons.
 * @author Manoj
 *
 */
public class JiraAdminManageAddonsPage {
	private Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * This method will initialize all the webelements inside the Jira Administrative Manage Addons Page and returns the page instance.
	 * @return This returns the Jira Administrative Manage Addons page instance.
	 */
	public static JiraAdminManageAddonsPage getInstance() {
		JiraAdminManageAddonsPage page = PageFactory.initElements(Driver.driver, JiraAdminManageAddonsPage.class);
		return page;
	}
	private JiraLandingPage jiraLandingPage=JiraLandingPage.getInstance();
	
	//private CommonUtil commonUtil=new CommonUtil();
	//private JiraAdministrationPage jiraAdministrationPage=PageFactory.initElements(Driver.driver, JiraAdministrationPage.class);
	//private JiraLandingPage jiraLandingPage=PageFactory.initElements(Driver.driver, JiraLandingPage.class);
	/******************************************************
	 * 	WEBELEMENTS
	 *****************************************************/
		// Find Manage Add-ons page header text.
		@FindBy(xpath="//div[@id='upm-container']/descendant::span[@id='upm-title']")
		private WebElement findNewAddonsPageheadertext;
	
		//File upload link present in manage addons page where you can upload a plugin manually.
		@FindBy(id="upm-upload")
		private WebElement fileUploadLink;
		
		// Find New Add-ons page header text.
		@FindBy(xpath="//div[@id='upm-container']/h2/span[@id='upm-title']")
		private WebElement manageAddonsPageheadertext;
		
		// File upload link i.e. if You will click on it, it will show the file upload pop up. 
		@FindBy(xpath="//*[@id='upm-upload-dialog']/div/div[2]/button[text()='Upload']")
		private WebElement fileUploadButton;
		
		// Browse button from where we can take the file.
		@FindBy(name="plugin")
		private WebElement fileUploadBrowseBtn;
		
		// File upload button in file upload popup.
		@FindBy(xpath="//*[@id='upm-upload-dialog']/div/div[2]/button[text()='Upload']")
		private WebElement uploadButtonInFileUploadPopup;
		
		@FindBy(xpath="//*[@id='upm-plugin-status-dialog']/div/div[2]/button[text()='Close']")
		private WebElement closeLinkAfterUploading;
		
		@FindBy(xpath="//*[@class='upm-plugin-installed-version-label']/following-sibling::dd[@class='upm-plugin-installed-version']")
		private WebElement xpathForInstalledVersionInSystem;
		
		@FindBy(xpath="//button[text()='Manage License']")
		private WebElement manageLicenceBtn;
		
		@FindBy(xpath="//label[contains(text(),'License key:')]/following-sibling::textarea")
		private WebElement xpathForLicenceTextArea;
		
		@FindBy(xpath="//form[*[text()='License key:']]/input[@name='submit']")
		private WebElement updateLicenceBtn;
		
		@FindBy(xpath="//div[@class='upm-license-details']/dl/div/dt[text()='License status:']/following-sibling::dd")
		private WebElement licenseStatus;
		
		// After installing plugin, this is the close link to close the plugin.
		@FindBy(xpath="//div[@id='upm-plugin-status-dialog']/descendant::a[text()='Close']")
		private WebElement pluginCloseLink;
		
		// Edit link of license key in manage addons page, By this we can edit the license and can give a new license.
		@FindBy(xpath="//div[@class='upm-plugin-license-container']/descendant::dt[text()='License key:']/following-sibling::dd/a[@title='Edit']")
		private WebElement licenseKeyEditLink;
		
		@FindBy(xpath="//div[@class='upm-column upm-main-column']/descendant::a[text()='Cancel']")
		private WebElement LicenseKeyCancelBtn;
		
		@FindBy(xpath="//div[@class='upm-plugin-license-container']/descendant::dt[text()='License details:']/following-sibling::dd[@class='upm-plugin-license-info']")
		private WebElement xpathForLicenseDetails;
		
		
		/******************************************************
		 * 	PAGE OBJECT METHODS
		 *****************************************************/
		/**
		 * Returns a boolean value to verify the method is executed successfully or not.
		 * This method is used to upload the add-ons from manage add-ons page and install zfj plugin and it will take the path of zfj plugin address and zfj license file from config.properties file.
		 * After installing it will verify here all links under the test is present or not.
		 *  @return The boolean value i.e. True or False.
		 */	
		public boolean uploadAddons(){
			try{
				Assert.assertTrue( CommonUtil.titleContains( "Manage add-ons", Constants.EXPLICIT_WAIT_LOW ) );
				logger.info( "Navigated Successfully in Manage add-ons page." );
				
				//String zfjLicense="AAABFw0ODAoPeNptj01rwkAYhO/7KxZ63pANWquwB008CMYEqx68rfE12TZ5N+xH2vTX1w8CUgpzmuFhZl52laep7CmfXDULR7Mxp3myo1HII1LoJnAVnIMfaKveBB8QyMKpDoQzHkgCtjCqdUqjyGtfKqS1KgAt0Is29HiHqAPrFJZk45sTmOyyt2CsGIckNiBvbCIdiFsfC8eMv5FlJ2t/T8RF1hZIKhU6QIkFLL9bZfqBGLGQX/XfzqFtIZuT1ltotIN5CeisYJxkppSo7KPksZO8g+nArBKxOCYRe51OODscpiuWztOYrB+/rukeP1F/4eA8DfJYq0Y5OA/Zrm9hIxsQcZamy228mq9J7k1RSQt/T/8CwdKEizAsAhQxRf+zqBSj5VJKlMu07GjjEzONDgIUSjDVr/LF4OfSL2Bu/GC0WNhZhxM=X02e6";
				String xpathForWaitingForPluginInstalled="//*[contains(text(),'Installed and Ready to Go!')]";
				String xpathForGettingInstalledVersion="//div[@class='plugin-name-version']";
				
				Assert.assertTrue((findNewAddonsPageheadertext.getText()).equals("Manage add-ons"), "This is not Manage Plugins Page.");
				logger.info("Manage Plugins page is verified.");
				
				fileUploadLink.click();
				CommonUtil.visibilityOfElementLocated("//div[@id='upm-upload-dialog']");
				//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				//String uploadFile="E:\\Installation\\"+uploadFileName+".obr";
				//fileUploadBrowseBtn.sendKeys("E:\\Installation\\je-1.7.3.1043.obr");
				fileUploadBrowseBtn.sendKeys(Config.getValue("UPLOAD_FILE_PATH"));
				//fileUploadBrowseBtn.sendKeys(uploadFile);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				uploadButtonInFileUploadPopup.click();
				CommonUtil.visibilityOfElementLocated("//div[@id='upm-progress']");
				CommonUtil.visibilityOfElementLocated("//*[@id='upm-plugin-status-dialog']/descendant::h2[text()='Installed and ready to go!']");
				logger.info("Installed version is : "+CommonUtil.getTextFromUIByXpath(xpathForGettingInstalledVersion));
				Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForGettingInstalledVersion).contains(Config.getValue("ZFJ_VERSION")), " Installed Plug-in version is not same , Change the plugin.");
				logger.info("zfj plugin installed successfully.");
				if(CommonUtil.isElementPresent("//button[text()='Manage License']")){
					manageLicenceBtn.click();
					CommonUtil.visibilityOfElementLocated("//label[contains(text(),'License key:')]/following-sibling::input[@value='Update']");
					xpathForLicenceTextArea.clear();
					xpathForLicenceTextArea.sendKeys(Config.getValue("ZFJ_LICENSE"));
					updateLicenceBtn.click();
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				}else {
					pluginCloseLink.click();
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
					if(CommonUtil.getTextFromUIByXpath("//div[@class='upm-plugin-license-container']/descendant::dt[text()='License details:']/following-sibling::dd[@class='upm-plugin-license-info']").equals("Unlicensed")){
						CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
						xpathForLicenceTextArea.clear();
						xpathForLicenceTextArea.sendKeys(Config.getValue("ZFJ_LICENSE"));
						CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
						updateLicenceBtn.click();
						logger.info("New Licence is installed successfully.");	
					} else {
						
						/*if(CommonUtil.isElementPresent("//label[contains(text(),'License key:')]/following-sibling::input[@value='Update']")) {
							
							xpathForLicenceTextArea.clear();
							xpathForLicenceTextArea.sendKeys(Config.getValue("ZFJ_LICENSE"));
							CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
							updateLicenceBtn.click();
							logger.info("New Licence is installed successfully.");
						} else {*/
							licenseKeyEditLink.click();
							CommonUtil.visibilityOfElementLocated("//label[contains(text(),'License key:')]/following-sibling::input[@value='Update']");
							xpathForLicenceTextArea.clear();
							xpathForLicenceTextArea.sendKeys(Config.getValue("ZFJ_LICENSE"));
							CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
							/*String x=CommonUtil.getAttributeValueUsingWebElements(updateLicenceBtn, "disabled");
							System.out.println("disabled".equals(CommonUtil.getAttributeValueUsingWebElements(updateLicenceBtn, "disabled")));
							String returnValues=CommonUtil.getAttributeValueUsingWebElements(updateLicenceBtn, "disabled");*/
							if ("disabled".equals(CommonUtil.getAttributeValueUsingWebElements(updateLicenceBtn, "disabled"))) {
								updateLicenceBtn.click();
								logger.info("New Licence is installed successfully.");				
							} else {
								LicenseKeyCancelBtn.click();
								logger.info("This license is same, which is previously given.");
							}
							//CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					}
					/*licenseKeyEditLink.click();
					CommonUtil.visibilityOfElementLocated("//label[contains(text(),'License key:')]/following-sibling::input[@value='Update']");
					xpathForLicenceTextArea.clear();
					xpathForLicenceTextArea.sendKeys(Config.getValue("ZFJ_LICENSE"));
					CommonUtil.javaWait(Constants.JAVA_WAIT_HIGH);
					//String 
					System.out.println(CommonUtil.getAttributeValueUsingWebElements(updateLicenceBtn, "disabled").equals("disabled"));
					if (CommonUtil.getAttributeValueUsingWebElements(updateLicenceBtn, "disabled").equals("true")) {
						LicenseKeyCancelBtn.click();
						logger.info("This license is same, which is previously given.");				
					} else {
						updateLicenceBtn.click();
						logger.info("New Licence is installed successfully.");
					}*/
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				}
				
				//manageLicenceBtn.click();
				
				
				
				//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				//System.out.println("Is Displayed : "+CommonUtil.isElementDisplayed(updateLicenceBtn));
				//System.out.println("Is enabled : "+CommonUtil.isElementEnabled(updateLicenceBtn));
				//String s=CommonUtil.getAttributeValueUsingWebElements(updateLicenceBtn, "disabled");
				//System.out.println(CommonUtil.getAttributeValueUsingWebElements(updateLicenceBtn, "disabled").equals("disabled"));
				//System.out.println(CommonUtil.getAttributeValueUsingWebElements(updateLicenceBtn, "disabled").equals("true"));
				
				
				//CommonUtil.invisibilityOfElementLocated("//label[contains(text(),'License key:')]/following-sibling::input[@value='Update']");
				//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
				logger.info(" zfj license is updated successfully.");
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				Assert.assertTrue(licenseStatus.getText().equals("Valid"), "Licence is not valid.");
				logger.info("zfj license is valid.");			
				//loseLinkAfterUploading.click();
				//Config.logger.info("Installed zfj version is same.");
				//CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				Assert.assertTrue(xpathForInstalledVersionInSystem.getText().contains(Config.getValue("ZFJ_VERSION")), "Installed zfj-plugin version is not same.");
				logger.info("Verified the installed zfj version.");
				//CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				//Assert.assertNotNull(JiraAdministrationPage.getInstance().leavingAdministrationPage(), "Not leaving from jira administrator.");
				//logger.info("Leaving successfully from jira administrator link.");
				
				//Assert.assertTrue(JiraLandingPage.getInstance().validateTestsDropdownMenu(),"Not validating properly the tests drop down menu.");
				//logger.info("Validated the tests drop down menu.");
				/*jiraLandingPage.getTestsDropDownLink().click();
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				Assert.assertTrue(jiraLandingPage.getCreateTestLink().getText().equals("Create a Test"), "Create a test link is not present in testdropdown link.");
				logger.info("Create a test link present inside test drop down menu.");
				
				Assert.assertTrue(jiraLandingPage.getSearchTestsLink().getText().equals("Search Tests"), "Search Tests link is not present in testdropdown link.");
				logger.info("Search Tests link present inside test drop down menu.");
				
				Assert.assertTrue(jiraLandingPage.getPlanTestCycleLink().getText().equals("Plan Test Cycle"), "Plan Test Cycle link is not present in testdropdown link.");
				logger.info("Plan Test Cycle link present inside test drop down menu.");
				
				Assert.assertTrue(jiraLandingPage.getExecuteTestsLink().getText().equals("Execute Tests"), "Execute Tests link is not present in testdropdown link.");
				logger.info("Execute Tests link present inside test drop down menu.");
				
				Assert.assertTrue(jiraLandingPage.getTestMetricsLink().getText().equals("Test Metrics"), "Test Metrics link is not present in testdropdown link.");
				logger.info("Test Metrics link present inside test drop down menu.");
				
				Assert.assertTrue(jiraLandingPage.getWelcomeLink().getText().equals("Welcome"), "Welcome link is not present in testdropdown link.");
				logger.info("Welcome link present inside test drop down menu.");
				
				Assert.assertTrue(jiraLandingPage.getZephyrHelpLink().getText().equals("Zephyr Help"), "Zephyr Help link is not present in testdropdown link.");
				logger.info("Zephyr Help link present inside test drop down menu.");
				
				Assert.assertTrue(jiraLandingPage.getAboutZephyrLink().getText().equals("About Zephyr"), "About Zephyr link is not present in testdropdown link.");
				logger.info("About Zephyr link present inside test drop down menu.");
				//Constants.flag=true;
*/				
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		public boolean uninstallPlugin(){
			try{
				Assert.assertTrue(validatePage(), "Manage Add-ons Page is not Validated Successfully.");
				String xpathForPluginNames = ".//*[@id='upm-manage-user-installed']/div[@id='upm-manage-user-installed-plugins']/descendant::div[@class='upm-plugin user-installed']";
				String xpathForZFJPlugIn = "//div[@class='upm-plugin user-installed' and @data-plugin-name='Zephyr for JIRA']/descendant::*[@class='upm-plugin-name']";
				if(CommonUtil.visibilityOfElementLocated(xpathForPluginNames)){
					if(CommonUtil.isElementPresent(xpathForZFJPlugIn)){
						CommonUtil.navigateThroughXpath("//div[@class='upm-plugin user-installed' and @data-plugin-name='Zephyr for JIRA']/descendant::*[@class='expander']");
						boolean b=CommonUtil.isElementDisplayed(CommonUtil.changeToWebElement("//a[@title='Uninstall']"));
						Assert.assertTrue(CommonUtil.isElementEnabled(CommonUtil.changeToWebElement("//a[@title='Uninstall']")), "Unistall button is not enabled.");
						CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
						CommonUtil.navigateThroughXpath("//a[@title='Uninstall']");
						logger.info("Clicked for uninstallation button.");
						Assert.assertTrue(CommonUtil.isElementPresent(".//*[@id='upm-confirm-dialog']/descendant::h2"),"Un-install popup is not showing while proceeding.");
						logger.info("Navigated to plugin uninstallation popup.");
						CommonUtil.navigateThroughXpath(".//*[@id='upm-confirm-dialog']/descendant::button[text()='Continue']");
						CommonUtil.visibilityOfElementLocated("//*[@id='upm-progress-popup']/descendant::h2[text()='Uninstalling']");
						logger.info("Unisalling is on progress.");
						CommonUtil.invisibilityOfElementLocated("//*[@id='upm-progress-popup']/descendant::h2[text()='Uninstalling']");
						logger.info("Unisalling progress bar completed.");
						CommonUtil.visibilityOfElementLocated("//*[@id='upm-feedback-dialog']/descendant::h2[text()='Feedback']");
						logger.info("Navigated to feedback page.");
						CommonUtil.navigateThroughXpath(".//*[@id='upm-feedback-dialog']/descendant::a[@class='button-panel-link button-panel-cancel-link']");
						CommonUtil.invisibilityOfElementLocated(".//*[@id='upm-feedback-dialog']/descendant::a[@class='button-panel-link button-panel-cancel-link']");
						logger.info("Feedback popup is now closed.");
						
						
					}else{
						logger.info("Zephyr for Jira plugin not found in user installed plugin list.");
					}
					//String  = CommonUtil.getAttributeValueUsingWebElements(element, attributeName)Value(xpathForPluginNames, "data-plugin-name");
					
				}else{
					logger.info("Not loading user installed plugin list.");
				}
			}catch(Exception e){
				return false;
			}
			return true;
		}
		private boolean validatePage(){
			try{
				Assert.assertTrue( CommonUtil.titleContains( "Manage add-ons", Constants.EXPLICIT_WAIT_LOW ) , "Manage plug-in page title is not validated successfully.");
				logger.info( "Manage add-ons Page Title Validated Successfully." );
				
				Assert.assertTrue((findNewAddonsPageheadertext.getText()).equals("Manage add-ons"), "Manage Plugins Page Header is not Validated Successfully.");
				logger.info("Manage Plugins Page Header is Validated Successfully.");
				
				logger.info( "Manage add-ons Page Validated Successfully.");
			}catch(Exception e){
				return false;
			}
			return true;
		}
}
