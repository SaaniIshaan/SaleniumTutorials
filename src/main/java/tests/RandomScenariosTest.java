package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.FileConstants;
import listeners.SFDCListeners;
import pages.AccountsPage;
import pages.BasePage;
import pages.LoginPage;

import pages.RandomScenariosPage;
import utils.CommonFileUtils;
import utils.CommonUtils;

@Listeners(SFDCListeners.class)
public class RandomScenariosTest extends BaseTest {

	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);

		lp.loginToApp(driver);
	}

	//(description="Verify if the firstname and lastname of the loggedin user is displayed")
	
	@Test(priority = 0)
	public void RandomScenarios_TC33() {
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		RandomScenariosPage Rsp = new RandomScenariosPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(Rsp.verifyAccountHoldersName(driver), "Failed to verify");
		BaseTest.test.info("AccountHoldersNamePage is verified");
		Assert.assertTrue(Rsp.verifyAccountHoldersNameisSameasMyProfilePage(driver), " Failed to verify");
		BaseTest.test.info("HomeNamePage as ProfilePage is verified ");
	}

	// (description="Verify the edited lastname is updated at various places")
	
	@Test(priority= 1)
	public void RandomScenarios_TC34() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		RandomScenariosPage Rsp = new RandomScenariosPage(driver);

		Assert.assertTrue(Rsp.verifyAccountHoldersName(driver));
		BaseTest.test.info("AccountHoldersNamePage is verified");
		Assert.assertTrue(Rsp.verifyAccountHoldersNameisSameasMyProfilePage(driver), " Failed to verify");
		BaseTest.test.info("HomeNamePage as ProfilePage is verified ");
		Assert.assertTrue(Rsp.verifyEditProfilePopupisDisplayed(driver), "Failed to verify");
		BaseTest.test.info("Edit Profile Pop-up is verified");
		Assert.assertTrue(Rsp.verifyLastNameChangeInAboutTab(driver, "Gupta"), "");
		BaseTest.test.info(" Updated LastName is verified");
		
		
	}

	//(description = "Verify the tab customization")
	
	@Test(priority = 2)
	public void RandomScenarios_TC35() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		RandomScenariosPage Rsp = new RandomScenariosPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(Rsp.verifySelectCustomization(driver),"Failed to  verify customization");
		BaseTest.test.info("Customized page is displayed");
		Assert.assertTrue(Rsp.verySelectedTabs(driver)," Failed to select");
		BaseTest.test.info("Selected Tabs are verified");
		Assert.assertTrue(Rsp.verifyLogout(driver), "Failed to Logout");
		BaseTest.test.info("Logout is successful");
		Assert.assertTrue(Rsp.verifyLaunchandLogin(driver), "Failed to Login");
		BaseTest.test.info("Logged back in again");
		
		
	}	
		

		
	// (description="Blocking an event in the calender")
	
	@Test(priority = 3)
	public void RandomScenarios_TC36() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		RandomScenariosPage Rsp = new RandomScenariosPage(driver);

		Assert.assertTrue(BasePage.clickElement(Rsp.HomeTab, driver));
		BaseTest.test.info("Home page is displayed");
		Assert.assertTrue(BasePage.clickElement(Rsp.currentdatelink, driver));
		BaseTest.test.info("calender page with first name and LastName is displayed");
		Assert.assertTrue(BasePage.clickElement(Rsp.EightPMTimeLink, driver));
		BaseTest.test.info("New event page with cursor on subject field is displayed");
		Assert.assertTrue(BasePage.clickElement(Rsp.SubjectComboBoxIcon, driver));
		BaseTest.test.info("Combo Box popup is opened");
		Assert.assertTrue(Rsp.verifyCombopopupisClosed(driver), "popup failed to close");
		BaseTest.test.info("POPup is closed and 'other' entered in the subject field ");
		Assert.assertTrue(BasePage.clickElement(Rsp.EndTimeField, driver));
		BaseTest.test.info("Time is selected in the Time field ");
		Assert.assertTrue(BasePage.clickElement(Rsp.TimeFielddropDown, driver));
		CommonUtils.waitforElementToClickable(driver, Rsp.SaveButton);
		Rsp.SaveButton.click();
		BaseTest.test.info("The Calander page is displayed with time slot 8:00PM to 9:00PM as a link ");

	}

	//(description="Blocking an event in the calender with weekly recurrance")
	
	@Test(priority = 4)
	public void RandomScenarios_TC37() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		BaseTest.test.info("Driver configured");
		RandomScenariosPage Rsp = new RandomScenariosPage(driver);
		Assert.assertTrue(BasePage.clickElement(Rsp.HomeTab, driver));
		BaseTest.test.info("Home page is displayed");
		Assert.assertTrue(BasePage.clickElement(Rsp.currentdatelink, driver));
		BaseTest.test.info("calender page with first name and LastName is displayed");
		Assert.assertTrue(BasePage.clickElement(Rsp.FourPMTimeLink, driver));
		BaseTest.test.info("New event page with cursor on subject field is displayed");
		Assert.assertTrue(BasePage.clickElement(Rsp.SubjectComboBoxIcon, driver));
		BaseTest.test.info("Combo Box popup is opened");
		Assert.assertTrue(Rsp.verifyCombopopupisClosed(driver), "popup failed to close");
		BaseTest.test.info("POPup is closed and 'other' entered in the subject field ");
		Assert.assertTrue(BasePage.clickElement(Rsp.EndTimeField, driver));
		BaseTest.test.info("Time is selected in the Time field ");
		Assert.assertTrue(BasePage.clickElement(Rsp.Time2FielddropDown, driver));
		BaseTest.test.info("Time is displayed in the Time field ");
		Assert.assertTrue(BasePage.clickElement(Rsp.RecurrenceCheckBox, driver));
		Thread.sleep(5000);
		Assert.assertTrue(BasePage.clickElement(Rsp.WeeklyRadioButton, driver));
		BaseTest.test.info("Radio button is selected ");
		BasePage.clickElement(Rsp.selectThursday, driver);
		BaseTest.test.info("Day is selected");
	
		Assert.assertTrue(BasePage.clickElement(Rsp.RecurrenceEndField, driver));
		Rsp.RecurrenceEndField.sendKeys("10/15/2023");
		BaseTest.test.info("End date is selected and calander is closed ");
		Assert.assertTrue(BasePage.clickElement(Rsp.SaveButton, driver));
		BaseTest.test.info("The Calander page is displayed with time slot  ");
		Assert.assertTrue(Rsp.veriFyMonthView(driver),"Failed to verify");
		BaseTest.test.info("Calender is displayed ");
	}

}