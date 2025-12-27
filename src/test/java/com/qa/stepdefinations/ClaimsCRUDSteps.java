package com.qa.stepdefinations;

import com.qa.base.Base;
import com.qa.pages.BuzzPage;
import com.qa.pages.ClaimsPage;
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

public class ClaimsCRUDSteps extends Base {

	Scenario scenario;
	LoginPage objLoginPage;
	ClaimsPage objClaimsPage;

	@Before
	public void startApplication(Scenario scenario) {

		this.scenario = scenario;

	}

	@Given("^Navigate to Claims after log in with Admin user$")
	public void navigate_to_Claims_after_log_in_with_Admin_user() throws Throwable {

		scenario.write("Starting the browser and application");
		driver = initializeWebDriver();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		scenario.write("Logging in to the  application");
		objLoginPage = new LoginPage(driver, scenario);
		objLoginPage.login(ReadProperties.getAppUserName(), ReadProperties.getAppPassword());
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		scenario.write("Navigating to claims page");
		objClaimsPage = new ClaimsPage(driver, scenario);
		objClaimsPage.navigateToClaimsPage();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

	}

	@Given("^I navigate to submit claims Page$")
	public void i_navigate_to_submit_claims_Page() throws Throwable {
		scenario.write("Ignoring step");
	}

	@When("^I crate claim Request with Event and Currency$")
	public void i_crate_claim_Request_with_Event_and_Currency(DataTable eventandCurrencyTable) throws Throwable {
		scenario.write("Adding new claim with Event " +eventandCurrencyTable.raw().get(1).get(0) + " and  currency as :" + eventandCurrencyTable.raw().get(1).get(1)); 
		objClaimsPage.submitClaim();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

	
	}

	@When("^I add Expenses for the new claim Request with below fields and values$")
	public void i_add_Expenses_for_the_new_claim_Request_with_below_fields_and_values(DataTable expenseTable) throws Throwable {
		scenario.write("Adding expenses ");
		objClaimsPage.addExpense(expenseTable.raw().get(2).get(1), expenseTable.raw().get(3).get(1));
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		
	}

	@Then("^I verify the total amount of all expenses is caculated correctly$")
	public void i_verify_the_total_amount_of_all_expenses_is_caculated_correctly() throws Throwable {
      Assert.assertEquals("100.00", objClaimsPage.getTotlalAmount().split(":")[1].trim());
      WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@After
	public void closeApplication() {
		scenario.write("Closing the browser and application!");
		closeBrowser();
	}
}
