package com.amz.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTextBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rjaiswar\\Desktop\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Cucumber");;
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		List<WebElement> listofsearch=driver.findElements(By.xpath("//li//div//div//div[@class='aypzV']//span"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(WebElement elemnt:listofsearch)
		{
			String text=elemnt.getText();
			System.out.println(text);
			if(text.equalsIgnoreCase("cucumber testing"))
			{
				elemnt.click();
				break;
			}
		}
		System.out.println("Execution is done");
		
	}

}
