package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.DriverFactory;

public class LoginWithPageFactory_TC_Review extends DriverFactory {

	/**
	 * 
	 * This test go to http://demo.guru99.com/V4/
	 * 
	 * Verify login page title as guru99 bank
	 * 
	 * Login to application
	 * 
	 * Verify the home page using Dashboard message
	 * 
	 * @throws Exception
	 * 
	 */

	@Test(priority = 0)
	public void test_Home_Page_Appear_Correct() throws Exception {
		WebDriver driver = getDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/V4/");

		Guru99Login_Review objLogin;

		Guru99HomePage_Review objHomePage;

		// Create Login Page object

		objLogin = new Guru99Login_Review(driver);

		// Verify login page title

		String loginPageTitle = objLogin.getLoginTitle();

		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

		// login to application

		objLogin.loginToGuru99("mgr123", "mgr!23");

		// go the next page

		objHomePage = new Guru99HomePage_Review(driver);

		// Verify home page
		Thread.sleep(1000);

		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));

	}

}