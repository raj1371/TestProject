package com.commonTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.common.Webdriver;

@Listeners({ com.commonTest.TestNgListner.class })
public class TestBase {

	public static WebDriver driver = null;

	public static WebDriver getDriver1() throws IOException {
		
		if (driver == null)
			driver = Webdriver.getDriver();

		return driver;
	}

	public static void TakeScreenShot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "//screenshots//screenshot.png"));

	}

}
