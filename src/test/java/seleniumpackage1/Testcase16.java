package seleniumpackage1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Testcase16 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver driver = ReusableCodes1.SalesforceLogin();
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Login successful");
		driver.findElement(By.linkText("Opportunities")).click();
		Thread.sleep(3000);
		System.out.println("Opportunity home page is displayed");
		// click on new opportunity, edit page is displayed
		driver.findElement(By.name("new")).click();
		
		// Enter value in opportunity field
		driver.findElement(By.id("opp3")).sendKeys("opp1");
		// Enter value in Account field
		driver.findElement(By.id("opp4")).sendKeys("Acc1");
	 	// Click on lead source
	    driver.findElement(By.id("opp6")).click();
	    WebElement dropdown = driver.findElement(By.id("opp6"));
	    Select s = new Select(dropdown);
		s.selectByValue("Purchased List");
		Thread.sleep(2000);
		// enter date in closed date field
		WebElement closedate = driver.findElement(By.id("opp9"));
		closedate.clear();
		closedate.sendKeys("8/27/2023");
	 // select stage
		WebElement stage = driver.findElement(By.id("opp11"));
		WebElement Select;
		Select stage1 = new Select(dropdown);
		stage1.selectByValue("Prospecting");
	// select probability
		WebElement probability = driver.findElement(By.id("opp12"));
		probability.sendKeys("1");
		// select campaign source
	WebElement campaignsource = driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/form/div/div[2]/div[3]/table/tbody/tr[6]/td[4]/span/a/img"));

		
		
		
	}
}