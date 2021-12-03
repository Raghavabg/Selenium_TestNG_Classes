package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CareersPage {

	public RemoteWebDriver driver;	
	
	public CareersPage(RemoteWebDriver driver) {

		this.driver = driver; // assign to local driver		
		this.lnkCareers = driver.findElement(By.linkText("Careers"));
		this.lnkAboutUs = driver.findElement(By.linkText("About Us"));
	}
		
	
	// Variables 			
	WebElement lnkCareers,lnkAboutUs;
	
		
	 
}
