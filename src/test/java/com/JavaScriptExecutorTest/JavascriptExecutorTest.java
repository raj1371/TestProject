package com.JavaScriptExecutorTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.JavascriptExecutor.JavascriptExecutorDemo;
import com.commonTest.TestBase;

public class JavascriptExecutorTest extends TestBase {

	@Test
	public void TestGmailLogin() throws IOException {

		JavascriptExecutorDemo jsE = new JavascriptExecutorDemo(getDriver1());
		jsE.navigateToGmail("testSiteGmailName");
		jsE.gmailLogin();

		String strTitle = jsE.getTitle();
		System.out.println("Title was::" + strTitle);

		jsE.refreshBrowser();
		jsE.createAlertpopUP();

	}

	@Test
	public void TestScrollBar() throws IOException {

		JavascriptExecutorDemo jsE = new JavascriptExecutorDemo(getDriver1());
		jsE.navigateToGmail("testSiteScrollBarName");
		jsE.Scrollbar(0, 200);

	}

}
