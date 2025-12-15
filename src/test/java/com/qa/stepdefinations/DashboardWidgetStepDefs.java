package com.qa.stepdefinations;

import java.util.HashMap;

import com.qa.base.Base;
import com.qa.pages.DashboardPage;
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

/**
 * @author Admin
 * 
 */

public class DashboardWidgetStepDefs extends Base {

	Scenario scenario;
	LoginPage objLoginPage;
	DashboardPage objDashboardPage;

	@Before
	public void startApplication(Scenario scenario) {

		this.scenario = scenario;

	}

	@Given("^I log in with Admin user and I am at Dashboard Page$")
	public void i_log_in_with_Admin_user_and_I_am_at_Dashboard_Page() throws Throwable {

		scenario.write("Starting the browser and application");

		driver = initializeWebDriver();
		WaitMethods.staticWait(5000);

		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

		scenario.write("Logging in to the  application");
		objLoginPage = new LoginPage(driver, scenario);
		objLoginPage.login(ReadProperties.getAppUserName(), ReadProperties.getAppPassword());
		WaitMethods.staticWait(5000);

		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

		objDashboardPage = new DashboardPage(driver, scenario);
		Assert.assertEquals("Dashboard", objDashboardPage.getDashboardPageTitle());

	}

	@When("^I view the Time at work widget at Dashboard Page$")
	public void i_view_the_Time_at_work_widget_at_Dashboard_Page() throws Throwable {
		scenario.write("This step is covered in below step");
	}

	@Then("^I check below values from the widget showing correct values$")
	public void i_check_below_values_from_the_widget_showing_correct_values(DataTable timeatWorWidgetDataTable)
			throws Throwable {

		HashMap<String, String> expectedValuesMap = new HashMap<String, String>();

		expectedValuesMap.put("WidgetTitle", timeatWorWidgetDataTable.raw().get(1).get(1));
		expectedValuesMap.put("lastpunchedinTime", timeatWorWidgetDataTable.raw().get(2).get(1));
		expectedValuesMap.put("currentTime", timeatWorWidgetDataTable.raw().get(3).get(1));
		expectedValuesMap.put("CurrentWeekspan", timeatWorWidgetDataTable.raw().get(4).get(1));
		expectedValuesMap.put("TotalWeekHoursmins", timeatWorWidgetDataTable.raw().get(5).get(1));
		scenario.write("Expected Value Map: " + expectedValuesMap);
		scenario.write("Actual Value Map: " + objDashboardPage.getTimeatworwigetData());
		Assert.assertEquals(expectedValuesMap, objDashboardPage.getTimeatworwigetData());

	}

	@After
	public void closeApplication() {
		scenario.write("Closing the browser and application!");
		closeBrowser();
	}
}
