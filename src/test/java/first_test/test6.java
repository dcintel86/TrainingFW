package first_test;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

//user define
import automationCore.DriverFactory;
import automationCore.ReadExcel;

public class test6 extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Test 4");
	@Test
	public void test_angularJS() throws Exception {
		WebDriver driver = getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://193.168.40.193/auto_training/");
		logger.info("Go to My Page");
		driver.findElement(By.xpath("//button[text()='Display']")).click();
		WebElement hide_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Hide']")));
		WebElement hide_btn2 = driver.findElement(By.xpath("//button[text()='Hide']"));
		wait.until(ExpectedConditions.elementToBeClickable(hide_btn2));
		hide_btn2.click();
		hide_btn.click();
		//driver.findElement(By.xpath("//button[text()='Hide']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Alert']")).click();
		Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
		myAlert.accept();
		Thread.sleep(5000);
	}

}
