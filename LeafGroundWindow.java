package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow {

	public static void main(String[] args) throws InterruptedException {
		

		// call WDM
		WebDriverManager.chromedriver().setup();
		
		
		//launch URL
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//click home page
		driver.findElement(By.id("home")).click();
		String firstWindow = driver.getWindowHandle();
		System.out.println("Primary Window: " +firstWindow);
		
		
		//second window handle
		Set<String> windows = driver.getWindowHandles();
		List<String> lstWindows = new ArrayList<String>(windows);
		String secWindow = lstWindows.get(1);
		driver.switchTo().window(secWindow).close();
		
		driver.switchTo().window(firstWindow);
		
		
		//Find the number of opened windows
		
		WebElement windowsNum = driver.findElement(By.xpath("//button[text()='Open Multiple Windows']"));
		windowsNum.click();
		System.out.println("The number of opened windows: "+ windows.size());
		Set<String> windowsOpen = driver.getWindowHandles();
		List<String> lstWindowsOpen = new ArrayList<String>(windowsOpen);
		String openFirst = lstWindowsOpen.get(1);
		String openSecond = lstWindowsOpen.get(2);
		
		driver.switchTo().window(firstWindow);
	
		//Close all except this window
		driver.findElement(By.xpath("//button[contains(text(),'Do not close')]")).click();
		driver.switchTo().window(openFirst).close();
		driver.switchTo().window(openSecond).close();
		
		driver.switchTo().window(firstWindow);
		
		//Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);
		Set<String> newWindows = driver.getWindowHandles();
		List<String> lstnewWindows = new ArrayList<String>(newWindows);
		String newWindow1 = lstnewWindows.get(1);
		String newWindow2 = lstnewWindows.get(2);
		System.out.println("New Window1: "+newWindow1);
		System.out.println("New Window2: "+newWindow2);
		System.out.println("Two new windows opened");
	
		
		

	}

}