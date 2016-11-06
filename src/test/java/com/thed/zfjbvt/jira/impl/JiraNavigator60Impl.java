package com.thed.zfjbvt.jira.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.Assert;
import com.thed.zfjbvt.jira.JiraNavigator;
import com.thed.zfjbvt.jira.impl.jira60.CreateIssuePage;
import com.thed.zfjbvt.jira.impl.jira60.JiraLandingPage;
import com.thed.zfjbvt.jira.impl.jira60.LoginPage;


public class JiraNavigator60Impl implements JiraNavigator {
	private Logger logger = Logger.getLogger(this.getClass());
	private JiraLandingPage jiraLandingPage=JiraLandingPage.getInstance();
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean doLogout(){
		return jiraLandingPage.logout();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean doLogin(String username, String password) {
		return LoginPage.getInstance().login(username, password);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean searchForNewPlugIn(Map<String, String> values){
		try{
			
			Assert.assertTrue(jiraLandingPage.navigateToAddonsPage(values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD"))
					.navigateToFindNewAddonsPage()
					.findNewAddons(values.get("FIND_NEW_PLUGIN_NAME")), "New Plug-in is not found Successfully." );
			logger.info("New plug-in found successfully.");
								/*.navigateToFindNewPlugInPage()
								.authenticateAdminPassword(values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD")));
			
			Assert.assertTrue(JiraAdminFindNewAddonsPage.getInstance().findNewAddons(values.get("FIND_NEW_PLUGIN_NAME"))," New Plug-in is not found Successfully.");*/
			
			//JiraAdministrationPage.getInstance().leavingAdministrationPage();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean installZFJPlugIn(Map<String, String> values){
		try{
			Assert.assertTrue(jiraLandingPage.navigateToAddonsPage(values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD"))
					.navigateToManageAddonsPage()
					.uploadAddons(), "Plug in is not installed successfully.");
			logger.info("Plug-in is installed successfully.");
			
			
			/*//Changed by Karthik (i.e since login is done once , admin authentication will not done)...
				jiraLandingPage.navigateToAdministrationPage().navigateToManageAddonsPage();
				if(CommonUtil.getTitle().contains("Administrator Access")){
					JiraAdministrationAuthenticatePage.getInstance().authenticateAdminPassword(values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD"));
				}
				Assert.assertTrue(JiraAdminManageAddonsPage.getInstance().uploadAddons(), "Addons is not loaded properly.");
				logger.info("zfj add-ons is installed successfully.");
			//changed till here...
			
			//JiraAdministrationPage.getInstance().leavingAdministrationPage();
*/
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean selectProject(String projectName){
		return jiraLandingPage.selectProject(projectName);
	}
	
	
	public boolean checkAndCloseNewFeatureDialog(){
		return jiraLandingPage.checkAndCloseNewFeatureDialog();
	}
	@Override
	public String getZephyrTestLink() {
		return jiraLandingPage.getZephyrTestLink();
	}
	public boolean navigateToAdminPage(String username, String password){
		try{
			Assert.assertTrue( jiraLandingPage.navigateToAdministrationPage(username, password), "Not Navigated Successfully to Administration Page." );
			logger.info("Navigated Successfully to Administration Page.");
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean navigateToAdminCustomizeTestStatusPage(String username, String password){
		try{
			Assert.assertTrue( jiraLandingPage.navigateToAddonsPage(username, password)
					.navigateToCustomizeTestStatusTab(), "Not Navigated Successfully to Customize Test Status Page." );
			logger.info("Navigated Successfully to Administration Page.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean navigateToAdminCustomizeStepStatusPage(String username, String password){
		try{
			Assert.assertTrue( jiraLandingPage.navigateToAddonsPage(username, password)
					.navigateToCustomizeStepStatusTab(), "Not Navigated Successfully to Customize Step Status Page." );
			logger.info("Navigated Successfully to Administration Page.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean leavingAdministrationPage() {
		return true;
	}
	public boolean createIssue(String issueSummary){
		try{
			CreateIssuePage.getInstance().createIssue(issueSummary);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean setFieldVisibilityInCreateIssueDialog(String firstField, String secondField){
		try{
			Assert.assertTrue(jiraLandingPage.navigateToCreateIssuePage().configureField(firstField, secondField));
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean navigateToZfjGeneralConfigurationPage(String username, String password) {
		try{
			Assert.assertTrue(jiraLandingPage.navigateToAddonsPage(username, password).navigateToGeneralConfigarationPage());
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public String createIssue(String issueSummary, String issueType) {
		String issueId = null;
		try{
			issueId = jiraLandingPage.navigateToCreateIssuePage().createIssue(issueSummary, issueType);
			Assert.assertNotNull(issueId,"Creating Issue failed...");
		}catch(Exception e){
			e.printStackTrace();
			return issueId;
		}
		return issueId;
	}
	@Override
	public String createDefect(String issueSummary, String issueType) {
		String defectId = null;
		try{
			defectId =  jiraLandingPage.navigateToCreateIssuePage().createDefect(issueSummary, issueType);
			Assert.assertNotNull(defectId,"Defect Creation Failed...");
		}catch(Exception e){
			e.printStackTrace();
			return defectId;
		}
		
		return defectId;
	}
	public boolean uninstallPlugin(Map<String, String> values){
		try{
			Assert.assertTrue(jiraLandingPage.navigateToAddonsPage(values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD"))
					.navigateToManageAddonsPage()
					.uninstallPlugin(), "Plug in is not installed successfully.");
			logger.info("Plug-in is installed successfully.");
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public boolean deleteProject(Map<String, String> values){
		return jiraLandingPage.deleteProject(values.get("JIRA_PROJECT"), values.get("ADMIN_AUTHENTICATE_USERNAME"), values.get("ADMIN_AUTHENTICATE_PASSWORD"));
	}
	@Override
	public boolean runJellyScript(Map<String, String> values) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
