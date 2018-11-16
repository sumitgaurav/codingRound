package testScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageLibrary.HotelBookingPage;
import testBase.TestBase;

public class HotelBookingTestCase extends TestBase {

	HotelBookingPage hotelBookingPage;
	
	@BeforeTest
	public void setUp(){
		hotelBookingPage = new HotelBookingPage(driver);
	}
	
	@Test
	public void testSearchHotels() throws InterruptedException{
		hotelBookingPage.clickOnHotelsTab();
		waitForElement(driver, 20,hotelBookingPage.localityTextBox);
		hotelBookingPage.enterLocalityAndCityName("Indiranagar, Bangalore");
		hotelBookingPage.enterCheckInDate();
		hotelBookingPage.enterCheckOutDate();
		hotelBookingPage.selectTravellers("1 room, 2 adults");
		hotelBookingPage.clickOnSearchButton();
		waitForElement(driver, 20, hotelBookingPage.searchTextBox);
		Assert.assertEquals(hotelBookingPage.searchTextBox.getAttribute("placeholder"), "Search for location, hotel or address in Bangalore");
	}
}
