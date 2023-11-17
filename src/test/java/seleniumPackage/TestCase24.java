package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase24 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = ReusableCodes.SalesforceLogin();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Leads")).click();
		 driver.findElement(By.id("Lead_Tab")).click();
		 Thread.sleep(3000);
		 String Expected = "Leads: Home ~ Salesforce - Developer Edition";
			String Actual = driver.getTitle();
			System.out.println("Leads home page is displayed");
		 //click on the new button
			 driver.findElement(By.name("new")).click();
			 Thread.sleep(3000);
			 System.out.println("Lead creation page is displayed");
			//enter value in the last name field 
			 driver.findElement(By.id("name_lastlea2")).sendKeys("ABCD");
			//enter name in the company field
			 driver.findElement(By.id("lea3")).sendKeys("ABCD");
			 //click on the save button
			 Thread.sleep(3000);
			 driver.findElement(By.name("save")).click();
			 
			 String Expectedresult = "bPageTitle";
			 String Actualresult = driver.getTitle();
			 
			 if(Actual.equals(Expected)) {
				 System.out.println("passed");
				 
				 System.out.println("newly created lead view page is displayed");
			}
			 else {
				 System.out.println("failed");
			 }
			 driver.close();
	}

}