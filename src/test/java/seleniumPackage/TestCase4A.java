package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase4A {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		//launch app
		driver.get("https://login.salesforce.com");
		
		driver.findElement(By.id("forgot_password_link")).click();
		
		driver.findElement(By.id("un")).sendKeys("mansi@hon.com");
		
		driver.findElement(By.id("continue")).click();
		
		String ExpectedText = "We’ve sent you an email with a link to finish resetting your password.";
		
		String ActualText = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/div/p[1]")).getText();
		
		
		 if(ActualText.equals(ExpectedText)) {
				
				System.out.println("passed");
			 }else {
				System.out.println("failed");
			}
			
			Thread.sleep(2000);
			driver.close();
		
		
		
		
		
		

	}

}
