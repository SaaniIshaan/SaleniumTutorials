package seleniumpackage1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase14 {

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
				Thread.sleep(7000);
				driver.findElement(By.id("Account_Tab")).click();
				Thread.sleep(3000);
				driver.findElement(By.linkText("Accounts with last activity > 30 days")).click();
				driver.findElement(By.id("ext-gen20")).click();
				WebElement dropdown = driver.findElement(By.id("ext-gen20"));
				driver.findElement(By.xpath("//div[@class='x-combo-list-item']")).click();
				
				// Read From field, click on calendar and then today

				driver.findElement(By.id("ext-gen152")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("ext-gen281")).click();
				
				// Read To field, click on calendar and then today
	
				driver.findElement(By.id("ext-gen154")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("ext-gen296")).click();
				
				// Save report
				driver.findElement(By.id("ext-gen49")).click();
				
				driver.findElement(By.id("saveReportDlg_reportNameField")).sendKeys("My first report");
				
				 driver.findElement(By.id("saveReportDlg_DeveloperName")).clear();
			
				//creating new Report
				driver.findElement(By.id("saveReportDlg_DeveloperName")).sendKeys("My_first_report12");
				driver.findElement(By.id("ext-comp-1067")).sendKeys("My first report created on 8/25");
				Thread.sleep(2000);
				driver.findElement(By.id("ext-gen316")).click();
				
				String Expected = "My first report ~ Salesforce - Developer Edition";
				String Actual = driver.getTitle();
				
				//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(""))));
				Thread.sleep(5000);
				 System.out.println(Actual);
				 if(Actual.equals(Expected)) {
					 System.out.println("passed");
			 }
				 else {
					 System.out.println("failed");
					 }
				 
				 Thread.sleep(2000);
				// driver.close();
				
				
			//	System.out.println("New Report page is displayed");
	}

}
