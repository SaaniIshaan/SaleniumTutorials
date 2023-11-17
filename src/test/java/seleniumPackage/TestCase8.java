package seleniumPackage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Launch app
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("mansi@hon.com");
		driver.findElement(By.id("password")).sendKeys("Manu@1234");
		driver.findElement(By.id("Login")).click();
		
		String ActualTitle = driver.getTitle();
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		
		if(ActualTitle.equalsIgnoreCase(expectedTitle)) 
			
			System.out.println("User is on home page");
		else 
			System.out.println("home page is not Lunched");
		
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//div[@class='mbrMenuItems']//child::a[@title='Developer Console (New Window)']")).click();
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
		System.out.println("Developer Console window is closed");
		
		driver.close();
	
		
		
		
		

	}

}
