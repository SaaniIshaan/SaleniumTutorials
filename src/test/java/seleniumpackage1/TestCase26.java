package seleniumpackage1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import seleniumpackage1.ReusableCodes1;

public class TestCase26 {

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
	 // click on create new contact
		Thread.sleep(3000);
		driver.findElement(By.linkText("Create New View")).click();
	// new view page is displayed
		Thread.sleep(3000);
		// enter the view name
		WebElement viewname  = driver.findElement(By.name("fname"));
		viewname.sendKeys("Singhal");
		//enter the unique view name
		WebElement uniqueviewname  = driver.findElement(By.name("fname"));
		uniqueviewname.clear();
		uniqueviewname.sendKeys("Agarwal3");
		Thread.sleep(5000);
		//click on save button
		driver.findElement(By.name("save")).click();
		Thread.sleep(3000);
		String Expected = "Contacts ~ Salesforce - Developer Edition";
		String Actual = driver.getTitle();

		if(Actual.equals(Expected)) {
			 System.out.println("passed");
		}
		 else {
			 System.out.println("failed");
			 }
		System.out.println("Created view page page is displayed");
		
		Assert.assertEquals(Expected, Actual);
		
		//driver.close();	
	}
		 
		 
}


