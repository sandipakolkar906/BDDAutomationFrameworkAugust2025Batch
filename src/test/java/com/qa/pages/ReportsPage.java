package com.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

/**
 * @author Admin
 *
 */
/**
 * @author Admin
 *
 */
public class ReportsPage {
	
	WebDriver driver;
	Scenario scenario;

	//page object repo
	
	
	@FindBy(xpath="//a[text()='Reports']")
	WebElement reportsPageLink;
	@FindBy(xpath="//button[text()=' Add ']")
	WebElement addReportButton;
	@FindBy(xpath="//label[text()='Select Display Field Group']/following::i[1]")
	WebElement fieldGroupDropDownArrow;
	@FindBy(xpath="//label[text()='Select Display Field']/following::i[1]")
	WebElement fieldDropdwonArrow;
	@FindBy(xpath="//label[text()='Select Display Field']/following::button[@class='oxd-icon-button orangehrm-report-icon']")
	WebElement plusbuttontoaddField;
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;
	@FindBy(xpath="//label[text()='Report Name']/following::input[1]")
	WebElement reportNameField;
	
	
	@FindBy(xpath="//div[@class='oxd-table-card']/child::div[1]/child::div[2]")
	WebElement searchedReportName;
	@FindBy(xpath="//button[@class='oxd-icon-button oxd-table-cell-action-space']/child::i[@class='oxd-icon bi-file-text-fill']")
	WebElement generateReportButton;
	@FindBy(xpath="//div[@class='header-rgRow actual-rgRow']/child::div[1]/child::div[1]")
	WebElement field1;
	
	@FindBy(xpath="//div[@class='header-rgRow actual-rgRow']/child::div[2]/child::div[1]")
	WebElement field2;
	
	@FindBy(xpath="//div[@class='header-rgRow actual-rgRow']/child::div[3]/child::div[1]")
	WebElement field3;
	@FindBy(xpath="//button[text()=' Search ']")
	WebElement searchReportButton;
	
	//page class constructer 
	

	public ReportsPage(WebDriver driver, Scenario scenario) {

		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);

	}
	
	
	//page operation methods 
	
	
	/**
	 * 
	 */
	public void navigateToReportsPage(){
		
		ElementActions.clickElement(driver, reportsPageLink, scenario);
	}
	
	/**
	 * @param reportName
	 */
	public void addnewCustomReport(String reportName){
		
		ElementActions.clickElement(driver, addReportButton, scenario);
		WaitMethods.staticWait(5000);
		ElementActions.sendKeys(driver, reportNameField, scenario, reportName);
		
		WaitMethods.staticWait(2000);
		
		ElementActions.clickElement(driver, fieldGroupDropDownArrow, scenario);
		
		Actions objactions= new Actions(driver);
	
		objactions.sendKeys(Keys.ARROW_DOWN).build().perform();
		WaitMethods.staticWait(2000);
		objactions.sendKeys(Keys.ENTER).build().perform();
		WaitMethods.staticWait(2000);
		
		for( int i=1;i<=3;i++){
			WaitMethods.staticWait(2000);
			ElementActions.clickElement(driver, fieldDropdwonArrow, scenario);
			WaitMethods.staticWait(2000);
			objactions.sendKeys(Keys.ARROW_DOWN).build().perform();
			WaitMethods.staticWait(2000);
			objactions.sendKeys(Keys.ENTER).build().perform();
			WaitMethods.staticWait(2000);
			ElementActions.clickElement(driver,plusbuttontoaddField , scenario);
			WaitMethods.staticWait(2000);
		}
		
		ElementActions.clickElement(driver, saveButton, scenario);
		WaitMethods.staticWait(5000);
	}
	
	
	public String searchReport(String reportName){
		Actions objactions= new Actions(driver);
		ElementActions.sendKeys(driver, reportNameField, scenario, reportName);
		//objactions.sendKeys(Keys.ARROW_DOWN).build().perform();
		//WaitMethods.staticWait(2000);
		//objactions.sendKeys(Keys.ENTER).build().perform();
		WaitMethods.staticWait(2000);
		ElementActions.clickElement(driver,searchReportButton , scenario);
		WaitMethods.staticWait(2000);
		return ElementActions.getText(driver, searchedReportName, scenario);
		
	
	}
	
	
	public void generateReport(){
		ElementActions.clickElement(driver,generateReportButton , scenario);
		WaitMethods.staticWait(5000);
	}
	
	public HashMap<String,String> getreportFields(){
		
		
		
		HashMap<String,String> reportFieldMap= new HashMap<String,String>();
		reportFieldMap.put("field1", ElementActions.getText(driver, field1, scenario));
		reportFieldMap.put("field2", ElementActions.getText(driver, field2, scenario));
		reportFieldMap.put("field3", ElementActions.getText(driver, field3, scenario));
		
		return reportFieldMap;
		
	}
	
	
	
}
