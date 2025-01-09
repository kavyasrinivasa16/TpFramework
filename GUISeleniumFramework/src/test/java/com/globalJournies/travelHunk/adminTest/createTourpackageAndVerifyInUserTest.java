package com.globalJournies.travelHunk.adminTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.adminCreateTourPackagePage;
import com.comcast.crm.objectrepositoryutility.adminHomePage;
import com.comcast.crm.objectrepositoryutility.tmsLoginPage;
import com.comcast.crm.objectrepositoryutility.userHomePage;
import com.comcast.crm.objectrepositoryutility.userTourpackagePage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)

public class createTourpackageAndVerifyInUserTest extends BaseClass {
	
	@Test
	public void CreateTourpackageAndVerifyInUserTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "navigate to login page");
		tmsLoginPage tmslp = new tmsLoginPage(driver);
		tmslp.LoginToAdmin();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to homepage and create tour package");
		adminHomePage ahp = new adminHomePage(driver);
		ahp.createtour();
		String packagename = jLib.getRandomNumber() + eLib.getDataFromExcel("admin", 1, 1);
		String packagetype = eLib.getDataFromExcel("admin", 1, 2);
		String packagelocation = eLib.getDataFromExcel("admin", 1, 3);
		String packageprice = eLib.getDataFromExcel("admin", 1, 4) + jLib.getRandomNumber();
		String packagefeature = eLib.getDataFromExcel("admin", 1, 5);
		String packagedetails = eLib.getDataFromExcel("admin", 1, 6);
		adminCreateTourPackagePage actpp = new adminCreateTourPackagePage(driver);
		actpp.getPackagenameEdt().sendKeys(packagename);
		actpp.getPackagetypeEdt().sendKeys(packagetype);
		actpp.getPackagelocationEdt().sendKeys(packagelocation);
		actpp.getPackagepriceEdt().sendKeys(packageprice);
		actpp.getPackagefeaturesEdt().sendKeys(packagefeature);
		actpp.getPackagedetailsEdt().sendKeys(packagedetails);
		wlib.scrolldown(driver);
		actpp.packageimage();
		actpp.getSubmitEdt().click();

		UtilityClassObject.getTest().log(Status.INFO, "logout from admin");
		tmslp.LogoutFromAdmin();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to user login page");
		tmslp.LoginToUser();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to tour package link");
		userHomePage uhp = new userHomePage(driver);
		uhp.getTourpackagelink().click();
		wlib.scrolldown(driver);

		UtilityClassObject.getTest().log(Status.INFO, "verify the created tour package in user account");
		userTourpackagePage utpp = new userTourpackagePage(driver);
		String actualCreatedtourpackagename = utpp.getCreatedtourpackagename().getText();
		Assert.assertEquals(true, actualCreatedtourpackagename.contains(packagename));

	}

}
