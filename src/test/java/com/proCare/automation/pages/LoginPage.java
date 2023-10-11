package com.proCare.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

	@FindBy(xpath = "//a[text()='Forgot Password ?']")
	private WebElement Ele_Forgot_Password;

	@FindBy(id = "rememberme")
	private WebElement ele_remembermeCheckBox;

	@FindBy(xpath = "//label[@for='rememberme']")
	private WebElement ele_remembermeCheckBox_Text;

	WebDriver driver;
	private WebUtils webUtils;
	WebDriverWait wait;
	LoginPage loginPage;

	public LoginPage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public void login() {
		String username = Config.getProperty("Username");
		String password = Config.getProperty("Password");
		this.enterUsername(username);
		this.enterPassword(password);
		this.clickSignnInButton();
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

	public boolean isUsernameAndPasswordOptionsDisplayed() {
		boolean flag = false;
		try {
			webUtils.isElementDisplayed(emailInputBox);
			webUtils.isElementDisplayed(passwordInputBox);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public String getUsernamePlaceHolderText() {
		String username_txt = webUtils.getTextUsingAttribute(emailInputBox, "placeholder");
		return username_txt;
	}

	public String getPasswordPlaceHolderText() {
		String pass_txt = webUtils.getTextUsingAttribute(passwordInputBox, "placeholder");
		return pass_txt;
	}

	public boolean isPasswordLinkDisplayed() {
		boolean flag = false;
		try {
			webUtils.isElementDisplayed(Ele_Forgot_Password);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isCheckBoxEnableDisplayed() {
		boolean flag = false;
		try {
			webUtils.isElementDisplayed(ele_remembermeCheckBox);
			webUtils.isElementEnabled(ele_remembermeCheckBox);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public String rememberMeCheckBoxText() {
		webUtils.elementWaitUntilDisplayed(ele_remembermeCheckBox_Text);
		return webUtils.getText(ele_remembermeCheckBox_Text);
	}

	public boolean isAbleToCheckedRememberMeFunctionality() {
		boolean flag = false;
		try {
			webUtils.click(ele_remembermeCheckBox);
			String Checked = webUtils.getTextUsingAttribute(ele_remembermeCheckBox, "value");
			Assert.assertEquals(Checked, "true");
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isAbleToUnCheckedRememberMeFunctionality() {
		boolean flag = false;
		try {
			webUtils.click(ele_remembermeCheckBox);
			String UnChecked = webUtils.getTextUsingAttribute(ele_remembermeCheckBox, "value");
			Assert.assertEquals(UnChecked, "false");
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
