package bdd.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import automationCore.DriverFactory;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefination extends DriverFactory{
	WebDriver driver;
	public static final Logger logger = LogManager.getLogger("Cucumber Demo");
	@Before
	public void beforeScenario() throws Exception {
		driver = getDriver();
		Thread.sleep(2000);
	}
	
	@Given("^I navigate to page at \"([^\"]*)\" address$")
	public void i_navigate_to_page_at_address(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@When("^I enter \"([^\"]*)\" text into search field$")
	public void i_enter_text_into_search_field(String arg1) throws Throwable {
		driver.findElement(By.name("q")).sendKeys(arg1);
		
	}

	@When("^click on search button$")
	public void click_on_search_button() throws Throwable {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@When("^I select the first result$")
	public void i_select_the_first_result() throws Throwable {
		driver.findElement(By.xpath("//*[@id='resultStats']/following::h3[1]/a")).click();
	}

	@Then("^I should go to \"([^\"]*)\"$")
	public void i_should_go_to(String arg1) throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().equals(arg1));
	}
	
	@Given("^tui mo \"([^\"]*)\" len$")
	public void tui_mo_len(String arg1) throws Throwable {
		driver.get(arg1);
	}
}
