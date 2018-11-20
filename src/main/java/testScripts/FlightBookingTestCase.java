package testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageLibrary.FlightBookingPage;
import testBase.TestBase;

/**
 * @author Sumit Kumar Sharma
 * @created 20-Nov-2018
 * This java class contains the Test case for Flight booking and validating user successful navigated to search result screen.
 */

public class FlightBookingTestCase extends TestBase {
	
	FlightBookingPage flightBookingPage;
	private String fromCityName = "Bangalore";
	private String toCityName = "Delhi";
	private int day= 21;
	private String placeHolderText= "Flights Deal: Get instant cashback upto Rs 3,000. Use coupon: TRVLHPY";
	
	/**
	 * This method will call initBrowser method, where Chrome browser instance will 
	 * get created and "URL = https://www.cleartrip.com/" will be launched. This method 
	 * (browser initialization) will be executed before every Test and each test will be 
	 * independent from another test case. For every test a new session will be created.
	 *  
	 */
	@BeforeTest
	public void setUp(){
		initBrowser();
		flightBookingPage = new FlightBookingPage(driver);
	}
	
	@Test
	public void testSearchFlight(){
		flightBookingPage.selectOneWayRadioButton();
		flightBookingPage.enterFromCityName(fromCityName,0);
		flightBookingPage.enterToCityName(toCityName,0);
		flightBookingPage.selectDay(day);
		flightBookingPage.clickOnSearchButton();
		waitForElement(driver, 20, flightBookingPage.flightDealsLink);
		Assert.assertEquals(flightBookingPage.flightDealsLink.getText(),placeHolderText);
	}
	
	/**
	 * This method is used to close the browser after test complete.
	 */
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
