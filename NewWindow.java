package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindow {
	public static void main(String[] args) {
	
	//Setup WDM
	WebDriverManager.chromedriver().setup();
			//Create browser object and Launch URL 
			ChromeDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("http://leaftaps.com/opentaps/control/login");
			//Login using username and password
			driver.findElement(By.id("username")).sendKeys("demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();	
			//linktext to move to lead and create lead page
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			
	        //click merge lead
			
			driver.findElement(By.linkText("Merge Leads")).click();
			
			driver.findElement(By.xpath("(//span[text()='From Lead']/following : : img"));
			
			
			Set <String> windowHandles = driver.getWindowHandles();
			List <String> lstWindowHandles = new ArrayList <String> (windowHandles);
			
			//second window
			driver.switchTo().window(lstWindowHandles.get(1));
			//name
			driver.findElement(By.name("First name")).sendKeys("Shanmugapriya");
			driver.findElement(By.xpath("//button[text()='From Lead']"));
			driver.findElement(By.xpath("//div[text()='From Lead']"));
			}
}