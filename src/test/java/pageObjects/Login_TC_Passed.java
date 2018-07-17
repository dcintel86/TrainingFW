package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationCore.DriverFactory;

public class Login_TC_Passed extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Session: Page Object Model");

	@Parameters({ "yourname", "password" })
	@Test
	public void validLogin(String yourname, String password) throws Exception {
		WebDriver driver = getDriver();
		driver.manage().window().maximize();
		driver.get("https://webmail.tma.com.vn/");
		Thread.sleep(3000);

		// Create a new object: loginPage from Login_Page class
		Login_Page loginPage = new Login_Page(driver);
		loginPage.LoginWith(yourname, password);

		// Verify failed login
		Thread.sleep(3000);
		WebElement message = driver.findElement(By.id("z_userName"));
		String actual_message = message.getText();
		Boolean result = actual_message.contains("Cuong Tran Dinh");
		Assert.assertTrue(result);
		System.out.println(actual_message + " logins successfully");
		Thread.sleep(3000);
	}
}
