package com.qa.stepdefinations;

import com.qa.base.Base;
import com.qa.pages.LoginPage;
import com.qa.pages.RecruitmentPage;
import com.qa.util.CaptureScreenshot;
import com.qa.util.GetSystemDateandTime;
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

/**
 * @author Admin
 *   
 */
public class RecruitmentCRUDSteps extends Base{
	
	Scenario scenario;
	LoginPage objLoginPage;
	RecruitmentPage objRecruitmentPage;
	
	
	@Before
	public void startApplication(Scenario scenario) {

		this.scenario = scenario;

	}
	
	@Given("^Navigate to Recruitment page after log in with Admin$")
	public void navigate_to_Recruitment_page_after_log_in_with_Admin() throws Throwable {
		
		scenario.write("Starting the browser and application");
		driver = initializeWebDriver();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		scenario.write("Logging in to the  application");
		objLoginPage = new LoginPage(driver, scenario);
		objLoginPage.login(ReadProperties.getAppUserName(), ReadProperties.getAppPassword());
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		
		scenario.write("Navigating to recruitment Page");
		objRecruitmentPage= new RecruitmentPage(driver,scenario);
		Assert.assertEquals("Recruitment", objRecruitmentPage.navigateToRecruitmentPage());
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@When("^Add new Candidate with below field and values$")
	public void add_new_Candidate_with_below_field_and_values(DataTable candidateDataTable) throws Throwable {
		scenario.write("Adding new Candidate");
		objRecruitmentPage.addnewCandidate(candidateDataTable.raw().get(1).get(1), candidateDataTable.raw().get(2).get(1), candidateDataTable.raw().get(3).get(1), candidateDataTable.raw().get(4).get(1));
		
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^I verify that candidate is added with currentDate$")
	public void i_verify_that_candidate_is_added_with_currentDate() throws Throwable {
		scenario.write("Verifying candidate Application Date");
		Assert.assertEquals(GetSystemDateandTime.getCurrentDateandTime().split(" ")[0],objRecruitmentPage.getCandidateApplicationDate() );
	    WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^I delete the searched Candidate$")
	public void i_delete_the_searched_Candidate() throws Throwable {
		scenario.write("Deleting newly added candidate");
		objRecruitmentPage.deleteCandidate();
		 WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	
	@After
	public void closeApplication() {
		scenario.write("Closing the browser and application!");
		closeBrowser();
	}
}
