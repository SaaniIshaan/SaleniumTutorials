package seleniumPackage;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//Launch app
		driver.get("https://login.salesforce.com");

		driver.findElement(By.id("username")).sendKeys("mansi@hon.com");
		
		driver.findElement(By.id("password")).sendKeys("Manu@1234");
		
		driver.findElement(By.id("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("userNavLabel")).click();
		//to store webelements return from the findelements
		ArrayList<WebElement>webelements = new ArrayList<WebElement>();
		
		webelements = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		
		String Expected[] = {"My Profile", "My Settings","Developer Console","Switch to Lightning Experience","Logout"};
		
		// to store the text from each element
				ArrayList<String> Actual = new ArrayList<String>();
				
				for (WebElement element : webelements) {
				Actual.add(element.getText());
				}
				
			boolean pass = true;	
				for(String Expected1 : Expected) {
				if(!Actual.contains(Expected1)) 
					pass = false;
					break;
				}
				
				
				if(pass) {
					System.out.println("passed");
				}
				else {
					System.out.println("failed");
				}
				
		
		}

}
