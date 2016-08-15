package com.FileUploadDemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.common.Page;

public class FileUpload extends Page {

	WebDriver driver = null;

	public FileUpload(WebDriver driver) {
		super(driver);

		this.driver = driver;

	}

	public String upLoadFile() throws AWTException {

		// Specify the file location with extension
		StringSelection fileTobeUploaded = new StringSelection("C:\\Resumes\\Automation\\Rajes_New.docx");

		// copy to clip board
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileTobeUploaded, null);
		System.out.println("selection" + fileTobeUploaded);

		// Open Monster.com
		driver.get("http://my.monsterindia.com/create_account.html");

		sleep(2000);

		// This will scroll down the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,350)");

		sleep(5000);

		// This will click on Browse button
		driver.findElement(By.id("wordresume")).click();

		System.out.println("Browse button clicked");

		sleep(1000);

		// Create object of Robot class
		Robot robot = new Robot();
		sleep(1000);

		// Press Enter



		robot.keyPress(KeyEvent.VK_ENTER);

		// Release Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Press CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Release CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyRelease(KeyEvent.VK_V);
		sleep(1000);

		// Press Enter 
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		sleep(2000);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		String strFileupload = js1.executeScript("return document.getElementById('wordresume').value;").toString();
		System.out.println(strFileupload);
		
		return strFileupload;

	}
}
