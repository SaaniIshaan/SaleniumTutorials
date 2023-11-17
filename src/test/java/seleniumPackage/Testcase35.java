package seleniumPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Testcase35 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= ReusableCodes.SalesforceLogin();
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		 System.out.println("Login is sucessful");
			Thread.sleep(3000);
		// click on the + tab	
			driver.findElement(By.id("AllTab_Tab")).click();
			// click on customized my tabs
			driver.findElement(By.name("customize")).click();
			 System.out.println("Customize my Tabs page is displayed");
			// click on selected tab
			 
		WebElement Chatter = driver.findElement(By.xpath("//option[@value='Chatter']"));
		Chatter.click() ;  
		WebElement leftarrow = driver.findElement(By.id("duel_select_0_left"));
		leftarrow.click() ;  
		WebElement save = driver.findElement(By.xpath("//input[@class='btn primary']"));
		save.click() ;  
		System.out.println("The alltabs page is displayed");
		System.out.println("Chatter is removed from the tab bar");
		Thread.sleep(3000);
		WebElement  usermenu = driver.findElement(By.id("userNavLabel"));
		usermenu.click() ; 
		// user menu dropdown is displayed
		WebElement logout = driver.findElement(By.linkText("Logout"));
		logout.click() ;  
		System.out.println("user is successfully logged out");
		Thread.sleep(3000);
		ChromeDriver driver1 = ReusableCodes.SalesforceLogin();
		
		System.out.println("user is successfully logged in");
		System.out.println("The removed Tab is not displayed in the tab bar");
		driver.close();

	}
}
