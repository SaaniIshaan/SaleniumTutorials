package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestCase27 {

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
		// click on recently created contacts
		Thread.sleep(3000);
		driver.findElement(By.id("hotlist_mode")).click();
		// dropdown is selected
		WebElement dropdown = driver.findElement(By.id("hotlist_mode"));
		Select createdview = new Select(dropdown);
		createdview.selectByVisibleText("Recently Viewed");
		Thread.sleep(3000);
		//Recently viewed contacts is displayed
		
		System.out.println("Recently viewed contact is displayed");
		
		
		
		driver.close();	
		
	}
	
}
