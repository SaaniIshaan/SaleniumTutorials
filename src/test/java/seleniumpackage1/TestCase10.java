package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase10 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//	FirefoxDriver driver= ReusableCodes1.SalesforceLogin();
		// driver.manage().window().maximize();
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
		
		Thread.sleep(3000);
		driver.findElement(By.name("new")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("acc2")).click();
		
		WebElement dropDown = driver.findElement(By.name("acc6"));
		Select s = new Select(dropDown);
		s.selectByValue("Technology Partner");
	
		Thread.sleep(2000);
		WebElement dropDown1 = driver.findElement(By.name("00NHu00000PIrjl"));
		// WebElement dropDown1 = driver.findElement(By.xpath("//div[@class['labelCol']"));
		Select se = new Select(dropDown1);
		se.selectByVisibleText("High");
		System.out.println("Test case is passed");
		WebElement Save = driver.findElement(By.name("save"));
		Save.click();
		System.out.println("Clicked on Save button");
		System.out.println("New account is displayed");
		
		
		driver.close();
	}

}
