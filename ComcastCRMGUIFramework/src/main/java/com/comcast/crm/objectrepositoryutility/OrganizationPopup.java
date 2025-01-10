package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPopup {
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDDEdt;
	
	@FindBy(name="search")
	private WebElement searchBtnEdt;
	
	public OrganizationPopup(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDDEdt() {
		return searchDDEdt;
	}

	public WebElement getSearchBtnEdt() {
		return searchBtnEdt;
	}

}
