package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDatabaseWithGUI {

	public static void main(String[] args) throws SQLException {

		String projectname = "maxfash12345";
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://106.51.90.215:8084/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("maxfash12345");
		driver.findElement(By.name("createdBy")).sendKeys("kavyarohi");
		Select sel = new Select(driver.findElement(By.name("status")));
		sel.selectByIndex(0);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();

		boolean flag = false;

		// step1: load/register the database driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

		// step2: connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("====done====");

		// step3 create sql statement
		Statement stat = conn.createStatement();

		// step4 execute select query and get result
		ResultSet resultset = stat.executeQuery("select* from project");

		while (resultset.next()) {
			String actprojectname = resultset.getString(4);
			if (projectname.equals(actprojectname)) {
				flag = true;
				System.out.println(projectname + "is available==PASS");
			}
		}
		if (flag == false) {
			System.out.println(projectname + "is notavailable==FAIL");

		}
		conn.close();
		driver.quit();

	}
}
