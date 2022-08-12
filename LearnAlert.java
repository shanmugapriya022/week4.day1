package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {
	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		//launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.findElements(By.xpath("//button[text()='Prompt Box']"));
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String str =driver.findElement(By.id("result1")).getText();
		System.out.println(str);
		
		
		
	}

}
