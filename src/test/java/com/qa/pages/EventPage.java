package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

public class EventPage {
	
	WebDriver driver;
	
	Scenario scenario;
	
	//page object repo 
	
	@FindBy(xpath="//span[text()='Configuration ']")
	WebElement configMenu;
	@FindBy(xpath="//a[text()='Events']")
	WebElement eventsOption;
	@FindBy(xpath="//button[text()=' Add ']")
	WebElement addButton;
	@FindBy(xpath="//label[text()='Event Name']/following::input[1]")
	WebElement evenetNameField ;
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;	
	@FindBy(xpath="//button[text()=' Search ']")
	WebElement searchEvent;
	@FindBy(xpath="//div[@class='oxd-table-card']/descendant::div[5]")
	WebElement searchedEventNameinTable;
	@FindBy(xpath="//button/following::i[@class='oxd-icon bi-pencil-fill']")
	WebElement editEventButton;
	@FindBy(xpath="//button/i[@class='oxd-icon bi-trash']")
	WebElement deleteEventButton;
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	WebElement deleteConfirmButton;
	
	
	// page class constructer
	
	public EventPage(WebDriver driver, Scenario scenario) {

		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);

	}
	//Page operation methods 
	
	public void navigateToConfigurationMenu(){
		
		ElementActions.clickElement(driver, configMenu, scenario);
	}
	
	
	public void NaviagteToEventOption(){
		ElementActions.clickElement(driver, eventsOption, scenario);
	}

	public void  createNewEvent(String eventName){
		
		ElementActions.clickElement(driver, addButton, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, evenetNameField, scenario, eventName);
		ElementActions.clickElement(driver, saveButton, scenario);
		
	}
	
	
	public String searchEventByName(String eventName){
		ElementActions.sendKeys(driver, evenetNameField, scenario, eventName);
		ElementActions.clickElement(driver, searchEvent, scenario);
		
		return ElementActions.getText(driver, searchedEventNameinTable, scenario);
	}
	
	
	public void editEventName(String textToAppend){
		
		ElementActions.clickElement(driver, editEventButton, scenario);
		ElementActions.sendKeys(driver, evenetNameField, scenario, textToAppend);
		ElementActions.clickElement(driver, saveButton, scenario);
	}

	public void deleteEvent(){
		ElementActions.clickElement(driver, deleteEventButton, scenario);
		ElementActions.clickElement(driver, deleteConfirmButton, scenario);
	}
	
}
