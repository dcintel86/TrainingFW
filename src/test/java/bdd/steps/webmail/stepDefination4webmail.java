package bdd.steps.webmail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import automationCore.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Login_Page;

public class stepDefination4webmail extends DriverFactory{
	WebDriver driver;
	Login_Page loginPage;
	public static final Logger logger = LogManager.getLogger("Cucumber Demo");
	@Before
	public void beforeScenario() throws Exception {
		driver = getDriver();
		Thread.sleep(2000);
		loginPage = new Login_Page(driver);
	}
	
	@After
	public void afterScenario() throws Exception {
		driver.quit();
	}
	
	@Given("^I open browser to \"([^\"]*)\"$")
	public void i_open_browser_to(String arg1) throws Throwable {
		driver.get(arg1);
	}
	
	@When("^login with user and password are \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_with_user_and_password_are_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.LoginWith(arg1, arg2);
	}

	@Then("^I should login successfully$")
	public void i_should_login_successfully() throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().equals("https://webmail.tma.com.vn/#1"));
	}

	
}
