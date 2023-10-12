package com.proCare.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.proCare.utils.common.CommonUtils;
import com.proCare.utils.common.DateUtils;
import com.proCare.utils.selenium.WebUtils;

/**
 * 
 * @author Mohammad.Arif
 *
 */
public class SpecialityPage {

	@FindBy(name = "username")
	private WebElement emailInputBox;

	@FindBy(name = "password")
	private WebElement passwordInputBox;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement signInButton;

	@FindBy(xpath = "//div[@id='page-content']//h1")
	private WebElement Ele_HomePageHeading;

	@FindBy(xpath = "//nav[@class='NavContainer']/ul/li/a/i[@class='fas nav_icon_organization']")
	private WebElement Ele_Organization_Icon;

	@FindBy(xpath = "//nav[@class='NavContainer Hover']/ul/li/ul/li/a/span[text()='SPECIALTY']")
	private WebElement Ele_Speciality_Button;

	@FindBy(xpath = "//div[@class='Main specialitypage']/div/div/div/div/h1")
	private WebElement Ele_SpecialityPage_Heading;

	@FindBy(xpath = "//div[@id='content-speciality-grid']/ul/li[2]/div/a[text()=' Add New Specialty']")
	private WebElement Ele_AddNewSpecialty_Button;

	@FindBy(xpath = "//span[text()='Add New Specialty']")
	private WebElement Ele_AddNewSpeciality_Section;

	@FindBy(name = "in_specialty_name")
	private WebElement Ele_SpecialtyName_Input;

	@FindBy(name = "in_specialty_desc")
	private WebElement Ele_Description_Input;

	@FindBy(name = "in_region_name")
	private WebElement Ele_RegionName_Input;

	@FindBy(xpath = "//div[@class='k-form-buttons']/button[text()='Save']")
	private WebElement Ele_Save_Button;

	@FindBy(xpath = "(//table[@role='presentation'])[2]/tbody/tr/td[1]/span")
	private WebElement Ele_SpecialityName_Text;

	@FindBy(xpath = "//div[@id='content-speciality-grid']/ul/li[@class='hoverMenu']")
	private WebElement Ele_ThreeDot_Menu;

	@FindBy(xpath = "//div[@id='content-speciality-grid']/ul/li[@class='hoverMenu']//span[text()='Delete Selected Rows']")
	private WebElement Ele_DeleteSelectedRows_Button;

	@FindBy(xpath = "//div[@id='content-speciality-grid']/ul/li/button[text()='Save']")
	private WebElement Ele_HeaderSave_Button;

	@FindBy(xpath = "//div[@id='content-speciality-grid']/ul/li/button[text()='Cancel']")
	private WebElement Ele_HeaderCancel_Button;

	@FindBy(xpath = "//div[text()='Are you sure you want to delete this record?']")
	private WebElement Ele_DeleteDialogBox_Section;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement Ele_DeleteYES_Buton;

	@FindBy(xpath = "(//span[@class='k-icon k-i-more-vertical'])[1]")
	private WebElement Ele_GridThreeDot_Menu;

	@FindBy(xpath = "//div[@class='k-filter-menu-container']/span/span/span[text()='Contains']")
	private WebElement Ele_Contains_Option;

	@FindBy(xpath = "(//div[@class='k-popup k-child-animation-container k-slide-down-enter k-slide-down-enter-active'])[2]/div/ul/li[text()='Is equal to']")
	private WebElement Ele_EqualTo_Option;

	@FindBy(xpath = "//div[@class='k-filter-menu-container']//input")
	private WebElement Ele_FilterInput_1;
	

	@FindBy(xpath = "//div[@class='k-filter-menu-container']/div/button[text()='Filter']")
	private WebElement Ele_Filter_Button;
	

	@FindBy(xpath = "//*[text()='No records available']")
	private WebElement Ele_NoDataFound_Message;
	
	@FindBy(xpath = "(//table[@role='presentation']/tbody/tr)[1]")
	private WebElement Ele_First_Row;
	
	@FindBy(xpath = "(//table[@role='presentation']/tbody/tr)[1]/td[1]")
	private WebElement Ele_First_Cell;
	
	@FindBy(xpath = "(//table[@role='presentation']/tbody/tr)[1]/td[1]/input")
	private WebElement Ele_FirstCell_InputBox;
	
	@FindBy(xpath = "//div[@id='content-speciality-grid']/ul/li/button[text()='Save']")
	private WebElement Ele_Header_Save_Button;
	
	
	
	

	WebDriver driver;
	private WebUtils webUtils;
	public String dynaminNumber = null;
	public String specialityName_val,UpdatedspecialityName_val;
	WebDriverWait wait;
	SpecialityPage loginPage;
	DateUtils dateUtils;
	CommonUtils common;

