package com.qa.stepdefinations;


import com.qa.base.Base;
import com.qa.pages.BuzzPage;
import com.qa.pages.LoginPage;
import com.qa.util.CaptureScreenshot;
import com.qa.util.GetSystemDateandTime;
import com.qa.util.ReadProperties;
import com.qa.util.WaitMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BuzzCRUDSteps extends Base {

	Scenario scenario;
	LoginPage objLoginPage;
	BuzzPage objBuzzPage;

	@Before
	public void startApplication(Scenario scenario) {

		this.scenario = scenario;

	}

	@Given("^Navigate to BUzz after log in with Admin user$")
	public void navigate_to_BUzz_after_log_in_with_Admin_user() throws Throwable {

		scenario.write("Starting the browser and application");

		driver = initializeWebDriver();
		WaitMethods.staticWait(5000);

		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

		scenario.write("Logging in to the  application");
		objLoginPage = new LoginPage(driver, scenario);
		objLoginPage.login(ReadProperties.getAppUserName(), ReadProperties.getAppPassword());
		WaitMethods.staticWait(5000);

		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
		scenario.write("navigating to BuzzPage");
		objBuzzPage = new BuzzPage(driver, scenario);
		objBuzzPage.navigateToBuzzPage();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

	}

	@When("^Post the comment as \"([^\"]*)\"$")
	public void post_the_comment_as(String commenttoPost) throws Throwable {
		scenario.write("Posting the comment to BuzzPage");
		objBuzzPage.postComment(commenttoPost);
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

	}

	@Then("^verify that comment time user and comment text is posted correctly as \"([^\"]*)\"$")
	public void verify_that_comment_time_user_and_comment_text_is_posted_correctly_as(String expectedCommentText)
			throws Throwable {

		scenario.write("verifying comment text and time ");

		Assert.assertEquals(expectedCommentText, objBuzzPage.getCommenttextandTime().get("commentText"));
		Assert.assertEquals(GetSystemDateandTime.getCurrentDateandTime(),
				objBuzzPage.getCommenttextandTime().get("commentTime"));
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

	}

	@When("^I click on like$")
	public void i_click_on_like() throws Throwable {
		scenario.write("liking the comment");
		objBuzzPage.LikeComment();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^I verify the like count is updated as Expected count \"([^\"]*)\"$")
	public void i_verify_the_like_count_is_updated_as_Expected_count(String expectedLikecount) throws Throwable {

		scenario.write("verifying the like count");
		String actuallikeCount = objBuzzPage.getLikeCount().split(" ")[0];

		Assert.assertEquals(expectedLikecount, actuallikeCount);
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");

	}

	@When("^I Edit the post with updated comment\"([^\"]*)\"$")
	public void i_Edit_the_post_with_updated_comment(String textToAppend) throws Throwable {
		scenario.write("Editing the Post");
		objBuzzPage.editPost(textToAppend);
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@Then("^I verify that updated comment\"([^\"]*)\"$")
	public void i_verify_that_updated_comment(String arg1) throws Throwable {
		scenario.write(" ingnoring  step");
	}

	@Then("^I delete the Post$")
	public void i_delete_the_Post() throws Throwable {
		scenario.write("Deleting  the Post");
		objBuzzPage.deletePost();
		WaitMethods.staticWait(5000);
		scenario.embed(CaptureScreenshot.captureImage(driver), "image/png");
	}

	@After
	public void closeApplication() {
		scenario.write("Closing the browser and application!");
		closeBrowser();
	}
}
