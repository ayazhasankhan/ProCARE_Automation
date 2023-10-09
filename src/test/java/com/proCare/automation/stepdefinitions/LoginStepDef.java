package com.proCare.automation.stepdefinitions;

import org.testng.Assert;

import com.proCare.automation.pages.HomePage;
import com.proCare.automation.pages.LoginPage;
import com.proCare.utils.common.Config;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	LoginPage loginPage;
	HomePage homePage;

	@Given("Launch ProCare application")
	public void launch_pro_care_application() {
		loginPage = new LoginPage(BaseStep.getDriver());
		homePage = new HomePage(BaseStep.getDriver());
	}

	/**
	 * TC_LF_001 Validate logging into the Application using valid credentials
	 */
	@Given("User allow to enter username")
	public void user_allow_to_enter_username() {
		loginPage.enterUsername(Config.getProperty("Username"));
	}

	@Given("User allow to enter password")
	public void user_allow_to_enter_password() {
		loginPage.enterPassword(Config.getProperty("Password"));
	}

	@Given("Click on sigin button")
	public void click_on_sigin_button() {
		loginPage.clickSignnInButton();
	}

	@Then("User should land on home page successfully")
	public void user_should_land_on_home_page_successfully() {
		Assert.assertEquals(homePage.isHomeGroupPageHeading(), true);
	}

	/**
	 * TC_LF_002 Validate logging into the Application using invalid credentials
	 * (i.e. Invalid email address and Invalid Password)
	 */
	@When("User allow to enter {string} invalid username")
	public void user_allow_to_enter_invalid_username(String invalid_Username) {
		loginPage.enterUsername(invalid_Username);
	}

	@When("User allow to enter {string} invalid password")
	public void user_allow_to_enter_invalid_password(String invalid_Password) {
		loginPage.enterPassword(invalid_Password);
	}

	@Then("Warning message with the text {string} should be displayed")
	public void warning_message_with_the_text_should_be_displayed(String errorMsg) {
		Assert.assertEquals(loginPage.invalidUsernamePasswordErrorMessage(), errorMsg);
	}
	@Then("Warning message with the text {string} and {string} should be displayed")
	public void warning_message_with_the_text_and_should_be_displayed(String username_Error, String password_Error) {
		Assert.assertEquals(loginPage.blankUsernameErrorMessage(), username_Error);
		Assert.assertEquals(loginPage.blankPasswordErrorMessage(), password_Error);
	}
}
