package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		// Launch app
		driver.get("https://login.salesforce.com");
		// Enter username
		driver.findElement(By.id("username")).sendKeys("mansi@hon.com");
		// Enter Password
		driver.findElement(By.id("password")).sendKeys("Manu@1234");
		// Login
		driver.findElement(By.id("Login")).click();
		
		String Expected = "Home";
		
		String Actual = driver.findElement(By.id("home_Tab")).getText();
		
		if(Actual.equals(Expected)) {
			 System.out.println("passed");
		 }
		 else {
			 System.out.println("failed");
		 }
		 Thread.sleep(2000);
		 driver.close();
		

	}

}
