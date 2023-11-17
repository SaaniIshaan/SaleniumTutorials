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

public class TestCase30 {

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
		//click on the create new view
		driver.findElement(By.linkText("Create New View")).click();
		Thread.sleep(3000);
		System.out.println("Create new view page is displayed");
		// Enter the values in the view unique name field
		driver.findElement(By.id("devname")).sendKeys("EFGH");
		// click on save button
		driver.findElement(By.name("save")).click();
		Thread.sleep(3000);
		String Expected = "Error:You must enter a value";
	//	String Actual = "errorMsg";
	String Actual = driver.findElement(By.xpath("//div[contains(text(),'You must enter a value')]")).getText();
	//	String Actual = driver.findElement(By.xpath("//div[@class='errorMsg']")).getText();
		if(Actual.equals(Expected)) {
			 System.out.println("passed");
		}
		 else {
			 System.out.println("failed");
			 }
		System.out.println("error message is displayed");
		
		Assert.assertEquals(Expected, Actual);
		
	//	driver.close();	
		
		}
		 
		 
	}


