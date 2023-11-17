package seleniumPackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import seleniumpackage1.ReusableCodes1;

public class TestCase21 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = ReusableCodes.SalesforceLogin();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Leads")).click();
		 driver.findElement(By.id("Lead_Tab")).click();
		 Thread.sleep(5000);
		 String Expected = "Leads: Home ~ Salesforce - Developer Edition";
			String Actual = driver.getTitle();
			System.out.println("Leads home page is displayed");
		 // clicking on the dropdown
		 driver.findElement(By.id("fcf")).click();
		 
		 List<WebElement>webelements = new ArrayList<WebElement>();
			webelements = driver.findElements(By.xpath("//*[@id='fcf']/option"));
			String Expected1[] = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads"};
			
			// to store the text from each element
			ArrayList<String>Actual1 = new ArrayList<String>();
			
			for(WebElement element : webelements) {
				Actual1.add(element.getText());
				System.out.println(element.getText());
			}
			boolean pass = true;
			for(String Expected2 :Expected1) {
				if (!Actual1.contains(Expected2)) {
					pass = false;
					System.out.println(Expected1);
					break;
				}
			}
			if(pass) {
				System.out.println("passed");
			}
			else {
				System.out.println("failed");
			}
			driver.close();
			
		}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	
		
		
		
	}


