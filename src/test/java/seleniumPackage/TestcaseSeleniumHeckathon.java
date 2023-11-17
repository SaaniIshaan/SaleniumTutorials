package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestcaseSeleniumHeckathon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		
		 //launch the app
		 driver.get( "https://www.xe.com/" );
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		//select INR in To 
	
	  driver.findElement(By.xpath("(//input[@type'text'])[3]")).click();
	//	Thread.sleep(3000);
  	  driver.findElement(By.xpath("(//input[@type'text'])[3]")).sendKeys("inr");
  	  
	
	driver.findElement(By.xpath("(//*[(contains(@class,'converterform-dropdown_option') or contains(@class,'Listboxoption')) and contains(.,'INR']")).click();
		
	driver.findElement(By.xpath("(//*[@id=\"__next\"]/div[3]/div[2]/section/div[2]/div/main/div/div[2]/button")).click();
		
		
		String expected = "Xe: Currency Exchange Rates and International Money Transfer";
		String actual = driver.getTitle();
		if(actual.contains(expected)) {
			System.out.println("Test is Successful");
			
		}else {
			System.out.println("Test is Failed");
		}
			
      System.out.println(actual);
		
      driver.close();
	}
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	