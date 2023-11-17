package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import constants.FileConstants;
import listeners.SFDCListeners;
import pages.BasePage;
import pages.LoginPage;
import pages.RandomScenariosPage;
import pages.UserMenuPage;
import utils.CommonFileUtils;
import utils.CommonUtils;
@Listeners(SFDCListeners.class)
public class UserMenuTest extends BaseTest{
	
	@BeforeClass
	public void navigateToHome()throws IOException {
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			
			lp.loginToApp(driver);
	}
	
//	(description="Select user menu for <username> drop down")
	
	@Test (priority =0)
	public void UserMenuDropDownTC05() throws IOException  {
		
		
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
	
		UserMenuPage ump = new UserMenuPage(driver);
	
		CommonUtils.waitForElement(driver,ump.userMenu);
			ump.userMenu.click();
			Assert.assertTrue(ump.verifyUserMenuItems(),"Failed to verify user menu options");
			BaseTest.test.info("verifyUserMenuItems");
		}
	
	
//	(description="select usermenu for username dropdown")
	
	@Test(priority = 3)
	public void userMenuDropDown_TC6()throws IOException, InterruptedException {
		
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		UserMenuPage ump = new UserMenuPage(driver);
	
		CommonUtils.waitForElement(driver,ump.userMenu);

		BaseTest.test.info("Username element is visible");
		ump.userMenu.click();

		BaseTest.test.info("clicked on usermenu");
		Assert.assertTrue(ump.verifyUserMenuItems(),"Failed to verify user menu options");
		BaseTest.test.info("verifyUserMenuItems");
		Assert.assertTrue(ump.selectMyProfile(),"");
		CommonUtils.waitForElement(driver, ump.profilePage);
		BaseTest.test.info("selected my Profile");
		CommonUtils.waitForElement(driver, ump.profilePage);
		BaseTest.test.info("Profile page is loaded");
		Assert.assertTrue(ump.isProfilePageVisible(),"");
		ump.selecteditContact(driver);		
		Assert.assertTrue(ump.verifyEditContactPopUp(driver), "");
		BaseTest.test.info("Edit Contact PopUp is verified");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, "Gupta"),"");
		BaseTest.test.info("Verified last name is change");
		Assert.assertTrue(ump.verifyCreatePost(driver,"This is great"));
		BaseTest.test.info("Verified Create Post");
		Thread.sleep(5000);
	
		BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(driver));
		
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.sFilePath));
		BaseTest.test.info("Verified File Upload");
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.PROFILE_PHOTO_FILE_PATH),"Photo upload completed");
		BaseTest.test.info("Verified PhotoUpload");
		
	}
	
	
	// (description = "Select my Settings from Usermenu option")
	
	@Test(priority = 4)
	public void userMenuDropDown_TC07()throws IOException, InterruptedException {
		
		
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		UserMenuPage ump = new UserMenuPage(driver);
		CommonUtils.waitForElement(driver,ump.userMenu);
		ump.userMenu.click();
	
		Assert.assertTrue(ump.verifyUserMenuItems(),"Failed to verify user menu options");
		BaseTest.test.info("Verified UserMenu Items");
		Assert.assertTrue(BasePage.selectMenuItems(driver, ump.MySettings),"not selected");
		BaseTest.test.info(" selected Menu Item My setting");
		Assert.assertTrue(BasePage.selectMenuItems(driver, ump.personallink),"Personal Link not selected");
		BaseTest.test.info(" selected Personal link");
		Assert.assertTrue(BasePage.selectMenuItems(driver, ump.loginHistorylink),"Hisory Link not selected");
		BaseTest.test.info("selected loginHistory link");
		Assert.assertTrue(BasePage.selectMenuItems(driver, ump.downloadloginhistory),"Hisory Link not selected");
		BaseTest.test.info("Login history downloaded");
		Assert.assertTrue(BasePage.selectMenuItems(driver, ump.DisplayLayoutlink),"Display and layout Link not selected");
		BaseTest.test.info("selected displayLayout link ");
		Assert.assertTrue(BasePage.selectMenuItems(driver, ump.CustomizedTab),"Display and layout Link not selected");
		BaseTest.test.info("selected Customized Tab ");
		ump.clickoncustomappdropdownChatter(driver);
		ump.verifyReportsfieldisAddedtoSelectedList(driver);
		Assert.assertTrue(ump.verifyDetailsareSavedasdefaultmailOption(driver),"failed to verify");
		BaseTest.test.info("Verified details are saved");
		Assert.assertTrue(ump.SampleEventpopwindowisdisplayed(driver),"failed to display");
		BaseTest.test.info("Verified pop window is displayed ");
	}
	
	
	//(description = "Select Developers Console")
	
	@Test(priority = 1)
	public void userMenuDropDown_TC08()throws IOException, InterruptedException {
		
		
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		UserMenuPage ump = new UserMenuPage(driver);
		CommonUtils.waitForElement(driver,ump.userMenu);
	
		ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(),"Failed to verify user menu options");
		BaseTest.test.info("Verified UserMenu Items");
		Assert.assertTrue(ump.selectDeveloperConsole(),"failed to select");
		BaseTest.test.info("Developer Console selected");
		ump.DeveloperConsoleisclosed(driver);
	}

	//(description = "Select \"Logout\" option from user menu for <username> drop down")
	
	@Test(priority = 2)
	public void userMenuDropDown_TC09()throws IOException, InterruptedException {
		
	
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		UserMenuPage  ump = new UserMenuPage(driver);
		CommonUtils.waitForElement(driver, ump.userMenu);
		ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(),"Failed to verify user menu options");
		BaseTest.test.info("Verified UserMenu Items");
		CommonUtils.waitforElementToClickable(driver, ump.Logout);
		ump.Logout.click();
		BaseTest.test.info("Logout is successful");
	
	}
	
	
}