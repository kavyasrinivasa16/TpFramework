package com.globalJournies.travelHunk.AllTestCaseTest;

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
import com.comcast.crm.objectrepositoryutility.userIssueTicketsPage;
import com.comcast.crm.objectrepositoryutility.userMyTourHistoryPage;
import com.comcast.crm.objectrepositoryutility.userTourpackagePage;
import com.comcast.crm.objectrepositoryutility.userWriteUsPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)

public class adminAndUserWorkFlowTestCaseTest extends BaseClass {

	@Test(groups = "regressionTest")
	public void CreateTourpackageAndLogoutTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "navigate to loginpage");
		tmsLoginPage tmslp = new tmsLoginPage(driver);
		tmslp.LoginToAdmin();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to Admin homepage and create tourpackage");
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

		UtilityClassObject.getTest().log(Status.INFO, "verify created tour package");
		String actualSuccessfulMsg = actpp.getVerifySuccessfulMsg().getText();
		Assert.assertEquals(true, actualSuccessfulMsg.contains("SUCCESS"));

		UtilityClassObject.getTest().log(Status.INFO, "logout as admin");
		tmslp.LogoutFromAdmin();
	}

	@Test(groups = "regressionTest")
	public void CreateTourpackageAndVerifyCountTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "navigate to loginpage");
		tmsLoginPage tmslp = new tmsLoginPage(driver);
		tmslp.LoginToAdmin();
		adminHomePage ahp = new adminHomePage(driver);
		String InitialTotalPackageCount = ahp.getTotalPackageInitialCount().getText();
		System.out.println("element" + InitialTotalPackageCount);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to Admin homepage and create tourpackage");
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

		UtilityClassObject.getTest().log(Status.INFO,
				"navigate to dashboard and verify total package count is increased or not");
		ahp.getDashboardbtn().click();
		String FinalTotalPackageCount = ahp.getTotalPackageFinalCount().getText();
		System.out.println("element" + FinalTotalPackageCount);
		Assert.assertNotEquals(true, FinalTotalPackageCount.contains(InitialTotalPackageCount));

	}

	/*@Test(groups = "regressionTest")
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

	}*/

	@Test(groups = "regressionTest")
	public void BookTourAndCancelTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "navigate to login page");
		tmsLoginPage tmslp = new tmsLoginPage(driver);
		tmslp.LoginToUser();

		UtilityClassObject.getTest().log(Status.INFO, "book tour package");
		userHomePage uhp = new userHomePage(driver);
		uhp.getDeatilsbtn().click();
		String fromdate = eLib.getDataFromExcel("user_booking_details", 1, 0);
		String todate = eLib.getDataFromExcel("user_booking_details", 1, 1);
		String comments = eLib.getDataFromExcel("user_booking_details", 1, 2);
		uhp.getFromDataEdt().sendKeys(fromdate);
		uhp.getToDataEdt().sendKeys(todate);
		wlib.scrolldown(driver);
		uhp.getCommentEdt().sendKeys(comments);
		uhp.getBook().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to my tour history and cancel booking");
		uhp.getMyTourHistory().click();
		Thread.sleep(2000);
		wlib.scrolldown(driver);
		userMyTourHistoryPage umthp = new userMyTourHistoryPage(driver);
		umthp.getMyTourHistoryBookingCancel().click();
		Thread.sleep(2000);
		wlib.switchtoAlertAndAccept(driver);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to write us link and select cancellation");
		uhp.getWriteUsLink().click();
		Thread.sleep(2000);
		userWriteUsPage uwp = new userWriteUsPage(driver);
		wlib.select(uwp.getSelectIssueDropdown(), "Cancellation");
		Thread.sleep(2000);
		String dropdownDescription = eLib.getDataFromExcel("writeus_dropdown", 1, 0);
		uwp.getDropdownDescription().sendKeys(dropdownDescription);
		Thread.sleep(2000);
		uwp.getDropdownSubmit().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to Issue tickets and verify issue is raised");
		userIssueTicketsPage uitp = new userIssueTicketsPage(driver);
		uitp.getIssueTicketsLink().click();
		String ActualIssueInIssueTicket = uitp.getActualIssueInIssueTicket().getText();
		Assert.assertEquals(true, ActualIssueInIssueTicket.contains("Cancellation"));
	}

	@Test(groups = "regressionTest")
	public void BookTourAndVerifyTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "navigate to login page");
		tmsLoginPage tmslp = new tmsLoginPage(driver);
		tmslp.LoginToUser();

		UtilityClassObject.getTest().log(Status.INFO, "book tour package");
		userHomePage uhp = new userHomePage(driver);
		uhp.getDeatilsbtn().click();
		String expectedtourpack = uhp.getVerifytourpack().getText();
		String fromdate = eLib.getDataFromExcel("user_booking_details", 1, 0);
		String todate = eLib.getDataFromExcel("user_booking_details", 1, 1);
		String comments = eLib.getDataFromExcel("user_booking_details", 1, 2);
		uhp.getFromDataEdt().sendKeys(fromdate);
		uhp.getToDataEdt().sendKeys(todate);
		wlib.scrolldown(driver);
		uhp.getCommentEdt().sendKeys(comments);
		uhp.getBook().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to my tour history and verify tour is booked");
		uhp.getMyTourHistory().click();
		Thread.sleep(2000);
		userMyTourHistoryPage umthp = new userMyTourHistoryPage(driver);
		String actualtourpack = umthp.getMyTourHistoryPackageName().getText();
		Assert.assertEquals(true, actualtourpack.contains(expectedtourpack));
	}

}
