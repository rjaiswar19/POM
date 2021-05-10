package com.amz.qa.report;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/*import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;*/

public class ExtentReporterNG{
	public static  ExtentReports extend;
	public static  ExtentHtmlReporter htmlReporter;
	public static  ExtentTest test;
	

	public static void setExtend()
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/target/"+"extend"+System.currentTimeMillis()+"report.HTML");
		htmlReporter.config().setDocumentTitle("Extent report by rama");
		htmlReporter.config().setReportName("amazon login page report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extend=new ExtentReports();
		extend.attachReporter(htmlReporter);
		
		extend.setSystemInfo("HostName", "MyName");
		extend.setSystemInfo("ProjectName", "AmazonProject");
		extend.setSystemInfo("Tester", "Rama");
		extend.setSystemInfo("OS","Window");
		extend.setSystemInfo("Browser Name", "Chrome");
		
		
	}
	
	
	
	public static void endReport()
	{
		extend.flush();
	}
	/*public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		extend=new ExtentReports(outputDirectory+File.separator+"Extent.html",true);

		for(ISuite suite:suites)
		{
			Map<String,ISuiteResult> results=suite.getResults();
			for(ISuiteResult result:results.values())
			{
                ITestContext context=result.getTestContext();
                
                buildTestNodes(context.getPassedTests(),LogStatus.PASS);
                buildTestNodes(context.getFailedTests(),LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(),LogStatus.SKIP);
                
			}
		}
	extend.flush();
	extend.close();
	}
*/

	/*private void buildTestNodes(IResultMap tests, LogStatus status) {
		// TODO Auto-generated method stub
		ExtentTest test;
		if(tests.size()>0)
		{
			for(ITestResult result:tests.getAllResults())
			{
				test=extend.startTest(result.getMethod().getMethodName());
				
				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));
				for(String group:result.getMethod().getGroups())
					test.assignCategory(group);
				if(result.getThrowable() != null)
				{
					test.log(status, result.getThrowable());
				}
				else
				{
					test.log(status, "Test" +status.toString().toLowerCase() +"ed");
				}
					
				extend.endTest(test);
			}
		}
		
	}
*/
	private Date getTime(long Millis) {
		// TODO Auto-generated method stub
		Calendar calender=Calendar.getInstance();
		calender.setTimeInMillis(Millis);
		return calender.getTime();
	}



	

}
