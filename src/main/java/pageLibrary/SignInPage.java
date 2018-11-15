package pageLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;


public class SignInPage extends TestBase  {
	static WebDriver driver;
	
	@FindBy(linkText ="Your trips")
	private WebElement yourTrips;
	
	@FindBy(id = "SignIn")
	private WebElement signInBtn;
	
	@FindBy(id = "signInButton")
	private WebElement signInBtn1;
	
	@FindBy(id = "errors1")
	private WebElement error;
	
	
	public SignInPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnSignInButtonPresentUnderYourTrips(){
		yourTrips.click();
		signInBtn.click();
	}
	
	public void clickOnSignInBtnInLoginWindow(){
		signInBtn1.click();
	}
	
	public String getError(){
		return error.getText();
	}
	
	
	
}
