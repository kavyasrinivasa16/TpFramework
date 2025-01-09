package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userWriteUsPage {
	
	WebDriver driver;
	public userWriteUsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "issue") private WebElement selectIssueDropdown;
	public WebElement getSelectIssueDropdown() {
		return selectIssueDropdown;
	}
	
	@FindBy(name = "description") private WebElement dropdownDescription;
	public WebElement getDropdownDescription() {
		return dropdownDescription;
	}
	
	@FindBy(xpath = "//button[text()='Submit']") private WebElement dropdownSubmit;
	public WebElement getDropdownSubmit() {
		return dropdownSubmit;
	}
	
	@FindBy(xpath = "//h4[text()='  Info successfully submited ']") private WebElement writeusSuccessfulMsgVerify;
	public WebElement getWriteusSuccessfulMsgVerify() {
		return writeusSuccessfulMsgVerify;
	}
}
