package first_test;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

//user define
import automationCore.DriverFactory;

public class SpecialElement extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Test 4");
	WebDriver driver;
	@Test
	public void test_alert_iframe() throws Exception {
		driver = getDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_settimeout");
		logger.info("Go to www.w3schools.com");
		Reporter.log("Go to www.w3schools.com");
		WebElement iframe1 = driver.findElement(By.id("iframeResult"));
		logger.info("Switch to Iframe result");
		Reporter.log("Switch to Iframe result");
		driver.switchTo().frame(iframe1).findElement(By.xpath("//*[text()='Try it']")).click();
		logger.info("Click on 'Try it' button");
		Reporter.log("Click on 'Try it' button");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
		myAlert.accept();
		logger.info("Wait until an alert displays and accept it");
		Reporter.log("Wait until an alert displays and accept it");
		Thread.sleep(5000);
	}

}
