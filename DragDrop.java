package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop {
	public static void main(String[] args) {
		
		//Setup WDM
		WebDriverManager.chromedriver().setup();
				//Create browser object and Launch URL 
				ChromeDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://jqueryui.com/droppable/");
				
				driver.switchTo().frame(0);
				WebElement drag = driver.findElement(By.id("Droppable"));
				WebElement drop = driver.findElement(By.id("Droppable"));
				Actions builder = new Actions(driver);
				builder.dragAndDrop(drag, drop).perform();
	}
}
