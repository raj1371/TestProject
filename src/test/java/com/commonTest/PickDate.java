package com.commonTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.BookFlight.BookFlight2;

public class PickDate extends TestBase {

	WebDriver driver;
	WebElement datePicker;
	List<WebElement> noOfColumns;
	List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December");
	// Expected Date, Month and Year
	int expMonth;
	int expYear;
	String expDate = null;
	// Calendar Month and Year
	String calMonth = null;
	String calYear = null;
	boolean dateNotFound;

	@Test
	public void pickExpDate() throws InterruptedException, IOException {
		driver = getDriver1();
		BookFlight2 bkFlight = new BookFlight2(driver);
		bkFlight.navigateToSite("testSiteNameMakemytrip");
		bkFlight.Bookticket("Hyderabad", "New Delhi");

		// Click on date text box to open date picker popup.
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		dateNotFound = true;

		// Set your expected date, month and year.
		expDate = "18";
		expMonth = 10;
		expYear = 2016;

		// This loop will be executed continuously till dateNotFound Is true.
		while (dateNotFound) {
			// Retrieve current selected month name from date picker popup.
			calMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			// Retrieve current selected year name from date picker popup.
			calYear = driver.findElement(By.className("ui-datepicker-year")).getText();

			// If current selected month and year are same as expected month and
			// year then go Inside this condition.
			if (monthList.indexOf(calMonth) + 1 == expMonth && (expYear == Integer.parseInt(calYear))) {
				// Call selectDate function with date to select and set
				// dateNotFound flag to false.
				selectDate(expDate);
				dateNotFound = false;
			}
			// If current selected month and year are less than expected month
			// and year then go Inside this condition.
			else if (monthList.indexOf(calMonth) + 1 < expMonth && (expYear == Integer.parseInt(calYear))
					|| expYear > Integer.parseInt(calYear)) {
				// Click on next button of date picker.
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			// If current selected month and year are greater than expected
			// month and year then go Inside this condition.
			else if (monthList.indexOf(calMonth) + 1 > expMonth && (expYear == Integer.parseInt(calYear))
					|| expYear < Integer.parseInt(calYear)) {
				// Click on previous button of date picker.
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}
		}
		Thread.sleep(3000);
	}

	public void selectDate(String date) {
		datePicker = driver.findElement(By.id("ui-datepicker-div"));
		noOfColumns = datePicker.findElements(By.tagName("td"));

		// Loop will rotate till expected date not found.
		for (WebElement cell : noOfColumns) {
			// Select the date from date picker when condition match.
			if (cell.getText().equals(date)) {
				cell.findElement(By.linkText(date)).click();
				break;
			}
		}
	}

}
