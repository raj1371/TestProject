package com.FileDownloadDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileDownloadDemo {

	WebDriver driver = null;

	public FileDownloadDemo() {
		driver = new FirefoxDriver();

	}

	public void DownloadJava() {

		driver.get("https://www.google.co.in");

	}

}
