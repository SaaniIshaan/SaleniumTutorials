package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestCase25 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver driver = ReusableCodes1.SalesforceLogin();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("Login is sucessful");
		Thread.sleep(3000);
		// click on Contact Tab 
		driver.findElement(By.linkText("Contacts")).click();
		System.out.println("Contact home page is displayed");
		// click on new button
		Thread.sleep(3000);
		driver.findElement(By.name("new")).click();
		System.out.println(" New Contact page is displayed");
		// Enter last name
		WebElement lastname  = driver.findElement(By.name("name_lastcon2"));
		lastname.sendKeys("gupta");
		// Enter Account name
		WebElement accountname  = driver.findElement(By.name("con4"));
		accountname.sendKeys("ABCD");
		//click on save button
		Thread.sleep(3000);
		driver.findElement(By.name("save")).click();
		
		String Expected = "Contact: gupta ~ Salesforce - Developer Edition";
		String Actual = driver.getTitle();
		
		if(Actual.equals(Expected)) {
			 System.out.println("passed");
		}
		 else {
			 System.out.println("failed");
			 }
		System.out.println("New Contact page is displayed");
		
		Assert.assertEquals(Expected, Actual);
		
		driver.close();	
		
		}

}
