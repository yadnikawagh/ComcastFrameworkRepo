package com.crm.Listeners;

import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.TeamLeaseRegtechBaseClass;


public class ListenerWithScreenshot extends TeamLeaseRegtechBaseClass implements ITestListener {

	public static ExtentSparkReporter spark =null;
	public static ExtentReports report=null;
	public static ExtentTest test;

	public void onTestStart(ITestResult result) {
		Reporter.log("onTestStart",true);
		String name = result.getMethod().getMethodName();
		test=report.createTest(name);
	}

	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.PASS,name+"is success");
		Reporter.log("onTestSuccess",true);
	}

	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.FAIL,name+"is Fail");
		LocalDateTime date = LocalDateTime.now();
		String time = date.toString().replace(":", "-");
		TakesScreenshot ts = (TakesScreenshot) driver;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
		Reporter.log("onTestFailure",true);
	}

	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.SKIP,name+"is skip");
		Reporter.log("onTestSkipped",true);
	}

	public void onStart(ITestContext context) {
		Reporter.log("OnStart",true);
		spark = new ExtentSparkReporter(".\\src\\test\\resources\\Screenshot\\ScriptReportListeners.html");
		spark.config().setDocumentTitle("TestNg Using Listeners");
		spark.config().setReportName("");
		spark.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.setSystemInfo("Browser", "Chrome-111");
		report.setSystemInfo("OS", "Windows-11");
		report.attachReporter(spark);
	}

	public void onFinish(ITestContext context) {
		Reporter.log("onFinish",true);
		//Flush
		report.flush();
	}
	

	
}
