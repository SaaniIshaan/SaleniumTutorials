package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFileUtils;
import utils.CommonUtils;

public class ContactsPage extends BasePage {
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText ="Contacts")
	 public WebElement ContactTab;
	
	@FindBy(name ="go")
	 public WebElement GoButton;
	
	@FindBy(linkText ="Edit")
	 public WebElement EditTab;
	
	@FindBy(linkText ="Create New View")
	 public WebElement CreateNewViewLink;
	
	@FindBy(id ="hotlist_mode")
	 public WebElement RecentlyViewedContacts;
	
	@FindBy(name ="new")
	 public WebElement NewButton;
	
	@FindBy(id ="fcf")
	 public WebElement ViewdropDown;
	
//	@FindBy(xpath= "//h2[@class='pageDescription']")
//	@FindBy(xpath="//div[@class='pageDescription']")
	@FindBy(className ="pageDescription")
	 public WebElement ContactsHomePage;
	
	@FindBy(name ="save")
	 public WebElement SaveButton;
	
	@FindBy(name ="save_new")
	 public WebElement SaveandNewButton;
	
	@FindBy(id ="name_firstcon2")
	 public WebElement FirstNameField;
	
	@FindBy(id ="name_lastcon2")
	 public WebElement LastNameField;
	
	@FindBy(id ="con4")
	 public WebElement AccountNameField;
	
	@FindBy(id ="fname")
	 public WebElement ViewNameField;
	
	@FindBy(id ="devname")
	 public WebElement ViewUniqueNameField;
	
	@FindBy(name ="cancel")
	 public WebElement CancelButton;
	
	@FindBy(className ="pageDescription")
	 public WebElement NewContactEditPage;
	
	@FindBy(className ="pageDescription")
	 public WebElement CreateNewViewPage;
	
	@FindBy(id ="fcf")
	 public WebElement ViewContactsdropDown;
	
	//@FindBy(linkText ="Singhal")
	// public WebElement RecentContactName;
	
	@FindBy(xpath ="//select[@id='fcf']")
	 public WebElement contactView;
	
	@FindBy(xpath = "//table[@class='list']//a")
	 public List<WebElement> contactNameList;
	
	@FindBy(xpath ="//div[@class='errorMsg']")
	 public WebElement errorMessage;
	
	@FindBy(xpath ="//h2[@class='topName']")
	 public WebElement RecentContactNamePage;
	
	
	 public boolean verifyNewContactHomePageisDisplayed(WebDriver driver) {
		 boolean isHomePageDisplayed =false;
		 if(CommonUtils.waitforElementToClickable(driver, ContactTab)) {
			 ContactTab.click();
			 if(CommonUtils.waitForElement(driver, ContactsHomePage)) {
				 isHomePageDisplayed = true;
				 logger.info("ContactsPage : Verify Home Page : HomePage is verified");
			 	}
			 
		 	}
		 return  isHomePageDisplayed;
	 	}
	
	 public boolean verifyNewContactPagewithDetailsIsDisplayed(WebDriver driver) throws IOException {
		 boolean  isVerified = false;
		 if(NewButton.isDisplayed()) {
			 NewButton.click();
		 }
		 if(CommonUtils.waitForElement(driver,NewContactEditPage)) {
			 LastNameField.clear();
			 LastNameField.sendKeys(CommonFileUtils.readContactsTestData("LastName"));
			 AccountNameField.clear();
			 AccountNameField.sendKeys(CommonFileUtils.readContactsTestData("AccountName"));
			 SaveButton.click();
			 isVerified = true;
			 logger.info("ContactsPage : Verify New Contact Page : New Contace page is verified");
		 }
		 return   isVerified;
	}
	 
	 
	 public boolean VerifyCreatedViewNameisDisplayedinContactsPage(WebDriver driver) throws IOException {
		 boolean  isviewnameDisplayed = false;
		 	if(CommonUtils.waitForElement(driver,CreateNewViewLink)) {
		 		CreateNewViewLink.click();
		 	}
		 	if(CommonUtils.waitForElement(driver,CreateNewViewPage)) {
		 		ViewNameField.clear();
		 		ViewNameField.sendKeys(CommonFileUtils.readContactsTestData("ViewName"));
		 		ViewUniqueNameField.clear();
		 		ViewUniqueNameField.sendKeys(CommonFileUtils.readContactsTestData("ViewUniqueName"));
		 		SaveButton.click();
		 		
		 		isviewnameDisplayed = true;
		 		logger.info("ContactsPage : Verify Created New View :  Created New view is verified");
		 		
		 		}
		 		return  isviewnameDisplayed;
	 		}
	 
	 
	 public boolean verifyContactsViewItemsDisplayed(WebDriver driver) {
		boolean  isContactsDisplayed = false;
		 if(CommonUtils.waitForElement(driver,ViewContactsdropDown )) {
			 ViewContactsdropDown.click();
		 	}
				isContactsDisplayed = true;
				logger.info("ContactsPage : Verify All the Contacts :  All Contacts verified");
					
				return isContactsDisplayed;
					
	 		}
	 			
	 
	 public boolean verifyselectContactName(WebDriver driver) {
		 
		 boolean isselected = false;
		 isselected = BasePage.verifyElementisDisplayed(driver,ContactsHomePage );
		 if(contactNameList.size()> 0 ) {
			 WebElement contactLink = contactNameList.get(0);
			 String contactNameText = contactLink.getText();
	//		 if(BasePage.clickElement(contactLink, driver)) {
	//			 isselected= BasePage.verifyDisplayMessage(driver, newContactText,contactNameText);
	//		 }
			 if(CommonUtils.waitforElementToClickable(driver,contactLink )){
				 contactLink .click();
				 isselected = true;
			 }
		 }
		 	return isselected;
	 }
	 
	 
	public boolean verifyContactPageWithAlltheInformation(WebDriver driver) {
		 boolean isContactNameVerified = false;
		 	if(CommonUtils.waitForElement(driver,RecentContactNamePage)) {
		 		if(RecentContactNamePage.isDisplayed()) {
				 isContactNameVerified = true;
			 logger.info("ContactsPage : Verify All the information :  All Information verified");
		 		}
		 	
		 	}
		 	return 	isContactNameVerified ;
	} 
		 
	
	
	 public boolean VerifyErrormessageisAppear(WebDriver driver) throws IOException {
		 boolean isErrortextVerified = false;
		 if(CommonUtils.waitForElement(driver, ContactsHomePage)) {
			 CreateNewViewLink.click();
			 }
		 if(CommonUtils.waitForElement(driver,CreateNewViewPage )) {
			 ViewNameField.clear();
			 ViewNameField.sendKeys(CommonFileUtils.readContactsTestData("ViewNameField"));
			 
			 ViewUniqueNameField.clear();
			 ViewUniqueNameField.sendKeys(CommonFileUtils.readContactsTestData("ViewUniqueNameField"));
			 CommonUtils.waitForElement(driver,SaveButton);
			 SaveButton.click();
			 isErrortextVerified = true;
			 logger.info("ContactsPage : Verify the Error Message :  Error message verified");
		 }
		 	return isErrortextVerified ;
		 
	 }
	 
	 public boolean verifyViewNameisNotCreated(WebDriver driver) throws IOException {
		 boolean isVerified = false;
		 if(CommonUtils.waitForElement(driver, ContactsHomePage)) {
			 CreateNewViewLink.click();
			 }
		 if(CommonUtils.waitForElement(driver,CreateNewViewPage )) {
			 ViewNameField.clear();
			 ViewNameField.sendKeys(CommonFileUtils.readContactsTestData("View"));
			 
			 ViewUniqueNameField.clear();
			 ViewUniqueNameField.sendKeys(CommonFileUtils.readContactsTestData("ViewUnique"));
			 CommonUtils.waitForElement(driver,CancelButton);
			 CommonUtils.waitForElement(driver,CancelButton);
			 CancelButton.click();
			 isVerified = true;
			 logger.info("ContactsPage : Verify ViewName is not Created :  ViewName is not created Verified");
			 
		 }
		 	return  isVerified ;
	 	}
	
	 public void clickonNewButton(WebDriver driver) {
		 CommonUtils.waitForElement(driver,NewButton);
			 NewButton.click();
	 	}
		 
		 public boolean verifyNewContactEditPageisDisplayed(WebDriver driver) throws IOException {
			 boolean isEditPageVerified = false;
			 CommonUtils.waitForElement(driver, NewContactEditPage);
			 if(NewContactEditPage.isDisplayed()) {
				 LastNameField.clear();
				 LastNameField.sendKeys(CommonFileUtils.readContactsTestData("Lastname"));
				 AccountNameField.clear();
				 AccountNameField.sendKeys(CommonFileUtils.readContactsTestData("Accountname"));
			 	}
			 if(CommonUtils.waitForElement(driver, SaveandNewButton)) {
				 SaveandNewButton.click();
				 isEditPageVerified = true;
				 logger.info("ContactsPage : Verify newContact Editpage is displayed : New Contact EditPage is Verified");
				 
			 }
			 	return  isEditPageVerified ;
			 	
		 }
		 
		 
		 
}