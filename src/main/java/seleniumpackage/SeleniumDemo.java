package seleniumpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
	

public class SeleniumDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
	//`	driver.get("https://selenium-prd.firebaseapp.com");
		driver.manage().window().maximize();
		
	//	WebElement dropDown = driver.findElement(By.id("city"));
	//	select
	//	Select city = new Select(dropDown);
	//	city.selectByValue("mumbai");
	//	city.selectByIndex(("")
	//	Thread.sleep(2000);
	//	driver.quit();
		
		driver.get("https:www.salesforce.com/");
		//ID
	//	driver.findElement(By.id("username")).sendKeys("mansi@hon.com");
		//Name
	//	driver.findElement(By.name("username")).sendKeys("mansi@hon.com");
		//Xpath
	//	driver.findElement(By.xpath("//*[@name ='username']")).sendKeys("mansi@hon.com");
	//	css selector
	//	driver.findElement(By.cssSelector("#username")).sendKeys("mansi@hon.com");
	//	linkText
	//	driver.findElement(By.linkText("Forgot Your Password?")).click();
	//	partial linkText
		driver.findElement(By.partialLinkText("Forgot")).click();
				
		Thread.sleep(3000);
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
