package practice.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mock {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.search.yahoo.com/?fr2=inr");
		//driver.findElement(By.className("D(ib) Td(u):h Ell"));
		List<WebElement> fetch = driver.findElements(By.className("D(ib) Td(u):h Ell"));
		System.out.println(fetch);
		
		
	}

}
