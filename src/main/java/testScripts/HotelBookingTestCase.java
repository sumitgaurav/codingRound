package testScripts;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageLibrary.HotelBookingPage;
import testBase.TestBase;

/**
 * @author Sumit Kumar Sharma
 * @created 20-Nov-2018
 * This java class contains the Test case for Hotel booking and validating user successful navigated to search result screen.
 */

public class HotelBookingTestCase extends TestBase {

	HotelBookingPage hotelBookingPage;
	
	
	
	private String cityName= "Indiranagar, Bangalore";
	private int checkInDate = 17;
	private int checkOutDate = 18;
	private String traveller = "1 room, 2 adults";
	private String placeHolderText= "Search for location, hotel or address in Bangalore";
	
	/**
	 * This method will call initBrowser method, where Chrome browser instance will 
	 * get created and "URL = https://www.cleartrip.com/" will be launched. This method 
	 * (browser initialization) will be executed before every Test and each test will be 
	 * independent from another test case. For every test a new session will be created.
	 * @throws IOException 
	 *  
	 */
	@BeforeTest
	public void setUp() throws IOException{
		initBrowser();
		hotelBookingPage = new HotelBookingPage(driver);
	}
	
	@Test
	public void testSearchHotels() throws InterruptedException{
		hotelBookingPage.clickOnHotelsTab();
		waitForElement(driver, 20,hotelBookingPage.localityTextBox);
		hotelBookingPage.enterLocalityAndCityName(cityName);
		hotelBookingPage.selectDay(checkInDate);
		hotelBookingPage.selectDay(checkOutDate);
		hotelBookingPage.selectTravellers(traveller);
		hotelBookingPage.clickOnSearchButton();
		waitForElement(driver, 20, hotelBookingPage.searchTextBox);
		Assert.assertEquals(hotelBookingPage.searchTextBox.getAttribute("placeholder"), placeHolderText);
	}
	
	/**
	 * This method is used to close the browser after test complete.
	 */
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
