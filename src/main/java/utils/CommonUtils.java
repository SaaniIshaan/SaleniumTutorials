package utils;

import java.io.File;
import java.io.IOException;

 import java.util.Date;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FileConstants;
import constants.WaitConstants;

public class CommonUtils {
	
//	private static final String FileConstants.SCREENSHOT_PATH = null;
	
	public static boolean waitForElement(WebDriver driver, WebElement element) {
		boolean isElementClickable = false;
	
	WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT);
	
	try {
		wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable = true;
		}catch(Exception e) {
		e.printStackTrace();
	}
	return isElementClickable;
}

	public static boolean waitForElementToDisappear(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
	
	WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT_TO_DISAPPER);
	
	try {
		wait.until(ExpectedConditions.invisibilityOf(element));
			isElementFound = true;
		}catch(Exception e) {
		e.printStackTrace();
	}
	return isElementFound;
	}
	
	public static boolean waitforElementToVisible(WebDriver driver, WebElement element) {
		boolean isElementVisible = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT_TO_VISIBLE);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementVisible = true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isElementVisible ;
		
  }
	public static boolean waitforElementToClickable(WebDriver driver, WebElement element) {
		boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_ELEMENT_TO_CLICKABLE);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable = true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isElementClickable ;
	}
	
	public static boolean waitforTitleContains(WebDriver driver, String sMessage ) {
		boolean isTitleContains = false;
		WebDriverWait wait = new WebDriverWait(driver, WaitConstants.WAIT_FOR_TITLE_CONTAINS);
		try {
			wait.until(ExpectedConditions.titleContains(sMessage));
				isTitleContains = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isTitleContains;
		
	}
	
	public static void moveToElement(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static String getStringDateAndTimeStamp() {
		String value = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	//	String value = "20230903053400";
		return  value;
	}

	public static String getScreenshot(WebDriver driver) throws IOException {
		
		String path = FileConstants.SCREENSHOT_PATH ;
		TakesScreenshot screen =(TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		  
		File dst = new File(path );
		FileUtils.copyFile(src,dst);
		
		return path;
	}
	
	
}
