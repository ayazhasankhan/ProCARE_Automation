package com.proCare.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.proCare.utils.selenium.WebUtils;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//div[@id='page-content']//h1")
	private WebElement HomePageHeading;
	private WebUtils webUtils;

	public HomePage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean isHomeGroupPageHeading() {
		return webUtils.isElementDisplayed(HomePageHeading);
	}
}
