package com.crm.generic.baseclasstest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassTest {
	@BeforeSuite
	public void BS()
	{
		System.out.println("Coonect to db and report config");
	}
	@BeforeClass
	public void BC()
	{
		System.out.println("launch browser");
	}
	@BeforeMethod
	public void BM()
	{
		System.out.println("login script");
	}
	
	@AfterMethod
	public void AM()
	{
		System.out.println("logout script");
	}
	@AfterClass
	public void AC()
	{
		System.out.println("close browser");
	}
	@AfterSuite
	public void AS()
	{
		System.out.println("close db and report backup");
	}

}
