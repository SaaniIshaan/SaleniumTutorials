package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestCase23 {

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
		// click on the go button
		 driver.findElement(By.name("go")).click();
		 Thread.sleep(3000);
		 
		String Expected1 = "view";
		String Actual1 = driver.getTitle();
		
		System.out.println("Todays Lead page is displayed");
		
		Assert.assertEquals(Expected1, Actual1);
		
		driver.close();
		
		
		}

}
