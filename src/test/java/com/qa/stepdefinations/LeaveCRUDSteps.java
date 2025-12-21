package com.qa.stepdefinations;

import com.qa.base.Base;
import com.qa.pages.LeavePage;
import com.qa.pages.LoginPage;
import com.qa.util.CaptureScreenshot;
import com.qa.util.ReadProperties;
import com.qa.util.WaitMethods;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LeaveCRUDSteps extends Base{
	
	
	Scenario scenario;
    LoginPage objLoginPage;
    LeavePage objLeavePage;
    
    
    @Before
	public void startApplication(Scenario scenario){
		
		this.scenario=scenario;
	}
    
    
	@Given("^Navigate to LEave after log in with Admin user$")
	public void navigate_to_LEave_after_log_in_with_Admin_user() throws Throwable {
		scenario.write("Starting the browser and application");

		driver = initializeWebDriver();
		WaitMethods.staticWait(5000);

		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

		scenario.write("Logging in to the  application");
		objLoginPage = new LoginPage(driver, scenario);
		objLoginPage.login(ReadProperties.getAppUserName(), ReadProperties.getAppPassword());
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		scenario.write("NAvigating to Leave Page");
		
		objLeavePage= new LeavePage(driver,scenario);
		objLeavePage.navigateToLeavePage();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		
		
		
	}

	@When("^I navigate config and then select Leave Types$")
	public void i_navigate_config_and_then_select_Leave_Types() throws Throwable {
	    
		scenario.write("Navigating config menu and selecting leave type ");
		objLeavePage.launchConfigMenu();
		objLeavePage.launchLeaveTypePage();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	
	}

	@Then("^Add the Leave with below field and values and I verify leave is displayed in leave list$")
	public void add_the_Leave_with_below_field_and_values_and_I_verify_leave_is_displayed_in_leave_list(DataTable leaveTypeNameTable) throws Throwable {
		scenario.write("Adding new leave Type ");
		objLeavePage.addNewLeaveType(leaveTypeNameTable.raw().get(0).get(1));
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		scenario.write("Veryfying the  new leave Type in the list ");
		Assert.assertEquals(leaveTypeNameTable.raw().get(0).get(1), objLeavePage.getNewlyaddedLeaveType());
		
	}

	@Then("^I Edit the Leave type and change below values and I verify verify the leave name is changed to new name$")
	public void i_Edit_the_Leave_type_and_change_below_values_and_I_verify_verify_the_leave_name_is_changed_to_new_name(DataTable textToAppendTable) throws Throwable {
	  
		scenario.write("Editing the Leave Type ");
		objLeavePage.editLeaveType(textToAppendTable.raw().get(0).get(1));
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^Delete the Newly added Leave Type$")
	public void delete_the_Newly_added_Leave_Type() throws Throwable {
		scenario.write("Deleting the  Leave Type ");
		objLeavePage.deleteLeaveType();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}
	
	@After
	public void closeApplication(){
		scenario.write("Closing the browser and application!");
		closeBrowser();
	}

}
