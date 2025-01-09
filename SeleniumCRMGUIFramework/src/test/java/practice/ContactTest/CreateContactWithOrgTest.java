package practice.ContactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		Random ran = new Random();
		int ranint = ran.nextInt(100);
		
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\New folder\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		String orgName = row.getCell(2).toString()+ranint;
		String contactlastname = row.getCell(3).getStringCellValue();
		wb.close();
	
		
		
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("firefoxe"))
		{
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		
		//step1 login to application
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step2 navigate to the organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//step3 click on create organization button
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		//step4 enter all the details and create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify header msg Expected Result
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgName))
		{
			System.out.println(orgName+ "is created==pass");
		}
		else {
			System.out.println(orgName+ "is notcreated==fail");
		}
		
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(contactlastname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		Thread.sleep(3000);
		
		
		//switch to child browser
		 Set<String> set = driver.getWindowHandles();
		 Iterator<String> it = set.iterator();
		 
		 while(it.hasNext())
		 {
			 String windowid = it.next();
			 driver.switchTo().window(windowid);
			 
			 String acturl = driver.getCurrentUrl();
			 if(acturl.contains("module=Accounts"))
			 {
				 break;
			 }
		 }
		 Thread.sleep(3000);
		 
		 driver.findElement(By.id("search_txt")).sendKeys(orgName);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		 
		 //switch to parent window
		 
		 Set<String> set1 = driver.getWindowHandles();
		 Iterator<String> it1 = set1.iterator();
		 
		 while(it1.hasNext())
		 {
			 String windowid1 = it1.next();
			 driver.switchTo().window(windowid1);
			 
			 String acturl1 = driver.getCurrentUrl();
			 if(acturl1.contains("Contacts&action"));
			 {
				 break;
			 }
		 }
		 
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 //verification
		 String headerinfo1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerinfo1.contains(contactlastname))
			{
				System.out.println(contactlastname+ "is verified==pass");
			}
			else {
				System.out.println(contactlastname+ "is notverified==fail");
			}
			
			//verification
			String actorgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if(actorgname.equals(orgName))
			{
				System.out.println(orgName + "info is created==pass");
			}
			else {
				System.out.println(orgName + "info is notcreated==fail");
			}
		 
		 driver.quit();	 
		 
	}

}
