package com.qa.pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;

/**
 * @author Admin
 * 
 *         This oage has page operation methods for buzz page test automation
 *
 */
public class BuzzPage {

	WebDriver driver;
	Scenario scenario;

	// page object repository

	@FindBy(xpath = "//span[text()='Buzz']")

	WebElement buzzPagelink;

	@FindBy(xpath = "//textarea[@class='oxd-buzz-post-input']")

	WebElement buzzTextfield;

	@FindBy(xpath = "//button[text()=' Post ']")

	WebElement postButton;
	
	@FindBy(xpath = "//p[text()='Edit Post']/following::button[text()=' Post ']")

	WebElement editandpostButton;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-body-text']")

	WebElement commentText;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-buzz-post-time']")

	WebElement commentTime;

	@FindBy(xpath = "//div[@class='orangehrm-buzz-post-actions']/child::div[1]")

	WebElement heartIcon;

	@FindBy(xpath = "//i[@class='oxd-icon bi-heart-fill orangehrm-buzz-stats-like-icon']/following-sibling::p[@class='oxd-text oxd-text--p orangehrm-buzz-stats-active']")

	WebElement likeCount;

	@FindBy(xpath = "//i[@class='oxd-icon bi-three-dots']")

	WebElement threedotsButton;

	@FindBy(xpath = "//p[text()='Edit Post']")

	WebElement editPostButton;
	
	

	@FindBy(xpath = "//p[text()='Edit Post']/following::textarea[1]")

	WebElement editpostfield;

	@FindBy(xpath = "//p[text()='Delete Post']")

	WebElement deletePostButton;

	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	WebElement yesDeleteButton;

	// page class constructer

	/**
	 * @param driver
	 * @param scenario
	 * 
	 *            This is a constructer of this class
	 */
	public BuzzPage(WebDriver driver, Scenario scenario) {

		this.driver = driver;
		this.scenario = scenario;
		PageFactory.initElements(driver, this);

	}

	// page operation methods

	public void navigateToBuzzPage() {

		ElementActions.clickElement(driver, buzzPagelink, scenario);

	}

	public void postComment(String commenttoPost) {

		WaitMethods.staticWait(2000);
		ElementActions.sendKeys(driver, buzzTextfield, scenario, commenttoPost);
		WaitMethods.staticWait(2000);
		ElementActions.clickElement(driver, postButton, scenario);
		WaitMethods.staticWait(5000);
	}

	public HashMap getCommenttextandTime() {
		WaitMethods.staticWait(2000);
		HashMap<String, String> objmap = new HashMap<String, String>();

		objmap.put("commentText", ElementActions.getText(driver, commentText, scenario));
		objmap.put("commentTime", ElementActions.getText(driver, commentTime, scenario));

		return objmap;

	}

	public void LikeComment() {

		ElementActions.clickElement(driver, heartIcon, scenario);
		WaitMethods.staticWait(2000);
	}

	public String getLikeCount() {
		return ElementActions.getText(driver, likeCount, scenario);
	}

	public void editPost(String textToappend) {
		ElementActions.clickElement(driver, threedotsButton, scenario);
		WaitMethods.staticWait(2000);
		ElementActions.clickElement(driver, editPostButton, scenario);
		WaitMethods.staticWait(2000);
		ElementActions.sendKeys(driver, editpostfield, scenario, textToappend);
		WaitMethods.staticWait(5000);
		ElementActions.clickElement(driver, editandpostButton, scenario);
		WaitMethods.staticWait(5000);
	}

	public void deletePost() {
		ElementActions.clickElement(driver, threedotsButton, scenario);
		WaitMethods.staticWait(2000);
		ElementActions.clickElement(driver, deletePostButton, scenario);
		WaitMethods.staticWait(2000);
		ElementActions.clickElement(driver, yesDeleteButton, scenario);
	}

}
