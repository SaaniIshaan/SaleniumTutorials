package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FileConstants;
import utils.CommonFileUtils;
import utils.CommonUtils;
import utils.CommonFileUtils;


public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="Login")
	public WebElement loginButton;
	
	@FindBy(id="error")
	public WebElement errorMessage;
	
	@FindBy(id="idcard-identity")
	public WebElement SavedUsername;
	
	@FindBy(id="forgot_password_link") 
	public WebElement forgotPassword;
	
	@FindBy(id="rememberUn")
	public WebElement rememberMe;
	
	@FindBy(id="un")
	public WebElement forgotUsername;
	
	@FindBy(id="home_Tab")
	public WebElement homeTab;
	
	@FindBy(id="continue")
	public WebElement Continue;
	
	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnTOLoginButton;
	
	
	public String checkCredentialMessaage ="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
	public String missingpasswordtext = "Please enter your password." ;
	
	public boolean selectrememberMeCheckBox() {
		logger.info("LoginPage : selectrememberMeCheckBox : Started") ;
		boolean isSelected = false;
		if(!rememberMe.isSelected()) {
			logger.info("LoginPage : selectrememberMeCheckBox : remember me checkbox is selected") ;
			rememberMe.click();
			isSelected = true;
		}
		logger.info("LoginPage : selectrememberMeCheckBox : Ended") ;
		return isSelected;
	}
	
	
	public void loginToApp(WebDriver driver) throws IOException {
	driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"prod.url"));
	logger.info("LoginPage : loginToApp : Started") ;
	driver.manage().window().maximize();
	logger.info("LoginPage : loginToApp :Window maximized") ;
	if (CommonUtils.waitForElement(driver, username)) {
	
		username.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"username"));
				
		password.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2,"password" ));
		logger.info("LoginPage : loginToApp : Clicked on login button") ;
				loginButton.click();
		}
	}

}