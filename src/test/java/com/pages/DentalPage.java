package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.main.Base;

public class DentalPage extends Base{
	
	public RemoteWebDriver driver;
	
	@BeforeTest
	  public void setupNintializeDriver() {
			
		 driver = intializeDriver();  // assign the driver handle to local driver		
		}
	
	
	 @AfterTest
	  public void teardown() {
			
			driver.quit();	
		}
	
  @Test(enabled = true, groups = {"Smoke", "Regression"})
  public void DentalQuotes() throws InterruptedException {
	  
	  
	  
	  if(driver.findElementByLinkText("What We Offer").isDisplayed())		
		{				
		 driver.findElementByLinkText("What We Offer").click();
		}
		else
		{
			 System.out.println("What We Offer link does not exist");
					
	    }	
		
	    
	    if(driver.findElementByLinkText("Dental Insurance").isDisplayed())		
		{				
		 driver.findElementByLinkText("Dental Insurance").click();
		}
		else
		{
			 System.out.println("Dental Insurance- link does not exist");
				
	    }	
	    
	    // without sync this will fail 
	    Thread.sleep(5000);	
	    
	    if(driver.findElement(By.cssSelector("button[data-automation-id='dental-get-coverage-Preferred']")).isDisplayed())
		{
			driver.findElement(By.cssSelector("button[data-automation-id='dental-get-coverage-Preferred']")).click();				
		}						
		else
		{
			System.out.println("dental-get-coverage-Preferred-- do not exist on Dental page");		
			
		}
		
		Thread.sleep(3000);		
	    
	    driver.navigate().back();	
	    
			 Thread.sleep(2000);	
			 System.out.println("DentalQuotes  Done ");
  }
}
