package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// Launch app
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		// Enter Username
		driver.findElement(By.name("username")).sendKeys("mansi@hon.com");
		//Enter Password
		driver.findElement(By.name("pw")).sendKeys("Manu@1234");
		//select checkBox
		driver.findElement(By.id("rememberUn")).click();
		//Login
		driver.findElement(By.name("Login")).click();
		
		 driver.findElement(By.id("userNavLabel")).click();
		 
		 driver.findElement(By.linkText("Logout")).click();
		 Thread.sleep(2000);
	
		 String ExpectedText = "mansi@hon.com";
		
		 String ActualText = driver.findElement(By.id("idcard-identity")).getText();
		
		 if(ActualText.equals(ExpectedText)) {
			
			System.out.println("passed");
		 }else {
			System.out.println("failed");
		}
		
		Thread.sleep(2000);
	//	driver.close();
	
		
		
		
		

	}

}
