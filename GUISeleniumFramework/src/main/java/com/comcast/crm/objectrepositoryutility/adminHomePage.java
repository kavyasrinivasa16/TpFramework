package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class adminHomePage extends WebDriverUtility{
	
	WebDriver driver;
	public adminHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[.=' Tour Packages']") private WebElement Tourpackagebtn;
	@FindBy(xpath = "//a[text()='Create']") private WebElement createbtn;
	@FindBy(xpath = "//a[text()='Manage']") private WebElement managebtn;
	@FindBy(xpath = "//span[.='Manage Booking']") private WebElement ManageBookingBtn;
	@FindBy(xpath = "//span[.='Manage Issues']") private WebElement ManageIssuesBtn;
	@FindBy(xpath = "//span[text()='Dashboard']") private WebElement dashboardbtn;
	
	@FindBy(xpath = "//a[text()='Back to home']") private WebElement backToHomeBtn;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div[2]/div[4]/div/div[2]/h4") private WebElement totalPackageInitialCount;
	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div[2]/div[4]/div/div[2]/h4") private WebElement totalPackageFinalCount;
	
	
	public WebElement getTotalPackageFinalCount() {
		return totalPackageFinalCount;
	}
	public WebElement getTotalPackageInitialCount() {
		return totalPackageInitialCount;
	}
	public WebElement getBackToHomeBtn() {
		return backToHomeBtn;
	}
	public WebElement getDashboardbtn() {
		return dashboardbtn;
	}
	public WebElement getTourpackagebtn() {
		return Tourpackagebtn;
	}
	public WebElement getCreatebtn() {
		return createbtn;
	}
	public WebElement getManagebtn() {
		return managebtn;
	}
	public WebElement getManageBookingBtn() {
		return ManageBookingBtn;
	}
	public WebElement getManageIssuesBtn() {
		return ManageIssuesBtn;
	}
	
	public void createtour()
	{
		Tourpackagebtn.click();
		createbtn.click();
	}
	public void managetour()
	{
		Tourpackagebtn.click();
		managebtn.click();
	}
}