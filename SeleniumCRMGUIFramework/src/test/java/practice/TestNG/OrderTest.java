package practice.TestNG;

import org.testng.annotations.Test;

public class OrderTest {
	
	@Test(invocationCount = 10)
	public void createContactTest() {
		System.out.println("executed createContactTest");
		//String str = null;
		//System.out.println(str.equals("123"));
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest()
	{
		System.out.println("executed modifyContactTest");
	}
	
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest()
	{
		System.out.println("executed deleteContactTest");
	}

}
