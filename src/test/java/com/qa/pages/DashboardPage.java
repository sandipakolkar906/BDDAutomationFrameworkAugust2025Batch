package com.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;

import cucumber.api.Scenario;

/**
 * @author Admin
 *
 */
public class DashboardPage {

	// page object repo+ constructer + page operation methods

	WebDriver driver;
	Scenario scenario;

	// page object repo

	@FindBy(xpath = "//span[@class='oxd-topbar-header-breadcrumb']/child::h6[1]")
	WebElement dashboardPageTitle;

	@FindBy(xpath = "//p[text()='Time at Work']")
	WebElement timeatWorkWidgetTitle;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-attendance-card-state']")
	WebElement lastPunchedinTime;

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span orangehrm-attendance-card-fulltime']")
	WebElement currentTimeofSystem;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-attendance-card-fulltime']")
	WebElement totalWeekHours;

	@FindBy(xpath = "//p[text()='This Week']/following-sibling::p[1]")
	WebElement currentWeekSpan;

	// constructer

	/**
	 * @param driver
	 * @param scenario
	 */
	public DashboardPage(WebDriver driver, Scenario scenario) {

		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);

	}

	// page operation methods

	/**
	 * @return
	 */

	public String getDashboardPageTitle() {
		return ElementActions.getText(driver, dashboardPageTitle, scenario);
	}

	/**
	 * @return this method will capture all time at work widget data in a map
	 *         and return a map
	 */
	public HashMap<String, String> getTimeatworwigetData() {

		HashMap<String, String> timeWidgetDataMap = new HashMap();
		timeWidgetDataMap.put("WidgetTitle", ElementActions.getText(driver, timeatWorkWidgetTitle, scenario));
		timeWidgetDataMap.put("lastpunchedinTime", ElementActions.getText(driver, lastPunchedinTime, scenario));
		timeWidgetDataMap.put("currentTime", ElementActions.getText(driver, currentTimeofSystem, scenario));
		timeWidgetDataMap.put("CurrentWeekspan", ElementActions.getText(driver, currentWeekSpan, scenario));
		timeWidgetDataMap.put("TotalWeekHoursmins", ElementActions.getText(driver, totalWeekHours, scenario));
		return timeWidgetDataMap;

	}

}
