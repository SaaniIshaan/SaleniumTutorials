package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Testcase18 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver driver = ReusableCodes1.SalesforceLogin();
		driver.manage().window().maximize();
		System.out.println("Login is sucessful");
		Thread.sleep(3000);
		//Click on Opportunity
		driver.findElement(By.linkText("Opportunities")).click();
		Thread.sleep(3000);
		String Expected = "Opportunities: Home ~ Salesforce ~ Developer Edition";
		String Actual = driver.getTitle();
		System.out.println("Opportunity home page is displayed");
		Thread.sleep(3000);
		//To view Stuck Opportunity page
		driver.findElement(By.linkText("Stuck Opportunities")).click();
		String Expected1 = "Stuck Opportunities ~ Salesforce ~ Developer Edition";
		String Actual1 = driver.getTitle();
		System.out.println("Actual1");
		System.out.println("\nReport page with Stuck opportunity is displayed\n");
		Assert.assertEquals(Actual1,Expected1);
		driver.close();
		
	}

}
