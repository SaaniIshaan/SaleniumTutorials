package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.FileConstants;
import listeners.SFDCListeners;
import pages.BasePage;
import pages.LeadsPage;
import pages.LoginPage;
import utils.CommonFileUtils;
import utils.CommonUtils;

	@Listeners(SFDCListeners.class)
	public class LeadsTest extends BaseTest{
		@BeforeClass
		public void navigateToHome()throws IOException {
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
		
			lp.loginToApp(driver);
		}
		
	//	(description="check Leads tab link")
		@Test(priority = 0)
		public void leads_TC20() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			LeadsPage Lp = new  LeadsPage(driver);
			
			Assert.assertTrue(Lp.verifyLeadsHomePageDisplayed(driver),"Failed to verify display");
			BaseTest.test.info("Leads home page is displayed");
			
		//	BaseTest.getDriver().close();
		}		
			
		
	//	(description="Leads Select View")
		@Test(priority = 1)
		public void leads_TC21() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			LeadsPage Lp = new  LeadsPage(driver);
			Assert.assertTrue(Lp.verifyLeadsHomePageDisplayed(driver),"Failed to verify display");
			BaseTest.test.info("Leads home page is displayed");
			Assert.assertTrue(Lp.verifyAllLeadsItemsShouldBeDisplayed(driver),"failed to verify");
			BaseTest.test.info("All Leads are displayed");
			
		//	BaseTest.getDriver().close();
		}
		
		
	//	(description="Functionality of the Go button")
		@Test(priority = 2)
		public void leads_TC22() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			LeadsPage Lp = new  LeadsPage(driver);
			Assert.assertTrue(Lp.verifyLeadsHomePageDisplayed(driver),"Failed to verify display");
			BaseTest.test.info("Leads home page is displayed");
			Assert.assertTrue(Lp.verifyAllLeadsItemsShouldBeDisplayed(driver),"failed to verify");
			BaseTest.test.info("All Leads are displayed");
			Assert.assertTrue(Lp.verifySelectLeadsfromthedropDown(driver),"Failed to select");
			BaseTest.test.info("Leads are selected from the dropdown");
			Assert.assertTrue(Lp.verifysalesforceLoginPageisAppear(driver),"Failed to Appear Login Page");
			BaseTest.test.info("Login Page is appear ");
			CommonUtils.waitForElement(driver, Lp.username);
			Lp.username.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"username"));
			Lp.password.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"password"));
			Lp.loginButton.click();
			Assert.assertTrue(Lp.verifyLeadsHomePageDisplayed(driver),"Failed to verify display");
			BaseTest.test.info("Logged in back again");
			Assert.assertTrue(Lp.verifyTodaysLeadsPageisDisplayed(driver)," Failed to verify");
			BaseTest.test.info("Todays Leads page is displayed");
			
		//	BaseTest.getDriver().close();
		}	
		
			
	//	(description="List item \"Todays Leads\" work")
		@Test(priority = 3)
		public void leads_TC23() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			LeadsPage Lp = new  LeadsPage(driver);
			Assert.assertTrue(Lp.verifyLeadsHomePageDisplayed(driver),"Failed to verify display");
			BaseTest.test.info("Leads home page is displayed");
			Assert.assertTrue(Lp.verifyAllLeadsItemsShouldBeDisplayed(driver),"failed to verify");
			BaseTest.test.info("All Leads are displayed");
			BasePage.selectDropdownItems(driver,Lp.AllLeadsItems,"Today's Leads");
			BaseTest.test.info("Todays's Leads Page is displayed");
			
		//  BaseTest.getDriver().close();
		}	
		
		
	//	(description="Check New button on Leads Home")
		@Test(priority = 4)
		public void leads_TC24() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			LeadsPage Lp = new  LeadsPage(driver);
			Assert.assertTrue(Lp.verifyLeadsHomePageDisplayed(driver),"Failed to verify display");
			BaseTest.test.info("Leads home page is displayed");
			Assert.assertTrue(Lp.verifyNewLeadCreationPagewithDetailsisDisplayed(driver),"Failed to verify");
			BaseTest.test.info("Leads Creation page with details is displayed");
			
		//	BaseTest.getDriver().close();
			
		}		
		
	}