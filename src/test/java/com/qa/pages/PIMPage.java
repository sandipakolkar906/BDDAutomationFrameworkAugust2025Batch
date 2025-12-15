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

public class PIMPage {
	
	WebDriver driver;
	Scenario scenario;
	
	// page object repository
	
		@FindBy(xpath = "//span[text()='PIM']")
		WebElement pimPagelink;

		@FindBy(xpath = "//a[text()='Add Employee']")
		WebElement addempButton;

		@FindBy(xpath = "//button[text()=' Add ']")
		WebElement addButton;

		@FindBy(xpath = "//input[@name='firstName']")
		WebElement empFirstNamefield;

		@FindBy(xpath = "//input[@name='middleName']")
		WebElement empmiddleNamefield;

		@FindBy(xpath = "//input[@name='lastName']")
		WebElement empLasteNamefield;

		@FindBy(xpath = "//button[text()=' Save ']")
		WebElement saveButton;
		
		@FindBy(xpath = "//a[text()='Employee List']")
		WebElement empListButton;

		@FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
		WebElement empNameSearchField;

		@FindBy(xpath = "//button[text()=' Search ']")
		WebElement searchButton;

		@FindBy(xpath = "//div[@class='oxd-table-card']/descendant::div[1]/child::div[3]")
		WebElement searchedEmpName;

		@FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space']/child::i[@class='oxd-icon bi-pencil-fill']")
		WebElement editempButton;

		@FindBy(xpath = "//button/child::i[@class='oxd-icon bi-trash']")
		WebElement deleteBUtton;
		
		
		@FindBy(xpath = "//button[text()=' Yes, Delete ']")
		WebElement yesDeleteButton;
		
		
		// constructor
		
		public PIMPage(WebDriver driver, Scenario scenario) {

			this.driver = driver;
			this.scenario = scenario;
			PageFactory.initElements(driver, this);

		}

		//page operation methods
		
		/**
		 * This method will navigate to PIM page
		 */
		public void navigateToPIMPage() {

			ElementActions.clickElement(driver, pimPagelink, scenario);
			WaitMethods.staticWait(2000);

		}
		

		/**
		 *  This method will add employee
		 */
		public void navigateToAddEmployeePage() {

			ElementActions.clickElement(driver, addempButton, scenario);
			WaitMethods.staticWait(2000);

		}

		public void addnewEmp(String fName, String mName, String lName) {

			
			ElementActions.sendKeys(driver, empFirstNamefield, scenario, fName);
			ElementActions.sendKeys(driver, empmiddleNamefield, scenario, mName);
			ElementActions.sendKeys(driver, empLasteNamefield, scenario, lName);
			ElementActions.clickElement(driver, saveButton, scenario);
			WaitMethods.staticWait(5000);

		}
		
		

		/**
		 * Navigate to Employee Search screen
		 */
		public void navigateToEmpListPage() {

			ElementActions.clickElement(driver, empListButton, scenario);
			WaitMethods.staticWait(5000);
		}

	

		/**
		 * @param fName
		 * @param mName
		 * @return
		 * 
		 * This Method will search the Employee
		 */
		public String searchEmpbyFnameandMname(String fName, String mName) {

			ElementActions.sendKeys(driver, empNameSearchField, scenario, fName);

			Actions objactions = new Actions(driver);
			WaitMethods.staticWait(5000);
			objactions.sendKeys(Keys.ARROW_DOWN).build().perform();
			WaitMethods.staticWait(2000);
			objactions.sendKeys(Keys.ENTER).build().perform();
			WaitMethods.staticWait(2000);
			ElementActions.clickElement(driver, searchButton, scenario);
			WaitMethods.staticWait(2000);
			return ElementActions.getText(driver, searchedEmpName, scenario);
		}
		
		/**
		 * @param texttoUpendtoFName
		 * @param texttoAppendToMname
		 * @param texttoAppendtoLastName
		 * 
		 * This Method will edit the employee information
		 */
		
		public void editEmp(String texttoUpendtoFName, String texttoAppendToMname, String texttoAppendtoLastName) {

			ElementActions.clickElement(driver, editempButton, scenario);
			WaitMethods.staticWait(5000);
			ElementActions.sendKeys(driver, empFirstNamefield, scenario, texttoUpendtoFName);
			ElementActions.sendKeys(driver, empmiddleNamefield, scenario, texttoAppendToMname);
			ElementActions.sendKeys(driver, empLasteNamefield, scenario, texttoAppendtoLastName);
			WaitMethods.staticWait(5000);
			ElementActions.clickElement(driver, saveButton, scenario);
		}


		/**
		 * This Method will delete the employee
		 */
		public void deleteEmp() {
			ElementActions.clickElement(driver, deleteBUtton, scenario);
			WaitMethods.staticWait(2000);
			ElementActions.clickElement(driver, yesDeleteButton, scenario);
		}
		
		
		
}