package practice.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	
	@Test(dataProvider = "getData")
	public void createContactTest(String firstname, String lastname)
	{
		System.out.println("FN:"+ firstname +",LN:"+ lastname );
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "kavya";
		objArr[0][1] = "sri";
		objArr[1][0] = "rohii";
		objArr[1][1] = "sri";
		objArr[2][0] = "kushi";
		objArr[2][1] = "rohii";
		
		return objArr;
		
	}

}
