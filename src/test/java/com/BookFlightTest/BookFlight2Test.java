package com.BookFlightTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.BookFlight.BookFlight2;
import com.commonTest.TestBase;

public class BookFlight2Test extends TestBase {

	//test Book flight
	@Test
	public void BookFlightTest2way() throws IOException {

		BookFlight2 bkFlight = new BookFlight2(getDriver1());
		bkFlight.navigateToSite("testSitemakemystripName");
		bkFlight.Bookticket("Hyderabad", "New Delhi");

	}

}
