package com.uaisle.ecommerce.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {
	public WebDriver driver;

	public static final String path = "./config.properties";

	public String log4jpath = "./log4j.properties";
	public static ExtentReports extent;
	public ExtentTest test;
	public ITestResult result;

	static {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		extent = new ExtentReports(
				System.getProperty("user.dir") + "/src/main/java/com/uaisel/ecommerce/htmlReports/test/"+dateFormat.format(cal.getTime())+".html",false);
	}
	
	@BeforeMethod
	public void startReport(Method result) {
		test=extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+"test is started");
		
	}

	@AfterMethod
	public void endReport(ITestResult result) {
		getResult(result);
	}

	public void getResult(ITestResult result2) {
		if (result2.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result2.getName());
		} else if (result2.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result2.getName() + "Test is skipped and the reason is : " + result2.getThrowable());
		} else if (result2.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL,
					result2.getName() + "Test is failed and the reason is : " + result2.getThrowable());
		}

	}

	public void selectOption(WebElement element, int option) {
		new Select(element).selectByIndex(option);
	}

	public int randomNumber() {
		Random r = new Random();
		int num = r.nextInt(9999);
		return num;
	}

	public String getData(String key) throws Exception {
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fi);

		return p.getProperty(key);
	}

	public void browserlaunch(String browser, String URL) {
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		PropertyConfigurator.configure(log4jpath);

	}
}
