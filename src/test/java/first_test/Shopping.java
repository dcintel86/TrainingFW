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
import org.testng.Reporter;
import org.testng.annotations.Test;

//user define
import automationCore.DriverFactory;
import automationCore.ReadExcel;

public class Shopping extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Test 4");
	@Test
	public void test_buy_an_item() throws Exception {
		WebDriver driver = getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://store.demoqa.com/");
		logger.info("http://store.demoqa.com/");
		Reporter.log("http://store.demoqa.com/");
		driver.findElement(By.name("s")).sendKeys("iPhone 5");
		driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
		logger.info("Search for iPhone 5");
		Reporter.log("Search for iPhone 5");
		Thread.sleep(7000);
		String price1 = driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div/div[1]/div[2]/div/p/span")).getText();
		driver.findElement(By.xpath("//*[@id='grid_view_products_page_container']/div/div[1]/div[3]/form/div/div[1]/span/input")).click();
		logger.info("The price of iPhone 5 is: " + price1);
		Reporter.log("The price of iPhone 5 is: " + price1);
		logger.info("Add the iPhone5 to cart");
		Reporter.log("Add the iPhone5 to cart");
		Thread.sleep(4000);
		String count = driver.findElement(By.xpath("//*/em[1]")).getText().trim();
		Assert.assertTrue(count.equals("1"));
		logger.info("Verify the item in cart should be 1");
		Reporter.log("Verify the item in cart should be 1");
		driver.findElement(By.xpath("//*[@id='header_cart']/a")).click();
		Thread.sleep(5000);
		String price2 = driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr[2]/td[5]/span/span")).getText();
		logger.info("Verify the total price should be " + price1);
		Reporter.log("Verify the total price should be " + price1);
	}

}
