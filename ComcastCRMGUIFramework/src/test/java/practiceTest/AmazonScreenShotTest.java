package practiceTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class AmazonScreenShotTest {
	
	@Test
	public void amazonTest() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.in");
		//STEP1:  CREATE OBJECT TO EVENTFIRINGWEBDRIVER
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		
		//STEP2: USE GETSCREENSHOTAS METHOD TO GET FILE TYPE OF SCREENSHOT
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		//STEP3: STORE SCREEN ON LOCAL DRIVER
		FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
	}

}
