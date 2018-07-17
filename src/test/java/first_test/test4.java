package first_test;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//user define
import automationCore.DriverFactory;
import automationCore.ReadExcel;

public class test4 extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Test 4");
	@Test
	public void test_angularJS() throws Exception {
		WebDriver driver = getDriver();
		driver.get("http://193.168.40.193/auto_training/");
		logger.info("Go to My Page");
		driver.findElement(By.xpath("//*[text()='Alert']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
		myAlert.accept();
		//driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}

}
