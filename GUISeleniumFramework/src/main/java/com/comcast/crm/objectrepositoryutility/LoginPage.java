package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 * Contains Login page elements & business lib like login()
 *
 */  
public class LoginPage extends WebDriverUtility{                              // Rule-1  create a separte java class
                           
	WebDriver driver;
	 public LoginPage(WebDriver driver) {             //Rule 3 : Object Initialization
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	                           
	@FindBy(name="username")                        // Rule-2 Object Creation
	private WebElement adminusernameEdt;
	
	@FindBy(name="password")
	private WebElement adminpasswordEdt;
	
	@FindBy(name = "login")
	private WebElement adminloginBtn;
	     
	
	                                             
	
	
	@FindBy(name="username")                        // Rule-2 Object Creation
	private WebElement usernameEdt;
	
	@FindBy(name="password")
	private WebElement passwordEdt;
	
	@FindBy(name = "login")
	private WebElement loginBtn;
	     
	
	                                             
	public WebElement getUsernameEdt() {            //Rule-4 : Object Encapsulation
		return usernameEdt;                        //Rule-5 : Object Utilization
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
/**
 *  login to application based username , password , url argumnets 
 * @param url
 * @param username
 * @param password
 */
	 public void loginToAdmin( String Adminusername , String Adminpassword) {
		 waitForPageToLoad(driver);
//		 driver.get(url);	
		// driver.manage().window().maximize();
		 usernameEdt.sendKeys(Adminusername);
		 passwordEdt.sendKeys(Adminpassword);
		 loginBtn.click();
	 }
	 public void loginToUser(String url, String Userusername , String Userpassword) {
		 waitForPageToLoad(driver);
		 driver.get(url);	
		// driver.manage().window().maximize();
		 usernameEdt.sendKeys(Userusername);
		 passwordEdt.sendKeys(Userpassword);
		 loginBtn.click();
	 }
	
	
}
