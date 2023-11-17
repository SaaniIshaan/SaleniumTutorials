package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.browser.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class ReusableCodes {

	public String url = "https://login.salesforce.com/";
	public String username = "mansi@hon.com";
	public String password = "Manu@1234";
	public static WebDriver driver;
   
public static ChromeDriver SalesforceLogin() {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();

driver.get("https://login.salesforce.com");

driver.findElement(By.id("username")).sendKeys("mansi@hon.com");

driver.findElement(By.id("password")).sendKeys("Manu@123");

driver.findElement(By.id("Login")).click();
return driver;
	}    
	
}
