package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.DriverFactory;

public class Login_TC_Failed extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Session: Page Object Model");

	@Test
	public void invalidLogin() throws Exception {
		WebDriver driver = getDriver();
		driver.manage().window().maximize();
		driver.get("https://webmail.tma.com.vn/");
		Thread.sleep(3000);

		// Create a new object: loginPage from Login_Page class
		Login_Page loginPage = new Login_Page(driver);
		loginPage.LoginWith("Yourname", "Password");

		// Verify failed login
		Thread.sleep(1000);
		WebElement message = driver.findElement(By.xpath("//*[@id='ZLoginErrorPanel']/table/tbody/tr/td[2]"));
		String actual_message = message.getText();
		Boolean result = actual_message.contains("The username or password is incorrect");
		Assert.assertTrue(result);
		Thread.sleep(3000);
		System.out.println("Login Failed");
	}
}
