package com.FileUploadDemo;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.common.Page;

public class FileUploadAutoIT extends Page {

	public FileUploadAutoIT(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String upLoadFileAutoIT() throws AWTException, IOException {

		// Specify the file location with extension

		// Open Monster.com
		driver.get("http://my.monsterindia.com/create_account.html");

		sleep(2000);

		// This will click on Browse button
		driver.findElement(By.id("wordresume")).click();

		System.out.println("Browse button clicked");

		sleep(1000);

		Runtime.getRuntime().exec("C:\\Resumes\\AutoITScript.exe");

		sleep(2000);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		String strFileupload = js1.executeScript("return document.getElementById('wordresume').value;").toString();
		System.out.println(strFileupload);

		return strFileupload;

	}

}
