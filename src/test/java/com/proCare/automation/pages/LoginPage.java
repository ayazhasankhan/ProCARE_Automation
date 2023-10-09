package com.proCare.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proCare.utils.common.Config;
import com.proCare.utils.selenium.WebUtils;

public class LoginPage {

	@FindBy(name = "username")
	private WebElement emailInputBox;

	@FindBy(name = "password")
	private WebElement passwordInputBox;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement signInButton;

	@FindBy(xpath = "//*[text()='Remember me']/../../../div[3]")
	private WebElement Ele_LoginErrorMsg;

	@FindBy(xpath = "//div[text()='Please enter username']")
	private WebElement Ele_Username_Blank_Error;

	@FindBy(xpath = "//div[text()='Please enter password']")
	private WebElement Ele_Password_Blank_Error;

	WebDriver driver;
	private WebUtils webUtils;
	WebDriverWait wait;
	LoginPage loginPage;

	public LoginPage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void login() {
		String password = System.getenv("EVRA_PASSWORD") != null ? System.getenv("EVRA_PASSWORD")
				: Config.getProperty("EVRA_PASSWORD");
		webUtils.enterText(emailInputBox, Config.getProperty("EVRA_EMAIL"));
		webUtils.enterText(passwordInputBox, password);
		webUtils.click(signInButton);
	}

	public void enterUsername(String username) {
		webUtils.elementWaitUntilDisplayed(emailInputBox);
		webUtils.enterText(emailInputBox, username);
	}

	public void enterPassword(String password) {
		webUtils.elementWaitUntilDisplayed(passwordInputBox);
		webUtils.enterText(passwordInputBox, password);
	}

	public void clickSignnInButton() {
		webUtils.elementWaitUntilDisplayed(signInButton);
		webUtils.click(signInButton);
	}

	public String invalidUsernamePasswordErrorMessage() {
		webUtils.elementWaitUntilDisplayed(Ele_LoginErrorMsg);
		return webUtils.getText(Ele_LoginErrorMsg);
	}

	public String blankUsernameErrorMessage() {
		webUtils.elementWaitUntilDisplayed(Ele_Username_Blank_Error);
		return webUtils.getText(Ele_Username_Blank_Error);
	}

	public String blankPasswordErrorMessage() {
		webUtils.elementWaitUntilDisplayed(Ele_Password_Blank_Error);
		return webUtils.getText(Ele_Password_Blank_Error);
	}

//	public void elementWaitUntilDisplayed(WebDriver driver, WebElement ele) {
//		wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOf(ele));
//	}

}
