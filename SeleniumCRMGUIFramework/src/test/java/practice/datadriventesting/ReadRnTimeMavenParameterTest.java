package practice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRnTimeMavenParameterTest {
	
	@Test
	public void runtimeparameterTest()
	{
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println("url Data ==>url==>"+URL);
		System.out.println("Browser Data ==>browser==>"+BROWSER);
		System.out.println("Username Data ==>username==>"+USERNAME);
		System.out.println("Password Data ==>password==>"+PASSWORD);
	}
}
