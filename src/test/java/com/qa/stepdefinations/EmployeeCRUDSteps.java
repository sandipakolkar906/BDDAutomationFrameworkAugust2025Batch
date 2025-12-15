package com.qa.stepdefinations;

import org.junit.Assert;

import com.qa.base.Base;
import com.qa.pages.LoginPage;
import com.qa.pages.PIMPage;
import com.qa.util.CaptureScreenshot;
import com.qa.util.ReadProperties;
import com.qa.util.WaitMethods;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Acer
 *
 */
/**
 * @author Acer
 * Test 1
 */
public class EmployeeCRUDSteps extends Base {
	
	

	    Scenario scenario;
	    LoginPage objLoginPage;
	    PIMPage objPIMPage;
	    
	    @Before
		public void startApplication(Scenario scenario){
			
			this.scenario=scenario;
			
			
		}
	

		@Given("^Navigate to PIM after log in with Admin user$")
		public void navigate_to_PIM_after_log_in_with_Admin_user() throws Throwable {
			
			scenario.write("Starting the browser and application");

			driver = initializeWebDriver();
			WaitMethods.staticWait(5000);

			scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
			

			scenario.write("Logging in to the  application");
			objLoginPage = new LoginPage(driver, scenario);
			objLoginPage.login(ReadProperties.getAppUserName(), ReadProperties.getAppPassword());
			WaitMethods.staticWait(5000);

			scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		    
		}

		@When("^I Add employee with  first name as \"([^\"]*)\" and mname as \"([^\"]*)\" and lName as \"([^\"]*)\"$")
		public void i_Add_employee_with_first_name_as_and_mname_as_and_lName_as(String fName, String mName, String lName)
				throws Throwable {
			
			scenario.write("Navigating to Add Emp Page and adding new emp");
			objPIMPage = new PIMPage(driver, scenario);
			objPIMPage.navigateToPIMPage();
			objPIMPage.navigateToAddEmployeePage();
			objPIMPage.addnewEmp(fName, mName, lName);
			WaitMethods.staticWait(5000);
			scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		    
		}

		@Then("^I  verify employeeAdded in list with  first name as \"([^\"]*)\" and mname as \"([^\"]*)\" and lName as \"([^\"]*)\"$")
		public void i_verify_employeeAdded_in_list_with_first_name_as_and_mname_as_and_lName_as(String fName, String mName,
				String lName) throws Throwable {
		    
			scenario.write("Searching the newly added emp");
			objPIMPage.navigateToEmpListPage();
			WaitMethods.staticWait(2000);
			Assert.assertEquals(fName + " " + mName, objPIMPage.searchEmpbyFnameandMname(fName, fName));
			WaitMethods.staticWait(5000);
			scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		}

		@When("^I click on Edit button and update below values and save the Data$")
		public void i_click_on_Edit_button_and_update_below_values_and_save_the_Data(DataTable editEmpDataTabel) 
				throws Throwable {
			
			scenario.write("Editing  the newly added emp");
			objPIMPage.editEmp(editEmpDataTabel.raw().get(0).get(1), editEmpDataTabel.raw().get(1).get(1),
					editEmpDataTabel.raw().get(2).get(1));
			WaitMethods.staticWait(5000);
			scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		   
		}

		@Then("^I search the employee and ensure that it is searched using below values$")
		public void i_search_the_employee_and_ensure_that_it_is_searched_using_below_values(DataTable updatedEmpTable) 
				throws Throwable {
			
			scenario.write("Search updated emp");
			objPIMPage.navigateToEmpListPage();
			Assert.assertEquals(updatedEmpTable.raw().get(0).get(1) + " " + updatedEmpTable.raw().get(1).get(1), objPIMPage
					.searchEmpbyFnameandMname(updatedEmpTable.raw().get(0).get(1), updatedEmpTable.raw().get(1).get(1)));
			WaitMethods.staticWait(5000);
			scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		    
		}

		@Then("^I select and Delete the Updated Employee and verify employee is not  in search result$")
		public void i_select_and_Delete_the_Updated_Employee_and_verify_employee_is_not_in_search_result() 
				throws Throwable {
		    
			scenario.write("Deleting the emp");
			objPIMPage.deleteEmp();
			WaitMethods.staticWait(5000);
			scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		}
		
		/**
		 * 
		 */
		@After
		public void closeApplication(){
			scenario.write("Closing the browser and application!");
			closeBrowser();
		}
}
