package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestCase17 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver driver = ReusableCodes1.SalesforceLogin();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println("Login is sucessful");
		Thread.sleep(3000);
		//Click on Opportunity
		driver.findElement(By.linkText("Opportunities")).click();
		Thread.sleep(5000);
		String Expected = "Opportunities: Home ~ Salesforce ~ Developer Edition";
		String Actual = driver.getTitle();
		System.out.println("Opportunity home page is displayed");
		// Click on Opportunity pipeline link
		driver.findElement(By.linkText("Opportunity Pipeline")).click();
		Thread.sleep(5000);
		String Expected1 = "Opportunities Pipeline"; 
		String Actual1 = driver.getTitle();
		System.out.println("Report page with pipelined opportunity is displayed");
		Assert.assertEquals(Actual1,Expected1);
		Thread.sleep(3000);
		//driver.close();
		
		}

}
