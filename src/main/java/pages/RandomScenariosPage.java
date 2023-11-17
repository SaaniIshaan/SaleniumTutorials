package pages;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import utils.CommonFileUtils;
import utils.CommonUtils;

public class RandomScenariosPage extends BasePage {

	public RandomScenariosPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "home_Tab")
	public WebElement HomeTab;

	@FindBy(id = "tailBreadcrumbNode")
//	@FindBy(xpath ="//span[@id='userNavLabel']")
	public WebElement myProfilePage;

	@FindBy(xpath = "li//[@id='home_Tab']")
	public WebElement HomePage;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement Myprofile;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement UserProfilepagenamedisplay;

	@FindBy(xpath = "//h1[@class='currentStatusUserName']//a")
	public WebElement AccountHoldersName;

	// @FindBy(xpath="//div[@class='editPen']//a[@class='contactInfoLaunch
	// editLink']//img")
	// @FindBy(xpath="//div[@class='contactInfo profileSection']//img")
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']//img")
	public WebElement editProfileButton;

	@FindBy(xpath = "//span[@class='feeditemfirstentity'][1]")
	public WebElement feeditemfirstentity;

	@FindBy(id = "aboutTab")
	public WebElement Abouttab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Abouttablastname;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")
	// @FindBy(xpath = "//input[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;

	@FindBy(id = "userNavLabel")
	public WebElement UserMenubutton;

	@FindBy(linkText = "Logout")
	public WebElement LogoutButton;

	@FindBy(id = "AllTab_Tab")
	public WebElement AllTabs;

	@FindBy(name = "customize")
	public WebElement CustomizeMyTabs;

	@FindBy(xpath = "//select[@id='duel_select_1']")
