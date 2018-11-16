package testScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageLibrary.FlightBookingPage;
import testBase.TestBase;

public class FlightBookingTestCase extends TestBase {
	
	FlightBookingPage flightBookingPage;
	
	@BeforeTest
	public void setUpPage(){
	flightBookingPage = new FlightBookingPage(driver);
	}
	
	@Test
	public void testSearchFlight(){
		flightBookingPage.selectOneWayRadioButton();
		flightBookingPage.enterFromCityName("Bangalore");
		flightBookingPage.enterToCityName("Delhi");
		flightBookingPage.selectCalendarDate();
		flightBookingPage.clickOnSearchButton();
		waitForElement(driver, 20, flightBookingPage.flightDealsLink);
		Assert.assertEquals(flightBookingPage.flightDealsLink.getText(), "Flights Deal: Get instant cashback upto Rs 3,000. Use coupon: TRVLHPY");
	}
}
