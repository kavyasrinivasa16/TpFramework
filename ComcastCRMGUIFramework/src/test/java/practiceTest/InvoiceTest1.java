package practiceTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvoiceTest1 {
	
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImplementation.class)
	public void activateSim()
	{
		System.out.println("execute activateSim");
		Assert.assertEquals("", "Login");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	}
	

}
