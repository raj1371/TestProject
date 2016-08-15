package com.commonTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.common.Stopwatch;
import com.common.Webdriver;

;

public class TestNgListner implements ITestListener {

	private Stopwatch stopwatch = new Stopwatch();
	public static WebDriver driver = null;

	public void onTestStart(ITestResult result) {

		 if (driver != null) {
		 TestBase.driver = null;
		 Webdriver.driver = null;
		 }

		Webdriver.killWebDriversAndRelatedBrowsers();

	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("Test sucess Event");
		try {
			driver = TestBase.getDriver1();
			// driver.quit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
