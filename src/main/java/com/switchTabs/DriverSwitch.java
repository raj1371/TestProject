package com.switchTabs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.common.Page;

public class DriverSwitch extends Page {

	public static String oldTabTitle = null;
	public static String newTabTitle = null;

   WebDriver driver = null;

	public DriverSwitch(WebDriver driver) {
		super(driver);

   	this.driver = driver;

	}

	public void naviGateURL(String testSiteNameDriverSwitch) {
		navigateURL(testSiteNameDriverSwitch);

	}

	public String redirectToNewTab() {

		// considering that there is only one tab opened in that point.
		String oldTab = driver.getWindowHandle();
		
		System.out.println("Parent windo Handle::"+oldTab);
		Click(findElement(By.xpath("//span[text()='Try Twitter Ads']")));
		sleep(2000);
		List<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		
		for(int i=0; i<newTab.size();i++){
			
			System.out.println("Window Handle"+i+"::"+newTab.get(i));
			
		}
		
		
		newTab.remove(oldTab);
		// change focus to new tab
		SwitchtoNewTab(newTab.get(0));
		// Do what you want here, you are in the new tab

		newTabTitle = driver.getTitle();

		System.out.println("Title of new tab::" + newTabTitle);

		sleep(2000);

		// driver.close();
		// change focus back to old tab
		return oldTab;
	}

	public void redirectToOldTab(String tab) {
		SwitchtoNewTab(tab);

		oldTabTitle = driver.getTitle();
		System.out.println("Title of new tab::" + oldTabTitle);

	}

}
