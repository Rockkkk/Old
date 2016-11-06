package com.thed.zfjbvt.jira.impl.jira52;

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
		// Find New Add-ons page header text.
		@FindBy(xpath="//div[@id='upm-container']/h2/span[@id='upm-title']")
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
		@FindBy(id="upm-upload-file")
		private WebElement fileUploadBrowseBtn;
		
		// File upload button in file upload popup.
		@FindBy(xpath="//*[@id='upm-upload-dialog']/div/div[2]/button[text()='Upload']")
		private WebElement uploadButtonInFileUploadPopup;
		
		@FindBy(xpath="//*[@id='upm-plugin-status-dialog']/div/div[2]/button[text()='Close']")
		private WebElement closeLinkAfterUploading;
		
		@FindBy(xpath="//*[@class='upm-plugin-installed-version-label']/following-sibling::dd[@class='upm-plugin-installed-version']")
		private WebElement xpathForInstalledVersionInSystem;
		
		@FindBy(xpath="//button[contains(text(),'Manage License')]")
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
				//String zfjLicense="AAABFw0ODAoPeNptj01rwkAYhO/7KxZ63pANWquwB008CMYEqx68rfE12TZ5N+xH2vTX1w8CUgpzmuFhZl52laep7CmfXDULR7Mxp3myo1HII1LoJnAVnIMfaKveBB8QyMKpDoQzHkgCtjCqdUqjyGtfKqS1KgAt0Is29HiHqAPrFJZk45sTmOyyt2CsGIckNiBvbCIdiFsfC8eMv5FlJ2t/T8RF1hZIKhU6QIkFLL9bZfqBGLGQX/XfzqFtIZuT1ltotIN5CeisYJxkppSo7KPksZO8g+nArBKxOCYRe51OODscpiuWztOYrB+/rukeP1F/4eA8DfJYq0Y5OA/Zrm9hIxsQcZamy228mq9J7k1RSQt/T/8CwdKEizAsAhQxRf+zqBSj5VJKlMu07GjjEzONDgIUSjDVr/LF4OfSL2Bu/GC0WNhZhxM=X02e6";
				String xpathForWaitingForPluginInstalled="//*[contains(text(),'Installed and Ready to Go!')]";
				String xpathForGettingInstalledVersion="//div[@class='plugin-name-version']";
				
				Assert.assertTrue((findNewAddonsPageheadertext.getText()).equals("Manage Plugins"), "This is not Manage Plugins Page.");
				logger.info("Manage Plugins page is verified.");
				
				fileUploadLink.click();
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				//String uploadFile="E:\\Installation\\"+uploadFileName+".obr";
				//fileUploadBrowseBtn.sendKeys("E:\\Installation\\je-1.7.3.1043.obr");
				fileUploadBrowseBtn.sendKeys(Config.getValue("UPLOAD_FILE_PATH"));
				//fileUploadBrowseBtn.sendKeys(uploadFile);
				CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				uploadButtonInFileUploadPopup.click();
				CommonUtil.visibilityOfElementLocated(xpathForWaitingForPluginInstalled);
				Assert.assertTrue(CommonUtil.getTextFromUIByXpath(xpathForGettingInstalledVersion).contains(Config.getValue("ZFJ_VERSION")), " Plug-in version is not same.");
				logger.info("Installed zfj version is same.");
				
				if(CommonUtil.isElementPresent("//button[text()='Manage License']")){
					manageLicenceBtn.click();
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
					xpathForLicenceTextArea.sendKeys(Config.getValue("ZFJ_LICENSE"));
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
					updateLicenceBtn.click();
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_HIGH);
					logger.info(" zfj license is updated successfully.");
					CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
					Assert.assertTrue(licenseStatus.getText().equals("Valid"), "Licence is not valid.");
					logger.info(" zfj license is valid.");	
				} else {
					pluginCloseLink.click();
					CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_LOW);
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
					CommonUtil.javaWait(Constants.JAVA_WAIT_LOW);
				}
						
				//loseLinkAfterUploading.click();
				//Config.logger.info("Installed zfj version is same.");
				CommonUtil.implicitWait(Constants.IMPLICIT_WAIT_MEDIUM);
				Assert.assertTrue(xpathForInstalledVersionInSystem.getText().contains(Config.getValue("ZFJ_VERSION")), "Installed zfj-plugin version is not same.");
				logger.info("Verified the installed zfj version.");
				CommonUtil.javaWait(Constants.JAVA_WAIT_MEDIUM);
				Assert.assertNotNull(JiraAdministrationPage.getInstance().leavingAdministrationPage(), "Not leaving from jira administrator.");
				logger.info("Leaving successfully from jira administrator link.");
				
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
}
