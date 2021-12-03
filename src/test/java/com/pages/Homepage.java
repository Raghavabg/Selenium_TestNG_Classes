package com.pages;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.main.Base;

public class Homepage extends Base{

	public RemoteWebDriver driver;
	
	@BeforeTest
	  public void setupNintializeDriver() {
			
		 driver = intializeDriver(); // assign the driver handle to local driver
		}
	
	
	 @AfterTest
	  public void teardown() {
			
			driver.quit();	
		}
		
	
  @Test(dataProvider="getdata" ,enabled = true, groups = {"Regression"})
  public void BasepageNavigation(String username,String password) {
	  
	  try {	  
		  
		  System.out.println("Homepage here ");
		
		  driver.get(prop.getProperty("produrl"));	// needs url hit for each data provider loop 
		  
		  Thread.sleep(2000);
					  
		ExamplePageObjectforHomePage lp = new ExamplePageObjectforHomePage(driver);
		
		if(lp.getlogin().isDisplayed())
		{
			lp.getlogin().click();
		}
		else
		{
			System.out.println("Login Link do not exist");
		}
				
		if(lp.getUsernamefield().isDisplayed())
		{
			lp.getUsernamefield().sendKeys(username);
			System.out.println("Login Page dispayed successfully ");
		}
		else
		{
			System.out.println("Failed to display Login page");
		}
	
		
		if(lp.getPwdfield().isDisplayed())
		{
			lp.getPwdfield().sendKeys(password);			
		}
		else
		{
			System.out.println("Failed to display Login page");
		}
		
		// assert check 
		Assert.assertEquals(lp.getSignupTodayfield().getText(), "Sign Up Today!");
		Assert.assertTrue(lp.getSignupTodayfield().isDisplayed());
						
			Thread.sleep(3000);				
			
			
		} 
	  
 
	  catch (InterruptedException e) {			
			e.printStackTrace();
		}	  

  }
  
  
  @DataProvider
  public Object[][] getdata() {
	  
	  // Rows - one and multipls columns 
	  // columns 	  
	  // Array size is 2    i.e 0,1,2  --- else you will get Array out of bound exceptions 
	  Object[][] data = new   Object[2][2];	  
	  data[0][0] = "Frist name";	  
	  data[0][1] = "password11";
	  data[1][0] = "Second name";
	  data[1][1] = "passwrd22";
	  
	return data;
	  
  }
  
  
  
}
