package com.sashimi.login;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import WhichWebdriver.WhichWebDriverFactory;
import WhichWebdriver.WhichWebDriverFactory.WhichWebDriver;
import cucumber.annotation.en.And;
//import WhichWebDriver.WhichWebDriverFactory;
//import sportsAutomation.SkyWebDriverFactory.SkyWebDriverFactory.SkyWebDriver;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;

public class ITLoginStepDefs {
	

	private  WhichWebDriver driver = WhichWebDriverFactory.getInstance();
		
	//@When("I am on the (.+) page$")
	@Given("I am on the homepage")
	public void WhichLogin() throws Exception {
		driver.get("http://www.which.co.uk/beta/reviews/tv");
		WebElement element = driver.findElement(By.className("icon-user"));
		element.click();
		driver.waitForElement(By.id("username"));
		
	}
	
	
	@And("I enter in my login credentials \"(.+)\" and \"(.+)\" ")
	public void enterCredentials(String username, String password) throws Exception {
		WebElement credentials = driver.findElement(By.id("username"));
		credentials.sendKeys(username);
		credentials = driver.findElement(By.id("Password"));
		credentials.sendKeys(password);
		
	}
	
	@And("^I enter in my login credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_enter_in_my_login_credentials_and(String arg1, String arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement credentials = driver.findElement(By.id("username"));
		credentials.sendKeys(arg1);
		credentials = driver.findElement(By.id("password"));
		credentials.sendKeys(arg2);
		credentials.sendKeys(Keys.RETURN);
		
		//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(scrFile, new File("~/screenshot.png"));
	    //throw new PendingException();
	}

	@Then("^I should be logged in$")
	public void I_should_be_logged_in() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		System.out.println("Page title is: " + driver.getTitle());
	    //throw new PendingException();
	}
}

//	Given I am on the homepage
//	And I enter in my login credentials "selenium001" and "password"
//	Then I should be logged in