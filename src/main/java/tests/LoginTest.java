package tests;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import constants.FileConstants;
import listeners.SFDCListeners;
import pages.BasePage;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonFileUtils;
import utils.CommonUtils;
import utils.ExcelUtils;
@Listeners(SFDCListeners.class)
public class LoginTest extends BaseTest {
	
	// description="Login Error Message"
	@Test(priority = 2)
	public void loginTestTC01() throws IOException {
		
		WebDriver driver =  BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
	
		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		lp.username.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"username"));
	
		lp.password.clear();
		logger.info("LoginPage : loginToApp : Clicked on login button") ;
		lp.loginButton.click();
	
	Assert.assertTrue(BasePage.verifyDisplayMessage(lp.errorMessage, lp.missingpasswordtext),"Failed to verify login");
		
	}
	

	
	//(description="Login To Salesforce")
	@Test(priority = 1)
	public void loginTestTC02() throws IOException {
		
		WebDriver driver =  BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
	
		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		
		lp.username.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"username"));
		lp.password.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"password"));
	
		logger.info("LoginPage : loginToApp : Clicked on login button") ;
		lp.loginButton.click();
		
		
		Assert.assertTrue(BasePage.verifyDisplayMessage(lp.homeTab,"Home"));
	}
	
	
	// (description="Check Rememberme")
	@Test(priority = 5)
	public void LoginTestTC03() throws IOException, InterruptedException {
		WebDriver driver =  BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
	
		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		
		lp.username.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"username"));
		lp.password.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"password"));

		Assert.assertTrue(lp.selectrememberMeCheckBox(),"rememberMe Checkbox is not selected");
		lp.loginButton.click();
		
		UserMenuPage ump = new UserMenuPage(driver);
		Assert.assertTrue(BasePage.verifyDisplayMessage(lp.homeTab, "Home"));
		CommonUtils.waitForElement(driver,ump.userMenu);
		ump.userMenu.click();

		Assert.assertTrue(ump.verifyUserMenuItems(),"Failed to verify userMenu options");
		if(CommonUtils.waitforElementToClickable(driver,ump.Logout)) {
			ump.Logout.click();
		}
		
		BaseTest.test.info("rememberMe checkbox is selected");
	}
	
	
//	(description="forgot password")
	@Test(priority = 3)
	public void LoginTestTC4A()throws IOException{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		CommonUtils.waitforElementToClickable(driver,lp.forgotPassword );
		lp.forgotPassword.click(); 
		CommonUtils.waitforElementToClickable(driver,lp.forgotUsername);
		lp.forgotUsername.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"username"));
		lp.Continue.click();
		BaseTest.test.info("Password reset message Page is displayed");
		}
	
	// (description="Forgot Password")
		@Test(priority = 4)
		public void LoginTestTC04B()throws IOException {
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
			lp.username.sendKeys("123");
			lp.password.sendKeys("22131");
			lp.loginButton.click();
			Assert.assertTrue(BasePage.verifyDisplayMessage(lp.errorMessage,lp.checkCredentialMessaage));
			BaseTest.test.info("verified display message");
			driver.close();
		}
	
	@BeforeClass
	public void navigateToHome()throws IOException {
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
			lp.loginToApp(driver);
	}
	
	}	


		
		
		
