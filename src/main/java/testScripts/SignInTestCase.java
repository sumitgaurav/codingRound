package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageLibrary.SignInPage;
import testBase.TestBase;

/**
 * @author Sumit Kumar Sharma
 * @created 20-Nov-2018
 * This java class contains the Test case for Sign In and validating the error message.
 */

public class SignInTestCase extends TestBase {
	
	SignInPage signInPage;
	private String frameName = "modal_window";
	private String errorMsg= "There were errors in your submission";
	
	
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
		signInPage = new SignInPage(driver);
	}
	
	@Test
	public void testSignInError(){
		signInPage.clickOnSignInButtonPresentUnderYourTrips();
		switchToFrame(frameName);
		signInPage.clickOnSignInBtnInLoginWindow();		
		String error = signInPage.getError();
		Assert.assertTrue(error.contains(errorMsg));
	}

	/**
	 * This method is used to close the browser after test complete.
	 */
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
