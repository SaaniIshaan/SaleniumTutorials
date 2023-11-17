import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

	public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	//  Setup Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
	//	launch Browser.....
		 driver.get("https://selenium-prd.firebaseapp.com/");
		// driver.get("https://login.salesforce.com");
			driver.manage().window().maximize(); // for maximizing the window
			
		 driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com ");
		 driver.findElement(By.id("password_field")).sendKeys("admin123");
		 driver.findElement(By.xpath("//*[text()='Login to Account']")).click();
		 Thread.sleep(3000);
	//	Radio buttons
		 driver.findElement(By.xpath("//input[@value ='female']")).click();
		 driver.findElement(By.xpath("//a[text() ='Home']")).click();	
	//	 dropdown
		 WebElement dropdown = driver.findElement(By.id("city"));
	//	 select
	//	 Select city = new Select(dropdown);
	//	 city.selectByValue("mumbai");
	//	 city.deselectByIndex(1);
		 
		 WebElement dropDown  = driver.findElement(By.id("District"));
	//	 Select district = new Select(dropDown);
	//	district.selectByValue("District");
		
	//	 dropDown = driver.findElement(By.name("pincode"));
	//	Select pincode = new Select(dropDown);
	//	pincode.selectByValue("label");
		
		dropDown = driver.findElement(By.xpath("Email id"));
		Select emailID = new Select (dropDown);
		emailID.selectByValue("Email-ID");
		
		Thread.sleep(2000);
		 driver.quit();
		 
		 
		/*	
			driver.findElement(By.xpath("//input[@value='female']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//a[text()='Home']")).click();
			
			WebElement dropDown = driver.findElement(By.id("city"));
	//		Select
			Select city = new Select(dropDown);
			city.selectByValue("mumbai");
			Thread.sleep(2000);
			driver.quit();*/
	}

}
