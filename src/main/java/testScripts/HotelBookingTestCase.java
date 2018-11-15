package testScripts;

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
		hotelBookingPage.selectDate("16");
		waitFor(10);
		hotelBookingPage.enterCheckOutDate("17");
		hotelBookingPage.selectTravellers("1 room, 2 adults");
		waitFor(10);
		hotelBookingPage.clickOnSearchButton();
		
	}
}
//td[not(contains(@class,'ui-datepicker-unselectable'))]/a[text()='1']