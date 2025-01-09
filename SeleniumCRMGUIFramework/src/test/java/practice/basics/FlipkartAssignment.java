package practice.basics;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartAssignment {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("redmi phones");
		driver.findElement(By.xpath("//button[@class='_2iLD__']")).click();
		
		//ArrayList<String> lst = new ArrayList<String>();
		
		List<WebElement> pricesText = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		for(WebElement prices : pricesText)
		{
			String text = prices.getText();
			System.out.println(text);
		}

	}

}
