package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgDemo {
	
	WebDriver driver;
//	@Test(priority = 1)
	@BeforeMethod
	public void launch() {
	//	driver = new ChromeDriver();
	//	driver.get("https://google.com");
	}
	
	
	@Test()
	public void search() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium");
				search.submit();
				System.out.println("Method 1");
	}
	@Test()
	public void search1() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium");
				search.submit();
				System.out.println("Method 1");
	}
	@Test()
	public void search2() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium");
				search.submit();
				System.out.println("Method 2");
	}
	
	@Test()
	public void search3() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium");
				search.submit();
				System.out.println("Method 2");
	}
	
		@Test ()
		public void login() {
			System.out.println("login 2");
			
		}
		@Test (dependsOnMethods = "login")
		public void home() {
			System.out.println("home 2");
			
		}
		
		
		
		@AfterMethod
		public void closeBrowser() {
		//	driver.close();
		}
	
	


	
		
	}

