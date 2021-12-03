package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ExamplePageObjectforHomePage {
	
	public RemoteWebDriver driver;

	By login = By.cssSelector("a[data-automation-id='myaccount-login-header']");
	By Usernamefield = By.id("username");
	By Passwordfield = By.id("password");
	By SignupTodayfield = By.linkText("Sign Up Today!");

	public ExamplePageObjectforHomePage(RemoteWebDriver driver) {

		this.driver = driver; // assign to local driver

	}

	public WebElement getlogin() {

		return driver.findElement(login);

	}

	public WebElement getUsernamefield() {

		return driver.findElement(Usernamefield);

	}
	
	public WebElement getPwdfield() {

		return driver.findElement(Passwordfield);

	}

	public WebElement getSignupTodayfield() {

		return driver.findElement(SignupTodayfield);

	}

}
