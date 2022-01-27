package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://dev66585.service-now.com");
				driver.manage().window().maximize();
				
				
				WebElement frame = driver.findElement(By.id("gsft_main"));
				driver.switchTo().frame(frame);
				
				driver.findElement(By.id("user_name")).sendKeys("admin");
				driver.findElement(By.id("user_password")).sendKeys("Qwerty@1930");
				
				driver.findElement(By.id("sysverb_login")).click();
				
				
				driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
				
				
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
				
				
				
				driver.switchTo().frame("gsft_main");
				driver.findElement(By.id("sysverb_new")).click();
				
	
				driver.findElement(By.id("lookup.incident.caller_id")).click();
				
				Set<String> windows = driver.getWindowHandles();
				List <String> window = new ArrayList<String>(windows);
				driver.switchTo().window(window.get(1));
				driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
				driver.switchTo().window(window.get(0));
				
				
				driver.switchTo().frame("gsft_main");
				driver.findElement(By.id("incident.short_description")).sendKeys("Testing Testing");
				
				
				String inciNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
				
				
				Thread.sleep(5000);
				driver.findElement(By.id("sysverb_insert_bottom")).click();
				
				System.out.println("The id is "+ inciNumber);
				
			
				driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(inciNumber, Keys.ENTER);
				
			
				String frst_result = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
				if (frst_result.contains(inciNumber))
					System.out.println("Created sucessfully");
				
		
				File source = driver.getScreenshotAs(OutputType.FILE);
				File dest = new File("./screenshot/img.png");
				FileUtils.copyFile(source, dest);
				
				Thread.sleep(1000);
				driver.close();
				
				
	}

}
