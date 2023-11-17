package seleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
		
	driver.findElement(By.name("username")).sendKeys("mansi@hon.com");
		
	driver.findElement(By.name("pw")).sendKeys("Manu@1234");
		
	driver.findElement(By.xpath("//input[@name='Login']")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("userNavLabel")).click();
		 
	 driver.findElement(By.linkText("My Settings")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.id("PersonalInfo_font")).click();
		Thread.sleep(1000);
	driver.findElement(By.id("LoginHistory_font")).click();
	
	driver.findElement(By.linkText("Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »")).click();
	Thread.sleep(1000);
	driver.findElement(By.id("DisplayAndLayout_font")).click();
	
	driver.findElement(By.id("CustomizeTabs_font")).click();
		
		WebElement dropdown = driver.findElement(By.id("p4"));
		Select se = new Select(dropdown);
		// se.selectByVisibleText("Salesforce Chatter");
		se.selectByValue("02uHu000001HuhH");
		
		//Actions action = new Actions(driver);
		//action.clickAndHold(from).moveToElement(to).release(to).build().perform();
		WebElement dropdown1 = driver.findElement(By.id("duel_select_0"));
		Select s = new Select(dropdown1);
	    s.selectByValue("report");	
	    driver.findElement(By.xpath("//*[@id='duel_select_0_right']/img")).click();
	    
	    driver.findElement(By.id("EmailSetup_font")).click();
	    
	    driver.findElement(By.id("EmailSettings_font")).click();
	    
	    driver.findElement(By.name("sender_name")).click();
	    driver.findElement(By.name("sender_email")).click();
	    driver.findElement(By.xpath("//input[@id='auto_bcc1']")).click();
	    driver.findElement(By.name("save")).click();
	    
	    String Expected = "Your settings have been successfully saved.";
	    String Actual = driver.findElement(By.xpath("//div[@class='messageText']")).getText();
	    
	    if(Actual.equals(Expected)) {
			System.out.println("Passed");
			}
		else {
			System.out.println("Failed");
		}
	    System.out.println("Email options saved");
	    
	    driver.findElement(By.id("CalendarAndReminders_font")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("Reminders_font")).click();
	    driver.findElement(By.id("testbtn")).click();
	    System.out.println("Sample window is poped up");
	    
	    Thread.sleep(3000);
	    driver.close();
	}


}
