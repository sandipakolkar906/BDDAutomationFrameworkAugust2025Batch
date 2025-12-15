package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

/**
 * @author Punam
 * This is page factory class which has repo, constructor and operation methods
 */
public class LoginPage {
	
	WebDriver driver ;
	Scenario scenario;

	// page object repository 
	// elements located by @FindByannotation and Xpath
		
		@FindBy(xpath="//input[@name='username']")
		WebElement userNameField;
		
		@FindBy(xpath="//input[@name='password']")
		WebElement passwordField;
		
		@FindBy(xpath="//button[text()=' Login ']")
		WebElement loginButton;
		
		@FindBy(xpath="//h6[text()='Dashboard']")
		WebElement titleOfHomePage;
		
	//Page class Constructor
		
		public LoginPage(WebDriver driver, Scenario scenario){
			
			this.driver=driver;
			this.scenario=scenario;
			PageFactory.initElements(driver, this);
			
		}
			
			/**
			 * @param userName
			 * @param password
			 * @return This method will accept user name and password and after log in it will 
			 * 			return the logged in home page title
			 */
		
			public String login(String userName, String password) {
				WaitMethods.staticWait(2000);
				ElementActions.sendKeys(driver, userNameField, scenario, userName);
				ElementActions.sendKeys(driver, passwordField, scenario, password);
				ElementActions.clickElement(driver, loginButton, scenario);
				WaitMethods.staticWait(2000);
				return ElementActions.getText(driver, titleOfHomePage, scenario);
			}
		}


