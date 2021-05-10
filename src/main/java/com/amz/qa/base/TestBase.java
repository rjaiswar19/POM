package com.amz.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.amz.qa.util.WebEventListener;
import com.amz.qa.report.ExtentReporterNG;
import com.amz.qa.util.TestUtil;




public class TestBase{
	
	public static WebDriver driver;
	public static Properties pro;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ExtentReporterNG extendreport;
	


	public void BeforeSuite()
	{
		ExtentReporterNG.setExtend();
	}
	


	
	


	public TestBase()
	{
		try{
			pro=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\amz\\qa\\config\\config.properties");
			pro.load(fis);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public static void initialization()
	{
		String browserName=pro.getProperty("Browser");
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjaiswar\\Desktop\\driver\\chromedriver.exe");	
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\rjaiswar\\Desktop\\driver\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(pro.getProperty("URL"));
		
		
		
		
	}
	public void AfterSuite()
	{
		ExtentReporterNG.endReport();
	}
	

}