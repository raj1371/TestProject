package com.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	public static Properties CONFIG = null;
	public static Properties OR = null;

	public static final long SLEEP = 500;
	public static final long DEFAULT_TIMEOUT = 30000;

	public WebDriver driver;

	private WebDriverWait wait;

	public Page(WebDriver driver) {

		this.driver = driver;

		Initializeprop();

	}

	public void Initializeprop() {
		try {
			CONFIG = new Properties();

			FileInputStream fn = new FileInputStream(System.getProperty("user.dir") + "//TestData//Config.properties");
			CONFIG.load(fn);

			OR = new Properties();
			fn = new FileInputStream(System.getProperty("user.dir") + "//TestData//OR.properties");
			OR.load(fn);

		} catch (Exception ex) {
		}

	}

	public void navigateURL() {
		driver.navigate().to(CONFIG.getProperty("testSiteName"));
	}

	public void navigateURL(String testSiteName) {
		driver.navigate().to(CONFIG.getProperty(testSiteName));
	}

	public WebElement findElement(By by) {

		long timeout = 20000;

		WebElement element = null;
		RuntimeException lastException = null;
		for (int i = 0; i < timeout / SLEEP; i++) {
			try {

				return driver.findElement(by);
			} catch (org.openqa.selenium.NoSuchElementException e) {
				lastException = e;
				sleep(SLEEP);
			}
		}

		return element;

	}

	public void sleep(long SLEEP) {
		try {
			Thread.sleep(SLEEP);
		} catch (InterruptedException e) {

		}
	}

	public void SetValue(WebElement element, String IDkey2) {

		if (element != null)

			// element.sendKeys(OR.getProperty(IDkey2));
			element.sendKeys(IDkey2);

	}

	public String GetValue(WebElement element) {

		if (element != null)

			return element.getText();
		else
			return null;
	}

	public <T> T waitUntil(ExpectedCondition<T> condition) {

		return wait.until(condition);
	}

	public void Click(WebElement element) {

		if (element != null)
			element.click();
	}

	public void Close() {
		driver.quit();
	}

	public void selectOptionWithText(WebElement element, String textToSelect) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).doubleClick(element).sendKeys(Keys.chord(Keys.CONTROL, "a"))
					.sendKeys(textToSelect);
			sleep(1000);

			action.sendKeys(Keys.ENTER);

			action.perform();

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void selectDate(String dateXpath, String expDate, int expMonth, int expYear) {

		List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December");

		// Calendar Month and Year
		String calMonth = null;
		String calYear = null;
		boolean dateNotFound;

		// Click on date text box to open date picker popup.
		driver.findElement(By.xpath(dateXpath)).click();
		dateNotFound = true;

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
		sleep(3000);

	}

	public void selectDate(String date) {

		WebElement datePicker = driver.findElement(By.id("ui-datepicker-div"));
		List<WebElement> noOfColumns = datePicker.findElements(By.tagName("td"));

		// Loop will rotate till expected date not found.
		for (WebElement cell : noOfColumns) {
			// Select the date from date picker when condition match.
			if (cell.getText().equals(date)) {
				cell.findElement(By.linkText(date)).click();
				break;
			}
		}
	}

	// Switch Frame by Name or ID

	public void SwitchFrame(String iFrame) {

		driver.switchTo().frame(iFrame);
	}

	// Switch Frame by index

	public void SwitchFrame(int index) {

		driver.switchTo().frame(index);
	}

	// Switch Frame by WebElement

	public void SwitchFrame(WebElement element) {

		driver.switchTo().frame(element);
	}

	public void SwitchFrameToDefault() {
		driver.switchTo().defaultContent();
	}

	public void SwitchtoNewTab(String tab) {
		driver.switchTo().window(tab);

	}
}
