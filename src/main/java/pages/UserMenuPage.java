package pages;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import constants.WaitConstants;
import utils.CommonFileUtils;
import utils.CommonUtils;


	/**
	 * This page contains all the required page object elements and methods of usermenu page
	 * @author Piyush
	 * @version v1.0
	 */
public class UserMenuPage extends BasePage {
		
		


		public UserMenuPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
			
		}
		@FindBy(id = "userNavLabel")
		public WebElement userMenu;
		
		@FindBy(xpath = "//div[@id ='userNav-menuItems']/a")
		public List<WebElement> userMenuOptions;
		
		@FindBy(xpath = "//a[@title='My Profile']")
		public WebElement MyProfile;
		
		@FindBy(linkText="My Settings")
		public WebElement MySettings;
		
	//	@FindBy(xpath="//[@class='noSecondHeader pageType']")
		@FindBy(id="PersonalSetup_font")
		public WebElement MySettingspage;
		
		@FindBy(linkText="Developer Console")
		public WebElement DevelopersConsole;
		
		@FindBy(xpath="//*[@id=\"editors-body\"]")
		public WebElement DevelopersConsolepage;
		
		@FindBy(id = "//a[@title='Switch to Lightning Experience']")
		public WebElement SwitchtoLightningExperience;
		
		@FindBy(linkText = "Logout")
		public WebElement Logout;
		
	//	@FindBy(css = "#username")
		@FindBy(id = "username")
		public WebElement Username;
		
		//My Profile
		
		@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
		public WebElement editContactButton;
		
		@FindBy(xpath= "//a[@class='contactInfoTitle']")
		public WebElement EditProfilePopupwindow;
		
		@FindBy(id = "aboutTab")
		public WebElement Abouttab;
		
		@FindBy(xpath="//input[@id='lastName']")
		public WebElement Abouttablastname;
		
		@FindBy(xpath = "//input[@value='Save All']")
		public WebElement saveAllButton;
		
		@FindBy(id ="tailBreadcrumbNode")
		public WebElement Userprofilepagenamedisplay;
		
		@FindBy(name = "j_id0:waitingForm")
		public WebElement spinnerIcon;
		
		@FindBy(id = "cropWaitingPage:croppingForm")
		public WebElement spinnerWhileCropping;
		
		@FindBy(id = "progressIcon")
		public WebElement fileUploadSpinner;


		// Postlink
		
		@FindBy(id="publisherAttachTextPost")
		public WebElement postLink;

		@FindBy(xpath = "/html/body")
		public WebElement postTextArea;

		@FindBy(xpath = "//input[@id='publishersharebutton']")
		public WebElement shareButton;
			
			
		// filelink
		
		@FindBy(id="publisherAttachContentPost")
		public WebElement filelink;
		
		@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
		public WebElement contentpost;

		@FindBy(css = "#chatterUploadFileAction")
		public WebElement Uploadfile;

		@FindBy(css = "#chatterFile")
		public WebElement Fileopen;

		@FindBy(css = "#publishersharebutton")
		public WebElement publish;

		@FindBy(xpath = "//input[@value='Cancel Upload']")
		public WebElement cancelUpload;

		@FindBy(id = "uploadLink")
		public WebElement updateButton;
		
		// Photo link

		@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
		public WebElement photolink;

		@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
		public WebElement uploadphoto;

		@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
		public WebElement uploadbutton;

		@FindBy(id = "publishersharebutton")
		public WebElement photosharebutton;

		@FindBy(id = "uploadPhotoContentId")
		public WebElement photoUploadIframe;

