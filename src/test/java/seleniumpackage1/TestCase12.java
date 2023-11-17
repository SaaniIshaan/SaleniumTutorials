package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase12 {

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
				Thread.sleep(8000);
				driver.findElement(By.id("Account_Tab")).click();
				Thread.sleep(3000);
				WebElement dropDown = driver.findElement(By.id("fcf"));
				Select s = new Select(dropDown);
				s.selectByValue("00BHu00000FuQU6");
				
				Thread.sleep(3000);
				driver.findElement(By.linkText("Edit")).click();
				driver.findElement(By.name("fname")).sendKeys("Efgh");
				Thread.sleep(3000);
				WebElement dropDown1 = driver.findElement(By.id("fcol1"));
				Select se = new Select(dropDown1);
				se.selectByValue("ACCOUNT.NAME");
				WebElement dropDown2 = driver.findElement(By.id("fop1"));
				Thread.sleep(3000);
				Select sa = new Select(dropDown2);
				sa.selectByValue("c");
				Thread.sleep(3000);
				WebElement value = driver.findElement(By.id("fval1"));
				value.clear();
				value.sendKeys("a");
			
				Thread.sleep(3000);
				driver.findElement(By.name("save")).click();
				
				String Actual = driver.findElement(By.name("fcf")).getText();
			System.out.println(Actual);
			Thread.sleep(3000);
				driver.close();
		
				
				
	}

}
