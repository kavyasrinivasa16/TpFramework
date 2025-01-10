package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(id = "mouseArea_Last Name")
	private WebElement headerLastname;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement headerstartDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement headerendDate;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement headerOrgName;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderLastname() {
		return headerLastname;
	}

	public WebElement getHeaderstartDate() {
		return headerstartDate;
	}

	public WebElement getHeaderendDate() {
		return headerendDate;
	}

	public WebElement getHeaderOrgName() {
		return headerOrgName;
	}
	
	public void createContactWithSupportDate(String lastname,String startdate,String enddate)
	{
		headerLastname.sendKeys(lastname);
		headerstartDate.clear();
		headerstartDate.sendKeys(startdate);
		headerendDate.clear();
		headerendDate.sendKeys(enddate);
	}

}
