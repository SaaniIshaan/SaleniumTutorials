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
import pages.OpportunityPage;
import utils.CommonUtils;
import pages.BasePage;
import pages.LoginPage;
import pages.OpportunityPage;

	@Listeners(SFDCListeners.class)
	public class OpportunityTest extends BaseTest{
		@BeforeClass
		public void navigateToHome()throws IOException {
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
		
			lp.loginToApp(driver);
		}
		
	//	(description="opportunities drop down")
		@Test(priority = 0)
		public void CreateOpty_TC15() throws InterruptedException, IOException {
			
			WebDriver driver = BaseTest.getDriver();
			BaseTest.test.info("Driver configured");
			
			OpportunityPage Op = new OpportunityPage(driver);
			CommonUtils.waitForElement(driver,Op.Opportunities);
			Op.Opportunities.click();
			BaseTest.test.info("Opportunity home page is displayed");
			CommonUtils.waitForElement(driver,Op.AllOpportunityItems);
			Op.verifyAllOpportunityItems(driver);
			Assert.assertTrue(Op.verifyAllOpportunityItems(driver),"Failed to verify");
			BaseTest.test.info("All Opportunity items are verified");
			
		}		
			
		//	(description = "Create a new Opty")
			@Test(priority = 1)
			public void CreateOpty_TC16() throws IOException {
				
				WebDriver driver = BaseTest.getDriver();
				OpportunityPage Op = new OpportunityPage(driver);
				CommonUtils.waitForElement(driver,Op.Opportunities);
				Op.Opportunities.click();
				BaseTest.test.info("Opportunity home page is displayed");
				
				Assert.assertTrue(Op.NewOpportunityPageWithDetailsisDisplayed(driver),"");
				Assert.assertTrue(BasePage.selectDropdownItems(driver, Op.LeadSource, "Purchased List"));
				Assert.assertTrue(BasePage.selectDropdownItems(driver, Op.Stage, "Prospecting"));
				
				Op.Save.click();
				BaseTest.test.info("Opportunity page is displayed with all the details");
			}
			
			
		//	(description = "Test opportunity Pipeline Report")
			@Test(priority = 2)
			public void CreateOpty_TC17() throws IOException {
				
				WebDriver driver = BaseTest.getDriver();
				OpportunityPage Op = new OpportunityPage(driver);
				CommonUtils.waitForElement(driver,Op.Opportunities);
				Op.Opportunities.click();
				BaseTest.test.info("Opportunity home page is displayed");
				Assert.assertTrue(Op.verifyPipelinedOpportunityPageisDisplayed(driver),"Failed to display");
				BaseTest.test.info(" PipelineOpportunity page is displayed ");
				
			}
			
		//	(description = "Test Stuck Opportunities Report")
			@Test(priority = 3)
			public void CreateOpty_TC18() throws IOException {
				
				WebDriver driver = BaseTest.getDriver();
				OpportunityPage Op = new OpportunityPage(driver);
				CommonUtils.waitForElement(driver,Op.Opportunities);
				Op.Opportunities.click();
				BaseTest.test.info("Opportunity home page is displayed");
			Assert.assertTrue(Op.verifyReportPagewithStuckOpportunitiesisDisplayed(driver),"Failed to display");
			BaseTest.test.info(" StuckOpportunity page is displayed ");
			
		}	
			
			
			//(description = "Test Quarterly Summary Report")
			
			@Test(priority = 4)
			public void CreateOpty_TC19() throws IOException, InterruptedException {
				
				WebDriver driver = BaseTest.getDriver();
				OpportunityPage Op = new OpportunityPage(driver);
				CommonUtils.waitForElement(driver,Op.Opportunities);
				Op.Opportunities.click();
				BaseTest.test.info("Opportunity home page is displayed");
			Assert.assertTrue(Op.VerifyOpportunityReportPagewithSearchCriteria(driver),"Failed to verify");
			BaseTest.test.info(" Opportunity Report Page with search Criteria is verified ");
			
			}		
			
	}