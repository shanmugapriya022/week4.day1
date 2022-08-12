package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameAlert {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
				
				//launch URL
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
				driver.manage().window().maximize();
				driver.switchTo().frame(0);
				driver.findElements(By.xpath("//button[text()='Try it']"));
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
				String str =driver.findElement(By.id("demo")).getText();
				System.out.println(str);
				
				
				
			}
}
