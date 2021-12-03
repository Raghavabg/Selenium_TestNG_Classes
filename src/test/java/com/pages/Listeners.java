package com.pages;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.main.Base;

// implements used to get interface which will have abstract methods
// extends is used in sub/child class from Base class - can be called only once  

public class Listeners extends Base  implements  ITestListener{	
	
	public RemoteWebDriver driver;
	
	 Logger logr = LogManager.getLogger(ContactsPage.class.getName());
	
	 ExtentTest test;
	 ExtentReports extent = ExtentReportsManager.createinstance();
	 ThreadLocal<ExtentTest> tExtentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result)
	{
		//System.out.println("Test Start from Listner");		
		 test = extent.createTest("Test Name :: "+ result.getMethod().getMethodName());
		tExtentTest.set(test);		
		//logr.info("Test Name started :: "+ result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		//System.out.println("Test PASS from Listner");		
		//String logtext = "<b>Test Case" + result.getMethod().getMethodName()+ "Successful</b>";
	      //	Markup ma = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
		tExtentTest.get().log(Status.PASS, "Test Passed");	
		logr.info("Test Name Passed :: "+ result.getMethod().getMethodName());
	}
		
	public void onTestFailure(ITestResult result)
	{
				
		try {
			
			//System.out.println("Test FAIL from Listner");		
			
			tExtentTest.get().fail(result.getThrowable());
		
			driver = null;		
			// to make thread safe and also assign the right class instance to take screen during parallel execution 			
			driver = (RemoteWebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
			tExtentTest.get().addScreenCaptureFromPath(getScreenShot(result.getMethod().getMethodName(), driver));
			
						
			logr.error("Test Name Failed :: "+ result.getMethod().getMethodName(), result.getThrowable());
			
			// tExtentTest.get().addScreenCaptureFromPath(getScreenShot(result.getMethod().getMethodName(), driver), result.getMethod().getMethodName());
			
			
			// getScreenShot(result.getMethod().getMethodName(), driver);  // call from base class 			
						
			/*;
			String execptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			tExtentTest.get().fail("<details> Exception message: "+ execptionMessage.replaceAll(",", "<br>") +"</details> \n");			
			String logtext = "<b>Test Case" + result.getTestName()+ "Failed</b>";
			Markup ma = MarkupHelper.createLabel(logtext, ExtentColor.RED);
			tExtentTest.get().log(Status.FAIL, ma);	
			*/			
			
		} 		
	     catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
					
	}
	
	
	
	public void onFinish(ITestContext context)
	{
		//System.out.println("Test Finish from Listner");
		//flush() - to write or update test information to your report. 
			extent.flush();			
	
	}
	

	
	
}
