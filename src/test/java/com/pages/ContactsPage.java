package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ContactsPage {
	
public RemoteWebDriver driver;	
	
	public ContactsPage(RemoteWebDriver driver) {

		this.driver = driver; // assign to local driver		
		// this.lnkCustomerservice = driver.findElementByLinkText("Customer Service");
		this.lnkCustomerservice = driver.findElementByXPath("/html/body/app-root/div[1]/corpweb-header/header/nav/ul/li[4]/button");
		this.lnkContactUs = driver.findElementByLinkText("Contact Us");
		//this.lnkonlineform = driver.findElementByLinkText("view our forms"); // fails because driver looks for the object initially 
	}
	
	
	// Variables 			
		WebElement lnkCustomerservice,lnkContactUs;	
		
		// since the object is in other pages		
		WebElement lnkonlineform()
		{ 						
			return driver.findElementByLinkText("view our forms");
		
		}
		
		WebElement lnkProviderPortal()
		{ 						
			return driver.findElementByLinkText("Provider Portal");
		
		}
		
		
		
	
}
