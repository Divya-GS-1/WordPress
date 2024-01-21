package com.WordPress1.Library;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting implements ITestListener{
	
	ExtentReports report;
	 ExtentTest Test_handle;
	public void onStart(ITestContext context) {
		   String Timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) ;
		   String ReportName="./test-output/Automation-Report-"+Timestamp+".html";
		   
		   report =new ExtentReports();
		   ExtentSparkReporter spark= new ExtentSparkReporter(ReportName);
		   spark.config().setDocumentTitle("WP_AutomationTesting");
		   spark.config().setReportName("WordPress");
		   
		   report.attachReporter(spark);
		   report.setSystemInfo("OS",System.getenv("OS"));
		   report.setSystemInfo("Envi", "QA");
		 
	  }
	 public void onTestStart(ITestResult result) {
		 Test_handle=report.createTest(result.getName());
		 Test_handle.log(Status.INFO,"Test "+ result.getName()+ " started");
		   }

	  public void onTestSuccess(ITestResult result) {
		  Test_handle.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ " Test case is PASSED", ExtentColor.GREEN));
	  }

	 
	  public void onTestFailure(ITestResult result) {
		  Test_handle.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ " Test case is FAILED. Refer below error msg", ExtentColor.RED));
		  Test_handle.log(Status.INFO, result.getThrowable().getMessage());
		  String screenshot_path="./Screenshots/"+result.getName()+".png";
		  File file=new File(screenshot_path);
		  System.out.println("Checking screenshot file exists..??"+file.exists());
		  if(file.exists()) {
			  Test_handle.fail(result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(screenshot_path).build());
		  }
	  }

	 
	  public void onTestSkipped(ITestResult result) {
	   
	  }

	  
	  public void onFinish(ITestContext context) {
		  report.flush();
	  }
	
	
	
	
	
}
