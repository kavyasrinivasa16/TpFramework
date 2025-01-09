package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userHomePage  {
	
	WebDriver driver;
	public userHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Tour Packages']") private WebElement tourpackagelink;
	
	@FindBy(xpath = "(//a[text()='Details'])[1]") private WebElement deatilsbtn;
	
	@FindBy(xpath = "//input[@name='fromdate']") private WebElement fromDataEdt;
	@FindBy(xpath = "//input[@name='todate']") private WebElement toDataEdt;
	@FindBy(xpath = "//input[@name='comment']") private WebElement commentEdt;
	@FindBy(xpath = "//button[text()='Book']") private WebElement book;
	
	@FindBy(xpath = "//a[text()='My Tour History']") private WebElement myTourHistory;
	@FindBy(xpath = "//form//table/tbody/tr[last()]/td[3]/a") private WebElement bookedTourInHistory;
	@FindBy(xpath = "//h2[text()='Manali Trip ']") private WebElement verifytourpack;
	
	@FindBy(xpath = "//a[text()=' / Write Us ']") private WebElement writeUsLink;
	
	
	
	public WebElement getWriteUsLink() {
		return writeUsLink;
	}
	public WebElement getVerifytourpack() {
		return verifytourpack;
	}
	public WebElement getTourpackagelink() {
		return tourpackagelink;
	}
	public WebElement getDeatilsbtn() {
		return deatilsbtn;
	}
	public WebElement getFromDataEdt() {
		return fromDataEdt;
	}
	public WebElement getToDataEdt() {
		return toDataEdt;
	}
	public WebElement getCommentEdt() {
		return commentEdt;
	}
	public WebElement getBook() {
		return book;
	}
	public WebElement getMyTourHistory() {
		return myTourHistory;
	}
	public WebElement getBookedTourInHistory() {
		return bookedTourInHistory;
	}

}
