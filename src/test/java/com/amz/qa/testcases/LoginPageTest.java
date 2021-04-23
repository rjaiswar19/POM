package com.amz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.page.HomePage;
import com.amz.qa.page.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
    
	@BeforeMethod
	public void setUP()
	{
		initialization();
		loginpage=new LoginPage();
		
	}
	
	
	
	
	
	@Test(priority=3)
	public void loginTest(){
		homepage = loginpage.login(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	
	
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//
//	}
}
