package practice.ContactTest;

import java.io.FileInputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		Random ran = new Random();
		int ranint = ran.nextInt(1000);
		
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\New folder\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(4);
		String lastname = row.getCell(2).toString()+ranint;
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		
		
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		java.util.Date dateObj = new java.util.Date();
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String startdate = sim.format(dateObj);
		
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String enddate = sim.format(cal.getTime());
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify startdate and enddate with expected result
		String actstartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstartdate.contains(startdate))
		{
			System.out.println(startdate + "info is verified==pass");
		}
		else {
			System.out.println(startdate + "info is notverified==fail");
		}
		
		String actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actenddate.contains(enddate))
		{
			System.out.println(enddate + "info is verified==pass");
		}
		else {
			System.out.println(enddate + "info is notverified==fail");
		}
		
		driver.quit();

	}

}