//		@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
		@FindBy(id = "j_id0:uploadFileForm:uploadBtn")
		public WebElement photoSaveButton;

		@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
		public WebElement photoSaveButton2;
		
		// My Settings
		// personallink
		
		@FindBy(id="PersonalInfo_font")
		public WebElement personallink;

		@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
		public WebElement loginHistorylink;
		
		@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
		public WebElement logindisplay;

		@FindBy(id = "contactInfoContentId")
		public WebElement iframeAboutTab;
		
		// Display&layoutlink

		@FindBy(id ="DisplayAndLayout_font")
		public WebElement DisplayLayoutlink;

		@FindBy(id = "CustomizeTabs_font")
		public WebElement CustomizedTab;

	//	@FindBy(xpath = "//*[@id=\"p4\"]/option[9]")
		@FindBy(id = "p4")
		public WebElement customApp;

//		@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
		@FindBy(id  = "duel_select_0")
		public WebElement Availabletab;

		@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
		public WebElement Add;
		
		@FindBy(id = "duel_select_1")
		public WebElement SelectedTabs;
		
	//	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
		@FindBy(name = "save")
		public WebElement save;

		@FindBy(id = "tabBar")
		public WebElement tabList;
		
		// Emaillink
		@FindBy(id = "EmailSetup_font")
		//public WebElement Emaillink;
		//@FindBy(xpath = "//*[@id=\"EmailSetup_font\"]")
		public WebElement Emaillink;

		@FindBy(id = "EmailSettings_font")
		public WebElement MyEmailSettings;

		@FindBy(id = "sender_name")
		public WebElement Emailname;
	
		@FindBy(id = "sender_email")
	//	@FindBy(xpath = "//*[@id=\"sender_email\"]")
		public WebElement Emailaddress;

		@FindBy(xpath = "//*[@id=\"useremailSection\"]/table/tbody/tr[7]/td[2]/div")
		public WebElement BCCradiobutton;

		@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
		public WebElement Saveonemail;
		
		// Calendar and Remainders
		@FindBy(id = "CalendarAndReminders_font")
		public WebElement CalendarAndReminders;
		
		@FindBy(id = "Reminders_font")
	//	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
		public WebElement ActivityRemainder;

		@FindBy(id = "testbtn")
		public WebElement OpenaTestRemainder;
		
		@FindBy(name = "save")
		public WebElement Save;

		@FindBy(xpath = "//*[@id=\"summary\"]")
		public WebElement SampleEventPopup;

		@FindBy(css = "#displayBadge")
		public WebElement moderatorButton;

		@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
		public WebElement profilePage;

		@FindBy(id = "contactTab")
		public WebElement contactTab;

		@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
		public WebElement firstPostText;

		@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
		public WebElement verifyFirstPostElement;

		@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
		public WebElement verifyFilePostElement;
	
		@FindBy(linkText="Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »")
		public WebElement downloadloginhistory;	
		
		
		/**
		 * This function can be called to select option from user menu options
		 * @param driver webdriver instance has to be passed
		 * @param sOption Option value eg: "My Profile"
		 * @return {boolean} true if given option is selected else false
		 */
	public boolean selectOptionFromUserMenuOptions(WebDriver driver, String sOption) {
			
			boolean isOptionSelected = false;
			
			if(userMenu.isDisplayed()) {
				userMenu.click();
			}
			WebElement userMenuItem = driver.findElement(By.xpath("//*[text()='"+sOption+"']"));
			if(userMenuItem.isDisplayed()) {
				userMenuItem.click();
				isOptionSelected = true;
			}
			return isOptionSelected;
		}
		/*
		 * @return
		 * @throws IOException
		 */
		
	public boolean verifyUserMenuItems() throws IOException {
		
		boolean isOptionVerified = true;
			
		String[] expectedUserMenuItems = CommonFileUtils.readUserMenuTestData("usermenu.items").split(",");
			
		for(int i=0; i< expectedUserMenuItems.length; i++) {
				
			String actualOption = userMenuOptions.get(i).getText();
				
			 if(expectedUserMenuItems[i].equals(actualOption)) {
				 System.out.println("Expected Option" +expectedUserMenuItems[i] + "Actual Option" +actualOption);
			 }else {
				System.out.println("Expected Option" +expectedUserMenuItems[i]+"failed to match with Actual Option"+actualOption);
				isOptionVerified = false;
			 }
				
		}	
		return isOptionVerified ;
	}				 
	public boolean	selectMyProfile() throws IOException{
			
		boolean isSelected = false;
			if(MyProfile.isDisplayed()) {
				MyProfile.click();
				isSelected = true;
			} 
			return isSelected;
		}
		public boolean  isProfilePageVisible() {
			return profilePage.isDisplayed();
		}
		public void selecteditContact(WebDriver driver) {
			if(CommonUtils.waitForElement(driver, editContactButton)) {
				editContactButton.click();
			}
		}
		public boolean verifyEditContactPopUp(WebDriver driver ) {
			boolean iscontactpopUpVerified = false;
			 
			if(CommonUtils.waitForElement(driver, iframeAboutTab)) { 
				driver.switchTo().frame(iframeAboutTab);
				
				if(Abouttab.isDisplayed() && contactTab.isDisplayed()) {
					iscontactpopUpVerified = true;
				}
			}
			// Note: Maybe required to switch to parent frame
			return iscontactpopUpVerified;
		}
	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String sLastName) {
		boolean isLastNameVerified = false;
		if(Abouttab.isDisplayed()) {
			Abouttab.click();
			Abouttablastname.clear();
			Abouttablastname.sendKeys(sLastName);
			saveAllButton.click();
			driver.switchTo().parentFrame();
				
		if(Userprofilepagenamedisplay.isDisplayed()) {
			String sActualName = Userprofilepagenamedisplay.getText();
			
				if(sActualName.contains(sLastName)) {
					isLastNameVerified = true;
				}
		}	
				else {
				System.out.println("UserMenuPage : verifyLastNameChangeInAboutTab : About tab is not visible");
				}
				
			}
		return isLastNameVerified;
	}
		public boolean verifyCreatePost(WebDriver driver, String sMessageToPost)throws InterruptedException {
			boolean verifyCreatePost= false;
			if(CommonUtils.waitForElement(driver,postLink)) {
				postLink.click();
				driver.switchTo().frame(0);
				postTextArea.sendKeys(sMessageToPost);
				driver.switchTo().parentFrame();
				if(shareButton.isDisplayed()) {
					shareButton.click();
					
					if(CommonUtils.waitForElementToDisappear(driver, cancelUpload)) {
						if(verifyFirstPostElement.isDisplayed()) {
							
							verifyCreatePost = true;
						}
					}
					
				}
			
			}
			return  verifyCreatePost;
		}

	//	public boolean verifyFileUpload(WebDriver driver, String sFilePath, WebElement verifyFilePostElement) throws InterruptedException {
			
		
		public boolean verifyFileUpload(WebDriver driver, String sFilePath) throws InterruptedException {
			boolean isFileUploadSuccess = false;
			if(CommonUtils.waitForElement(driver, filelink)) {
				filelink.click();
				if(CommonUtils.waitForElement(driver, Uploadfile)) {
					Uploadfile.click();
				}
				if(CommonUtils.waitForElement(driver, Fileopen)) {	
					Fileopen.sendKeys(sFilePath);
					shareButton.click();
				
					if(CommonUtils.waitForElementToDisappear(driver, cancelUpload)) 	{
						if(verifyFilePostElement.isDisplayed()) 	{
						isFileUploadSuccess = true;
						
						}
					}
				}
		
			}		
				return isFileUploadSuccess ;
		}		
		
		public boolean verifyPhotoUpload(WebDriver driver, String sPhotopath) {
			
			boolean isUploadSuccess = false;
			CommonUtils.moveToElement(driver, moderatorButton);
			if(updateButton.isDisplayed()) {
				updateButton.click();
			}
			
			driver.switchTo().frame(photoUploadIframe);
			if(CommonUtils.waitForElement(driver,uploadphoto)) {
				  uploadphoto.sendKeys(sPhotopath); 
				  photoSaveButton.click(); 
			}
			
			if(CommonUtils.waitForElementToDisappear(driver,spinnerIcon)){
				photoSaveButton2.click();
			}
			if(CommonUtils.waitForElementToDisappear(driver,spinnerWhileCropping)) {
				  isUploadSuccess = true; 
			} 
			driver.switchTo().parentFrame(); 
			return isUploadSuccess; 	
		}
		
		
		public void clickoncustomappdropdownChatter(WebDriver driver) {
			if(CommonUtils.waitForElement(driver,DisplayLayoutlink)) {
				customApp.click();
				Select sc = new Select(customApp);
				sc.selectByValue("02uHu000001HuhH");
			}
		}	
	
		public void verifyReportsfieldisAddedtoSelectedList(WebDriver driver ) throws InterruptedException {
		
			Select list = new Select(Availabletab);
			List<WebElement> alloptions = list.getOptions();
			
			for (int i=0; i< alloptions.size(); i++) {
				if(alloptions.contains("report")){
					Select rpt = new Select(Availabletab);
					rpt.selectByValue("report");
					Add.click();
				}
			}
		    save.click();
		}
		
		public boolean verifyDetailsareSavedasdefaultmailOption(WebDriver driver) throws IOException {
			boolean areSaved = false;
			if(CommonUtils.waitForElement(driver,Emaillink)) { 
				if(Emaillink.isDisplayed()) {
				Emaillink.click();
				}
				if(MyEmailSettings.isDisplayed()) {
				MyEmailSettings.click();
				}
				Emailname.clear();
				Emailname.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.USER_MENU_TESTDATA_FILE_PATH,"EmailName"));
				Emailaddress.clear();
				Emailaddress.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.USER_MENU_TESTDATA_FILE_PATH,"EmailAddress"));
				BCCradiobutton.click();
				save.click();
				areSaved = true;
			}
			return  areSaved;
		}
		
		
		public boolean SampleEventpopwindowisdisplayed(WebDriver driver) {
			boolean  isdisplayed  = false;
			if(CommonUtils.waitForElement(driver,CalendarAndReminders)) {
			
				CalendarAndReminders.click();
			}
			if(ActivityRemainder.isDisplayed()) {
				ActivityRemainder.click();
			}
				
			
			if(CommonUtils.waitForElement(driver,OpenaTestRemainder)) {
				
				OpenaTestRemainder.click();
					
			/*	String parentWindow = driver.getWindowHandle();
				System.out.println(parentWindow);
				Set<String> windows = driver.getWindowHandles();
				windows.remove(parentWindow);
				String newwindow = "";
					for(String handle : windows) {
						System.out.println(handle);
						newwindow = handle;
							
					}	
						
				driver.switchTo().window(newwindow);
						
				driver.close();
				driver.switchTo().window(parentWindow);*/
				isdisplayed = true;
			}		
			return isdisplayed;			
		}
		
		
		
	public boolean	selectDeveloperConsole() throws IOException{
			
		boolean isSelected = false;
		if(DevelopersConsole.isDisplayed()) {
			DevelopersConsole.click();
			isSelected = true;
		} 
			return isSelected;
	}
		
	public void DeveloperConsoleisclosed(WebDriver driver) {
		driver.switchTo().parentFrame();
		driver.quit();
	}
		
	public boolean	selectLogout() throws IOException{
			
		boolean isSelected = false;
		if(Logout.isDisplayed()) {
			Logout.click();
			isSelected = true;
		} 
		return isSelected;
	}
		
		
	public boolean logoutisSuccessful(WebDriver driver) {
		boolean isSuccessful = false;
		if(Username.isDisplayed()) {
			isSuccessful = true;
		}
		return isSuccessful;
	}
}			