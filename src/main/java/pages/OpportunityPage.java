package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.sl.draw.geom.GuideIf.Op;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import tests.BaseTest;
import utils.CommonFileUtils;
import utils.CommonUtils;

public class OpportunityPage extends BasePage {
	
	public OpportunityPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(id ="Opportunity_Tab")
	public WebElement Opportunities;
	
	@FindBy(id ="fcf")
	public WebElement AllOpportunityItems;
	
	@FindBy(name ="go")
	public WebElement Gobutton;
	
	@FindBy(linkText ="Edit")
	public WebElement Editbutton;
	
	@FindBy(linkText ="Create New View")
	public WebElement CreateNewView;
	
	@FindBy(id ="hotlist_mode")
	public WebElement RecentlyViewed;
	
	@FindBy(className ="pageDescription")
	public WebElement OpportunityHomePage;
	
	@FindBy(name ="new")
	public WebElement Newbutton;
	
	@FindBy(id ="quarter_q")
	public WebElement IntervalBox;
	
	@FindBy(xpath ="//select[@id='quarter_q']")
	public WebElement IntervalBoxdropdown;
	
	@FindBy(xpath ="//select[@id='open']")
	public WebElement IncludeBox;
	
	@FindBy(id ="")
	public WebElement IncludeBoxdropdown;
	
	@FindBy(name ="go")
	public WebElement Runreport;
	
	@FindBy(id ="fname")
	public WebElement ViewNamedropDown;
	
	@FindBy(id ="devname")
	public WebElement ViewUniqueNamedropDown;
	
	@FindBy(className ="pageDescription")
	public WebElement EditOpportunityPage;
	
	@FindBy(name ="save")
	public WebElement Save;
	
	@FindBy(id ="fcol1")
	public WebElement FielddropDown;
	
	@FindBy(id ="fop1")
	public WebElement Operator;
	
	@FindBy(id ="fval1")
	public WebElement Value;
	
	@FindBy(xpath ="//div[@class='selectTitle']")
	public WebElement SelectedFields;
	
	@FindBy(id ="colselector_select_0")
	public WebElement AvailableFields;
	
	@FindBy(className ="rightArrowIcon")
	public WebElement Addbutton;
	
	@FindBy(className ="leftArrowIcon")
	public WebElement RemoveButton;
	
	@FindBy(id ="opp3")
	public WebElement OpportunityName;
	
	@FindBy(id ="opp4")
	public WebElement AccountName;
	
	@FindBy(id ="opp6")
	public WebElement LeadSource;
	
	@FindBy(id ="opp9")
	public WebElement CloseDate;
	
	@FindBy(id ="opp11")
	public WebElement Stage;
	
	@FindBy(id ="opp12")
	public WebElement Probability;
	
	@FindBy(id ="opp17")
	public WebElement PrimaryCampaignSource;
	
	@FindBy(linkText ="Opportunity Pipeline")
	public WebElement OpportunityPipelineLink;
	
	@FindBy(linkText ="Stuck Opportunities ")
	public WebElement StuckOpportunities;
	
	@FindBy(className ="lbHeader")
	public WebElement QuarterlySummaryLink;
	
	@FindBy(xpath ="//h1[@class='noSecondHeader pageType']")
	public WebElement OpportunityPipelinePage;
	
	@FindBy(xpath ="//h1[@class='noSecondHeader pageType']")
	public WebElement StuckOpportunityPage;
	
	
	
	
	public boolean SelectAllOpportunities(WebDriver driver, String sOption) throws InterruptedException  {
		boolean isOptionSelected = false;
			if(Opportunities.isDisplayed()) {
				Opportunities.click();
			
			}	
			
		WebElement AllOpportunityItems	= driver.findElement(By.xpath("//*[@id='fcf']//option"));
			if(AllOpportunityItems.isDisplayed()) {
				AllOpportunityItems.click();
				isOptionSelected =true;
		
			logger.info(" OpportunityPage : SelectAllOpportunities : OpportunityItems Displayed" );
			}
		
				return isOptionSelected;
	}

