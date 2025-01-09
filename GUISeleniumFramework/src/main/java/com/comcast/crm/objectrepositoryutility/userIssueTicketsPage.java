package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userIssueTicketsPage {
	WebDriver driver;
	public userIssueTicketsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Issue Tickets']") private WebElement IssueTicketsLink;
	public WebElement getIssueTicketsLink() {
		return IssueTicketsLink;
	}
	
	@FindBy(xpath = "//table/tbody/tr[last()]/td[3]") private WebElement ActualIssueInIssueTicket;
	public WebElement getActualIssueInIssueTicket() {
		return ActualIssueInIssueTicket;
	}

}
