package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFileUtils;
import utils.CommonUtils;

public class LeadsPage extends BasePage {
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	@FindBy(id="Lead_Tab")
	public WebElement LeadsTab;
	
	@FindBy(linkText="Edit")
	public WebElement EditButton;
	
	@FindBy(name="go")
	public WebElement GoButton;
	
	@FindBy(linkText="Create New View")
	public WebElement CreateNewViewLink;
	
	@FindBy(name="go")
	public WebElement RunReport;
	
	@FindBy(name="new")
	public WebElement NewButton;
	
	@FindBy(id="hotlist_mode")
	public WebElement RecentlyViewedLeads;
	
	@FindBy(id="fcf")
	public WebElement Viewdropdown;
	
	@FindBy(id="scope")
	public WebElement Viewleads;
	
	@FindBy(id="name_lastlea2")
	public WebElement LastNameField;
	
	@FindBy(id="name_firstlea2")
	public WebElement FirstNameField;
	
	@FindBy(id="lea5")
	public WebElement LeadSourceField;
	
	@FindBy(id="lea3")
	public WebElement CompanyField;
	
	@FindBy(name="save")
	public WebElement SaveButton;
	
	@FindBy(className="pageDescription")
	public WebElement LeadsHomePage;
	
//	@FindBy(xpath="//*[@id='fcf']/options")
	@FindBy(id="fcf")
	public WebElement AllLeadsItems;
	
	@FindBy(id="userNavLabel")
	public WebElement userMenu;
	
	@FindBy(xpath="//a[@title='Logout']")
	//@FindBy(linkText="Logout")
	public WebElement Logout;
	
	@FindBy(xpath="//div[@id ='userNav-menuItems']/a")
	public WebElement userMenuItems;
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="Login")
	public WebElement loginButton;
	
	
	
	public boolean  verifyLeadsHomePageDisplayed(WebDriver driver) {
		boolean isDisplayedVerified = false;
		if(CommonUtils.waitForElement(driver, LeadsTab)) {
			LeadsTab.click();
		}	
		if(CommonUtils.waitForElement(driver, LeadsHomePage)) {
				isDisplayedVerified = true ;
				logger.info("LeadsPage : Verify LeadsHomePage : LeadsHomePage is Verified");
		}
		return  isDisplayedVerified ;
	}
	
	public boolean verifyAllLeadsItemsShouldBeDisplayed(WebDriver driver) throws IOException {
		boolean isLeadsItemsVerified = false;
		
		if(LeadsHomePage.isDisplayed()) {
			Viewdropdown.click();
			
			String[] expectedAllLeadsItems = CommonFileUtils.readLeadsTestData("LeadsMenuItems").split(",");
			List<WebElement> AllLeadsItems = new ArrayList<WebElement>();
			AllLeadsItems = driver.findElements(By.xpath("//*[@id='fcf']/option"));
			ArrayList<String>actualElementText = new ArrayList<String>();
				
			for(WebElement element : AllLeadsItems) {
					actualElementText.add(element.getText());
			}			
			for(int i=0; i< expectedAllLeadsItems.length; i++) {
				if(actualElementText.contains(expectedAllLeadsItems[i])) {
					System.out.println("Expected Option" + expectedAllLeadsItems[i]);
				}
				else {
					System.out.println("Expected Option" + expectedAllLeadsItems[i] + "Failed to match with Actual option");
				}
				isLeadsItemsVerified = true;
				logger.info("LeadsPage : Verify All Leads items :All Leads Items are verified");
			}
		}
		return isLeadsItemsVerified;
	}
	
	public boolean verifySelectLeadsfromthedropDown(WebDriver driver) {
		boolean isSelected = false;
		if(CommonUtils.waitForElement( driver, AllLeadsItems)) {
			AllLeadsItems.click();
		}
		if(AllLeadsItems.isDisplayed()) {
			BasePage.selectDropdownItems(driver,AllLeadsItems,"Today's Leads");
			BasePage.selectDropdownItems(driver,AllLeadsItems,"My Unread Leads");
			isSelected = true;
		}
			return  isSelected;
	}	
		
		public boolean verifysalesforceLoginPageisAppear (WebDriver driver) {
			boolean  IsLoginPageAppears = false;
			if(CommonUtils.waitForElement( driver,userMenu)) {
				if(userMenu.isDisplayed()) {
					userMenu.click();
					if(CommonUtils.waitforElementToClickable( driver,userMenuItems)) {
						if(CommonUtils.waitforElementToClickable( driver,Logout)) {
							Logout.click();
						}
						IsLoginPageAppears = true;
						logger.info("LeadsPage : Verify Logout from the Page : Logout is verified");
					}
			
				}	
			}
			return IsLoginPageAppears ;
		}	
			public boolean verifyTodaysLeadsPageisDisplayed(WebDriver driver) {
				boolean isTodaysLeadsDisplayed =false;
				if(CommonUtils.waitForElement(driver,GoButton)) {
					GoButton.click();
					isTodaysLeadsDisplayed = true;
					logger.info("LeadsPage : Verify TodaysLeads page is displayed : TodaysLead page is verified");
				}
				return  isTodaysLeadsDisplayed  ;
		
			}
		
			
		
		public boolean verifyNewLeadCreationPagewithDetailsisDisplayed(WebDriver driver) throws IOException {
			boolean  LeadCreationPageisVerified = false ;
			if(LeadsHomePage.isDisplayed()) {
				if(CommonUtils.waitForElement(driver,NewButton)) {
					NewButton.click();
				}	
			}
			if(CommonUtils.waitForElement(driver,LeadsHomePage)) {
				if(LeadsHomePage.isDisplayed()) {
					LastNameField.clear();
					LastNameField.sendKeys(CommonFileUtils.readLeadsTestData("LastName"));
					CompanyField.clear();
					CompanyField.sendKeys(CommonFileUtils.readLeadsTestData("CompanyName"));
					SaveButton.click();
					LeadCreationPageisVerified  = true ;
				 logger.info("LeadsPage : verify New Leads Page with Details : Page is verified");
				 
				}
				
				
			}	
		
			return LeadCreationPageisVerified  ;
		
		}

	}

