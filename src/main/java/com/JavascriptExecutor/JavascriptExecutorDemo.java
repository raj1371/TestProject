package com.JavascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.common.Page;

public class JavascriptExecutorDemo extends Page {

	WebDriver driver = null;
	JavascriptExecutor js = null;

	public JavascriptExecutorDemo(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void navigateToGmail(String testSiteName) {

		navigateURL(testSiteName);

	}

	public void gmailLogin() {
		
		
		
		js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('Email').value='thirumalasetti.rajesh24'");

		js.executeScript("document.getElementById('next').click()");
		sleep(1000);

		js.executeScript("document.getElementById('Passwd').value='newuser_123'");
		js.executeScript("document.getElementById('signIn').click()");

		sleep(4000);

	}

	public void Scrollbar(int horizantal, int vertical) {

		sleep(2000);
		js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1000);");

		System.out.println("Scroll bar is excuted::");
		sleep(4000);
	}

	// Create Alert PopUP
	public void createAlertpopUP() {
		js = (JavascriptExecutor) driver;
		js.executeScript("alert('hello world');");
	}

	// Create Refresh Browser
	public void refreshBrowser() {
		js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	// Get Title
	public String getTitle() {
		String sText = null;
		js = (JavascriptExecutor) driver;
		sText = js.executeScript("return document.title;").toString();

		return sText;
	}

	public void naviGatetoNewPage() {
		js = (JavascriptExecutor) driver;
		// Navigate to new Page
		js.executeScript("window.location = 'https://www.facebook.com/uftHelp'");
	}
}
