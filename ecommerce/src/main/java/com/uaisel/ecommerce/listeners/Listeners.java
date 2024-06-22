package com.uaisel.ecommerce.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.uaisle.ecommerce.basepage.BasePage;

public class Listeners extends BasePage implements ITestListener {

	public void onTestStart(ITestResult arg0) {
		Reporter.log("Test Start Running :" + arg0.getMethod().getMethodName());

	}

	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test is skipped :" + arg0.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult arg0) {
		Reporter.log("Test Successful :" + arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		String methodname = arg0.getName();
		if (arg0.isSuccess()) {
			File srcpath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String reportDirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/sec/main/java/com/uaisel/ecommerce");
			File targetPath = new File((String) reportDirectory + "/passedscreens/" + methodname
					+ simpleDate.format(cal.getTime() + ".png"));
			try {
				FileUtils.copyFile(srcpath, targetPath);
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void onTestFailure(ITestResult arg0) {

	}

}
