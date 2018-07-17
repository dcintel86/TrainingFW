package first_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//user define
import automationCore.DriverFactory;

public class Session1 extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Session1");

	@Test
	public void loginTMA() throws Exception {

		// Print put: "Hello this is the first test case"
		System.out.println("Hello this is the first test case");

		// Open browser, chrome/firefox depends on Maven configuration file
		WebDriver driver = getDriver();

		// Maximum browser
		driver.manage().window().maximize();

		// Navigate browser to open website: "https://webmail.tma.com.vn"
		driver.get("https://webmail.tma.com.vn");

		// Logs a message with level INFO on this logger
		logger.info("Open Web mail TMA");

		// Find Element by name
		WebElement username = driver.findElement(By.name("username"));
		// Send "Yourname" to the element: username
		username.sendKeys("Yourname");

		WebElement password = driver.findElement(By.xpath("//*[@id=\'password\']"));
		password.sendKeys("YourPassword");
		Thread.sleep(2000);

		// From element: password, submit Login form

		WebElement singin = driver
				.findElement(By.xpath("/html/body/div/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input[2]"));
		singin.click();
		Thread.sleep(5000);

		// Verify the current URL equals to "https://webmail.tma.com.vn/" in case of
		// failure login
		Assert.assertTrue(driver.getCurrentUrl().equals("https://webmail.tma.com.vn/"));

		// Verify the current URL equals to "https://webmail.tma.com.vn/#1" in case of
		// successful login
		// Assert.assertTrue(driver.getCurrentUrl().equals("https://webmail.tma.com.vn/#1"));

		Thread.sleep(5000);
		System.out.println("Login TMA");
	}

}