package com.thed.zfjbvt.zfj;

import java.util.List;
import java.util.Map;
/**
 * This is zfj's navigator page which is an interface, where we can put the method heading part and declaration should be in implementation classes. 
 * @author Manoj
 *
 */
public interface ZfjNavigator{
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to update the test execution status.
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status.<br/>
	 * <b>NEW_TEST_EXEC_STATUS</b> This parameter contains the new test execution status. <br/>
	 * <b>NEW_TEST_EXEC_STATUS_DESC</b> This parameter contains the new test execution status description. <br/>
	 * </p>
	 *  @return The boolean value i.e. True or False.
	 */
	public boolean updateTestExecutionStatus(Map<String, String> values);
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to add a new test execution status.
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>NEW_TEST_EXEC_STATUS</b> This parameter contains a new test execution status.<br/>
	 * <b>NEW_TEST_EXEC_STATUS_DESC</b> This parameter contains the new test execution status description. <br/>
	 * <b>NEW_TEST_EXEC_STATUS_COLORCODE</b> This parameter contains the new test execution status color code. <br/>
	 * </p>
	 *  @return The boolean value i.e. True or False.
	 */
	public boolean addTestExecutionStatus(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to update the step execution status.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>TEST_STEP_STATUS</b> This parameter contains test execution status.<br/>
	 * <b>NEW_STEP_EXEC_STATUS</b> This parameter contains the new test execution status. <br/>
	 * <b>NEW_STEP_EXEC_STATUS_DESC</b> This parameter contains the new test execution status description. <br/>
	 * </p>
	 *  @return The boolean value i.e. True or False.
	 */
	public boolean updateStepExecutionStatus(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to add a new step execution status.
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>NEW_STEP_EXEC_STATUS</b> This parameter contains a new test execution status.<br/>
	 * <b>NEW_STEP_EXEC_STATUS_DESC</b> This parameter contains the new test execution status description. <br/>
	 * <b>NEW_STEP_EXEC_STATUS_COLORCODE</b> This parameter contains the new test execution status color code. <br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean addStepExecutionStatus(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to create a new test cycle.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>CYCLE_DESC</b> This parameter contains the cycle description which is used for creating the cycle in zfj. <br/>
	 * <b>CYCLE_START_DATE</b>  This parameter contains the cycle start date which is used for creating the cycle in zfj.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean createTestCycle(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to add a test into the test cycle.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used for adding into the cycle in zfj. <br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean addTestToCycle(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test in test cycle and change the status to any.
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean executeTest(Map<String, String> values);
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test in test cycle and change the status to any and create a defect asssociated with the test.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * <b>ISSUE_SUMMARY</b> This parameter contains the issue summary which is used for creating an issue.
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean executeTestWithDefect(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute test steps of the test in test cycle and change the step statuses to any <br/>
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>STEP_EXEC_STATUS_ONE</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>STEP_EXEC_STATUS_TWO</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>STEP_EXEC_STATUS_THREE</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>STEP_EXEC_STATUS_FOUR</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean executeSteps(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test step of the test in test cycle and change the step statuses to any.<br/>
	 *@param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>STEP_EXEC_STATUS</b>This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>STEP_NUM</b>This parameter contains step number which step want to execute.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean executeStep(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test step associate with a defect.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>STEP_EXEC_STATUS</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>TEST_STEP_NUM</b> This parameter contains step number which step want to execute.<br/>
	 * <b>ISSUE_SUMMARY</b> This parameter contains the issue summary text which is used while creating an issue.<br/>
	 *  </p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean executeStepWithDefect(Map<String, String> values);

	
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute all tests and change the execution status to different value.<br/>
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>CYCLE_DESC</b> This parameter contains the cycle description. <br/>
	 * <b>CYCLE_START_DATE</b> This parameter contains the start date of the cycle.<br/>
	 * <b>TEST_ONE</b> This parameter contains the number of steps want to execute while execution.<br/>
	 * <b>TEST_ONE</b> This parameter contains the first test value which is used for execution.</br>
	 * <b>TEST_TWO</b> This parameter contains the second test value which is used for execution.</br>
	 * <b>TEST_THREE</b> This parameter contains the third test value which is used for execution.</br>
	 * <b>TEST_FOUR</b> This parameter contains the fourth test value which is used for execution.</br>
	 * <b>TEST_FIVE</b> This parameter contains the fifth test value which is used for execution.</br>
	 * <b>TEST_ONE_EXEC_STATUS</b> This parameter contains the execution status for first test added.</br>
	 * <b>TEST_TWO_EXEC_STATUS</b> This parameter contains the execution status for second test added.</br>
	 * <b>TEST_THREE_EXEC_STATUS</b> This parameter contains the execution status for third test added.</br>
	 * <b>TEST_FOUR_EXEC_STATUS</b> This parameter contains the execution status for fourth test added.</br>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean addTestsMultipleAndExecute(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute all steps of a test and change the main test execution status according to the auto suggest values.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>STEP_EXEC_STATUS</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>NUM_OF_STEPS_EXEC</b> This parameter contains the number of steps want to execute while execution.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean executeAllSteps(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to edit a cycle by changing the previous value and add some new value.<br/>
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>NEW_CYCLE_NAME</b> This parameter contains the new cycle name which is used to replace the old cycle.. <br/>
	 * <b>CYCLE_DESC</b> This parameter contains the cycle description which is used while creating a cycle.<br/>
	 * <b>BUILD_NAME</b> This parameter contains the build number which is used while creating a cycle.</br>
	 * <b>ENV_NAME</b> This parameter contains the enviroment name which is used while creating a cycle.</br>
	 * <b>CYCLE_START_DATE</b> This parameter contains the cycle start date that defines the starting date of the cycle.</br>
	 * <b>CYCLE_END_DATE</b> This parameter contains the cycle end date that defines the ending date of the cycle.</br>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean editCycle(Map<String, String> values);
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test with defect and with attachment.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * <b>ISSUE_SUMMARY</b> This parameter contains the issue summary which is used while creating any defect/issue.</br>
	 *</p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean executeTestWithDefectAndAttachment(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test directly in plan test cycle.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *</p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean executeTestDirectlyInPlanTest(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test directly in view issue page.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *</p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean executeTestDirectlyInViewIssue(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to search a test in Quick search and validate it.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *</p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean quickSearchByID(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test in adhoc and change test to any status from issue detail page.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *</p>
	 * @return The boolean value i.e. True or False.
	 */
	//public boolean executeTestInAdhoc(Map<String, String> values);
	
	//public boolean deleteTest();
	
	//public boolean addTestsFromJiraSearch(Map<String, String> values);
	
	//public boolean addTestsFromOtherCycle(Map<String, String> values);
	
	
	/*public boolean executeTestStepUsingE(Map<String, String> values);
	public boolean executeMultipleTestStepUsingE(Map<String, String> values);
	public boolean executeTestStepUsingEWithDefect(Map<String, String> values);
	public boolean addTestsUsingSpaceBar(Map<String, String> values);
	//public boolean executeMultipleTestsUsingE(Map<String, String> values, String testStatus);
*/	

	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to create a new test cycle.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>CYCLE_DESC</b> This parameter contains the cycle description which is used for creating the cycle in zfj. <br/>
	 * <b>CYCLE_START_DATE</b>  This parameter contains the cycle start date which is used for creating the cycle in zfj.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean createTestCycle(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to add a test into the test cycle.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used for adding into the cycle in zfj. <br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean addTestToCycle(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test in test cycle and change the status to any.
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeTest(Map<String, String> values);
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test in test cycle and change the status to any and create a defect asssociated with the test.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * <b>ISSUE_SUMMARY</b> This parameter contains the issue summary which is used for creating an issue.
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeTestWithDefect(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute test steps of the test in test cycle and change the step statuses to any <br/>
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>STEP_EXEC_STATUS_ONE</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>STEP_EXEC_STATUS_TWO</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>STEP_EXEC_STATUS_THREE</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>STEP_EXEC_STATUS_FOUR</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeSteps(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test step of the test in test cycle and change the step statuses to any.<br/>
	 *@param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>STEP_EXEC_STATUS</b>This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>STEP_NUM</b>This parameter contains step number which step want to execute.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeStep(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test step associate with a defect.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>STEP_EXEC_STATUS</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>TEST_STEP_NUM</b> This parameter contains step number which step want to execute.<br/>
	 * <b>ISSUE_SUMMARY</b> This parameter contains the issue summary text which is used while creating an issue.<br/>
	 *  </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeStepWithDefect(Map<String, String> values);

	
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute all tests and change the execution status to different value.<br/>
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>CYCLE_DESC</b> This parameter contains the cycle description. <br/>
	 * <b>CYCLE_START_DATE</b> This parameter contains the start date of the cycle.<br/>
	 * <b>TEST_ONE</b> This parameter contains the number of steps want to execute while execution.<br/>
	 * <b>TEST_ONE</b> This parameter contains the first test value which is used for execution.</br>
	 * <b>TEST_TWO</b> This parameter contains the second test value which is used for execution.</br>
	 * <b>TEST_THREE</b> This parameter contains the third test value which is used for execution.</br>
	 * <b>TEST_FOUR</b> This parameter contains the fourth test value which is used for execution.</br>
	 * <b>TEST_FIVE</b> This parameter contains the fifth test value which is used for execution.</br>
	 * <b>TEST_ONE_EXEC_STATUS</b> This parameter contains the execution status for first test added.</br>
	 * <b>TEST_TWO_EXEC_STATUS</b> This parameter contains the execution status for second test added.</br>
	 * <b>TEST_THREE_EXEC_STATUS</b> This parameter contains the execution status for third test added.</br>
	 * <b>TEST_FOUR_EXEC_STATUS</b> This parameter contains the execution status for fourth test added.</br>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean addTestsMultipleAndExecute(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute all steps of a test and change the main test execution status according to the auto suggest values.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>STEP_EXEC_STATUS</b> This parameter contains step execution status which is used for set the status while executing test.<br/>
	 * <b>NUM_OF_STEPS_EXEC</b> This parameter contains the number of steps want to execute while execution.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeAllSteps(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to edit a cycle by changing the previous value and add some new value.<br/>
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>NEW_CYCLE_NAME</b> This parameter contains the new cycle name which is used to replace the old cycle.. <br/>
	 * <b>CYCLE_DESC</b> This parameter contains the cycle description which is used while creating a cycle.<br/>
	 * <b>BUILD_NAME</b> This parameter contains the build number which is used while creating a cycle.</br>
	 * <b>ENV_NAME</b> This parameter contains the enviroment name which is used while creating a cycle.</br>
	 * <b>CYCLE_START_DATE</b> This parameter contains the cycle start date that defines the starting date of the cycle.</br>
	 * <b>CYCLE_END_DATE</b> This parameter contains the cycle end date that defines the ending date of the cycle.</br>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean editCycle(Map<String, String> values);
	
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test with defect and with attachment.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 * <b>ISSUE_SUMMARY</b> This parameter contains the issue summary which is used while creating any defect/issue.</br>
	 *</p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeTestWithDefectAndAttachment(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test directly in plan test cycle.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *</p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeTestDirectlyInPlanTest(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to execute a test directly in view issue page.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *</p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeTestDirectlyInViewIssue(Map<String, String> values);
	/**
	 * Returns a boolean value to verify the method is executed successfully or not.<br/>
	 * This method is used to search a test in Quick search and validate it.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *</p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean quickSearchByID(Map<String, String> values);
	/**
	 * This method is used to execute a test in adhoc and change test to any status from issue detail page.<br/>
	 *  @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name which is used for creating and selecting a cycle. <br/>
	 * <b>TEST_NAME</b> This parameter contains the test name which is used executing into the cycle in zfj. <br/>
	 * <b>TEST_EXEC_STATUS</b> This parameter contains test execution status which is used for set the status while executing test.<br/>
	 *</p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeTestInAdhoc(Map<String, String> values);
	/**
	 * This method will take the first test from search tests page and delete that test from search tests page. 
	 * @return The boolean value i.e. True or False.
	 */
	public boolean deleteTest(String testToDelete);
	/**
	 * This method is used to add tests from jira search.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name.<br/>
	 * <b>CYCLE_DESC</b> This parameter contains the cycle description. <br/>
	 * <b>CYCLE_START_DATE</b> This parameter contains cycle start date.<br/>
	 * <b>FILTER_NAME</b> This parameter contains the filter name.
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean addTestsFromJiraSearch(Map<String, String> values);
	/**
	 * This method is used to add tests from other cycle.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>OLD_CYCLE_NAME</b> This parameter contains the Old cycle name.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name.<br/>
	 * <b>CYCLE_DESC</b> This parameter contains the cycle description. <br/>
	 * <b>CYCLE_START_DATE</b> This parameter contains cycle start date.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean addTestsFromOtherCycle(Map<String, String> values);
	
	/**
	 * This method is used export a cycle in csv format.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains cycle name which is used while creating the cycle and selecting the cycle.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name.<br/>
	 * <b>CYCLE_START_DATE</b> This parameter contains cycle start date.<br/>
	 * <b>BUILD_NAME</b> This parameter contains the build name of the cycle. <br/>
	 * <b>ENVIROMENT_NAME</b> This parameter contains the enviroment name of the cycle. <br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean exportCycle(Map<String, String> values);
	
		
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method verifies all the ZFJ Test Menus
	 * 
	 * @return A boolean value i.e True or False.
	 */
	public boolean verifyZfjTestMenus();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method creates an issue of type TEST.
	 * @param values Map contains values to create a Test.
	 * <p>
	 * <b>SUMMARY</b> This parameter contains the TEST summary of the test thats been created.<br/>
	 * <b>PRIORITY</b> This parameter contains the priority of the test thats been created.<br/>
	 * <b>COMPONENT</b> This parameter contains the component to which the TEST belongs to.<br/>
	 * <b>AFFECTED_VERSION</b> This parameter contains the version the TEST is Affecting. <br/>
	 * <b>FIX_VERSION</b> This parameter contains the version the TEST has to be fixed. <br/>
	 * <b>ENVIRONMENT</b> This parameter contains the environment name of the TEST. <br/>
	 * <b>DESCRIPTION</b> This parameter contains the description of the TEST thats been created. <br/> 
	 * <b>LABEL</b> This parameter contains the label to which the TEST is categorized to. <br/>
	 * </p>
	 * 
	 * @return The boolean value i.e. True or False.
	 * 
	 */
	public boolean createTest(Map<String, String> values);

	/**
	 * Returns a boolean value based on the method's execution status i.e method executed successfully or not.<br/>
	 * This method sets the visibility of the fields in create issue dialog., default it will set the environment and the fix version fields.<br/> 	
	 * @param Two STRINGS, this strings should be the fields whose visibility has to be set. 
	 * 
	 * @return The boolean value i.e. True or False.
	 *//*
	public boolean setFieldVisibilityInCreateIssueDialog(String firstField, String secondField);*/
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method creates a TEST and adds Test steps to the test created.
	 * @param values Map contains values to create a TEST and add Test steps to it.
	 * <p>
	 * <b>values to create a TEST.</b><br/>
	 * <b>SUMMARY</b> This parameter contains the TEST summary of the test thats been created.<br/>
	 * <b>PRIORITY</b> This parameter contains the priority of the test thats been created.<br/>
	 * <b>COMPONENT</b> This parameter contains the component to which the TEST belongs to.<br/>
	 * <b>AFFECTED_VERSION</b> This parameter contains the version the TEST is Affecting. <br/>
	 * <b>FIX_VERSION</b> This parameter contains the version the TEST has to be fixed. <br/>
	 * <b>ENVIRONMENT</b> This parameter contains the environment name of the TEST. <br/>
	 * <b>DESCRIPTION</b> This parameter contains the description of the TEST thats been created. <br/> 
	 * <b>LABEL</b> This parameter contains the label to which the TEST is categorized to. <br/>
	 * 
	 * <b> values to add test steps to the TEST.</b><br/>
	 * 
	 * <b>FIRST_STEP</b> This parameter contains the first test step's description. </br>
	 * <b>FIRST_DATA</b> This parameter contains the first test step's data. </br>
	 * <b>FIRST_EXPECTED_RESULT</b> This parameter contains the first test step's expected result. </br>
	 * 
	 * <b>SECOND_STEP</b> This parameter contains the second test step's description. </br>
	 * <b>SECOND_DATA</b> This parameter contains the second test step's data. </br>
	 * <b>SECOND_EXPECTED_RESULT</b> This parameter contains the second test step's expected result. </br>
	 * 
	 * <b>THIRD_STEP</b> This parameter contains the third test step's description. </br>
	 * <b>THIRD_DATA</b> This parameter contains the third test step's data. </br>
	 * <b>THIRD_EXPECTED_RESULT</b> This parameter contains the third test step's expected result. </br>
	 * 
	 * <b>FOURTH_STEP</b> This parameter contains the fourth test step's description. </br>
	 * <b>FOURTH_DATA</b> This parameter contains the fourth test step's data. </br>
	 * <b>FOURTH_EXPECTED_RESULT</b> This parameter contains the fourth test step's expected result. </br>
	 * 
	 * <b>FIFTH_STEP</b> This parameter contains the fifth test step's description. </br>
	 * <b>FIFTH_DATA</b> This parameter contains the fifth test step's data. </br>
	 * <b>FIFTH_EXPECTED_RESULT</b> This parameter contains the fifth test step's expected result. </br>
	 * 
	 * <b>TOTAL_STEPS</b> This parameter contains the total number of test steps that are added to the Test (<=5)test steps can be added. <br/> 
	 * </p>
	 * 
	 * @return The boolean value i.e. True or False.
	 */
	
	public boolean addStepsToTest(Map<String, String> values);
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method Re-Arranges the Test steps thats been added to the TEST, it selects The First Test from the ISSUE NAVIGATOR and re-arranges the test steps.
	 * This method re-arranges the Test steps numbers 1 and 4.
	 * 
	 * @return The boolean value i.e. True or False.
	 */
	public boolean reArrangeTeststeps(int srcStep, int destStep);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method creates a TEST and adds Test steps to the test created and edits the test step specified.
	 * @param values Map contains values to create a TEST, Test steps to it and to edit it.
	 * <p>
	 * <b>values to create a TEST.</b><br/>
	 * <b>SUMMARY</b> This parameter contains the TEST summary of the test thats been created.<br/>
	 * <b>PRIORITY</b> This parameter contains the priority of the test thats been created.<br/>
	 * <b> values to add test steps to the TEST.</b><br/>
	 * 
	 * 
	 * <b>FIRST_STEP</b> This parameter contains the first test step's description. </br>
	 * <b>FIRST_DATA</b> This parameter contains the first test step's data. </br>
	 * <b>FIRST_EXPECTED_RESULT</b> This parameter contains the first test step's expected result. </br>
	 * 
	 * <b>SECOND_STEP</b> This parameter contains the second test step's description. </br>
	 * <b>SECOND_DATA</b> This parameter contains the second test step's data. </br>
	 * <b>SECOND_EXPECTED_RESULT</b> This parameter contains the second test step's expected result. </br>
	 * <b>TOTAL_STEPS</b> This parameter contains the total number of test steps that are added to the Test (<=5)test steps can be added. <br/>
	 * <b>TEST_STEP_TO_EDIT</b> This parameter contains the Test step Number that has to be Edited. <br/>
	 * <b>CHANGE_STEP_TO</b> This parameter contains the Test step's description that has to changed to. <br/>
	 * <b>CHANGE_DATA_TO</b> This parameter contains the Test step's data that has to changed to. <br/>
	 * <b>CHANGE_EXPECTED_RESULT_TO</b> This parameter contains the Test step's expected result that has to changed to. <br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean editTeststeps(Map<String, String> values);
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method creates an issue of type TEST and edits the TEST created.
	 * @param values Map contains values to create a Test and the values to edit the same.
	 * <p>
	 * <b>SUMMARY</b> This parameter contains the TEST summary of the test thats been created.<br/>
	 * <b>PRIORITY</b> This parameter contains the priority of the test thats been created.<br/>
	 * <b>COMPONENT</b> This parameter contains the component to which the TEST belongs to.<br/>
	 * <b>AFFECTED_VERSION</b> This parameter contains the version the TEST is Affecting. <br/>
	 * <b>FIX_VERSION</b> This parameter contains the version the TEST has to be fixed. <br/>
	 * <b>ENVIRONMENT</b> This parameter contains the environment name of the TEST. <br/>
	 * <b>DESCRIPTION</b> This parameter contains the description of the TEST thats been created. <br/> 
	 * <b>LABEL</b> This parameter contains the label to which the TEST is categorized to. <br/>
	 * 
	 * <b>CHANGE_SUMMARY_TO</b> This parameter contains the new TEST summary of the test thats been created.<br/>
	 * <b>CHANGE_PRIORITY_TO</b> This parameter contains the new priority of the test thats been created.<br/>
	 * <b>CHANGE_COMPONENT_TO</b> This parameter contains the new component to which the TEST belongs to.<br/>
	 * <b>CHANGE_AFFECTED_VERSION_TO</b> This parameter contains new the version the TEST is Affecting. <br/>
	 * <b>CHANGE_FIX_VERSION_TO</b> This parameter contains the new version the TEST has to be fixed. <br/>
	 * <b>CHANGE_ENVIRONMENT_TO</b> This parameter contains the new environment name of the TEST. <br/>
	 * <b>CHANGE_DESCRIPTION_TO</b> This parameter contains the new description of the TEST thats been created. <br/> 
	 * <b>CHANGE_LABEL_TO</b> This parameter contains the new label to which the TEST is categorized to. <br/>
	 * </p> 
	 * 
	 * @return The boolean value i.e. True or False.
	 */
	public boolean editTestDetails(Map<String, String> values);
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method creates a TEST and adds Test steps to the test created and clones the same.
	 * @param values Map contains values to create a TEST, Test steps to it and the summary of  the new clone TEST.
	 * <p>
	 * <b>values to create a TEST.</b><br/>
	 * <b>SUMMARY</b> This parameter contains the TEST summary of the test thats been created.<br/>
	 * <b>PRIORITY</b> This parameter contains the priority of the test thats been created.<br/>
	 * <b>COMPONENT</b> This parameter contains the component to which the TEST belongs to.<br/>
	 * <b>AFFECTED_VERSION</b> This parameter contains the version the TEST is Affecting. <br/>
	 * <b>FIX_VERSION</b> This parameter contains the version the TEST has to be fixed. <br/>
	 * <b>ENVIRONMENT</b> This parameter contains the environment name of the TEST. <br/>
	 * <b>DESCRIPTION</b> This parameter contains the description of the TEST thats been created. <br/> 
	 * <b>LABEL</b> This parameter contains the label to which the TEST is categorized to. <br/>
	 * 
	 * <b> values to add test steps to the TEST.</b><br/>
	 * 
	 * <b>FIRST_STEP</b> This parameter contains the first test step's description. </br>
	 * <b>FIRST_DATA</b> This parameter contains the first test step's data. </br>
	 * <b>FIRST_EXPECTED_RESULT</b> This parameter contains the first test step's expected result. </br>
	 * 
	 * <b>SECOND_STEP</b> This parameter contains the second test step's description. </br>
	 * <b>SECOND_DATA</b> This parameter contains the second test step's data. </br>
	 * <b>SECOND_EXPECTED_RESULT</b> This parameter contains the second test step's expected result. </br>
	 * <b>TOTAL_STEPS</b> This parameter contains the total number of test steps that are added to the Test (<=5)test steps can be added. <br/>
	 * 
	 * <b>CHANGE_SUMMARY_TO</b> This parameter contains the cloned TEST summary.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	
	public boolean cloneTest(Map<String, String> values);
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method creates two TESTS and links them.
	 * 
	 * @param values Map contains values to create two TESTS, link type and comment for linking two TESTS.
	 * <p>
	 * FIRST TEST details. <br/>
	 * <b>SUMMARY</b> This parameter contains the TEST summary of the test thats been created.<br/>
	 * <b>PRIORITY</b> This parameter contains the priority of the test thats been created.<br/>
	 * <b>COMPONENT</b> This parameter contains the component to which the TEST belongs to.<br/>
	 * <b>AFFECTED_VERSION</b> This parameter contains the version the TEST is Affecting. <br/>
	 * <b>FIX_VERSION</b> This parameter contains the version the TEST has to be fixed. <br/>
	 * <b>ENVIRONMENT</b> This parameter contains the environment name of the TEST. <br/>
	 * <b>DESCRIPTION</b> This parameter contains the description of the TEST thats been created. <br/> 
	 * <b>LABEL</b> This parameter contains the label to which the TEST is categorized to. <br/>
	 * 
	 * SECOND TEST details. <br/>
	 * <b>SECOND_SUMMARY</b> This parameter contains the new TEST summary of the test thats been created.<br/>
	 * <b>SECOND_PRIORITY</b> This parameter contains the new priority of the test thats been created.<br/>
	 * <b>SECOND_COMPONENT</b> This parameter contains the new component to which the TEST belongs to.<br/>
	 * <b>SECOND_AFFECTED_VERSION</b> This parameter contains new the version the TEST is Affecting. <br/>
	 * <b>SECOND_FIX_VERSION</b> This parameter contains the new version the TEST has to be fixed. <br/>
	 * <b>SECOND_ENVIRONMENT</b> This parameter contains the new environment name of the TEST. <br/>
	 * <b>SECOND_DESCRIPTION</b> This parameter contains the new description of the TEST thats been created. <br/> 
	 * <b>SECOND_LABEL</b> This parameter contains the new label to which the TEST is categorized to. <br/>
	 * 
	 * <b>LINKS</b> This parameter contains the type of LINK between the two tests. <br/>
	 * <b>COMMENT</b> This parameter contains the comment, description on the link. <br/>
	 * </p>
	 * 
	 * @return The boolean value i.e. True or False.
	 */
	public boolean linkTestToAnotherTest(Map<String, String> values);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method creates TEST and ISSUE and links a TEST to an ISSUE thats been created. 
	 * @param values Map contains values to create four TESTS, issue summary,issue type,link type and comment for linking a TEST to an ISSUE.
	 *<p>
	 * <b>values to create a TEST.</b><br/>
	 * <b>SUMMARY</b> This parameter contains the TEST summary of the test thats been created.<br/>
	 * <b>PRIORITY</b> This parameter contains the priority of the test thats been created.<br/>
	 * 
	 * <b> values to create ISSUE.</b> <br/>
	 * <b>ISSUE_SUMMARY</b> This parameter contains the issue's summary thats been created. <br/>
	 * <b>ISSUE_TYPE</b> This parameter contains the issue type that links the two tests. <br/>
	 * <b>LINKS</b> This parameter contains the type of LINK between the two tests. <br/>
	 * <b>COMMENT</b> This parameter contains the comment, description on the link. <br/>
	 * </p>
	 *
	 *@return The boolean value i.e. True or False.
	 */
	public boolean linkTestToissue(Map<String, String>values);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method does a QUICK SEARCH on the test by specifying the TEST-ID of a test., by default the method will fetch the first test that is 
	 * present in the ISSUE NAVIGATOR PAGE and search for the same. 
	 * 
	 *@return The boolean value i.e. True or False.
	 */
	public boolean searchTestByKeyword();
	
	public boolean searchTestById();
	
	
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method exports ALL_FIELDS in ISSUE NAVIGATOR into EXCEL FORMAT, by default this method will validate the first TEST thats been created 
	 * with test steps before invoking this method. 
	 *@return The boolean value i.e. True or False.
	 */
	public boolean exportTestFromIssueNavigator();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method creates a TEST CYCLE, a TEST and adds the TEST to that CYCLE and Clones the CYCLE. 
	 * @param values Map contains values to create cycle, test and clone the cycle.
	 * <p>
	 * <b>VERSION_NAME</b> This parameter contains the version to which the new cycle created must added.<br/>
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name that is to be created.<br/>
	 * <b>CLONE_CYCLE_NAME</b> This parameter contains the clone cycle's name.<br/>
	 * <b>CYCLE_DESC</b> This parameter contains the description of the newly created cycle.<br/>
	 * <b>CYCLE_START_DATE</b> This parameter contains the start date of the cycle thats been created.<br/>
	 * <b>TEST_SUMMARY</b> This parameter contains the summary of the Test thats been created.<br/>
	 * <b>TEST_PRIORITY</b> This parameter contains the priority of test thats been created.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	
	public boolean cloneTestCycle(Map<String, String> values);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the "All Executed Tests" in PreDefined Filters and does bulk status change to the Tests selected.<br/>
	 * @param String status, int totalTests contains values to perform bulk status change.
	 * <p>
	 * <b>STATUS</b> This parameter contains the new status that has to be changed. <br/>
	 * <b>TOTALTEST</b> This parameter contains the number of test that has to selected to change the status.  
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean changeBulkTestsStatus(String status, int totalTest);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the "All Executed Tests" in PreDefined Filters and bulk does associates defect to the Tests selected.<br/>
	 * @param int totalTests contains value to perform bulk association of defects.
	 * <p>
	 * <b>TOTALTEST</b>This parameter contains the number of test that has to selected to associate the defects.
	 * <p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean bulkAssociateDefect(String issueId,int totalTests);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the "All Unexecuted Test" in PreDefined Filters and does bulk status change to the Tests along with Test steps selected.<br/>
	 * @param String testStatus, String teststepStatus, int totalTests contains value to perform bulk association of defects.
	 * <p>
	 * <b>TESTSTATUS</b> This parameter contains the new status that has to be changed for the Test selected. <br/>
	 * <b>TESTSTEPSTATUS</b> This parameter contains the new status that has to be changed for the Test steps selected. <br/>
	 * <b>TOTALTEST</b> This parameter contains the number of test that has to selected to do bulk status change.
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	
	public boolean changeBulkTestsStatusWithTeststeps(String testStatus, String teststepStatus, int totalTest);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the "All Executed Tests" in PreDefined Filters and does bulk status change to the Tests with clearing the defects associated to it.<br/>
	 * @param int totalTest contains the value to perform bulk test status change to unexecuted.
	 * <p>
	 * <b>TOTALTEST</b> This parameter contains the number of test that has to selected to do bulk status change.<br/>
	 * </p> 
	 * @return The boolean value i.e. True or False.
	 */
		
	public boolean changeBulkTestStatusToUnexecutedWithDefectsCleared(String bugId,int totalTest);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the "All Executed Tests" in PreDefined Filters and does bulk move of test form one cycle to another cycle.<br/>
	 * @param Stirng version, cycle contains the value to perform bulk move of test form one cycle to another.
	 * <p>
	 * <b>VERSION</b> This parameter contains the version to which the cycle belongs to. <br/>
	 * <b>CYCLE</b> This parameter contains the cycle name to which the Test will be moved to. <br/>
	 * <b>TOTALTEST</b> This parameter contains the number of test that has to selected to do bulk status change.<br/> 
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	
	
	public boolean bulkMoveTestsToCycle(String version,String cycle,int totalTest);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the "All Executed Tests" in PreDefined Filters and does bulk move of test form one cycle to another cycle along with the defects associated.<br/>
	 * @param Stirng version, cycle and int totalTest contains the value to perform bulk move of test form one cycle to another.
	 * <p>
	 * <b>VERSION</b> This parameter contains the version to which the cycle belongs to. <br/>
	 * <b>CYCLE</b> This parameter contains the cycle name to which the Test will be moved to. <br/> 
	 * <b>TOTALTEST</b> This parameter contains the number of test that has to selected to do bulk move.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean bulkMoveTestsToCycleWithDefects(String version, String cycle, String bugId, int totalTest);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the "All Executed Tests" in PreDefined Filters and does bulk move of test form one cycle to a newly created cycle by clearing the defects and the status associated.<br/>
	 * @param String version,cycle and int totalTest contains the value to perform bulk move of test form one cycle to another.
	 * <p>
	 * <b>VERSION</b> This parameter contains the version to which the cycle belongs to. <br/>
	 * <b>CYCLE</b> This parameter contains the cycle name to which will be created and the Test will be moved to. <br/> 
	 * <b>TOTALTEST</b> This parameter contains the number of test that has to selected to do bulk move.<br/>
	 * </p>
	 * 
	 * @return The boolean value i.e. True or False.
	 */
	
	
	
	public boolean bulkMoveTestToCycleWithDefectsAndStatusNotCarried(String version, String cycle,String bugId, int totalTest);
		
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the "All Executed Tests" in PreDefined Filters and does bulk copy of test form one cycle to a newly created cycle by clearing the defects and the status associated.<br/>
	 * @param String version,cycle and int totalTest contains the value to perform bulk copy of test form one cycle to another.
	 * <p>
	 * <b>VERSION</b> This parameter contains the version to which the cycle belongs to. <br/>
	 * <b>CYCLE</b> This parameter contains the cycle name to which will be created and the Test will be moved to. <br/> 
	 * <b>TOTALTEST</b> This parameter contains the number of test that has to selected to do bulk copy.<br/>
	 * </p>
	 * 
	 * @return The boolean value i.e. True or False.
	 */
	
	public boolean bulkCopyTestToCycleWithDefectsAndStatusNotCarried(String version, String cycle, String issueId, int totalTest);
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method drills down the Test Summary page and validates the total TEST created, executed and remaining,also validates
	 *the total number of TESTS created under each COMPONENT,VRESION AND LABEL available RESPECTIVELY.<br/>
	 * 
	 * @return The boolean value i.e. True or False.
	 */
	public boolean viewAndDrillDownTestSummary();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the<b> TEST CREATION</b> and <b>TEST EXECUTION<b> CHARTS in Test Summary page and validates the total TEST created, executed in last 30 days.<br/> 
	 *  
	 * @return The boolean value i.e. True or False.
	 */
	public boolean viewTestSummaryCharts();
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method launches Test Metrics and validates the <b>TEST DISTRIBUTION<b> and <b>TEST EXECUTION<b> GADGETS.<br/>
	 * @return The boolean value i.e. True or False.
	 */
	
	public boolean launchTestMatricsAndDispalysCreationAndExecutionGadgets();
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method adds the<b> TOP DEFECT GADGET</b> to the TEST METRICS page. By default gadget will be TOP DEFECT.<br/>
	 * @param gadget, STRING values which specifies the gadget that has to be added.<br/>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	public boolean addTopDefectGadget();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method adds the<b> TEST EXECUTION BURNDOWN GADGET</b> to the TEST METRICS page.<br/>
	 * @param gadget, STRING values which specifies the gadget that has to be added. By default gadget will be TEST EXECUTION BURNDOWN.<br/>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	public boolean addExecutionBurndownGadget();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method adds the<b>TEST EXECUTION DETAILS GADGET</b> to the TEST METRICS page.<br/>
	 * @param gadget, STRING values which specifies the gadget that has to be added. By default gadget will be TEST EXECUTION DETAILS.<br/>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	
	
	public boolean addTestExecutionDetailsGadget();
	
	
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method edits a specified GADGET in the TEST METRICS page.<br/>
	 * @param values Map contains values to edit a GADGET.<br/>
	 * <p>
	 * <b>GADGET</b> This parameter contains the gadget name that has to be edited.<br/> 
	 * <b>PROJECT</b> This parameter contains the project that has to selected. <br/>
	 * <b>VERSION</b> This parameter contains the version to be shown.<br/>
	 * <b>GROUPBY</b> This parameter contains the group by option that has to selected.<br/>
	 * </p>
	 * @return The boolean value i.e. True or False.<br/>
	 */
	public boolean editGadget(Map<String, String> values);
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the TEST EXECUTION GADGET in the TEST METRIC page and displays the PROJECT,VERSION AND GROUPBY option of TEST EXECUTION GADGET.<br/>
	 * @param gadget, STRING values which specifies the gadget that has to be displayed. By default the gadget will be TEST EXECUTION.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean viewTestExecutionGadget();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the TEST DISTRIBUTION GADGET in the TEST METRIC page and displays the PROJECT,VERSION AND GROUPBY option of TEST DISTRIBUTION GADGET.<br/>
	 * @param gadget, STRING values which specifies the gadget that has to be displayed. By default the gadget will be TEST DISTRIBUTION.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean viewTestDistributonGadget();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the TOP DEFECT GADGET in the TEST METRIC page and displays the PROJECT,VERSION AND GROUPBY option of TOP DEFECT GADGET.<br/>
	 * @param gadget, STRING values which specifies the gadget that has to be displayed. By default the gadget will be TOP DEFECT.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean viewTopDefectGadget();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the TEST EXECUTION BURNDOWN GADGET in the TEST METRIC page and displays the PROJECT,VERSION AND GROUPBY option of TEST EXECUTION BURNDOWN GADGET.<br/>
	 * @param gadget, STRING values which specifies the gadget that has to be displayed. By default the gadget will be TEST EXECUTION BURNDOWN.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean viewExecutionBurndownGadget();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method selects the TEST EXECUTION DETAILS GADGET in the TEST METRIC page and displays the SEARCH BY, ZQL QUERY AND GROUPBY option of TEST EXECUTION DETAILS GADGET.<br/>
	 * @param gadget, STRING values which specifies the gadget that has to be displayed. By default the gadget will be TEST EXECUTION DETAILS.
	 * @return The boolean value i.e. True or False.
	 */
	public boolean viewTestExecutionDetailsGadget();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the WORKFLOW TOOLBAR option in VIEW TEST PAGE based on the FLAG set in the ZFJ GENERAL CONFIGURATION.<br/>
	 * @return The boolean value i.e. True or False.
	 */
	
	public boolean checkWorkflowToolbar();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the ISSUE LINK from an ISSUE to a TEST in VIEW TEST PAGE based on the FLAG set in the ZFJ GENERAL CONFIGURATION.<br/>
	 * @return The boolean value i.e. True or False.
	 */
	
	
	
	public boolean changeIssueLinkStatus();
	
	/**
	 * Returns a boolean value based on the method's execution status, i.e method executed successfully or not.<br/>
	 * This method validates the REMOTE ISSUE LINK from an ISSUE to a TEST EXECUTION in VIEW TEST PAGE based on the FLAG set in the ZFJ GENERAL CONFIGURATION.<br/>
	 * @return The boolean value i.e. True or False.
	 */
	
	
	public boolean changeRemoteIssueLinkStatus();
	
	public boolean executePredefinedFilters(Map<String, String> values);
	
	public boolean executeZQLQueryForFixVersion(Map<String, String> values);
	
	public boolean createExecFilterAndSaveToFavourite(Map<String, String> values);
	
	public boolean searchExecutionFilter(Map<String, String> values);
	
	public boolean exportTestExecutions(Map<String, String> values);
	
	public boolean deleteExecutions(Map<String, String> values);
	
	public boolean searchExecFilterInManageExecFilter(Map<String, String> values);
	/**
	 * Return a boolean value after executing a test by using E button from execution navigator.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>FILTER_NAME_ONE</b> This parameter contains the filter name. 
	 * <b>FILTER_NAME_TWO</b> This parameter contains the filter name.
	 * <b>PROJECT_NAME</b> This parameter contains the project name.
	 * <b>VERSION_NAME</b> This parameter contains the version name.
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name.
	 * <b>TEST_NAME</b> This parameter contains the test name for execution.
	 * <b>TEST_EXEC_STATUS</b> This parameter contains the test execution status for changing the status.
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeTestFromExecutionNavigator(Map<String, String> values);
	/**
	 * Return a boolean value after executing a test directly from execution navigator.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>FILTER_NAME_ONE</b> This parameter contains the filter name. 
	 * <b>FILTER_NAME_TWO</b> This parameter contains the filter name.
	 * <b>PROJECT_NAME</b> This parameter contains the project name.
	 * <b>VERSION_NAME</b> This parameter contains the version name.
	 * <b>CYCLE_NAME</b> This parameter contains the cycle name.
	 * <b>TEST_NAME</b> This parameter contains the test name for execution.
	 * <b>TEST_EXEC_STATUS</b> This parameter contains the test execution status for changing the status.
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeTestDirectlyFromExecutionNavigator(Map<String, String> values);
	/**
	 * Return a boolean value after executing the ZQL Query by using component.
	 * @param values Map contains values for operation of this method.
	 * <p>
	 * <b>COMPONENT_NAME</b> This parameter contains the component name. 
	 * <b>ZQLQUERY</b> This parameter contains the ZQL Query that have to execute. 
	 * </p>
	 * @return The boolean value i.e. True or False.
	 */
	public boolean executeZQLQueryForComponent(Map<String, String> values);
	
	public Map<String, String> createMultipleTestsWithStep();
	public Map<String, String> createMultipleTests();
	public boolean validateTestsDropDown();
	public boolean createTest(String summary, String priority);
	public boolean changeWorkflowStatus();
	public boolean validateWorkflowOptions();
	public boolean checkIssueLinkStatus();
	public boolean checkRemoteIssueLinkStatus();
	public boolean validateIssueLink(Map<String, String> values);
	public boolean validateRemoteIssueLink(Map<String, String> values);
	public boolean executeMultipleTests(Map<String, String> values);

	
	public boolean cloneTeststepInsertAfterStep(int teststep);
	public boolean cloneTeststepByEnteringAValidNumber(int teststep, int cloneAt);
	public boolean customizeColumnsInZqlGadget(String firstColumn, String secondColumn);
	
	
	public Map<String, List<String>> returnTests();
	public List<String> getTest(List<String> list, String type);
	public boolean searchVersion(String versionName);
	public boolean switchViewFromEN(String viewOne, String viewTwo);
	public boolean executeTestInDetailViewFromExecutionNavigator(Map<String, String> values);
	public boolean navigateTestUsingPrevAndNextInDetailediew(String filterName);
	public boolean navigatePageInDetailediew(String filterName, String type);
	public boolean customizeColumnDisplayEN(String filterName, String type);
	public boolean restoreDefualtsColumnInEN(String filterName, String type);
	public boolean navigateTestInFSUsingPrevAndNextInDetailedview(String filterName);
	
	public boolean resetFilters();
	public List<String> getTests(int number);
	public boolean deleteTestExecutionStatus(String testStatus);
	public boolean deleteStepExecutionStatus(String stepStatus);
	public boolean resetGadget();
	public boolean bulkMoveTests(Map<String , String> values);
}
