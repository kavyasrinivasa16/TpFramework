package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener, ISuiteListener {

	public ExtentReports reports;
	public static ExtentTest test;
	public ExtentSparkReporter spark;

	@Override
	public void onStart(ISuite suite) {

		System.out.println("Report configuration");
		// spark report config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Env information and create test
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("OS", "windows-10");
		reports.setSystemInfo("BROWSER", "CHROME-100");

	}

	@Override
	public void onFinish(ISuite suite) {

		System.out.println("Report backUP");
		reports.flush();

	}
	@Override
	public void onTestStart(ITestResult result) {

		test = reports.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "==> STARTED <==");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filepath = eDriver.getScreenshotAs(OutputType.BASE64);

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "==> FAILED <==");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + "==> COMPLETED <==");
	}
	
	
	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
}
