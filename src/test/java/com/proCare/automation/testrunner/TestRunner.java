package com.proCare.automation.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		 features = "src/test/resources/Features",
         glue = {"com.proCare.automation.stepdefinitions"},
         plugin = { "pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
         monochrome = false,
         dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
	

}
