package seleniumpackage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SeleniumAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new FirefoxDriver();
		
	//	void accept								methods//
	//	void dismiss
	//	void sendKeys(String sendKeys)
	//	String getText();
		driver.get("prd.firebaseapp.com/");
		driver.manage().window().maximize();
		
		WebElement alertbox = driver.findElement(By.id("alert"));
		alertbox.click();
		
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		Thread.sleep(4000);
		alert.accept();
	}

}
