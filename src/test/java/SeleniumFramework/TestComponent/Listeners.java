package SeleniumFramework.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumFramework.resorces.ExtentReporterNg;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNg.getReportObject();
	
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Pass");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
		//getTestClass().getRealClass().getField("driver").get(result.getInstance());
		
		try {
		driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		
		}catch(Exception e1){
			// TODO Auto-generated catch block
						e1.printStackTrace();
		}
		String filePath = null;
		try {
			
			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		//get Screenshot, attach to report
		
		
	
	}
	

	public void onTestSkipped(ITestResult result) {}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	
	public void onStart(ITestContext context) {}

	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	 
}
