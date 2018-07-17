package first_test;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//user define
import automationCore.DriverFactory;
import automationCore.ReadExcel;

public class test2 extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Test 1");
	@Test
	public void test_invalid_email() throws Exception {
		ReadExcel re = new ReadExcel("TC01");
		String usr = re.getVar("username");
		String pass = re.getVar("password");
		WebDriver driver = getDriver();
		driver.get("https://webmail.tma.com.vn");
		logger.info("Go to Web Mail");
		driver.findElement(By.id("username")).sendKeys(usr);
		logger.info("Provide Username");
		driver.findElement(By.id("password")).sendKeys(pass);
		logger.info("Provide Password");
		driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
	}

}
