package utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
public static ExtentReports extent;//Static ExtentReports Object
public static ExtentReports getReportInstance()//Method Declaration
{
	if(extent==null)
	{
		ExtentSparkReporter spark=new ExtentSparkReporter("target/ExtentReport.html");//Create Spark Reporter
		//ThreadLocal<ExtentTest> test = new ThreadLocal<>();
		
		spark.config().setReportName("Automation test Result");//Set Report Name
		spark.config().setDocumentTitle("Text Execution report");//Set Document Title
		 extent =new ExtentReports();//Create ExtentReports Object
		 extent.attachReporter(spark);//Attach Reporter
		 extent.setSystemInfo("Tester", "Vijaya");//Add System Info
		 extent.setSystemInfo("Environment", "QA");//Add System Info
		 
		}
	return extent;//Return Statement
}

	
}
