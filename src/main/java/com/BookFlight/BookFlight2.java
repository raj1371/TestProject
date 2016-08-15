package com.BookFlight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.common.Page;

public class BookFlight2 extends Page {

	public BookFlight2(WebDriver driver) {
		super(driver);

	}

	public void navigateToSite(String siteName) {
		navigateURL(siteName);
	}

	public void Bookticket(String fromCity, String toCity) {

		String strFlight = OR.getProperty("Flights");
		System.out.println(strFlight);

		Click(findElement(By.xpath(OR.getProperty("Flights"))));

		selectOptionWithText(
				findElement(By.id(OR.getProperty("txt_city_From"))), fromCity);
		selectOptionWithText(findElement(By.id(OR.getProperty("txt_city_To"))),
				toCity);

		selectDate(OR.getProperty("departureDate"), "18", 10, 2016);

		selectDate(OR.getProperty("returnDate"), "20", 12, 2016);
		
		Click(findElement(By.id(OR.getProperty("searchFlights"))));
		
		

	}

}
