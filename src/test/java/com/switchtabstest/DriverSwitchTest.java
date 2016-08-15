package com.switchtabstest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.commonTest.TestBase;
import com.switchTabs.DriverSwitch;

public class DriverSwitchTest extends TestBase {

	@Test
	public void testTabs() throws IOException {

		DriverSwitch dSwitch = new DriverSwitch(getDriver1());

		dSwitch.naviGateURL("testSiteNameDriverSwitch");

		String oldTab = dSwitch.redirectToNewTab();

		Assert.assertEquals(DriverSwitch.newTabTitle.trim(),"Sign in");

		dSwitch.redirectToOldTab(oldTab);

		Assert.assertEquals(DriverSwitch.oldTabTitle.trim(),"Advertising on Twitter");

	}
	
	@Test
	public void LoginTest(){
		//login
		
	}
	
	@Test
	public void HomePage(){
		
		//login
		//homepage display
	}
	
	@Test
	public void Quotationcrate(){
		//login
		//Homepage
		//Quotation create 
		
	}
	
	@Test
	public void Quotationlistdisplay(){
		//login
		//Homepage
		//Quotation List
		
	}

}
