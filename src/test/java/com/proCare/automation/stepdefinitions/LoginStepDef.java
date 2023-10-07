package com.proCare.automation.stepdefinitions;


import com.proCare.automation.pages.LoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginStepDef {
	
	LoginPage loginPage;
	
	@Before
	public void setUp() {
		loginPage = new LoginPage(BaseStep.getDriver());
	}
	
	@When("User enter the username as {string}")
	public void user_enter_the_username_as(String string) {
		loginPage.enterUserName(string);
	}
	
	@Given("User enter the password as {string}")
	public void user_enter_the_password_as(String string) {
		loginPage.enterPassword(string);
	}
	
	@When("User click on the login button")
	public void user_click_on_the_login_button() {
		loginPage.clickOnLoginButton();
	}
	
	@Then("Login should be success")
	public void login_should_be_success() {

	}
}
