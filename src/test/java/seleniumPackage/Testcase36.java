package seleniumPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testcase36{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= ReusableCodes.SalesforceLogin();
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		 System.out.println("Login is sucessful");
			Thread.sleep(3000);
			// click on home tab
		driver.findElement(By.linkText("Home")).click();	
		System.out.println("Home page is displayed with all the required information");
		Thread.sleep(3000);
	//click on current date field
		WebElement currentdatelink = driver.findElement(By.linkText("Sunday August 27, 2023"));
		currentdatelink.click() ; 
		Thread.sleep(3000);
		System.out.println("Calender page is displayed");
	//click on time link
		driver.findElement(By.xpath("//*[@id='p:f:j_id25:j_id61:40:j_id64']/a")).click();
		System.out.println("Calender new Event page is displayed");
		Thread.sleep(3000);
	// click on subject combo icon
		driver.findElement(By.className("comboboxIcon")).click();
		System.out.println("Combobox popup is opened");
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		
		driver.findElement(By.xpath("//a[@href='javascript:pickValue(4);']")).click();
		// driver.switchTo().defaultContent();
				driver.switchTo().window(currentHandle);
				Thread.sleep(2000);
				System.out.println("Popup is closed and other is entered in subject field");
				// click on end date and time field
				
			WebElement enddate = driver.findElement(By.id("EndDateTime"));
			enddate.clear();
			enddate.sendKeys("8/29/2023");
				driver.findElement(By.id("EndDateTime_time")).click();
				System.out.println("End time field dropdown is displayed");
				// select the time from the dropdown
				driver.findElement(By.id("timePickerItem_42")).click();
				System.out.println("time selected");
				
				Thread.sleep(3000);
			// click on save
				driver.findElement(By.name("save")).click();
				System.out.println("Event calender executed sucessfully");
				driver.close();
	}

}

