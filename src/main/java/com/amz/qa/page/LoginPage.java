package com.amz.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;


public class LoginPage extends TestBase {
	
	@FindBy(id="ap_email")
	WebElement UserName;
	
	
	@FindBy(id="ap_password")
	WebElement Password;
	
	@FindBy(xpath="//span[@id='continue']")
	WebElement Cntbtn;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement SignInbtn;
	
	@FindBy(id="signInSubmit")
	WebElement Singinsubmitbtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
   public String ValidateLoginPageTitle()
   {
	   return driver.getTitle();
   }
   
   public HomePage login(String uname,String pwd)
   {
	   SignInbtn.click();
	   UserName.sendKeys(uname);
	   Cntbtn.click();
	   Password.sendKeys(pwd);
	   Singinsubmitbtn.click();
	   return new HomePage();
   }
}
