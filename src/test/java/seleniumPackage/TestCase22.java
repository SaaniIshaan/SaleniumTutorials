package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase22 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = ReusableCodes.SalesforceLogin();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Leads")).click();
		 driver.findElement(By.id("Lead_Tab")).click();
		 Thread.sleep(5000);
		 String Expected = "Leads: Home ~ Salesforce - Developer Edition";
			String Actual = driver.getTitle();
			System.out.println("Leads home page is displayed");
		 // clicking on the dropdown
		 driver.findElement(By.id("fcf")).click();
		 // clicking on todays lead
		 WebElement TodaysLead = driver.findElement(By.id("fcf"));
		Select select = new Select(TodaysLead);
		select.selectByValue("00BHu00000GsWRd");
		 Thread.sleep(5000);
		//clicking on user menu for logout
		 WebElement Usermenu = driver.findElement(By.id("userNavLabel"));
		 Usermenu.click();
		//for logout
		 driver.findElement(By.linkText("Logout")).click();
		 Thread.sleep(5000);
		System.out.println("Logout is sucessful");
		driver.close();
		// Relogin to the home page
		ChromeDriver driver2 = ReusableCodes.SalesforceLogin();
		Thread.sleep(5000);
	//	click on the leads tab
		driver.findElement(By.id("Lead_Tab")).click();
		System.out.println("Leads home page is displayed");
		 // clicking on the dropdown
		 driver.findElement(By.id("fcf")).click();
		
		
		
		
		
		
		
		

	}

}
