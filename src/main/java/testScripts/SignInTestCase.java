package testScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageLibrary.SignInPage;
import testBase.TestBase;

public class SignInTestCase extends TestBase {
	
	SignInPage signInPage;
	
	@BeforeTest
	public void setUpPage(){
	signInPage = new SignInPage(driver);
	}
	
	@Test
	public void testSignInError(){
		signInPage.clickOnSignInButtonPresentUnderYourTrips();
		driver.switchTo().frame("modal_window");
		signInPage.clickOnSignInBtnInLoginWindow();		
		String error = signInPage.getError();
		Assert.assertTrue(error.contains("There were errors in your submission"));
	}
}
