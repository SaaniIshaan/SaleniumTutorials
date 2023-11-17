package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestCase31{

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
		// Enter the values in the view name field
		driver.findElement(By.id("fname")).sendKeys("ABCD");
		// Enter the values in the view unique name field
		driver.findElement(By.id("devname")).sendKeys("EFGH");
		//click on the cancel
		driver.findElement(By.name("cancel")).click();
		Thread.sleep(3000);
		// nothing is printed
		
		System.out.println("contact home page is displayed");
		
		
		
		driver.close();	
		
		
		
		
		

	}

}
