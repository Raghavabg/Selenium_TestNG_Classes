package com.pages;


import java.io.File;
import java.util.Date;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager {
	
	RemoteWebDriver driver;
	
	public static ExtentReports extent;
	
  public ExtentReportsManager(RemoteWebDriver driver) {
		
		
		this.driver = driver;  // assign to local driver 
	}
	
	
	public static ExtentReports createinstance()	
	{
		
	
		String filename = getReportname();		
		String directory = System.getProperty("user.dir") + "/ExtentReports/";	
		new File(directory).mkdir();
		String path = directory + filename;				
		
		//String path = System.getProperty("user.dir") + "/ExtentReports/" + "Results.html";	
		System.out.println("path is "+path);
		
		// Section 1 of ExtentReports is config report names, themes and Doc title  
		ExtentHtmlReporter htmlrepo = new ExtentHtmlReporter(path);		
		htmlrepo.config().setEncoding("utf-8");
		htmlrepo.config().setDocumentTitle("TestNG Test Automation Results");
		htmlrepo.config().setReportName("Corp web Results");
		htmlrepo.config().setTheme(Theme.STANDARD);
		
		// Section 2 of ExtentReports is adding system info like Environment, browser and platforms 
		extent = new ExtentReports();
		extent.setSystemInfo("Environment", "Production");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Platform", "Windows");
		extent.attachReporter(htmlrepo);
				
		return extent;		
	}
	
	
	
	public static String getReportname()
	{
		Date d = new Date();
		
		String filename = "Automation Report" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		
		return filename;
		
	}

}
