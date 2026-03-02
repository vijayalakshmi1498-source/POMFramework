package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utils.ExtentManager;
import utils.Screenshotutils;

public class TestListeners implements ITestListener {
ExtentReports extent =ExtentManager.getReportInstance();//ExtentManager la irundhu report object vangrom.
ExtentTest test;


@Override
public void onTestStart(ITestResult result) {
    test = extent.createTest(result.getName());
}
public void onTestSuccess(ITestResult result)
{
	if (test != null) {
        test.pass("Test Passed");
}}
@Override
public void onTestFailure(ITestResult result) {

    if (test == null) {
        test = extent.createTest(result.getName());
    }

    test.fail(result.getThrowable());

    Object currentClass = result.getInstance();
    WebDriver driver = ((BaseTest) currentClass).driver;

    String path = Screenshotutils.captureScreenshot(driver, result.getName());
    test.addScreenCaptureFromPath(path);
}

 /*public void onTestFailure(ITestResult result) 
{
	 if(test==null)
	 test.fail("Test Failed");  
 BaseTest base=(BaseTest)result.getInstance();//Current running test class instance edukkrom.
 String path=Screenshotutils.captureScreenshot(base.driver,result.getName());//Capture Screenshot
 test.addScreenCaptureFromPath(path);//Attach Screenshot to Report	
}*/
 public void onFinish(ITestContext context)
 {
	 extent.flush();//Report file write pannum.without this report will not generate
 }
 
 
	}

