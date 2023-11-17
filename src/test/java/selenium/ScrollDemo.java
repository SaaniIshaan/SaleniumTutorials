package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDemo {
  @Test
  public void f() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.apple.com/in/");
	  Thread.sleep(3000);
	  Actions actions = new Actions(driver);
	//  scrolls little down by 2000 px
	  actions.scrollByAmount(0, 3000).build().perform();
	  
	  //scrolls little up by 1000 px
	//  actions.scrollByAmount(0, -1000).perform();
	  
	  WebElement element = driver.findElement(By.xpath("//a[@class='unit-link']"));
	  element.click();
	  
  }
}
