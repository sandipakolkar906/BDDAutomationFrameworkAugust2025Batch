package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

public class RecruitmentPage {

	WebDriver driver;
	Scenario scenario;

	// page object repo

	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitmentPageLink;
	@FindBy(xpath = "//a[text()='Candidates']")
	WebElement candidatesOption;
	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addcandidateButton;
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement fNameField;
	@FindBy(xpath = "//input[@name='middleName']")
	WebElement mNameField;
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lNameField;
	@FindBy(xpath = "//label[text()='Email']/following::input[1]")
	WebElement emailField;
	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='oxd-table-card']/child::div[1]/child::div[5]/child::div[1]")
	WebElement dateOfApplication;
	@FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
	WebElement deleteCandidateButton;
	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	WebElement deleteCOnfirmationButton;
	@FindBy(xpath = "//h6[text()='Recruitment']")
	WebElement recruitmentPageTitle;

	// page class constructer

	public RecruitmentPage(WebDriver driver, Scenario scenario) {

		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);

	}

	// page operation methods

	/**
	 * @return
	 */
	public String navigateToRecruitmentPage() {

		ElementActions.clickElement(driver, recruitmentPageLink, scenario);

		return ElementActions.getText(driver, recruitmentPageTitle, scenario);
	}

	/**
	 * @param fName
	 * @param mName
	 * @param lName
	 * @param eMail
	 */
	public void addnewCandidate(String fName, String mName, String lName, String eMail) {

		ElementActions.clickElement(driver, candidatesOption, scenario);
		ElementActions.clickElement(driver, addcandidateButton, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, fNameField, scenario, fName);
		ElementActions.sendKeys(driver, mNameField, scenario, mName);
		ElementActions.sendKeys(driver, lNameField, scenario, lName);
		ElementActions.sendKeys(driver, emailField, scenario, eMail);
		ElementActions.clickElement(driver, saveButton, scenario);
	}

	/**
	 * @return
	 */
	public String getCandidateApplicationDate() {
		ElementActions.clickElement(driver, candidatesOption, scenario);
		WaitMethods.staticWait(5000);
		return ElementActions.getText(driver, dateOfApplication, scenario);

	}

	public void deleteCandidate() {
		ElementActions.clickElement(driver, deleteCandidateButton, scenario);
		ElementActions.clickElement(driver, deleteCOnfirmationButton, scenario);
	}

}
