package com.proCare.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.proCare.utils.selenium.WebUtils;

public class LoginPage {
	
	@FindBy(name = "username")
	private WebElement usernameInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;
	
	@FindBy(css = "button[type='submit']")
	private WebElement login;

	private WebUtils webUtils;

	public LoginPage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String username) {
		webUtils.enterText(usernameInput, username);
	}
	
	public void enterPassword(String password) {
		webUtils.enterText(passwordInput, password);
	}
	
	public void clickOnLoginButton() {
		webUtils.click(login);
	}


}
