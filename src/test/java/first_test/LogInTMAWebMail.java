package first_test;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

//user define
import automationCore.DriverFactory;

public class LogInTMAWebMail extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Test log in TMA Web mail");
	WebDriver driver;
	@Test
	public void test_invalid_login() throws Exception {
		driver = getDriver();
		driver.get("https://webmail.tma.com.vn");
		logger.info("Open Web mail TMA");
		provideInto(driver, "Username:", "ffffffffff");
		Reporter.log("Provide username: ffffffffff");
		logger.info("Provide username: ffffffffff");
		provideInto(driver, "Password:", "ffffffffff");
		Thread.sleep(10000);
		logger.info("Provide password: ffffffffff");
		Reporter.log("Provide password: ffffffffff");
		provideInto(driver, "Password:", Keys.ENTER);
		Thread.sleep(5000);
	}
	
	public void provideInto(WebDriver driver, String label, String text) {
		driver.findElement(By.xpath("//*[text()='" + label + "']/following::input[1]")).sendKeys(text);
	}
	
	public void provideInto(WebDriver driver, String label, org.openqa.selenium.Keys key) {
		driver.findElement(By.xpath("//*[text()='" + label + "']/following::input[1]")).sendKeys(key);
	}

}
