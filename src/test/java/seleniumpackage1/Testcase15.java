package seleniumpackage1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testcase15 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FirefoxDriver driver = ReusableCodes1.SalesforceLogin();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Opportunities")).click();
		//to store webelements return from the findelements
		
		List<WebElement>webelements = new ArrayList<WebElement>();
		webelements = driver.findElements(By.xpath("//*[@id='fcf']//option"));
		String Expected[] = {"All Opportunities", "Closing Next Month","Closing This Month","My Opportunities","New This Week","Recently Viewed Opportunities","Won"};
		
		// to store the text from each element
		ArrayList<String>Actual = new ArrayList<String>();
		
		for(WebElement element : webelements) {
			Actual.add(element.getText());
			System.out.println(element.getText());
		}
		boolean pass = true;
		for(String Expected1 :Expected) {
			if (!Actual.contains(Expected1)) {
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

