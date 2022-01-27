package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) {

     WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		// Load URL
		driver.get("http://www.leafground.com/pages/Alert.html");
		
		// Maximize the browser
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		
		//SwitchTo
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		alert.accept();


	}

}
