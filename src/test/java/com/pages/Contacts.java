package com.pages;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.main.Base;

public class Contacts extends Base{	
	
	@BeforeTest
	public void setupNintializeDriver() {		
		driver = intializeDriver();  // assign the driver handle to local driver	
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test(enabled = true, groups = {"Smoke"})
	public void Contacts_04() 
	{
		try {		
			
			Thread.sleep(3000);	
			
			System.out.println("Customer Service check ");
	
		ContactsPage cp = new ContactsPage(driver);  // page instance 			
		Thread.sleep(2000);	
		
		if (cp.lnkCustomerservice.isDisplayed()) 
		{
			cp.lnkCustomerservice.click();
			//System.out.println("Customer Service -link exist ");
		} else {
			System.out.println("Customer Service -link does not exist ");
		}
          
		Thread.sleep(2000);

		if (cp.lnkContactUs.isDisplayed())
		{
			cp.lnkContactUs.click();
			//System.out.println("Contact Us -link exist ");			
		} else {
			System.out.println("Contact Us -link does not exist ");
		}
		
		Thread.sleep(3000);	
		
		// intention to fail the test cases 
		String text = cp.lnkonlineform().getText();	
		System.out.println("Reading value from the link for View forms-- "+text);	
		//Assert.assertEquals(text, "online");
		
		
		String text1 = cp.lnkProviderPortal().getText();	
		System.out.println("Reading value from the link for Provide portal-- "+text1);	
		
		System.out.println("Contacts  Done ");	
		
		}
		
		  catch (InterruptedException e) {			
				e.printStackTrace();
			}	  

	}


}
