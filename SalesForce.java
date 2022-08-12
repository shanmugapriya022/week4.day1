package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	

	public static void main(String[] args) throws InterruptedException {
		
		// call WDM
		WebDriverManager.chromedriver().setup();
		
		
		//launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//Enter the username as " ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		
		//Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys("Password#123");
		
		
		//click on the login button
		driver.findElement(By.id("Login")).click();
		
		String windowHandle = driver.getWindowHandle();
		//System.out.println(windowHandle);
		
		//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		
		//Switch to the next window using Windowhandles
		Set<String> mobPublisher = driver.getWindowHandles();
		List<String> lstMobile = new ArrayList<String>(mobPublisher);
		String newWindow = lstMobile.get(1);
		System.out.println("New Window: " +newWindow);
		driver.switchTo().window(newWindow);
		
		//click on the confirm button in the redirecting page
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='dialog']//button)[2]")).click();
		
		
		
		//Get the title
		String title = driver.getTitle();
		System.out.println("The new window title: "+title);
		
		
		//Get back to the parent window
		driver.switchTo().window(windowHandle);
		
		
		//close the browser
		driver.close();
		
		
		

	}

}