package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase13 {

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
				System.out.println("Login is sucessful");
				Thread.sleep(5000);
				driver.findElement(By.id("Account_Tab")).click();
				Thread.sleep(3000);
				String Expected = "Accounts: Home ~ Salesforce - Developer Edition";
				String Actual =driver.getTitle();

				 if(Actual.equals(Expected)) {
					
					System.out.println("passed");
				 }else {
					System.out.println("failed");
				}
				 System.out.println("Account page is displayed");
				 
			// To merge Accounts	
				
				driver.findElement(By.linkText("Merge Accounts")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("srch")).sendKeys("ab");
				driver.findElement(By.name("srchbutton")).click();
			
				driver.findElement(By.name("goNext")).click();
				Thread.sleep(3000);
				driver.findElement(By.name("save")).click();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				
			System.out.println("Merge Account is completed");	
				driver.close();
	}

}
