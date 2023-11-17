package seleniumpackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase19 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		FirefoxDriver driver = ReusableCodes1.SalesforceLogin();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Login is sucessful");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Opportunities")).click();
		Thread.sleep(3000);
		String Expected = "Opportunities: Home ~ Salesforce ~ Developer Edition";
		String Actual = driver.getTitle();
		System.out.println("Opportunity home page is displayed");
		Thread.sleep(3000);
		//click on values from list
		WebElement currentfq = driver.findElement(By.id("quarter_q"));
		currentfq.click();
		
		WebElement dropdown = driver.findElement(By.id("quarter_q"));
		Select s = new Select(dropdown);
		s.selectByValue("current");
		s.selectByValue("next1");
		Thread.sleep(3000);
		
		driver.findElement(By.id("open")).click();
		WebElement dropdown1 = driver.findElement(By.id("open"));
		Select se = new Select(dropdown1);
		se.selectByValue("all");
		WebElement Runreport = driver.findElement(By.name("go"));
		Runreport.click();
		se.selectByValue("open");
		se.selectByValue("closed");
		System.out.println("Quaterly summary report is completed");
		driver.close();
		
	}

}
