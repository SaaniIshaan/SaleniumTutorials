package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumpackage1.ReusableCodes1;

public class TestCase33 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= ReusableCodes.SalesforceLogin();
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		 System.out.println("Login is sucessful");
			Thread.sleep(3000);
			// click on home tab
		driver.findElement(By.linkText("Home")).click();	
		System.out.println("Home page is displayed");
		Thread.sleep(3000);
			// click on the first name and last name link
		driver.findElement(By.linkText("Monika Garg")).click();
		System.out.println("FirstName LastName page is displayed");
			
		System.out.println("verification is completed");
			
			driver.close();
			
			
	}

}
