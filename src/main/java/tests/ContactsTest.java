package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.SFDCListeners;
import pages.BasePage;
import pages.ContactsPage;
import pages.LoginPage;

	@Listeners(SFDCListeners.class)
	public class ContactsTest extends BaseTest{
		@BeforeClass
		public void navigateToHome()throws IOException {
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
		
			lp.loginToApp(driver);
		}
		
	//	(description="Create new contact")
		
		@Test(priority= 0)
		public void Contacts_TC25() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			ContactsPage Cp = new ContactsPage(driver);

			Assert.assertTrue(Cp.verifyNewContactHomePageisDisplayed(driver),"Failed to display");
			BaseTest.test.info("contacts home page is displayed");
			Assert.assertTrue(Cp.verifyNewContactPagewithDetailsIsDisplayed(driver),"Failed to verify");
			BaseTest.test.info(" New contacts page is displayed");
			
		}		
			
	//	(description="Create new view in the contact Page")
		
		@Test(priority= 1)
		public void Contacts_TC26() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			ContactsPage Cp = new ContactsPage(driver);

			Assert.assertTrue(Cp.verifyNewContactHomePageisDisplayed(driver),"Failed to display");
			BaseTest.test.info("contacts home page is displayed");
			Assert.assertTrue(Cp.VerifyCreatedViewNameisDisplayedinContactsPage(driver),"Failed to verify");
			BaseTest.test.info("Contact HomePage is displayed with Created view name");
			
		}
		
	//  (description="check recently created contacts in the contact Page")
		
		@Test(priority= 2)
		public void Contacts_TC27() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			ContactsPage Cp = new ContactsPage(driver);

			Assert.assertTrue(Cp.verifyNewContactHomePageisDisplayed(driver),"Failed to display");
			BaseTest.test.info("contacts home page is displayed");
			BasePage.selectDropdownItems(driver, Cp.RecentlyViewedContacts, "Recently Created");
			BaseTest.test.info("Recently Created Contacts Are displayed");
		
		}
		
		
	//	(description="check My contact view in the Contact Page")
		
		@Test(priority= 3)
		public void Contacts_TC28() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			ContactsPage Cp = new ContactsPage(driver);

			Assert.assertTrue(Cp.verifyNewContactHomePageisDisplayed(driver),"Failed to display");
			BaseTest.test.info("contacts home page is displayed");
			Assert.assertTrue(Cp.verifyContactsViewItemsDisplayed(driver),"Failed to verify");
			BaseTest.test.info("All contacts are verified");
			Assert.assertTrue(BasePage.selectDropdownItems(driver, Cp.ViewContactsdropDown, "My Contacts"));
			BaseTest.test.info("My contacts is selected");
			
		}
		
	//	(description="View a Contact in the Contact Page")
		
		@Test(priority= 4)
		public void Contacts_TC29() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			ContactsPage Cp = new ContactsPage(driver);

			Assert.assertTrue(Cp.verifyNewContactHomePageisDisplayed(driver),"Failed to display");
			BaseTest.test.info("contacts home page is displayed");
			Assert.assertTrue(Cp.verifyselectContactName(driver), "");
			BaseTest.test.info("contact name is selected");
			Assert.assertTrue(Cp.verifyContactPageWithAlltheInformation(driver),("Failed to verify"));
			BaseTest.test.info("Recent Contact is displayed with all the information");
			
		}
		
	//	(description="Check the Error message if, the required information is not entered while creating a New view in Contacts")
		
		@Test(priority= 5)
		public void Contacts_TC30() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			ContactsPage Cp = new ContactsPage(driver);

			Assert.assertTrue(Cp.verifyNewContactHomePageisDisplayed(driver),"Failed to display");
			BaseTest.test.info("contacts home page is displayed");
			Assert.assertTrue(Cp.VerifyErrormessageisAppear(driver),"Failed to appear");
			BaseTest.test.info("Error Meassage is appeared in the view name field is verified");
			
		}	
	//	(description="Check the Cancel button works fine in Create New View")
		
		@Test(priority= 5)
		public void Contacts_TC31() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			ContactsPage Cp = new ContactsPage(driver);

			Assert.assertTrue(Cp.verifyNewContactHomePageisDisplayed(driver),"Failed to display");
			BaseTest.test.info("contacts home page is displayed");
			Assert.assertTrue(Cp.verifyViewNameisNotCreated(driver),"Failed to verified");
			BaseTest.test.info("ViewName is not created is verified");
		}	
			
	//	(description="Check the Save and New button works in New Contact page")
		
		@Test(priority= 6)
		public void Contacts_TC32() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			ContactsPage Cp = new ContactsPage(driver);

			Assert.assertTrue(Cp.verifyNewContactHomePageisDisplayed(driver),"Failed to display");
			BaseTest.test.info("contacts home page is displayed");
			Cp.NewButton.click();
			Assert.assertTrue(Cp.verifyNewContactEditPageisDisplayed(driver),"Failed to verify");
			BaseTest.test.info("New Edit Contact Page is verified");
		}
			
	}		