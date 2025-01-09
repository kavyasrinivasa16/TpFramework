package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminCreateTourPackagePage {
	
	WebDriver driver;
	public adminCreateTourPackagePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "packagename") private WebElement packagenameEdt;
	@FindBy(name = "packagetype") private WebElement packagetypeEdt;
	@FindBy(name = "packagelocation") private WebElement packagelocationEdt;
	@FindBy(name = "packageprice") private WebElement packagepriceEdt;
	@FindBy(name = "packagefeatures") private WebElement packagefeaturesEdt;
	@FindBy(name = "packagedetails") private WebElement packagedetailsEdt;
	@FindBy(name = "packageimage") private WebElement packageimageEdt;
	@FindBy(name = "submit") private WebElement submitEdt;
	@FindBy(xpath = "//strong[text()='SUCCESS']") private WebElement verifySuccessfulMsg;
	
	
	public WebElement getVerifySuccessfulMsg() {
		return verifySuccessfulMsg;
	}

	public WebElement getPackagenameEdt() {
		return packagenameEdt;
	}

	public WebElement getPackagetypeEdt() {
		return packagetypeEdt;
	}

	public WebElement getPackagelocationEdt() {
		return packagelocationEdt;
	}

	public WebElement getPackagepriceEdt() {
		return packagepriceEdt;
	}

	public WebElement getPackagefeaturesEdt() {
		return packagefeaturesEdt;
	}

	public WebElement getPackagedetailsEdt() {
		return packagedetailsEdt;
	}

	public WebElement getPackageimageEdt() {
		return packageimageEdt;
	}

	public WebElement getSubmitEdt() {
		return submitEdt;
	}
	public void packageimage() {
		packageimageEdt.sendKeys("C:/Users/Lenovo/Desktop/greatBarrierReef.jpg");
	}
}
