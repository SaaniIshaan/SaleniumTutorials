package listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;
import utils.CommonUtils;

public class SFDCListeners extends BaseTest implements ITestListener{
	@Override 
	public void onTestSuccess(ITestResult result) {
		BaseTest.test.pass(result.getName()+"Test Passed");
		BaseTest.test.info(MarkupHelper.createLabel(result.getName()+" PASSED",ExtentColor.GREEN));
	}
	
	@Override 
	public void onTestFailure(ITestResult result) {
		BaseTest.test.fail(result.getName()+"Test Failed");
		BaseTest.test.info(MarkupHelper.createLabel(result.getName()+" FAILED",ExtentColor.RED));
		try {
		BaseTest.test.addScreenCaptureFromPath(CommonUtils.getScreenshot(BaseTest.getDriver()));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