	public SpecialityPage(WebDriver driver) {
		webUtils = new WebUtils(driver);
		dateUtils = new DateUtils();
		common = new CommonUtils();
		PageFactory.initElements(driver, this);
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

	public boolean performMouseHoverOrganization() {
		boolean flag = false;
		try {
			webUtils.mouseHoverUsingJs(Ele_Organization_Icon);
			flag = true;
		} catch (Exception e) {
			flag = false;

		}
		return flag;
	}

	public boolean checkSpecialityOptionDisplayed() {
		boolean flag = false;
		try {
			webUtils.isElementDisplayed(Ele_Speciality_Button);
			flag = true;
		} catch (Exception e) {
			flag = false;

		}
		return flag;
	}

	public void clickOnSpaciality() {
		webUtils.jsClick(Ele_Speciality_Button);
	}

	public boolean verifySpecialityPageDisplayed() {
		boolean flag = false;
		try {
			webUtils.isElementDisplayed(Ele_SpecialityPage_Heading);
			flag = true;
		} catch (Exception e) {
			flag = false;

		}
		return flag;
	}

	public void clickAddNewSpacialityButton() {
		webUtils.jsClick(Ele_AddNewSpecialty_Button);
	}

	public boolean verifyAddNewSectionDisplayed() {
		boolean flag = false;
		try {
			webUtils.isElementDisplayed(Ele_AddNewSpeciality_Section);
			flag = true;
		} catch (Exception e) {
			flag = false;

		}
		return flag;
	}

	public String enterSpecialityName(String name) {
		specialityName_val = name + dateUtils.generateRandomNoInDateAndTime();
		webUtils.enterText(Ele_SpecialtyName_Input, name + dateUtils.generateRandomNoInDateAndTime());
		return specialityName_val;
	}

	public void enterDescription(String desc) {
		webUtils.enterText(Ele_Description_Input, desc + dateUtils.generateRandomNoInDateAndTime());
	}

	public void enterRegionName(String region) {
		webUtils.enterText(Ele_RegionName_Input, region + dateUtils.generateRandomNoInDateAndTime());
	}

	public void clickOnSaveButton() throws InterruptedException {
		common.hardWaitFor(1200);
		this.clickAddNewSpacialityButton();
		common.hardWaitFor(1200);
		this.clickAddNewSpacialityButton();
		webUtils.jsClick(Ele_Save_Button);
		System.out.println("");
	}

	public String getCreatedSpecialityName() throws InterruptedException {
		common.hardWaitFor(4500);
		return webUtils.getText(Ele_SpecialityName_Text);
	}
	public String getUpdatedSpecialityName() throws InterruptedException {
		common.hardWaitFor(2500);
		return webUtils.getText(Ele_SpecialityName_Text);
	}

	public void selectCreatedRow() throws Exception {
		common.hardWaitFor(1500);
		webUtils.click(Ele_First_Row);
	}

	public void performMouseHoverThreeDotMenu() throws InterruptedException {
		webUtils.isElementDisplayed(Ele_HeaderSave_Button);
		common.hardWaitFor(2500);
		webUtils.click(Ele_ThreeDot_Menu);
	}

	public boolean verifyDeleteSelectedRowsButtonDisplayed() throws InterruptedException {
		boolean flag = false;
		try {
			common.hardWaitFor(1200);
			webUtils.isElementDisplayed(Ele_DeleteSelectedRows_Button);
			flag = true;
		} catch (Exception e) {
			flag = false;

		}
		return flag;
	}

	public void clickOnSelectedRowsButton() throws InterruptedException {
		common.hardWaitFor(2200);
		webUtils.jsClick(Ele_DeleteSelectedRows_Button);
		common.hardWaitFor(1200);
	}

	public void clickOnYesToDeleteButton() throws InterruptedException {
		common.hardWaitFor(1200);
		webUtils.click(Ele_DeleteYES_Buton);
		common.hardWaitFor(3500);
	}

	public String verifyDeleteDialogBoxSDisplayed() throws InterruptedException {
		common.hardWaitFor(1500);
		webUtils.isElementDisplayed(Ele_DeleteDialogBox_Section);
		String txt_ele = webUtils.getText(Ele_DeleteDialogBox_Section);
		return txt_ele;
	}

	public boolean makeSureSpecialityDeleted() {
		boolean flag = false;
		try {
			webUtils.jsClick(Ele_GridThreeDot_Menu);
			common.hardWaitFor(500);
			webUtils.jsClick(Ele_Contains_Option);
			common.hardWaitFor(500);
			webUtils.jsClick(Ele_EqualTo_Option);
			common.hardWaitFor(500);
			webUtils.enterText(Ele_FilterInput_1, specialityName_val);
			common.hardWaitFor(500);
			webUtils.jsClick(Ele_Filter_Button);
			common.hardWaitFor(900);
			boolean flg = webUtils.isElementDisplayed(Ele_NoDataFound_Message);
			common.hardWaitFor(2500);
			Assert.assertEquals(flg, true);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	public void selectCreatedSpeciality() throws Throwable {
		common.hardWaitFor(2500);
		webUtils.actionDoubleClick(Ele_First_Cell,5);
		common.hardWaitFor(1500);
	}
	
	public String enterUpdatedSpeciality(String updatedTxt) {
		UpdatedspecialityName_val = updatedTxt+dateUtils.generateRandomNoInDateAndTime();
		webUtils.enterText(Ele_FirstCell_InputBox, UpdatedspecialityName_val);
		return UpdatedspecialityName_val;
	}
	
	public void clickOnSaveButtonUnderHeaderSection() throws Throwable {
		common.hardWaitFor(1500);
		webUtils.jsClick(Ele_Header_Save_Button);
		common.hardWaitFor(4500);
	}

}
