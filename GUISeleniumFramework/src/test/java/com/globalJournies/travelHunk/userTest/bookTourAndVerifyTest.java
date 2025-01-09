package com.globalJournies.travelHunk.userTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.tmsLoginPage;
import com.comcast.crm.objectrepositoryutility.userHomePage;
import com.comcast.crm.objectrepositoryutility.userMyTourHistoryPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)

public class bookTourAndVerifyTest extends BaseClass {

	@Test
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
