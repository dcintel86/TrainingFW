package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99Login_Review {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 * 
	 */
	@FindBy(name = "uid")
	private WebElement user99GuruName;

	@FindBy(name = "password")
	private WebElement password99Guru;

	/*
	 * @FindBy(className = "barone") private WebElement password99Guru;
	 */

	@FindBy(name = "btnLogin")
	private WebElement login;

	private WebDriver driver;

	public Guru99Login_Review() {
	}

	public Guru99Login_Review(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	// Set user name in textbox

	public void setUserName(String strUserName) {

		user99GuruName.sendKeys(strUserName);

	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		password99Guru.sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		login.click();

	}

	// Get the title of Login Page

	public String getLoginTitle() {

		return this.driver.getTitle();

	}

	/**
	 * 
	 * This POM method will be exposed in test case to login in the application
	 * 
	 * @param strUserName
	 * 
	 * @param strPasword
	 * 
	 * @return
	 * 
	 */

	public void loginToGuru99(String strUserName, String strPasword) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();

	}

}