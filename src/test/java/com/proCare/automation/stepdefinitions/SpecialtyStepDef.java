package com.proCare.automation.stepdefinitions;

import org.testng.Assert;

import com.proCare.automation.pages.HomePage;
import com.proCare.automation.pages.LoginPage;
import com.proCare.automation.pages.SpecialityPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Mohammad.Arif
 *
 */
public class SpecialtyStepDef {
	LoginPage loginPage;
	HomePage homePage;
	SpecialityPage specialityPage;
	public String speciality,speciality_Updated = "";

	@Given("Launch and Login ProCare application")
	public void launch_and_login_pro_care_application() {
		loginPage = new LoginPage(BaseStep.getDriver());
		homePage = new HomePage(BaseStep.getDriver());
		specialityPage = new SpecialityPage(BaseStep.getDriver());
		loginPage.login();
	}

	@When("User able to see home page")
	public void user_able_to_see_home_page() {
		Assert.assertEquals(homePage.isHomeGroupPageHeading(), true);
	}

	@When("User allow to mouse hover Organization Icon")
	public void user_allow_to_mouse_hover_organization_icon() {
		Assert.assertEquals(specialityPage.performMouseHoverOrganization(), true);
	}

	@Then("User is able to see speciality option under Organization list")
	public void user_is_able_to_see_speciality_option_under_organization_list() {
		Assert.assertEquals(specialityPage.checkSpecialityOptionDisplayed(), true);
	}

	@Then("User click on speciality button")
	public void user_click_on_speciality_button() {
		specialityPage.clickOnSpaciality();
	}

	@Then("User should land on Specialty page")
	public void user_should_land_on_specialty_page() {
		Assert.assertEquals(specialityPage.verifySpecialityPageDisplayed(), true);
	}

	@Then("Click on Add New Specialty")
	public void click_on_add_new_specialty() {
		specialityPage.clickAddNewSpacialityButton();
	}

	@Then("User able to see Add New Specialty section")
	public void user_able_to_see_add_new_specialty_section() {
		Assert.assertEquals(specialityPage.verifyAddNewSectionDisplayed(), true);
	}

	@Then("User allow to enter Specialty Name {string}")
	public void user_allow_to_enter_specialty_name(String specialityName) {
		speciality = specialityPage.enterSpecialityName(specialityName);
	}

	@Then("User allow to enter Description {string}")
	public void user_allow_to_enter_description(String description) {
		specialityPage.enterDescription(description);
	}

	@Then("User allow to enter Region Name {string}")
	public void user_allow_to_enter_region_name(String Region) {
		specialityPage.enterRegionName(Region);
	}

	@Then("click on Save button under Add New Specialty section")
	public void click_on_save_button_under_add_new_specialty_section() throws InterruptedException {
		specialityPage.clickOnSaveButton();
	}

	@Then("User should be able to create new Speciality successfully")
	public void user_should_be_able_to_create_new_speciality_successfully() throws InterruptedException {
		Assert.assertEquals(specialityPage.getCreatedSpecialityName(), speciality);
	}

	@Then("User able to select row for newly created speciality")
	public void user_able_to_select_row_for_newly_created_speciality() {
		specialityPage.selectCreatedRow();
	}

	@Then("Click on Three dot menu")
	public void click_on_three_dot_menu() throws InterruptedException {
		specialityPage.performMouseHoverThreeDotMenu();
	}

	@Then("User able to see Delete Selected Rows button")
	public void user_able_to_see_delete_selected_rows_button() throws InterruptedException {
		Assert.assertEquals(specialityPage.verifyDeleteSelectedRowsButtonDisplayed(), true);
	}

	@Then("click on Delete Selected Rows button")
	public void click_on_delete_selected_rows_button() throws InterruptedException {
		specialityPage.clickOnSelectedRowsButton();
	}

	@Then("Delete confirmation box should be open along with text {string}")
	public void delete_confirmation_box_should_be_open_along_with_text(String string) throws InterruptedException {
		Assert.assertEquals(specialityPage.verifyDeleteDialogBoxSDisplayed(), string);
	}

	@Then("click on Yes button")
	public void click_on_yes_button() throws InterruptedException {
		specialityPage.clickOnYesToDeleteButton();
	}

	@Then("newly created speciality should be delete successfully")
	public void newly_created_speciality_should_be_delete_successfully() {
		Assert.assertEquals(specialityPage.makeSureSpecialityDeleted(), true);
	}

	@Then("User double click on newly created speciality")
	public void user_double_click_on_newly_created_speciality() throws Throwable {
		specialityPage.selectCreatedSpeciality();
	}

	@Then("User allow to enter updated speciality {string}")
	public void user_allow_to_enter_updated_speciality(String specialityName) {
		speciality_Updated = specialityPage.enterUpdatedSpeciality(specialityName);
	}

	@Then("User click on save button under section")
	public void user_click_on_save_button_under_section() throws Throwable {
		specialityPage.clickOnSaveButtonUnderHeaderSection();
	}

	@Then("Speciality should be updated successfully")
	public void speciality_should_be_updated_successfully() throws Throwable {
		Assert.assertEquals(specialityPage.getUpdatedSpecialityName(), speciality_Updated);
	}

}
