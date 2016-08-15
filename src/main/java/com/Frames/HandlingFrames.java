package com.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.common.Page;

public class HandlingFrames extends Page {

	public String fName;
	public String lName;

	public HandlingFrames(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public HandlingFrames(WebDriver driver, String fName, String lName) {
		super(driver);
		this.fName = fName;
		this.lName = lName;
	}

	public void naviGateURL() {
		navigateURL();
	}

	public void HandleFirstFrame() {

		SwitchFrame(OR.getProperty("iFrame1"));
		SetFrame1Fields(fName, lName);
		sleep(2000);

	}

	public void HandleSeconFrame() {
		
		String str=OR.getProperty("iFrame2");
		
		System.out.println(OR.getProperty("iFrame2"));
		SwitchFrame(OR.getProperty("iFrame2"));
		SetFrame2Fields();
	}

	public void setBackFrame() {
		
		SwitchFrameToDefault();

	}

	public void SetFrame1Fields(String fName, String lfName) {

		SetValue(findElement(By.name(OR.getProperty("fName"))), fName);
		SetValue(findElement(By.name(OR.getProperty("lName"))), lfName);

	}

	public void SetFrame2Fields() {
		Click(findElement(By.xpath(OR.getProperty("tab1"))));
	}

}
