package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase28 {

	public static void main(String[] args) throws InterruptedException { 
		// TODO Auto-generated method stub
		FirefoxDriver driver = ReusableCodes1.SalesforceLogin();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		System.out.println("Login is sucessful");
		Thread.sleep(3000);
		// click on Contact Tab 
		driver.findElement(By.linkText("Contacts")).click();
		System.out.println("Contact home page is displayed");
		Thread.sleep(3000);
		//select my contacts dropdown
		WebElement dropdown = driver.findElement(By.id("fcf"));
		dropdown.click();
		Select s = new Select(dropdown);
		s.selectByValue("00BHu00000GsWSK");
	// click on go button
		driver.findElement(By.name("go")).click();
		Thread.sleep(3000);
		System.out.println("My Contact view is displayed");
		
		
		
		
		
		
		 driver.close();
	}

}
