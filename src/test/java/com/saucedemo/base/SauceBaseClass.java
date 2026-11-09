package com.saucedemo.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saucedemo.page.SauceHomePgae;
import com.saucedemo.page.SauceLoginPage;
//import com.sun.org.apache.bcel.internal.classfile.Method;

public class SauceBaseClass {
	
	public static WebDriver driver;
	public SauceLoginPage ob;
	public 	WebDriverWait wait;
	public SauceHomePgae ho;
	
	public static ExtentSparkReporter reporter;
	public static ExtentTest test;
	public static ExtentReports extent;
	
	@BeforeTest
	public void setup()
	{
		reporter = new ExtentSparkReporter("./report/saucedemoreport.html");
		reporter.config().setDocumentTitle("Automation_saucedemo");
		reporter.config().setReportName("functional test");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "windows10");
		extent.setSystemInfo("testername", "abs");
		
		ChromeOptions options = new ChromeOptions();
		//incognito
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@BeforeMethod
	public void bfrmthd(Method mthd)
	{
		ob = new SauceLoginPage(driver);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		ho = new SauceHomePgae(driver);
		
		test = extent.createTest(mthd.getName());
	}
	
	@AfterTest()
	public void teardown()
	{
		extent.flush();
	}
	
	@AfterMethod
	public void browserclose(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "failed test case is"+result.getName());
			test.log(Status.FAIL, "failed test case is"+result.getThrowable());
			String Screenshotpath = screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(Screenshotpath);
			
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP,"test case skiped is"+result.getName());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"test case passed is"+result.getName());
		}
	}
	
	public static String screenshotMethod(WebDriver driver,String scnname) throws IOException
	{
		File src =( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = "./scnshot/"+scnname+".png";
		FileHandler.copy(src,new File(dest));
		return dest;
	}
	
	@DataProvider(name = "keralalogin")
	public Object[][] getdata() throws IOException
	{
		String st = "C:\\Users\\Hp\\Documents\\inputssss\\inputssss.xlsx";

		return com.exelutils.ExelUtils.getTestData(st,"Sheet2");
	}
	
	

}
