package com.saucedemo.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.saucedemo.base.SauceBaseClass;

public class SauceTest extends SauceBaseClass {

	@Test(priority =0)
	public void Validloginpage()  throws Exception
	{
//		test = extent.createTest("Validloginpage");
		ob.setvalues("standard_user","secret_sauce");
		ob.login();
		wait.until(ExpectedConditions.urlContains("inventory.html"));
		Reporter.log("login successs");
		
		Thread.sleep(3000);
	}
	
//	@Test(priority =1)
//	public void titleverify()
//	{
////		test = extent.createTest("titleverify");
//
//		String actual = ob.title();
//		
//		System.out.println("title============"+actual);
//		
//		Assert.assertEquals(actual, "Swag Labs");
//		Reporter.log("titleverify successs");
//
//	}
	
	@Test(dataProvider = "keralalogin",priority = 1)
	public void invalidtest(String username , String password)
	{
		driver.findElement(By.id("ulogin")).clear();
		driver.findElement(By.id("ulogin")).sendKeys(username);
		driver.findElement(By.id("upass")).clear();
		driver.findElement(By.id("upass")).sendKeys(password);
		driver.findElement(By.id("sub_logbtn")).click();
		
		System.out.println("executed for  "+username);
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.urlContains("myhome"));
	}
}
