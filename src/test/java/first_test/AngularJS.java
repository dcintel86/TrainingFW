package first_test;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

//user define
import automationCore.DriverFactory;
import automationCore.ReadExcel;

public class AngularJS extends DriverFactory {
	public static final Logger logger = LogManager.getLogger("Demo AngularJS");
	WebDriver driver;
	@Test
	public void test_angularJS() throws Exception {
		driver = getDriver();
		driver.get("https://angularjs.org");
		logger.info("Go to https://angularjs.org");
		Reporter.log("Go to https://angularjs.org");
		driver.findElement(By.xpath("//*[@ng-model='todoList.todoText']")).sendKeys("Java Selenium Testing");
		logger.info("Add 'Java Selenium Testing' into todoList");
		Reporter.log("Add 'Java Selenium Testing' into todoList");
		driver.findElement(By.xpath("//*[@value='add']")).click();
		String text = driver.findElements(By.xpath("//*[@ng-repeat='todo in todoList.todos']")).get(2).getText();
		logger.info("Item 2 of To Do List is --- " + text);
		Reporter.log("Item 2 of To Do List is --- " + text);
		Assert.assertTrue(text.equals("Java Selenium Testing"));
		Thread.sleep(10000);
	}

}
