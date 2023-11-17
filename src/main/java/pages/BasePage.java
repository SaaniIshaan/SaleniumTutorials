package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtils;

public class BasePage {
	
	
	public static Logger logger = LogManager.getLogger("BASETEST");
	
	public static boolean verifyElementisDisplayed(WebDriver driver,  WebElement element) {
			boolean elementDisplayed = false;
			if(CommonUtils.waitForElement(driver, element)) {
				if(element.isDisplayed()) {
					elementDisplayed = true;
					logger.info("Page : verifyElementisDisplayed");
				}
			}	
			return elementDisplayed ;
			
	}
	
	
	
	public static boolean verifyDisplayMessage( WebElement element, String sMessage) {
		
		boolean messageDisplayed = false;
		
		if(element.isDisplayed()) {
			String sActualMessage = element.getText();
			System.out.println("sActualMessage:" +sActualMessage);
				if(sActualMessage.contains(sMessage)) {
					logger.info(" Page : Display message is verified ");
					messageDisplayed = true;
				}
		}
		
		return messageDisplayed;
	}
	
	
	
	 public static boolean selectMenuItems(WebDriver driver,  WebElement element) {
			
		boolean  isSelected = false;
		if(CommonUtils.waitForElement(driver, element)) {
			if(element.isDisplayed()) {
				element.click();
				logger.info(" Page : MenuItems selected ");
				isSelected = true;
			}
		}
		return isSelected;
	 }
	 
	 public static boolean assignInputvalue(WebDriver driver, WebElement element, String sValue) {
		 
		 boolean isValueassigned = false;
		 if(CommonUtils.waitForElement(driver, element)) {
			 element.clear();
			 element.sendKeys("Created Date");
			 
			 logger.info(" Page : assigned InputValue ");
			 isValueassigned = true;
		 }
		 return  isValueassigned;
	 }
	 
	 
	 public static boolean selectDropdownItems(WebDriver driver, WebElement dropdown, String sOptionvalue) {
		boolean  isSelected = false;
	//	if(CommonUtils.waitForElement(driver, dropdown)) {
		if (CommonUtils.waitforElementToClickable(driver, dropdown)) {
			 if(dropdown.isDisplayed()) {
					dropdown.click();
					Select select = new Select(dropdown);
					select.selectByVisibleText(sOptionvalue);
					
					isSelected = true;
			 } 
			 
		}
		 	return isSelected;
	}	 

	public static boolean clickElement(WebElement element, WebDriver driver) {

		boolean isButtonClicked = false;
			if (CommonUtils.waitForElement(driver, element)) {
					element.click();
						isButtonClicked = true;
			}
			return  isButtonClicked;
	}
	
	
	public static boolean validatetitle(WebDriver driver,String expectedmessage) {
		boolean messageDisplayed = false;
		
		String sActualMessage = driver.getTitle();
		if(sActualMessage.equals(expectedmessage) ) {
			messageDisplayed = true;
		}
		return messageDisplayed;
	}



	
	
	
	
	
	
}






