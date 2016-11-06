package com.thed.zfjbvt.jira;

import java.util.Map;
/**
 * This is Jira's navigator page which is an interface, where we can put the method heading part and declaration should be in implementation classes. 
 * @author Manoj
 *
 */
public interface JiraNavigator {
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to logout from jira.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean doLogout();
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to login to jira and it will show jira landing page.
	 * This method will take a map which contains  <b>JIRA_USERNAME, JIRA_PASSWORD</b>.
	 * @param values contains values for operation of this method.
	 * @param JIRA_USERNAME This parameter contains jira's username for lagin to jira.
	 * @param JIRA_PASSWORD This parameter contains jira's password for lagin to jira.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean doLogin(String username, String password);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to search for new plugin in Atlassian Marketplace in JIRA.
	 * This method will take a map which contains  <b>ADMIN_AUTHENTICATE_USERNAME, ADMIN_AUTHENTICATE_PASSWORD, FIND_NEW_PLUGIN_NAME </b>.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>ADMIN_AUTHENTICATE_USERNAME</b> This parameter contains Administration authenticate username.<br/>
	 * <b>ADMIN_AUTHENTICATE_PASSWORD</b> This parameter contains Administration authenticate password <br/>
	 * <b>FIND_NEW_PLUGIN_NAME</b> This parameter contains zfj plugin name which need to search in Atlassian Marketplace. <br/>
	 * </p>
	 *  @return The boolean value i.e. True or False.
	 */
	public boolean searchForNewPlugIn(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.
	 * This method is used to install zfj plunin in manage admin add-ons page.
	 * This method will take a map which contains  <b>ADMIN_AUTHENTICATE_USERNAME, ADMIN_AUTHENTICATE_PASSWORD, FIND_NEW_PLUGIN_NAME </b>.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>ADMIN_AUTHENTICATE_USERNAME</b> This parameter contains Administration authenticate username.<br/>
	 * <b>ADMIN_AUTHENTICATE_PASSWORD</b> This parameter contains Administration authenticate password <br/>
	 *  </p>
	 *  @return The boolean value i.e. True or False.
	 */
	public boolean installZFJPlugIn(Map<String, String> values);
	
	/**
	 * Returns a boolean value based on the method's execution status i.e method executed successfully or not.<br/>
	 * This method sets the visibility of the fields in create issue dialog., default it will set the environment and the fix version fields.<br/> 	
	 * @param Two STRINGS, this strings should be the fields whose visibility has to be set. 
	 * 
	 * @return The boolean value i.e. True or False.
	 */
	public boolean setFieldVisibilityInCreateIssueDialog(String firstField, String secondField);
	
	public boolean selectProject(String projectName);
	
	
	
	public boolean checkAndCloseNewFeatureDialog();
	
	public String getZephyrTestLink();
	
	public boolean navigateToAdminPage(String username, String password);
	public boolean navigateToAdminCustomizeTestStatusPage(String username, String password);
	public boolean navigateToAdminCustomizeStepStatusPage(String username, String password);
	public boolean navigateToZfjGeneralConfigurationPage(String username, String password);
	public boolean leavingAdministrationPage();
	public boolean createIssue(String issueSummary);
	public String createIssue(String issueSummary,String issueType);
	public String createDefect(String issueSummary,String issueType);
	//public boolean changeViewInSearchTest(String view);
	public boolean uninstallPlugin(Map<String, String> values);
	public boolean deleteProject(Map<String, String> values);
	
	public boolean runJellyScript(Map<String, String> values);

}
