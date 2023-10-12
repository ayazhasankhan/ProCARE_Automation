package com.proCare.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proCare.utils.common.CommonUtils;
import com.proCare.utils.selenium.WebUtils;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//div[@id='page-content']//h1")
	private WebElement HomePageHeading;
	private WebUtils webUtils;
	CommonUtils common;

	public HomePage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		common = new CommonUtils();
		PageFactory.initElements(driver, this);
	}

	public boolean isHomeGroupPageHeading() throws Exception {
		common.hardWaitFor(6000);
		return webUtils.isElementDisplayed(HomePageHeading);
	}
}
