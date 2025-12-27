package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

public class ClaimsPage {

	WebDriver driver;
	Scenario scenario;
	// Page repository

	@FindBy(xpath = "//span[text()='Claim']")
	WebElement claimPageLink;
	@FindBy(xpath = "//a[text()='Submit Claim']")
	WebElement subMitClaimBUtton;
	@FindBy(xpath = "//label[text()='Event']/following::div[5]")
	WebElement eventDropdown;
	@FindBy(xpath = "//label[text()='Currency']/following::div[5]")
	WebElement currencyDropdown;
	@FindBy(xpath = "//button[text()=' Create ']")
	WebElement createClaimButton;
	@FindBy(xpath = "//h6[text()='Expenses']/following::button[1]")
	WebElement addExpenseButton;
	@FindBy(xpath = "//label[text()='Expense Type']/following::div[5]")
	WebElement expenseTypeDropdown;
	@FindBy(xpath = "//label[text()='Date']/following::input[1]")
	WebElement dateTextField;
	@FindBy(xpath = "//label[text()='Amount']/following::input[1]")
	WebElement amountTextField;
	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveButton;
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p']")
	WebElement totalAmount;

	// page class constructer

	public ClaimsPage(WebDriver driver, Scenario scenario) {

		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);

	}

	// page operation methods

	// navigate to claims page

	public void navigateToClaimsPage() {

		ElementActions.clickElement(driver, claimPageLink, scenario);
		WaitMethods.staticWait(5000);
	}

	// submit claim with event and currency

	public void submitClaim() {
		ElementActions.clickElement(driver, subMitClaimBUtton, scenario);
		WaitMethods.staticWait(2000);
		ElementActions.clickElement(driver, eventDropdown, scenario);
		WaitMethods.staticWait(2000);
		Actions objactions = new Actions(driver);
		objactions.sendKeys(Keys.ARROW_DOWN).build().perform();
		WaitMethods.staticWait(2000);
		objactions.sendKeys(Keys.ENTER).build().perform();
		WaitMethods.staticWait(2000);
		ElementActions.clickElement(driver, currencyDropdown, scenario);
		WaitMethods.staticWait(2000);
		objactions.sendKeys(Keys.ARROW_DOWN).build().perform();
		WaitMethods.staticWait(2000);
		objactions.sendKeys(Keys.ENTER).build().perform();
		WaitMethods.staticWait(2000);
		ElementActions.clickElement(driver, createClaimButton, scenario);
		WaitMethods.staticWait(5000);
	}

	// Add Expense with Type , Date and amount

	public void addExpense(String date, String amount) {

		ElementActions.clickElement(driver, addExpenseButton, scenario);
		ElementActions.clickElement(driver, expenseTypeDropdown, scenario);
		WaitMethods.staticWait(2000);
		Actions objactions = new Actions(driver);
		objactions.sendKeys(Keys.ARROW_DOWN).build().perform();
		WaitMethods.staticWait(2000);
		objactions.sendKeys(Keys.ENTER).build().perform();
		WaitMethods.staticWait(2000);

		ElementActions.sendKeys(driver, dateTextField, scenario, date);
		ElementActions.sendKeys(driver, amountTextField, scenario, amount);
		ElementActions.clickElement(driver, saveButton, scenario);

	}

	// Capture the total amount

	public String getTotlalAmount() {
		return ElementActions.getText(driver, totalAmount, scenario);
	}

}
