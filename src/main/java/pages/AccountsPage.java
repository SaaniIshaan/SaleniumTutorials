package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import constants.FileConstants;
import tests.BaseTest;
import utils.CommonFileUtils;
import utils.CommonUtils;

public class AccountsPage extends BasePage{
	
	public AccountsPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(id ="Account_Tab")
	public WebElement AccountTab;
	
	@FindBy(name="new")
	public WebElement NewButton;
	
	@FindBy(id="acc2")
	public WebElement AccountName;
	
	@FindBy(linkText="Create New View")
	public WebElement CreateNewViewLink;
	
	@FindBy(className="pageDescription")
	public WebElement CreateNewViewPage;
	
	@FindBy(id="fname")
	public WebElement viewname; 
	
	@FindBy(id="devname")
	public WebElement viewUniquename; 
	
	//@FindBy(xpath="//select[@id='fcf']")
	@FindBy(id="fcf")
	public WebElement Viewdropdown;
	
	@FindBy(linkText="Edit")
	public WebElement EditButton;
	
	@FindBy(name="save")
	public WebElement Save;
	
	@FindBy(name="save_new")
	public WebElement SaveandNew;
	
	@FindBy(name="cancel")
	public WebElement Cancel;
	
	@FindBy(xpath="//*[@class='pageDescription']")
	public WebElement NewAccount;
	
	@FindBy(id="acc6")
	public WebElement Typedropdown;
	
	@FindBy(id="00NHu00000PIrjl")
	public WebElement CustomerPriority;
	
	@FindBy(className="topName")
	public WebElement NewAccountName;
	
	@FindBy(id="fcol1")
	public WebElement FieldDropdown;
	
	@FindBy(id="fop1")
	public WebElement OperatorDropdown;
	
	@FindBy(id="fval1")
	public WebElement ValueDropdown;
	
	@FindBy(className="pageDescription")
	public WebElement EditViewpage;
	
	@FindBy(linkText="Merge Accounts")
	public WebElement MergeAccounts;
	//@FindBy(name="srch")
	@FindBy(id="srch")
	public WebElement SrchBoxtomergeAccounts;
	
	@FindBy(name="srchbutton")
	public WebElement FindAccounts;
	
	@FindBy(xpath="//div[@class='noSecondHeader pageType']")
	public WebElement MergemyAccountsPage;
	
	@FindBy(name="goNext")
	public WebElement Next;
	
	@FindBy(linkText="Accounts with last activity > 30 days")
	public WebElement Accountwithlastactivity30days;
	
	//@FindBy(name="dateColumn")
	@FindBy(id="ext-gen20")
	public WebElement Datefield;
	
	@FindBy(xpath="//div[@class='x-combo-list-item']")
	//@FindBy(id="//div[contains(text(),'Created Date'])")
	public WebElement CreatedDate;
	
	@FindBy(id="ext-gen152")
	public WebElement Fromfield;
	
	@FindBy(id="ext-gen276")
	public WebElement FromfieldToday;
	
	@FindBy(id="ext-gen154")
	public WebElement Tofield;
	
	@FindBy(id="ext-gen290")
	public WebElement TofieldToday;
	
	@FindBy(id="ext-gen49")
	public WebElement Save1;
	
	@FindBy(className="pageDescription")
	public WebElement UnsavedReportPage;
	
	@FindBy(id="saveReportDlg_reportNameField")
	public WebElement Reportname;
	
	@FindBy(id="saveReportDlg_DeveloperName")
	public WebElement ReportUniquename;
	
	@FindBy(id="ext-gen271")
	public WebElement SaveandRunReport;
	
	@FindBy(id="ext-gen148")
	public WebElement datefieldDropdown;
	
	@FindBy(id="ext-comp-1042")
	public WebElement StartDate;
	
	@FindBy(id="cid1")
	public WebElement CheckBox1;
	
	@FindBy(id="cid2")
	public WebElement CheckBox2;
	
	@FindBy(id="ext-comp-1045")
	public WebElement EndDate;
	
	@FindBy(name="save")
	public WebElement MergeSaveButton;
	
	@FindBy(id="ext-comp-1064")
	public WebElement SpinnerIcon;
	
	public boolean  AccountsPageisdisplayed(WebDriver driver) throws InterruptedException  {
		boolean isDisplayed = false;
		if(CommonUtils.waitforElementToClickable(driver, AccountTab)) {
		AccountTab.click();
		}
		if(CommonUtils.waitForElement(driver,Viewdropdown)); 
			
			if(Viewdropdown.isDisplayed()) {
			isDisplayed = true;
		}
	
		return isDisplayed;
	}
	
