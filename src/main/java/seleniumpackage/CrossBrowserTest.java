package seleniumpackage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTest {
	WebDriver  driver;
	FirefoxOptions firefoxoptions = new FirefoxOptions();
	ChromeOptions chromeoptions = new ChromeOptions();
	EdgeOptions edgeoptions = new EdgeOptions();
	
	@Parameters("browser")
	@BeforeTest
	public void initializeBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Firefox is launched");
		}
		else if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Chrome is launched");
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge is launched");
		}
		
	}
	
	@Test
	public void validateGoogleTitle() {
		driver.get("https://www.google.com");
		String getGoogleTitle = driver.getTitle();
		String ExpectedTitle = "Google";
		Assert.assertEquals(getGoogleTitle.contains("Google"),ExpectedTitle.contains("Google"));
		System.out.println("validation is successful");
	}
	
	@AfterTest
	public void EndTest() {
		driver.quit();
	}
	
}
