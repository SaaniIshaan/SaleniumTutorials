package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableCodes1 {

		public String url = "https://login.salesforce.com";
		public String username = "mansi@hon.com";
		public String password = "Manu@1234";
		public static WebDriver driver;
	   
	public static FirefoxDriver SalesforceLogin() {
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();

	driver.get("https://login.salesforce.com");

	driver.findElement(By.id("username")).sendKeys("mansi@hon.com");

	driver.findElement(By.id("password")).sendKeys("Manu@123");

	driver.findElement(By.id("Login")).click();
		return (FirefoxDriver) driver;
		}
	}

