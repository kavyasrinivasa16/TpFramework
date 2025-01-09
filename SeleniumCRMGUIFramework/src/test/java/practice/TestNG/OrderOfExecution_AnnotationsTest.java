package practice.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OrderOfExecution_AnnotationsTest {
	
	@BeforeSuite
	public void BS()
	{
		System.out.println("BS");
	}
	@BeforeClass
	public void BC()
	{
		System.out.println("BC");
	}
	@BeforeMethod
	public void BM()
	{
		System.out.println("BM");
	}
	@Test
	public void CC()
	{
		System.out.println("CC");
	}
	@Test
	public void CCD()
	{
		System.out.println("CCD");
	}
	@AfterMethod
	public void AM()
	{
		System.out.println("AM");
	}
	@AfterClass
	public void AC()
	{
		System.out.println("AC");
	}
	@AfterSuite
	public void AS()
	{
		System.out.println("AS");
	}

}
