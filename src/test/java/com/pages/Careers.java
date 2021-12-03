package com.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.main.Base;

public class Careers extends Base{
	public RemoteWebDriver driver;	

	@BeforeTest
	public void setupNintializeDriver() {
		driver = intializeDriver();  // assign the driver handle to local driver	
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
			
	// methods or test cases 	
	@Test(enabled = true, groups = {"Smoke"})
	public void Careers_TC05() throws InterruptedException
	{		
		CareersPage pg= new CareersPage(driver); // page instances
		
		//System.out.println("Careers_TC05  here ");
		
		if(pg.lnkCareers.isDisplayed())
		{
			pg.lnkCareers.click();
			System.out.println("Careers -link exist ");
		}
		else {
			System.out.println("Careers -link does not exist ");
		}
		
            Thread.sleep(2000);	
	    driver.navigate().back();	
				
		System.out.println("Careers_TC05  Done ");
		
	}
	
	
	
	@Test(enabled = true, groups = {"Smoke"})
	public void AboutUs_TC06() throws InterruptedException
	{		
		CareersPage pg= new CareersPage(driver); // page instances
		
		//System.out.println("AboutUs_TC06 here ");
		
		if(pg.lnkAboutUs.isDisplayed())
		{
			pg.lnkAboutUs.click();
			System.out.println(" About Us just display ");
		}
		else {
			System.out.println("About Us cannot show");
		}
		
		Thread.sleep(2000);	
		driver.navigate().back();	
				
		System.out.println("AboutUs_TC06  Done ");
		
	}
	
	

}
