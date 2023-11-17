package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import seleniumpackage1.ReusableCodes1;

public class TestCase32 {

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
		// click on new button
		Thread.sleep(3000);
		driver.findElement(By.name("new")).click();
		System.out.println(" New Contact page is displayed");
		Thread.sleep(3000);
		// Enter last name
		WebElement lastname  = driver.findElement(By.name("name_lastcon2"));
		lastname.sendKeys("Indian");
		// Enter Account name
		WebElement accountname  = driver.findElement(By.name("con4"));
		accountname.sendKeys("Global Media");
		// click on save & new
		driver.findElement(By.name("save_new")).click();
		
	String Expected = "No matches found.";
	String Actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[5]/td[2]/div")).getText();

		if(Actual.equals(Expected)) {
		}
		 else {
			 System.out.println("failed");
			 }
		System.out.println("No matches found for Global media");
		
		Assert.assertEquals(Expected, Actual);
		
		driver.close();	
		
		
		
		
		}

}
