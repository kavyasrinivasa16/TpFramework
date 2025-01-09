package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 *         Contains Login page elements & business lib like login()
 *
 */
public class Home extends WebDriverUtility {

	WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[text()='Admin Login']")
	private WebElement adminlink;
	
	public WebElement getAdminlink() {
		return adminlink;
	}
	public void AdminLogin(String url)
	{
		driver.get(url);
		adminlink.click();
		
	}

	@FindBy(xpath = "//p[text()='Welcome']")
	private WebElement welcomelink;
	@FindBy(xpath = "//a[.=' Logout']")
	private WebElement logout;
	

	

	public WebElement getWelcomelink() {
		return welcomelink;
	}
	public WebElement getLogout() {
		return logout;
	}
	
	public void logoutFromAdmin() {
		welcomelink.click();
		logout.click();
	}

}