	public boolean verifyAllOpportunityItems(WebDriver driver) throws IOException {
		
		boolean isOptionVerified = true;

		String[] expectedAllOpportunityItems = CommonFileUtils.readPropertiesFile(FileConstants.OPPORTUNITY_TESTDATA_FILE_PATH,"Opportunity.items").split(",");
		
		List<WebElement> AllOpportunityItems = new ArrayList<WebElement>();
		AllOpportunityItems	= driver.findElements(By.xpath("//*[@id='fcf']//option"));
		ArrayList<String>actualElementText = new ArrayList<String>();
		
		for(WebElement element : AllOpportunityItems) {
			actualElementText.add(element.getText());
		}
		
		for(int i=0; i< expectedAllOpportunityItems.length; i++) {
				
			if(actualElementText.contains(expectedAllOpportunityItems[i])) {
				 System.out.println("Expected Option" + expectedAllOpportunityItems[i]);
			 }else {
				 
			  System.out.println("Expected Option" +expectedAllOpportunityItems[i] + "failed to match with Actual Option");
			  
				isOptionVerified = false;
			 }
				logger.info( "OpportunityPage : verifyAllOpportunityItems : AllOpportunityItems verified");
		}	
		return isOptionVerified ;
	}				 
	
	public boolean NewOpportunityPageWithDetailsisDisplayed(WebDriver driver) throws IOException {
		boolean  NewDetailPageisDisplayed = false;
		if(CommonUtils.waitForElement(driver,Newbutton )) {
			if(Newbutton.isDisplayed()) {
			Newbutton.click();
			}
		}
		if(CommonUtils.waitForElement(driver,EditOpportunityPage )) {
			if(EditOpportunityPage.isDisplayed()) {
			OpportunityName.clear();
			OpportunityName.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.OPPORTUNITY_TESTDATA_FILE_PATH, "OpportunityName"));
			AccountName.clear();
			AccountName.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.OPPORTUNITY_TESTDATA_FILE_PATH, "AccountName"));
			CloseDate.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.OPPORTUNITY_TESTDATA_FILE_PATH, "CloseDate"));
			Probability.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.OPPORTUNITY_TESTDATA_FILE_PATH, "Probability"));
			PrimaryCampaignSource.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.OPPORTUNITY_TESTDATA_FILE_PATH,"PrimaryCampaignSource" ));
			
			NewDetailPageisDisplayed = true;
			logger.info( "OpportunityPage : Opportunity page with details : Opportunity Page with details displayed");
			}
		}	
		
		return   NewDetailPageisDisplayed;
	}

	
	public boolean verifyPipelinedOpportunityPageisDisplayed(WebDriver driver) {
		boolean isDisplayed = false;
		CommonUtils.waitForElement(driver,OpportunityHomePage);
		 if(OpportunityHomePage.isDisplayed()) {
			 OpportunityPipelineLink.click();
		 }
		 if(BasePage.verifyElementisDisplayed(driver, OpportunityPipelinePage)) {
			 isDisplayed = true;
			 logger.info( "OpportunityPage :   Verify PipelineOpportunity page : PipelineOpportunity page is verified");
		 }
		 return isDisplayed;
	}
	
	public boolean verifyReportPagewithStuckOpportunitiesisDisplayed(WebDriver driver) {
		boolean isReportPageDisplayed = false;
		CommonUtils.waitForElement(driver,OpportunityHomePage);
		if(OpportunityHomePage.isDisplayed()) {
			if(CommonUtils.waitForElement(driver, StuckOpportunities)) {
				StuckOpportunities.click();
			}
			if(BasePage.verifyElementisDisplayed(driver,StuckOpportunityPage)) {
				isReportPageDisplayed  = true;
			 logger.info( "OpportunityPage :   Verify StuckOpportunity Report page : StuckOpportunity Report page is verified");
			}
		}
			return  isReportPageDisplayed ;
	}	
		
	public boolean VerifyOpportunityReportPagewithSearchCriteria(WebDriver driver) throws IOException, InterruptedException {
		boolean isVerified = false;
		CommonUtils.waitForElement(driver,OpportunityHomePage);
		if(OpportunityHomePage.isDisplayed()) {
			QuarterlySummaryLink.click();
		}
			if(CommonUtils.waitForElement(driver, IntervalBox )) {
				IntervalBox.click();
		
				WebElement IntervalBoxdropdown = driver.findElement(By.xpath("//select[@id='quarter_q']")) ;
				Select select  = new Select(IntervalBoxdropdown);
				select.selectByVisibleText("Current FQ");
				select.selectByVisibleText("Next FQ");
				
				CommonUtils.waitForElement(driver, IncludeBox);
					IncludeBox.click();
				
				WebElement  IncludeBoxdropdown = driver.findElement(By.xpath("//select[@id='open']")); 
				Select select1  = new Select(IncludeBoxdropdown);
				select1.selectByValue("all");
				select1.selectByValue("closed");
				select1.selectByValue("open");
				Runreport.click();
				isVerified = true;
				logger.info( "OpportunityPage :  Verify Opportunity Report page : Opportunity Report page is verified");
			}
			
	
				return isVerified;
				
		}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

