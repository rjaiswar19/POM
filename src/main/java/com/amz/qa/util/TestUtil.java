package com.amz.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.amz.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\rjaiswar\\workspace\\DE\\POM\\src\\main\\java\\com\\amz\\qa\\testdata\\TestData.xlsx";
	
    static Workbook workbook;
    static Sheet sheet;
    static JavascriptExecutor js;
    public void SwitchToFrame()
    {
    	driver.switchTo().frame("mainpanel");
    	
    }
    
    public static String takeScreenshotAtEndOfTest() throws IOException
    {
          File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          String currentdirectory=System.getProperty("user.dir");
          String screenshotdestination=System.getProperty("User.dir")+"\\Screenshot\\amazonTestCaseReport"+System.currentTimeMillis()+".png";
          File filedestination=new File(screenshotdestination);
          FileUtils.copyFile(srcfile,filedestination);
          
          
          return screenshotdestination ;
    }
    
    public static Object[][] getTestData(String sheetName)
    {
    	FileInputStream fim=null;
    	try{
    		fim=new FileInputStream(TESTDATA_SHEET_PATH);
    	}
    	catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	try{
    		workbook=WorkbookFactory.create(fim);
    	}
    	catch(InvalidFormatException e)
    	{
    		e.printStackTrace();
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	sheet=workbook.getSheet(sheetName);
    	Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    	for(int i=0;i<sheet.getLastRowNum();i++)
    	{
    		for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
    		{
    			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
    		}
    	}
    	return data;
    }
}
