package tests;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import constants.FileConstants;

public class BaseTest {
	private static ThreadLocal<WebDriver>threadLocalDriver = new ThreadLocal<>();
	
	static ExtentReports extent = new ExtentReports();
	static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	
	public static Logger logger = LogManager.getLogger("BASETEST");
	
	
	// Requirements
	// Cross browser support
	// parallel support -
	// Proper reporting - Accurate Assertions, Screenshots
	// Support of Logs in the framework
	
	@BeforeMethod
	public void setup(java.lang.reflect.Method name){
		BaseTest.test = extent.createTest(name.getName());
		logger.info("BaseTest : setup :"+name.getName()+" Test Object for reporting is created");
	}
	//@AfterTest
	@AfterMethod
	public void tearDown(java.lang.reflect.Method name) { 
		logger.info("BaseTest : tearDown :"+name.getName()+" Tear down called");
	}
	@Parameters({"browserName","isHeadless"})
	@BeforeTest
	public static void setDriver() {
		spark = new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
		extent.attachReporter(spark);
		logger.info("BaseTest : setDriver : Spark report configured");
		WebDriver driver = BaseTest.getBrowserType("Chrome",false);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("BaseTest : setDriver : driver object assigned");
		threadLocalDriver.set(driver);
	}	
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	@AfterTest
	public static void removeDriver() {
		//getDriver().close();
		threadLocalDriver.remove();
		logger.info("BaseTest : removeDriver : removed driver");
		 extent.flush();
	}
	
	
	public static WebDriver getBrowserType(String browserName, boolean headless) {
		WebDriver driver = null;
		String browserType = browserName.toLowerCase();
		switch (browserType) {
		case  "chrome":
			if(headless) {
			ChromeOptions co = new ChromeOptions();
			logger.info("BaseTest : getBrowserType : Headless chrome configured");
			co.addArguments("--headless");
			driver = new ChromeDriver(co);
			}else {
				driver = new ChromeDriver();
				logger.info("BaseTest : getBrowserType : Chrome configured");
			}
			break;
	
		case "firefox":
			if(headless) {
				FirefoxOptions fo = new FirefoxOptions();
				logger.info("BaseTest : getBrowserType : Headless Firefox configured");
				fo.addArguments("--headless");
			driver = new FirefoxDriver(fo);
			}else {
				driver = new FirefoxDriver();
			logger.info("BaseTest : getBrowserType : Firefox configured");
			}
			break;
	
		case "safari":
			
			driver = new SafariDriver();
			logger.info("BaseTest : getBrowserType : Safari configured");
		
			break; 

		case "edge":
			driver = new EdgeDriver();
			logger.info("BaseTest : getBrowserType : EdgeDriver configured");
			break;
		
		default:
			driver = null;
			break;
	  }	
	  return driver;
	
	}
}