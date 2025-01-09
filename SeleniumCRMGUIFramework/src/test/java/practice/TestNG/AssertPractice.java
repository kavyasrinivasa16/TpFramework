package practice.TestNG;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertPractice {
	
	@Test
	public void createcontactTest()
	{
		Reporter.log("step1", true);
		Reporter.log("step2",true);
		Assert.assertEquals("A", "B");
		Reporter.log("step3",true);
		Assert.assertEquals("X", "Y");
		Reporter.log("step4",true);
	}
	
	@Test
	public void MODIFYcontactTest()
	{
		Reporter.log("step1",true);
		Reporter.log("step2",true);
		Reporter.log("step3",true);
		Reporter.log("step4",true);
	}
	
	

}
