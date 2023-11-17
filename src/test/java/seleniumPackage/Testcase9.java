package seleniumPackage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase9 {

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
		
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(3000);
		
		//to store webelements return from the findelements
		ArrayList<WebElement>webelements = new ArrayList<WebElement>();
				
		webelements = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
				
		String Expected[] = {"My Profile", "My Settings","Developer Console","Switch to Lightning Experience","Logout"};
				
		// to store the text from each element
		ArrayList<String> Actual = new ArrayList<String>();
						
			for (WebElement element : webelements) {
				Actual.add(element.getText());
			}
			
			
		driver.findElement(By.linkText("Logout")).click();
			
			
		String Expected1 = "Login | Salesforce";
			
		String Actual1 = driver.getTitle();

				if(Actual1.equals(Expected1)) {
					 System.out.println("passed");
				 }
				 else {
					 System.out.println("failed");
				 }
			Thread.sleep(2000);
			driver.close();

	}

}
