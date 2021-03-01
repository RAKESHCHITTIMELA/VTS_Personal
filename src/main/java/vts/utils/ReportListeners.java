package vts.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import vts.mail.*;

import com.aventstack.extentreports.Status;

import vts.basetest.TestBase;

public class ReportListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		// before each test case
		test = extent.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test Case: " + result.getMethod().getMethodName() + " is Passed.");
	}

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, "Test Case: " + result.getMethod().getMethodName() + " is Failed.");
		test.log(Status.FAIL, result.getThrowable());

		// add screenshot for failed testcase

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
		Date date = new Date();
		String actualdate = format.format(date);
		String screenshotpath = System.getProperty("user.dir") + "\\src\\main\\java\\vts\\reports\\ " + actualdate
				+ ".jpeg";
		File dest = new File(screenshotpath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			test.addScreenCaptureFromPath(screenshotpath, "Test Case failure screenshot");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Case: " + result.getMethod().getMethodName() + "is Skipped.");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		// setup method call
		extent = setupExtentReport();

	}

	public void onFinish(ITestContext context) {
		// close extent
		extent.flush();
//		SendMailReport sm = new SendMailReport();
//		try {
//			sm.sendMail();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	
	
	}

}
