package com.saucedemo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {
	
	WebDriver driver;
	
	@FindBy(id = "user-name")
	WebElement userfiled;
	
	@FindBy(id = "password")
	WebElement passwordfield;
	
	@FindBy(id = "login-button")
	WebElement login;
	
	public SauceLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setvalues(String user, String pass)
	{
		userfiled.sendKeys(user);
		passwordfield.sendKeys(pass);
		
	}
	
	public void login()
	{
		login.click();
	}
	
	public String title()
	{
		return driver.getTitle();
	}
	

}
