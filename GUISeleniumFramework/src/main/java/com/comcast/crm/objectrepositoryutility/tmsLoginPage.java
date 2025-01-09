package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class tmsLoginPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public tmsLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[.='Admin Login']") private WebElement adminLoginLink;
	@FindBy(name="username") private WebElement adminusername;
	@FindBy(name="password") private WebElement adminpassword;
	@FindBy(name = "login") private WebElement adminloginBtn;
	@FindBy(xpath = "//span[text()='Administrator']") private WebElement welcomelink;
	@FindBy(xpath = "//a[text()=' Logout']") private WebElement logoutbtn;
	
	@FindBy(xpath = "//a[text()='/ Sign In']") private WebElement userSigninLink;
	@FindBy(xpath = "//input[@placeholder='Enter your Email']") private WebElement userusername;
	@FindBy(xpath = "//h3[text()='Signin with your account ']/../../../../../div[1]/div[1]/div[2]/form/input[2]") private WebElement userpassword;
	@FindBy(xpath = "//h3[text()='Signin with your account ']/../../../../../div[1]/div[1]/div[2]/form/input[3]") private WebElement usersigninbtn;
	@FindBy(xpath = "//a[text()='/ Logout']") private WebElement userlogoutbtn;
	
	public WebElement getAdminLoginLink() {
		return adminLoginLink;
	}
	public WebElement getAdminusername() {
		return adminusername;
	}
	public WebElement getAdminpassword() {
		return adminpassword;
	}
	public WebElement getAdminloginBtn() {
		return adminloginBtn;
	}
	public WebElement getWelcomelink() {
		return welcomelink;
	}
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	public WebElement getUserSigninLink() {
		return userSigninLink;
	}
	public WebElement getUserusername() {
		return userusername;
	}
	public WebElement getUserpassword() {
		return userpassword;
	}
	public WebElement getUsersigninbtn() {
		return usersigninbtn;
	}
	public WebElement getUserlogoutbtn() {
		return userlogoutbtn;
	}
	
	public void LoginToAdmin()
	{
		driver.get("http://49.249.28.218:8081/AppServer/Online_Tourism_Management_System/");
		driver.manage().window().maximize();
		adminLoginLink.click();
		adminusername.sendKeys("Admin");
		adminpassword.sendKeys("Test@123");
		adminloginBtn.click();
	}
	public void LogoutFromAdmin() throws InterruptedException
	{
		welcomelink.click();
		Thread.sleep(2000);
		logoutbtn.click();
	}
	public void LoginToUser() throws InterruptedException
	{
		driver.get("http://49.249.28.218:8081/AppServer/Online_Tourism_Management_System/");
		driver.manage().window().maximize();
		userSigninLink.click();
		userusername.sendKeys("kavya@gmail.com");
		userpassword.sendKeys("kavya");
		usersigninbtn.click();	
	}
	public void LogoutFromUser()
	{
		userlogoutbtn.click();
	}

}
