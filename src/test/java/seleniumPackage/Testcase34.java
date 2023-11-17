package seleniumPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testcase34 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= ReusableCodes.SalesforceLogin();
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		 System.out.println("Login is sucessful");
			Thread.sleep(3000);
			// click on home tab
		driver.findElement(By.linkText("Home")).click();	
		System.out.println("Home page is displayed");
		Thread.sleep(3000);
			// click on the first name and last name link
		driver.findElement(By.linkText("Monika GargAbcd")).click();
	System.out.println("FirstName LastName page is displayed");
		//click on the edit profile icon
		
		driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img")).click();
	//	 driver.findElement(By.xpath("//div[@class='contactInfo profileSection']//img")).click();
		Thread.sleep(3000);
		 driver.switchTo().frame(2);
		 driver.findElement(By.linkText("About")).click();
		// focus should be on the first name field
		// Enter last name
			WebElement lastname  = driver.findElement(By.name("lastName"));
			lastname.clear();
			lastname.sendKeys("Abcd");
		 //Click on save all button
			WebElement saveall  = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
			saveall.click();
			System.out.println("Edit profile popup is closed");
			System.out.println("Edited LastName Executed sucessfully");
			driver.close();
	
	}

}

