package com.main;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;

public class Base {

	public RemoteWebDriver driver;
	public Properties prop;

	public RemoteWebDriver intializeDriver() {
		try {

			System.out.println("Base intializeDriver started");
			
			 prop = new Properties();			
			 InputStream fisr = getClass().getClassLoader().getResourceAsStream("databrowser.properties");
			 

			prop.load(fisr);
			String browser = prop.getProperty("browser");
	
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				driver = new RemoteWebDriver(new URL("http://P190493l:4444/wd/hub"), options); // Local run
				
		
			} else if (browser.equalsIgnoreCase("firefox")) {
				// firfox details 

			}

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);			
			driver.get(prop.getProperty("produrl"));	
			driver.manage().window().maximize();  	

		}

		catch (Exception e) {
			System.out.println(" error occurred " + e.getMessage());
		}

		return driver;

	}
	
	
	public String getScreenShot(String testcasename,RemoteWebDriver driver)
	{
		String destination = null;
		try {			
			
			TakesScreenshot ts = (TakesScreenshot) driver;  // selelnium class TakesScreenshot
			 File Source = ts.getScreenshotAs(OutputType.FILE); // java io file 
			 
			 String datename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); // java SimpleDateFormat class
			 
		    destination = System.getProperty("user.dir") + "/Screenshots/" + testcasename + datename + ".png";			 
			 File finaldestination = new File(destination);   		
			   Files.copy(Source, finaldestination);	 
			   	   			
		}
		
		catch (Exception e) {
			System.out.println(" error occurred " + e.getMessage());
		}
		
		System.out.println("screenshot path is "+ destination);
		return destination;
		
	}
	
	

}
