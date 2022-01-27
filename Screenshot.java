package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();

		//Load URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		
		// Maximize the browser
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		WebElement clickbutton = driver.findElement(By.xpath("//button[text()='Click Me']"));
		File source = clickbutton.getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/Homescreen.png");
		FileUtils.copyFile(source, destination);
		driver.switchTo().defaultContent();
		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
		System.out.println(frame.size());
		

	}

}
