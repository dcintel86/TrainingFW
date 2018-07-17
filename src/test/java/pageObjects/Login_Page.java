package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	private WebDriver driver;

	// Constructor
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Find Elements

	@FindBy(id = "username")
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;

	// Action

	public Login_Page LoginWith(String user, String pass) throws InterruptedException {
		username.sendKeys(user);
		password.sendKeys(pass);
		password.sendKeys(Keys.ENTER);
		return this;
	}

}
