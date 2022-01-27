package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		//Load URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		
		// Maximize the browser
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//label[text()='Click button to open home page in New Window']")).click();
		String handle = driver.getWindowHandle();
		System.out.println(handle);


	}

}
