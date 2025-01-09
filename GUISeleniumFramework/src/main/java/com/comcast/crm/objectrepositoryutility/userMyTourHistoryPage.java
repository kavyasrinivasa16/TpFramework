package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class userMyTourHistoryPage {
public WebDriverUtility wlib=new WebDriverUtility();
	
	WebDriver driver;
	public userMyTourHistoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//table/tbody/tr[last()]/td[3]") private WebElement myTourHistoryPackageName;
	public WebElement getMyTourHistoryPackageName() {
		return myTourHistoryPackageName;
	}
	
	@FindBy(xpath = "//table/tbody/tr[last()]/td[9]") private WebElement myTourHistoryBookingCancel;
	public WebElement getMyTourHistoryBookingCancel() {
		return myTourHistoryBookingCancel;
	}	
}
