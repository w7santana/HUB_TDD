package br.com.rsinet.HUB_TDD.utility;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	@Test
	public static void loginTest() throws IOException {
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(".\\Reports\\testandoReport.html");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		ExtentTest logger = extent.createTest("LoginTest");
		
		logger.log(Status.INFO, "Login to amazon");
		
		logger.log(Status.PASS, "Title verified");
		   
        // Flush method will write the test in report- This is mandatory step  
    extent.flush();
	
        // You can call createTest method multiple times depends on your requirement
        // In our case we are calling twice which will add 2 testcases in our report
    ExtentTest logger2=extent.createTest("Logoff Test");
    
    logger2.log(Status.FAIL, "Title verified");
    
    logger2.fail("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath(".\\Evidencias\\logo.jpg").build());
    
    logger2.pass("Failed because of some issues", MediaEntityBuilder.createScreenCaptureFromPath(".\\Evidencias\\logo.jpg").build());

        // This will add another test in report
    extent.flush();
		
	}

}
