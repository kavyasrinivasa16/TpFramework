package com.comcast.crm.objectrepositoryutility;
/**contains login page elements and business libraries login()
 * @author Kavya.S
 * 
 * 
 */

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{

	// Rule_1 Create a separate java class
	// Rule_2 object creations
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindBy(id = "submitButton")
	private WebElement loginbtn;

	// Rule:4 object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

/**
 * login to application based on username, password, url arguments
 * @param url
 * @param username
 * @param password
 */
	public void loginToapp(String url, String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();
	}

}
