package seleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
		
		driver.findElement(By.name("username")).sendKeys("mansi@hon.com");
		
		driver.findElement(By.name("pw")).sendKeys("Manu@1234");
		
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
		 driver.findElement(By.id("userNavLabel")).click();
		 
		 driver.findElement(By.linkText("My Profile")).click();
		
		 Thread.sleep(2000);
	
		 driver.findElement(By.xpath("//div[@class='contactInfo profileSection']//img")).click();
		 Thread.sleep(3000);
		 driver.switchTo().frame(2);
		 driver.findElement(By.linkText("About")).click();
		 // change the last name of user profile
		 WebElement lastName = driver.findElement(By.id("lastName"));
		 lastName.clear();
		 lastName.sendKeys("Garg");
		 driver.findElement(By.xpath("//input[@value='Save All']")).click();	
		 driver.switchTo().parentFrame();
		// driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")).click();
		// driver.findElement(By.linkText("Post")).click();
		// driver.switchTo().frame(0);
		 //Edit post link
		 Thread.sleep(3000);
		 driver.findElement(By.id("publisherAttachTextPost")).click();
		 Thread.sleep(3000);
		 WebElement postIframe = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
		 driver.switchTo().frame(postIframe);
		 WebElement postbody = driver.findElement(By.xpath("html/body[1]")); 
		 postbody.click();
		 postbody.sendKeys("final text");
		 String parent = driver.getWindowHandle();
		 driver.switchTo().window(parent);
		 driver.findElement(By.id("publishersharebutton")).click();
		 System.out.println("Text posted is shared");
		 
		 // uploading a file
		 Thread.sleep(3000);
		 driver.findElement(By.id("publisherAttachContentPost")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.id("chatterUploadFileAction")).click();
		 Thread.sleep(3000);
		/* WebElement chooseFile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		 enterText(choosefile,  );
		// driver.findElement(By.xpath("//input[@id='chatterFile']")).sendKeys();
		 Thread.sleep(3000);
		 driver.findElement(By.id("publishersharebutton")).click();
		 Thread.sleep(3000);
		*/ 
		 // uploading a photo
		 
		 
		 
		 
		 
		 
		 
		// driver.findElement(By.xpath("/html/body")).sendKeys("number 2");
		// driver.switchTo().parentFrame();
		// driver.findElement(By.id("publishersharebutton")).click();
		// System.out.println("Text posted is shared");
		
	// Thread.sleep(3000);
		// uploading a file 
		// driver.findElement(By.xpath("//*[@id='publisherAttachContentPost']/span[1]")).click();
		// driver.findElement(By.id("chatterUploadFileAction")).click();
		// Thread.sleep(5000);*/
	
	
	}

}
