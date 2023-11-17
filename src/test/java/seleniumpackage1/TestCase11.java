package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase11 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				WebDriverManager.firefoxdriver();
				WebDriver driver = new FirefoxDriver();
				
				driver.get("https://login.salesforce.com");
				driver.manage().window().maximize();
				// Enter Username
				driver.findElement(By.name("username")).sendKeys("mansi@hon.com");
				//Enter Password
				driver.findElement(By.name("pw")).sendKeys("Manu@1234");
				//Login
				driver.findElement(By.name("Login")).click();
				 Thread.sleep(5000);
				driver.findElement(By.id("Account_Tab")).click();
				
				driver.findElement(By.linkText("Create New View")).click();
				Thread.sleep(2000);
				driver.findElement(By.name("fname")).sendKeys("Abcd");
				driver.findElement(By.name("devname")).sendKeys("Abcd");
				driver.findElement(By.name("save")).click();
				
				String ActualText = "";
				String ExpectedText = "";
				
				if(ActualText.equals(ExpectedText)) {
					 System.out.println("passed");
			 }
				 else {
					 System.out.println("failed");
					 }
				 Thread.sleep(2000);
				 driver.close();
				
				
	}

}
