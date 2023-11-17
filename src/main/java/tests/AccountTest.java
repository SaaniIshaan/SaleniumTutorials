package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.FileConstants;
import listeners.SFDCListeners;
import pages.AccountsPage;
import pages.BasePage;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonFileUtils;
import utils.CommonUtils;
@Listeners(SFDCListeners.class)
public class AccountTest extends BaseTest{
	



	@BeforeClass
	public void navigateToHome()throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
	
		lp.loginToApp(driver);
	}
	
	//@Test(description="Create an Account")
//	@Test(priority=0)
	public void CreateAccount_TC10() throws InterruptedException, IOException {
		
		
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		AccountsPage Ap = new AccountsPage(driver);
		//Ap.AccountsPageisdisplayed(driver);
		Assert.assertTrue(Ap.AccountsPageisdisplayed(driver),"Failed to display");
		BaseTest.test.info("Account home page is displayed");
		CommonUtils.waitforElementToClickable(driver,Ap.NewButton );
		Ap.NewButton.click();
		Assert.assertTrue(Ap.verifyNewAccounteditPageisDisplayed(driver),"Failed to display");
		BaseTest.test.info("Account edit page is displayed");
		CommonUtils.waitforElementToClickable(driver,Ap.AccountName);
		Ap.AccountName.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name,"AccountName"));
		Ap.Typedropdown.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name,"Type"));
		Ap.CustomerPriority.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name,"CustomerPriority"));
		Assert.assertTrue(Ap.verifyPageisdisplayedwithAccountDetails(driver)," failed to display");
		BaseTest.test.info("verified all the account details");
		}
	
	
	//(description="Create new View")
	
//	@Test(priority=1)
	public void CreateAccount_TC11() throws InterruptedException, IOException {

		
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		AccountsPage Ap = new AccountsPage(driver);

		Assert.assertTrue(Ap.AccountsPageisdisplayed(driver),"Failed to display");
		BaseTest.test.info("Account home page is displayed");
		Ap.CreateNewViewLink.click();
		Assert.assertTrue(Ap.VerifynewlyAddedViewdisplayed(driver),"failed to display");
		BaseTest.test.info("Verified new displayedview");
		
	}

	//  (description="Edit view")
	
//	@Test(priority=2)
	public void CreateAccount_TC12() throws InterruptedException, IOException {

	
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		AccountsPage Ap = new AccountsPage(driver);

		Assert.assertTrue(Ap.AccountsPageisdisplayed(driver),"Failed to display");
		BaseTest.test.info("Account home page is displayed");
		Ap.Viewdropdown.click();
		Ap.EditButton.click();
		Assert.assertTrue(Ap.verifynewAccountDetails(driver),"Failed to verify");
		BaseTest.test.info("New Account page with details is displayed");
		
	}
	
	 //	(description="MergeAccounts")
	
//	@Test(priority=3)
	public void CreateAccount_TC13() throws InterruptedException, IOException {

	
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		AccountsPage Ap = new AccountsPage(driver);
		BasePage.clickElement(Ap.AccountTab, driver);
		Assert.assertTrue(Ap.AccountsPageisdisplayed(driver),"Failed to display");
		BaseTest.test.info("Account home page is displayed");
		
		Assert.assertTrue(Ap.verifyMergeaccountspageisdisplayedwithDetails(driver),"failed to displayed");
		driver.switchTo().alert().accept();
		BaseTest.test.info("Accounts are Merged");
	
	 }

		

 //  (description="Create account report")
	
	@Test(priority=4)
  	public void CreateAccount_TC14() throws InterruptedException, IOException {
 
  		WebDriver driver = BaseTest.getDriver();
  		BaseTest.test.info("Driver configured");
  		AccountsPage Ap = new AccountsPage(driver);
  		
		BasePage.clickElement(Ap.AccountTab, driver);
 	Assert.assertTrue(Ap.AccountsPageisdisplayed(driver),"Failed to display");
 	BaseTest.test.info("Account home page is displayed");
 	Ap.Accountwithlastactivity30days.click();
 	BaseTest.test.info("Unsaved Report page is displayed"); 
 	Assert.assertTrue(Ap.VerifyNewReportPageisdisplayedwithdetails(driver),"Not displayed");
 	BaseTest.test.info("New Report page is displayed"); 
 	Ap.Reportname.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name,"reportName"));
 	//CommonUtils.waitforElementToVisible(driver, Ap.ReportUniquename);
	Ap.ReportUniquename.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.Account_Name,"reportUniqueName"));
	//CommonUtils.waitforElementToVisible(driver, Ap.SaveandRunReport);
	CommonUtils.waitforElementToClickable(driver, Ap.SaveandRunReport);
	Thread.sleep(10000);
	Ap.SaveandRunReport.click();
 
   	}
  }