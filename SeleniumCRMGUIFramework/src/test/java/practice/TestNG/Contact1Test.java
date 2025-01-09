package practice.TestNG;

import org.testng.annotations.Test;

public class Contact1Test {
	@Test(priority = 1)
	public void createContactTest()
	{
		System.out.println("executed createContactTest");
	}
	
	@Test(priority = 2)
	public void modifyContactTest()
	{
		System.out.println("executed modifyContactTest");
	}
	
	@Test(priority = 3)
	public void deleteContactTest()
	{
		System.out.println("executed deleteContactTest");
	}

}
