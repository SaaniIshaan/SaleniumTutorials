package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase20 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = ReusableCodes.SalesforceLogin();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Login is sucessful");
		Thread.sleep(3000);
		
		// click on leads Tab 
		 driver.findElement(By.linkText("Leads")).click();
		 driver.findElement(By.id("Lead_Tab")).click();
		// WebElement Leads;
		 
		String Expected = "Leads: Home ~ Salesforce - Developer Edition";
		String Actual = driver.getTitle();
		
		if(Actual.equals(Expected)) {
			 System.out.println("passed");
			 System.out.println("Leads home page is displayed");
		}
		 else {
			 System.out.println("failed");
		}
		 Thread.sleep(2000);
		 driver.close();
		
		
		
		
		
		
		
		
		
		
		
	}

}