//	@FindBy(id="duel_select_1")
	public WebElement SelectedTabs;

	@FindBy(id = "duel_select_0")
	public WebElement AvailableTabs;

	@FindBy(xpath = "//option[@value='Chatter']")
	public WebElement ChatterTab;

	@FindBy(name = "save")
	public WebElement SaveButton;
	
	@FindBy(xpath="//img[@class='leftArrowIcon']")
	public WebElement RemoveButton;

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//span[@class='pageDescription']/a[1]")
	public WebElement currentdatelink;

	@FindBy(xpath = "//a[contains(text(),'8:00 PM')]")
	public WebElement EightPMTimeLink;

	@FindBy(className = "comboboxIcon")
	public WebElement SubjectComboBoxIcon;

	@FindBy(xpath = "//a[@href='javascript:pickValue(4);']")
	public WebElement OtherButton;

	@FindBy(id = "EndDateTime")
	public WebElement EndDateTimeField;

	@FindBy(id = "EndDateTime_time")
	public WebElement EndTimeField;

	@FindBy(xpath ="//a[contains(text(),'4:00 PM')]")
	public WebElement FourPMTimeLink;

	@FindBy(id = "timePickerItem_38")
	public WebElement Time2FielddropDown;

	@FindBy(id = "timePickerItem_42")
	public WebElement TimeFielddropDown;

	@FindBy(id = "IsRecurrence")
	public WebElement RecurrenceCheckBox;

	@FindBy(id = "rectypeftw")
	public WebElement WeeklyRadioButton;

	@FindBy(id = "RecurrenceEndDateOnly")
	public WebElement RecurrenceEndField;
	
	@FindBy(id = "16")
	public WebElement selectThursday;
	
	@FindBy(xpath = "//img[contains(@class,'calRight')]")
	public WebElement pickingdate;

	@FindBy(xpath = "//h1[@class='pageType']")
	public WebElement monthview;

	@FindBy(xpath = "//img[@class='monthviewIcon']")
	public WebElement monthviewIcon;
	
	
	

	public boolean verifyAccountHoldersName(WebDriver driver) {
		boolean isNameverified = false;

		if (CommonUtils.waitforElementToClickable(driver, HomeTab)) {
			HomeTab.click();
		}
		if (BasePage.verifyElementisDisplayed(driver, AccountHoldersName)) {

			isNameverified = true;
			logger.info("Random Page : verify AccountHolders Name : AccountHolders Name is verified");
		}

		return isNameverified;
	}

	public boolean verifyAccountHoldersNameisSameasMyProfilePage(WebDriver driver) {
		boolean isHomenamePageVerified = false;
		if (CommonUtils.waitforElementToClickable(driver, AccountHoldersName)) {
			AccountHoldersName.click();

		}
		CommonUtils.waitforElementToVisible(driver, myProfilePage);
		if (BasePage.verifyDisplayMessage(myProfilePage, "Monika Gupta")) {
			isHomenamePageVerified = true;
			logger.info(
					"Random Page : Verify HomePage is same as MyProfilePage : HomePage is same as MyProfilePage verified");
		}
		return isHomenamePageVerified;

	}

	public boolean verifyEditProfilePopupisDisplayed(WebDriver driver) throws InterruptedException {
		boolean isPopupVerified = false;
		if (CommonUtils.waitForElement(driver, feeditemfirstentity)) {
			if (CommonUtils.waitforElementToClickable(driver, editProfileButton)) {
				editProfileButton.click();
			}
		}
		 
		if (CommonUtils.waitForElement(driver, iframeAboutTab)) {
			
			driver.switchTo().frame(iframeAboutTab);
		}
		
		if (CommonUtils.waitForElement(driver, Abouttab)) {
			
			if (Abouttab.isDisplayed() && contactTab.isDisplayed()) {
				 isPopupVerified = true;
				logger.info("Random Page : Verify Editprofile Popup ; EditProfile popup is verified");
			}
		}
		return isPopupVerified;
	}

	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String sLastName) {
		boolean isLastNameVerified = false;
		if (Abouttab.isDisplayed()) {
			Abouttab.click();
			Abouttablastname.clear();
			Abouttablastname.sendKeys(sLastName);
			saveAllButton.click();
			driver.switchTo().parentFrame();

			if (UserProfilepagenamedisplay.isDisplayed()) {
				String sActualName = UserProfilepagenamedisplay.getText();

				if (sActualName.contains(sLastName)) {
					isLastNameVerified = true;
				}
			} else {
				System.out.println("RandomScenariosPage : verifyLastNameChangeInAboutTab : About tab is not visible");
			}

		}
		return isLastNameVerified;
	}

	public boolean verifyCombopopupisClosed(WebDriver driver) {
		boolean isPopupClosed = false;

		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		if (CommonUtils.waitForElement(driver, OtherButton)) {
			OtherButton.click();
			isPopupClosed = true;
			driver.switchTo().window(currentHandle);
		}
		return isPopupClosed;
	}

	public boolean  verifySelectCustomization(WebDriver driver) {
		boolean isTabCustomizationSelected = false;
		
		BasePage.clickElement(AllTabs, driver);
		BasePage.clickElement(CustomizeMyTabs, driver);
		 isTabCustomizationSelected =true;
		return  isTabCustomizationSelected ;
		
	}	
		
		public boolean verySelectedTabs(WebDriver driver) {
			boolean isSelected = false;
		isSelected = BasePage.clickElement(ChatterTab, driver);
		isSelected	= BasePage.clickElement(RemoveButton, driver);
		isSelected = BasePage.clickElement(SaveButton, driver);
			
			return isSelected;
			
		}
		public boolean verifyLogout(WebDriver driver ) {
			boolean isLogoutVerified = false;
			isLogoutVerified = BasePage.selectMenuItems( driver,UserMenubutton);
			isLogoutVerified = BasePage.selectMenuItems(driver, LogoutButton);
			
			return isLogoutVerified;
			
		}
		
		public boolean verifyLaunchandLogin(WebDriver driver) throws IOException {
			boolean isLoginVerified = false;
			
		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		driver.manage().window().maximize()	;
		logger.info("LoginPage  : loginToApp : LoginStarted");
		if(BasePage.verifyElementisDisplayed(driver, username)) {
		 LoginPage lp = new  LoginPage(driver);
			lp.loginToApp(driver);
			isLoginVerified = true;
		}
			
			return isLoginVerified;
			
		}
		
		public boolean veriFyMonthView(WebDriver driver) {
			boolean isSelected = false;
			
			BasePage.clickElement(monthviewIcon, driver) ;
			if(BasePage.verifyElementisDisplayed(driver, monthview)) {
				isSelected = true;
			}
			
			return	isSelected;
			
		}
	}