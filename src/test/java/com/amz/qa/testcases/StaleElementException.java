package com.amz.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjaiswar\\Desktop\\driver\\chromedriver.exe");		WebDriver driver=new ChromeDriver();
		
		driver.get("https://ui.cogmento.com/");
		WebElement Username=driver.findElement(By.xpath("//input[@name='email']"));
		
		Username.sendKeys("RamashankarJaiswar19@gmail.com");
		
		WebElement Password=driver.findElement(By.xpath("//input[@name='password']"));
		
		Password.sendKeys("Harman@2021");
		
		
		
	}

}
