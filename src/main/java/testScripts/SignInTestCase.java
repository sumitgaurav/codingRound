package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageLibrary.SignInPage;
import testBase.TestBase;
import utils.Constants;

/**
 * @author Sumit Kumar Sharma
 * @created 20-Nov-2018
 */

public class SignInTestCase extends TestBase {
	
	SignInPage signInPage;
	
	/**
	 * This method will call initBrowser method, where Chrome browser instance will 
	 * get created and "URL = https://www.cleartrip.com/" will be launched. This method 
	 * (browser initialization) will be executed before every Test and each test will be 
	 * independent from another test case. For every test a new session will be created.
	 * @throws IOException  
	 */
	@BeforeTest
	public void setUp(){
		initBrowser();
		signInPage = new SignInPage(driver);
	}
	
	// This test method will verify the error message, If user try to click on Sign In button without entering the username and password.
	@Test
	public void testSignInError(){
		signInPage.clickOnSignInButtonPresentUnderYourTrips();
		switchToFrame(Constants.FRAME_NAME);
		signInPage.clickOnSignInBtnInLoginWindow();		
		String error = signInPage.getError();
		Assert.assertTrue(error.contains(Constants.ERROR_MSG));
	}

	
	// This method is used to close the browser after test complete.
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
