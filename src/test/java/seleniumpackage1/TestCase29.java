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

public class TestCase29 {

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
		// click on a contact name under the recent contacts
		driver.findElement(By.linkText("gupta")).click();
		Thread.sleep(3000);
		System.out.println(" Contact name is displayed ");
		//check the contact details
		
			String Expected = "Contact: gupta ~ Salesforce - Developer Edition";
			String Actual = driver.getTitle();

			if(Actual.equals(Expected)) {
				 System.out.println("passed");
			}
			 else {
				 System.out.println("failed");
				 }
			System.out.println("New Contact page is displayed with all the information");
			
			Assert.assertEquals(Expected, Actual);
			
			driver.close();	
			
	
	
	
	
	
	
	}
	
}