	public void clickonNewButton(WebDriver driver) {
		NewButton.click();
	}
	public boolean verifyNewAccounteditPageisDisplayed(WebDriver driver) {
		boolean isDisplayed = false;
		if(CommonUtils.waitForElement(driver,NewAccount)); 
		if(NewAccount.isDisplayed()) {
			logger.info(" AccountPage : New account edit page is displayed ");
			isDisplayed =true;
		}
		return isDisplayed;	
	}

	public boolean verifyPageisdisplayedwithAccountDetails(WebDriver driver) {
		boolean verified = false;
		if(CommonUtils.waitforElementToClickable(driver,Save )) {
			Save.click();
		}
		if(CommonUtils.waitForElement(driver,NewAccountName)) { 
			if(NewAccountName.isDisplayed()) {
				logger.info(" AccountPage : Page is displayed with account details ");
				verified =true;
			}
		}
			return  verified;
		}
		

	public void clickonCreateNewViewlink(WebDriver driver) {
		if(CommonUtils.waitforElementToClickable(driver, CreateNewViewLink)) {
			CreateNewViewLink.click();
		}
		
	}
	
		public boolean  VerifynewlyAddedViewdisplayed(WebDriver driver) throws IOException {
			boolean isdisplayed = false;
			CommonUtils.waitForElement(driver,CreateNewViewPage);
			if(CreateNewViewPage.isDisplayed()) {
				viewname.clear();
				viewname.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name, "ViewName"));
				viewUniquename.clear();
				viewUniquename.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name, "ViewUniquename"));
				logger.info(" AccountPage : Newly added view is displayed ");
				Save.click();
				
				isdisplayed = true;
			}
			
			return isdisplayed;
		
		}
	

		public void selecttheviewnamedropdown(WebDriver driver) {
			if(CommonUtils.waitForElement(driver,Viewdropdown)) { 
				Viewdropdown.click();
				EditButton.click();
			}
		}	
		
	public boolean verifynewAccountDetails(WebDriver driver) throws IOException {
	boolean  isVerified = false;
		if(CommonUtils.waitForElement(driver,EditViewpage))
			if(EditViewpage.isDisplayed()) {
				viewname.clear();
				viewname.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name, "ViewName"));
				viewUniquename.clear();
				viewUniquename.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name, "ViewUniquename"));
		
				FieldDropdown.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name, "FieldDropdown"));
				OperatorDropdown.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name, "OperatordropDown"));
				ValueDropdown.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name, "ValuedropDown"));
			logger.info(" AccountPage :  verified new account details ");
			if(CommonUtils.waitForElement(driver,Save)){
				Save.click();
			}
		}
			isVerified = true ;
		
			return  isVerified;
	}
			
			
	public boolean verifyMergeaccountspageisdisplayedwithDetails(WebDriver driver) throws IOException {
			boolean isDisplayed = false;
			
			BasePage.clickElement(MergeAccounts, driver);
		
				SrchBoxtomergeAccounts.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name,"AccountName") );
				BasePage.clickElement(FindAccounts, driver)	;
				BasePage.clickElement(Next, driver)	;
				CommonUtils.waitforElementToClickable(driver,MergeSaveButton);
				MergeSaveButton.click();
					
					logger.info(" AccountPage : verified merge account details ");
					isDisplayed =true;
					
			
				return isDisplayed ;
			}
	
		public boolean verifyPopupMergeConfirmation(WebDriver driver) {
			boolean isPopupVerified = false;
			
		WebElement alertbox =driver.findElement(By.id("alert"));
		if(CommonUtils.waitForElement(driver, alertbox)) {
			alertbox.click();
		}
			driver.switchTo().alert().accept();
		
			isPopupVerified =true;
			
			return isPopupVerified ;
		}
			
		
			
	
	public void createAccountReportisdisplayed() throws IOException {
			Accountwithlastactivity30days.click();
			UnsavedReportPage.isDisplayed(); 
		}
			
		public boolean VerifyNewReportPageisdisplayedwithdetails(WebDriver driver) {
			boolean  isReportdisplayed = false;
			
			BasePage.clickElement(Datefield, driver);
			BasePage.clickElement(CreatedDate, driver);
			
			StartDate.clear();
			StartDate.sendKeys("09/07/2023");
			EndDate.clear();
			EndDate.sendKeys("09/07/2023");
			Save1.click();
			logger.info("AccountPage : New report is displayed : Not displayed");
			isReportdisplayed = true;
			
			return isReportdisplayed;
		}
	
	
}	
	
	
	
	